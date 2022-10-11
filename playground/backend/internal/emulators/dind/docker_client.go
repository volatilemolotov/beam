package dind

import (
	"context"
	"fmt"
	"io"
	"os"

	"github.com/docker/docker/api/types"
	"github.com/docker/docker/api/types/container"
	"github.com/docker/docker/api/types/filters"
	"github.com/docker/docker/client"
	"github.com/docker/go-connections/nat"
)

type DockerClient struct {
	ctx    context.Context
	client *client.Client
}

func NewDockerClient(ctx context.Context) *DockerClient {
	dockerClient, err := client.NewClientWithOpts(client.FromEnv, client.WithAPIVersionNegotiation())
	if err != nil {
		fmt.Println(err.Error())
	}
	return &DockerClient{ctx: ctx, client: dockerClient}
}

func (dc *DockerClient) PullImage(imagePath string) {
	if dc.hasImage(imagePath) {
		return
	}
	out, err := dc.client.ImagePull(dc.ctx, imagePath, types.ImagePullOptions{})
	defer out.Close()
	if err != nil {
		fmt.Println(err.Error())
	}
	io.Copy(os.Stdout, out)
}

func (dc *DockerClient) hasImage(imagePath string) bool {
	filter := filters.NewArgs()
	filter.Add("reference", imagePath)
	images, err := dc.client.ImageList(dc.ctx, types.ImageListOptions{Filters: filter})
	if err != nil {
		return false
	}
	return len(images) > 0
}

func (dc *DockerClient) StartContainer(imagePath, name string, envVars []string, exposedPorts []string) string {
	portSet, portBindings, _ := nat.ParsePortSpecs(exposedPorts)

	hostConfig := &container.HostConfig{
		PortBindings: portBindings,
	}
	config := &container.Config{
		Image:        imagePath,
		Env:          envVars,
		ExposedPorts: portSet,
	}

	cont, err := dc.client.ContainerCreate(dc.ctx, config, hostConfig, nil, nil, name)
	if err != nil {
		fmt.Println(err.Error())
	}

	if err := dc.client.ContainerStart(dc.ctx, cont.ID, types.ContainerStartOptions{}); err != nil {
		fmt.Println(err.Error())
	}

	return cont.ID
}

func (dc *DockerClient) StopAndRemoveContainer(contID string) {
	if err := dc.client.ContainerStop(context.Background(), contID, nil); err != nil {
		fmt.Println(err.Error())
	}
	if err := dc.client.ContainerRemove(context.Background(), contID, types.ContainerRemoveOptions{}); err != nil {
		fmt.Println(err.Error())
	}
}

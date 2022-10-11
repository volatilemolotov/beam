package components

import (
	"fmt"

	"github.com/google/uuid"

	"beam.apache.org/playground/backend/internal/emulators/dind"
	"beam.apache.org/playground/backend/internal/emulators/producer/clients"
)

type DockerComponent struct {
	client *dind.DockerClient
}

func NewDockerComponent(client *dind.DockerClient) *DockerComponent {
	return &DockerComponent{client: client}
}

func (dc *DockerComponent) StartKafkaEmulator(pipelineId uuid.UUID) string {
	kafkaImage := "bitnami/kafka:latest"
	kafkaContainer := fmt.Sprintf("%s_%s", "kafa", pipelineId)
	kafkaEnvs := []string{
		"KAFKA_ENABLE_KRAFT=yes",
		"KAFKA_CFG_PROCESS_ROLES=broker,controller",
		"KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER",
		"KAFKA_CFG_LISTENERS=EXTERNAL://:9092,CONTROLLER://:9093,INTERNAL://0.0.0.0:29092",
		"KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT",
		"KAFKA_CFG_INTER_BROKER_LISTENER_NAME=INTERNAL",
		"KAFKA_CFG_ADVERTISED_LISTENERS=EXTERNAL://localhost:9092,INTERNAL://kafka:29092",
		"KAFKA_CFG_BROKER_ID=1",
		"KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=1@127.0.0.1:9093",
		"ALLOW_PLAINTEXT_LISTENER=yes",
		"KAFKA_KRAFT_CLUSTER_ID=L0ZEQh1yTbGhNNUE7-6wSQ",
		"KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=true",
	}
	dc.client.PullImage(kafkaImage)
	containerId := dc.client.StartContainer(kafkaImage, kafkaContainer, kafkaEnvs, []string{"9092:9092"})

	kafkaProducer := clients.NewKafkaProducer()
	kafkaProducer.ProduceDatasets()
	return containerId
}

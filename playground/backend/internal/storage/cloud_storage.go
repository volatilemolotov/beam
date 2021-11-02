package storage

import (
	pb "beam.apache.org/playground/backend/internal/api/v1"
	"bytes"
	"cloud.google.com/go/storage"
	"context"
	"fmt"
	"github.com/google/uuid"
	"google.golang.org/api/option"
	"io/ioutil"
	"time"
)

const (
	BucketName = "playground-examples"
	BucketPath = "https://storage.googleapis.com/" + BucketName
)

type CloudStorage struct {
	examplesList  *pb.GetListOfExamplesResponse
	examplesUuids map[uuid.UUID]string
}

func NewCloudStorage(examplesList *pb.GetListOfExamplesResponse, examplesUuids map[uuid.UUID]string) *CloudStorage {
	return &CloudStorage{examplesList: examplesList, examplesUuids: examplesUuids}
}

func (cd *CloudStorage) GetExample(exampleUuid uuid.UUID, ctx context.Context) (*pb.GetExampleResponse, error) {
	examplePath, ok := cd.examplesUuids[exampleUuid]
	if ok != true {
		return nil, fmt.Errorf("no example in bucket with uuid %s", exampleUuid.String())
	}

	client, err := storage.NewClient(ctx, option.WithoutAuthentication())
	if err != nil {
		return nil, fmt.Errorf("storage.NewClient: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(ctx, time.Second*10)
	defer cancel()

	bucket := client.Bucket(BucketName)
	rc, err := bucket.Object(examplePath).NewReader(ctx)
	if err != nil {
		return nil, fmt.Errorf("Object(%q).NewReader: %v", examplePath, err)
	}
	defer rc.Close()

	data, err := ioutil.ReadAll(rc)
	if err != nil {
		return nil, fmt.Errorf("ioutil.ReadAll: %v", err)
	}
	var buf bytes.Buffer
	fmt.Fprintf(&buf, "Blob %v downloaded.\n", examplePath)
	fmt.Println(buf.String())
	fmt.Println(string(data))

	//return &pb.GetExampleResponse{Code: string(data)}, nil

	//url := BucketPath + "/" + examplePath
	//fmt.Println("Downloading ", url)
	//
	//resp, err := http.Get(url)
	//if err != nil {
	//	return nil, err
	//}
	//defer resp.Body.Close()
	//
	//data, err := ioutil.ReadAll(resp.Body)
	//if err != nil {
	//	return nil, fmt.Errorf("ioutil.ReadAll: %v", err)
	//}
	//fmt.Println(string(data))

	return nil, nil
}

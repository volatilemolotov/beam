package storage

import (
	pb "beam.apache.org/playground/backend/internal/api/v1"
	"cloud.google.com/go/storage"
	"context"
	"encoding/json"
	"fmt"
	"google.golang.org/api/iterator"
	"google.golang.org/api/option"
	"io/ioutil"
	"path/filepath"
	"strings"
	"time"
)

const (
	BucketName      = "playground-examples"
	OutputExtension = "output"
	MetaInfoName    = "meta.info"
)

type CloudStorage struct {
}

func NewCloudStorage() *CloudStorage {
	return &CloudStorage{}
}

type ExampleInfo struct {
	Name        string
	CsPath      string
	Description string `json:"Description"`
	Type        string `json:"Type"`
}

type ExampleInfoArr []ExampleInfo
type SdkCategories map[string]ExampleInfoArr
type Examples map[string]SdkCategories

// GetExample returns the source code of the example
func (cd *CloudStorage) GetExample(ctx context.Context, examplePath string) (*string, error) {
	extension := getFileExtensionBySdk(examplePath)
	data, err := cd.getFileFromStorage(ctx, examplePath, extension)
	if err != nil {
		return nil, err
	}
	result := string(data)
	return &result, nil
}

// GetExampleOutput returns the run output of the example
func (cd *CloudStorage) GetExampleOutput(ctx context.Context, examplePath string) (*string, error) {
	data, err := cd.getFileFromStorage(ctx, examplePath, OutputExtension)
	if err != nil {
		return nil, err
	}
	result := string(data)
	return &result, nil
}

// GetListOfExamples returns the list of stored example at cloud storage bucket
func (cd *CloudStorage) GetListOfExamples(ctx context.Context, sdk string, category string) (*Examples, error) {
	client, err := storage.NewClient(ctx, option.WithoutAuthentication())
	if err != nil {
		return nil, fmt.Errorf("storage.NewClient: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(ctx, time.Second*10)
	defer cancel()

	bucket := client.Bucket(BucketName)
	if sdk == "SDK_UNSPECIFIED" {
		sdk = ""
	}
	examples := make(Examples, 0)
	it := bucket.Objects(ctx, &storage.Query{
		Prefix: filepath.Join(sdk, category),
	})
	for {
		attrs, err := it.Next()
		if err == iterator.Done {
			break
		}
		if err != nil {
			return nil, fmt.Errorf("Bucket(%q).Objects: %v", BucketName, err)
		}
		path := attrs.Name
		if strings.Count(path, "/") == 3 && path[len(path)-1] == '/' {
			infoPath := filepath.Join(path, MetaInfoName)
			rc, err := bucket.Object(infoPath).NewReader(ctx)
			if err != nil {
				return nil, fmt.Errorf("Object(%q).NewReader: %v", infoPath, err)
			}
			data, err := ioutil.ReadAll(rc)
			if err != nil {
				return nil, fmt.Errorf("ioutil.ReadAll: %v", err)
			}
			exampleInfo := ExampleInfo{}
			err = json.Unmarshal(data, &exampleInfo)
			if err != nil {
				return nil, fmt.Errorf("json.Unmarshal: %v", err)
			}
			exampleInfo.CsPath = path
			exampleInfo.Name = filepath.Base(path)
			cd.setExampleToMap(path, &examples, &exampleInfo)
		}
	}
	return &examples, nil
}

func (cd *CloudStorage) setExampleToMap(path string, examples *Examples, exampleInfo *ExampleInfo) {
	splittedPath := strings.Split(path, "/")
	sdk := splittedPath[0]
	category := splittedPath[1]
	catMap, ok := (*examples)[sdk]
	if !ok {
		(*examples)[sdk] = make(SdkCategories, 0)
		catMap = (*examples)[sdk]
	}
	exampleArr, ok := catMap[category]
	if !ok {
		catMap[category] = make(ExampleInfoArr, 0)
		exampleArr = catMap[category]
	}
	exampleArr = append(exampleArr, *exampleInfo)
	catMap[category] = exampleArr
}

func (cd *CloudStorage) getFileFromStorage(ctx context.Context, examplePath string, extension string) ([]byte, error) {
	client, err := storage.NewClient(ctx, option.WithoutAuthentication())
	if err != nil {
		return nil, fmt.Errorf("storage.NewClient: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(ctx, time.Second*10)
	defer cancel()

	bucket := client.Bucket(BucketName)

	filePath := getFullFilePath(examplePath, extension)
	rc, err := bucket.Object(filePath).NewReader(ctx)
	if err != nil {
		return nil, fmt.Errorf("Object(%q).NewReader: %v", filePath, err)
	}
	defer rc.Close()

	data, err := ioutil.ReadAll(rc)
	if err != nil {
		return nil, fmt.Errorf("ioutil.ReadAll: %v", err)
	}
	return data, nil
}

func getFullFilePath(examplePath string, extension string) string {
	exampleName := filepath.Base(examplePath)
	fileName := strings.Join([]string{exampleName, extension}, ".")
	filePath := filepath.Join(examplePath, fileName)
	return filePath
}

func getFileExtensionBySdk(examplePath string) string {
	sdk := strings.Split(examplePath, "/")[0]
	var extension string
	switch sdk {
	case pb.Sdk_SDK_JAVA.String():
		extension = "java"
	case pb.Sdk_SDK_PYTHON.String():
		extension = "py"
	case pb.Sdk_SDK_GO.String():
		extension = "go"
	case pb.Sdk_SDK_SCIO.String():
		extension = "scala"
	}
	return extension
}

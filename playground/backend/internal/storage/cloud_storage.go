// Licensed to the Apache Software Foundation (ASF) under one or more
// contributor license agreements.  See the NOTICE file distributed with
// this work for additional information regarding copyright ownership.
// The ASF licenses this file to You under the Apache License, Version 2.0
// (the "License"); you may not use this file except in compliance with
// the License.  You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package storage

import (
	pb "beam.apache.org/playground/backend/internal/api/v1"
	"beam.apache.org/playground/backend/internal/logger"
	"cloud.google.com/go/storage"
	"context"
	"encoding/json"
	"fmt"
	"google.golang.org/api/iterator"
	"google.golang.org/api/option"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"
	"time"
)

const (
	BucketName      = "playground-examples"
	OutputExtension = "output"
	MetaInfoName    = "meta.info"
	Timeout         = 10
	javaExtension   = "java"
	goExtension     = "go"
	pyExtension     = "py"
	scioExtension   = "scala"
)

type ExamplesInfo []pb.Example
type SdkCategories map[string]ExamplesInfo
type Examples map[string]SdkCategories

// CloudStorage represents working tools for getting compiled and
// run beam examples from Google Cloud Storage. It is required that
// the bucket where examples are stored would be public,
// and it has a concrete structure of directories, namely:
// /SDK_JAVA
// ---- /Category1
// --------/Example1
// --------/Example2
// ----  ...
// /SDK_GO
// ---- /Category2
// --------/Example1
// --------/Example2
// ----  ...
// ...
type CloudStorage struct {
}

func New() *CloudStorage {
	return &CloudStorage{}
}

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
func (cd *CloudStorage) GetListOfExamples(ctx context.Context, sdk pb.Sdk, category string) (*Examples, error) {
	client, err := storage.NewClient(ctx, option.WithoutAuthentication())
	if err != nil {
		return nil, fmt.Errorf("storage.NewClient: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(ctx, time.Second*Timeout)
	defer cancel()

	bucket := client.Bucket(BucketName)
	prefix := sdk.String()
	if sdk == pb.Sdk_SDK_UNSPECIFIED {
		prefix = ""
	}
	examples := make(Examples, 0)
	it := bucket.Objects(ctx, &storage.Query{
		Prefix: filepath.Join(prefix, category),
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
		if isFullPathToExample(path) {
			infoPath := filepath.Join(path, MetaInfoName)
			rc, err := bucket.Object(infoPath).NewReader(ctx)
			if err != nil {
				logger.Errorf("Object(%q).NewReader: %v", infoPath, err.Error())
				continue
			}
			data, err := ioutil.ReadAll(rc)
			if err != nil {
				logger.Errorf("ioutil.ReadAll: %v", err.Error())
				continue
			}
			exampleInfo := pb.Example{}
			err = json.Unmarshal(data, &exampleInfo)
			if err != nil {
				logger.Errorf("json.Unmarshal: %v", err.Error())
				continue
			}

			exampleInfo.CloudPath = path
			exampleInfo.Name = filepath.Base(path)
			cd.writeExample(path, &examples, &exampleInfo)
			rc.Close()
		}
	}
	return &examples, nil
}

func isFullPathToExample(path string) bool {
	return strings.Count(path, string(os.PathSeparator)) == 3 && path[len(path)-1] == os.PathSeparator
}

func (cd *CloudStorage) writeExample(path string, examples *Examples, exampleInfo *pb.Example) {
	splintedPath := strings.Split(path, string(os.PathSeparator))
	sdk := splintedPath[0]      // the path of the form "sdk/category/example", where the first part is sdk
	category := splintedPath[1] // and the second part is the name of the category
	catMap, ok := (*examples)[sdk]
	if !ok {
		(*examples)[sdk] = make(SdkCategories, 0)
		catMap = (*examples)[sdk]
	}
	exampleArr, ok := catMap[category]
	if !ok {
		catMap[category] = make(ExamplesInfo, 0)
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
		extension = javaExtension
	case pb.Sdk_SDK_PYTHON.String():
		extension = pyExtension
	case pb.Sdk_SDK_GO.String():
		extension = goExtension
	case pb.Sdk_SDK_SCIO.String():
		extension = scioExtension
	}
	return extension
}

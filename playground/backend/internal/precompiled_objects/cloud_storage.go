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

package precompiled_objects

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
	BucketName       = "playground-examples"
	OutputExtension  = "output"
	MetaInfoName     = "meta.info"
	Timeout          = 10
	javaExtension    = "java"
	goExtension      = "go"
	pyExtension      = "py"
	scioExtension    = "scala"
	separatorsNumber = 2
)

type ObjectInfo struct {
	Description string                   `protobuf:"bytes,3,opt,name=description,proto3" json:"description,omitempty"`
	Type        pb.PrecompiledObjectType `protobuf:"varint,4,opt,name=type,proto3,enum=api.v1.PrecompiledObjectType" json:"type,omitempty"`
	Categories  []string                 `json:"categories,omitempty"`
}

type PrecompiledObjects []pb.PrecompiledObject
type CategoryToPrecompiledObjects map[string]PrecompiledObjects
type SdkToCategories map[string]CategoryToPrecompiledObjects

// CloudStorage represents working tools for getting compiled and
// run beam examples from Google Cloud Storage. It is required that
// the bucket where examples are stored would be public,
// and it has a concrete structure of directories, namely:
// SDK_JAVA/
// --------PrecompiledObject1/
// ----------- PrecompiledObject1.java
// ----------- PrecompiledObject1.output
// ----------- meta.info
// --------PrecompiledObject2/
// ----  ...
// SDK_GO/
// --------PrecompiledObject1/
// ----------- PrecompiledObject1.go
// ----------- PrecompiledObject1.output
// ----------- meta.info
// --------PrecompiledObject2/
// ----  ...
// ...
type CloudStorage struct {
}

func New() *CloudStorage {
	return &CloudStorage{}
}

// GetPrecompiledObject returns the source code of the example
func (cd *CloudStorage) GetPrecompiledObject(ctx context.Context, precompiledObjectPath string) (*string, error) {
	extension := getFileExtensionByFileSdk(precompiledObjectPath)
	data, err := cd.getFileFromBucket(ctx, precompiledObjectPath, extension)
	if err != nil {
		return nil, err
	}
	result := string(data)
	return &result, nil
}

// GetPrecompiledObjectOutput returns the run output of the example
func (cd *CloudStorage) GetPrecompiledObjectOutput(ctx context.Context, precompiledObjectPath string) (*string, error) {
	data, err := cd.getFileFromBucket(ctx, precompiledObjectPath, OutputExtension)
	if err != nil {
		return nil, err
	}
	result := string(data)
	return &result, nil
}

// GetPrecompiledObjects returns the list of stored example at cloud storage bucket
func (cd *CloudStorage) GetPrecompiledObjects(ctx context.Context, sdk pb.Sdk, category string) (*SdkToCategories, error) {
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
	precompiledObjects := make(SdkToCategories, 0)
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
		if isPathToPrecompiledObjectDir(path) {
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
			precompiledObject := ObjectInfo{}
			err = json.Unmarshal(data, &precompiledObject)
			if err != nil {
				logger.Errorf("json.Unmarshal: %v", err.Error())
				continue
			}
			for _, categoryName := range precompiledObject.Categories {
				cd.appendPrecompiledObject(&precompiledObject, &precompiledObjects, path, categoryName)
			}
			rc.Close()
		}
	}
	return &precompiledObjects, nil
}

// GetCategoryToPrecompiledObjects adds categories with precompiled objects to protobuf object
func GetCategoryToPrecompiledObjects(categoryName string, precompiledObjects PrecompiledObjects, sdkCategories *pb.Categories) {
	category := pb.Categories_Category{
		CategoryName:       categoryName,
		PrecompiledObjects: make([]*pb.PrecompiledObject, 0),
	}
	for _, example := range precompiledObjects {
		category.PrecompiledObjects = append(category.PrecompiledObjects, &example)
	}
	sdkCategories.Categories = append(sdkCategories.Categories, &category)
}

// isPathToPrecompiledObjectDir is it a path where object is stored
func isPathToPrecompiledObjectDir(path string) bool {
	return strings.Count(path, string(os.PathSeparator)) == separatorsNumber && isDir(path)
}

func isDir(path string) bool {
	return path[len(path)-1] == os.PathSeparator
}

// appendPrecompiledObject add precompiled object to the common structure of precompiled objects
func (cd *CloudStorage) appendPrecompiledObject(objectInfo *ObjectInfo, sdkToCategories *SdkToCategories, path string, categoryName string) {
	sdkName := getSdkName(path)
	categoryToPrecompiledObjects, ok := (*sdkToCategories)[sdkName]
	if !ok {
		(*sdkToCategories)[sdkName] = make(CategoryToPrecompiledObjects, 0)
		categoryToPrecompiledObjects = (*sdkToCategories)[sdkName]
	}
	objects, ok := categoryToPrecompiledObjects[categoryName]
	if !ok {
		categoryToPrecompiledObjects[categoryName] = make(PrecompiledObjects, 0)
		objects = categoryToPrecompiledObjects[categoryName]
	}
	precompiledObject := pb.PrecompiledObject{
		CloudPath:   path,
		Name:        filepath.Base(path),
		Description: objectInfo.Description,
		Type:        objectInfo.Type,
	}
	precompiledObject.CloudPath = path
	precompiledObject.Name = filepath.Base(path)
	objects = append(objects, precompiledObject)
	categoryToPrecompiledObjects[categoryName] = objects
}

// getSdkName get category and sdk from the name of the file name (path)
func getSdkName(path string) string {
	sdkName := strings.Split(path, string(os.PathSeparator))[0] // the path of the form "sdkName/example/", where the first part is sdkName
	return sdkName
}

func (cd *CloudStorage) getFileFromBucket(ctx context.Context, pathToObject string, extension string) ([]byte, error) {
	client, err := storage.NewClient(ctx, option.WithoutAuthentication())
	if err != nil {
		return nil, fmt.Errorf("storage.NewClient: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(ctx, time.Second*Timeout)
	defer cancel()

	bucket := client.Bucket(BucketName)

	filePath := getFullFilePath(pathToObject, extension)
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

// getFullFilePath get full path to the precompiled object file
func getFullFilePath(pathToObject string, extension string) string {
	precompiledObjectName := filepath.Base(pathToObject)
	fileName := strings.Join([]string{precompiledObjectName, extension}, ".")
	filePath := filepath.Join(pathToObject, fileName)
	return filePath
}

// getFileExtensionByFileSdk get extension of the file with code by the sdk name
func getFileExtensionByFileSdk(precompiledObjectPath string) string {
	sdk := strings.Split(precompiledObjectPath, "/")[0]
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

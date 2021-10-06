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

package fs_tool

import (
	pb "beam.apache.org/playground/backend/internal/api"
	"fmt"
	"github.com/google/uuid"
	"io/fs"
	"io/ioutil"
	"os"
	"path/filepath"
)

const parentBaseFileFolder = "internal"

// Folder contains  names of folders with executable and compiled files (/src and /bin for java SDK)
type Folder struct {
	executableFolder string
	compiledFolder   string
}

// Extension contains executable and compiled files' extensions (.java and .class for java SDK)
type Extension struct {
	executableExtension string
	compiledExtension   string
}

type LifeCycle struct {
	folderGlobs []string
	folder      Folder
	extension   Extension
	pipelineId  uuid.UUID
}

// NewLifeCycle returns a corresponding LifeCycle depending on the given SDK.
func NewLifeCycle(sdk pb.Sdk, pipelineId uuid.UUID) (*LifeCycle, error) {
	switch sdk {
	case pb.Sdk_SDK_JAVA:
		return newJavaLifeCycle(pipelineId), nil
	default:
		return nil, fmt.Errorf("%s isn't supported now", sdk)
	}
}

// CreateFolders creates all folder by folderGlobs.
func (l *LifeCycle) CreateFolders() error {
	for _, folder := range l.folderGlobs {
		err := os.MkdirAll(folder, fs.ModePerm)
		if err != nil {
			return err
		}
	}
	return nil
}

// DeleteFolders deletes all folder by folderGlobs.
func (l *LifeCycle) DeleteFolders() error {
	for _, folder := range l.folderGlobs {
		err := os.RemoveAll(folder)
		if err != nil {
			return err
		}
	}
	return nil
}

// CreateExecutableFile creates executable file (file.java for java SDK).
func (l *LifeCycle) CreateExecutableFile(code string) (string, error) {
	if _, err := os.Stat(l.folder.executableFolder); os.IsNotExist(err) {
		return "", err
	}

	fileName := getFileName(l.pipelineId, l.extension.executableExtension)
	filePath := filepath.Join(l.folder.executableFolder, fileName)
	err := ioutil.WriteFile(filePath, []byte(code), 0600)
	if err != nil {
		return "", err
	}
	return fileName, nil
}

// DeleteExecutableFile deletes executable file (file.java for java SDK).
func (l *LifeCycle) DeleteExecutableFile() error {
	fileName := getFileName(l.pipelineId, l.extension.executableExtension)
	filePath := filepath.Join(l.folder.executableFolder, fileName)
	return os.RemoveAll(filePath)
}

// DeleteCompiledFile deletes compiled file (file.class for java SDK).
func (l *LifeCycle) DeleteCompiledFile() error {
	fileName := getFileName(l.pipelineId, l.extension.compiledExtension)
	filePath := filepath.Join(l.folder.compiledFolder, fileName)
	return os.RemoveAll(filePath)
}

// getFileName returns fileName by pipelineId and fileType (pipelineId.java for java SDK).
func getFileName(pipelineId uuid.UUID, fileType string) string {
	return fmt.Sprintf("%s.%s", pipelineId, fileType)
}

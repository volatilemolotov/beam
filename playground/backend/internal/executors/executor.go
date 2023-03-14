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

package executors

import (
	pb "beam.apache.org/playground/backend/internal/api/v1"
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"context"
	"fmt"
	"os/exec"
	"path/filepath"
)

type ExecutionType string

const (
	Run  ExecutionType = "Run"
	Test ExecutionType = "RunTest"
)

// CmdConfiguration for base cmd code execution
type CmdConfiguration struct {
	fileNames       []string
	workingDir      string
	commandName     string
	commandArgs     []string
	pipelineOptions []string
}

// Executor struct for all sdks (Java/Python/Go/SCIO)
type Executor struct {
	compileArgs CmdConfiguration
	runArgs     CmdConfiguration
	testArgs    CmdConfiguration
}

// GetCompileCmd prepares the Cmd for code compilation
// Returns Cmd instance
func GetCompileCmd(ctx context.Context, paths *fs_tool.LifeCyclePaths, sdkEnv *environment.BeamEnvs) (*exec.Cmd, error) {
	sdk := sdkEnv.ApacheBeamSdk
	executorConfig := sdkEnv.ExecutorConfig

	compileCmd := executorConfig.CompileCmd
	workingDir := paths.AbsoluteBaseFolderPath
	args := executorConfig.CompileArgs

	switch sdk {
	case pb.Sdk_SDK_JAVA:
		javaSources, err := GetFilesFromFolder(paths.AbsoluteSourceFileFolderPath, fs_tool.JavaSourceFileExtension)
		if err != nil {
			return nil, err
		}
		args = append(args, javaSources...)
	case pb.Sdk_SDK_GO:
		goSources, err := GetFilesFromFolder(paths.AbsoluteSourceFileFolderPath, fs_tool.GoSourceFileExtension)
		if err != nil {
			return nil, err
		}
		args = append(args, goSources...)
	default:
		args = append(args, paths.AbsoluteSourceFilePath)
	}

	cmd := exec.CommandContext(ctx, compileCmd, args...)
	cmd.Dir = workingDir
	return cmd, nil
}

// Run prepares the Cmd for execution of the code
// Returns Cmd instance
func (ex *Executor) Run(ctx context.Context) *exec.Cmd {
	args := ex.runArgs.commandArgs
	if len(ex.runArgs.fileNames) > 0 {
		args = append(args, ex.runArgs.fileNames...)
	}
	if ex.runArgs.pipelineOptions != nil && ex.runArgs.pipelineOptions[0] != "" {
		args = append(args, ex.runArgs.pipelineOptions...)
	}
	cmd := exec.CommandContext(ctx, ex.runArgs.commandName, args...)
	cmd.Dir = ex.runArgs.workingDir
	return cmd
}

// RunTest prepares the Cmd for execution of the unit test
// Returns Cmd instance
func (ex *Executor) RunTest(ctx context.Context) *exec.Cmd {
	args := append(ex.testArgs.commandArgs, ex.testArgs.fileNames...)
	cmd := exec.CommandContext(ctx, ex.testArgs.commandName, args...)
	cmd.Dir = ex.testArgs.workingDir
	return cmd
}

// GetFirstFileFromFolder return a name of the first file in a specified folder
func GetFilesFromFolder(folderAbsolutePath string, extension string) ([]string, error) {
	return filepath.Glob(fmt.Sprintf("%s/*%s", folderAbsolutePath, extension))
}

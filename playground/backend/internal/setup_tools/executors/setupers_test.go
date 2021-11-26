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
	"beam.apache.org/playground/backend/internal/executors"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"beam.apache.org/playground/backend/internal/utils"
	"beam.apache.org/playground/backend/internal/validators"
	"context"
	"github.com/google/uuid"
	"os"
	"path/filepath"
	"reflect"
	"testing"
)

// SetupHelper returns executors.CompileBuilder setup it according to sdk
func SetupHelper(filePath, filesFolderPath string, sdk pb.Sdk, executorConfig *environment.ExecutorConfig) (*executors.CompileBuilder, error) {
	val, err := utils.GetValidators(sdk, filePath)
	if err != nil {
		return nil, err
	}
	prep, err := utils.GetPreparators(sdk, filePath)
	if err != nil {
		return nil, err
	}

	compileBuilder := executors.NewExecutorBuilder().
		WithValidator().
		WithSdkValidators(val).
		WithPreparator().
		WithSdkPreparators(prep).
		WithCompiler()

	compileBuilder = compileBuilder.
		WithCommand(executorConfig.CompileCmd).
		WithArgs(executorConfig.CompileArgs).
		WithFileName(filePath).
		WithWorkingDir(filesFolderPath)

	return compileBuilder, nil
}

func TestSetup(t *testing.T) {
	pipelineId := uuid.New()
	sdk := pb.Sdk_SDK_JAVA
	filesFolderPath := filepath.Join("executable_files", pipelineId.String())
	filePath := filepath.Join(filesFolderPath, "src", pipelineId.String()+".java")
	executorConfig := &environment.ExecutorConfig{
		CompileCmd:  "MOCK_COMPILE_CMD",
		RunCmd:      "MOCK_RUN_CMD",
		CompileArgs: []string{"MOCK_COMPILE_ARG"},
		RunArgs:     []string{"MOCK_RUN_ARG"},
	}
	val := validators.GetJavaValidators(filePath)

	type args struct {
		filePath        string
		filesFolderPath string
		sdk             pb.Sdk
		executorConfig  *environment.ExecutorConfig
	}
	tests := []struct {
		name    string
		args    args
		want    *executors.CompileBuilder
		wantErr bool
	}{
		{
			// Test case with calling SetupHelper with incorrect SDK.
			// As a result, want to receive an error.
			name: "incorrect sdk",
			args: args{
				filePath:        filePath,
				filesFolderPath: filesFolderPath,
				sdk:             pb.Sdk_SDK_UNSPECIFIED,
				executorConfig:  executorConfig,
			},
			want:    nil,
			wantErr: true,
		},
		{
			// Test case with calling SetupHelper with correct SDK.
			// As a result, want to receive an expected compile builder.
			name: "correct sdk",
			args: args{
				filePath:        filePath,
				filesFolderPath: filesFolderPath,
				sdk:             sdk,
				executorConfig:  executorConfig,
			},
			want: executors.NewExecutorBuilder().
				WithValidator().
				WithSdkValidators(val).
				WithCompiler().
				WithCommand(executorConfig.CompileCmd).
				WithArgs(executorConfig.CompileArgs).
				WithFileName(filePath).
				WithWorkingDir(filesFolderPath),
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := SetupHelper(tt.args.filePath, tt.args.filesFolderPath, tt.args.sdk, tt.args.executorConfig)
			if (err != nil) != tt.wantErr {
				t.Errorf("SetupHelper() err = %v, wantErr %v", err, tt.wantErr)
			}
			if got != nil {
				gotBuilder := got.Build()
				wantBuilder := tt.want.Build()
				if !reflect.DeepEqual(gotBuilder.Compile(context.Background()), wantBuilder.Compile(context.Background())) {
					t.Errorf("SetupHelper() got.Build.Compile() = %v, want %v", gotBuilder.Compile(context.Background()), wantBuilder.Compile(context.Background()))
				}
				if !reflect.DeepEqual(gotBuilder.Run(context.Background()), wantBuilder.Run(context.Background())) {
					t.Errorf("SetupHelper() got.Build.Run() = %v, want %v", gotBuilder.Run(context.Background()), wantBuilder.Run(context.Background()))
				}
			}
		})
	}
}

func TestSetupRunner(t *testing.T) {
	successPipelineId := uuid.New()
	errorPipelineId := uuid.New()
	sdk := pb.Sdk_SDK_JAVA
	errorLc, err := fs_tool.NewLifeCycle(sdk, errorPipelineId, "")
	if err != nil {
		panic(err)
	}
	successLc, err := fs_tool.NewLifeCycle(sdk, successPipelineId, "")
	if err != nil {
		panic(err)
	}
	err = successLc.CreateFolders()
	if err != nil {
		panic(err)
	}
	_, err = os.Create(successLc.Folder.ExecutableFileFolder + "/temp.class")
	if err != nil {
		panic(err)
	}
	executorConfig := &environment.ExecutorConfig{
		CompileCmd:  "MOCK_COMPILE_CMD",
		RunCmd:      "MOCK_RUN_CMD",
		CompileArgs: []string{"MOCK_COMPILE_ARG"},
		RunArgs:     []string{"MOCK_RUN_ARG"},
	}
	sdkEnv := environment.NewBeamEnvs(pb.Sdk_SDK_JAVA, executorConfig, "")
	className, err := successLc.ExecutableName(successPipelineId, "")
	executor := executors.NewExecutorBuilder().
		WithRunner().
		WithCommand(sdkEnv.ExecutorConfig.RunCmd).
		WithArgs(sdkEnv.ExecutorConfig.RunArgs).
		WithWorkingDir(successLc.GetAbsoluteBaseFolderPath()).
		WithExecutableName(className).
		Build()
	if err != nil {
		panic(err)
	}

	type args struct {
		pipelineId uuid.UUID
		lc         *fs_tool.LifeCycle
		workingDir string
		sdkEnv     *environment.BeamEnvs
	}
	tests := []struct {
		name    string
		args    args
		want    *executors.Executor
		wantErr bool
	}{
		{
			// Test case with calling SetupHelper method with incorrect SDK.
			// As a result, want to receive an error.
			name: "incorrect sdk",
			args: args{
				pipelineId: successPipelineId,
				lc:         successLc,
				workingDir: "",
				sdkEnv:     environment.NewBeamEnvs(pb.Sdk_SDK_UNSPECIFIED, executorConfig, ""),
			},
			want:    nil,
			wantErr: true,
		},
		{
			// Test case with calling SetupHelper method with incorrect LifeCycle.
			// As a result, want to receive an error.
			name: "error during set class name",
			args: args{
				pipelineId: errorPipelineId,
				lc:         errorLc,
				workingDir: "",
				sdkEnv:     sdkEnv,
			},
			want:    nil,
			wantErr: true,
		},
		{
			// Test case with calling SetupHelper method with correct SDK.
			// As a result, want to receive an expected run builder.
			name: "correct sdk",
			args: args{
				pipelineId: successPipelineId,
				lc:         successLc,
				workingDir: "",
				sdkEnv:     sdkEnv,
			},
			want:    &executor,
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := SetupRunner(tt.args.pipelineId, tt.args.lc, tt.args.workingDir, tt.args.sdkEnv)
			if (err != nil) != tt.wantErr {
				t.Errorf("SetupHelper() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if got != nil {
				if !reflect.DeepEqual(got.Run(context.Background()), tt.want.Run(context.Background())) {
					t.Errorf("SetupHelper() got.Build().Run() = %v, want %v", got.Run(context.Background()), tt.want.Run(context.Background()))
				}
				os.RemoveAll("executable_files")
			}
		})
	}
}

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

package builders

import (
	pb "beam.apache.org/playground/backend/internal/api/v1"
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/executors"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"beam.apache.org/playground/backend/internal/logger"
	"beam.apache.org/playground/backend/internal/utils"
	"fmt"
	"github.com/google/uuid"
)

func SetupValidator(filePath string, sdk pb.Sdk) (*executors.Executor, error) {
	val, err := utils.GetValidators(sdk, filePath)
	if err != nil {
		return nil, err
	}

	executor := executors.NewExecutorBuilder().
		WithValidator().
		WithSdkValidators(val).
		Build()

	return &executor, nil
}

func SetupPreparator(filePath string, sdk pb.Sdk) (*executors.Executor, error) {
	prep, err := utils.GetPreparators(sdk, filePath)
	if err != nil {
		return nil, err
	}
	executor := executors.NewExecutorBuilder().
		WithPreparator().
		WithSdkPreparators(prep).
		Build()

	return &executor, nil
}

func SetupCompiler(filePath, filesFolderPath string, executorConfig *environment.ExecutorConfig) (*executors.Executor, error) {
	executor := executors.NewExecutorBuilder().
		WithCompiler().
		WithCommand(executorConfig.CompileCmd).
		WithArgs(executorConfig.CompileArgs).
		WithFileName(filePath).
		WithWorkingDir(filesFolderPath).
		Build()

	return &executor, nil
}

func SetupRunner(pipelineId uuid.UUID, lc *fs_tool.LifeCycle, workingDir string, sdkEnv *environment.BeamEnvs) (*executors.Executor, error) {
	builder := executors.NewExecutorBuilder().
		WithRunner().
		WithCommand(sdkEnv.ExecutorConfig.RunCmd).
		WithArgs(sdkEnv.ExecutorConfig.RunArgs).
		WithWorkingDir(lc.GetAbsoluteBaseFolderPath())

	switch sdkEnv.ApacheBeamSdk {
	case pb.Sdk_SDK_JAVA:
		className, err := lc.ExecutableName(pipelineId, workingDir)
		if err != nil {
			logger.Errorf("%s: get executable file name: %s\n", pipelineId, err.Error())
			return nil, err
		}
		builder = builder.WithExecutableName(className)
	case pb.Sdk_SDK_GO:
		builder = builder.WithCommand(lc.GetAbsoluteExecutableFilePath())
	case pb.Sdk_SDK_PYTHON:
		builder = builder.WithExecutableName(lc.GetAbsoluteExecutableFilePath())
	default:
		return nil, fmt.Errorf("incorrect sdk: %s", sdkEnv.ApacheBeamSdk)
	}
	executor := builder.Build()
	return &executor, nil
}

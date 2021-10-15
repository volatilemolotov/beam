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
package main

import (
	pb "beam.apache.org/playground/backend/internal/api"
	"beam.apache.org/playground/backend/internal/cache"
	"beam.apache.org/playground/backend/internal/errors"
	"beam.apache.org/playground/backend/internal/executors"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"context"
	"github.com/google/uuid"
	"google.golang.org/grpc/grpclog"
	"os"
	"time"
)

type playgroundController struct {
	pb.UnimplementedPlaygroundServiceServer
}

var cacheService = cache.NewCache(os.Getenv("cache"))

//RunCode is running code from requests using a particular SDK
func (controller *playgroundController) RunCode(ctx context.Context, info *pb.RunCodeRequest) (*pb.RunCodeResponse, error) {
	defer func() {
		grpclog.Info("RunCode complete")
	}()

	pipelineId := uuid.New()
	expTime, err := time.ParseDuration(os.Getenv("expiration"))
	if err != nil {
		expTime = time.Hour
	}

	// create file system service
	lc, err := fs_tool.NewLifeCycle(info.Sdk, pipelineId)
	if err != nil {
		grpclog.Error("RunCode: NewLifeCycle: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during creating file system service: "+err.Error())
	}

	// create folders
	err = lc.CreateFolders()
	if err != nil {
		grpclog.Error("RunCode: CreateFolders: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during preparing folders: "+err.Error())
	}

	// create file with code
	_, err = lc.CreateExecutableFile(info.Code)
	if err != nil {
		grpclog.Error("RunCode: CreateExecutableFile: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during creating file with code: "+err.Error())
	}

	// create executor
	exec, err := executors.NewExecutor(info.Sdk, lc)
	if err != nil {
		grpclog.Error("RunCode: NewExecutor: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during creating executor: "+err.Error())
	}

	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_EXECUTING)
	if err != nil {
		grpclog.Error("RunCode: cache.SetValue: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during set value to cache: "+err.Error())
	}
	err = cacheService.SetExpTime(pipelineId, expTime)
	if err != nil {
		grpclog.Error("RunCode: cache.SetExpTime: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during set expiration to cache: "+err.Error())
	}

	go parallelRunCode(ctx, lc, exec, pipelineId)

	pipelineInfo := pb.RunCodeResponse{PipelineUuid: pipelineId.String()}
	return &pipelineInfo, nil
}

//CheckStatus is checking status for the specific pipeline by PipelineUuid
func (controller *playgroundController) CheckStatus(ctx context.Context, info *pb.CheckStatusRequest) (*pb.CheckStatusResponse, error) {
	// TODO implement this method
	status := pb.CheckStatusResponse{Status: pb.Status_STATUS_FINISHED}
	return &status, nil
}

//GetRunOutput is returning output of execution for specific pipeline by PipelineUuid
func (controller *playgroundController) GetRunOutput(ctx context.Context, info *pb.GetRunOutputRequest) (*pb.GetRunOutputResponse, error) {
	// TODO implement this method
	pipelineResult := pb.GetRunOutputResponse{Output: "Test Pipeline Result"}

	return &pipelineResult, nil
}

//GetCompileOutput is returning output of compilation for specific pipeline by PipelineUuid
func (controller *playgroundController) GetCompileOutput(ctx context.Context, info *pb.GetCompileOutputRequest) (*pb.GetCompileOutputResponse, error) {
	// TODO implement this method
	compileOutput := pb.GetCompileOutputResponse{Output: "test compile output"}
	return &compileOutput, nil
}

// parallelRunCode validates, compiles and runs code by pipelineId.
// During each operation updates status of execution and saves it into cache.
// In case of compilation failed saves logs to cache.
// After success code running saves output to cache.
func parallelRunCode(ctx context.Context, lc *fs_tool.LifeCycle, exec *executors.Executor, pipelineId uuid.UUID) {
	ctxWithTimeout, cancelByTimeoutFunc := context.WithTimeout(ctx, timeout)
	defer func(lc *fs_tool.LifeCycle) {
		grpclog.Info("parallelRunCode: DeleteFolders ...")
		err := lc.DeleteFolders()
		if err != nil {
			grpclog.Error("parallelRunCode: DeleteFolders: " + err.Error())
		}

		// set to cache pipelineId: cache.SubKey_Status: Status_STATUS_EXPIRED
		err := cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_EXPIRED)
		if err != nil {
			grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
			return
		}

		grpclog.Info("parallelRunCode complete")

		cancelByTimeoutFunc()
	}(lc)

	// set to cache pipelineId: cache.SubKey_Canceled: false
	err := cacheService.SetValue(pipelineId, cache.SubKey_Canceled, false)
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
		return
	}

	finish := make(chan bool)
	cancel := make(chan bool)
	go func(lc *fs_tool.LifeCycle, exec *executors.Executor, pipelineId uuid.UUID, finish chan bool) {
		// validate
		grpclog.Info("parallelRunCode: Validate ...")
		err := exec.Validate()
		if err != nil {
			// error during validation
			grpclog.Error("parallelRunCode: Validate: " + err.Error())

			// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
			err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
			if err != nil {
				grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
				return
			}
			return
		}
		grpclog.Info("parallelRunCode: Validate finish")

		grpclog.Info("parallelRunCode: Compile ...")
		err = exec.Compile()
		if err != nil {
			// error during compilation
			grpclog.Error("parallelRunCode: Compile: " + err.Error())

			// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
			err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
			if err != nil {
				grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
				return
			}

			// set to cache pipelineId: cache.SubKey_CompileOutput: err.Error()
			err = cacheService.SetValue(pipelineId, cache.SubKey_CompileOutput, err.Error())
			if err != nil {
				grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
				return
			}
			return
		}
		// compilation success
		grpclog.Info("parallelRunCode: Compile finish")

		// set to cache pipelineId: cache.SubKey_CompileOutput: ""
		err = cacheService.SetValue(pipelineId, cache.SubKey_CompileOutput, "")
		if err != nil {
			grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
			return
		}

		grpclog.Info("parallelRunCode: get executable file name ...")
		fileName, err := lc.GetExecutableName()
		if err != nil {
			grpclog.Error("parallelRunCode: get executable file name: " + err.Error())
			err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
			if err != nil {
				grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
				return
			}
		}
		grpclog.Infof("parallelRunCode: executable file name: %s", fileName)

		grpclog.Info("parallelRunCode: Run ...")
		output, err := exec.Run(fileName)
		if err != nil {
			// error during run code
			grpclog.Error("parallelRunCode: Run: " + err.Error())

			// set to cache pipelineId: cache.SubKey_RunOutput: err.Error()
			err = cacheService.SetValue(pipelineId, cache.Subkey_RunOutput, err.Error())
			if err != nil {
				grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
				return
			}

			// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
			err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
			if err != nil {
				grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
				return
			}
			return
		}
		// run code success
		grpclog.Info("parallelRunCode: Run finish")

		// set to cache pipelineId: cache.SubKey_RunOutput: output
		err = cacheService.SetValue(pipelineId, cache.Subkey_RunOutput, output)
		if err != nil {
			grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
			return
		}

		// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_FINISHED
		err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_FINISHED)
		if err != nil {
			grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
			return
		}

		// if channel was closed then no need to set any value
		if _, ok := <-finish; !ok {
			return
		}
		finish <- true
	}(lc, exec, pipelineId, finish)
	go func(cancel chan bool) {
		for {
			canceled, err := cacheService.GetValue(pipelineId, cache.SubKey_Canceled)
			if err != nil {
				grpclog.Error("parallelRunCode: cache.GetValue: " + err.Error())
				return
			}
			// if channel was closed then need to stop goroutine
			if _, ok := <-cancel; !ok {
				return
			}
			if canceled.(bool) {
				cancel <- true
				return
			}
			time.Sleep(time.Second)
		}
	}(cancel)

	select {
	case <-ctxWithTimeout.Done():
		grpclog.Info("parallelRunCode finish because of ctxWithTimeout.Done")
	case <-cancel:
		grpclog.Info("parallelRunCode finish because of Cancel operation")
	case <-finish:
		grpclog.Info("parallelRunCode finish")
	}
	close(finish)
	close(cancel)
}

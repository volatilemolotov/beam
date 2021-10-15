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
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/errors"
	"beam.apache.org/playground/backend/internal/executors"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"context"
	"fmt"
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
	env := environment.NewEnvironment()
	expTime := env.ServerEnvs.GetCacheExpiration()
	timeout := env.ServerEnvs.GetRunCodeTimeout()

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

	go runCode(context.TODO(), lc, exec, pipelineId, timeout)

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

// runCode validates, compiles and runs code by pipelineId.
// During each operation updates status of execution and saves it into cache.
// In case of compilation failed saves logs to cache.
// After success code running saves output to cache.
func runCode(ctx context.Context, lc *fs_tool.LifeCycle, exec *executors.Executor, pipelineId uuid.UUID, timeout time.Duration) {
	channel := make(chan interface{}, 1)

	ctxWithTimeout, cancelByTimeoutFunc := context.WithTimeout(ctx, timeout)
	defer func(lc *fs_tool.LifeCycle) {
		cleanUp(lc)
		cancelByTimeoutFunc()
		close(channel)
	}(lc)

	// validate
	grpclog.Info("parallelRunCode: Validate ...")
	fmt.Println("parallelRunCode: Validate ...")
	//for {
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId)
		return
	case channel <- exec.Validate():
		err := <-channel
		if err != nil {
			// error during validation
			processErrDuringValidate(err.(error), pipelineId)
			return
		}
	}
	//}
	grpclog.Info("parallelRunCode: Validate finish")
	fmt.Println("parallelRunCode: Validate finish")

	// compile
	grpclog.Info("parallelRunCode: Compile ...")
	fmt.Println("parallelRunCode: Compile ...")
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId)
		return
	case channel <- exec.Compile():
		err := <-channel
		if err != nil {
			// error during compilation
			processErrDuringCompile(err.(error), pipelineId)
			return
		}
	}
	grpclog.Info("parallelRunCode: Compile finish")
	fmt.Println("parallelRunCode: Compile finish")

	// set empty value to pipelineId: cache.SubKey_CompileOutput
	err := cacheService.SetValue(pipelineId, cache.SubKey_CompileOutput, "")
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
		return
	}

	// get executable file name
	grpclog.Info("parallelRunCode: get executable file name ...")
	fmt.Println("parallelRunCode: get executable file name ...")
	fileName, err := lc.GetExecutableName()
	if err != nil {
		// error during get executable file name
		processErrDuringGetExecutableName(err, pipelineId)
		return
	}
	grpclog.Infof("parallelRunCode: executable file name: %s", fileName)
	fmt.Printf("parallelRunCode: executable file name: %s\n", fileName)

	// run
	output := ""
	grpclog.Info("parallelRunCode: Run ...")
	fmt.Println("parallelRunCode: Run ...")
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId)
		return
	case channel <- exec.Run(fileName):
		runResult := <-channel
		err := runResult.(*executors.RunResult).Err
		output = runResult.(*executors.RunResult).Output
		if err != nil {
			// error during run code
			processErrDuringRun(err, pipelineId)
			return
		}
	}
	grpclog.Info("parallelRunCode: Run finish")
	fmt.Println("parallelRunCode: Run finish")
	processSuccessRun(pipelineId, output)
	fmt.Println(cacheService.GetValue(pipelineId, cache.SubKey_Status))
	fmt.Println(cacheService.GetValue(pipelineId, cache.SubKey_CompileOutput))
	fmt.Println(cacheService.GetValue(pipelineId, cache.Subkey_RunOutput))
}

// finishByContext is used in case of runCode method finished by timeout
func finishByContext(pipelineId uuid.UUID) {
	grpclog.Info("parallelRunCode finish because of ctxWithTimeout.Done")

	// set to cache pipelineId: cache.SubKey_Status: Status_STATUS_TIMEOUT
	err := cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// cleanUp removes all prepared folders for received LifeCycle
func cleanUp(lc *fs_tool.LifeCycle) {
	grpclog.Info("parallelRunCode complete")
	fmt.Println("parallelRunCode complete")

	grpclog.Info("parallelRunCode: DeleteFolders ...")
	fmt.Println("parallelRunCode: DeleteFolders ...")
	err := lc.DeleteFolders()
	if err != nil {
		grpclog.Error("parallelRunCode: DeleteFolders: " + err.Error())
		fmt.Println("parallelRunCode: DeleteFolders: " + err.Error())
	}
	grpclog.Info("parallelRunCode: DeleteFolders complete")
	fmt.Println("parallelRunCode: DeleteFolders complete")
}

// processErrDuringValidate processes error received during Validate step
func processErrDuringValidate(err error, pipelineId uuid.UUID) {
	grpclog.Error("parallelRunCode: Validate: " + err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processErrDuringCompile processes error received during Compile step
func processErrDuringCompile(err error, pipelineId uuid.UUID) {
	grpclog.Error("parallelRunCode: Compile: " + err.Error())
	fmt.Println("parallelRunCode: Compile: " + err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
		fmt.Println("parallelRunCode: cache.SetValue: " + err.Error())
	}

	// set to cache pipelineId: cache.SubKey_CompileOutput: err.Error()
	err = cacheService.SetValue(pipelineId, cache.SubKey_CompileOutput, err.Error())
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
		fmt.Println("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processErrDuringGetExecutableName processes error received during getting executable file name
func processErrDuringGetExecutableName(err error, pipelineId uuid.UUID) {
	grpclog.Error("parallelRunCode: get executable file name: " + err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processErrDuringRun processes error received during Run step
func processErrDuringRun(err error, pipelineId uuid.UUID) {
	grpclog.Error("parallelRunCode: Run: " + err.Error())

	// set to cache pipelineId: cache.SubKey_RunOutput: err.Error()
	err = cacheService.SetValue(pipelineId, cache.Subkey_RunOutput, err.Error())
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
	}

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		grpclog.Error("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processSuccessRun processes case after successfully Run step
func processSuccessRun(pipelineId uuid.UUID, output string) {
	// set to cache pipelineId: cache.SubKey_RunOutput: output
	err := cacheService.SetValue(pipelineId, cache.Subkey_RunOutput, output)
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
}

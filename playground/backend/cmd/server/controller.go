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
	"github.com/google/uuid"
	"log"
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
		log.Println("RunCode complete")
	}()

	pipelineId := uuid.New()
	env := environment.NewEnvironment()
	expTime := env.ServerEnvs.GetCacheExpiration()
	timeout := env.ServerEnvs.GetRunCodeTimeout()

	// create file system service
	lc, err := fs_tool.NewLifeCycle(info.Sdk, pipelineId)
	if err != nil {
		log.Printf("RunCode: NewLifeCycle: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during creating file system service: "+err.Error())
	}

	// create folders
	err = lc.CreateFolders()
	if err != nil {
		log.Printf("RunCode: CreateFolders: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during preparing folders: "+err.Error())
	}

	// create file with code
	_, err = lc.CreateExecutableFile(info.Code)
	if err != nil {
		log.Printf("RunCode: CreateExecutableFile: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during creating file with code: "+err.Error())
	}

	// create executor
	exec, err := executors.NewExecutor(info.Sdk, lc)
	if err != nil {
		log.Printf("RunCode: NewExecutor: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during creating executor: "+err.Error())
	}

	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_EXECUTING)
	if err != nil {
		log.Printf("RunCode: cache.SetValue: " + err.Error())
		return nil, errors.InternalError("Run code", "Error during set value to cache: "+err.Error())
	}
	err = cacheService.SetExpTime(pipelineId, expTime)
	if err != nil {
		log.Printf("RunCode: cache.SetExpTime: " + err.Error())
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
		cancelByTimeoutFunc()
		close(channel)
		cleanUp(lc)
	}(lc)

	// validate
	log.Println("parallelRunCode: Validate ...")
	go exec.Validate(channel)
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId)
		return
	case err := <-channel:
		if err != nil {
			// error during validation
			processErrDuringValidate(err.(error), pipelineId)
			return
		}
	}
	log.Println("parallelRunCode: Validate finish")

	// compile
	log.Println("parallelRunCode: Compile ...")
	go exec.Compile(channel)
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId)
		return
	case err := <-channel:
		if err != nil {
			// error during compilation
			processErrDuringCompile(err.(error), pipelineId)
			return
		}
	}
	log.Println("parallelRunCode: Compile finish")

	// set empty value to pipelineId: cache.SubKey_CompileOutput
	err := cacheService.SetValue(pipelineId, cache.SubKey_CompileOutput, "")
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
		return
	}

	// get executable file name
	log.Println("parallelRunCode: get executable file name ...")
	fileName, err := lc.GetExecutableName()
	if err != nil {
		// error during get executable file name
		processErrDuringGetExecutableName(err, pipelineId)
		return
	}
	log.Printf("parallelRunCode: executable file name: %s\n", fileName)

	// run
	output := ""
	log.Println("parallelRunCode: Run ...")
	go exec.Run(channel, fileName)
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId)
		return
	case runResult := <-channel:
		err := runResult.(*executors.RunResult).Err
		output = runResult.(*executors.RunResult).Output
		if err != nil {
			// error during run code
			processErrDuringRun(err, pipelineId)
			return
		}
	}
	log.Println("parallelRunCode: Run finish")
	processSuccessRun(pipelineId, output)
}

// finishByContext is used in case of runCode method finished by timeout
func finishByContext(pipelineId uuid.UUID) {
	log.Println("parallelRunCode finish because of ctxWithTimeout.Done")

	// set to cache pipelineId: cache.SubKey_Status: Status_STATUS_TIMEOUT
	err := cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// cleanUp removes all prepared folders for received LifeCycle
func cleanUp(lc *fs_tool.LifeCycle) {
	log.Println("parallelRunCode complete")

	log.Println("parallelRunCode: DeleteFolders ...")
	err := lc.DeleteFolders()
	if err != nil {
		log.Printf("parallelRunCode: DeleteFolders: " + err.Error())
	}
	log.Println("parallelRunCode: DeleteFolders complete")
}

// processErrDuringValidate processes error received during Validate step
func processErrDuringValidate(err error, pipelineId uuid.UUID) {
	log.Printf("parallelRunCode: Validate: " + err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processErrDuringCompile processes error received during Compile step
func processErrDuringCompile(err error, pipelineId uuid.UUID) {
	log.Printf("parallelRunCode: Compile: " + err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}

	// set to cache pipelineId: cache.SubKey_CompileOutput: err.Error()
	err = cacheService.SetValue(pipelineId, cache.SubKey_CompileOutput, err.Error())
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processErrDuringGetExecutableName processes error received during getting executable file name
func processErrDuringGetExecutableName(err error, pipelineId uuid.UUID) {
	log.Printf("parallelRunCode: get executable file name: " + err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processErrDuringRun processes error received during Run step
func processErrDuringRun(err error, pipelineId uuid.UUID) {
	log.Printf("parallelRunCode: Run: " + err.Error())

	// set to cache pipelineId: cache.SubKey_RunOutput: err.Error()
	err = cacheService.SetValue(pipelineId, cache.Subkey_RunOutput, err.Error())
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
	}
}

// processSuccessRun processes case after successfully Run step
func processSuccessRun(pipelineId uuid.UUID, output string) {
	// set to cache pipelineId: cache.SubKey_RunOutput: output
	err := cacheService.SetValue(pipelineId, cache.Subkey_RunOutput, output)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
		return
	}

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_FINISHED
	err = cacheService.SetValue(pipelineId, cache.SubKey_Status, pb.Status_STATUS_FINISHED)
	if err != nil {
		log.Printf("parallelRunCode: cache.SetValue: " + err.Error())
		return
	}
}

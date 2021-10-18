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
	"time"
)

type playgroundController struct {
	env          *environment.Environment
	cacheService cache.Cache

	pb.UnimplementedPlaygroundServiceServer
}

//RunCode is running code from requests using a particular SDK
func (controller *playgroundController) RunCode(ctx context.Context, info *pb.RunCodeRequest) (*pb.RunCodeResponse, error) {
	pipelineId := uuid.New()

	defer func() {
		log.Printf("RunCode() is completed for pipeline with id: %s\n", pipelineId)
	}()

	expTime := controller.env.GetCacheExpirationTime()
	timeout := controller.env.ServerEnvs.GetPipelineExecuteTimeout()

	// create file system service
	lc, err := fs_tool.NewLifeCycle(info.Sdk, pipelineId)
	if err != nil {
		log.Printf("%s: RunCode(): NewLifeCycle(): %s\n", pipelineId, err.Error())
		return nil, errors.InternalError("Run code", "Error during creating file system service: "+err.Error())
	}

	// create folders
	err = lc.CreateFolders()
	if err != nil {
		log.Printf("%s: RunCode(): CreateFolders(): %s\n", pipelineId, err.Error())
		return nil, errors.InternalError("Run code()", "Error during preparing folders: "+err.Error())
	}

	// create file with code
	_, err = lc.CreateExecutableFile(info.Code)
	if err != nil {
		log.Printf("%s: RunCode(): CreateExecutableFile(): %s\n", pipelineId, err.Error())
		return nil, errors.InternalError("Run code()", "Error during creating file with code: "+err.Error())
	}

	// create executor
	exec, err := executors.NewExecutor(info.Sdk, lc)
	if err != nil {
		log.Printf("%s: RunCode(): NewExecutor(): %s\n", pipelineId, err.Error())
		return nil, errors.InternalError("Run code()", "Error during creating executor: "+err.Error())
	}

	setToCache(controller.cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_EXECUTING)

	err = controller.cacheService.SetExpTime(pipelineId, expTime)
	if err != nil {
		log.Printf("%s: RunCode(): cache.SetExpTime(): %s\n", pipelineId, err.Error())
		return nil, errors.InternalError("Run code()", "Error during set expiration to cache: "+err.Error())
	}

	go processCode(context.TODO(), controller.cacheService, lc, exec, pipelineId, timeout)

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

// processCode validates, compiles and runs code by pipelineId.
// During each operation updates status of execution and saves it into cache.
// In case of some step is failed saves output logs to cache.
// After success code running saves output to cache.
// At the end of this method deletes all created folders
func processCode(ctx context.Context, cacheService cache.Cache, lc *fs_tool.LifeCycle, exec *executors.Executor, pipelineId uuid.UUID, timeout time.Duration) {
	channel := make(chan interface{}, 1)

	ctxWithTimeout, cancelByTimeoutFunc := context.WithTimeout(ctx, timeout)
	defer func(lc *fs_tool.LifeCycle) {
		cancelByTimeoutFunc()
		cleanUp(pipelineId, lc)
	}(lc)

	// validate
	log.Printf("%s: Validate() ...\n", pipelineId)
	go exec.Validate(channel)
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId, cacheService)
		return
	case err := <-channel:
		if err != nil {
			// error during validation
			processErrDuringValidate(err.(error), pipelineId, cacheService)
			return
		}
	}
	log.Printf("%s: Validate() finish\n", pipelineId)

	// compile
	log.Printf("%s: Compile() ...\n", pipelineId)
	go exec.Compile(channel)
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId, cacheService)
		return
	case err := <-channel:
		if err != nil {
			// error during compilation
			processErrDuringCompile(err.(error), pipelineId, cacheService)
			return
		}
	}
	log.Printf("%s: Compile() finish\n", pipelineId)

	// set empty value to pipelineId: cache.SubKey_CompileOutput
	setToCache(cacheService, pipelineId, cache.SubKey_CompileOutput, "")

	// get executable file name
	log.Printf("%s: get executable file name ...\n", pipelineId)
	fileName, err := lc.GetExecutableName()
	if err != nil {
		// error during get executable file name
		processErrDuringGetExecutableName(err, pipelineId, cacheService)
		return
	}
	log.Printf("%s: executable file name: %s\n", pipelineId, fileName)

	// run
	output := ""
	log.Printf("%s: Run() ...\n", pipelineId)
	go exec.Run(channel, fileName)
	select {
	case <-ctxWithTimeout.Done():
		finishByContext(pipelineId, cacheService)
		return
	case runResult := <-channel:
		err := runResult.(*executors.RunResult).Err
		output = runResult.(*executors.RunResult).Output
		if err != nil {
			// error during run code
			processErrDuringRun(err, pipelineId, cacheService)
			return
		}
	}
	log.Printf("%s: Run() finish\n", pipelineId)
	processSuccessRun(pipelineId, output, cacheService)
}

// finishByContext is used in case of runCode method finished by timeout
func finishByContext(pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: processCode finish because of ctxWithTimeout.Done\n", pipelineId)

	// set to cache pipelineId: cache.SubKey_Status: Status_STATUS_TIMEOUT
	setToCache(cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
}

// cleanUp removes all prepared folders for received LifeCycle
func cleanUp(pipelineId uuid.UUID, lc *fs_tool.LifeCycle) {
	log.Printf("%s: DeleteFolders() ...\n", pipelineId)
	err := lc.DeleteFolders()
	if err != nil {
		log.Printf("%s: DeleteFolders(): %s\n", pipelineId, err.Error())
	}
	log.Printf("%s: DeleteFolders() complete\n", pipelineId)
	log.Printf("%s: complete\n", pipelineId)
}

// processErrDuringValidate processes error received during Validate step
func processErrDuringValidate(err error, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: Validate: %s\n", pipelineId, err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
}

// processErrDuringCompile processes error received during Compile step
func processErrDuringCompile(err error, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: Compile: %s\n", pipelineId, err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)

	// set to cache pipelineId: cache.SubKey_CompileOutput: err.Error()
	setToCache(cacheService, pipelineId, cache.SubKey_CompileOutput, err.Error())
}

// processErrDuringGetExecutableName processes error received during getting executable file name
func processErrDuringGetExecutableName(err error, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: get executable file name: %s\n", pipelineId, err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
}

// processErrDuringRun processes error received during Run step
func processErrDuringRun(err error, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: Run: %s\n", pipelineId, err.Error())

	// set to cache pipelineId: cache.SubKey_RunOutput: err.Error()
	setToCache(cacheService, pipelineId, cache.Subkey_RunOutput, err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
}

// processSuccessRun processes case after successfully Run step
func processSuccessRun(pipelineId uuid.UUID, output string, cacheService cache.Cache) {
	// set to cache pipelineId: cache.SubKey_RunOutput: output
	setToCache(cacheService, pipelineId, cache.Subkey_RunOutput, output)

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_FINISHED
	setToCache(cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_FINISHED)
}

// setToCache puts value to cache by key and subKey
func setToCache(cacheService cache.Cache, key uuid.UUID, subKey cache.SubKey, value interface{}) {
	err := cacheService.SetValue(key, subKey, value)
	if err != nil {
		log.Printf("%s: cache.SetValue: %s\n", key, err.Error())
	}
}

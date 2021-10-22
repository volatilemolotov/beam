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
	pb "beam.apache.org/playground/backend/internal/api/v1"
	"beam.apache.org/playground/backend/internal/cache"
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/errors"
	"beam.apache.org/playground/backend/internal/executors"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"beam.apache.org/playground/backend/internal/validators"
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
	// check for correct sdk
	switch info.Sdk {
	case pb.Sdk_SDK_UNSPECIFIED, pb.Sdk_SDK_GO, pb.Sdk_SDK_PYTHON, pb.Sdk_SDK_SCIO:
		log.Printf("RunCode(): unimplemented sdk: %s\n", info.Sdk)
		return nil, errors.InvalidArgumentError("Run code()", "unimplemented sdk: "+info.Sdk.String())
	}

	pipelineId := uuid.New()

	defer func() {
		log.Printf("RunCode() is completed for pipeline with id: %s\n", pipelineId)
	}()

	cacheExpirationTime := controller.env.ApplicationEnvs.GetCacheExpirationTime()
	pipelineExecuteTimeout := controller.env.ApplicationEnvs.GetPipelineExecuteTimeout()

	// create file system service
	lc, err := fs_tool.NewLifeCycle(info.Sdk, pipelineId, controller.env.ApplicationEnvs.GetWorkingDir())
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

	filePath := lc.GetAbsoluteExecutableFilePath()
	workingDir := lc.GetAbsoluteExecutableFilesFolderPath()

	// create executor
	var val *[]validators.Validator
	switch info.Sdk {
	case pb.Sdk_SDK_JAVA:
		val = validators.GetJavaValidators(filePath)
	}
	exec := executors.NewExecutorBuilder().
		WithValidator().
		WithSdkValidators(val).
		WithCompiler().
		WithCommand(controller.env.BeamSdkEnvs.ExecutorConfig.CompileCmd).
		WithArgs(controller.env.BeamSdkEnvs.ExecutorConfig.CompileArgs).
		WithFileName(filePath).
		WithWorkingDir(workingDir)

	setToCache(ctx, controller.cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_EXECUTING)

	err = controller.cacheService.SetExpTime(ctx, pipelineId, cacheExpirationTime)
	if err != nil {
		log.Printf("%s: RunCode(): cache.SetExpTime(): %s\n", pipelineId, err.Error())
		return nil, errors.InternalError("Run code()", "Error during set expiration to cache: "+err.Error())
	}

	go processCode(context.TODO(), controller.cacheService, lc, exec, pipelineId, pipelineExecuteTimeout, controller.env.BeamSdkEnvs.ExecutorConfig)

	pipelineInfo := pb.RunCodeResponse{PipelineUuid: pipelineId.String()}
	return &pipelineInfo, nil
}

//CheckStatus is checking status for the specific pipeline by PipelineUuid
func (controller *playgroundController) CheckStatus(ctx context.Context, info *pb.CheckStatusRequest) (*pb.CheckStatusResponse, error) {
	pipelineId := info.PipelineUuid
	statusInterface, err := controller.cacheService.GetValue(ctx, uuid.MustParse(pipelineId), cache.SubKey_Status)
	if err != nil {
		log.Printf("%s: CheckStatus(): cache.GetValue: error: %s", pipelineId, err.Error())
		return nil, errors.NotFoundError("CheckStatus", "Error during getting cache by pipelineId: "+pipelineId+", subKey: cache.SubKey_Status")
	}
	status, converted := statusInterface.(pb.Status)
	if !converted {
		return nil, errors.InternalError("CheckStatus", "status value from cache couldn't be converted to correct status enum")
	}
	return &pb.CheckStatusResponse{Status: status}, nil
}

//GetRunOutput is returning output of execution for specific pipeline by PipelineUuid
func (controller *playgroundController) GetRunOutput(ctx context.Context, info *pb.GetRunOutputRequest) (*pb.GetRunOutputResponse, error) {
	pipelineId := info.PipelineUuid
	runOutputInterface, err := controller.cacheService.GetValue(ctx, uuid.MustParse(pipelineId), cache.SubKey_RunOutput)
	if err != nil {
		log.Printf("%s: GetRunOutput(): cache.GetValue: error: %s", pipelineId, err.Error())
		return nil, errors.NotFoundError("GetRunOutput", "there is no run output for pipelineId: "+pipelineId+", subKey: cache.SubKey_RunOutput")
	}
	runOutput, converted := runOutputInterface.(string)
	if !converted {
		return nil, errors.InternalError("GetRunOutput", "run output can't be converted to string")
	}
	pipelineResult := pb.GetRunOutputResponse{Output: runOutput}
	return &pipelineResult, nil
}

//GetCompileOutput is returning output of compilation for specific pipeline by PipelineUuid
func (controller *playgroundController) GetCompileOutput(ctx context.Context, info *pb.GetCompileOutputRequest) (*pb.GetCompileOutputResponse, error) {
	pipelineId := info.PipelineUuid
	compileOutputInterface, err := controller.cacheService.GetValue(ctx, uuid.MustParse(pipelineId), cache.SubKey_CompileOutput)
	if err != nil {
		log.Printf("%s: GetCompileOutput(): cache.GetValue: error: %s", pipelineId, err.Error())
		return nil, errors.NotFoundError("GetCompileOutput", "there is no compile output for pipelineId: "+pipelineId+", subKey: cache.SubKey_CompileOutput")
	}
	compileOutput, converted := compileOutputInterface.(string)
	if !converted {
		return nil, errors.InternalError("GetCompileOutput", "compile output can't be converted to string")
	}
	pipelineResult := pb.GetCompileOutputResponse{Output: compileOutput}

	return &pipelineResult, nil
}

// processCode validates, compiles and runs code by pipelineId.
// During each operation updates status of execution and saves it into cache.
// In case of some step is failed saves output logs to cache.
// After success code running saves output to cache.
// At the end of this method deletes all created folders
func processCode(ctx context.Context, cacheService cache.Cache, lc *fs_tool.LifeCycle, execBuilder *executors.CompileBuilder, pipelineId uuid.UUID, timeout time.Duration, execConfig *environment.ExecutorConfig) {
	ctxWithTimeout, cancelByTimeoutFunc := context.WithTimeout(ctx, timeout)
	defer func(lc *fs_tool.LifeCycle) {
		cancelByTimeoutFunc()
		cleanUp(pipelineId, lc)
	}(lc)

	errorChannel := make(chan error, 1)
	dataChannel := make(chan interface{}, 1)
	doneChannel := make(chan bool, 1)

	exec := execBuilder.Build()

	// validate
	log.Printf("%s: Validate() ...\n", pipelineId)
	validateFunc := exec.Validate()
	go validateFunc(doneChannel, errorChannel)

	select {
	case <-ctxWithTimeout.Done():
		finishByContext(ctxWithTimeout, pipelineId, cacheService)
		return
	case ok := <-doneChannel:
		if !ok {
			// error during validation
			err := <-errorChannel
			processErrDuringValidate(ctxWithTimeout, err.(error), pipelineId, cacheService)
			return
		}
	}
	log.Printf("%s: Validate() finish\n", pipelineId)

	// compile
	log.Printf("%s: Compile() ...\n", pipelineId)
	compileCmd := exec.Compile(ctxWithTimeout)
	go func(doneCh chan bool, errCh chan error, dataCh chan interface{}) {
		data, err := compileCmd.CombinedOutput()
		if err != nil {
			dataCh <- data
			errCh <- err
			doneCh <- false
		} else {
			doneCh <- true
		}
	}(doneChannel, errorChannel, dataChannel)

	select {
	case <-ctxWithTimeout.Done():
		finishByContext(ctxWithTimeout, pipelineId, cacheService)
		return
	case ok := <-doneChannel:
		if !ok {
			// error during compilation
			data := <-dataChannel
			err := <-errorChannel
			processErrDuringCompile(ctxWithTimeout, err.(error), data.([]byte), pipelineId, cacheService)
			return
		}
	}
	log.Printf("%s: Compile() finish\n", pipelineId)

	// set empty value to pipelineId: cache.SubKey_CompileOutput
	setToCache(ctxWithTimeout, cacheService, pipelineId, cache.SubKey_CompileOutput, "")

	className, err := lc.GetExecutableName()
	if err != nil {
		processErrDuringGetExecutableName(ctxWithTimeout, err, pipelineId, cacheService)
		return
	}

	exec = execBuilder.
		WithRunner().
		WithCommand(execConfig.RunCmd).
		WithArgs(execConfig.RunArgs).
		WithClassName(className).
		WithWorkingDir(lc.GetAbsoluteExecutableFilesFolderPath()).
		Build()

	log.Printf("%s: Run() ...\n", pipelineId)
	runCmd := exec.Run(ctxWithTimeout)
	go func(doneCh chan bool, errCh chan error, dataCh chan interface{}) {
		data, err := runCmd.CombinedOutput()
		dataCh <- data
		if err != nil {
			errCh <- err
			doneCh <- false
		} else {
			doneCh <- true
		}
	}(doneChannel, errorChannel, dataChannel)

	select {
	case <-ctxWithTimeout.Done():
		finishByContext(ctxWithTimeout, pipelineId, cacheService)
		return
	case ok := <-doneChannel:
		data := <-dataChannel
		if !ok {
			// error during run code
			err := <-errorChannel
			processErrDuringRun(ctxWithTimeout, err.(error), data.([]byte), pipelineId, cacheService)
			return
		}
		log.Printf("%s: Run() finish\n", pipelineId)
		processSuccessRun(ctxWithTimeout, pipelineId, data.([]byte), cacheService)
	}
}

// finishByContext is used in case of runCode method finished by timeout
func finishByContext(ctx context.Context, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: processCode finish because of ctxWithTimeout.Done\n", pipelineId)

	// set to cache pipelineId: cache.SubKey_Status: Status_STATUS_TIMEOUT
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
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
func processErrDuringValidate(ctx context.Context, err error, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: Validate: %s\n", pipelineId, err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
}

// processErrDuringCompile processes error received during Compile step
func processErrDuringCompile(ctx context.Context, err error, data []byte, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: Compile: err: %s, output: %s\n", pipelineId, err.Error(), data)

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)

	// set to cache pipelineId: cache.SubKey_CompileOutput: err.Error()
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_CompileOutput, "error: "+err.Error()+", output: "+string(data))
}

// processErrDuringGetExecutableName processes error received during getting executable file name
func processErrDuringGetExecutableName(ctx context.Context, err error, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: get executable file name: %s\n", pipelineId, err.Error())

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)
}

// processErrDuringRun processes error received during Run step
func processErrDuringRun(ctx context.Context, err error, data []byte, pipelineId uuid.UUID, cacheService cache.Cache) {
	log.Printf("%s: Run: err: %s, output: %s\n", pipelineId, err.Error(), data)

	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_ERROR
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_ERROR)

	// set to cache pipelineId: cache.SubKey_RunOutput: err.Error()
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_RunOutput, "error: "+err.Error()+", output: "+string(data))
}

// processSuccessRun processes case after successfully Run step
func processSuccessRun(ctx context.Context, pipelineId uuid.UUID, output []byte, cacheService cache.Cache) {
	// set to cache pipelineId: cache.SubKey_Status: pb.Status_STATUS_FINISHED
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_Status, pb.Status_STATUS_FINISHED)

	// set to cache pipelineId: cache.SubKey_RunOutput: output
	setToCache(ctx, cacheService, pipelineId, cache.SubKey_RunOutput, string(output))
}

// setToCache puts value to cache by key and subKey
func setToCache(ctx context.Context, cacheService cache.Cache, key uuid.UUID, subKey cache.SubKey, value interface{}) {
	err := cacheService.SetValue(ctx, key, subKey, value)
	if err != nil {
		log.Printf("%s: cache.SetValue: %s\n", key, err.Error())
	}
}

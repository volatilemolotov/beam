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
	"beam.apache.org/playground/backend/internal/executors"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"context"
	"fmt"
	"github.com/google/uuid"
	"google.golang.org/grpc"
	"google.golang.org/grpc/test/bufconn"
	"log"
	"net"
	"os"
	"reflect"
	"testing"
	"time"
)

const bufSize = 1024 * 1024

var lis *bufconn.Listener
var cacheService cache.Cache

func TestMain(m *testing.M) {
	server := setup()
	defer teardown(server)
	m.Run()
}

func setup() *grpc.Server {
	lis = bufconn.Listen(bufSize)
	s := grpc.NewServer()
	var err error
	cacheService, err = cache.NewCache(context.Background(), "")
	if err != nil {
		panic(err)
	}
	pb.RegisterPlaygroundServiceServer(s, &playgroundController{
		env:          environment.NewEnvironment(),
		cacheService: cacheService,
	})
	go func() {
		if err := s.Serve(lis); err != nil {
			log.Fatalf("Server exited with error: %v", err)
		}
	}()
	return s
}

func teardown(server *grpc.Server) {
	server.Stop()
}

func bufDialer(context.Context, string) (net.Conn, error) {
	return lis.Dial()
}

func TestPlaygroundController_RunCode(t *testing.T) {
	type args struct {
		ctx     context.Context
		request *pb.RunCodeRequest
	}
	tests := []struct {
		name       string
		args       args
		wantStatus pb.Status
		wantErr    bool
	}{
		{
			name: "RunCode with incorrect sdk",
			args: args{
				ctx: context.Background(),
				request: &pb.RunCodeRequest{
					Code: "MOCK_CODE",
					Sdk:  pb.Sdk_SDK_UNSPECIFIED,
				},
			},
			wantErr: true,
		},
		{
			name: "RunCode with correct sdk",
			args: args{
				ctx: context.Background(),
				request: &pb.RunCodeRequest{
					Code: "MOCK_CODE",
					Sdk:  pb.Sdk_SDK_JAVA,
				},
			},
			wantStatus: pb.Status_STATUS_EXECUTING,
			wantErr:    false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			conn, err := grpc.DialContext(tt.args.ctx, "bufnet", grpc.WithContextDialer(bufDialer), grpc.WithInsecure())
			if err != nil {
				t.Fatalf("Failed to dial bufnet: %v", err)
			}
			defer conn.Close()
			client := pb.NewPlaygroundServiceClient(conn)
			response, err := client.RunCode(tt.args.ctx, tt.args.request)
			if (err != nil) != tt.wantErr {
				t.Errorf("PlaygroundController_RunCode() error = %v, wantErr %v", err, tt.wantErr)
			}
			if err == nil {
				if response == nil {
					t.Errorf("PlaygroundController_RunCode() response shoudn't be nil")
				} else {
					if response.PipelineUuid == "" {
						t.Errorf("PlaygroundController_RunCode() response.pipeLineId shoudn't be nil")
					} else {
						path := "internal/executable_files_" + response.PipelineUuid
						os.RemoveAll(path)
					}
					status, _ := cacheService.GetValue(tt.args.ctx, uuid.MustParse(response.PipelineUuid), cache.SubKey_Status)
					if status == nil {
						t.Errorf("PlaygroundController_RunCode() status shoudn't be nil")
					}
					if !reflect.DeepEqual(status, tt.wantStatus) {
						t.Errorf("PlaygroundController_RunCode() status = %v, wantStatus %v", status, tt.wantStatus)
					}
				}
			}
		})
	}
}

func TestPlaygroundController_CheckStatus(t *testing.T) {
	ctx := context.Background()
	conn, err := grpc.DialContext(ctx, "bufnet", grpc.WithContextDialer(bufDialer), grpc.WithInsecure())
	if err != nil {
		t.Fatalf("Failed to dial bufnet: %v", err)
	}
	defer conn.Close()
	client := pb.NewPlaygroundServiceClient(conn)
	pipelineMeta := pb.CheckStatusRequest{
		PipelineUuid: uuid.NewString(),
	}
	status, err := client.CheckStatus(ctx, &pipelineMeta)
	if err != nil {
		t.Fatalf("runCode failed: %v", err)
	}
	log.Printf("Response: %+v", status)
}

func TestPlaygroundController_GetCompileOutput(t *testing.T) {
	ctx := context.Background()
	conn, err := grpc.DialContext(ctx, "bufnet", grpc.WithContextDialer(bufDialer), grpc.WithInsecure())
	if err != nil {
		t.Fatalf("Failed to dial bufnet: %v", err)
	}
	defer conn.Close()
	client := pb.NewPlaygroundServiceClient(conn)
	pipelineMeta := pb.GetCompileOutputRequest{
		PipelineUuid: uuid.NewString(),
	}
	compileOutput, err := client.GetCompileOutput(ctx, &pipelineMeta)
	if err != nil {
		t.Fatalf("runCode failed: %v", err)
	}
	log.Printf("Response: %+v", compileOutput)
}

func TestPlaygroundController_GetRunOutput(t *testing.T) {
	ctx := context.Background()
	conn, err := grpc.DialContext(ctx, "bufnet", grpc.WithContextDialer(bufDialer), grpc.WithInsecure())
	if err != nil {
		t.Fatalf("Failed to dial bufnet: %v", err)
	}
	defer conn.Close()
	client := pb.NewPlaygroundServiceClient(conn)
	pipelineMeta := pb.GetRunOutputRequest{
		PipelineUuid: uuid.NewString(),
	}
	runOutput, err := client.GetRunOutput(ctx, &pipelineMeta)
	if err != nil {
		t.Fatalf("runCode failed: %v", err)
	}
	log.Printf("Response: %+v", runOutput)
}

func Test_processCode(t *testing.T) {
	cacheService, _ := cache.NewCache(context.Background(), "")
	type args struct {
		ctx     context.Context
		timeout time.Duration
	}
	tests := []struct {
		name              string
		createExecFile    bool
		code              string
		expectedStatus    pb.Status
		expectedRunOutput interface {
		}
		expectedCompileOutput interface {
		}
		args args
	}{
		{
			name:                  "small pipeline execution timeout",
			createExecFile:        false,
			code:                  "",
			expectedStatus:        pb.Status_STATUS_ERROR,
			expectedCompileOutput: nil,
			expectedRunOutput:     nil,
			args: args{
				ctx:     context.Background(),
				timeout: 0,
			},
		},
		{
			name:                  "validation failed",
			createExecFile:        false,
			code:                  "",
			expectedStatus:        pb.Status_STATUS_ERROR,
			expectedCompileOutput: nil,
			expectedRunOutput:     nil,
			args: args{
				ctx:     context.Background(),
				timeout: time.Second * 100,
			},
		},
		{
			name:                  "compilation failed",
			createExecFile:        true,
			code:                  "MOCK_CODE",
			expectedStatus:        pb.Status_STATUS_ERROR,
			expectedCompileOutput: "Compilation error: src/%s.java:1: error: reached end of file while parsing\nMOCK_CODE\n^\n1 error\n",
			expectedRunOutput:     nil,
			args: args{
				ctx:     context.Background(),
				timeout: time.Second * 100,
			},
		},
		{
			name:                  "run failed",
			createExecFile:        true,
			code:                  "class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(1/0);\n    }\n}",
			expectedStatus:        pb.Status_STATUS_ERROR,
			expectedCompileOutput: "",
			expectedRunOutput:     "exit status 1",
			args: args{
				ctx:     context.Background(),
				timeout: time.Second * 100,
			},
		},
		{
			name:                  "all success",
			createExecFile:        true,
			code:                  "class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello world!\");\n    }\n}",
			expectedStatus:        pb.Status_STATUS_FINISHED,
			expectedCompileOutput: "",
			expectedRunOutput:     "Hello world!\n",
			args: args{
				ctx:     context.Background(),
				timeout: time.Second * 100,
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			pipelineId := uuid.New()
			lc, _ := fs_tool.NewLifeCycle(pb.Sdk_SDK_JAVA, pipelineId)
			err := lc.CreateFolders()
			if err != nil {
				t.Fatalf("error during prepare folders: %s", err.Error())
			}
			exec, _ := executors.NewExecutor(pb.Sdk_SDK_JAVA, lc)

			if tt.createExecFile {
				_, _ = lc.CreateExecutableFile(tt.code)
			}

			processCode(tt.args.ctx, cacheService, lc, exec, pipelineId, tt.args.timeout)

			status, _ := cacheService.GetValue(tt.args.ctx, pipelineId, cache.SubKey_Status)
			if !reflect.DeepEqual(status, tt.expectedStatus) {
				t.Errorf("processCode() set status: %s, but expectes: %s", status, tt.expectedStatus)
			}

			compileOutput, _ := cacheService.GetValue(tt.args.ctx, pipelineId, cache.SubKey_CompileOutput)
			if compileOutput == nil || compileOutput.(string) == "" {
				if !reflect.DeepEqual(compileOutput, tt.expectedCompileOutput) {
					t.Errorf("processCode() set compileOutput: %s, but expectes: %s", compileOutput, tt.expectedCompileOutput)
				}
			} else {
				if !reflect.DeepEqual(compileOutput, fmt.Sprintf(tt.expectedCompileOutput.(string), pipelineId)) {
					t.Errorf("processCode() set compileOutput: %s, but expectes: %s", compileOutput, tt.expectedCompileOutput)
				}
			}

			runOutput, _ := cacheService.GetValue(tt.args.ctx, pipelineId, cache.SubKey_RunOutput)
			if !reflect.DeepEqual(runOutput, tt.expectedRunOutput) {
				t.Errorf("processCode() set runOutput: %s, but expectes: %s", runOutput, tt.expectedRunOutput)
			}
		})
	}
}

func Test_processErrDuringGetExecutableName(t *testing.T) {
	cacheService, _ := cache.NewCache(context.Background(), "")
	type args struct {
		err        error
		pipelineId uuid.UUID
	}
	tests := []struct {
		name string
		args args
	}{
		{
			name: "all success",
			args: args{
				err:        fmt.Errorf("MOCK_ERROR"),
				pipelineId: uuid.New(),
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			value, err := cacheService.GetValue(context.Background(), tt.args.pipelineId, cache.SubKey_Status)
			if value != nil {
				t.Errorf("processErrDuringGetExecutableName() value should be: nil, but receive: %s", value)
			}
			if err == nil {
				t.Errorf("processErrDuringGetExecutableName() err should not be nil, but receive: %s", err)
			}

			processErrDuringGetExecutableName(context.Background(), tt.args.err, tt.args.pipelineId, cacheService)

			value, _ = cacheService.GetValue(context.Background(), tt.args.pipelineId, cache.SubKey_Status)
			if !reflect.DeepEqual(value, pb.Status_STATUS_ERROR) {
				t.Errorf("processErrDuringGetExecutableName() value : %s, but want: %s", value, pb.Status_STATUS_ERROR)
			}
		})
	}
}

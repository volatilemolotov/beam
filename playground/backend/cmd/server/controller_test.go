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
	"context"
	"github.com/google/uuid"
	"google.golang.org/grpc"
	"google.golang.org/grpc/test/bufconn"
	"log"
	"net"
	"testing"
	"time"
)

const bufSize = 1024 * 1024

var lis *bufconn.Listener

func TestMain(m *testing.M) {
	server := setup()
	defer teardown(server)
	m.Run()
}

func setup() *grpc.Server {
	lis = bufconn.Listen(bufSize)
	s := grpc.NewServer()
	pb.RegisterPlaygroundServiceServer(s, &playgroundController{})
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
	ctx := context.Background()
	conn, err := grpc.DialContext(ctx, "bufnet", grpc.WithContextDialer(bufDialer), grpc.WithInsecure())
	if err != nil {
		t.Fatalf("Failed to dial bufnet: %v", err)
	}
	defer conn.Close()
	client := pb.NewPlaygroundServiceClient(conn)
	code := pb.RunCodeRequest{
		Code: "class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World!\");\n    }\n}",
		Sdk:  pb.Sdk_SDK_JAVA,
	}
	pipelineMeta, err := client.RunCode(ctx, &code)
	if err != nil {
		t.Fatalf("runCode failed: %v", err)
	}
	log.Printf("Response RUN_CODE: %+v", pipelineMeta)
	time.Sleep(time.Minute)

	request := pb.CheckStatusRequest{
		PipelineUuid: pipelineMeta.PipelineUuid,
	}
	status, err := client.CheckStatus(ctx, &request)
	if err != nil {
		t.Fatalf("runCode failed: %v", err)
	}
	log.Printf("Response CHECK_STATUS: %+v", status)

	requestCompileOutput := pb.GetCompileOutputRequest{
		PipelineUuid: pipelineMeta.PipelineUuid,
	}
	compileOutput, err := client.GetCompileOutput(ctx, &requestCompileOutput)
	if err == nil {
		t.Fatalf("getCompileOutput failed: %+v", compileOutput)
	}
	log.Printf("Error: %+v", err)

	requestRunOutput := pb.GetRunOutputRequest{
		PipelineUuid: pipelineMeta.PipelineUuid,
	}
	statusRunOutput, err := client.GetRunOutput(ctx, &requestRunOutput)
	if err != nil {
		t.Fatalf("getRunOutput failed: %v", err)
	}
	log.Printf("Response GET_RUN_OUTPUT: %+v", statusRunOutput)
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

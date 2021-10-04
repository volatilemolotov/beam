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
	pb "beam.apache.org/playground/backend/pkg/api"
	"beam.apache.org/playground/backend/pkg/environment"
	"beam.apache.org/playground/backend/pkg/executors"
	"beam.apache.org/playground/backend/pkg/fs_tool"
	"fmt"
	"github.com/improbable-eng/grpc-web/go/grpcweb"
	"google.golang.org/grpc"
	"google.golang.org/grpc/grpclog"
)

// runServer is starting http server wrapped on grpc
func runServer() error {
	envService := environment.NewService(nil)
	executor, err := getExecutor(envService.BeamSdkEnvs)
	if err != nil {
		return err
	}
	grpcServer := grpc.NewServer()
	controller := newPlaygroundController(executor)
	pb.RegisterPlaygroundServiceServer(grpcServer, controller)

	setupLogger(envService.LogWriters)
	handler := Wrap(grpcServer, getGrpcWebOptions())
	errChan := make(chan error)

	go listenHttp(errChan, envService.ServerEnvs, handler)
	err = <-errChan
	return err
}

// getGrpcWebOptions returns grpcweb options needed to configure wrapper
func getGrpcWebOptions() []grpcweb.Option {
	return []grpcweb.Option{
		grpcweb.WithCorsForRegisteredEndpointsOnly(false),
		grpcweb.WithAllowNonRootResource(true),
		grpcweb.WithOriginFunc(func(origin string) bool {
			return true
		}),
	}

}

// setupLogger is configuring grpc logger using LoggerV2
func setupLogger(writers environment.LogWriters) {
	grpclog.SetLoggerV2(grpclog.NewLoggerV2(
		writers.InfoWriter,
		writers.WarningWriter,
		writers.ErrorWriter))
}

// getExecutor is a factory for executors. Returns executor based on environment.BeamEnvs
func getExecutor(sdk environment.BeamEnvs) (executors.Executor, error) {
	switch sdk.ApacheBeamSdk {
	case pb.Sdk_SDK_JAVA:
		return executors.NewJavaExecutor(&fs_tool.JavaFileSystemService{}), nil
	default:
		return nil, fmt.Errorf("%s isn't supported now", sdk)

	}

}

func main() {
	err := runServer()
	if err != nil {
		panic(err)
	}
}

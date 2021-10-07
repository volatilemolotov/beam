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
	"google.golang.org/grpc"
	"google.golang.org/grpc/grpclog"
)

func runServer() error {
	grpcServer := grpc.NewServer()
	// TODO need to implement selecting executor based on os env var
	controller := playgroundController{executor: executors.JavaExecutor{}}
	pb.RegisterPlaygroundServiceServer(grpcServer, &controller)
	envService := environment.NewService(nil)
	grpclog.SetLoggerV2(grpclog.NewLoggerV2(
		envService.LogWriters.InfoWriter,
		envService.LogWriters.WarningWriter,
		envService.LogWriters.ErrorWriter))
	handler := Wrap(grpcServer)
	errChan := make(chan error)

	go listenHttp(errChan, envService.ServerEnvs, handler)
	for {
		select {
		case err := <-errChan:
			return err
		}
	}
}

func main() {
	err := runServer()
	if err != nil {
		panic(err)
	}
}

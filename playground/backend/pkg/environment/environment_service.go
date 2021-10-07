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

package environment

import (
	pb "beam.apache.org/playground/backend/pkg/api"
	"google.golang.org/grpc/grpclog"
	"os"
	"strconv"
)

const (
	serverIpKey   = "SERVER_IP"
	serverPortKey = "SERVER_PORT"
	beamSdkKey    = "BEAM_SDK"
	defaultIp     = "localhost"
	defaultPort   = 8080
	defaultSdk    = pb.Sdk_SDK_JAVA
)

type Service struct {
	ServerEnvs  ServerEnvs
	LogWriters  LogWriters
	BeamSdkEnvs BeamSdk
}

func NewService(writers *LogWriters) *Service {
	if writers == nil {
		writers = NewLogWriters(os.Stdout, os.Stdout, os.Stderr)
	}
	svc := Service{LogWriters: *writers}
	svc.initServerEnvsFromOsEnvs()
	svc.initSdkEnvsFromOsEnvs()

	return &svc
}

func (svc *Service) initServerEnvsFromOsEnvs() {
	ip := defaultIp
	port := defaultPort
	if value, present := os.LookupEnv(serverIpKey); present == true {
		ip = value
	}

	if value, present := os.LookupEnv(serverPortKey); present == true {
		if converted, err := strconv.Atoi(value); err != nil {
			port = converted
		} else {
			grpclog.Errorf("couldn't convert provided port. Using default %s\n", defaultPort)
		}
	}

	svc.ServerEnvs = *NewServerEnvs(ip, port)
}

func (svc *Service) initSdkEnvsFromOsEnvs() {
	sdk := pb.Sdk_SDK_UNSPECIFIED
	if value, present := os.LookupEnv(beamSdkKey); present == true {

		switch value {
		case pb.Sdk_SDK_JAVA.String():
			sdk = pb.Sdk_SDK_JAVA
		case pb.Sdk_SDK_GO.String():
			sdk = pb.Sdk_SDK_GO
		case pb.Sdk_SDK_PYTHON.String():
			sdk = pb.Sdk_SDK_PYTHON
		case pb.Sdk_SDK_SCIO.String():
			sdk = pb.Sdk_SDK_SCIO
		}
	}
	if sdk == pb.Sdk_SDK_UNSPECIFIED {
		grpclog.Infof("couldn't get sdk from %s os env, using default: %s", beamSdkKey, defaultSdk)
	}

	svc.BeamSdkEnvs = *NewBeamSdk(sdk)
}

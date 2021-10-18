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
	pb "beam.apache.org/playground/backend/internal/api"
	"google.golang.org/grpc/grpclog"
	"os"
	"strconv"
	"time"
)

const (
	serverIpKey                   = "SERVER_IP"
	serverPortKey                 = "SERVER_PORT"
	beamSdkKey                    = "BEAM_SDK"
	cacheExpirationKey            = "CACHE_EXPIRATION"
	pipelineExecuteTimeoutKey     = "PIPELINE_EXECUTION_TIMEOUT"
	defaultIp                     = "localhost"
	defaultPort                   = 8080
	defaultSdk                    = pb.Sdk_SDK_JAVA
	defaultCacheExpiration        = time.Minute * 30
	defaultPipelineExecuteTimeout = time.Minute * 10
)

// Environment operates with environment structures: ServerEnvs, LogWriters, BeamEnvs
type Environment struct {
	ServerEnvs      ServerEnvs
	BeamSdkEnvs     BeamEnvs
	cacheExpiration time.Duration
}

// NewEnvironment is a constructor for Environment.
// Default values:
// LogWriters: by default using os.Stdout
// ServerEnvs: by default using defaultIp and defaultPort from constants
// BeamEnvs: by default using pb.Sdk_SDK_JAVA
func NewEnvironment() *Environment {
	svc := Environment{}
	svc.ServerEnvs = *getServerEnvsFromOsEnvs()
	svc.BeamSdkEnvs = *getSdkEnvsFromOsEnvs()
	svc.cacheExpiration = getCacheExpirationFromEnvs()

	return &svc
}

// getServerEnvsFromOsEnvs lookups in os environment variables and takes value for ip and port. If not exists - using default
func getServerEnvsFromOsEnvs() *ServerEnvs {
	ip := defaultIp
	port := defaultPort
	pipelineExecuteTimeout := defaultPipelineExecuteTimeout

	if value, present := os.LookupEnv(serverIpKey); present {
		ip = value
	}

	if value, present := os.LookupEnv(serverPortKey); present {
		if converted, err := strconv.Atoi(value); err == nil {
			port = converted
		} else {
			grpclog.Errorf("couldn't convert provided port. Using default %s\n", defaultPort)
		}
	}

	if value, present := os.LookupEnv(pipelineExecuteTimeoutKey); present {
		if converted, err := time.ParseDuration(value); err == nil {
			pipelineExecuteTimeout = converted
		} else {
			grpclog.Errorf("couldn't convert provided request timeout. Using default %s\n", defaultPipelineExecuteTimeout)
		}
	}

	return NewServerEnvs(ip, port, pipelineExecuteTimeout)
}

// getServerEnvsFromOsEnvs lookups in os environment variables and takes value for Apache Beam SDK. If not exists - using default
func getSdkEnvsFromOsEnvs() *BeamEnvs {
	sdk := pb.Sdk_SDK_UNSPECIFIED
	if value, present := os.LookupEnv(beamSdkKey); present {

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
		sdk = defaultSdk
	}

	return NewBeamEnvs(sdk)
}

// getCacheExpirationFromEnvs lookups in os environment variables and takes value for cache expiration time. If not exists - using default
func getCacheExpirationFromEnvs() time.Duration {
	cacheExpiration := defaultCacheExpiration
	if value, present := os.LookupEnv(cacheExpirationKey); present {
		if converted, err := time.ParseDuration(value); err == nil {
			cacheExpiration = converted
		} else {
			grpclog.Errorf("couldn't convert provided cache expiration. Using default %s\n", defaultCacheExpiration)
		}
	}
	return cacheExpiration
}

// GetCacheExpirationTime returns cache expiration time from environment
func (e *Environment) GetCacheExpirationTime() time.Duration {
	return e.cacheExpiration
}

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
	"github.com/tkanos/gonfig"
	"os"
	"strings"
)

// CmdConfig contains needed for compiling and execution of the code commands
type CmdConfig struct {
	CompileCmd  string   `json:"compile_cmd"`
	RunCmd      string   `json:"run_cmd"`
	CompileArgs []string `json:"compile_args"`
	RunArgs     []string `json:"run_args"`
}

// BeamEnvs contains all environments related of ApacheBeam. These will use to run pipelines
type BeamEnvs struct {
	ApacheBeamSdk pb.Sdk
	CmdConfig     *CmdConfig
}

// NewBeamEnvs is a BeamEnvs constructor
func NewBeamEnvs(apacheBeamSdk pb.Sdk) *BeamEnvs {
	config := readConfig(apacheBeamSdk)
	return &BeamEnvs{ApacheBeamSdk: apacheBeamSdk, CmdConfig: config}
}

func readConfig(apacheBeamSdk pb.Sdk) *CmdConfig {
	cmdConfig := getCmdConfig(apacheBeamSdk)
	switch apacheBeamSdk {
	case pb.Sdk_SDK_JAVA:
		cmdConfig.CompileArgs = append(cmdConfig.CompileArgs,
			getEnv("BEAM_SDK", "/opt/apache/beam/jars/beam-sdks-java-harness.jar"))
		jars := strings.Join([]string{
			getEnv("BEAM_SDK", "/opt/apache/beam/jars/beam-sdks-java-harness.jar"),
			getEnv("BEAM_RUNNER", "/opt/apache/beam/jars/beam-runners-direct.jar"),
			getEnv("JDK", "/opt/apache/beam/jars/slf4j-jdk14.jar"),
		}, ":")
		cmdConfig.RunArgs[1] += jars
	case pb.Sdk_SDK_GO:
	case pb.Sdk_SDK_PYTHON:
	case pb.Sdk_SDK_SCIO:
	}

	return &cmdConfig
}

func getCmdConfig(apacheBeamSdk pb.Sdk) CmdConfig {
	path, err := os.Getwd()
	if err != nil {
		panic(err)
	}
	CmdConfigPath := path + "/playground/backend/internal/environment/configs/" + apacheBeamSdk.String() + ".json"
	cmdConfig := CmdConfig{}
	err = gonfig.GetConf(CmdConfigPath, &cmdConfig)
	if err != nil {
		panic(err)
	}
	return cmdConfig
}

func getEnv(key, fallback string) string {
	if value, ok := os.LookupEnv(key); ok {
		return value
	}
	return fallback
}

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

package executors

import (
	pb "beam.apache.org/playground/backend/internal/api"
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"beam.apache.org/playground/backend/internal/validators"
	"github.com/google/uuid"
)

func ExampleOfExecutorUsage() {
	exec := Executor{}
	cycle, err := fs_tool.NewLifeCycle(pb.Sdk_SDK_JAVA, uuid.New())
	cycle.CreateFolders()
	cycle.CreateExecutableFile("exampleOfExecutorUsage")
	if err != nil {
		return
	}
	env := environment.NewEnvironment()
	ConfigureSDK(&exec, env.BeamSdkEnvs, cycle.Folder.BaseFolder, validators.GetJavaValidators(cycle.GetAbsoluteExecutableFilePath()))

	applyValidators := exec.Validate()
	go func() {
		err := applyValidators()
		if err != nil {

		}
	}()

	compileCmd := exec.Compile()
	go func() {
		_, err := compileCmd.Output()
		if err != nil {

		}
	}()

	runCmd := exec.Run("HelloWorld")

	go func() {
		_, err := runCmd.Output()
		if err != nil {

		}
	}()

}

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

// Package executors
package executors

import (
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/validators"
)

// ConfigureSDK fills up an executor with Cmd arguments
func ConfigureSDK(exec *Executor, envs environment.BeamEnvs, workingDir string, validatorsFuncs *[]validators.Validator) {
	if validatorsFuncs == nil {
		v := make([]validators.Validator, 0)
		validatorsFuncs = &v
	}
	exec.validators = *validatorsFuncs
	exec.dirPath = workingDir
	exec.compileCommand = envs.CmdConfig.CompileCmd
	exec.runCommand = envs.CmdConfig.RunCmd
	exec.compileArgs = envs.CmdConfig.CompileArgs
	exec.runArgs = envs.CmdConfig.RunArgs

}

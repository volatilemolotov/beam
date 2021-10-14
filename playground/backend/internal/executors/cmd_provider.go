package executors// Licensed to the Apache Software Foundation (ASF) under one or more
import (
	"beam.apache.org/playground/backend/internal/validators"
	"os/exec"
)

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
"os/exec"
)

// CmdProvider struct for all executors (Java/Python/Go/SCIO)
type CmdProvider struct {
	dirPath        string
	validators     []validators.Validator
	compileCommand string
	compileArgs    []string
	runCommand     string
	runArgs        []string
}

// NewCmdProvider fills up an executor with Cmd arguments
func NewCmdProvider(envs environment.BeamEnvs, workingDir string, filePath string, validatorsFuncs *[]validators.Validator) *CmdProvider {
	provider := CmdProvider{}
	if validatorsFuncs == nil {
		v := make([]validators.Validator, 0)
		validatorsFuncs = &v
	}
	compileArgs := append(envs.CmdConfig.CompileArgs, filePath)
	provider.validators = *validatorsFuncs
	provider.dirPath = workingDir
	provider.compileCommand = envs.CmdConfig.CompileCmd
	provider.runCommand = envs.CmdConfig.RunCmd
	provider.compileArgs = compileArgs
	provider.runArgs = envs.CmdConfig.RunArgs
	return &provider
}

// Validators return the function that apply all validators of executor
func (ex *CmdProvider) Validators() func() error {
	return func() error {
		for _, validator := range ex.validators {
			err := validator.Validator(validator.Args...)
			if err != nil {
				return err
			}
		}

		return nil
	}
}

// Compile prepares the Cmd for code compilation
// Returns Cmd instance
func (ex *CmdProvider) Compile() *exec.Cmd {
	cmd := exec.Command(ex.compileCommand, ex.compileArgs...)
	cmd.Dir = ex.dirPath
	return cmd
}

// Run prepares the Cmd for execution of the code
// Returns Cmd instance
func (ex *CmdProvider) Run(name string) *exec.Cmd {
	args := append(ex.runArgs, name)
	cmd := exec.Command(ex.runCommand, args...)
	cmd.Dir = ex.dirPath
	return cmd
}


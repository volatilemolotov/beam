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
	"beam.apache.org/playground/backend/internal/validators"
	"os/exec"
)

// Executor interface for all executors (Java/Python/Go/SCIO)
type Executor struct {
	relativeFilePath string
	absoulteFilePath string
	dirPath          string
	executableDir    string
	validators       []validators.Validator
	compileCommand   string
	compileArgs      []string
	runCommand       string
	runArgs          []string
}

// Validate checks that the file exists and that extension of the file matches the SDK.
// Return function that apply any validators
func (ex *Executor) Validate() func() error {
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

// Compile compiles the code and creates executable file.
// Return error if it occurs
func (ex *Executor) Compile() *exec.Cmd {
	cmd := exec.Command(ex.compileCommand, ex.compileArgs...)
	cmd.Dir = ex.dirPath
	return cmd
}

// Run runs the executable file.
// Return logs and error if it occurs
func (ex *Executor) Run(name string) *exec.Cmd {
	args := append(ex.runArgs, name)
	cmd := exec.Command(ex.runCommand, args...)
	cmd.Dir = ex.dirPath
	return cmd
}

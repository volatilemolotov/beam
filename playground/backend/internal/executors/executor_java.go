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
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"beam.apache.org/playground/backend/internal/utils"
	"context"
	"fmt"
	"os/exec"
	"path/filepath"
	"strings"
)

const (
	javaCompileCmd        = "javac"
	javaRunCmd            = "java"
	javaLoggConfigOption  = "-Djava.util.logging.config.file"
	javaLogConfigFileName = "logging.properties"
	javaTestCmd           = "java"
)

var getBeamJars = environment.ConcatBeamJarsToString

func getJavaCompileArgs() ([]string, error) {
	classpath, err := getBeamJars()
	if err != nil {
		return nil, fmt.Errorf("error during proccessing jars: %s", err.Error())
	}
	return []string{"-d", "bin", "-parameters", "-classpath", classpath}, nil
}

func getJavaRunArgs() ([]string, error) {
	classpath, err := getBeamJars()
	if err != nil {
		return nil, fmt.Errorf("error during proccessing jars: %s", err.Error())
	}
	return []string{"-cp", fmt.Sprintf("bin:%s", classpath)}, nil
}

func getJavaTestArgs() ([]string, error) {
	classpath, err := getBeamJars()
	if err != nil {
		return nil, fmt.Errorf("error during proccessing jars: %s", err.Error())
	}
	return []string{"-cp", fmt.Sprintf("bin:%s", classpath), "org.junit.runner.JUnitCore"}, nil
}

func getJavaCompileCmd(ctx context.Context, paths *fs_tool.LifeCyclePaths) (*exec.Cmd, error) {
	javaSources, err := paths.GetSourceFiles()
	if err != nil {
		return nil, err
	}

	compileArgs, err := getJavaCompileArgs()
	if err != nil {
		return nil, err
	}
	cmd := exec.CommandContext(ctx, javaCompileCmd, append(compileArgs, javaSources...)...)
	cmd.Dir = paths.AbsoluteBaseFolderPath
	return cmd, nil
}

func getJavaRunCmd(ctx context.Context, paths *fs_tool.LifeCyclePaths, pipelineOptions string) (*exec.Cmd, error) {
	pipelineOptions = utils.ReplaceSpacesWithEquals(pipelineOptions)

	logConfigFilePath := filepath.Join(paths.AbsoluteBaseFolderPath, javaLogConfigFileName)
	runArgs, err := getJavaRunArgs()
	if err != nil {
		return nil, err
	}
	args := append(runArgs, fmt.Sprintf("%s=%s", javaLoggConfigOption, logConfigFilePath))

	className, err := paths.FindExecutableName(ctx)
	if err != nil {
		return nil, err
	}
	pipelineOptionsSplit := strings.Split(pipelineOptions, " ")

	args = append(args, className)
	args = append(args, pipelineOptionsSplit...)

	cmd := exec.CommandContext(ctx, javaRunCmd, args...)
	cmd.Dir = paths.AbsoluteBaseFolderPath
	return cmd, nil
}

func getJavaRunTestCmd(ctx context.Context, paths *fs_tool.LifeCyclePaths) (*exec.Cmd, error) {
	className, err := paths.FindTestExecutableName(ctx)
	if err != nil {
		return nil, err
	}

	testArgs, err := getJavaTestArgs()
	if err != nil {
		return nil, err
	}

	cmd := exec.CommandContext(ctx, javaTestCmd, append(testArgs, className)...)
	cmd.Dir = paths.AbsoluteBaseFolderPath
	return cmd, nil
}

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
	"os"
	"reflect"
	"testing"
)

func setOsEnvs(envsToSet map[string]string) {
	for key, value := range envsToSet {
		if err := os.Setenv(key, value); err != nil {
			panic(err)
		}

	}
}

func TestNewService(t *testing.T) {
	type args struct {
		writers *LogWriters
	}
	tests := []struct {
		name string
		args args
		want *Service
	}{
		{name: "create env service with default envs", args: args{writers: nil}, want: &Service{
			ServerEnvs:  *NewServerEnvs(defaultIp, defaultPort),
			LogWriters:  *NewLogWriters(os.Stdout, os.Stdout, os.Stderr),
			BeamSdkEnvs: *NewBeamEnvs(pb.Sdk_SDK_JAVA),
		}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := NewService(tt.args.writers); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("NewService() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_getSdkEnvsFromOsEnvs(t *testing.T) {
	tests := []struct {
		name      string
		want      BeamEnvs
		envsToSet map[string]string
	}{
		{name: "default sdk envs", want: BeamEnvs{defaultSdk}},
		{name: "right sdk key in os envs", want: BeamEnvs{pb.Sdk_SDK_JAVA}, envsToSet: map[string]string{"BEAM_SDK": "SDK_JAVA"}},
		{name: "wrong sdk key in os envs", want: BeamEnvs{defaultSdk}, envsToSet: map[string]string{"BEAM_SDK": "SDK_J"}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			setOsEnvs(tt.envsToSet)
			if got := getSdkEnvsFromOsEnvs(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("getSdkEnvsFromOsEnvs() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_getServerEnvsFromOsEnvs(t *testing.T) {
	tests := []struct {
		name      string
		want      ServerEnvs
		envsToSet map[string]string
	}{
		{name: "default values", want: ServerEnvs{defaultIp, defaultPort}},
		{name: "values from os envs", want: ServerEnvs{"12.12.12.21", 1234}, envsToSet: map[string]string{serverIpKey: "12.12.12.21", serverPortKey: "1234"}},
		{name: "not int port in os env, should be default", want: ServerEnvs{"12.12.12.21", defaultPort}, envsToSet: map[string]string{serverIpKey: "12.12.12.21", serverPortKey: "1a34"}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			setOsEnvs(tt.envsToSet)
			if got := getServerEnvsFromOsEnvs(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("getServerEnvsFromOsEnvs() = %v, want %v", got, tt.want)
			}
		})
	}
}

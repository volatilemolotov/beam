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

package test_utils

import (
	"fmt"
	"os"
	"testing"

	"beam.apache.org/playground/backend/internal/constants"
)

func TestMain(m *testing.M) {
	exitValue := m.Run()
	if exitValue == 0 && testing.CoverMode() != "" {
		coverage := testing.Coverage()
		if coverage < constants.MinTestCoverage {
			fmt.Printf(constants.BadTestCoverageErrTemplate, coverage, constants.MinTestCoverage*100)
			exitValue = -1
		}
	}
	os.Exit(exitValue)
}

func TestRandomString(t *testing.T) {
	tests := []struct {
		name           string
		actualLength   int
		expectedLength int
	}{
		{
			name:           "Generation randon string with fixed length",
			actualLength:   50,
			expectedLength: 50,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := RandomString(tt.actualLength)
			if len(result) != tt.expectedLength {
				t.Errorf("RandomString() returns a string with unexpected length")
			}
		})
	}
}

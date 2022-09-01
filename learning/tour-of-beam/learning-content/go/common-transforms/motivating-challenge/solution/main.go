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

// beam-playground:
//   name: CommonTransformsSolution
//   description: Common Transforms motivating challenge solution.
//   multifile: false
//   context_line: 34

package main

import (
	"context"
	"github.com/apache/beam/sdks/v2/go/pkg/beam"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/log"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/transforms/filter"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/transforms/stats"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/x/beamx"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/x/debug"
)

func main() {
	ctx := context.Background()

	p, s := beam.NewPipelineWithRoot()

	// List of elements
	input := beam.Create(s, 43, -12, 4, 532, -88, -79, 0, 7, 31)

	// The [input] filtered with the positiveNumbersFilter()
	filtered := getPositiveNumbers(s, input)

    // Returns map
	numberMap := getMap(s, filtered)

	// Returns numbers count with the countingNumbers()
	count := getCountingNumbersByKey(s, numberMap)

	debug.Print(s, count)

	err := beamx.Run(ctx, p)

	if err != nil {
		log.Exitf(context.Background(), "Failed to execute job: %v", err)
	}
}

// Returns positive numbers
func getPositiveNumbers(s beam.Scope, input beam.PCollection) beam.PCollection {
	return filter.Include(s, input, func(element int) bool {
		return element >= 0
	})
}

// Returns a map with a key that will not be odd or even , and the value will be the number itself at the input
func getMap(s beam.Scope, input beam.PCollection) beam.PCollection {
	return beam.ParDo(s, func(input int) (string, int) {
		if input%2 == 0 {
			return "even", input
		} else {
			return "odd", input
		}
	}, input)
}

// Returns the count of numbers
func getCountingNumbersByKey(s beam.Scope, input beam.PCollection) beam.PCollection {
	return stats.Count(s,
		beam.ParDo(s, func(key string, value int) string {
			return key
		}, input))
}
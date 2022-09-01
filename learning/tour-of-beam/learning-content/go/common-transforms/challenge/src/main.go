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
	input := beam.Create(s, -12, 4, 532, -88, -79, 0, 7, 31)

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

// Write here getPositiveNumbers function

// Write here getMap function

// Write here getCountingNumbersByKey function

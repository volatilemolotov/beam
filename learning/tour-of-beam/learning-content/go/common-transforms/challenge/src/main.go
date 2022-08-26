package main

import (
    "context"
	"github.com/apache/beam/sdks/v2/go/pkg/beam"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/log"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/x/beamx"
	"github.com/apache/beam/sdks/v2/go/pkg/beam/x/debug"
    "github.com/apache/beam/sdks/v2/go/pkg/beam/transforms/filter"
    "github.com/apache/beam/sdks/v2/go/pkg/beam/transforms/stats"
)

func main() {
	ctx := context.Background()

	p, s := beam.NewPipelineWithRoot()

	// List of elements
    input := beam.Create(s, -12, 4, 532, -88, -79, 0)

    // The [input] filtered with the positiveNumbersFilter()
    filtered := positiveNumbersFilter(s, input)

    // Return numbers count with the countingNumbers()
    count := countingNumbers(s, filtered)

	debug.Print(s, count)

	err := beamx.Run(ctx, p)

	if err != nil {
		log.Exitf(context.Background(), "Failed to execute job: %v", err)
	}
}

// Write here positiveNumbersFilter function


// Write here countingNumbers function

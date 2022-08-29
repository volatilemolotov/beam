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
    filtered := getPositiveNumbers(s, input)

    // Return numbers count with the countingNumbers()
    count := getCountingNumbersByKey(s, filtered)

	debug.Print(s, count)

	err := beamx.Run(ctx, p)

	if err != nil {
		log.Exitf(context.Background(), "Failed to execute job: %v", err)
	}
}

// Return positive numbers
func getPositiveNumbers(s beam.Scope, input beam.PCollection) beam.PCollection {
	return filter.Exclude(s, input, func(element int) bool {
		return element >= 0
	})
}

// Set key for each number
type ComputeWordLengthFn struct{}

func (fn *ComputeWordLengthFn) ProcessElement(word string, emit func(int)) {
	emit(len(word))
}

// Return the count of numbers
func getCountingNumbersByKey(s beam.Scope, input beam.PCollection) beam.PCollection {
	return stats.CountElms(s, input)
}
package task

import (
	"strings"
	"context"
    "github.com/apache/beam/sdks/go/pkg/beam"
    "github.com/apache/beam/sdks/go/pkg/beam/log"
    "github.com/apache/beam/sdks/go/pkg/beam/x/beamx"
    "github.com/apache/beam/sdks/go/pkg/beam/x/debug"
)

func main() {
	ctx := context.Background()

	p, s := beam.NewPipelineWithRoot()

	input := beam.Create(s, "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")

	reversed, toUpper := applyTransform(s, input)

	debug.Printf(s, "Reversed: %s", reversed)

	debug.Printf(s, "Upper: %s", toUpper)

	err := beamx.Run(ctx, p)

	if err != nil {
		log.Exitf(context.Background(), "Failed to execute job: %v", err)
	}
}


func applyTransform(s beam.Scope, input beam.PCollection) (beam.PCollection, beam.PCollection) {
	reversed := reverseString(s, input)
	toUpper := toUpperString(s, input)
	return reversed, toUpper
}

func reverseString(s beam.Scope, input beam.PCollection) beam.PCollection {
	return beam.ParDo(s, reverseFn, input)
}

func toUpperString(s beam.Scope, input beam.PCollection) beam.PCollection {
	return beam.ParDo(s, strings.ToUpper, input)
}

func reverseFn(s string) string {
	runes := []rune(s)

	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}

	return string(runes)
}
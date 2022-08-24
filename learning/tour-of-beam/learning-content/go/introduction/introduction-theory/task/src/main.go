
package main

import (
  "context"
  "github.com/apache/beam/sdks/v2/go/pkg/beam"
  "github.com/apache/beam/sdks/v2/go/pkg/beam/log"
  "github.com/apache/beam/sdks/v2/go/pkg/beam/x/beamx"
  "github.com/apache/beam/sdks/v2/go/pkg/beam/x/debug"
)

func main() {
  p, s := beam.NewPipelineWithRoot()

  hello := helloBeam(s)
  debug.Print(s, hello)

  err := beamx.Run(context.Background(), p)
  if err != nil {
    log.Exitf(context.Background(), "Failed to execute job: %v", err)
  }
}

func helloBeam(s beam.Scope) beam.PCollection {
  return beam.Create(s, "Hello Beam")
}
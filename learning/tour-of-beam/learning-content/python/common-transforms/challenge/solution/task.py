import apache_beam as beam

from log_elements import LogElements

with beam.Pipeline() as p:

    # List of elements
    (p | beam.Create(range(-5, 10))
     | beam.Filter(lambda num: num >= 0)
     | beam.WithKeys(lambda num: "positive")
     | beam.combiners.Count.PerKey()
     | LogElements())


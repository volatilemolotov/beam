import apache_beam as beam

# Output PCollection
class Output(beam.PTransform):
    class _OutputFn(beam.DoFn):

        def process(self, element):
            print(element)

    def expand(self, input):
        input | beam.ParDo(self._OutputFn())

with beam.Pipeline() as p:
    # List of elements
    (p | beam.Create(range(-5, 10))
    # Return filtered numbers

    # Set 'positive' for numbers

    # Return count for each key

     | Output())


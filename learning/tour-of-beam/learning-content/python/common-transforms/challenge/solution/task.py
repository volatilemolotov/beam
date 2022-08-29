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
     | beam.Filter(lambda num: num >= 0)
     | beam.WithKeys(lambda num: 'Yes' if num%2==0 else 'No')
     | beam.combiners.Count.PerKey()
     | Output())

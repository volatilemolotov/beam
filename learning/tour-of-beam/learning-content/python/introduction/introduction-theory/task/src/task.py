import apache_beam as beam

from log_elements import LogElements

with beam.Pipeline() as p:
    (p | beam.Create(['Hello Beam'])
    | LogElements())


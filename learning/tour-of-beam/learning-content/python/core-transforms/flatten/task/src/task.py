import apache_beam as beam

from log_elements import LogElements

with beam.Pipeline() as p:

    wordsStartingWithA = \
        p | 'Words starting with A' >> beam.Create(['apple', 'ant', 'arrow'])

    wordsStartingWithB = \
        p | 'Words starting with B' >> beam.Create(['ball', 'book', 'bow'])

    ((wordsStartingWithA, wordsStartingWithB)
     | beam.Flatten()
     | LogElements())
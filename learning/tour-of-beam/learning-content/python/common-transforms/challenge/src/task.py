import apache_beam as beam

from log_elements import LogElements

with beam.Pipeline() as p:
    # List of elements
    (p | beam.Create(range(-5, 10))
    # Return filtered numbers

    # Set 'positive' for numbers

    # Return count for each key

     | LogElements())


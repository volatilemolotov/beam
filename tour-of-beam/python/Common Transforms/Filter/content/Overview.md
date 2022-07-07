### Using Filter

Given a predicate, filter out all elements that do not satisfy this predicate. It can also be used for filtering based on an inequality with a given value based on the order of comparison of the element.

```
import apache_beam as beam

from log_elements import LogElements

with beam.Pipeline() as p:
  (p | beam.Create(range(1, 11))
     | beam.Filter(lambda num: num % 2 == 0)
     | LogElements())
```

Filter accepts a function that keeps elements that return True, and filters out the remaining elements.


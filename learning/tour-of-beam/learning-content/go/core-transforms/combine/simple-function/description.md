# Combine

`Combine` is a Beam transform for combining collections of elements or values in your data. Combine has variants that work on entire PCollections, and some that combine the values for each key in `PCollections` of **key/value** pairs.

When you apply a `Combine` transform, you must provide the function that contains the logic for combining the elements or values. The combining function should be commutative and associative, as the function is not necessarily invoked exactly once on all values with a given key. Because the input data (including the value collection) may be distributed across multiple workers, the combining function might be called multiple times to perform partial combining on subsets of the value collection. The Beam SDK also provides some pre-built combine functions for common numeric combination operations such as sum, min, and max.

Simple combine operations, such as sums, can usually be implemented as a simple function.

```
func ApplyTransform(s beam.Scope, input beam.PCollection) beam.PCollection {
	return beam.Combine(s, func(sum, elem int) int {
		return sum + elem
	}, input)
}
```
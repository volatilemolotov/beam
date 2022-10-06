# BinaryCombineFn

An abstract subclass of `Combine.CombineFn` for implementing combiners that are more easily expressed as binary operations.

```
static class SumBigIntegerFn extends BinaryCombineFn<BigInteger> {
    @Override
    public BigInteger apply(BigInteger left, BigInteger right) {
      return left.add(right);
    }
}
```

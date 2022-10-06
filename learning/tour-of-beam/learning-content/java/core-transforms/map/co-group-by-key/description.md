# CoGroupByKey

You can use the `CoGroupByKey` transformation for a tuple of tables. `CoGroupByKey` groups results from all tables by similar keys in `CoGbkResults`, from which results for any particular table can be accessed using the `TupleTag` tag supplied with the source table.

For type safety, the Jav SDK requires you to pass each `PCollection` as part of a `KeyedPCollectionTuple`. You must declare a `TupleTag` for each input `PCollection` in the `KeyedPCollectionTuple` that you want to pass to `CoGroupByKey`. As output, `CoGroupByKey` returns a `PCollection<KV<K, CoGbkResult>>`, which groups values from all the input `PCollections` by their common keys. Each key (all of type K) will have a different `CoGbkResult`, which is a map from `TupleTag<T> to Iterable<T>`. You can access a specific collection in an `CoGbkResult` object by using the `TupleTag` that you supplied with the initial collection.

```
// Mock data
final List<KV<String, String>> emailsList =
    Arrays.asList(
        KV.of("amy", "amy@example.com"),
        KV.of("carl", "carl@example.com"),
        KV.of("julia", "julia@example.com"),
        KV.of("carl", "carl@email.com"));

final List<KV<String, String>> phonesList =
    Arrays.asList(
        KV.of("amy", "111-222-3333"),
        KV.of("james", "222-333-4444"),
        KV.of("amy", "333-444-5555"),
        KV.of("carl", "444-555-6666"));

// Creating PCollections
PCollection<KV<String, String>> emails = p.apply("CreateEmails", Create.of(emailsList));
PCollection<KV<String, String>> phones = p.apply("CreatePhones", Create.of(phonesList));

// Create TupleTag for safety type
final TupleTag<String> emailsTag = new TupleTag<>();
final TupleTag<String> phonesTag = new TupleTag<>();

// Apply CoGroupByKey 
PCollection<KV<String, CoGbkResult>> results =
    KeyedPCollectionTuple.of(emailsTag, emails)
        .and(phonesTag, phones)
        .apply(CoGroupByKey.create());

// Get result
PCollection<String> contactLines =
    results.apply(
        ParDo.of(
            new DoFn<KV<String, CoGbkResult>, String>() {
              @ProcessElement
              public void processElement(ProcessContext c) {
                KV<String, CoGbkResult> e = c.element();
                String name = e.getKey();
                Iterable<String> emailsIter = e.getValue().getAll(emailsTag);
                Iterable<String> phonesIter = e.getValue().getAll(phonesTag);
                String formattedResult =
                    Snippets.formatCoGbkResults(name, emailsIter, phonesIter);
                c.output(formattedResult);
              }
            }));
```

The following code example joins the two `PCollection`s with `CoGroupByKey`, followed by a `ParDo` to consume the result. Then, the code uses tags to look up and format data from each collection.
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;


public class Task {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();
        Pipeline pipeline = Pipeline.create(options);

        // List of elements
        PCollection<Integer> numbers =
                pipeline.apply(Create.of(-34, -1, 26, 0, 93, -66, 53));

        // The [numbers] filtered with the positiveNumberFilter()
        PCollection<Integer> filtered = getPositiveNumbers(numbers);

        // Set key for each number
        PCollection<KV<String,Integer>> getCollectionWithKey = setKeyForNumbers(filtered);

        // Return count numbers
        PCollection<KV<String,Long>> countPerKey = getCountPerKey(getCollectionWithKey);

        output(countPerKey);

        pipeline.run();
    }

    // Write a method that returns positive numbers
    // static PCollection<Integer> getPositiveNumbers(PCollection<Integer> input) {
    //
    // }

    // Returns a map with a key that will not be odd or even , and the value will be the number itself at the input
    // static PCollection<KV<String, Integer>> setKeyForNumbers(PCollection<Integer> input) {
    //
    // }

    // Returns the count of numbers
    // static PCollection<KV<String,Long>> getCountPerKey(PCollection<KV<String, Integer>> input) {
    //
    // }

    static <T> void output(PCollection<T> pCollection) {
        pCollection.apply(ParDo.of(new DoFn<T, T>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                System.out.println(c.element());
            }
        }));
    }
}
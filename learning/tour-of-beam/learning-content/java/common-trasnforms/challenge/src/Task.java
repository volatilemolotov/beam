import org.apache.beam.learning.katas.util.Log;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.transforms.Count;


public class Task {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();
        Pipeline pipeline = Pipeline.create(options);

        // List of elements
        PCollection<Integer> numbers =
                pipeline.apply(Create.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // The [numbers] filtered with the positiveNumberFilter()
        PCollection<Integer> filtered = positiveNumberFilter(numbers);

        // Return count numbers
        PCollection<Long> count = countNumbers(filtered);

        count.apply(Log.ofElements());

        pipeline.run();
    }


    // Write here positiveNumbersFilter function

    // Write here countingNumbers function
}
import static org.apache.beam.sdk.values.TypeDescriptors.integers;

import java.util.Arrays;
import org.apache.beam.learning.katas.util.Log;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class Task {

    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();
        Pipeline pipeline = Pipeline.create(options);

        pipeline
                .apply(Create.of("1,2,3,4,5", "6,7,8,9,10"))
                .apply(new ExtractAndMultiplyNumbers())
                .apply(Log.ofElements());

        pipeline.run();
    }

    static class ExtractAndMultiplyNumbers
            extends PTransform<PCollection<String>, PCollection<Integer>> {

        @Override
        public PCollection<Integer> expand(PCollection<String> input) {
            return input
                    .apply(ParDo.of(new DoFn<String, Integer>() {

                        @ProcessElement
                        public void processElement(@Element String numbers, OutputReceiver<Integer> out) {
                            Arrays.stream(numbers.split(","))
                                    .forEach(numStr -> out.output(Integer.parseInt(numStr)));
                        }

                    }))

                    .apply(MapElements.into(integers()).via(number -> number * 10));
        }

    }
}
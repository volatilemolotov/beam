import org.apache.beam.learning.katas.util.Log;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Flatten;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionList;

public class Task {

    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();
        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> wordsStartingWithA =
                pipeline.apply("Words starting with A",
                        Create.of("apple", "ant", "arrow")
                );

        PCollection<String> wordsStartingWithB =
                pipeline.apply("Words starting with B",
                        Create.of("ball", "book", "bow")
                );

        PCollection<String> output = applyTransform(wordsStartingWithA, wordsStartingWithB);

        output.apply(Log.ofElements());

        pipeline.run();
    }

    static PCollection<String> applyTransform(
            PCollection<String> words1, PCollection<String> words2) {

        return PCollectionList.of(words1).and(words2)
                .apply(Flatten.pCollections());
    }

}
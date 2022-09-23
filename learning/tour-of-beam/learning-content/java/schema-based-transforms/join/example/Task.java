import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.schemas.transforms.Join;
import org.apache.beam.sdk.schemas.transforms.Select;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Task {
    private static final Logger LOG = LoggerFactory.getLogger(Task.class);

    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();
        Pipeline pipeline = Pipeline.create(options);

        User user1 = new User(1L, "Andy", "Gross");
        User user2 = new User(2L, "May", "Kim");
        Location location = new Location(1L, 223.2, 16.8);

        PCollection<Object> userPCollection = pipeline.apply(Create.of(user1, user2));
        PCollection<Object> locationPCollection = pipeline.apply(Create.of(location));

        PCollection<Row> rowPCollection = userPCollection.apply(Join.innerJoin(locationPCollection).using("userId"));

        rowPCollection.apply(Select.fieldNames("lhs.userName", "lhs.userSurname", "rhs.latitude", "rhs.longtitude"))
                .apply("User location", ParDo.of(new LogOutput<>("User with location")));

        pipeline.run();

    }

    static class LogOutput<T> extends DoFn<T, T> {

        private String prefix;

        LogOutput() {
            this.prefix = "Processing element";
        }

        LogOutput(String prefix) {
            this.prefix = prefix;
        }

        @ProcessElement
        public void processElement(ProcessContext c) throws Exception {
            LOG.info(prefix + ": {}", c.element());
        }
    }
}

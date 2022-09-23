import com.example.demo.Location;
import com.example.demo.User;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
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

        User user = new User(1L, "Andy", "Gross", new Location(2L, 24,553));
        PCollection<User> input = pipeline.apply(Create.of(user));

        // Select [userName] and [userSurname]
        PCollection<Row> fullName = input.apply(Select.fieldNames("userName", "userSurname"));
        fullName.apply("User fullName", ParDo.of(new LogOutput<>("FullName")));

        // Select user [location]
        PCollection<Row> location = input.apply(Select.fieldNames("location.*"));
        location.apply("User location", ParDo.of(new LogOutput<>("Location")));

        // Flattened row, select all fields
        PCollection<Row> flattened = input.apply(Select.flattenedSchema());
        flattened.apply("User flatten row", ParDo.of(new LogOutput<>("Flattened")));

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

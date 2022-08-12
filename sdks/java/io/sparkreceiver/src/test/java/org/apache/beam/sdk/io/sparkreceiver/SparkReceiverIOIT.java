package org.apache.beam.sdk.io.sparkreceiver;

import com.google.cloud.Timestamp;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.Producer;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.common.IOITHelper;
import org.apache.beam.sdk.io.common.IOTestPipelineOptions;
import org.apache.beam.sdk.io.synthetic.SyntheticSourceOptions;
import org.apache.beam.sdk.metrics.Counter;
import org.apache.beam.sdk.metrics.Metrics;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.ExperimentalOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.testing.TestPipelineOptions;
import org.apache.beam.sdk.testutils.NamedTestResult;
import org.apache.beam.sdk.testutils.metrics.IOITMetrics;
import org.apache.beam.sdk.testutils.metrics.MetricsReader;
import org.apache.beam.sdk.testutils.metrics.TimeMonitor;
import org.apache.beam.sdk.testutils.publishing.InfluxDBSettings;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableSet;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.joda.time.Duration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.createStream;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getEnvironment;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getMessage;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getProducer;
import static org.apache.beam.sdk.io.synthetic.SyntheticOptions.fromJsonString;
import static org.junit.Assert.assertEquals;

/**
 * IO Integration test for {@link org.apache.beam.sdk.io.sparkreceiver.SparkReceiverIO}.
 *
 * <p>{@see https://beam.apache.org/documentation/io/testing/#i-o-transform-integration-tests} for
 * more details.
 *
 * <p>NOTE: This test sets retention policy of the messages so that all messages are retained in the
 * topic so that we could read them back after writing.
 *
 * <p>{@see https://stackoverflow.com/questions/59245356/how-to-create-apache-spark-standalone-cluster-for-integration-testing-using-test/68156137} for
 *  more details about spark testcontainers setup.</p>
 */
@SuppressWarnings({"FieldCanBeLocal", "rawtypes", "unused"})
@RunWith(JUnit4.class)
public class SparkReceiverIOIT {

  private static final Logger LOG = LoggerFactory.getLogger(SparkReceiverIOIT.class);

  private static final String READ_TIME_METRIC_NAME = "read_time";

  private static final String WRITE_TIME_METRIC_NAME = "write_time";

  private static final String RUN_TIME_METRIC_NAME = "run_time";

  private static final String READ_ELEMENT_METRIC_NAME = "spark_read_element_count";

  private static final Network NETWORK = Network.newNetwork();

  private static final String NAMESPACE = SparkReceiverIOIT.class.getName();

  private static final String TEST_ID = UUID.randomUUID().toString();

  private static final String TIMESTAMP = Timestamp.now().toString();

  private static final String TEST_MESSAGE_PREFIX = "Test ";
  private static final String RABBITMQ_USERNAME = "rabbitMqUser";
  private static final String RABBITMQ_PASSWORD = "rabbitMqPassword";

  private static Options options;

  private static SyntheticSourceOptions sourceOptions;

  private static GenericContainer rabbitMqContainer;

  private static InfluxDBSettings settings;

  private static final ExperimentalOptions sdfPipelineOptions;

  static {
    sdfPipelineOptions = PipelineOptionsFactory.create().as(ExperimentalOptions.class);
    ExperimentalOptions.addExperiment(sdfPipelineOptions, "use_sdf_read");
    ExperimentalOptions.addExperiment(sdfPipelineOptions, "beam_fn_api");
    sdfPipelineOptions.as(TestPipelineOptions.class).setBlockOnRun(false);
  }

  @Rule public TestPipeline readPipeline = TestPipeline.fromOptions(sdfPipelineOptions);

  @BeforeClass
  public static void setup() throws IOException {
    options = IOITHelper.readIOTestPipelineOptions(Options.class);
    sourceOptions = fromJsonString(options.getSourceOptions(), SyntheticSourceOptions.class);
    options.setRabbitMqBootstrapServerAddress("rabbitmq-stream://guest:guest@" + options.getRabbitMqBootstrapServerAddress());
    if (options.isWithTestcontainers()) {
      setupRabbitMqContainer();
    } else {
      settings =
          InfluxDBSettings.builder()
              .withHost(options.getInfluxHost())
              .withDatabase(options.getInfluxDatabase())
              .withMeasurement(options.getInfluxMeasurement())
              .get();
    }
  }

  @AfterClass
  public static void afterClass() {
    if (rabbitMqContainer != null) {
      rabbitMqContainer.stop();
    }
  }

  private static void setupRabbitMqContainer() {
    rabbitMqContainer =
        new RabbitMQContainer(
            DockerImageName.parse("rabbitmq")
                .withTag(options.getRabbitMqContainerVersion()))
            .withAdminPassword(null)
            .withPluginsEnabled("rabbitmq_stream")
            .withExposedPorts(5552, 5672, 15672)
            .withEnv("RABBITMQ_SERVER_ADDITIONAL_ERL_ARGS", "-rabbitmq_stream advertised_host localhost");
    rabbitMqContainer.start();
    options.setRabbitMqBootstrapServerAddress(
        getBootstrapServers(
            rabbitMqContainer.getHost(),
            rabbitMqContainer.getMappedPort(5552).toString()));
  }

  private static String getBootstrapServers(String host, String port) {
    return String.format("rabbitmq-stream://guest:guest@%s:%s", host, port);
  }

  /** Pipeline options specific for this test. */
  @SuppressWarnings("unused")
  public interface Options extends IOTestPipelineOptions, StreamingOptions {

    @Description("Options for synthetic source.")
    @Validation.Required
    @Default.String("{\"numRecords\": \"100\",\"keySizeBytes\": \"1\",\"valueSizeBytes\": \"90\"}")
    String getSourceOptions();

    void setSourceOptions(String sourceOptions);

    @Description("RabbitMQ bootstrap server address")
    @Default.String("rabbitmq-stream://guest:guest@localhost:5672")
    String getRabbitMqBootstrapServerAddress();

    void setRabbitMqBootstrapServerAddress(String address);

    @Description("RabbitMQ stream")
    @Default.String("stream")
    String getStreamName();

    void setStreamName(String streamName);

    @Description("Whether to use testcontainers")
    @Default.Boolean(true)
    Boolean isWithTestcontainers();

    void setWithTestcontainers(Boolean withTestcontainers);

    @Description("RabbitMQ container version. Use when useTestcontainers is true")
    @Nullable
    @Default.String("3.9-alpine")
    String getRabbitMqContainerVersion();

    void setRabbitMqContainerVersion(String rabbitMqContainerVersion);

    @Description("Time to wait for the events to be processed by the read pipeline (in seconds)")
//    @Validation.Required
    @Default.Integer(25)
    Integer getReadTimeout();

    void setReadTimeout(Integer readTimeout);
  }

  private void writeToRabbitMq(final long maxNumRecords) {
    final CountDownLatch confirmLatch = new CountDownLatch((int) maxNumRecords);
    final List<String> data = LongStream.range(0, maxNumRecords)
        .mapToObj(number -> TEST_MESSAGE_PREFIX + number)
        .collect(Collectors.toList());

    try (Environment environment = getEnvironment(options.getRabbitMqBootstrapServerAddress())) {
      createStream(environment, options.getStreamName());
      final Producer producer = getProducer(environment, options.getStreamName());
      data.forEach(text -> {
        System.out.println("trying to send message to RabbitMQ");
        LOG.info("trying to send message to RabbitMQ");
        final Message message = getMessage(producer, text, Long.parseLong(text.substring(5)));
        producer.send(message, confirmationStatus -> {
          confirmLatch.countDown();
          System.out.println("sending messages to RabbitMQ " + confirmationStatus.isConfirmed());
          LOG.info("sending messages to RabbitMQ " + confirmationStatus.isConfirmed());
        });
        System.out.println("sending messages to RabbitMQ. CountdownLatch = " + confirmLatch.getCount());
        LOG.info("sending messages to RabbitMQ. CountdownLatch = " + confirmLatch.getCount());
      });
    } catch (Exception e) {
      System.err.println("Error during sending messages to RabbitMQ: " + e.getMessage());
    }
  }

  private SparkReceiverIO.Read<String> readFromRabbitMqWithoutOffset(final long maxNumRecords) {
    final ReceiverBuilder<String, RabbitMqReceiverWithoutOffset> receiverBuilder =
        new ReceiverBuilder<>(RabbitMqReceiverWithoutOffset.class).withConstructorArgs(
            options.getRabbitMqBootstrapServerAddress(),
            maxNumRecords,
            options.getStreamName());

    return SparkReceiverIO.<String>read()
            .withSparkConsumer(new CustomSparkConsumer<>(maxNumRecords))
            .withValueClass(String.class)
            .withGetOffsetFn(rabbitMqMessage -> Long.valueOf(rabbitMqMessage.substring(TEST_MESSAGE_PREFIX.length())))
            .withSparkReceiverBuilder(receiverBuilder);
  }

  private SparkReceiverIO.Read<String> readFromRabbitMqWithOffset(final long maxNumRecords) {
    final ReceiverBuilder<String, RabbitMqReceiverWithOffset> receiverBuilder =
        new ReceiverBuilder<>(RabbitMqReceiverWithOffset.class).withConstructorArgs(
            options.getRabbitMqBootstrapServerAddress(),
            options.getStreamName());

    return SparkReceiverIO.<String>read()
//        .withSparkConsumer(new CustomSparkConsumer<>(maxNumRecords))
        .withValueClass(String.class)
        .withGetOffsetFn(rabbitMqMessage -> Long.valueOf(rabbitMqMessage.substring(TEST_MESSAGE_PREFIX.length())))
        .withSparkReceiverBuilder(receiverBuilder);
  }

  private static class MapRabbitMqRecordsToStrings extends SimpleFunction<byte[], String> {

    @Override
    public String apply(byte[] input) {
      try {
        return Arrays.toString(input);
      } catch (Exception e) {
        LOG.error("Error during RabbitMQ message conversion");
        throw e;
      }
    }
  }

  private static class CountingFn extends DoFn<String, Void> {

    private final Counter elementCounter;

    CountingFn(String namespace, String name) {
      elementCounter = Metrics.counter(namespace, name);
    }

    @ProcessElement
    public void processElement() {
      elementCounter.inc(1L);
    }
  }

  private void cancelIfTimeout(PipelineResult readResult, PipelineResult.State readState) throws IOException {
    if (readState == null) {
      readResult.cancel();
    }
  }

  private long readElementMetric(PipelineResult result) {
    MetricsReader metricsReader = new MetricsReader(result, SparkReceiverIOIT.NAMESPACE);
    return metricsReader.getCounterMetric(SparkReceiverIOIT.READ_ELEMENT_METRIC_NAME);
  }

  private Set<NamedTestResult> readMetrics(PipelineResult readResult) {
    BiFunction<MetricsReader, String, NamedTestResult> supplier =
        (reader, metricName) -> {
          long start = reader.getStartTimeMetric(metricName);
          long end = reader.getEndTimeMetric(metricName);
          return NamedTestResult.create(TEST_ID, TIMESTAMP, metricName, (end - start) / 1e3);
        };

    NamedTestResult readTime =
        supplier.apply(new MetricsReader(readResult, NAMESPACE), READ_TIME_METRIC_NAME);
    NamedTestResult runTime =
        NamedTestResult.create(
            TEST_ID, TIMESTAMP, RUN_TIME_METRIC_NAME, readTime.getValue());

    return ImmutableSet.of(readTime, runTime);
  }

  @Test
  @Ignore
  public void testSparkReceiverIOReadsInStreaming() throws IOException {

    writeToRabbitMq(sourceOptions.numRecords);
    LOG.info(sourceOptions.numRecords + " records were successfully written to RabbitMQ");

    // Use streaming pipeline to read RabbitMQ records.
    readPipeline.getOptions().as(Options.class).setStreaming(true);
    readPipeline
        .apply("Read from unbounded RabbitMq", readFromRabbitMqWithoutOffset(sourceOptions.numRecords))
        .setCoder(StringUtf8Coder.of())
        .apply(ParDo.of(new TestOutputDoFn()))
        .apply("Measure read time", ParDo.of(new TimeMonitor<>(NAMESPACE, READ_TIME_METRIC_NAME)))
        .apply("Counting element", ParDo.of(new CountingFn(NAMESPACE, READ_ELEMENT_METRIC_NAME)));

    final PipelineResult readResult = readPipeline.run();
    final PipelineResult.State readState =
        readResult.waitUntilFinish(Duration.standardSeconds(options.getReadTimeout()));

    cancelIfTimeout(readResult, readState);

    assertEquals(
        sourceOptions.numRecords,
        readElementMetric(readResult));

    if (!options.isWithTestcontainers()) {
      Set<NamedTestResult> metrics = readMetrics(readResult);
      IOITMetrics.publishToInflux(TEST_ID, TIMESTAMP, metrics, settings);
    }
  }

  @Test
  public void testSparkReceiverIOReadsInStreamingWithOffset() throws IOException {

    writeToRabbitMq(sourceOptions.numRecords);
    LOG.info(sourceOptions.numRecords + " records were successfully written to RabbitMQ");

    // Use streaming pipeline to read RabbitMQ records.
    readPipeline.getOptions().as(Options.class).setStreaming(true);
    readPipeline
        .apply("Read from unbounded RabbitMq", readFromRabbitMqWithOffset(sourceOptions.numRecords))
        .setCoder(StringUtf8Coder.of())
        .apply(ParDo.of(new TestOutputDoFn()))
        .apply("Measure read time", ParDo.of(new TimeMonitor<>(NAMESPACE, READ_TIME_METRIC_NAME)))
        .apply("Counting element", ParDo.of(new CountingFn(NAMESPACE, READ_ELEMENT_METRIC_NAME)));

    final PipelineResult readResult = readPipeline.run();
    final PipelineResult.State readState =
        readResult.waitUntilFinish(Duration.standardSeconds(options.getReadTimeout()));

    cancelIfTimeout(readResult, readState);

    assertEquals(
        sourceOptions.numRecords,
        readElementMetric(readResult));

    if (!options.isWithTestcontainers()) {
      Set<NamedTestResult> metrics = readMetrics(readResult);
      IOITMetrics.publishToInflux(TEST_ID, TIMESTAMP, metrics, settings);
    }
  }
}

package org.apache.beam.examples.complete.redispubsubtofile.io;

import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.beam.sdk.annotations.Experimental;
import org.apache.beam.sdk.annotations.Experimental.Kind;
import org.apache.beam.sdk.io.Read;
import org.apache.beam.sdk.io.Read.Unbounded;
import org.apache.beam.sdk.io.redis.RedisConnectionConfiguration;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Experimental(Kind.SOURCE_SINK)
public class RedisPubSubIO {

  private static final Logger LOG = LoggerFactory.getLogger(RedisPubSubIO.class);

  private RedisPubSubIO() {
  }

  public static ReadMessage readMessage() {
    return new AutoValue_RedisPubSubIO_ReadMessage.Builder()
        .setConnectionConfiguration(RedisConnectionConfiguration.create())
        .setChannels(Collections.emptyList())
        .build();
  }

  @AutoValue
  public abstract static class ReadMessage extends PTransform<PBegin, PCollection<RedisMessage>> {

    abstract RedisConnectionConfiguration connectionConfiguration();

    abstract List<String> channels();

    abstract Builder builder();

    @Override
    public PCollection<RedisMessage> expand(PBegin input) {
      Unbounded<RedisMessage> unbounded =
          Read.from(new RedisUnboundedSource(this));
      return input.getPipeline().apply(unbounded);
    }

    public ReadMessage withHost(String host) {
      return builder().setConnectionConfiguration(connectionConfiguration().withHost(host)).build();
    }

    public ReadMessage withPort(int port) {
      return builder().setConnectionConfiguration(connectionConfiguration().withPort(port)).build();
    }

    public ReadMessage withChannels(String... channels) {
      return builder().setChannels(Arrays.asList(channels)).build();
    }

    @AutoValue.Builder
    abstract static class Builder {

      abstract Builder setConnectionConfiguration(
          RedisConnectionConfiguration connection);

      abstract Builder setChannels(List<String> channels);

      abstract ReadMessage build();
    }
  }

  public static class ReadRedisMessageFn extends DoFn<RedisMessage, String> {

    @ProcessElement
    public void processElement(@Element RedisMessage message,
        OutputReceiver<String> outputReceiver) {
      outputReceiver.output(message.getChannel() + " -> " + message.getValue());
    }
  }
}

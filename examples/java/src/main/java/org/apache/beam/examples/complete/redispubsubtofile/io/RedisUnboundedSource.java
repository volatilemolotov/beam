package org.apache.beam.examples.complete.redispubsubtofile.io;

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.io.UnboundedSource;
import org.apache.beam.sdk.options.PipelineOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({
    "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisUnboundedSource extends
    UnboundedSource<RedisMessage, RedisCheckpointMark> {

  /* Logger for class.*/
  private static final Logger LOG = LoggerFactory.getLogger(RedisUnboundedSource.class);

  private final RedisPubSubIO.ReadMessage spec;

  public RedisUnboundedSource(RedisPubSubIO.ReadMessage spec) {
    this.spec = spec;
  }

  public RedisPubSubIO.ReadMessage getSpec() {
    return spec;
  }

  @Override
  public List<RedisUnboundedSource> split(
      int desiredNumSplits,
      PipelineOptions options) throws Exception {
    List<String> channels = this.spec.channels();

    checkState(channels.size() > 0,
        "Subscription channels set must not be empty");

    if (channels.size() == 1) {
      return Collections.singletonList(this);
    }

    int splitCount = Math.min(desiredNumSplits, channels.size());
    while (channels.size() % splitCount > 0) {
      ++splitCount;
    }

    List<RedisUnboundedSource> result = new ArrayList<>(splitCount);

    for (int i = 0; i < splitCount; i++) {
      int expectedChannels = channels.size() / splitCount;
      int fromIndex = i * expectedChannels;
      int toIndex = fromIndex + expectedChannels;

      List<String> splitChannels = new ArrayList<>(channels.subList(fromIndex, toIndex));

      result.add(new RedisUnboundedSource(spec.builder().setChannels(splitChannels).build()));
    }

    return result;
  }

  @Override
  public RedisUnboundedReader createReader(
      PipelineOptions options,
      RedisCheckpointMark checkpointMark) throws IOException {
    return new RedisUnboundedReader(this, checkpointMark);
  }

  @Override
  public Coder<RedisCheckpointMark> getCheckpointMarkCoder() {
    return AvroCoder.of(RedisCheckpointMark.class);
  }

  @Override
  public Coder<RedisMessage> getOutputCoder() {
    return RedisMessageCoder.of();
  }

}

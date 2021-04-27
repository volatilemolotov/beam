package org.apache.beam.examples.complete.redispubsubtofile.io;

import java.io.IOException;
import java.util.Optional;
import org.apache.avro.reflect.AvroIgnore;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.io.UnboundedSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DefaultCoder(AvroCoder.class)
@SuppressWarnings({
    "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisCheckpointMark implements UnboundedSource.CheckpointMark {

  private static final Logger LOG = LoggerFactory.getLogger(RedisCheckpointMark.class);
  @AvroIgnore
  private Optional<RedisUnboundedReader> reader;
  ;

  private RedisCheckpointMark() {
  }

  public RedisCheckpointMark(Optional<RedisUnboundedReader> reader) {
    this.reader = reader;
  }

  @Override
  public void finalizeCheckpoint() throws IOException {
  }

}

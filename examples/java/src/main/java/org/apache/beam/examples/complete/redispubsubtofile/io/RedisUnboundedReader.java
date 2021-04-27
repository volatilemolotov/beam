package org.apache.beam.examples.complete.redispubsubtofile.io;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import org.apache.beam.sdk.io.UnboundedSource;
import org.apache.beam.sdk.io.UnboundedSource.UnboundedReader;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@SuppressWarnings({
    "rawtypes", // TODO(https://issues.apache.org/jira/browse/BEAM-10556)
    "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisUnboundedReader extends UnboundedReader<RedisMessage> {

  /* Logger for class.*/
  private static final Logger LOG = LoggerFactory.getLogger(RedisUnboundedReader.class);
  private static final Duration RECORDS_ENQUEUE_POLL_TIMEOUT = Duration.millis(100);
  private final SynchronousQueue<RedisMessage> messages = new SynchronousQueue<>();
  private final ExecutorService jedisConsumerService = Executors.newSingleThreadExecutor();
  private final RedisUnboundedSource source;
  private RedisMessage currentRedisMessage;
  private Instant currentTimestamp;

  public RedisUnboundedReader(RedisUnboundedSource source, RedisCheckpointMark checkpointMark) {
    this.source = source;
  }

  @Override
  public byte[] getCurrentRecordId()
      throws NoSuchElementException {
    return super.getCurrentRecordId();
  }

  @Override
  @SuppressWarnings("FutureReturnValueIgnored")
  public boolean start() throws IOException {
    final String[] channels = this.source.getSpec().channels()
        .toArray(new String[this.source.getSpec().channels().size()]);

    jedisConsumerService.submit(new Runnable() {
      @Override
      public void run() {
        try (Jedis jedis = new Jedis();) {
          JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
              try {
                messages.offer(new RedisMessage(channel, message),
                    RECORDS_ENQUEUE_POLL_TIMEOUT.getMillis(), TimeUnit.SECONDS);
              } catch (InterruptedException e) {
                LOG.warn("{}: consumer thread is interrupted", this, e);
              }
            }
          };

          jedis.subscribe(jedisPubSub, channels);
        } catch (Exception e) {
          LOG.error("{}: Exception while reading from Redis", this, e);
          throw e;
        }
      }
    });

    return advance();
  }

  @Override
  public boolean advance() throws IOException {
    RedisMessage message = messages.poll();
    if (message != null) {
      currentTimestamp = Instant.now();
      currentRedisMessage = message;
      return true;
    }

    return false;
  }

  @Override
  public RedisMessage getCurrent() throws NoSuchElementException {
    return this.currentRedisMessage;
  }

  @Override
  public Instant getCurrentTimestamp()
      throws NoSuchElementException {
    return this.currentTimestamp;
  }

  @Override
  public void close() throws IOException {
    jedisConsumerService.shutdown();

    try {
      jedisConsumerService.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  @Override
  public Instant getWatermark() {
    return Instant.now();
  }

  @Override
  public UnboundedSource.CheckpointMark getCheckpointMark() {
    return new RedisCheckpointMark(Optional.of(this));
  }

  @Override
  public UnboundedSource<RedisMessage, ?> getCurrentSource() {
    return this.source;
  }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.io.sparkreceiver;

import com.rabbitmq.stream.Consumer;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.createStream;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getConsumer;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getEnvironment;

/**
 * Imitation of Spark {@link Receiver} for RabbitMQ that implements {@link HasOffset} interface. Used to
 * test {@link SparkReceiverIO#read()}.
 */
public class RabbitMqReceiverWithOffset extends Receiver<String> implements HasOffset {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitMqReceiverWithOffset.class);

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private static final List<String> STORED_RECORDS = new ArrayList<>();
  private static long MAX_NUM_RECORDS;
  private static String RABBITMQ_URL;
  private static String STREAM_NAME;
  private static Long startOffset;

  RabbitMqReceiverWithOffset(final String uri, final Long maxNumRecords, final String streamName) {
    super(StorageLevel.MEMORY_AND_DISK_2());
    MAX_NUM_RECORDS = maxNumRecords;
    STREAM_NAME = streamName;
    RABBITMQ_URL = uri;
  }

  @Override
  public void setStartOffset(Long startOffset) {
    if (startOffset != null) {
      RabbitMqReceiverWithOffset.startOffset = startOffset;
    }
  }

  @Override
  @SuppressWarnings("FutureReturnValueIgnored")
  public void onStart() {
    Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().build()).submit(this::receive);
  }

  @Override
  public void onStop() {
  }

  private void receive() {
    long currentOffset = startOffset;
    final Queue<String> received = new ConcurrentLinkedQueue<>();
    final AtomicInteger messageConsumed = new AtomicInteger((int) currentOffset);

    LOG.info("Starting receiver");
    try (final Environment environment = getEnvironment(RABBITMQ_URL)) {
      createStream(environment, STREAM_NAME);
      getConsumer(environment, STREAM_NAME, messageConsumed.get(), received);
    } catch (Exception e) {
      LOG.error("Exception during consumer creation", e);
//      throw e;
    }

    while (!isStopped() && messageConsumed.get() < MAX_NUM_RECORDS) {
      if (!received.isEmpty()) {
        try {
          final String stringMessage = received.poll();
          LOG.info("Moving message from test consumer to receiver = " + stringMessage);
          STORED_RECORDS.add(stringMessage);
          store(stringMessage);
          messageConsumed.incrementAndGet();
        } catch (Exception e) {
          LOG.error("Exception " + e.getMessage());
        }
      }
    }

//    if (isStopped() || testConsumer.getReceived().size() == MAX_NUM_RECORDS) {
//      try {
//        LOG.info("Stopping receiver");
//        channel.close();
//        connection.close();
//      } catch (TimeoutException | IOException e) {
//        throw new RuntimeException(e);
//      }
//    }
  }

//  /** A simple RabbitMQ {@code Consumer} that stores all received messages. */
//  static class TestConsumer extends DefaultConsumer {
//
//    private final List<String> received;
//
//    public TestConsumer(Channel channel) {
//      super(channel);
//      this.received = Collections.synchronizedList(new ArrayList<>());
//    }
//
//    @Override
//    public void handleDelivery(
//        String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
//      try {
//        LOG.info("adding message to test consumer " + new String(body, StandardCharsets.UTF_8));
//        received.add(new String(body, StandardCharsets.UTF_8));
//      } catch (Exception e) {
//        LOG.error("Exception during reading from RabbitMQ " + e.getMessage());
//      }
//    }
//
//    /** Returns a thread safe unmodifiable view of received messages. */
//    public List<String> getReceived() {
//      return Collections.unmodifiableList(received);
//    }
//  }
}

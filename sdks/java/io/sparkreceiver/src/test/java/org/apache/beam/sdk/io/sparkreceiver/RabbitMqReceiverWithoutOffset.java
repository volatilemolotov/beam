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

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * Imitation of Spark {@link Receiver} for RabbitMQ that doesn't implement {@link HasOffset} interface. Used to
 * test {@link SparkReceiverIO#read()}.
 */
public class RabbitMqReceiverWithoutOffset extends Receiver<String> {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitMqReceiverWithoutOffset.class);

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private static final List<String> STORED_RECORDS = new ArrayList<>();
  private static long MAX_NUM_RECORDS;
  private static String RABBITMQ_URL;
  private static String QUEUE_NAME;

  RabbitMqReceiverWithoutOffset(final String uri, final Long maxNumRecords, final String queueName) {
    super(StorageLevel.MEMORY_AND_DISK_2());
    MAX_NUM_RECORDS = maxNumRecords;
    QUEUE_NAME = queueName;
    RABBITMQ_URL = uri;
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
    int currentOffset = 0;

    final TestConsumer testConsumer;
    final Connection connection;
    final Channel channel;

    try {
      LOG.info("Starting receiver");
      final ConnectionFactory connectionFactory = new ConnectionFactory();
      connectionFactory.setUri(RABBITMQ_URL);
      connectionFactory.setAutomaticRecoveryEnabled(true);
      connectionFactory.setConnectionTimeout(600000);
      connectionFactory.setNetworkRecoveryInterval(5000);
      connectionFactory.setRequestedHeartbeat(60);
      connectionFactory.setTopologyRecoveryEnabled(true);
      connectionFactory.setRequestedChannelMax(0);
      connectionFactory.setRequestedFrameMax(0);
      connection = connectionFactory.newConnection();
      channel = connection.createChannel();
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      testConsumer = new TestConsumer(channel);
      channel.basicConsume(QUEUE_NAME, true, testConsumer);
    } catch (TimeoutException | IOException | URISyntaxException | NoSuchAlgorithmException | KeyManagementException e) {
      throw new RuntimeException(e);
    }

    while (!isStopped() && currentOffset < MAX_NUM_RECORDS) {
      if (currentOffset < testConsumer.getReceived().size()) {
        try {
          final String stringMessage = testConsumer.getReceived().get(currentOffset);
          LOG.info("Moving message from test consumer to receiver = " + stringMessage);
          STORED_RECORDS.add(stringMessage);
          store(stringMessage);
          currentOffset++;
        } catch (Exception e) {
          LOG.error("Exception " + e.getMessage());
        }
      }
    }

    if (isStopped() || testConsumer.getReceived().size() == MAX_NUM_RECORDS) {
      try {
        LOG.info("Stopping receiver");
        channel.close();
        connection.close();
      } catch (TimeoutException | IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  /** A simple RabbitMQ {@code Consumer} that stores all received messages. */
  static class TestConsumer extends DefaultConsumer {

    private final List<String> received;

    public TestConsumer(Channel channel) {
      super(channel);
      this.received = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void handleDelivery(
        String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
      try {
        LOG.info("adding message to test consumer " + new String(body, StandardCharsets.UTF_8));
        received.add(new String(body, StandardCharsets.UTF_8));
      } catch (Exception e) {
        LOG.error("Exception during reading from RabbitMQ " + e.getMessage());
      }
    }

    /** Returns a thread safe unmodifiable view of received messages. */
    public List<String> getReceived() {
      return Collections.unmodifiableList(received);
    }
  }
}

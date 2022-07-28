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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Imitation of Spark {@link Receiver} for RabbitMQ that doesn't implement {@link HasOffset} interface. Used to
 * test {@link SparkReceiverIO#read()}.
 */
public class RabbitMqReceiverWithoutOffset extends Receiver<String> {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitMqReceiverWithoutOffset.class);

  private final ConnectionFactory connectionFactory;
  private TestConsumer testConsumer;
  private Connection connection;
  private Channel channel;

  private static final int TIMEOUT_MS = 500;
  private static final List<String> STORED_RECORDS = new ArrayList<>();
  private static int MAX_NUM_RECORDS;
  private static String QUEUE_NAME;

  RabbitMqReceiverWithoutOffset(final String uri, final Integer maxNumRecords, final String queueName) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
    super(StorageLevel.MEMORY_AND_DISK_2());
    connectionFactory = new ConnectionFactory();
    connectionFactory.setUri(uri);
    connectionFactory.setAutomaticRecoveryEnabled(true);
    connectionFactory.setConnectionTimeout(60000);
    connectionFactory.setNetworkRecoveryInterval(5000);
    connectionFactory.setRequestedHeartbeat(60);
    connectionFactory.setTopologyRecoveryEnabled(true);
    connectionFactory.setRequestedChannelMax(0);
    connectionFactory.setRequestedFrameMax(0);
    MAX_NUM_RECORDS = maxNumRecords;
    QUEUE_NAME = queueName;
  }

  @Override
  @SuppressWarnings("FutureReturnValueIgnored")
  public void onStart() {
    try {
      System.out.println("Starting receiver");
      connection = connectionFactory.newConnection();
      channel = connection.createChannel();
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      testConsumer = new TestConsumer(channel);
      channel.basicConsume(QUEUE_NAME, true, testConsumer);
    } catch (TimeoutException | IOException e) {
      throw new RuntimeException(e);
    }

    Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().build()).submit(this::receive);
  }

  @Override
  public void onStop() {
    try {
      System.out.println("Stopping receiver");
      if (channel != null) {
        channel.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (TimeoutException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void receive() {
    int currentOffset = 0;
    while (!isStopped() && testConsumer.getReceived().size() < MAX_NUM_RECORDS) {
      if (currentOffset < MAX_NUM_RECORDS && testConsumer.getReceived().size() > currentOffset) {
        try {
          final String message = testConsumer.getReceived().get(currentOffset);
          System.out.println("Adding message to receiver's queue = " + message);
          STORED_RECORDS.add(message);
          store(message);
          currentOffset++;
        } catch (Exception e) {
          System.out.println("Exception " + e.getMessage());
        }
      }
      try {
        System.out.println("No messages in TestConsumer. Receiver is waiting");
        TimeUnit.MILLISECONDS.sleep(TIMEOUT_MS);
      } catch (InterruptedException e) {
        LOG.error("Interrupted", e);
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
        String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
        throws IOException {
      System.out.println("adding message to queue " + new String(body, StandardCharsets.UTF_8));
      received.add(new String(body, StandardCharsets.UTF_8));
    }

    /** Returns a thread safe unmodifiable view of received messages. */
    public List<String> getReceived() {
      return Collections.unmodifiableList(received);
    }
  }
}

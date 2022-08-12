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

import com.rabbitmq.stream.Environment;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.createStream;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getConsumer;
import static org.apache.beam.sdk.io.sparkreceiver.RabbitMqConnectionHelper.getEnvironment;

/**
 * Imitation of Spark {@link Receiver} for RabbitMQ that doesn't implement {@link HasOffset} interface. Used to
 * test {@link SparkReceiverIO#read()}.
 */
public class RabbitMqReceiverWithoutOffset extends Receiver<String> {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitMqReceiverWithoutOffset.class);

  private static String RABBITMQ_URL;
  private static String STREAM_NAME;

  RabbitMqReceiverWithoutOffset(final String uri, final String streamName) {
    super(StorageLevel.MEMORY_AND_DISK_2());
    STREAM_NAME = streamName;
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
    final AtomicInteger messageConsumed = new AtomicInteger(0);

    LOG.info("Starting receiver");
    try (final Environment environment = getEnvironment(RABBITMQ_URL)) {
      createStream(environment, STREAM_NAME);
      getConsumer(environment, STREAM_NAME, messageConsumed.get(), this::store);
    }
  }
}

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

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.spark.SparkConf;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.joda.time.Duration;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Test class for {@link SparkReceiverIO}. */
@RunWith(JUnit4.class)
public class SparkReceiverIOTest {

  @Rule public final transient TestPipeline p = TestPipeline.create();

  private static class CustomReceiverWithoutOffset extends Receiver<String> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomReceiverWithoutOffset.class);

    CustomReceiverWithoutOffset() {
      super(StorageLevel.MEMORY_AND_DISK_2());
    }

    @Override
    @SuppressWarnings("FutureReturnValueIgnored")
    public void onStart() {
      Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().build()).submit(this::receive);
    }

    @Override
    public void onStop() {}

    private void receive() {
      Long currentOffset = 0L;
      while (!isStopped()) {
        store((currentOffset++).toString());
        try {
          TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
          LOG.error("Interrupted", e);
        }
      }
    }
  }

  private static class CustomReceiverWithOffset extends Receiver<String> implements HasOffset {

    private static final Logger LOG = LoggerFactory.getLogger(CustomReceiverWithOffset.class);

    private Long startOffset;

    CustomReceiverWithOffset() {
      super(StorageLevel.MEMORY_AND_DISK_2());
    }

    @Override
    public void setStartOffset(Long startOffset) {
      if (startOffset != null) {
        this.startOffset = startOffset;
      }
    }

    @Override
    @SuppressWarnings("FutureReturnValueIgnored")
    public void onStart() {
      Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().build()).submit(this::receive);
    }

    @Override
    public void onStop() {}

    @Override
    public Long getEndOffset() {
      return Long.MAX_VALUE;
    }

    private void receive() {
      Long currentOffset = startOffset;
      while (!isStopped()) {
        store((currentOffset++).toString());
        try {
          TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
          LOG.error("Interrupted", e);
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static class CustomSparkConsumer<V> implements SparkConsumer<V> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomSparkConsumer.class);

    private static final Queue<Object> queue = new ConcurrentLinkedQueue<>();
    private Receiver<V> sparkReceiver;

    @Override
    public V poll() {
      return (V) queue.poll();
    }

    @Override
    public void start(Receiver<V> sparkReceiver) {
      try {
        this.sparkReceiver = sparkReceiver;
        new WrappedSupervisor(
            sparkReceiver,
            new SparkConf(),
            objects -> {
              queue.offer(objects[0]);
              return null;
            });
        sparkReceiver.supervisor().startReceiver();
      } catch (Exception e) {
        LOG.error("Can not init Spark Receiver!", e);
      }
    }

    @Override
    public void stop() {
      queue.clear();
      sparkReceiver.stop("Stopped");
    }

    @Override
    public boolean hasRecords() {
      return !queue.isEmpty();
    }
  }

  @Test
  public void testReadFromCustomReceiverWithOffset() {

    ReceiverBuilder<String, CustomReceiverWithOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> reader =
        SparkReceiverIO.<String>read()
            .withValueClass(String.class)
            .withValueCoder(StringUtf8Coder.of())
            .withGetOffsetFn(Long::valueOf)
            .withSparkReceiverBuilder(receiverBuilder);

    p.apply(reader).setCoder(StringUtf8Coder.of());
    p.run().waitUntilFinish(Duration.standardSeconds(30));
  }

  @Test
  public void testReadFromCustomReceiverWithoutOffset() {

    ReceiverBuilder<String, CustomReceiverWithoutOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithoutOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> reader =
        SparkReceiverIO.<String>read()
            .withValueClass(String.class)
            .withValueCoder(StringUtf8Coder.of())
            .withGetOffsetFn(Long::valueOf)
            .withSparkConsumer(new CustomSparkConsumer<>())
            .withSparkReceiverBuilder(receiverBuilder);

    p.apply(reader).setCoder(StringUtf8Coder.of());
    p.run().waitUntilFinish(Duration.standardSeconds(30));
  }
}

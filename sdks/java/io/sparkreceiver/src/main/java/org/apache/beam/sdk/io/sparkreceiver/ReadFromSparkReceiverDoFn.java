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
import java.util.concurrent.TimeUnit;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.io.range.OffsetRange;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.DoFn.UnboundedPerElement;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.transforms.splittabledofn.GrowableOffsetRangeTracker;
import org.apache.beam.sdk.transforms.splittabledofn.ManualWatermarkEstimator;
import org.apache.beam.sdk.transforms.splittabledofn.OffsetRangeTracker;
import org.apache.beam.sdk.transforms.splittabledofn.RestrictionTracker;
import org.apache.beam.sdk.transforms.splittabledofn.WatermarkEstimator;
import org.apache.beam.sdk.transforms.splittabledofn.WatermarkEstimators;
import org.apache.beam.sdk.transforms.windowing.BoundedWindow;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.receiver.Receiver;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.joda.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("nullness")
@UnboundedPerElement
public class ReadFromSparkReceiverDoFn<V> extends DoFn<byte[], V> {

  private static final Logger LOG = LoggerFactory.getLogger(ReadFromSparkReceiverDoFn.class);
  private static final int START_POLL_TIMEOUT_MS = 500;
  private static final int CONTINUE_POLL_TIMEOUT_MS = 300;

  private final SerializableFunction<Instant, WatermarkEstimator<Instant>>
      createWatermarkEstimatorFn;
  private final SerializableFunction<V, Long> getOffsetFn;
  private final ReceiverBuilder<V, ? extends Receiver<V>> sparkReceiverBuilder;
  private Receiver<V> sparkReceiver;
  private SparkConsumer<V> sparkConsumer;

  public ReadFromSparkReceiverDoFn(SparkReceiverIO.Read<V> transform) {
    createWatermarkEstimatorFn = WatermarkEstimators.Manual::new;
    sparkReceiverBuilder = transform.getSparkReceiverBuilder();
    getOffsetFn = transform.getGetOffsetFn();
    if (sparkReceiverBuilder != null && !receiverHasOffset()) {
      sparkConsumer = transform.getSparkConsumer();
      try {
        sparkReceiver = sparkReceiverBuilder.build();
        sparkConsumer.start(sparkReceiver);
      } catch (Exception e) {
        LOG.error("Can not build Spark Receiver", e);
      }
    }
  }

  @GetInitialRestriction
  public OffsetRange initialRestriction(@Element byte[] element) {
    return new OffsetRange(0, Long.MAX_VALUE);
  }

  @GetInitialWatermarkEstimatorState
  public Instant getInitialWatermarkEstimatorState(@Timestamp Instant currentElementTimestamp) {
    return currentElementTimestamp;
  }

  @NewWatermarkEstimator
  public WatermarkEstimator<Instant> newWatermarkEstimator(
      @WatermarkEstimatorState Instant watermarkEstimatorState) {
    return createWatermarkEstimatorFn.apply(ensureTimestampWithinBounds(watermarkEstimatorState));
  }

  @GetSize
  public double getSize(@Element byte[] element, @Restriction OffsetRange offsetRange) {
    return restrictionTracker(element, offsetRange).getProgress().getWorkRemaining();
    // Before processing elements, we don't have a good estimated size of records and offset gap.
  }

  private class SparkReceiverLatestOffsetEstimator
      implements GrowableOffsetRangeTracker.RangeEndEstimator {

    public SparkReceiverLatestOffsetEstimator() {}

    @Override
    public long estimate() {
      if (receiverHasOffset()) {
        return ((HasOffset) sparkReceiver).getEndOffset();
      }
      return Long.MAX_VALUE;
    }
  }

  private boolean receiverHasOffset() {
    return HasOffset.class.isAssignableFrom(sparkReceiverBuilder.getSparkReceiverClass());
  }

  @NewTracker
  public OffsetRangeTracker restrictionTracker(
      @Element byte[] element, @Restriction OffsetRange restriction) {
    return new GrowableOffsetRangeTracker(
        restriction.getFrom(), new SparkReceiverLatestOffsetEstimator()) {};
  }

  @GetRestrictionCoder
  public Coder<OffsetRange> restrictionCoder() {
    return new OffsetRange.Coder();
  }

  @Setup
  public void setup() throws Exception {
    // Start to track record size and offset gap per bundle.
  }

  @Teardown
  public void teardown() throws Exception {
    // Closeables close
    LOG.debug("Teardown");
    if (!receiverHasOffset()) {
      sparkConsumer.stop();
    }
  }

  @SuppressWarnings("unchecked")
  private static class SparkConsumerWithOffset<V> implements SparkConsumer<V> {
    private final Queue<V> recordsQueue = new ConcurrentLinkedQueue<>();
    private Receiver<V> sparkReceiver;
    private final Long startOffset;

    public SparkConsumerWithOffset(Long startOffset) {
      this.startOffset = startOffset;
    }

    @Override
    public boolean hasRecords() {
      return !recordsQueue.isEmpty();
    }

    @Override
    public V poll() {
      return recordsQueue.poll();
    }

    @Override
    public void start(Receiver<V> sparkReceiver) {
      this.sparkReceiver = sparkReceiver;
      try {
        new WrappedSupervisor(
            sparkReceiver,
            new SparkConf(),
            objects -> {
              V record = (V) objects[0];
              recordsQueue.offer(record);
              return null;
            });
      } catch (Exception e) {
        LOG.error("Can not init Spark Receiver!", e);
      }
      ((HasOffset) sparkReceiver).setStartOffset(startOffset);
      sparkReceiver.supervisor().startReceiver();
      try {
        TimeUnit.MILLISECONDS.sleep(START_POLL_TIMEOUT_MS);
      } catch (InterruptedException e) {
        LOG.error("Interrupted", e);
      }
    }

    @Override
    public void stop() {
      sparkReceiver.stop("Stopped");
      recordsQueue.clear();
    }
  }

  @ProcessElement
  public ProcessContinuation processElement(
      @Element byte[] element,
      RestrictionTracker<OffsetRange, Long> tracker,
      WatermarkEstimator<Instant> watermarkEstimator,
      OutputReceiver<V> receiver) {

    if (receiverHasOffset()) {
      try {
        this.sparkReceiver = sparkReceiverBuilder.build();
        this.sparkConsumer = new SparkConsumerWithOffset<>(tracker.currentRestriction().getFrom());
        sparkConsumer.start(sparkReceiver);
      } catch (Exception e) {
        LOG.error("Can not build Spark Receiver", e);
      }
    }

    while (sparkConsumer.hasRecords()) {
      V record = sparkConsumer.poll();
      if (record != null) {
        Long offset = getOffsetFn.apply(record);
        if (!tracker.tryClaim(offset)) {
          if (receiverHasOffset()) {
            sparkConsumer.stop();
          }
          LOG.debug(
              "ProcessContinuation.stop for restriction {}",
              tracker.currentRestriction().toString());
          return ProcessContinuation.stop();
        }
        ((ManualWatermarkEstimator<Instant>) watermarkEstimator).setWatermark(Instant.now());
        receiver.outputWithTimestamp(record, Instant.now());
      }
    }
    if (receiverHasOffset()) {
      sparkConsumer.stop();
    } else {
      try {
        TimeUnit.MILLISECONDS.sleep(CONTINUE_POLL_TIMEOUT_MS);
      } catch (InterruptedException e) {
        LOG.error("Interrupted", e);
      }
    }
    LOG.info("Current restriction: {}", tracker.currentRestriction().toString());
    return ProcessContinuation.resume();
  }

  private static Instant ensureTimestampWithinBounds(Instant timestamp) {
    if (timestamp.isBefore(BoundedWindow.TIMESTAMP_MIN_VALUE)) {
      timestamp = BoundedWindow.TIMESTAMP_MIN_VALUE;
    } else if (timestamp.isAfter(BoundedWindow.TIMESTAMP_MAX_VALUE)) {
      timestamp = BoundedWindow.TIMESTAMP_MAX_VALUE;
    }
    return timestamp;
  }
}

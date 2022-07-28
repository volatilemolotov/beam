package org.apache.beam.sdk.io.sparkreceiver;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.receiver.Receiver;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Imitation of {@link SparkConsumer} for RabbitMQ that stores records into static {@link Queue}. Used to test
 * {@link SparkReceiverIO#read()}.
 */
@SuppressWarnings("unchecked")
public class RabbitMqConsumer<V> implements SparkConsumer<V> {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitMqConsumer.class);

  private static final Queue<Object> queue = new ConcurrentLinkedQueue<>();
  private Receiver<V> sparkReceiver;

  @Override
  public boolean hasRecords() {
    System.out.println("Checking if queue has records = " + !queue.isEmpty());
    return !queue.isEmpty();
  }

  @Override
  public @Nullable V poll() {
    System.out.println("Polling element from queue");
    final V v = (V) queue.poll();
    System.out.println("Polling element from queue " + (v != null ? v.toString() : ""));
    return v;
  }

  @Override
  public void start(Receiver<V> sparkReceiver) {
    try {
      System.out.println("Starting consumer");
      this.sparkReceiver = sparkReceiver;
      new WrappedSupervisor(sparkReceiver, new SparkConf(), objects -> {
        System.out.println("Moving message from receiver to consumer " + objects[0]);
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
    System.out.println("Stopping consumer");
    queue.clear();
    sparkReceiver.stop("Stopped");
  }
}
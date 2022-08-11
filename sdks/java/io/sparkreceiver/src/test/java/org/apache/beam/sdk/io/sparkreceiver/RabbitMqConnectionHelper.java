package org.apache.beam.sdk.io.sparkreceiver;

import com.rabbitmq.stream.Address;
import com.rabbitmq.stream.Consumer;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler;
import com.rabbitmq.stream.OffsetSpecification;
import com.rabbitmq.stream.Producer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Queue;

public class RabbitMqConnectionHelper {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitMqConnectionHelper.class);

  @SuppressWarnings("StringSplitter")
  public static Environment getEnvironment(final String serverAddress) {
    final String hostPort = serverAddress.split("rabbitmq-stream://guest:guest@")[1];
    final String host = hostPort.split(":")[0];
    final int port = Integer.parseInt(hostPort.split(":")[1]);
    return Environment.builder()
        .addressResolver(address -> new Address(host, port))
        .uri(serverAddress)
        .host(host)
        .port(port)
        .build();
  }

  public static void createStream(final Environment environment, final String streamName) {
    environment.streamCreator().stream(streamName).create();
  }

  public static Producer getProducer(final Environment environment, final String streamName) {
    return environment
        .producerBuilder()
        .stream(streamName) // stream to publish to
        .build();
  }

  public static Message getMessage(final Producer producer, final String message, final long messageId) {
    return producer.messageBuilder()
        .properties()
        .creationTime(System.currentTimeMillis())
        .messageId(messageId)
        .messageBuilder()
        .addData(message.getBytes(StandardCharsets.UTF_8))
        .build();
  }

  public static Consumer getConsumer(final Environment environment, final String streamName, final long currentOffset, final Queue<String> received) {
    return environment.consumerBuilder()
        .stream(streamName) // the stream to consume from
        .offset(OffsetSpecification.offset(currentOffset)) // start consuming at the beginning
//        .name("myApp")
//        .manualTrackingStrategy().builder()
        .messageHandler(getMessageHandler(received))
        .build();
  }

  @NotNull
  public static MessageHandler getMessageHandler(Queue<String> received) {
    return (context, message) -> {
      // ... message processing ...
      try {
        final String sMessage = new String(message.getBodyAsBinary(), StandardCharsets.UTF_8);
        LOG.info("adding message to test consumer " + sMessage);
//        System.out.println("adding message to test consumer " + sMessage);
        received.add(sMessage);
      } catch (Exception e) {
        LOG.error("Exception during reading from RabbitMQ " + e.getMessage());
      }

      context.storeOffset(); // store the message offset
      // ...
    };
  }
}

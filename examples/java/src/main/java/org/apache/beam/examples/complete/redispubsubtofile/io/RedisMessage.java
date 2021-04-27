package org.apache.beam.examples.complete.redispubsubtofile.io;

public class RedisMessage {

  private final String channel;
  private final String value;

  public RedisMessage(
      String channel,
      String value) {
    this.channel = channel;
    this.value = value;
  }

  public String getChannel() {
    return channel;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {

    return new StringBuilder()
        .append("RedisMessage{")
        .append(channel)
        .append(" -> ")
        .append(value)
        .append("}")
        .toString();
  }
}

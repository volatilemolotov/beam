package org.apache.beam.examples.complete.redispubsubtofile.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.coders.StructuredCoder;
import org.codehaus.jackson.map.ObjectMapper;

@SuppressWarnings({
    "rawtypes", // TODO(https://issues.apache.org/jira/browse/BEAM-10556)
    "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisMessageCoder extends StructuredCoder<RedisMessage> {

  private static final StringUtf8Coder stringCoder = StringUtf8Coder.of();
  private static final RedisMessageCoder instance = new RedisMessageCoder();
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public RedisMessageCoder() {

  }

  public static RedisMessageCoder of() {
    return new RedisMessageCoder();
  }

  @Override
  public void encode(RedisMessage value,
      OutputStream outStream)
      throws CoderException, IOException {
    stringCoder.encode(value.getChannel(), outStream);
    stringCoder.encode(value.getValue(), outStream);
  }

  @Override
  public RedisMessage decode(InputStream inStream)
      throws CoderException, IOException {
    return new RedisMessage(
        stringCoder.decode(inStream),
        stringCoder.decode(inStream)
    );
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Arrays.asList(stringCoder, stringCoder);
  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {
    stringCoder.verifyDeterministic();
  }
}

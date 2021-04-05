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
package org.apache.beam.examples.complete.redisstream.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.StructuredCoder;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.StreamEntry;

@SuppressWarnings({
  "rawtypes", // TODO(https://issues.apache.org/jira/browse/BEAM-10556)
  "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisStreamEntryCoder extends StructuredCoder<StreamEntry> {
  private static final RedisStreamEntryCoder instance = new RedisStreamEntryCoder();
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static RedisStreamEntryCoder of() {
    return instance;
  }

  @Override
  public void encode(StreamEntry value, OutputStream outStream) throws CoderException, IOException {
    objectMapper.writeValue(outStream, value);
  }

  @Override
  public StreamEntry decode(InputStream inStream) throws CoderException, IOException {
    return objectMapper.readValue(inStream, StreamEntry.class);
  }

  @Override
  public List<? extends Coder<?>> getCoderArguments() {
    return Collections.emptyList();
  }

  @Override
  public void verifyDeterministic() throws NonDeterministicException {}
}

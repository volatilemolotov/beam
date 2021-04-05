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
import java.util.NoSuchElementException;
import org.apache.beam.sdk.io.UnboundedSource;
import org.apache.beam.sdk.io.UnboundedSource.UnboundedReader;
import org.joda.time.Instant;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.StreamEntry;

@SuppressWarnings({
  "rawtypes", // TODO(https://issues.apache.org/jira/browse/BEAM-10556)
  "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisStreamReader extends UnboundedReader<StreamEntry> {
  private final RedisStreamSource source;
  private final RedisStreamCheckpointMark checkpointMark;

  private JedisPool jedisPool;
  private Jedis jedis;

  public RedisStreamReader(RedisStreamSource source, RedisStreamCheckpointMark checkpointMark) {
    this.source = source;
    this.checkpointMark = checkpointMark;
  }

  @Override
  public boolean start() throws IOException {
    jedisPool = source.getSpec().connectConfig().connect();
    jedis = jedisPool.getResource();

    return true;
  }

  @Override
  public boolean advance() throws IOException {
    return false;
  }

  @Override
  public StreamEntry getCurrent() throws NoSuchElementException {
    return null;
  }

  @Override
  public Instant getCurrentTimestamp() throws NoSuchElementException {
    return null;
  }

  @Override
  public void close() throws IOException {
    jedisPool.close();
  }

  @Override
  public Instant getWatermark() {
    return checkpointMark.oldestInstant;
  }

  @Override
  public UnboundedSource.CheckpointMark getCheckpointMark() {
    return new RedisStreamCheckpointMark();
  }

  @Override
  public UnboundedSource<StreamEntry, ?> getCurrentSource() {
    return source;
  }
}

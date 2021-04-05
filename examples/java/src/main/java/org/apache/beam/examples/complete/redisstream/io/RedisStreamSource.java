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

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.beam.examples.complete.redisstream.io.RedisStreamIO.Read;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.io.UnboundedSource;
import org.apache.beam.sdk.options.PipelineOptions;
import redis.clients.jedis.StreamEntry;

@SuppressWarnings({
  "nullness" // TODO(https://issues.apache.org/jira/browse/BEAM-10402)
})
public class RedisStreamSource extends UnboundedSource<StreamEntry, RedisStreamCheckpointMark> {
  private final RedisStreamIO.Read spec;

  public RedisStreamSource(Read spec) {
    this.spec = spec;
  }

  public Read getSpec() {
    return spec;
  }

  @Override
  public List<? extends UnboundedSource<StreamEntry, RedisStreamCheckpointMark>> split(
      int desiredNumSplits, PipelineOptions options) throws Exception {
    List<String> streams = new ArrayList<>(spec.streams());

    checkState(
        streams.size() > 0,
        "Could not find any streams. Please check Redis configuration and stream names.");

    if (streams.size() == 1) {
      return Collections.singletonList(this);
    }

    int splitCount = Math.min(desiredNumSplits, streams.size());
    while (streams.size() % splitCount > 0) {
      ++splitCount;
    }

    List<RedisStreamSource> result = new ArrayList<>(splitCount);

    for (int i = 0; i < splitCount; i++) {
      int expectedStreams = streams.size() / splitCount;
      int fromIndex = i * expectedStreams;
      int toIndex = fromIndex + expectedStreams;

      List<String> splitStreams = streams.subList(fromIndex, toIndex);
      result.add(new RedisStreamSource(spec.builder().setStreams(splitStreams).build()));
    }

    return result;
  }

  @Override
  public UnboundedReader<StreamEntry> createReader(
      PipelineOptions options, RedisStreamCheckpointMark checkpointMark) {
    return new RedisStreamReader(this, checkpointMark);
  }

  @Override
  public Coder<RedisStreamCheckpointMark> getCheckpointMarkCoder() {
    return AvroCoder.of(RedisStreamCheckpointMark.class);
  }

  @Override
  public Coder<StreamEntry> getOutputCoder() {
    return RedisStreamEntryCoder.of();
  }
}

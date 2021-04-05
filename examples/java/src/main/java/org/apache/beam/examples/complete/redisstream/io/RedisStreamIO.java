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

import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.List;
import org.apache.beam.sdk.annotations.Experimental;
import org.apache.beam.sdk.annotations.Experimental.Kind;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import redis.clients.jedis.StreamEntry;

@Experimental(Kind.SOURCE_SINK)
public class RedisStreamIO {
  public static Read read() {
    return new AutoValue_RedisStreamIO_Read.Builder()
        .setConnectConfig(RedisStreamConnectConfig.create())
        .setStreams(Collections.emptyList())
        .build();
  }

  @AutoValue
  public abstract static class Read extends PTransform<PBegin, PCollection<StreamEntry>> {
    abstract RedisStreamConnectConfig connectConfig();

    abstract List<String> streams();

    abstract Builder builder();

    @AutoValue.Builder
    abstract static class Builder {
      abstract Builder setConnectConfig(RedisStreamConnectConfig connectConfig);

      abstract Builder setStreams(List<String> streams);

      abstract Read build();
    }

    public Read withHost(String host) {
      return builder().setConnectConfig(connectConfig().withHost(host)).build();
    }

    public Read withPort(Integer port) {
      return builder().setConnectConfig(connectConfig().withPort(port)).build();
    }

    public Read withStreams(List<String> streams) {
      return builder().setStreams(streams).build();
    }

    @Override
    public PCollection<StreamEntry> expand(PBegin input) {
      return input.apply(org.apache.beam.sdk.io.Read.from(new RedisStreamSource(this)));
    }
  }
}

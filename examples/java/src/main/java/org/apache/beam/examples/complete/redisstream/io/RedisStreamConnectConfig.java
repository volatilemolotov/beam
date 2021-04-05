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

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;

import com.google.auto.value.AutoValue;
import java.io.Serializable;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

@AutoValue
public abstract class RedisStreamConnectConfig implements Serializable {
  abstract ValueProvider<String> host();

  abstract ValueProvider<Integer> port();

  abstract Build builder();

  @AutoValue.Builder
  public abstract static class Build {
    abstract Build setHost(ValueProvider<String> host);

    abstract Build setPort(ValueProvider<Integer> port);

    abstract RedisStreamConnectConfig build();
  }

  public RedisStreamConnectConfig withHost(String host) {
    checkArgument(StringUtils.isNoneEmpty(host), "Host can't be null or empty.");

    return withHost(ValueProvider.StaticValueProvider.of(host));
  }

  public RedisStreamConnectConfig withHost(ValueProvider<String> host) {
    return builder().setHost(host).build();
  }

  public RedisStreamConnectConfig withPort(Integer port) {
    checkArgument(port != null && port > 0, "Port can't be null, negative or 0.");

    return withPort(ValueProvider.StaticValueProvider.of(port));
  }

  public RedisStreamConnectConfig withPort(ValueProvider<Integer> port) {
    return builder().setPort(port).build();
  }

  public static RedisStreamConnectConfig create() {
    return new AutoValue_RedisStreamConnectConfig.Builder()
        .setHost(ValueProvider.StaticValueProvider.of(Protocol.DEFAULT_HOST))
        .setPort(ValueProvider.StaticValueProvider.of(Protocol.DEFAULT_PORT))
        .build();
  }

  public JedisPool connect() {
    return new JedisPool(host().get(), port().get());
  }
}

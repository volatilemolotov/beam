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
package org.apache.beam.examples.complete.redisstream.templates;

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.beam.examples.complete.redisstream.io.RedisStreamIO;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.StreamEntry;

public class RedisStreamToPubSub {

  private static final Logger LOGGER = LoggerFactory.getLogger(RedisStreamToPubSub.class);

  public static void main(String[] args) {
    RedisStreamToPubSubOption options =
        PipelineOptionsFactory.fromArgs(args).withValidation().as(RedisStreamToPubSubOption.class);

    run(options);
  }

  private static void run(RedisStreamToPubSubOption options) {
    Pipeline pipeline = Pipeline.create(options);

    final PCollection<StreamEntry> result =
        pipeline.apply(
            RedisStreamIO.read()
                .withHost(checkAndGetHost(options.getRedisHost()))
                .withPort(checkAndGetPort(options.getRedisPort()))
                .withStreams(checkAndGetStreamAsList(options.getRedisStreams())));

    pipeline.run();
  }

  private static String checkAndGetHost(String host) {
    checkArgument(host != null, "Missing required option --redisHost");

    return host;
  }

  private static Integer checkAndGetPort(String port) {
    checkArgument(port != null, "Missing required option --redisPort");

    try {
      return Integer.parseInt(port);
    } catch (NumberFormatException e) {
      String errorMessage = "Incorrect format of option --redisPort";
      LOGGER.error(errorMessage);
      throw new IllegalArgumentException(errorMessage, e);
    }
  }

  private static List<String> checkAndGetStreamAsList(String streamsAsString) {
    checkArgument(streamsAsString != null, "Missing required option --redisStreams.");

    final List<String> streams =
        Arrays.stream(streamsAsString.split(",")).map(String::trim).collect(Collectors.toList());

    checkArgument(
        streams.size() > 0 && StringUtils.isNoneBlank(streams.get(0)),
        "Option --redisStream can't be empty.");

    return streams;
  }
}

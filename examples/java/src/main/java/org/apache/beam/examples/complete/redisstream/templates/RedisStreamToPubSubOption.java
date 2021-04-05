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

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;

public interface RedisStreamToPubSubOption extends PipelineOptions {
  @Description("Host of Redis Stream.")
  @Validation.Required
  String getRedisHost();

  void setRedisHost(String redisHost);

  @Description("Port of Redis Stream.")
  @Validation.Required
  String getRedisPort();

  void setRedisPort(String redisPort);

  @Description("Comma separated list of Redis Stream(s) to read input from (eg: stream1, stream2).")
  @Validation.Required
  String getRedisStreams();

  void setRedisStreams(String redisStreams);
}

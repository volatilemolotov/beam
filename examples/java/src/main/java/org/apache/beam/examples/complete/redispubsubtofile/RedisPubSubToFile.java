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
package org.apache.beam.examples.complete.redispubsubtofile;

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;
import org.apache.beam.examples.complete.redispubsubtofile.io.RedisPubSubIO;
import org.apache.beam.examples.complete.redispubsubtofile.io.RedisPubSubIO.ReadRedisMessageFn;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisPubSubToFile {

  /* Logger for class */
  private static final Logger LOG = LoggerFactory.getLogger(RedisPubSubToFile.class);

  public static void main(String[] args) {
    RedisPubSubToFileOptions options = PipelineOptionsFactory.fromArgs(args)
        .withValidation().as(RedisPubSubToFileOptions.class);

    run(options);
  }

  public static void run(RedisPubSubToFileOptions options) {
    checkArgument(!Arrays.asList(options.getChannels()).isEmpty(),
        "List of channels must not be an empty");

    Pipeline pipeline = Pipeline.create(options);
    pipeline.apply(RedisPubSubIO.readMessage()
        .withHost(options.getHost())
        .withPort(options.getPort())
        .withChannels(options.getChannels()))
        .apply(ParDo.of(new ReadRedisMessageFn()))
        .apply(Window.<String>into(FixedWindows.of(Duration.standardSeconds(30))))
        .apply("WriteData",
            TextIO.write().withWindowedWrites().withNumShards(1).to(options.getOutputFilePath()));

    pipeline.run().waitUntilFinish();
  }
}

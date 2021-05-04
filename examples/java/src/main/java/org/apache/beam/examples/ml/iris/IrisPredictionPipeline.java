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
package org.apache.beam.examples.ml.iris;

import static org.apache.beam.examples.ml.iris.KafkaUtils.checkAndGetTopicsAsList;
import static org.apache.beam.examples.ml.iris.KafkaUtils.checkBootstrapServers;
import static org.apache.beam.examples.ml.iris.KafkaUtils.getConsumerConfig;
import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import java.util.List;
import java.util.Map;
import org.apache.beam.examples.ml.iris.IrisPrediction.IrisPredictionTransform;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.TextIO.Write;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.Values;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.joda.time.Duration;

public class IrisPredictionPipeline {

  public static void main(String[] args) {
    final IrisPredictionPipelineOptions options =
        PipelineOptionsFactory.fromArgs(args).as(IrisPredictionPipelineOptions.class);

    Pipeline pipeline = Pipeline.create(options);
    run(pipeline, options);
  }

  private static void run(Pipeline pipeline, IrisPredictionPipelineOptions options) {
    checkBootstrapServers(options.getBootstrapServers());

    List<String> topics = checkAndGetTopicsAsList(options.getInputTopics());
    Map<String, Object> consumerConfig = getConsumerConfig(options.getKafkaConsumerConfig());

    checkArgument(
        isNoneBlank(options.getEndpointUrl()), "Endpoint url of AI platform cannot be empty.");
    checkArgument(isNoneBlank(options.getProjectId()), "Project id cannot be empty.");
    checkArgument(isNoneBlank(options.getLocation()), "Location cannot be empty.");
    checkArgument(isNoneBlank(options.getEndpointId()), "Endpoint id cannot be empty.");

    pipeline
        .apply(
            "readFromKafka", readFromKafka(options.getBootstrapServers(), topics, consumerConfig))
        .apply("createValues", Values.create())
        .apply("predict", predict(options))
        .apply("window", Window.into(FixedWindows.of(Duration.standardSeconds(30))))
        .apply("writeToTextFile", writeToFile(options));

    pipeline.run();
  }

  private static PTransform<PBegin, PCollection<KV<String, String>>> readFromKafka(
      String bootstrapServers, List<String> topics, Map<String, Object> consumerConfig) {

    return KafkaIO.<String, String>read()
        .withBootstrapServers(bootstrapServers)
        .withTopics(topics)
        .withKeyDeserializer(StringDeserializer.class)
        .withValueDeserializer(StringDeserializer.class)
        .withConsumerConfigUpdates(consumerConfig)
        .withoutMetadata();
  }

  private static PTransform<PCollection<String>, PCollection<String>> predict(
      IrisPredictionPipelineOptions options) {
    checkArgument(
        isNoneBlank(options.getEndpointUrl()), "Endpoint url of AI platform cannot be empty.");
    checkArgument(isNoneBlank(options.getProjectId()), "Project id cannot be empty.");
    checkArgument(isNoneBlank(options.getLocation()), "Location cannot be empty.");
    checkArgument(isNoneBlank(options.getEndpointId()), "Endpoint id cannot be empty.");

    return IrisPredictionTransform.newBuilder()
        .setEndpointUrl(options.getEndpointUrl())
        .setProjectId(options.getProjectId())
        .setEndpointId(options.getEndpointId())
        .setLocation(options.getLocation())
        .build();
  }

  private static Write writeToFile(IrisPredictionPipelineOptions options) {
    checkArgument(StringUtils.isNoneBlank(options.getOutputDirectory(), "Output directory cannot be empty."));

    return TextIO.write()
        .to(options.getOutputDirectory())
        .withWindowedWrites()
        .withNumShards(20)
        .withSuffix(".csv");
  }
}

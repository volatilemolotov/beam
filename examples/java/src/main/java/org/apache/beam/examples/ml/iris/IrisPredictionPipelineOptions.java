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

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface IrisPredictionPipelineOptions extends PipelineOptions {

  @Description(
      "Comma Separated list of Kafka Bootstrap Servers (e.g: server1:[port],server2:[port]).")
  String getBootstrapServers();

  void setBootstrapServers(String bootstrapServers);

  @Description(
      "Comma Separated list of Kafka topic(s) to read the input from (e.g: topic1,topic2).")
  String getInputTopics();

  void setInputTopics(String inputTopics);

  @Description(
      "Additional kafka consumer configs to be applied to Kafka Consumer (e.g. key1=value1;key2=value2).")
  String getKafkaConsumerConfig();

  void setKafkaConsumerConfig(String kafkaConfig);

  @Description("Endpoint to serve predictions.")
  String getEndpointUrl();

  void setEndpointUrl(String endpointUrl);

  @Description("Project id that model is deployed in.")
  String getProjectId();

  void setProjectId(String projectId);

  @Description("Region that is used by deployed model.")
  String getLocation();

  void setLocation(String location);

  @Description("Endpoint id to deployed model.")
  String getEndpointId();

  void setEndpointId(String endpointId);

  @Description("The directory to write output files. Must end with a slash. ")
  String getOutputDirectory();

  void setOutputDirectory(String outputDirectory);
}

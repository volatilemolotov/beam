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
package org.apache.beam.examples.complete.cdap;

import io.cdap.cdap.api.data.format.StructuredRecord;
import org.apache.beam.examples.complete.cdap.options.CdapZendeskToCdapHubspotOptions;
import org.apache.beam.examples.complete.cdap.transforms.FormatInputTransform;
import org.apache.beam.examples.complete.cdap.transforms.FormatOutputTransform;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.NullableCoder;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.io.hadoop.WritableCoder;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.MapValues;
import org.apache.beam.sdk.values.TypeDescriptors;
import org.apache.hadoop.io.NullWritable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link CdapZendeskToCdapHubspot} pipeline is a streaming pipeline which ingests data in JSON format from
 * CDAP Zendesk, and outputs the resulting records to CDAP Hubspot. Input topics, output topic, Bootstrap servers
 * are specified by the user as template parameters. <br>
 *
 * <p><b>Pipeline Requirements</b>
 *
 * <ul>
 *   <li>CDAP Bootstrap Server(s).
 *   <li>The CDAP Zendesk input stream.
 *   <li>The CDAP Hubspot output stream.
 * </ul>
 *
 * <p><b>Example Usage</b>
 *
 * <pre>
 * # Gradle preparation
 *
 * To run this example your {@code build.gradle} file should contain the following task
 * to execute the pipeline:
 * {@code
 * task execute (type:JavaExec) {
 *     mainClass = System.getProperty("mainClass")
 *     classpath = sourceSets.main.runtimeClasspath
 *     systemProperties System.getProperties()
 *     args System.getProperty("exec.args", "").split()
 * }
 * }
 *
 * This task allows to run the pipeline via the following command:
 * {@code
 * gradle clean execute -DmainClass=org.apache.beam.examples.complete.cdap.CdapZendeskToCdapHubspot \
 *      -Dexec.args="--<argument>=<value> --<argument>=<value>"
 * }
 *
 * # Running the pipeline
 * To execute this pipeline, specify the parameters:
 *
 * - CDAP Bootstrap servers
 * - CDAP Zendesk input stream
 * - CDAP Hubspot output stream
 *
 * in the following format:
 * {@code
 * --bootstrapServers=host:port \
 * --inputTopics=your-input-topic \
 * --outputTopic=projects/your-project-id/topics/your-topic-name
 * }
 *
 * By default this will run the pipeline locally with the DirectRunner. To change the runner, specify:
 * {@code
 * --runner=YOUR_SELECTED_RUNNER
 * }
 * </pre>
 *
 * <p><b>Example Zendesk and Hubspot usage</b>
 *
 * <pre>
 * This template contains an example Class to deserialize Zendesk messages and send them to Hubspot via Cdap.
 * </pre>
 */
public class CdapZendeskToCdapHubspot {

  /* Logger for class.*/
  private static final Logger LOG = LoggerFactory.getLogger(CdapZendeskToCdapHubspot.class);

  /**
   * Main entry point for pipeline execution.
   *
   * @param args Command line arguments to the pipeline.
   */
  public static void main(String[] args) {
    CdapZendeskToCdapHubspotOptions options =
        PipelineOptionsFactory.fromArgs(args).withValidation().as(CdapZendeskToCdapHubspotOptions.class);

    // Create the pipeline
    Pipeline pipeline = Pipeline.create(options);
    run(pipeline, options);
  }

  /**
   * Runs a pipeline which reads message from CDAP and writes it to RabbitMq.
   *
   * @param options arguments to the pipeline
   */
  public static PipelineResult run(Pipeline pipeline, CdapZendeskToCdapHubspotOptions options) {
    LOG.info(
        "Starting Cdap-Zendesk-To-Cdap-Hubspot pipeline with parameters bootstrap servers:"
            + "\nZendesk parameters:\n"
            + options.getCdapZendeskParams()
            + "\nHubspot parameters"
            + options.getCdapHubspotParams());

    /*
     * Steps:
     *  1) Read messages in from Cdap Zendesk
     *  2) Extract values only
     *  3) Write successful records to Cdap Hubspot
     */

    pipeline
        .apply("readFromCdapZendesk", FormatInputTransform.readFromCdapZendesk(options.getCdapZendeskParams()))
        .setCoder(
            KvCoder.of(
                NullableCoder.of(WritableCoder.of(NullWritable.class)),
                SerializableCoder.of(StructuredRecord.class)))
        .apply(MapValues.into(TypeDescriptors.strings()).via(Object::toString))
        .apply("writeToCdapHubspot", FormatOutputTransform.writeToCdapHubspot(options.getCdapHubspotParams()));

    return pipeline.run();
  }
}

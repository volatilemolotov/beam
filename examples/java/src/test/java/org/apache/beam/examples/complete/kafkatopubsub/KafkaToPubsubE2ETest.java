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
package org.apache.beam.examples.complete.kafkatopubsub;

import static org.apache.beam.examples.complete.kafkatopubsub.transforms.FormatTransform.readFromKafka;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import com.google.auth.Credentials;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.apache.beam.examples.complete.kafkatopubsub.utils.RunKafkaContainer;
import org.apache.beam.runners.direct.DirectOptions;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.extensions.gcp.auth.NoopCredentialFactory;
import org.apache.beam.sdk.extensions.gcp.options.GcpOptions;
import org.apache.beam.sdk.io.gcp.pubsub.*;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Values;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.PubSubEmulatorContainer;
import org.testcontainers.utility.DockerImageName;

/** E2E test for {@link KafkaToPubsub} pipeline. */
public class KafkaToPubsubE2ETest {

  @Rule public final transient TestPipeline pipeline = TestPipeline.fromOptions(OPTIONS);
  @Rule public transient TestPubsubSignal signal = TestPubsubSignal.fromOptions(OPTIONS);
  @Rule public transient TestPubsub testPubsub = TestPubsub.fromOptions(OPTIONS);

  private static final String PUBSUB_EMULATOR_IMAGE =
      "gcr.io/google.com/cloudsdktool/cloud-sdk:316.0.0-emulators";
  private static final String PUBSUB_MESSAGE = "test pubsub message";
  private static final String PROJECT_ID = "try-kafka-pubsub";
  private static final String TOPIC_NAME = "listen-to-kafka";
  private static final PubsubClient.TopicPath TOPIC_PATH =
      PubsubClient.topicPathFromName(PROJECT_ID, TOPIC_NAME);
  private static final PipelineOptions OPTIONS = TestPipeline.testingPipelineOptions();

  @BeforeClass
  public static void beforeClass() throws Exception {
    Credentials credentials = NoopCredentialFactory.fromOptions(OPTIONS).getCredential();
    OPTIONS.as(GcpOptions.class).setGcpCredential(credentials);
    OPTIONS.as(GcpOptions.class).setProject(PROJECT_ID);
    setupPubsubContainer(OPTIONS.as(PubsubOptions.class));
//    createPubsubTopicForTest(OPTIONS.as(PubsubOptions.class));
  }

  private static class LogIt extends DoFn<String, String> {
    @ProcessElement
    public void processElement(ProcessContext context) {
      System.out.println("[TEST]\t\tElement is: " + context.element());
      context.output(context.element());
    }
  }


  @Test
  public void testKafkaToPubsubE2E() throws IOException, InterruptedException {
    System.out.println("[TEST]\t\ttest started...");
//    System.out.println("test started, waiting for subscription to create...");
//    testPubsub.assertSubscriptionEventuallyCreated(PROJECT_ID, Duration.standardSeconds(10));
//    System.out.println("subscription is created");
    pipeline.getOptions().as(DirectOptions.class).setBlockOnRun(false);

    RunKafkaContainer rkc = new RunKafkaContainer(PUBSUB_MESSAGE);
    String bootstrapServer = rkc.getBootstrapServer();
    String[] kafkaTopicsList = new String[] {rkc.getTopicName()};

    String pubsubTopicPath = testPubsub.topicPath().getPath();
    System.out.println(String.format("[TEST]\t\twill be writing to '%s' topic", pubsubTopicPath));

    Map<String, Object> kafkaConfig = new HashMap<>();
    Map<String, String> sslConfig = new HashMap<>();

    PCollection<KV<String, String>> readStrings =
        pipeline.apply(
            "readFromKafka",
            readFromKafka(bootstrapServer, Arrays.asList(kafkaTopicsList), kafkaConfig, sslConfig));

        readStrings
            .apply(Values.create())
            .apply(ParDo.of(new LogIt()))
            .apply("writeToPubSub", PubsubIO.writeStrings().to(pubsubTopicPath));


//    readFromPubsub.apply(
//        "waitForTestMessage",
//        signal.signalSuccessWhen(
//            readFromPubsub.getCoder(),
//            input -> {
//              if (input == null) {
//                return false;
//              }
//              return input.stream().anyMatch(message -> Objects.equals(message, PUBSUB_MESSAGE));
//            }));

//    Supplier<Void> start = signal.waitForStart(Duration.standardSeconds(10));
//    pipeline.apply(signal.signalStart());
    PipelineResult job = pipeline.run();
    System.out.println("[TEST]\t\tPipeline started");
//    start.get();
    System.out.println("[TEST]\t\twaiting for message for 1 minutes");
//    testPubsub.assertThatTopicEventuallyReceives(hasProperty("payload", equalTo(PUBSUB_MESSAGE.getBytes(StandardCharsets.US_ASCII)))).waitForUpTo(Duration.standardSeconds(20));
    List<PubsubMessage> pubsubMessages = testPubsub.waitForNMessages(1, Duration.standardMinutes(1));
    pubsubMessages.forEach(System.out::println);
    System.out.println("[TEST]\t\twaited 1 minutes for message");
    assertThat(pubsubMessages, hasSize(1));
//    signal.waitForSuccess(Duration.standardMinutes(2));
    try {
      job.cancel();
    } catch (IOException | UnsupportedOperationException e) {
      throw new AssertionError("Could not stop pipeline.", e);
    }
  }

  private static void setupPubsubContainer(PubsubOptions options) {
    PubSubEmulatorContainer emulator =
        new PubSubEmulatorContainer(DockerImageName.parse(PUBSUB_EMULATOR_IMAGE));
    emulator.start();
    String pubsubUrl = emulator.getEmulatorEndpoint();
    options.setPubsubRootUrl("http://" + pubsubUrl);
  }

  private static void createPubsubTopicForTest(PubsubOptions options) {
    try {
      PubsubClient pubsubClient = PubsubJsonClient.FACTORY.newClient(null, null, options);
      pubsubClient.createTopic(TOPIC_PATH);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

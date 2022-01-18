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
package org.apache.beam.sdk.io.cdap;

import io.cdap.plugin.salesforce.plugin.source.streaming.SalesforceReceiver;
import io.cdap.plugin.salesforce.plugin.source.streaming.SalesforceStreamingSourceConfig;
import org.apache.spark.streaming.receiver.ReceiverSupervisor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Test class for */
@RunWith(JUnit4.class)
public class ProxyBuilderTest {

  private static final Logger LOG = LoggerFactory.getLogger(ProxyBuilderTest.class);

  private static final String SALESFORCE_CONFIG_JSON_STRING =
      "{\n"
          + "\"pushTopicName\": \"topicName\",\n"
          + "\"sObjectName\": \"sObject\",\n"
          + "\"datetimeAfter\": \"datetime\",\n"
          + "\"consumerKey\": \"key\",\n"
          + "\"consumerSecret\": \"secret\",\n"
          + "\"username\": \"user\",\n"
          + "\"password\": \"password\",\n"
          + "\"loginUrl\": \"https://www.google.com\",\n"
          + "\"referenceName\": \"reference\"\n"
          + "}";

  // TODO: Need to add appropriate dependencies, then the next Test could be uncommented and will
  // work for PubSub
  //  private static final String PUBSUB_CONFIG_JSON_STRING =
  //      "{\n"
  //          + " \"project\": \"datatokenization\",\n"
  //          + " \"serviceAccountType\": \"JSON\",\n"
  //          + " \"serviceFilePath\": \"/something.json\",\n"
  //          + " \"subscription\": \"cdap-sub\",\n"
  //          + " \"topic\": \"cdap\",\n"
  //          + " \"numberOfReaders\": 1\n"
  //          + "}";
  //
  //  @Test
  //  public void testCreatingProxySparkReceiverForPubsub() {
  //    try {
  //      PubSubSubscriberConfig pubsubConfig =
  //          new ConfigWrapper<>(PubSubSubscriberConfig.class)
  //              .fromJsonString(PUBSUB_CONFIG_JSON_STRING)
  //              .build();
  //      ProxyBuilder<PubSubMessage, PubSubReceiver> builder =
  //          new ProxyBuilder<>(PubSubReceiver.class);
  //
  //      PubSubReceiver proxyReciever =
  //          builder.withConstructorArgs(pubsubConfig, false, StorageLevel.DISK_ONLY()).build();
  //      proxyReciever.onStart();
  //
  //      ReceiverSupervisor supervisor = proxyReciever.supervisor();
  //      Assert.assertTrue(supervisor instanceof WrappedSupervisor);
  //    } catch (Exception e) {
  //      LOG.error("Can not get proxy", e);
  //    }
  //  }

  /**
   * If this test passed, then proxy object for custom {@link
   * org.apache.spark.streaming.receiver.Receiver} was created successfully, and the corresponding
   * {@link ReceiverSupervisor} was wrapped into {@link WrappedSupervisor}.
   */
  @Test
  public void testCreatingProxySparkReceiverForSalesforce() {
    try {
      SalesforceStreamingSourceConfig config =
          new ConfigWrapper<>(SalesforceStreamingSourceConfig.class)
              .fromJsonString(SALESFORCE_CONFIG_JSON_STRING)
              .build();
      ProxyBuilder<String, SalesforceReceiver> builder =
          new ProxyBuilder<>(SalesforceReceiver.class);

      SalesforceReceiver proxyReciever =
          builder
              .withConstructorArgs(config.getAuthenticatorCredentials(), config.getPushTopicName())
              .build();
      proxyReciever.onStart();

      ReceiverSupervisor supervisor = proxyReciever.supervisor();
      Assert.assertTrue(supervisor instanceof WrappedSupervisor);
    } catch (Exception e) {
      LOG.error("Can not get proxy", e);
    }
  }
}

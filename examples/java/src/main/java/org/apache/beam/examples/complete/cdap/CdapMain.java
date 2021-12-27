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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cdap.cdap.api.plugin.PluginConfig;
import io.cdap.plugin.salesforce.SalesforceConstants;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceSourceConfig;
import io.cdap.plugin.salesforce.plugin.source.batch.util.SalesforceSourceConstants;
import org.apache.beam.examples.complete.kafkatopubsub.KafkaToPubsub;
import org.apache.beam.examples.complete.kafkatopubsub.options.KafkaToPubsubOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CdapMain {

  /* Logger for class.*/
  private static final Logger LOG = LoggerFactory.getLogger(CdapMain.class);

  public static void main(String[] args) {
    if (args.length == 0) {
      LOG.error("Need to pass the json file path as a first arg");
      return;
    }
    String jsonFilePath = args[0];

    try {
      TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
      };
      Map<String, Object> mapping = new ObjectMapper()
          .readValue(new File(jsonFilePath), typeRef);

      //1
      String oldReferenceName = "reference";
      SalesforceSourceConfig firstConfig = new ConfigWrapper<>(SalesforceSourceConfig.class)
          .withParams(mapping)
          .build();
      validateSalesforceConfigObject(mapping, firstConfig);
      assertEquals(oldReferenceName, firstConfig.referenceName);

      //2
      String newReferenceName = "new reference name";
      SalesforceSourceConfig secondConfig = new ConfigWrapper<>(SalesforceSourceConfig.class)
          .fromJsonFile(new File(jsonFilePath))
          .setParam("referenceName", newReferenceName)
          .build();
      validateSalesforceConfigObject(mapping, secondConfig);
      assertEquals(newReferenceName, secondConfig.referenceName);
    } catch (Exception e) {
      LOG.error("Error occurred while getting the config object", e);
      fail();
    }
  }

  private static void validateSalesforceConfigObject(Map<String, Object> mapping, SalesforceSourceConfig config) {
    assertEquals(mapping.get(SalesforceSourceConstants.PROPERTY_DATETIME_AFTER),
        config.getDatetimeAfter());
    assertEquals(mapping.get(SalesforceSourceConstants.PROPERTY_SOBJECT_NAME),
        config.getSObjectName());
    assertEquals(mapping.get(SalesforceConstants.PROPERTY_CONSUMER_KEY), config.getConsumerKey());
    assertEquals(mapping.get(SalesforceConstants.PROPERTY_CONSUMER_SECRET), config.getConsumerSecret());
    assertEquals(mapping.get(SalesforceConstants.PROPERTY_USERNAME), config.getUsername());
    assertEquals(mapping.get(SalesforceConstants.PROPERTY_PASSWORD), config.getPassword());
    assertEquals(mapping.get(SalesforceConstants.PROPERTY_LOGIN_URL), config.getLoginUrl());
  }
}

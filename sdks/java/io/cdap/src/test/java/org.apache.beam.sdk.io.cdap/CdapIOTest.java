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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.cdap.format.StructuredRecordStringConverter;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceBatchSource;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceSourceConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.NullableCoder;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.io.cdap.context.BatchSourceContextImpl;
import org.apache.beam.sdk.io.cdap.github.batch.GithubBatchSource;
import org.apache.beam.sdk.io.cdap.github.batch.GithubBatchSourceConfig;
import org.apache.beam.sdk.io.cdap.github.batch.GithubFormatProvider;
import org.apache.beam.sdk.io.cdap.github.batch.GithubInputFormat;
import org.apache.beam.sdk.io.cdap.github.common.model.impl.*;
import org.apache.beam.sdk.io.cdap.zendesk.batch.ZendeskBatchSource;
import org.apache.beam.sdk.io.cdap.zendesk.batch.ZendeskBatchSourceConfig;
import org.apache.beam.sdk.io.cdap.zendesk.batch.ZendeskInputFormat;
import org.apache.beam.sdk.io.cdap.zendesk.batch.util.ZendeskBatchSourceConstants;
import org.apache.beam.sdk.io.cdap.zendesk.common.ObjectType;
import org.apache.beam.sdk.io.hadoop.WritableCoder;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

/** Test class for {@link CdapIO}. */
@SuppressWarnings("ModifiedButNotUsed")
@RunWith(JUnit4.class)
public class CdapIOTest {

  @Rule public final transient TestPipeline p = TestPipeline.create();

  private static final Logger LOG = LoggerFactory.getLogger(CdapIOTest.class);
  private static final ImmutableMap<String, Object> TEST_SALESFORCE_PARAMS_MAP =
      ImmutableMap.<String, java.lang.Object>builder()
          .put("sObjectName", "sObject")
          .put("datetimeAfter", "datetime")
          .put("consumerKey", "key")
          .put("consumerSecret", "secret")
          .put("username", "user")
          .put("password", "password")
          .put("loginUrl", "https://www.google.com")
          .put("referenceName", "oldReference")
          .build();
  private static final ImmutableMap<String, Object> TEST_GITHUB_PARAMS_MAP =
      ImmutableMap.<String, java.lang.Object>builder()
          .put("authorizationToken", System.getenv("GITHUB_TOKEN"))
          .put("repoOwner", System.getenv("GITHUB_REPO_OWNER"))
          .put("repoName", System.getenv("GITHUB_REPO_NAME"))
          .put("datasetName", "Branches")
          .put("hostname", "https://api.github.com")
          .build();
  private static final ImmutableMap<String, Object> TEST_ZENDESK_PARAMS_MAP =
      ImmutableMap.<String, java.lang.Object>builder()
          .put("referenceName", "referenceName")
          .put("adminEmail", System.getenv("ZENDESK_ADMIN_EMAIL"))
          .put("apiToken", System.getenv("ZENDESK_TOKEN"))
          .put("zendeskBaseUrl", System.getenv("ZENDESK_BASE_URL"))
          .put("subdomains", "api/v2")
          .put("maxRetryCount", 10000)
          .put("maxRetryWait", 10000)
          .put("maxRetryJitterWait", 10000)
          .put("connectTimeout", 10)
          .put("readTimeout", 10)
          .put("objectsToPull", "Groups")
          .build();
  private static final String TEST_ZENDESK_RECORD =
      "{\"url\":\"https://akv1119.zendesk.com/api/v2/groups/4422893473693.json\",\"id\":4422893473693,\"name\":"
          + "\"Поддержка\",\"deleted\":false,\"createdAt\":"
          + "\"2022-02-22T09:38:12Z\",\"updatedAt\":\"2022-02-22T09:38:12Z\",\"object\":\"Groups\"}";
  private static final Gson GSON = new GsonBuilder().create();

  @Test
  public void testReadFromGithub() {

    GithubBatchSourceConfig pluginConfig =
        new ConfigWrapper<>(GithubBatchSourceConfig.class)
            .withParams(TEST_GITHUB_PARAMS_MAP)
            .build();

    CdapIO.Read<Text, Branch> reader =
        CdapIO.<Text, Branch>read()
            .withCdapPluginClass(GithubBatchSource.class)
            .withPluginConfig(pluginConfig)
            .withKeyClass(Text.class)
            .withValueClass(Branch.class);

    assertNotNull(reader.getPluginConfig());
    assertNotNull(reader.getCdapPlugin());
    assertFalse(reader.getCdapPlugin().isUnbounded());
    assertEquals(BatchSourceContextImpl.class, reader.getCdapPlugin().getContext().getClass());

    List<KV<Text, Branch>> inputs = new ArrayList<>();
    inputs.add(KV.of(null, new Branch("master", false)));

    PCollection<KV<Text, Branch>> input =
        p.apply(reader)
            .setCoder(
                KvCoder.of(
                    NullableCoder.of(WritableCoder.of(Text.class)),
                    SerializableCoder.of(Branch.class)));

    PAssert.that(input).containsInAnyOrder(inputs);
    p.run();

    assertEquals(GithubInputFormat.class, reader.getCdapPlugin().formatClass);

    Configuration hadoopConf = reader.getCdapPlugin().getHadoopConf();
    String configJson = hadoopConf.get(GithubFormatProvider.PROPERTY_CONFIG_JSON);
    GithubBatchSourceConfig configFromJson =
        GSON.fromJson(configJson, GithubBatchSourceConfig.class);

    assertEquals(pluginConfig.getAuthorizationToken(), configFromJson.getAuthorizationToken());
  }

  @Test
  public void testReadFromZendesk() {

    ZendeskBatchSourceConfig pluginConfig =
        new ConfigWrapper<>(ZendeskBatchSourceConfig.class)
            .withParams(TEST_ZENDESK_PARAMS_MAP)
            .build();

    CdapIO.Read<NullWritable, StructuredRecord> reader =
        CdapIO.<NullWritable, StructuredRecord>read()
            .withCdapPluginClass(ZendeskBatchSource.class)
            .withPluginConfig(pluginConfig)
            .withKeyClass(NullWritable.class)
            .withValueClass(StructuredRecord.class);

    assertNotNull(reader.getPluginConfig());
    assertNotNull(reader.getCdapPlugin());
    assertFalse(reader.getCdapPlugin().isUnbounded());
    assertEquals(BatchSourceContextImpl.class, reader.getCdapPlugin().getContext().getClass());

    List<KV<NullWritable, StructuredRecord>> inputs = new ArrayList<>();
    Schema schema = ObjectType.GROUPS.getObjectSchema();
    try {
      inputs.add(
          KV.of(
              NullWritable.get(),
              StructuredRecordStringConverter.fromJsonString(TEST_ZENDESK_RECORD, schema)));
    } catch (IOException e) {
      LOG.error("Fail to get StructuredRecord from JSON string", e);
    }

    PCollection<KV<NullWritable, StructuredRecord>> input =
        p.apply(reader)
            .setCoder(
                KvCoder.of(
                    NullableCoder.of(WritableCoder.of(NullWritable.class)),
                    SerializableCoder.of(StructuredRecord.class)));

    PAssert.that(input).containsInAnyOrder(inputs);
    p.run();

    assertEquals(ZendeskInputFormat.class, reader.getCdapPlugin().formatClass);

    Configuration hadoopConf = reader.getCdapPlugin().getHadoopConf();
    String configJson = hadoopConf.get(ZendeskBatchSourceConstants.PROPERTY_CONFIG_JSON);
    ZendeskBatchSourceConfig configFromJson =
        GSON.fromJson(configJson, ZendeskBatchSourceConfig.class);

    assertEquals(pluginConfig.getAdminEmail(), configFromJson.getAdminEmail());
  }

  @Test
  public void testReadFromSalesforce() {
    try {

      SalesforceSourceConfig pluginConfig =
          new ConfigWrapper<>(SalesforceSourceConfig.class)
              .withParams(TEST_SALESFORCE_PARAMS_MAP)
              .build();

      CdapIO.Read<Schema, Map<String, String>> reader =
          CdapIO.<Schema, Map<String, String>>read()
              .withCdapPluginClass(SalesforceBatchSource.class)
              .withPluginConfig(pluginConfig);

      assertNotNull(reader.getPluginConfig());
      assertNotNull(reader.getCdapPlugin());
      assertFalse(reader.getCdapPlugin().isUnbounded());
      assertEquals(BatchSourceContextImpl.class, reader.getCdapPlugin().getContext().getClass());

      // TODO: Provide params needed for Salesforce connection, run test pipeline
      //  and add assertions for Hadoop conf and pipeline result

    } catch (Exception e) {
      LOG.error("Error occurred", e);
      fail();
    }
  }
}

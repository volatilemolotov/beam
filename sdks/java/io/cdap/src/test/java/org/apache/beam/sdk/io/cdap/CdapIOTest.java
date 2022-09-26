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

import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.common.Constants;
import io.cdap.plugin.salesforce.plugin.OAuthInfo;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceBatchSource;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceSourceConfig;
import io.cdap.plugin.sendgrid.batch.source.SendGridSource;
import io.cdap.plugin.sendgrid.batch.source.SendGridSourceConfig;
import io.cdap.plugin.sendgrid.common.helpers.IBaseObject;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraBatchSource;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraSourceConfig;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraSplitArgument;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.MapCoder;
import org.apache.beam.sdk.coders.NullableCoder;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.cdap.context.BatchSinkContextImpl;
import org.apache.beam.sdk.io.cdap.context.BatchSourceContextImpl;
import org.apache.beam.sdk.io.hadoop.WritableCoder;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Values;
import org.apache.beam.sdk.transforms.windowing.AfterWatermark;
import org.apache.beam.sdk.transforms.windowing.GlobalWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.OutputCommitter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/** Test class for {@link CdapIO}. */
@RunWith(JUnit4.class)
@SuppressWarnings("rawtypes")
public class CdapIOTest {

  @Rule public final transient TestPipeline p = TestPipeline.create();
  @Rule public TemporaryFolder tmpFolder = new TemporaryFolder();

  private static final Map<String, Object> TEST_EMPLOYEE_PARAMS_MAP =
      ImmutableMap.<String, Object>builder()
          .put(EmployeeConfig.OBJECT_TYPE, "employee")
          .put(Constants.Reference.REFERENCE_NAME, "referenceName")
          .build();

  private static final ImmutableMap<String, Object> TEST_ZUORA_PARAMS_MAP =
      ImmutableMap.<String, Object>builder()
          .put("authType", "basic")
          .put("referenceName", "referenceName")
          .put("authUsername", System.getenv("ZUORA_USERNAME"))
          .put("authPassword", System.getenv("ZUORA_PASSWORD"))
          .put("baseObjects", "Orders")
          .build();

  private static final ImmutableMap<String, Object> TEST_SENDGRID_PARAMS_MAP =
      ImmutableMap.<String, Object>builder()
          .put("authType", "api")
          .put("referenceName", "referenceName")
          .put("sendGridApiKey", System.getenv("SENDGRID_API_KEY"))
          .put("dataSourceTypes", "MarketingCampaign")
          .put("dataSourceMarketing", "Senders")
          .put("dataSourceFields", "id,nickname")
          .build();

  private static final ImmutableMap<String, Object> TEST_SALESFORCE_PARAMS_MAP =
      ImmutableMap.<String, Object>builder()
          .put("referenceName", "referenceName")
          .put("username", "akarys.shorabek@akvelon.com")
          .put("password", "Akarys2001#")
          .put("securityToken", "9h0BXK5zefgIwxzEzdqxv5Trv")
          .put("consumerKey", "3MVG9t0sl2P.pByr4TRAiAY43fPIry8GgeN22WuRUTiIVg7j7o9KTlSGhRDTvuIZ2ivTLew3_Bfc6MRPDcErC")
          .put("consumerSecret", "77B38C597867F12182E33E98C188EF966E2754676F67308EE61AFB95F84E3C6E")
          .put("loginUrl", "https://login.salesforce.com/services/oauth2/token")
          .put("sObjectName", "Opportunity")
          .build();

  @Before
  public void setUp() {
    OutputCommitter mockedOutputCommitter = Mockito.mock(OutputCommitter.class);
    EmployeeOutputFormat.initWrittenOutput(mockedOutputCommitter);
  }

  @Test
  public void testReadBuildsCorrectly() {
    EmployeeConfig pluginConfig =
        new ConfigWrapper<>(EmployeeConfig.class).withParams(TEST_EMPLOYEE_PARAMS_MAP).build();

    CdapIO.Read<String, String> read =
        CdapIO.<String, String>read()
            .withCdapPlugin(
                Plugin.create(
                    EmployeeBatchSource.class,
                    EmployeeInputFormat.class,
                    EmployeeInputFormatProvider.class))
            .withPluginConfig(pluginConfig)
            .withKeyClass(String.class)
            .withValueClass(String.class);

    Plugin cdapPlugin = read.getCdapPlugin();
    assertNotNull(cdapPlugin);
    assertEquals(EmployeeBatchSource.class, cdapPlugin.getPluginClass());
    assertEquals(EmployeeInputFormat.class, cdapPlugin.getFormatClass());
    assertEquals(EmployeeInputFormatProvider.class, cdapPlugin.getFormatProviderClass());
    assertNotNull(cdapPlugin.getContext());
    assertEquals(BatchSourceContextImpl.class, cdapPlugin.getContext().getClass());
    assertEquals(PluginConstants.PluginType.SOURCE, cdapPlugin.getPluginType());
    assertNotNull(cdapPlugin.getHadoopConfiguration());
    assertEquals(pluginConfig, read.getPluginConfig());
    assertEquals(String.class, read.getKeyClass());
    assertEquals(String.class, read.getValueClass());
  }

  @Test
  public void testReadFromZuora() {
    ZuoraSourceConfig zuoraSourceConfig = new ConfigWrapper<>(ZuoraSourceConfig.class)
        .withParams(TEST_ZUORA_PARAMS_MAP)
        .build();

    CdapIO.Read<ZuoraSplitArgument, BaseObject> reader =
        CdapIO.<ZuoraSplitArgument, BaseObject>read()
            .withCdapPluginClass(ZuoraBatchSource.class)
            .withPluginConfig(zuoraSourceConfig)
            .withKeyClass(ZuoraSplitArgument.class)
            .withValueClass(BaseObject.class);

    assertNotNull(reader.getPluginConfig());
    assertNotNull(reader.getCdapPlugin());
    assertFalse(reader.getCdapPlugin().isUnbounded());
    assertEquals(BatchSourceContextImpl.class, reader.getCdapPlugin().getContext().getClass());

    PCollection<KV<ZuoraSplitArgument, BaseObject>> input = p.apply(reader).setCoder(
        KvCoder.of(
            SerializableCoder.of(ZuoraSplitArgument.class),
            SerializableCoder.of(BaseObject.class)
        )
    );

    int expectedRecordsCount = 336;

    PAssert.that(input)
        .satisfies(
            (iterable) -> {
              List<KV<ZuoraSplitArgument, BaseObject>> list =
                  (List<KV<ZuoraSplitArgument, BaseObject>>) iterable;
              assertEquals(expectedRecordsCount, list.size());
              return null;
            }
        );

    p.run();
  }

  @Test
  public void testReadFromSalesForce() {
    SalesforceSourceConfig sourceConfig = new ConfigWrapper<>(SalesforceSourceConfig.class)
        .withParams(TEST_SALESFORCE_PARAMS_MAP)
        .build();

    CdapIO.Read<Schema, LinkedHashMap> reader =
        CdapIO.<Schema, LinkedHashMap>read()
            .withCdapPluginClass(SalesforceBatchSource.class)
            .withPluginConfig(sourceConfig)
            .withKeyClass(Schema.class)
            .withValueClass(LinkedHashMap.class);

    assertNotNull(reader.getPluginConfig());
    assertNotNull(reader.getCdapPlugin());
    assertFalse(reader.getCdapPlugin().isUnbounded());
    assertEquals(BatchSourceContextImpl.class, reader.getCdapPlugin().getContext().getClass());

    PCollection<KV<Schema, LinkedHashMap>> input = p.apply(reader).setCoder(
        KvCoder.of(
            SerializableCoder.of(Schema.class),
            SerializableCoder.of(LinkedHashMap.class)
        )
    );

    PAssert.thatSingleton(input.apply(Values.create()).apply(Window.<LinkedHashMap>into(new GlobalWindows())
        .discardingFiredPanes()
        .triggering(AfterWatermark.
            pastEndOfWindow())).apply(Count.globally())).isEqualTo(31L);

    p.run();
  }

  @Test
  public void testReadFromSendGrid() {
    SendGridSourceConfig sourceConfig = new ConfigWrapper<>(SendGridSourceConfig.class)
        .withParams(TEST_SENDGRID_PARAMS_MAP)
        .build();

    CdapIO.Read<NullWritable, IBaseObject> reader =
        CdapIO.<NullWritable, IBaseObject>read()
            .withCdapPluginClass(SendGridSource.class)
            .withPluginConfig(sourceConfig)
            .withKeyClass(NullWritable.class)
            .withValueClass(IBaseObject.class);

    assertNotNull(reader.getPluginConfig());
    assertNotNull(reader.getCdapPlugin());
    assertFalse(reader.getCdapPlugin().isUnbounded());
    assertEquals(BatchSourceContextImpl.class, reader.getCdapPlugin().getContext().getClass());

    PCollection<KV<NullWritable, IBaseObject>> input = p.apply(reader).setCoder(
        KvCoder.of(
            NullableCoder.of(WritableCoder.of(NullWritable.class)),
            SerializableCoder.of(IBaseObject.class)
        )
    );

    PAssert.that(input)
        .satisfies(
            (iterable) -> {
              List<KV<NullWritable, IBaseObject>> list =
                  (List<KV<NullWritable, IBaseObject>>) iterable;
              assertEquals(2, list.size());
              assertEquals("tommy", list.get(1).getValue().asMap().get("nickname"));
              return null;
            }
        );

    p.run();
  }


  @Test
  public void testReadObjectCreationFailsIfCdapPluginClassIsNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> CdapIO.<String, String>read().withCdapPluginClass(null));
  }

  @Test
  public void testReadObjectCreationFailsIfPluginConfigIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> CdapIO.<String, String>read().withPluginConfig(null));
  }

  @Test
  public void testReadObjectCreationFailsIfKeyClassIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> CdapIO.<String, String>read().withKeyClass(null));
  }

  @Test
  public void testReadObjectCreationFailsIfValueClassIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> CdapIO.<String, String>read().withValueClass(null));
  }

  @Test
  public void testReadValidationFailsMissingCdapPluginClass() {
    CdapIO.Read<String, String> read = CdapIO.read();
    assertThrows(IllegalArgumentException.class, read::validateTransform);
  }

  @Test
  public void testReadObjectCreationFailsIfCdapPluginClassIsNotSupported() {
    assertThrows(
        UnsupportedOperationException.class,
        () -> CdapIO.<String, String>read().withCdapPluginClass(EmployeeBatchSource.class));
  }

  @Test
  public void testReadingData() {
    EmployeeConfig pluginConfig =
        new ConfigWrapper<>(EmployeeConfig.class).withParams(TEST_EMPLOYEE_PARAMS_MAP).build();
    CdapIO.Read<String, String> read =
        CdapIO.<String, String>read()
            .withCdapPlugin(
                Plugin.create(
                    EmployeeBatchSource.class,
                    EmployeeInputFormat.class,
                    EmployeeInputFormatProvider.class))
            .withPluginConfig(pluginConfig)
            .withKeyClass(String.class)
            .withValueClass(String.class);

    List<KV<String, String>> expected = new ArrayList<>();
    for (int i = 1; i < EmployeeInputFormat.NUM_OF_TEST_EMPLOYEE_RECORDS; i++) {
      expected.add(KV.of(String.valueOf(i), EmployeeInputFormat.EMPLOYEE_NAME_PREFIX + i));
    }
    PCollection<KV<String, String>> actual = p.apply("ReadTest", read);
    PAssert.that(actual).containsInAnyOrder(expected);
    p.run();
  }

  @Test
  public void testWriteBuildsCorrectly() {
    EmployeeConfig pluginConfig =
        new ConfigWrapper<>(EmployeeConfig.class).withParams(TEST_EMPLOYEE_PARAMS_MAP).build();

    CdapIO.Write<String, String> write =
        CdapIO.<String, String>write()
            .withCdapPlugin(
                Plugin.create(
                    EmployeeBatchSink.class,
                    EmployeeOutputFormat.class,
                    EmployeeOutputFormatProvider.class))
            .withPluginConfig(pluginConfig)
            .withKeyClass(String.class)
            .withValueClass(String.class)
            .withLocksDirPath(tmpFolder.getRoot().getAbsolutePath());

    Plugin cdapPlugin = write.getCdapPlugin();
    assertNotNull(cdapPlugin);
    assertNotNull(write.getLocksDirPath());
    assertEquals(EmployeeBatchSink.class, cdapPlugin.getPluginClass());
    assertEquals(EmployeeOutputFormat.class, cdapPlugin.getFormatClass());
    assertEquals(EmployeeOutputFormatProvider.class, cdapPlugin.getFormatProviderClass());
    assertNotNull(cdapPlugin.getContext());
    assertEquals(BatchSinkContextImpl.class, cdapPlugin.getContext().getClass());
    assertEquals(PluginConstants.PluginType.SINK, cdapPlugin.getPluginType());
    assertNotNull(cdapPlugin.getHadoopConfiguration());
    assertEquals(pluginConfig, write.getPluginConfig());
    assertEquals(String.class, write.getKeyClass());
    assertEquals(String.class, write.getValueClass());
  }

  @Test
  public void testWriteObjectCreationFailsIfCdapPluginClassIsNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> CdapIO.<String, String>write().withCdapPluginClass(null));
  }

  @Test
  public void testWriteObjectCreationFailsIfPluginConfigIsNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> CdapIO.<String, String>write().withPluginConfig(null));
  }

  @Test
  public void testWriteObjectCreationFailsIfKeyClassIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> CdapIO.<String, String>write().withKeyClass(null));
  }

  @Test
  public void testWriteObjectCreationFailsIfValueClassIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> CdapIO.<String, String>write().withValueClass(null));
  }

  @Test
  public void testWriteObjectCreationFailsIfLockDirIsNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> CdapIO.<String, String>write().withLocksDirPath(null));
  }

  @Test
  public void testWriteValidationFailsMissingCdapPluginClass() {
    CdapIO.Write<String, String> write = CdapIO.write();
    assertThrows(IllegalArgumentException.class, write::validateTransform);
  }

  @Test
  public void testWriteObjectCreationFailsIfCdapPluginClassIsNotSupported() {
    assertThrows(
        UnsupportedOperationException.class,
        () -> CdapIO.<String, String>write().withCdapPluginClass(EmployeeBatchSink.class));
  }

  @Test
  public void testWritingData() throws IOException {
    List<KV<String, String>> data = new ArrayList<>();
    for (int i = 0; i < EmployeeInputFormat.NUM_OF_TEST_EMPLOYEE_RECORDS; i++) {
      data.add(KV.of(String.valueOf(i), EmployeeInputFormat.EMPLOYEE_NAME_PREFIX + i));
    }
    PCollection<KV<String, String>> input = p.apply(Create.of(data));

    EmployeeConfig pluginConfig =
        new ConfigWrapper<>(EmployeeConfig.class).withParams(TEST_EMPLOYEE_PARAMS_MAP).build();
    input.apply(
        "Write",
        CdapIO.<String, String>write()
            .withCdapPlugin(
                Plugin.create(
                    EmployeeBatchSink.class,
                    EmployeeOutputFormat.class,
                    EmployeeInputFormatProvider.class))
            .withPluginConfig(pluginConfig)
            .withKeyClass(String.class)
            .withValueClass(String.class)
            .withLocksDirPath(tmpFolder.getRoot().getAbsolutePath()));
    p.run();

    List<KV<String, String>> writtenOutput = EmployeeOutputFormat.getWrittenOutput();
    assertEquals(data.size(), writtenOutput.size());
    assertTrue(data.containsAll(writtenOutput));
    assertTrue(writtenOutput.containsAll(data));

    Mockito.verify(EmployeeOutputFormat.getOutputCommitter()).commitJob(Mockito.any());
  }
}

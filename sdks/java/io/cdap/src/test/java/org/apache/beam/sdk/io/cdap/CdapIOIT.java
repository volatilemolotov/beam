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

import static org.apache.beam.sdk.io.synthetic.SyntheticOptions.fromJsonString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.cdap.plugin.common.Constants;
import io.cdap.plugin.hubspot.common.BaseHubspotConfig;
import io.cdap.plugin.hubspot.common.SourceHubspotConfig;
import io.cdap.plugin.hubspot.sink.batch.HubspotBatchSink;
import io.cdap.plugin.hubspot.sink.batch.SinkHubspotConfig;
import io.cdap.plugin.hubspot.source.batch.HubspotBatchSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.coders.CustomCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.Read;
import org.apache.beam.sdk.io.common.HashingFn;
import org.apache.beam.sdk.io.common.IOITHelper;
import org.apache.beam.sdk.io.common.IOTestPipelineOptions;
import org.apache.beam.sdk.io.synthetic.SyntheticBoundedSource;
import org.apache.beam.sdk.io.synthetic.SyntheticSourceOptions;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;
import org.apache.hadoop.io.NullWritable;
import org.joda.time.Duration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * IO Integration test for {@link org.apache.beam.sdk.io.cdap.CdapIO}.
 *
 * <p>{@see https://beam.apache.org/documentation/io/testing/#i-o-transform-integration-tests} for
 * more details.
 */
@RunWith(JUnit4.class)
public class CdapIOIT {

  @Rule public TestPipeline writePipeline = TestPipeline.create();

  @Rule public TestPipeline readPipeline = TestPipeline.create();

  @Rule public TemporaryFolder tmpFolder = new TemporaryFolder();

  private static SyntheticSourceOptions sourceOptions;

  private static Options options;

  private static String expectedHashcode;

  private static Map<String, Object> hubspotParamsMap;

  private static ObjectMapper objectMapper;

  private static List<String> propertyNames;

  @BeforeClass
  public static void setup() throws IOException {
    options = IOITHelper.readIOTestPipelineOptions(Options.class);
    sourceOptions = fromJsonString(options.getSourceOptions(), SyntheticSourceOptions.class);
    hubspotParamsMap = new HashMap<>();
    hubspotParamsMap.put(
        BaseHubspotConfig.API_SERVER_URL, BaseHubspotConfig.DEFAULT_API_SERVER_URL);
    hubspotParamsMap.put(BaseHubspotConfig.API_KEY, options.getHubspotApiKey());
    hubspotParamsMap.put(BaseHubspotConfig.OBJECT_TYPE, options.getHubspotObjectType());
    hubspotParamsMap.put(Constants.Reference.REFERENCE_NAME, "referenceName");
    objectMapper = new ObjectMapper();
    propertyNames = options.getHubspotPropertyNames();
  }

  @AfterClass
  public static void afterClass() {
    //TODO: clean hubspot
  }

  @Test
  public void testCdapIOReadsAndWritesCorrectlyInBatch() throws IOException {
    // Map of hashes of set size collections with 100b records - 10b key, 90b values.
    Map<Long, String> expectedHashes =
        ImmutableMap.of(
            1000L, "4507649971ee7c51abbb446e65a5c660",
            100_000_000L, "0f12c27c9a7672e14775594be66cad9a");
    expectedHashcode = getHashForRecordCount(sourceOptions.numRecords, expectedHashes);
    writePipeline
        .apply("Generate records", Read.from(new SyntheticBoundedSource(sourceOptions)))
        .apply("Map records", ParDo.of(new MapToHubspotRecord()))
        .apply("Write to Hubspot", writeToHubspot(hubspotParamsMap));

    readPipeline.getCoderRegistry().registerCoderForClass(JsonElement.class, JsonElementCoder.of());

    PCollection<String> hashcode =
        readPipeline
            .apply("Read from bounded Hubspot", readFromBoundedHubspot(hubspotParamsMap))
            .apply("Map records to strings", MapElements.via(new MapHubspotRecordsToStrings()))
            .apply("Calculate hashcode", Combine.globally(new HashingFn()).withoutDefaults());

    PAssert.thatSingleton(hashcode).isEqualTo(expectedHashcode);

    PipelineResult writeResult = writePipeline.run();
    writeResult.waitUntilFinish();

    PipelineResult readResult = readPipeline.run();
    readResult.waitUntilFinish(Duration.standardSeconds(options.getReadTimeout()));
  }

  /** Pipeline options specific for this test. */
  public interface Options extends IOTestPipelineOptions, StreamingOptions {

    @Description("Options for synthetic source.")
    @Validation.Required
    String getSourceOptions();

    void setSourceOptions(String sourceOptions);

    @Description("Time to wait for the events to be processed by the read pipeline (in seconds)")
    @Validation.Required
    Integer getReadTimeout();

    void setReadTimeout(Integer readTimeout);

    @Description("Api key for Hubspot source.")
    @Validation.Required
    String getHubspotApiKey();

    void setHubspotApiKey(String hubspotApiKey);

    @Description("Object type for Hubspot source.")
    @Validation.Required
    String getHubspotObjectType();

    void setHubspotObjectType(String hubspotObjectType);

    @Description("Property names for Hubspot record.")
    @Validation.Required
    List<String> getHubspotPropertyNames();

    void setHubspotPropertyNames(List<String> hubspotPropertyNames);
  }

  private CdapIO.Read<NullWritable, JsonElement> readFromBoundedHubspot(
      Map<String, Object> paramsMap) {
    SourceHubspotConfig pluginConfig =
        new ConfigWrapper<>(SourceHubspotConfig.class).withParams(paramsMap).build();
    return CdapIO.<NullWritable, JsonElement>read()
        .withCdapPluginClass(HubspotBatchSource.class)
        .withPluginConfig(pluginConfig)
        .withKeyClass(NullWritable.class)
        .withValueClass(JsonElement.class);
  }

  private CdapIO.Write<NullWritable, String> writeToHubspot(Map<String, Object> paramsMap) {
    SinkHubspotConfig sinkConfig =
        new ConfigWrapper<>(SinkHubspotConfig.class).withParams(paramsMap).build();

    return CdapIO.<NullWritable, String>write()
        .withCdapPluginClass(HubspotBatchSink.class)
        .withPluginConfig(sinkConfig)
        .withKeyClass(NullWritable.class)
        .withValueClass(String.class)
        .withLocksDirPath(tmpFolder.getRoot().getAbsolutePath());
  }

  public static String getHashForRecordCount(long recordCount, Map<Long, String> hashes) {
    String hash = hashes.get(recordCount);
    if (hash == null) {
      throw new UnsupportedOperationException(
          String.format("No hash for that record count: %s", recordCount));
    }
    return hash;
  }

  public static class JsonElementCoder extends CustomCoder<JsonElement> {
    private static final JsonElementCoder CODER = new JsonElementCoder();
    private static final StringUtf8Coder STRING_CODER = StringUtf8Coder.of();

    public static JsonElementCoder of() {
      return CODER;
    }

    @Override
    public void encode(JsonElement value, OutputStream outStream) throws IOException {
      STRING_CODER.encode(value.toString(), outStream);
    }

    @Override
    public JsonElement decode(InputStream inStream) throws IOException {
      return JsonParser.parseString(STRING_CODER.decode(inStream));
    }
  }

  private static class MapHubspotRecordsToStrings
      extends SimpleFunction<KV<NullWritable, JsonElement>, String> {
    @Override
    public String apply(KV<NullWritable, JsonElement> input) {
      return input.getValue().toString();
    }
  }

  private static class MapToHubspotRecord
      extends DoFn<KV<byte[], byte[]>, KV<NullWritable, String>> {
    @ProcessElement
    public void process(ProcessContext context) throws JsonProcessingException {
      byte[] value = context.element().getValue();
      String strVal = Arrays.toString(value);
      List<HubspotPropertyJson> props = new ArrayList<>();
      for (String propertyName : propertyNames) {
        props.add(new HubspotPropertyJson(propertyName, strVal));
      }
      HubspotPropertiesJson hubspotPropertiesJson = new HubspotPropertiesJson(props);
      context.output(
          KV.of(
              NullWritable.get(),
              objectMapper
                  .writer()
                  .withDefaultPrettyPrinter()
                  .writeValueAsString(hubspotPropertiesJson)));
    }
  }

  @SuppressWarnings("UnusedVariable")
  private static class HubspotPropertiesJson {
    private List<HubspotPropertyJson> properties;

    public HubspotPropertiesJson(List<HubspotPropertyJson> properties) {
      this.properties = properties;
    }
  }

  @SuppressWarnings("UnusedVariable")
  private static class HubspotPropertyJson {
    private String name;
    private String value;

    public HubspotPropertyJson(String name, String value) {
      this.name = name;
      this.value = value;
    }
  }
}

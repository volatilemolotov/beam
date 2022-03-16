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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.CustomCoder;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.NullableCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.cdap.hubspot.common.BaseHubspotConfig;
import org.apache.beam.sdk.io.cdap.hubspot.common.SourceHubspotConfig;
import org.apache.beam.sdk.io.cdap.hubspot.source.batch.HubspotBatchSource;
import org.apache.beam.sdk.io.hadoop.WritableCoder;
import org.apache.beam.sdk.options.*;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CdapMain {

    private static final Gson GSON = new GsonBuilder().create();

    private static final ImmutableMap<String, Object> TEST_HUBSPOT_PARAMS_MAP =
            ImmutableMap.<String, java.lang.Object>builder()
                    .put("apiServerUrl", BaseHubspotConfig.DEFAULT_API_SERVER_URL)
                    .put("objectType", "Contacts")
                    .put("referenceName", "Contacts")
                    .put("apiKey", "eu1-cf41-6dae-4693-bc3f-e4583fd3bce7")
                    .build();

    /** Sample of PipelineOptions with a ValueProvider option argument. */
    public interface MyOptions extends PipelineOptions {
        @Description("Path to output .txt")
        @Default.String("hubspot-contacts-output.txt")
        ValueProvider<String> getOutputPath();

        void setOutputPath(ValueProvider<String> value);
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

    public static void main(String[] args) {

        // Create a PipelineOptions object. This object lets us set various execution
        // options for our pipeline, such as the runner you wish to use. This example
        // will run with the DirectRunner by default, based on the class path configured
        // in its dependencies.
        MyOptions options = PipelineOptionsFactory
                .fromArgs(args)
                .as(MyOptions.class);

        // In order to run your pipeline, you need to make following runner specific changes:
        //
        // CHANGE 1/3: Select a Beam runner, such as BlockingDataflowRunner
        // or FlinkRunner.
        // CHANGE 2/3: Specify runner-required options.
        // For BlockingDataflowRunner, set project and temp location as follows:
        //   DataflowPipelineOptions dataflowOptions = options.as(DataflowPipelineOptions.class);
        //   dataflowOptions.setRunner(BlockingDataflowRunner.class);
        //   dataflowOptions.setProject("SET_YOUR_PROJECT_ID_HERE");
        //   dataflowOptions.setTempLocation("gs://SET_YOUR_BUCKET_NAME_HERE/AND_TEMP_DIRECTORY");
        // For FlinkRunner, set the runner as follows. See {@code FlinkPipelineOptions}
        // for more details.
        //   options.as(FlinkPipelineOptions.class)
        //      .setRunner(FlinkRunner.class);

        // Create the Pipeline object with the options we defined above
        Pipeline p = Pipeline.create(options);

        // Concept #1: Apply a root transform to the pipeline; in this case, TextIO.Read to read a set
        // of input text files. TextIO.Read returns a PCollection where each element is one line from
        // the input text (a set of Shakespeare's texts).

        // This example reads from a public dataset containing the text of King Lear.
        SourceHubspotConfig pluginConfig =
                new ConfigWrapper<>(SourceHubspotConfig.class).withParams(TEST_HUBSPOT_PARAMS_MAP).build();

        CdapIO.Read<NullWritable, JsonElement> reader =
                CdapIO.<NullWritable, JsonElement>read()
                        .withCdapPluginClass(HubspotBatchSource.class)
                        .withPluginConfig(pluginConfig)
                        .withKeyClass(NullWritable.class)
                        .withValueClass(JsonElement.class);

        p.getCoderRegistry().registerCoderForClass(JsonElement.class, JsonElementCoder.of());

        PCollection<KV<NullWritable, JsonElement>> output =
                p.apply(reader)
                        .setCoder(
                                KvCoder.of(
                                        NullableCoder.of(WritableCoder.of(NullWritable.class)), JsonElementCoder.of()));

        // Write to .txt file
        PCollection<String> strings =
                output
                        .apply(
                                MapElements.into(TypeDescriptors.strings())
                                        .via(
                                                ((SerializableFunction<KV<NullWritable, JsonElement>, String>)
                                                        input -> GSON.toJson(input.getValue()))))
                        .setCoder(StringUtf8Coder.of());

        strings.apply(TextIO.write().to(options.getOutputPath()));

        p.run().waitUntilFinish();
    }
}

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
package org.apache.beam.examples.complete.cdap.transforms;

import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.plugin.hubspot.sink.batch.SinkHubspotConfig;
import io.cdap.plugin.hubspot.source.batch.HubspotBatchSource;
import org.apache.beam.sdk.io.cdap.CdapIO;
import org.apache.beam.sdk.io.cdap.ConfigWrapper;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PDone;
import org.apache.hadoop.io.NullWritable;

import java.util.Map;

/** Different transformations over the processed data in the pipeline. */
public class FormatOutputTransform extends PTransform<PCollection<KV<NullWritable, String>>, PDone> {

  /**
   * Configures Cdap Hubspot receiver.
   *
   * @param params Cdap Hubspot plugin config
   * @return configured writing to Cdap Hubspot
   */
  public static CdapIO.Write<NullWritable, String> writeToCdapHubspot(Map<String, Object> params) {
    final SinkHubspotConfig pluginConfig =
        new ConfigWrapper<>(SinkHubspotConfig.class)
            .withParams(params)
            .build();

    return CdapIO.<NullWritable, String>write()
        .withCdapPluginClass(HubspotBatchSource.class)
        .withPluginConfig(pluginConfig)
        .withKeyClass(NullWritable.class)
        .withValueClass(String.class);
  }

  private final Map<String, Object> params;

  public FormatOutputTransform(Map<String, Object> params) {
    this.params = params;
  }

  @Override
  public PDone expand(PCollection<KV<NullWritable, String>> input) {
    return input.apply("writeToCdapHubspot", writeToCdapHubspot(params));
  }
}

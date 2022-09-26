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
package org.apache.beam.examples.complete.cdap.options;

import io.cdap.plugin.common.Constants;
import io.cdap.plugin.hubspot.common.BaseHubspotConfig;
import java.util.Map;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;

/**
 * The {@link CdapHubspotOptions} interface provides the custom execution options passed by the
 * executor at the command-line.
 */
public interface CdapHubspotOptions extends PipelineOptions {

  @Validation.Required
  @Description("Hubspot api server url. If not specified then the default url will be used.")
  String apiServerUrl();

  @Validation.Required
  @Description("Hubspot OAuth2 API Key.")
  String apiKey();

  @Validation.Required
  @Description("Name of object to pull from Hubspot (e.g. Contacts).")
  String objectType();

  @Validation.Required
  @Description(Constants.Reference.REFERENCE_NAME_DESCRIPTION)
  String referenceName();

  @Validation.Required
  @Description("Path to output .txt file.")
  String outputTxtFilePath();

  default Map<String, Object> toPluginConfigParamsMap() {
    String apiServerUrl = apiServerUrl();
    return ImmutableMap.<String, Object>builder()
        .put(
            BaseHubspotConfig.API_SERVER_URL,
            apiServerUrl != null ? apiServerUrl : BaseHubspotConfig.DEFAULT_API_SERVER_URL)
        .put(BaseHubspotConfig.API_KEY, apiKey())
        .put(BaseHubspotConfig.OBJECT_TYPE, objectType())
        .put(Constants.Reference.REFERENCE_NAME, referenceName())
        .build();
  }
}

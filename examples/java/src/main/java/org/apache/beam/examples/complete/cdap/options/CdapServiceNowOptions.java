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
import io.cdap.plugin.servicenow.source.util.ServiceNowConstants;
import java.util.Map;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;

/**
 * The {@link CdapServiceNowOptions} interface provides the custom execution options passed by the
 * executor at the command-line.
 */
public interface CdapServiceNowOptions extends PipelineOptions {

  @Validation.Required
  @Description("The Client ID for ServiceNow Instance.")
  String clientId();

  @Validation.Required
  @Description("The Client Secret for ServiceNow Instance.")
  String clientSecret();

  @Validation.Required
  @Description("The user name for ServiceNow Instance.")
  String user();

  @Validation.Required
  @Description("The password for ServiceNow Instance.")
  String password();

  @Validation.Required
  @Description(
      "The REST API Endpoint for ServiceNow Instance. For example, https://instance.service-now.com")
  String restApiEndpoint();

  @Validation.Required
  @Description(
      "Mode of query. The mode can be one of two values: "
          + "`Reporting` - will allow user to choose application for which data will be fetched for all tables, "
          + "`Table` - will allow user to enter table name for which data will be fetched.")
  String queryMode();

  @Validation.Required
  @Description(
      "The name of the ServiceNow table from which data to be fetched. Note, the Table name value "
          + "will be ignored if the Mode is set to `Reporting`.")
  String tableName();

  @Validation.Required
  @Description(
      "The type of values to be returned."
          + "`Actual` -  will fetch the actual values from the ServiceNow tables"
          + "`Display` - will fetch the display values from the ServiceNow tables."
          + "Default is Actual.")
  String valueType();

  @Validation.Required
  @Description(Constants.Reference.REFERENCE_NAME_DESCRIPTION)
  String referenceName();

  @Validation.Required
  @Description("Path to output .txt file.")
  String outputTxtFilePath();

  default Map<String, Object> toPluginConfigParamsMap() {
    return ImmutableMap.<String, Object>builder()
        .put(ServiceNowConstants.PROPERTY_CLIENT_ID, clientId())
        .put(ServiceNowConstants.PROPERTY_CLIENT_SECRET, clientSecret())
        .put(ServiceNowConstants.PROPERTY_USER, user())
        .put(ServiceNowConstants.PROPERTY_PASSWORD, password())
        .put(ServiceNowConstants.PROPERTY_API_ENDPOINT, restApiEndpoint())
        .put(ServiceNowConstants.PROPERTY_QUERY_MODE, queryMode())
        .put(ServiceNowConstants.PROPERTY_TABLE_NAME, tableName())
        .put(ServiceNowConstants.PROPERTY_VALUE_TYPE, valueType())
        .put(Constants.Reference.REFERENCE_NAME, referenceName())
        .build();
  }
}

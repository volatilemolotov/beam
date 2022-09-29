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
import io.cdap.plugin.salesforce.SalesforceConstants;
import io.cdap.plugin.salesforce.plugin.source.batch.util.SalesforceSourceConstants;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;

import java.util.Map;

public interface CdapSalesforceOptions extends PipelineOptions {

    @Validation.Required
    @Description(Constants.Reference.REFERENCE_NAME_DESCRIPTION)
    String referenceName();

    @Validation.Required
    @Description(SalesforceConstants.PROPERTY_USERNAME)
    String username();

    @Validation.Required
    @Description(SalesforceConstants.PROPERTY_PASSWORD)
    String password();

    @Validation.Required
    @Description(SalesforceConstants.PROPERTY_SECURITY_TOKEN)
    String securityToken();

    @Validation.Required
    @Description(SalesforceConstants.PROPERTY_CONSUMER_KEY)
    String consumerKey();

    @Validation.Required
    @Description(SalesforceConstants.PROPERTY_CONSUMER_SECRET)
    String consumerSecret();

    @Validation.Required
    @Description(SalesforceConstants.PROPERTY_LOGIN_URL)
    String loginUrl();

    @Validation.Required
    @Description(SalesforceSourceConstants.PROPERTY_SOBJECT_NAME)
    String sObjectName();

    @Validation.Required
    @Description("Path to output .txt file.")
    String outputTxtFilePath();

    default Map<String, Object> toPluginConfigParamsMap() {
        return ImmutableMap.<String, Object>builder()
            .put(Constants.Reference.REFERENCE_NAME, referenceName())
            .put(SalesforceConstants.PROPERTY_USERNAME, username())
            .put(SalesforceConstants.PROPERTY_PASSWORD, password())
            .put(SalesforceConstants.PROPERTY_SECURITY_TOKEN, securityToken())
            .put(SalesforceConstants.PROPERTY_CONSUMER_KEY, consumerKey())
            .put(SalesforceConstants.PROPERTY_CONSUMER_SECRET, consumerSecret())
            .put(SalesforceConstants.PROPERTY_LOGIN_URL, loginUrl())
            .put(SalesforceSourceConstants.PROPERTY_SOBJECT_NAME, sObjectName())
            .build();
    }
}
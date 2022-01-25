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

import com.google.common.collect.ImmutableMap;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceInputFormat;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceInputFormatProvider;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceSourceConfig;
import io.cdap.plugin.salesforce.plugin.source.batch.SalesforceBatchSource;

import java.util.*;

/**
 * Class providing an example of plugin wrapper usage.
 */
public class PluginWrapperTest {
    /**
     * Wrapper builder for Salesforce Batch Source plugin.
     */
    public static class SalesforcePluginWrapperBuilder extends PluginWrapperBuilder {
        /**
         * Constructor for Salesforce Batch Source plugin wrapper builder.
         */
        public SalesforcePluginWrapperBuilder() {
            super(SalesforceBatchSource.class);
            this.withFormat(SalesforceInputFormat.class)
                .withFormatProvider(SalesforceInputFormatProvider.class);
        }
    }

    /**
     * Wrapper for Salesforce Batch Source plugin.
     */
    public static class SalesforcePluginWrapper extends PluginWrapper {
        /**
         * Constructor for creating Salesforce Batch Source plugin wrapper instance.
         */
        public SalesforcePluginWrapper() {
            super(SalesforceBatchSource.class);
        }

        /**
         * Reads data from Salesforce.
         */
        public Object read() {
            return new Object();
        }
    }

    private final ImmutableMap<String, String> TEST_SALESFORCE_PARAMS_MAP =
            ImmutableMap.<String, String>builder()
                    .put("sObjectName", "sObject")
                    .put("datetimeAfter", "datetime")
                    .put("consumerKey", "key")
                    .put("consumerSecret", "secret")
                    .put("username", "user")
                    .put("password", "password")
                    .put("loginUrl", "https://www.google.com")
                    .put("referenceName", "some reference name")
                    .build();

    private final HashMap<String, Object> TEST_SALESFORCE_PARAMS_MAP_OBJ =
            new HashMap<>(TEST_SALESFORCE_PARAMS_MAP);

    private final String REFERENCE_NAME_PARAM_NAME = "referenceName";

    /**
     * Config for Salesforce Batch Source plugin.
     */
    public SalesforceSourceConfig salesforceSourceConfig =
            new ConfigWrapper<>(SalesforceSourceConfig.class)
            .withParams(TEST_SALESFORCE_PARAMS_MAP_OBJ)
            .setParam(REFERENCE_NAME_PARAM_NAME, "some reference name")
            .build();

    /**
     * Salesforce plugin wrapper instance.
     */
    public SalesforcePluginWrapper pluginWrapper =
            (SalesforcePluginWrapper) new SalesforcePluginWrapperBuilder()
                    .withConfig(salesforceSourceConfig)
                    .build();

    /**
     * Example of reading data using plugin wrapper.
     */
    Object obj = pluginWrapper.read();
}

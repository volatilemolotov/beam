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

import java.util.*;

public class PluginWrapperTest {
    public static class SalesforcePluginWrapperBuilder<F, FP> extends PluginWrapperBuilder<F, FP> {
        public SalesforcePluginWrapperBuilder(PluginWrapper<F, FP> pluginWrapper) {
            super(pluginWrapper);
        }

        public PluginWrapper<F, FP> build() {
            return pluginWrapper;
        }
    }

    public static class SalesforcePluginWrapper<K, V> extends SourcePluginWrapper<K, V> {
        public SalesforcePluginWrapper (
                SalesforceInputFormat salesforceInputFormat,
                SalesforceInputFormatProvider salesforceInputFormatProvider
        ) {
            super(salesforceInputFormat, salesforceInputFormatProvider);
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

    public SalesforceSourceConfig salesforceSourceConfig =
            new ConfigWrapper<>(SalesforceSourceConfig.class)
            .withParams(TEST_SALESFORCE_PARAMS_MAP_OBJ)
            .setParam(REFERENCE_NAME_PARAM_NAME, "some reference name")
            .build();


    private final List<String> queries = Arrays.asList("q1", "q2", "q3");

    public SalesforceInputFormat salesforceInputFormat = new SalesforceInputFormat();
    SalesforceInputFormatProvider salesforceInputFormatProvider =
            new SalesforceInputFormatProvider(salesforceSourceConfig, queries,
                    TEST_SALESFORCE_PARAMS_MAP, null);

    public PluginWrapper<SalesforceInputFormat, SalesforceInputFormatProvider> salesforcePluginWrapper =
            new SalesforcePluginWrapper(salesforceInputFormat, salesforceInputFormatProvider);


    public PluginWrapper<SalesforceInputFormat, SalesforceInputFormatProvider> pluginWrapper =
            new SalesforcePluginWrapperBuilder<>(salesforcePluginWrapper)
                    .withConfig(salesforceSourceConfig)
                    .build();
}

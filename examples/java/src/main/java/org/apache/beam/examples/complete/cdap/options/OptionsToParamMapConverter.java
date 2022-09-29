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

import static io.cdap.plugin.zendesk.source.batch.ZendeskBatchSourceConfig.PROPERTY_CONNECT_TIMEOUT;
import static io.cdap.plugin.zendesk.source.batch.ZendeskBatchSourceConfig.PROPERTY_MAX_RETRY_COUNT;
import static io.cdap.plugin.zendesk.source.batch.ZendeskBatchSourceConfig.PROPERTY_MAX_RETRY_JITTER_WAIT;
import static io.cdap.plugin.zendesk.source.batch.ZendeskBatchSourceConfig.PROPERTY_MAX_RETRY_WAIT;
import static io.cdap.plugin.zendesk.source.batch.ZendeskBatchSourceConfig.PROPERTY_READ_TIMEOUT;
import static io.cdap.plugin.zendesk.source.batch.ZendeskBatchSourceConfig.PROPERTY_URL;
import static io.cdap.plugin.zendesk.source.common.config.BaseZendeskSourceConfig.PROPERTY_ADMIN_EMAIL;
import static io.cdap.plugin.zendesk.source.common.config.BaseZendeskSourceConfig.PROPERTY_API_TOKEN;
import static io.cdap.plugin.zendesk.source.common.config.BaseZendeskSourceConfig.PROPERTY_OBJECTS_TO_PULL;
import static io.cdap.plugin.zendesk.source.common.config.BaseZendeskSourceConfig.PROPERTY_SUBDOMAINS;

import java.util.Map;
import org.apache.beam.vendor.guava.v26_0_jre.com.google.common.collect.ImmutableMap;

public class OptionsToParamMapConverter {

  public static Map<String, Object> getParams(CdapZendeskOptions zendeskOptions) {
    return ImmutableMap.<String, Object>builder()
        .put("referenceName", "referenceName")
        .put(PROPERTY_ADMIN_EMAIL, zendeskOptions.getAdminEmail())
        .put(PROPERTY_API_TOKEN, zendeskOptions.getApiToken())
        .put(PROPERTY_URL, zendeskOptions.getZendeskBaseUrl())
        .put(PROPERTY_SUBDOMAINS, zendeskOptions.getSubdomains())
        .put(PROPERTY_MAX_RETRY_COUNT, zendeskOptions.getMaxRetryCount())
        .put(PROPERTY_MAX_RETRY_WAIT, zendeskOptions.getMaxRetryWait())
        .put(PROPERTY_MAX_RETRY_JITTER_WAIT, zendeskOptions.getMaxRetryJitterWait())
        .put(PROPERTY_CONNECT_TIMEOUT, zendeskOptions.getConnectTimeout())
        .put(PROPERTY_READ_TIMEOUT, zendeskOptions.getReadTimeout())
        .put(PROPERTY_OBJECTS_TO_PULL, zendeskOptions.getObjectsToPull())
        .build();
  }
}

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
package io.cdap.plugin.zuora.plugin.batch.sink;

import com.google.common.base.Strings;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.common.IdUtils;
import io.cdap.plugin.zuora.plugin.common.BaseConfigValidator;

/** Sink Config Validator. */
public class ZuoraSinkConfigValidator extends BaseConfigValidator {
  private ZuoraSinkConfig config;

  public ZuoraSinkConfigValidator(FailureCollector failureCollector, ZuoraSinkConfig config) {
    super(failureCollector, config);
    this.config = config;
  }

  @Override
  public void doValidation() {
    IdUtils.validateReferenceName(config.referenceName, failureCollector);

    if (!config.containsMacro(ZuoraSinkConfig.PROPERTY_OBJECT_NAME)) {
      if (Strings.isNullOrEmpty(config.getObjectName())) {
        failureCollector
            .addFailure("Object name should be set", "")
            .withConfigProperty(ZuoraSinkConfig.PROPERTY_OBJECT_NAME);
      }
    }

    if (!config.containsMacro(ZuoraSinkConfig.PROPERTY_BODY_COLUMN)) {
      if (Strings.isNullOrEmpty(config.getBodyColumnName())) {
        failureCollector
            .addFailure("Body column name should be set", "")
            .withConfigProperty(ZuoraSinkConfig.PROPERTY_BODY_COLUMN);
      }
    }
  }
}

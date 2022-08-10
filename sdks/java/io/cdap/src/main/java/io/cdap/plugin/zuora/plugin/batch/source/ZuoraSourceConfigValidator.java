/*
 *  Copyright © 2020 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.cdap.plugin.zuora.plugin.batch.source;

import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.common.IdUtils;
import io.cdap.plugin.zuora.plugin.common.BaseConfigValidator;

/**
 * Source config validator.
 */
public class ZuoraSourceConfigValidator extends BaseConfigValidator {
  private ZuoraSourceConfig config;

  public ZuoraSourceConfigValidator(FailureCollector failureCollector, ZuoraSourceConfig config) {
    super(failureCollector, config);
    this.config = config;
  }

  private void checkObjects() {
    if (config.getObjects().isEmpty()) {
      failureCollector.addFailure("No objects selected for the query", null)
        .withConfigProperty(ZuoraSourceConfig.PROPERTY_BASE_OBJECTS_TO_PULL);
    }
  }

  @Override
  public void doValidation() {
    IdUtils.validateReferenceName(config.referenceName, failureCollector);

    if (!config.containsMacro(ZuoraSourceConfig.PROPERTY_BASE_OBJECTS_TO_PULL)) {
      checkObjects();
    }
  }
}

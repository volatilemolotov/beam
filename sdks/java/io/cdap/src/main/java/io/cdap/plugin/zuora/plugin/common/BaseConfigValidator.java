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

package io.cdap.plugin.zuora.plugin.common;

import com.google.common.base.Strings;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.cdap.etl.api.validation.ValidationFailure;
import io.cdap.plugin.zuora.client.ZuoraRestClient;
import java.io.IOException;

/**
 * Base Config Validator.
 */
public abstract class BaseConfigValidator {
  protected FailureCollector failureCollector;
  protected ZuoraRestClient client = null;
  private BaseConfig config;

  public BaseConfigValidator(FailureCollector failureCollector, BaseConfig config) {
    this.failureCollector = failureCollector;
    this.config = config;
  }

  private void checkAuthType() {
    try {
      config.getAuthType();
    } catch (IllegalArgumentException e) {
      failureCollector.addFailure(String.format("Wrong authentication method selected: %s", e.getMessage()), null)
        .withConfigProperty(BaseConfig.PROPERTY_AUTH_TYPE);
    }
  }

  private void checkAuthData() {
    boolean tryToLogin = true;

    if (Strings.isNullOrEmpty(config.getAuthUsername())) {
      failureCollector.addFailure("User name is not set", null)
        .withConfigProperty(BaseConfig.PROPERTY_USERNAMENAME);
      tryToLogin = false;
    }
    if (Strings.isNullOrEmpty(config.getAuthPassword())) {
      failureCollector.addFailure("Password is not set", null)
        .withConfigProperty(BaseConfig.PROPERTY_PASSWORD);
      tryToLogin = false;
    }

    if (tryToLogin) {
      client = new ZuoraRestClient(config);
    }
  }

  private void checkClientConnectivity() {
    try {
      client.checkConnection();
    } catch (IOException e) {
      ValidationFailure failure = failureCollector
        .addFailure(String.format("Connectivity issues: %s", e.getMessage()), null)
        .withStacktrace(e.getStackTrace());

      if (config.getAuthType() == AuthType.BASIC) {
        failure
          .withConfigProperty(BaseConfig.PROPERTY_USERNAMENAME)
          .withConfigProperty(BaseConfig.PROPERTY_PASSWORD);
      }
      if (config.getAuthType() == AuthType.OAUTH2) {
        failure.withConfigProperty(BaseConfig.PROPERTY_CLIENT_ID);
        failure.withConfigProperty(BaseConfig.PROPERTY_CLIENT_SECRET);
      }
    }
  }

  private boolean authContainsMacro() {
    return config.containsMacro(BaseConfig.PROPERTY_USERNAMENAME)
      || config.containsMacro(BaseConfig.PROPERTY_PASSWORD)
      || config.containsMacro(BaseConfig.PROPERTY_CLIENT_ID)
      || config.containsMacro(BaseConfig.PROPERTY_CLIENT_SECRET);
  }

  /**
   * Perform validation tasks which did not involve API Client usage.
   */
  public abstract void doValidation();

  /**
   * Validate the required properties of the config file.
   */
  public void validate() {
    client = null;

    if (!config.containsMacro(BaseConfig.PROPERTY_AUTH_TYPE)) {
      checkAuthType();
    }

    if (!authContainsMacro()) {
      checkAuthData();
    }

    doValidation();

    // client could be not constructed, if any of checkAuth tests failed
    if (client != null && !authContainsMacro()) {
      checkClientConnectivity();
    }
  }
}

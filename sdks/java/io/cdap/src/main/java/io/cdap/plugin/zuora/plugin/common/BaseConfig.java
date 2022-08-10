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

import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.common.ReferencePluginConfig;
import javax.annotation.Nullable;

/**
 * Base plugin configuration.
 */
public abstract class BaseConfig extends ReferencePluginConfig {
  public static final String PROPERTY_CONFIG_JSON = "cdap.zuora.config";

  public static final String PLUGIN_NAME = "Zuora";
  public static final String OBJECT_NAME_FIELD = "object_name";

  public static final String PROPERTY_AUTH_TYPE = "authType";
  public static final String PROPERTY_USERNAMENAME = "authUsername";
  public static final String PROPERTY_PASSWORD = "authPassword";
  public static final String PROPERTY_CLIENT_ID = "authClientId";
  public static final String PROPERTY_CLIENT_SECRET = "authClientSecret";
  public static final String PROPERTY_REST_API = "apiEndpoint";
  private static final String EMPTY_STRING = "";

  @Macro
  @Name(PROPERTY_AUTH_TYPE)
  @Description("The way, how user would like to be authenticated to the account")
  private String authType;

  @Macro
  @Name(PROPERTY_USERNAMENAME)
  @Description("Login name for the account")
  @Nullable
  private String authUsername;

  @Macro
  @Name(PROPERTY_PASSWORD)
  @Description("Password for the account")
  @Nullable
  private String authPassword;

  @Macro
  @Name(PROPERTY_CLIENT_ID)
  @Description("OAuth2 Client id")
  @Nullable
  private String authClientId;

  @Macro
  @Name(PROPERTY_CLIENT_SECRET)
  @Description("OAuth2 Client secret")
  @Nullable
  private String authClientSecret;

  @Macro
  @Name(PROPERTY_REST_API)
  @Description("REST API Endpoint")
  private String apiEndpoint;


  public BaseConfig(String referenceName) {
    super(referenceName);
  }

  /**
   * Validate configuration for the issues.
   *
   */
  protected abstract void validate(FailureCollector failureCollector);

  /**
   * Returns the string.
   * @return string
   */
  public String getAuthUsername() {
    switch (getAuthType()) {
      case BASIC:
        return authUsername;
      case OAUTH2:
        return authClientId;
    }
    return EMPTY_STRING;
  }

  /**
   * Returns the string.
   * @return string
   */
  public String getAuthPassword() {
    switch (getAuthType()) {
      case OAUTH2:
        return authClientSecret;
      case BASIC:
        return authPassword;
    }
    return EMPTY_STRING;
  }

  /**
   * Returns the AuthType.
   * @return AuthType
   */
  public AuthType getAuthType() {
    switch (authType) {
      case "basic":
        return AuthType.BASIC;
      case "oauth2":
        return AuthType.OAUTH2;
      default:
        throw new IllegalArgumentException(String.format("Authentication using '%s' is not supported", authType));
    }
  }

  public String getApiEndpoint() {
    return apiEndpoint;
  }
}

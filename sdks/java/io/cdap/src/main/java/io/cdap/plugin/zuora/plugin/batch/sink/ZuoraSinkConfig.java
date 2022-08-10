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

package io.cdap.plugin.zuora.plugin.batch.sink;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Sink Config.
 */
public class ZuoraSinkConfig extends BaseConfig {
  public static final String PROPERTY_OBJECT_NAME = "objectName";
  public static final String PROPERTY_BODY_COLUMN = "bodyColumnName";
  public static final String PROPERTY_REQUEST_ARGUMENTS_SOURCE = "requestArgumentsSource";
  public static final String PROPERTY_REQUEST_ARGUMENTS = "requestArguments";

  public static final String TO_TYPE_INPUT = "input";
  public static final String TO_TYPE_CONFIG = "config";

  /**
   * Available sources for recipient addresses.
   */
  public enum ToArgumentsSource {
    CONFIG,
    INPUT;

    /**
     * Returns the ToArgumentsSource.
     * @param toType the totype
     * @return ToArgumentsSource
     */
    public static ToArgumentsSource fromString(String toType) {
      switch (toType) {
        case TO_TYPE_INPUT:
          return ToArgumentsSource.INPUT;
        case TO_TYPE_CONFIG:
          return ToArgumentsSource.CONFIG;
        default:
          throw new IllegalArgumentException(String.format("Unknown arguments source '%s', allowed: '%s', '%s'",
            toType, TO_TYPE_INPUT, TO_TYPE_CONFIG));
      }
    }
  }

  @Name(PROPERTY_OBJECT_NAME)
  @Description("Object name to write")
  @Macro
  private String objectName;

  @Name(PROPERTY_BODY_COLUMN)
  @Description("JSON content of the object")
  @Macro
  private String bodyColumnName;

  @Name(PROPERTY_REQUEST_ARGUMENTS_SOURCE)
  @Description("Object arguments would be taken from the sink configuration or input schema columns")
  @Macro
  private String requestArgumentsSource;

  @Name(PROPERTY_REQUEST_ARGUMENTS)
  @Description("Arguments required for the object. If input record request arguments selected, contains only names")
  @Nullable
  @Macro
  private String requestArguments;

  public ZuoraSinkConfig(String referenceName) {
    super(referenceName);
  }

  private void validateField(Schema schema, String fieldName) {
    Schema.Field field = schema.getField(fieldName);

    if (field == null) {
      throw new IllegalArgumentException(String.format("Plugin is configured to use column '%s'" +
        ", but input schema did not provide such column", fieldName));
    }

    Schema fieldSchema = field.getSchema();
    if (fieldSchema.getType() == Schema.Type.UNION) {
      if (fieldSchema.getUnionSchemas().stream().noneMatch(x -> x.getType() == Schema.Type.STRING)) {
        throw new IllegalArgumentException(String.format("The input schema column '%s' expected to be of type STRING",
          fieldName));
      }
      return;
    }

    if (fieldSchema.getType() != Schema.Type.STRING) {
      throw new IllegalArgumentException(String.format("The input schema column '%s' expected to be of type STRING",
        fieldName));
    }
  }

  @Override
  protected void validate(FailureCollector failureCollector) {
    new ZuoraSinkConfigValidator(failureCollector, this).validate();
  }

  /**
   * Just validate the schema.
   * @param schema the schema
   */
  public void validate(Schema schema) {
    if (schema == null) {
      throw new IllegalArgumentException("Input schema cannot be empty");
    }

    validateField(schema, bodyColumnName);;

    if (getArgumentsSource() == ToArgumentsSource.INPUT) {
      getRequestArguments().keySet().forEach(x -> {
        validateField(schema, x);
      });
    }
  }

  public ToArgumentsSource getArgumentsSource() {
    return ToArgumentsSource.fromString(requestArgumentsSource);
  }

  public String getObjectName() {
    return objectName;
  }

  public String getBodyColumnName() {
    return bodyColumnName;
  }

  /**
   * Returns the map of strings.
   * @return map of strings
   */
  @SuppressWarnings("StringSplitter")
  public Map<String, String> getRequestArguments() {
    ImmutableMap.Builder<String, String> argumentsBuilder = new ImmutableMap.Builder<>();
    if (!Strings.isNullOrEmpty(requestArguments)) {
      Arrays.stream(requestArguments.split(",")).forEach(x -> {
        String[] pair = x.split(":");
        if (pair.length == 2) {
          argumentsBuilder.put(pair[0], pair[1]);
        }
      });
    }
    return argumentsBuilder.build();
  }

}

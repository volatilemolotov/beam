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
package io.cdap.plugin.zuora.client.schema;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/** Zuora Schema types. */
@SuppressWarnings({"ImmutableEnumChecker", "StringSplitter", "ClassNewInstance"})
public class SchemaFieldType {
  public static final String PICKLIST = "picklist";
  public static final String ARRAY = "array";

  private enum FieldType {
    DATE("date"),
    DATETIME("datetime"),
    BOOLEAN("boolean"),
    PICKLIST("picklist"),
    ZOQL("ZOQL"),
    TEXT("text"),
    INTEGER("integer"),
    DECIMAL("decimal"),
    ARRAY("array"),
    UNKNOWN("unknown");

    private String type;

    FieldType(String type) {
      this.type = type;
    }

    public String getType() {
      return type;
    }

    public static FieldType fromString(String s) {
      return Arrays.stream(FieldType.values())
          .filter(x -> x.getType().equals(s))
          .findFirst()
          .orElse(FieldType.UNKNOWN);
    }
  }

  private String type;
  private String subtype;

  SchemaFieldType(String type) {
    String[] data = type.split("\\|");
    this.type = data[0];
    if (data.length == 2) {
      this.subtype = data[1];
    }
  }

  public String getType() {
    return type;
  }

  public String getSubtype() {
    return subtype;
  }

  /**
   * Returns the string.
   *
   * @param complete the complete is boolean variable.
   * @return string
   */
  public String getJavaType(boolean complete) {
    FieldType fieldType = FieldType.fromString(type);
    switch (fieldType) {
      case BOOLEAN:
        return "Boolean";
      case INTEGER:
        return "Integer";
      case DECIMAL:
        return "Double";
      case ARRAY:
        return (complete) ? String.format("List<%s>", subtype) : "List";
      default:
        return "String";
    }
  }

  /**
   * Map Zuora type to CDAP Type.
   *
   * <p>For reference {@link io.cdap.cdap.api.data.schema.Schema.Type}
   */
  public String getCDAPType() {
    FieldType fieldType = FieldType.fromString(type);
    switch (fieldType) {
      case BOOLEAN:
        return "BOOLEAN";
      case INTEGER:
        return "INT";
      case DECIMAL:
        return "DOUBLE";
      case ARRAY:
        return "ARRAY";
      default:
        return "STRING";
    }
  }

  /**
   * Returns the string.
   *
   * @param variableName the variable name
   * @return string
   */
  public String getNullWrapper(String variableName) {
    switch (getJavaType(false)) {
      case "String":
        return String.format("(%s == null) ? \"\" : %s", variableName, variableName);
      case "Boolean":
        return String.format("(%s == null) ? false : %s", variableName, variableName);
      case "List":
        return String.format(
            "(%s == null) ? Collections.EMPTY_LIST : %s", variableName, variableName);
      case "Integer":
        return String.format("(%s == null) ? 0 : %s", variableName, variableName);
      case "Double":
        return String.format("(%s == null) ? 0d : %s", variableName, variableName);
    }
    return variableName;
  }

  /**
   * Returns the object.
   *
   * @param type the class type
   * @return object
   * @throws IllegalAccessException if any validation issue
   * @throws InstantiationException if any validation issue
   */
  public static Object getDefaultValue(Class<?> type)
      throws IllegalAccessException, InstantiationException {
    if (type == Integer.class) {
      return 0;
    } else if (type == String.class) {
      return "";
    } else if (type == Double.class) {
      return 0d;
    } else if (type == Boolean.class) {
      return false;
    } else if (type == List.class) {
      return Collections.EMPTY_LIST;
    } else if (type == Map.class) {
      return Collections.EMPTY_MAP;
    } else {
      return type.newInstance();
    }
  }

  public static SchemaFieldType fromString(String type) {
    return new SchemaFieldType(type);
  }
}

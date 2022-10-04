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

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

/** Zuora object field definition. */
public class ZuoraObjectField {

  @XmlElement(name = "name")
  @SerializedName("name")
  private String name;

  @XmlElement(name = "label")
  @SerializedName("label")
  private String label;

  @XmlElement(name = "selectable", defaultValue = "false")
  @SerializedName("selectable")
  private Boolean selectable;

  @XmlElement(name = "creatable", defaultValue = "false")
  @SerializedName("creatable")
  private Boolean creatable;

  @XmlElement(name = "updatable", defaultValue = "false")
  @SerializedName("updatable")
  private Boolean updatable;

  @XmlElement(name = "filterable", defaultValue = "false")
  @SerializedName("filterable")
  private Boolean filterable;

  @XmlElement(name = "custom", defaultValue = "false")
  @SerializedName("custom")
  private Boolean custom;

  @XmlElement(name = "maxlength", defaultValue = "0")
  @SerializedName("maxlength")
  private Integer maxlength;

  @XmlElement(name = "required", defaultValue = "false")
  @SerializedName("required")
  private Boolean required;

  @XmlElement(name = "type")
  @SerializedName("type")
  private String type;

  @XmlTransient
  @SerializedName("subtype")
  private String subtype;

  @XmlElementWrapper(name = "contexts")
  @XmlElement(name = "context")
  private List<String> contexts;

  @XmlElementWrapper(name = "options")
  @XmlElement(name = "option")
  private List<String> options;

  public String getName() {
    return name;
  }

  public String getLabel() {
    return label;
  }

  public Boolean getSelectable() {
    return selectable;
  }

  public Boolean getCreatable() {
    return creatable;
  }

  public Boolean getUpdatable() {
    return updatable;
  }

  public Boolean getFilterable() {
    return filterable;
  }

  public Boolean getCustom() {
    return custom;
  }

  public Integer getMaxlength() {
    return maxlength;
  }

  public Boolean getRequired() {
    return required;
  }

  public String getSubtype() {
    return subtype;
  }

  public SchemaFieldType getType() {
    return SchemaFieldType.fromString(type);
  }

  public List<String> getContexts() {
    return contexts;
  }

  public List<String> getOptions() {
    return options;
  }

  @SuppressWarnings("AnnotateFormatMethod")
  private void appendLine(StringBuilder sb, String line, Object... args) {
    if (args != null) {
      line = String.format(line, args);
    }
    sb.append("  ").append(line).append(System.lineSeparator());
  }

  /**
   * Returns the string.
   *
   * @return string
   */
  public String getJavaName() {
    char[] c = getName().toCharArray();
    c[0] = Character.toLowerCase(c[0]);
    return new String(c);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    appendLine(builder, "/**");
    appendLine(builder, "* Name: %s (%s), Type: %s", getName(), getLabel(), type);
    appendLine(
        builder,
        "* Options (custom, update, select): %s, %s, %s",
        getCustom(),
        getUpdatable(),
        getSelectable());

    if (options != null && !options.isEmpty()) {
      appendLine(builder, "*");
      appendLine(builder, "* Allowed values: ");

      final int[] lineWidth = {0};

      options.forEach(
          x -> {
            if (lineWidth[0] == 0) {
              builder.append("  * ");
            } else if (lineWidth[0] >= 80) {
              lineWidth[0] = 0;
              builder.append(System.lineSeparator()).append("  * ");
            }
            lineWidth[0] += x.length() + 2;
            builder.append(String.format("%s, ", x));
          });
      appendLine(builder, "%s  *", System.lineSeparator());
    }
    appendLine(builder, "**/");
    if (required != null && !required) {
      appendLine(builder, "@Nullable");
    }

    // even while describe return field names with first upper case letter, real response comes with
    // lower case
    appendLine(builder, "@SerializedName(\"%s\")", getJavaName());
    if (getType().getCDAPType().equalsIgnoreCase("array")) {
      appendLine(
          builder,
          "@ObjectFieldDefinition(FieldType = Schema.Type.%s, NestedClass = \"%s\")",
          getType().getCDAPType(),
          subtype);
    } else {
      appendLine(
          builder, "@ObjectFieldDefinition(FieldType = Schema.Type.%s)", getType().getCDAPType());
    }
    appendLine(builder, "private %s %s;", getType().getJavaType(true), getJavaName());
    return builder.toString();
  }
}

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

import com.google.common.base.Strings;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/** Zuora object. */
@SuppressWarnings("AnnotateFormatMethod")
@XmlRootElement(name = "object")
public class ZuoraObjectSchema {

  @XmlElement(name = "name")
  @SerializedName("name")
  private String name;

  @XmlElement(name = "label")
  @SerializedName("label")
  private String label;

  @XmlElementWrapper(name = "fields")
  @XmlElement(name = "field")
  @SerializedName("fields")
  private List<ZuoraObjectField> fields;

  @XmlElementWrapper(name = "related-objects")
  @XmlElement(name = "object")
  @SerializedName("relatedObjects")
  private List<ZuoraObjectSchema> relatedObjects;

  @XmlTransient
  @SerializedName("api")
  private String api;

  @XmlTransient
  @SerializedName("requiredFields")
  private String requiredFields;

  public String getName() {
    return name;
  }

  public String getLabel() {
    return label;
  }

  public List<ZuoraObjectField> getFields() {
    return fields;
  }

  public List<ZuoraObjectSchema> getRelatedObjects() {
    return relatedObjects;
  }

  private void appendLine(StringBuilder sb, String line, Object... args) {
    if (args != null && args.length != 0) {
      line = String.format(line, args);
    }
    sb.append(line).append(System.lineSeparator());
  }

  boolean hasListFields() {
    return fields.stream().anyMatch(x -> x.getType().getType().equals(SchemaFieldType.ARRAY));
  }

  private void generateAsMapMethod(StringBuilder builder, List<ZuoraObjectField> fields) {
    appendLine(builder, "  @Override");
    appendLine(builder, "  public void addFields() {");
    fields.stream()
        .filter(x -> !x.getCustom())
        .forEach(
            x -> {
              appendLine(
                  builder,
                  "    addCustomField(\"%s\", %s, %s.class);",
                  // even while describe return field names with first upper case letter, real
                  // response comes with lower case
                  x.getJavaName(),
                  x.getJavaName(),
                  x.getType().getJavaType(false));
            });
    appendLine(builder, "  }");
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    appendLine(builder, "/**");
    appendLine(builder, "* Object name: %s (%s)", getName(), getLabel());
    if (relatedObjects != null) {
      appendLine(builder, "* Related objects: ");
      relatedObjects.forEach(
          x -> {
            appendLine(builder, "* - %s", x.getName());
          });
    }

    appendLine(builder, "**/");
    appendLine(builder, "@SuppressWarnings(\"unused\")");
    appendLine(builder, "@ObjectDefinition(");
    appendLine(builder, "  Name = \"%s\",", getName());
    if (!Strings.isNullOrEmpty(requiredFields)) {
      appendLine(builder, "  RequiredArguments = {");
      appendLine(builder, "    %s", requiredFields);
      appendLine(builder, "  },");
    }
    if (api != null) {
      appendLine(builder, "  APIUrl = \"%s\",", api);
      appendLine(builder, "  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE");
    } else {
      appendLine(builder, "  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED");
    }
    appendLine(builder, ")");
    appendLine(builder, "public class %s extends BaseObject {", getName());
    if (fields != null) {
      fields.stream().filter(x -> !x.getCustom()).forEach(x -> appendLine(builder, x.toString()));
      appendLine(builder, "");
      generateAsMapMethod(builder, fields);
    }
    appendLine(builder, "}");

    return builder.toString();
  }
}

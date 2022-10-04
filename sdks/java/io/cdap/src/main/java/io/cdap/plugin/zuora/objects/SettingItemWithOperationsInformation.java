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
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Object name: SettingItemWithOperationsInformation (SettingItemWithOperationsInformation). Related
 * objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "SettingItemWithOperationsInformation",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class SettingItemWithOperationsInformation extends BaseObject {
  /**
   * Name: context (context), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("context")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String context;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: httpOperations (httpOperations), Type: array|SettingItemHttpOperation. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("httpOperations")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "SettingItemHttpOperation")
  private List<SettingItemHttpOperation> httpOperations;

  /** Name: key (key), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("key")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String key;

  /**
   * Name: pathPattern (pathPattern), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("pathPattern")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pathPattern;

  @Override
  public void addFields() {
    addCustomField("context", context, String.class);
    addCustomField("description", description, String.class);
    addCustomField("httpOperations", httpOperations, List.class);
    addCustomField("key", key, String.class);
    addCustomField("pathPattern", pathPattern, String.class);
  }
}

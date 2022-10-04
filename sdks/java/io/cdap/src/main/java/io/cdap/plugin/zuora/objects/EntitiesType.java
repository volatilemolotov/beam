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
import javax.annotation.Nullable;

/** Object name: EntitiesType (EntitiesType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "Entities",
    responseRootElement = "entities",
    APIUrl = "entities",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class EntitiesType extends BaseObject {
  /**
   * Name: displayName (displayName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("displayName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String displayName;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /** Name: locale (locale), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("locale")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String locale;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: parentId (parentId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("parentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String parentId;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: tenantId (tenantId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("tenantId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tenantId;

  /**
   * Name: timezone (timezone), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("timezone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String timezone;

  @Override
  public void addFields() {
    addCustomField("displayName", displayName, String.class);
    addCustomField("id", id, String.class);
    addCustomField("locale", locale, String.class);
    addCustomField("name", name, String.class);
    addCustomField("parentId", parentId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("tenantId", tenantId, String.class);
    addCustomField("timezone", timezone, String.class);
  }
}

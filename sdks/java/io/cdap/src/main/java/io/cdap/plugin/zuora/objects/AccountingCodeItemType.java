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

/** Object name: AccountingCodeItemType (AccountingCodeItemType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AccountingCodeItemType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AccountingCodeItemType extends BaseObject {
  /**
   * Name: category (category), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("category")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String category;

  /**
   * Name: createdBy (createdBy), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdBy;

  /**
   * Name: createdOn (createdOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdOn;

  /**
   * Name: glAccountName (glAccountName), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("glAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String glAccountName;

  /**
   * Name: glAccountNumber (glAccountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("glAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String glAccountNumber;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
   * Name: updatedBy (updatedBy), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedBy;

  /**
   * Name: updatedOn (updatedOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedOn;

  @Override
  public void addFields() {
    addCustomField("category", category, String.class);
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("glAccountName", glAccountName, String.class);
    addCustomField("glAccountNumber", glAccountNumber, String.class);
    addCustomField("id", id, String.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedBy", updatedBy, String.class);
    addCustomField("updatedOn", updatedOn, String.class);
  }
}

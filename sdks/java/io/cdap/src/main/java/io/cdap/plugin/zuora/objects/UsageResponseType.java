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

/** Object name: UsageResponseType (UsageResponseType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "UsageResponseType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class UsageResponseType extends BaseObject {
  /**
   * Name: accountNumber (accountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

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
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: fileName (fileName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("fileName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fileName;

  /**
   * Name: groupId (groupId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("groupId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String groupId;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: importId (importId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("importId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String importId;

  /**
   * Name: quantity (quantity), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
   * Name: startDateTime (startDateTime), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("startDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDateTime;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /** Name: tag (tag), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tag")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tag;

  /**
   * Name: uniqueKey (uniqueKey), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("uniqueKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uniqueKey;

  /**
   * Name: unitOfMeasure (unitOfMeasure), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("unitOfMeasure")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unitOfMeasure;

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
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("description", description, String.class);
    addCustomField("fileName", fileName, String.class);
    addCustomField("groupId", groupId, String.class);
    addCustomField("id", id, String.class);
    addCustomField("importId", importId, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("startDateTime", startDateTime, String.class);
    addCustomField("status", status, String.class);
    addCustomField("tag", tag, String.class);
    addCustomField("uniqueKey", uniqueKey, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
    addCustomField("updatedBy", updatedBy, String.class);
    addCustomField("updatedOn", updatedOn, String.class);
  }
}

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

/** Object name: AttachmentResponseType (AttachmentResponseType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AttachmentResponseType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AttachmentResponseType extends BaseObject {
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
   * Name: fileContentType (fileContentType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("fileContentType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fileContentType;

  /** Name: fileId (fileId), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("fileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fileId;

  /**
   * Name: fileName (fileName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("fileName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fileName;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

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
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("description", description, String.class);
    addCustomField("fileContentType", fileContentType, String.class);
    addCustomField("fileId", fileId, String.class);
    addCustomField("fileName", fileName, String.class);
    addCustomField("id", id, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("updatedBy", updatedBy, String.class);
    addCustomField("updatedOn", updatedOn, String.class);
  }
}

/*
 *  Copyright © 2019 Cask Data, Inc.
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
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;


import javax.annotation.Nullable;

/**
* Object name: UsageDetailResponseType (UsageDetailResponseType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "UsageDetailResponseType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class UsageDetailResponseType extends BaseObject {
  /**
  * Name: createdBy (createdBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdBy;

  /**
  * Name: createdOn (createdOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdOn;

  /**
  * Name: description (description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: error (error), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("error")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String error;

  /**
  * Name: errorCount (errorCount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("errorCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String errorCount;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: importedCount (importedCount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("importedCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String importedCount;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: processEnd (processEnd), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("processEnd")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processEnd;

  /**
  * Name: processStart (processStart), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("processStart")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processStart;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: totalCount (totalCount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalCount;

  /**
  * Name: updatedBy (updatedBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedBy;

  /**
  * Name: updatedOn (updatedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedOn;


  @Override
  public void addFields() {
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("description", description, String.class);
    addCustomField("error", error, String.class);
    addCustomField("errorCount", errorCount, String.class);
    addCustomField("id", id, String.class);
    addCustomField("importedCount", importedCount, String.class);
    addCustomField("name", name, String.class);
    addCustomField("processEnd", processEnd, String.class);
    addCustomField("processStart", processStart, String.class);
    addCustomField("status", status, String.class);
    addCustomField("totalCount", totalCount, String.class);
    addCustomField("updatedBy", updatedBy, String.class);
    addCustomField("updatedOn", updatedOn, String.class);
  }
}

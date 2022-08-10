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
* Object name: MassUpdateType (MassUpdateType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "MassUpdateType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class MassUpdateType extends BaseObject {
  /**
  * Name: actionType (actionType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("actionType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String actionType;

  /**
  * Name: endedOn (endedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endedOn;

  /**
  * Name: errorCount (errorCount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("errorCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String errorCount;

  /**
  * Name: inputSize (inputSize), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("inputSize")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer inputSize;

  /**
  * Name: outputSize (outputSize), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("outputSize")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer outputSize;

  /**
  * Name: outputType (outputType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("outputType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String outputType;

  /**
  * Name: outputURL (outputURL), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("outputURL")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String outputURL;

  /**
  * Name: processedCount (processedCount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("processedCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processedCount;

  /**
  * Name: startedOn (startedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startedOn;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: successCount (successCount), Type: string..
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("successCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String successCount;

  /**
  * Name: totalCount (totalCount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalCount;

  /**
  * Name: uploadedBy (uploadedBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uploadedBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uploadedBy;

  /**
  * Name: uploadedOn (uploadedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uploadedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uploadedOn;


  @Override
  public void addFields() {
    addCustomField("actionType", actionType, String.class);
    addCustomField("endedOn", endedOn, String.class);
    addCustomField("errorCount", errorCount, String.class);
    addCustomField("inputSize", inputSize, Integer.class);
    addCustomField("outputSize", outputSize, Integer.class);
    addCustomField("outputType", outputType, String.class);
    addCustomField("outputURL", outputURL, String.class);
    addCustomField("processedCount", processedCount, String.class);
    addCustomField("startedOn", startedOn, String.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("successCount", successCount, String.class);
    addCustomField("totalCount", totalCount, String.class);
    addCustomField("uploadedBy", uploadedBy, String.class);
    addCustomField("uploadedOn", uploadedOn, String.class);
  }
}

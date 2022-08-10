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
* Object name: CommonUsageImportsErrorResponseErrorItemErrorsItem (CommonUsageImportsErrorResponseErrorItemErrorsItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CommonUsageImportsErrorResponseErrorItemErrorsItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CommonUsageImportsErrorResponseErrorItemErrorsItem extends BaseObject {
  /**
  * Name: message (message), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("message")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String message;

  /**
  * Name: objectName (objectName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("objectName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String objectName;

  /**
  * Name: reason (reason), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reason")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reason;

  /**
  * Name: rejectedValue (rejectedValue), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("rejectedValue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String rejectedValue;


  @Override
  public void addFields() {
    addCustomField("message", message, String.class);
    addCustomField("objectName", objectName, String.class);
    addCustomField("reason", reason, String.class);
    addCustomField("rejectedValue", rejectedValue, String.class);
  }
}

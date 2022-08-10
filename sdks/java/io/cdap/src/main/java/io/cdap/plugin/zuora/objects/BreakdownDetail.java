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
* Object name: BreakdownDetail (BreakdownDetail).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "BreakdownDetail",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class BreakdownDetail extends BaseObject {
  /**
  * Name: amount (amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: endDate (endDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
  * Name: generatedReason (generatedReason), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("generatedReason")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String generatedReason;

  /**
  * Name: orderActionId (orderActionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderActionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderActionId;

  /**
  * Name: orderItemId (orderItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderItemId;

  /**
  * Name: orderNumber (orderNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderNumber;

  /**
  * Name: startDate (startDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;

  /**
  * Name: termNumber (termNumber), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termNumber;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("endDate", endDate, String.class);
    addCustomField("generatedReason", generatedReason, String.class);
    addCustomField("orderActionId", orderActionId, String.class);
    addCustomField("orderItemId", orderItemId, String.class);
    addCustomField("orderNumber", orderNumber, String.class);
    addCustomField("startDate", startDate, String.class);
    addCustomField("termNumber", termNumber, String.class);
  }
}

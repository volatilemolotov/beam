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
* Object name: OrderItem (OrderItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "OrderItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class OrderItem extends BaseObject {
  /**
  * Name: endDate (endDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
  * Name: id (id), Type: string..
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: orderActionId (orderActionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderActionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderActionId;

  /**
  * Name: quantity (quantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: scId (scId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("scId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String scId;

  /**
  * Name: startDate (startDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;


  @Override
  public void addFields() {
    addCustomField("endDate", endDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("orderActionId", orderActionId, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("scId", scId, String.class);
    addCustomField("startDate", startDate, String.class);
  }
}

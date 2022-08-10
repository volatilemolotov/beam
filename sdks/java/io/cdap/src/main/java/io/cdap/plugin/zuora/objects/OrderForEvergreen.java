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

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: OrderForEvergreen (OrderForEvergreen).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "OrderForEvergreen",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class OrderForEvergreen extends BaseObject {
  /**
  * Name: createdBy (createdBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdBy;

  /**
  * Name: createdDate (createdDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: existingAccountNumber (existingAccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("existingAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String existingAccountNumber;

  /**
  * Name: orderDate (orderDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderDate;

  /**
  * Name: orderNumber (orderNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderNumber;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: subscriptions (subscriptions), Type: array|OrderForEvergreenSubscriptionsItem..
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "OrderForEvergreenSubscriptionsItem")
  private List<OrderForEvergreenSubscriptionsItem> subscriptions;

  /**
  * Name: updatedBy (updatedBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedBy;

  /**
  * Name: updatedDate (updatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("existingAccountNumber", existingAccountNumber, String.class);
    addCustomField("orderDate", orderDate, String.class);
    addCustomField("orderNumber", orderNumber, String.class);
    addCustomField("status", status, String.class);
    addCustomField("subscriptions", subscriptions, List.class);
    addCustomField("updatedBy", updatedBy, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

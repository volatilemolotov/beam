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
* Object name: RevenueEventDetailType (RevenueEventDetailType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "RevenueEventDetailType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class RevenueEventDetailType extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: createdOn (createdOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdOn;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: eventType (eventType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("eventType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventType;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: number (number), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
  * Name: recognitionEnd (recognitionEnd), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognitionEnd")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognitionEnd;

  /**
  * Name: recognitionStart (recognitionStart), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognitionStart")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognitionStart;

  /**
  * Name: revenueItems (revenueItems), Type: array|RevenueItemType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "RevenueItemType")
  private List<RevenueItemType> revenueItems;

  /**
  * Name: subscriptionChargeId (subscriptionChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionChargeId;

  /**
  * Name: subscriptionId (subscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("eventType", eventType, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("number", number, String.class);
    addCustomField("recognitionEnd", recognitionEnd, String.class);
    addCustomField("recognitionStart", recognitionStart, String.class);
    addCustomField("revenueItems", revenueItems, List.class);
    addCustomField("subscriptionChargeId", subscriptionChargeId, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("success", success, Boolean.class);
  }
}

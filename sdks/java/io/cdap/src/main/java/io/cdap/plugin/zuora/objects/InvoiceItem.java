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
* Object name: InvoiceItem (InvoiceItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "InvoiceItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class InvoiceItem extends BaseObject {
  /**
  * Name: appliedToItemId (appliedToItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("appliedToItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedToItemId;

  /**
  * Name: availableToCreditAmount (availableToCreditAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("availableToCreditAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String availableToCreditAmount;

  /**
  * Name: balance (balance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /**
  * Name: chargeAmount (chargeAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeAmount;

  /**
  * Name: chargeDescription (chargeDescription), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeDescription;

  /**
  * Name: chargeId (chargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeId;

  /**
  * Name: chargeName (chargeName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeName;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: productName (productName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productName;

  /**
  * Name: quantity (quantity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: serviceEndDate (serviceEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceEndDate;

  /**
  * Name: serviceStartDate (serviceStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceStartDate;

  /**
  * Name: subscriptionId (subscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: subscriptionName (subscriptionName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionName;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: taxAmount (taxAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

  /**
  * Name: taxationItems (taxationItems), Type: InvoiceItemTaxationItemsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxationItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxationItems;

  /**
  * Name: unitOfMeasure (unitOfMeasure), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unitOfMeasure")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unitOfMeasure;


  @Override
  public void addFields() {
    addCustomField("appliedToItemId", appliedToItemId, String.class);
    addCustomField("availableToCreditAmount", availableToCreditAmount, String.class);
    addCustomField("balance", balance, String.class);
    addCustomField("chargeAmount", chargeAmount, String.class);
    addCustomField("chargeDescription", chargeDescription, String.class);
    addCustomField("chargeId", chargeId, String.class);
    addCustomField("chargeName", chargeName, String.class);
    addCustomField("id", id, String.class);
    addCustomField("productName", productName, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("subscriptionName", subscriptionName, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxationItems", taxationItems, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
  }
}

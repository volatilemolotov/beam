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
* Object name: POSTBillingPreviewCreditMemoItem (POSTBillingPreviewCreditMemoItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTBillingPreviewCreditMemoItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTBillingPreviewCreditMemoItem extends BaseObject {
  /**
  * Name: amount (amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: amountWithoutTax (amountWithoutTax), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amountWithoutTax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amountWithoutTax;

  /**
  * Name: appliedToItemId (appliedToItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("appliedToItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedToItemId;

  /**
  * Name: chargeDate (chargeDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeDate;

  /**
  * Name: chargeNumber (chargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: chargeType (chargeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeType;

  /**
  * Name: comment (comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: processingType (processingType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("processingType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processingType;

  /**
  * Name: quantity (quantity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: ratePlanChargeId (ratePlanChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanChargeId;

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
  * Name: sku (sku), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sku")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sku;

  /**
  * Name: skuName (skuName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("skuName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String skuName;

  /**
  * Name: subscriptionId (subscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: subscriptionNumber (subscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

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
    addCustomField("amount", amount, String.class);
    addCustomField("amountWithoutTax", amountWithoutTax, String.class);
    addCustomField("appliedToItemId", appliedToItemId, String.class);
    addCustomField("chargeDate", chargeDate, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("chargeType", chargeType, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("id", id, String.class);
    addCustomField("processingType", processingType, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratePlanChargeId", ratePlanChargeId, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("sku", sku, String.class);
    addCustomField("skuName", skuName, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
  }
}

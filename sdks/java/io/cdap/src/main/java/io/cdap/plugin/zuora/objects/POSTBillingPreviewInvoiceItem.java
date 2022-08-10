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
* Object name: POSTBillingPreviewInvoiceItem (POSTBillingPreviewInvoiceItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTBillingPreviewInvoiceItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTBillingPreviewInvoiceItem extends BaseObject {
  /**
  * Name: appliedToItemId (appliedToItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("appliedToItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedToItemId;

  /**
  * Name: chargeAmount (chargeAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeAmount;

  /**
  * Name: chargeDate (chargeDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeDate;

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
  * Name: subscriptionNumber (subscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: taxAmount (taxAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

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
    addCustomField("chargeAmount", chargeAmount, String.class);
    addCustomField("chargeDate", chargeDate, String.class);
    addCustomField("chargeDescription", chargeDescription, String.class);
    addCustomField("chargeId", chargeId, String.class);
    addCustomField("chargeName", chargeName, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("chargeType", chargeType, String.class);
    addCustomField("id", id, String.class);
    addCustomField("processingType", processingType, String.class);
    addCustomField("productName", productName, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("subscriptionName", subscriptionName, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
  }
}

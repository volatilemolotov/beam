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
* Object name: POSTSubscriptionPreviewResponseType (POSTSubscriptionPreviewResponseType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTSubscriptionPreviewResponseType",
  RequiredArguments = {
    "Request"
  },
  APIUrl = "subscriptions/preview",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class POSTSubscriptionPreviewResponseType extends BaseObject {
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
  * Name: chargeMetrics (chargeMetrics), Type: POSTSubscriptionPreviewResponseTypeChargeMetricsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeMetrics")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeMetrics;

  /**
  * Name: contractedMrr (contractedMrr), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractedMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractedMrr;

  /**
  * Name: creditMemo (creditMemo), Type: POSTSubscriptionPreviewResponseTypeCreditMemoItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditMemo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemo;

  /**
  * Name: invoice (invoice), Type: POSTSubscriptionPreviewResponseTypeInvoiceItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoice;

  /**
  * Name: invoiceItems (invoiceItems), Type: array|POSTSubscriptionPreviewInvoiceItemsType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTSubscriptionPreviewInvoiceItemsType")
  private List<POSTSubscriptionPreviewInvoiceItemsType> invoiceItems;

  /**
  * Name: invoiceTargetDate (invoiceTargetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
  * Name: previewChargeMetricsResponse (previewChargeMetricsResponse), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("previewChargeMetricsResponse")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previewChargeMetricsResponse;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: targetDate (targetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
  * Name: taxAmount (taxAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

  /**
  * Name: totalContractedValue (totalContractedValue), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalContractedValue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalContractedValue;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("amountWithoutTax", amountWithoutTax, String.class);
    addCustomField("chargeMetrics", chargeMetrics, String.class);
    addCustomField("contractedMrr", contractedMrr, String.class);
    addCustomField("creditMemo", creditMemo, String.class);
    addCustomField("invoice", invoice, String.class);
    addCustomField("invoiceItems", invoiceItems, List.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("previewChargeMetricsResponse", previewChargeMetricsResponse, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("totalContractedValue", totalContractedValue, String.class);
  }
}

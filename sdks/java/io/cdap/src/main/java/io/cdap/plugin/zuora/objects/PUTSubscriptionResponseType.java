/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import java.util.List;
import javax.annotation.Nullable;

/** Object name: PUTSubscriptionResponseType (PUTSubscriptionResponseType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTSubscriptionResponseType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTSubscriptionResponseType extends BaseObject {
  /** Name: amount (amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: amountWithoutTax (amountWithoutTax), Type: number. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("amountWithoutTax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amountWithoutTax;

  /**
   * Name: chargeMetrics (chargeMetrics), Type: PUTSubscriptionResponseTypeChargeMetricsItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("chargeMetrics")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeMetrics;

  /**
   * Name: creditMemo (creditMemo), Type: PUTSubscriptionResponseTypeCreditMemoItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditMemo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemo;

  /**
   * Name: creditMemoId (creditMemoId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("creditMemoId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoId;

  /**
   * Name: invoice (invoice), Type: PUTSubscriptionResponseTypeInvoiceItem. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("invoice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoice;

  /**
   * Name: invoiceId (invoiceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
   * Name: invoiceItems (invoiceItems), Type: array|PUTSubscriptionPreviewInvoiceItemsType. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceItems")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PUTSubscriptionPreviewInvoiceItemsType")
  private List<PUTSubscriptionPreviewInvoiceItemsType> invoiceItems;

  /**
   * Name: invoiceTargetDate (invoiceTargetDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
   * Name: paidAmount (paidAmount), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("paidAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paidAmount;

  /**
   * Name: paymentId (paymentId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
   * Name: previewChargeMetricsResponse (previewChargeMetricsResponse), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("previewChargeMetricsResponse")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previewChargeMetricsResponse;

  /**
   * Name: subscriptionId (subscriptionId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
   * Name: targetDate (targetDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
   * Name: taxAmount (taxAmount), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

  /**
   * Name: totalDeltaMrr (totalDeltaMrr), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("totalDeltaMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDeltaMrr;

  /**
   * Name: totalDeltaTcv (totalDeltaTcv), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("totalDeltaTcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDeltaTcv;

  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("amountWithoutTax", amountWithoutTax, String.class);
    addCustomField("chargeMetrics", chargeMetrics, String.class);
    addCustomField("creditMemo", creditMemo, String.class);
    addCustomField("creditMemoId", creditMemoId, String.class);
    addCustomField("invoice", invoice, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("invoiceItems", invoiceItems, List.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("paidAmount", paidAmount, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("previewChargeMetricsResponse", previewChargeMetricsResponse, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("totalDeltaMrr", totalDeltaMrr, String.class);
    addCustomField("totalDeltaTcv", totalDeltaTcv, String.class);
  }
}

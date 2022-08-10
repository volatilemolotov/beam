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
* Object name: SubscribeResult (SubscribeResult).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "SubscribeResult",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class SubscribeResult extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AccountNumber (AccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: ChargeMetricsData (ChargeMetricsData), Type: SubscribeResultChargeMetricsDataItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeMetricsData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeMetricsData;

  /**
  * Name: Errors (Errors), Type: array|ActionsErrorResponse.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("errors")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ActionsErrorResponse")
  private List<ActionsErrorResponse> errors;

  /**
  * Name: GatewayResponse (GatewayResponse), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayResponse")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponse;

  /**
  * Name: GatewayResponseCode (GatewayResponseCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayResponseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponseCode;

  /**
  * Name: InvoiceData (InvoiceData), Type: array|InvoiceData.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceData")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "InvoiceData")
  private List<InvoiceData> invoiceData;

  /**
  * Name: InvoiceId (InvoiceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
  * Name: InvoiceNumber (InvoiceNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceNumber;

  /**
  * Name: InvoiceResult (InvoiceResult), Type: SubscribeResultInvoiceResultItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceResult")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceResult;

  /**
  * Name: PaymentId (PaymentId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
  * Name: PaymentTransactionNumber (PaymentTransactionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentTransactionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentTransactionNumber;

  /**
  * Name: SubscriptionId (SubscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: SubscriptionNumber (SubscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: Success (Success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: TotalMrr (TotalMrr), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalMrr;

  /**
  * Name: TotalTcv (TotalTcv), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalTcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalTcv;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("chargeMetricsData", chargeMetricsData, String.class);
    addCustomField("errors", errors, List.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("invoiceData", invoiceData, List.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("invoiceNumber", invoiceNumber, String.class);
    addCustomField("invoiceResult", invoiceResult, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("paymentTransactionNumber", paymentTransactionNumber, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("totalMrr", totalMrr, String.class);
    addCustomField("totalTcv", totalTcv, String.class);
  }
}

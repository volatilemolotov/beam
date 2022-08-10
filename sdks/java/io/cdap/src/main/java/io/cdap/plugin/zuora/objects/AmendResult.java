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
* Object name: AmendResult (AmendResult).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AmendResult",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AmendResult extends BaseObject {
  /**
  * Name: AmendmentIds (AmendmentIds), Type: array|AmendResultAmendmentIdsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amendmentIds")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AmendResultAmendmentIdsItem")
  private List<AmendResultAmendmentIdsItem> amendmentIds;

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
  * Name: InvoiceDatas (InvoiceDatas), Type: array|InvoiceData.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDatas")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "InvoiceData")
  private List<InvoiceData> invoiceDatas;

  /**
  * Name: InvoiceId (InvoiceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

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
  * Name: Success (Success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: TotalDeltaMrr (TotalDeltaMrr), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalDeltaMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDeltaMrr;

  /**
  * Name: TotalDeltaTcv (TotalDeltaTcv), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalDeltaTcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDeltaTcv;


  @Override
  public void addFields() {
    addCustomField("amendmentIds", amendmentIds, List.class);
    addCustomField("errors", errors, List.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("invoiceDatas", invoiceDatas, List.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("paymentTransactionNumber", paymentTransactionNumber, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("totalDeltaMrr", totalDeltaMrr, String.class);
    addCustomField("totalDeltaTcv", totalDeltaTcv, String.class);
  }
}

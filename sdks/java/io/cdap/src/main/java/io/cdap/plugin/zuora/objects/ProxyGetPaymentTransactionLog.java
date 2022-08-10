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
* Object name: ProxyGetPaymentTransactionLog (ProxyGetPaymentTransactionLog).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetPaymentTransactionLog",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetPaymentTransactionLog extends BaseObject {
  /**
  * Name: AVSResponseCode (AVSResponseCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("aVSResponseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String aVSResponseCode;

  /**
  * Name: BatchId (BatchId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("batchId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batchId;

  /**
  * Name: CVVResponseCode (CVVResponseCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cVVResponseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cVVResponseCode;

  /**
  * Name: Gateway (Gateway), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gateway;

  /**
  * Name: GatewayReasonCode (GatewayReasonCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayReasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayReasonCode;

  /**
  * Name: GatewayReasonCodeDescription (GatewayReasonCodeDescription), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayReasonCodeDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayReasonCodeDescription;

  /**
  * Name: GatewayState (GatewayState), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayState;

  /**
  * Name: GatewayTransactionType (GatewayTransactionType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayTransactionType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayTransactionType;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: PaymentId (PaymentId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
  * Name: RequestString (RequestString), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("requestString")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String requestString;

  /**
  * Name: ResponseString (ResponseString), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("responseString")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String responseString;

  /**
  * Name: TransactionDate (TransactionDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transactionDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transactionDate;

  /**
  * Name: TransactionId (TransactionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transactionId;


  @Override
  public void addFields() {
    addCustomField("aVSResponseCode", aVSResponseCode, String.class);
    addCustomField("batchId", batchId, String.class);
    addCustomField("cVVResponseCode", cVVResponseCode, String.class);
    addCustomField("gateway", gateway, String.class);
    addCustomField("gatewayReasonCode", gatewayReasonCode, String.class);
    addCustomField("gatewayReasonCodeDescription", gatewayReasonCodeDescription, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("gatewayTransactionType", gatewayTransactionType, String.class);
    addCustomField("id", id, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("requestString", requestString, String.class);
    addCustomField("responseString", responseString, String.class);
    addCustomField("transactionDate", transactionDate, String.class);
    addCustomField("transactionId", transactionId, String.class);
  }
}

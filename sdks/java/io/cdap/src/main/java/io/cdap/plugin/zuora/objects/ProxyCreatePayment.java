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
import javax.annotation.Nullable;

/** Object name: ProxyCreatePayment (ProxyCreatePayment). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyCreatePayment",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyCreatePayment extends BaseObject {
  /**
   * Name: AccountId (AccountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: AccountingCode (AccountingCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /** Name: Amount (Amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: AppliedCreditBalanceAmount (AppliedCreditBalanceAmount), Type: number. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("appliedCreditBalanceAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedCreditBalanceAmount;

  /**
   * Name: AppliedInvoiceAmount (AppliedInvoiceAmount), Type: number. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("appliedInvoiceAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedInvoiceAmount;

  /**
   * Name: AuthTransactionId (AuthTransactionId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("authTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String authTransactionId;

  /**
   * Name: Comment (Comment), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
   * Name: EffectiveDate (EffectiveDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
   * Name: Gateway (Gateway), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("gateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gateway;

  /**
   * Name: GatewayOptionData (GatewayOptionData), Type: ProxyCreatePaymentGatewayOptionDataItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("gatewayOptionData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOptionData;

  /**
   * Name: GatewayOrderId (GatewayOrderId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("gatewayOrderId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOrderId;

  /**
   * Name: GatewayResponse (GatewayResponse), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("gatewayResponse")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponse;

  /**
   * Name: GatewayResponseCode (GatewayResponseCode), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("gatewayResponseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponseCode;

  /**
   * Name: GatewayState (GatewayState), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("gatewayState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayState;

  /**
   * Name: InvoiceId (InvoiceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
   * Name: InvoiceNumber (InvoiceNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceNumber;

  /**
   * Name: InvoicePaymentData (InvoicePaymentData), Type: ProxyCreatePaymentInvoicePaymentDataItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoicePaymentData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoicePaymentData;

  /**
   * Name: PaymentMethodId (PaymentMethodId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
   * Name: PaymentNumber (PaymentNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentNumber;

  /**
   * Name: ReferenceId (ReferenceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
   * Name: SoftDescriptor (SoftDescriptor), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("softDescriptor")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptor;

  /**
   * Name: SoftDescriptorPhone (SoftDescriptorPhone), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("softDescriptorPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptorPhone;

  /** Name: Status (Status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /** Name: Type (Type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("appliedCreditBalanceAmount", appliedCreditBalanceAmount, String.class);
    addCustomField("appliedInvoiceAmount", appliedInvoiceAmount, String.class);
    addCustomField("authTransactionId", authTransactionId, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("gateway", gateway, String.class);
    addCustomField("gatewayOptionData", gatewayOptionData, String.class);
    addCustomField("gatewayOrderId", gatewayOrderId, String.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("invoiceNumber", invoiceNumber, String.class);
    addCustomField("invoicePaymentData", invoicePaymentData, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("paymentNumber", paymentNumber, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("softDescriptor", softDescriptor, String.class);
    addCustomField("softDescriptorPhone", softDescriptorPhone, String.class);
    addCustomField("status", status, String.class);
    addCustomField("type", type, String.class);
  }
}

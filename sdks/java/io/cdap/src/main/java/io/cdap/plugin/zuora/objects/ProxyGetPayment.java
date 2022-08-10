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
* Object name: ProxyGetPayment (ProxyGetPayment).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetPayment",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetPayment extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AccountingCode (AccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /**
  * Name: Amount (Amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: AppliedCreditBalanceAmount (AppliedCreditBalanceAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("appliedCreditBalanceAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedCreditBalanceAmount;

  /**
  * Name: AuthTransactionId (AuthTransactionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("authTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String authTransactionId;

  /**
  * Name: BankIdentificationNumber (BankIdentificationNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankIdentificationNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankIdentificationNumber;

  /**
  * Name: CancelledOn (CancelledOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledOn;

  /**
  * Name: Comment (Comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: EffectiveDate (EffectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
  * Name: Gateway (Gateway), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gateway;

  /**
  * Name: GatewayOrderId (GatewayOrderId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayOrderId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOrderId;

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
  * Name: GatewayState (GatewayState), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayState;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: MarkedForSubmissionOn (MarkedForSubmissionOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("markedForSubmissionOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String markedForSubmissionOn;

  /**
  * Name: PaymentMethodId (PaymentMethodId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
  * Name: PaymentMethodSnapshotId (PaymentMethodSnapshotId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodSnapshotId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodSnapshotId;

  /**
  * Name: PaymentNumber (PaymentNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentNumber;

  /**
  * Name: ReferenceId (ReferenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
  * Name: RefundAmount (RefundAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("refundAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundAmount;

  /**
  * Name: SecondPaymentReferenceId (SecondPaymentReferenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("secondPaymentReferenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondPaymentReferenceId;

  /**
  * Name: SettledOn (SettledOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("settledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String settledOn;

  /**
  * Name: SoftDescriptor (SoftDescriptor), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("softDescriptor")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptor;

  /**
  * Name: SoftDescriptorPhone (SoftDescriptorPhone), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("softDescriptorPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptorPhone;

  /**
  * Name: Source (Source), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("source")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String source;

  /**
  * Name: SourceName (SourceName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceName;

  /**
  * Name: Status (Status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: SubmittedOn (SubmittedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("submittedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submittedOn;

  /**
  * Name: TransferredToAccounting (TransferredToAccounting), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

  /**
  * Name: Type (Type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("appliedCreditBalanceAmount", appliedCreditBalanceAmount, String.class);
    addCustomField("authTransactionId", authTransactionId, String.class);
    addCustomField("bankIdentificationNumber", bankIdentificationNumber, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("gateway", gateway, String.class);
    addCustomField("gatewayOrderId", gatewayOrderId, String.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("id", id, String.class);
    addCustomField("markedForSubmissionOn", markedForSubmissionOn, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("paymentMethodSnapshotId", paymentMethodSnapshotId, String.class);
    addCustomField("paymentNumber", paymentNumber, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("refundAmount", refundAmount, String.class);
    addCustomField("secondPaymentReferenceId", secondPaymentReferenceId, String.class);
    addCustomField("settledOn", settledOn, String.class);
    addCustomField("softDescriptor", softDescriptor, String.class);
    addCustomField("softDescriptorPhone", softDescriptorPhone, String.class);
    addCustomField("source", source, String.class);
    addCustomField("sourceName", sourceName, String.class);
    addCustomField("status", status, String.class);
    addCustomField("submittedOn", submittedOn, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

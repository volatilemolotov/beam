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

/** Object name: ProxyGetRefund (ProxyGetRefund). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyGetRefund",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyGetRefund extends BaseObject {
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
   * Name: CancelledOn (CancelledOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("cancelledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledOn;

  /**
   * Name: Comment (Comment), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
   * Name: CreatedById (CreatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
   * Name: CreatedDate (CreatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
   * Name: Gateway (Gateway), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("gateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gateway;

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

  /** Name: Id (Id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: MarkedForSubmissionOn (MarkedForSubmissionOn), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("markedForSubmissionOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String markedForSubmissionOn;

  /**
   * Name: MethodType (MethodType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("methodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String methodType;

  /**
   * Name: PaymentMethodId (PaymentMethodId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
   * Name: PaymentMethodSnapshotId (PaymentMethodSnapshotId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("paymentMethodSnapshotId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodSnapshotId;

  /**
   * Name: ReasonCode (ReasonCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
   * Name: ReferenceID (ReferenceID), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceID;

  /**
   * Name: RefundDate (RefundDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("refundDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundDate;

  /**
   * Name: RefundNumber (RefundNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("refundNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundNumber;

  /**
   * Name: RefundTransactionTime (RefundTransactionTime), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("refundTransactionTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundTransactionTime;

  /**
   * Name: SecondRefundReferenceId (SecondRefundReferenceId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("secondRefundReferenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondRefundReferenceId;

  /**
   * Name: SettledOn (SettledOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("settledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String settledOn;

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

  /**
   * Name: SourceType (SourceType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("sourceType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceType;

  /** Name: Status (Status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: SubmittedOn (SubmittedOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("submittedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submittedOn;

  /**
   * Name: TransferredToAccounting (TransferredToAccounting), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

  /** Name: Type (Type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
   * Name: UpdatedById (UpdatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
   * Name: UpdatedDate (UpdatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("gateway", gateway, String.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("id", id, String.class);
    addCustomField("markedForSubmissionOn", markedForSubmissionOn, String.class);
    addCustomField("methodType", methodType, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("paymentMethodSnapshotId", paymentMethodSnapshotId, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referenceID", referenceID, String.class);
    addCustomField("refundDate", refundDate, String.class);
    addCustomField("refundNumber", refundNumber, String.class);
    addCustomField("refundTransactionTime", refundTransactionTime, String.class);
    addCustomField("secondRefundReferenceId", secondRefundReferenceId, String.class);
    addCustomField("settledOn", settledOn, String.class);
    addCustomField("softDescriptor", softDescriptor, String.class);
    addCustomField("softDescriptorPhone", softDescriptorPhone, String.class);
    addCustomField("sourceType", sourceType, String.class);
    addCustomField("status", status, String.class);
    addCustomField("submittedOn", submittedOn, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

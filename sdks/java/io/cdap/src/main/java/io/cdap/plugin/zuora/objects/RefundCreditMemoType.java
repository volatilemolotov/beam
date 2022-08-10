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
* Object name: RefundCreditMemoType (RefundCreditMemoType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "RefundCreditMemo",
  RequiredPostArguments = {
    "body", "creditmemoId"
  },
  APIUrl = "creditmemos/{creditmemoId}/refunds",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class RefundCreditMemoType extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: amount (amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: cancelledOn (cancelledOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledOn;

  /**
  * Name: comment (comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: createdById (createdById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: createdDate (createdDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: creditMemoId (creditMemoId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditMemoId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoId;

  /**
  * Name: financeInformation (financeInformation), Type: RefundCreditMemoTypeFinanceInformationItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /**
  * Name: gatewayId (gatewayId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayId;

  /**
  * Name: gatewayResponse (gatewayResponse), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayResponse")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponse;

  /**
  * Name: gatewayResponseCode (gatewayResponseCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayResponseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponseCode;

  /**
  * Name: gatewayState (gatewayState), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayState;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: markedForSubmissionOn (markedForSubmissionOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("markedForSubmissionOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String markedForSubmissionOn;

  /**
  * Name: methodType (methodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("methodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String methodType;

  /**
  * Name: number (number), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
  * Name: paymentId (paymentId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
  * Name: paymentMethodId (paymentMethodId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
  * Name: paymentMethodSnapshotId (paymentMethodSnapshotId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodSnapshotId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodSnapshotId;

  /**
  * Name: reasonCode (reasonCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
  * Name: referenceId (referenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
  * Name: refundDate (refundDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("refundDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundDate;

  /**
  * Name: refundTransactionTime (refundTransactionTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("refundTransactionTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundTransactionTime;

  /**
  * Name: secondRefundReferenceId (secondRefundReferenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("secondRefundReferenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondRefundReferenceId;

  /**
  * Name: settledOn (settledOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("settledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String settledOn;

  /**
  * Name: softDescriptor (softDescriptor), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("softDescriptor")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptor;

  /**
  * Name: softDescriptorPhone (softDescriptorPhone), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("softDescriptorPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptorPhone;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: submittedOn (submittedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("submittedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submittedOn;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
  * Name: updatedById (updatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: updatedDate (updatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditMemoId", creditMemoId, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("gatewayId", gatewayId, String.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("id", id, String.class);
    addCustomField("markedForSubmissionOn", markedForSubmissionOn, String.class);
    addCustomField("methodType", methodType, String.class);
    addCustomField("number", number, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("paymentMethodSnapshotId", paymentMethodSnapshotId, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("refundDate", refundDate, String.class);
    addCustomField("refundTransactionTime", refundTransactionTime, String.class);
    addCustomField("secondRefundReferenceId", secondRefundReferenceId, String.class);
    addCustomField("settledOn", settledOn, String.class);
    addCustomField("softDescriptor", softDescriptor, String.class);
    addCustomField("softDescriptorPhone", softDescriptorPhone, String.class);
    addCustomField("status", status, String.class);
    addCustomField("submittedOn", submittedOn, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

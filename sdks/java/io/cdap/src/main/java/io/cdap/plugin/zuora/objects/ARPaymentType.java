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
* Object name: ARPaymentType (ARPaymentType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "Payments",
  RequiredPostArguments = {
    "body"
  },
  APIUrl = "payments",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class ARPaymentType extends BaseObject {
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
  * Name: appliedAmount (appliedAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("appliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedAmount;

  /**
  * Name: authTransactionId (authTransactionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("authTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String authTransactionId;

  /**
  * Name: bankIdentificationNumber (bankIdentificationNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankIdentificationNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankIdentificationNumber;

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
  * Name: creditBalanceAmount (creditBalanceAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditBalanceAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditBalanceAmount;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: effectiveDate (effectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
  * Name: financeInformation (financeInformation), Type: ARPaymentTypeFinanceInformationItem.
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
  * Name: gatewayOrderId (gatewayOrderId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayOrderId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOrderId;

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
  * Name: number (number), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

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
  * Name: referenceId (referenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
  * Name: refundAmount (refundAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("refundAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundAmount;

  /**
  * Name: secondPaymentReferenceId (secondPaymentReferenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("secondPaymentReferenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondPaymentReferenceId;

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
  * Name: unappliedAmount (unappliedAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unappliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedAmount;

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
    addCustomField("appliedAmount", appliedAmount, String.class);
    addCustomField("authTransactionId", authTransactionId, String.class);
    addCustomField("bankIdentificationNumber", bankIdentificationNumber, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditBalanceAmount", creditBalanceAmount, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("gatewayId", gatewayId, String.class);
    addCustomField("gatewayOrderId", gatewayOrderId, String.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("id", id, String.class);
    addCustomField("markedForSubmissionOn", markedForSubmissionOn, String.class);
    addCustomField("number", number, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("paymentMethodSnapshotId", paymentMethodSnapshotId, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("refundAmount", refundAmount, String.class);
    addCustomField("secondPaymentReferenceId", secondPaymentReferenceId, String.class);
    addCustomField("settledOn", settledOn, String.class);
    addCustomField("softDescriptor", softDescriptor, String.class);
    addCustomField("softDescriptorPhone", softDescriptorPhone, String.class);
    addCustomField("status", status, String.class);
    addCustomField("submittedOn", submittedOn, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("type", type, String.class);
    addCustomField("unappliedAmount", unappliedAmount, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

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

/** Object name: CreditMemoType (CreditMemoType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CreditMemo",
    RequiredPostArguments = {"body", "invoiceId"},
    APIUrl = "invoices/{invoiceId}/creditmemos",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class CreditMemoType extends BaseObject {
  /**
   * Name: accountId (accountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /** Name: amount (amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: appliedAmount (appliedAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("appliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedAmount;

  /**
   * Name: autoApplyUponPosting (autoApplyUponPosting), Type: boolean. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("autoApplyUponPosting")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoApplyUponPosting;

  /**
   * Name: cancelledById (cancelledById), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("cancelledById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledById;

  /**
   * Name: cancelledOn (cancelledOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("cancelledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledOn;

  /**
   * Name: comment (comment), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
   * Name: createdById (createdById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
   * Name: createdDate (createdDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
   * Name: creditMemoDate (creditMemoDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("creditMemoDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoDate;

  /**
   * Name: currency (currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: excludeFromAutoApplyRules (excludeFromAutoApplyRules), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("excludeFromAutoApplyRules")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean excludeFromAutoApplyRules;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: latestPDFFileId (latestPDFFileId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("latestPDFFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String latestPDFFileId;

  /** Name: number (number), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
   * Name: postedById (postedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("postedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postedById;

  /**
   * Name: postedOn (postedOn), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("postedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postedOn;

  /**
   * Name: reasonCode (reasonCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
   * Name: referredInvoiceId (referredInvoiceId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("referredInvoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referredInvoiceId;

  /**
   * Name: refundAmount (refundAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("refundAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundAmount;

  /** Name: source (source), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("source")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String source;

  /**
   * Name: sourceId (sourceId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("sourceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceId;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

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
   * Name: taxMessage (taxMessage), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxMessage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxMessage;

  /**
   * Name: taxStatus (taxStatus), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxStatus;

  /**
   * Name: totalTaxExemptAmount (totalTaxExemptAmount), Type: number. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("totalTaxExemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalTaxExemptAmount;

  /**
   * Name: transferredToAccounting (transferredToAccounting), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

  /**
   * Name: unappliedAmount (unappliedAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("unappliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedAmount;

  /**
   * Name: updatedById (updatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
   * Name: updatedDate (updatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("appliedAmount", appliedAmount, String.class);
    addCustomField("autoApplyUponPosting", autoApplyUponPosting, Boolean.class);
    addCustomField("cancelledById", cancelledById, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditMemoDate", creditMemoDate, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("excludeFromAutoApplyRules", excludeFromAutoApplyRules, Boolean.class);
    addCustomField("id", id, String.class);
    addCustomField("latestPDFFileId", latestPDFFileId, String.class);
    addCustomField("number", number, String.class);
    addCustomField("postedById", postedById, String.class);
    addCustomField("postedOn", postedOn, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referredInvoiceId", referredInvoiceId, String.class);
    addCustomField("refundAmount", refundAmount, String.class);
    addCustomField("source", source, String.class);
    addCustomField("sourceId", sourceId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxMessage", taxMessage, String.class);
    addCustomField("taxStatus", taxStatus, String.class);
    addCustomField("totalTaxExemptAmount", totalTaxExemptAmount, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("unappliedAmount", unappliedAmount, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

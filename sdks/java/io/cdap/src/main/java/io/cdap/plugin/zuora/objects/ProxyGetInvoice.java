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

/** Object name: ProxyGetInvoice (ProxyGetInvoice). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyGetInvoice",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyGetInvoice extends BaseObject {
  /**
   * Name: AccountId (AccountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: AdjustmentAmount (AdjustmentAmount), Type: number. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("adjustmentAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentAmount;

  /** Name: Amount (Amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: AmountWithoutTax (AmountWithoutTax), Type: number. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("amountWithoutTax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amountWithoutTax;

  /**
   * Name: Balance (Balance), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /** Name: Body (Body), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("body")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String body;

  /**
   * Name: Comments (Comments), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comments")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comments;

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
   * Name: CreditBalanceAdjustmentAmount (CreditBalanceAdjustmentAmount), Type: number. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditBalanceAdjustmentAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditBalanceAdjustmentAmount;

  /**
   * Name: DueDate (DueDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("dueDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dueDate;

  /** Name: Id (Id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: IncludesOneTime (IncludesOneTime), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("includesOneTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includesOneTime;

  /**
   * Name: IncludesRecurring (IncludesRecurring), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("includesRecurring")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includesRecurring;

  /**
   * Name: IncludesUsage (IncludesUsage), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("includesUsage")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includesUsage;

  /**
   * Name: InvoiceDate (InvoiceDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("invoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceDate;

  /**
   * Name: InvoiceNumber (InvoiceNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceNumber;

  /**
   * Name: LastEmailSentDate (LastEmailSentDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("lastEmailSentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastEmailSentDate;

  /**
   * Name: PaymentAmount (PaymentAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentAmount;

  /**
   * Name: PostedBy (PostedBy), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("postedBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postedBy;

  /**
   * Name: PostedDate (PostedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("postedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postedDate;

  /**
   * Name: RefundAmount (RefundAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("refundAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundAmount;

  /** Name: Status (Status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: TargetDate (TargetDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
   * Name: TaxAmount (TaxAmount), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

  /**
   * Name: TaxExemptAmount (TaxExemptAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("taxExemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptAmount;

  /**
   * Name: TransferredToAccounting (TransferredToAccounting), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

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
    addCustomField("adjustmentAmount", adjustmentAmount, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("amountWithoutTax", amountWithoutTax, String.class);
    addCustomField("balance", balance, String.class);
    addCustomField("body", body, String.class);
    addCustomField("comments", comments, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditBalanceAdjustmentAmount", creditBalanceAdjustmentAmount, String.class);
    addCustomField("dueDate", dueDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("includesOneTime", includesOneTime, Boolean.class);
    addCustomField("includesRecurring", includesRecurring, Boolean.class);
    addCustomField("includesUsage", includesUsage, Boolean.class);
    addCustomField("invoiceDate", invoiceDate, String.class);
    addCustomField("invoiceNumber", invoiceNumber, String.class);
    addCustomField("lastEmailSentDate", lastEmailSentDate, String.class);
    addCustomField("paymentAmount", paymentAmount, String.class);
    addCustomField("postedBy", postedBy, String.class);
    addCustomField("postedDate", postedDate, String.class);
    addCustomField("refundAmount", refundAmount, String.class);
    addCustomField("status", status, String.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxExemptAmount", taxExemptAmount, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

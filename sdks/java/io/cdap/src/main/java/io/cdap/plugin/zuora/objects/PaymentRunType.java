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

/** Object name: PaymentRunType (PaymentRunType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PaymentRun",
    RequiredPostArguments = {"body"},
    APIUrl = "payment-runs",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class PaymentRunType extends BaseObject {
  /**
   * Name: accountId (accountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: applyCreditBalance (applyCreditBalance), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("applyCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean applyCreditBalance;

  /**
   * Name: autoApplyCreditMemo (autoApplyCreditMemo), Type: boolean. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("autoApplyCreditMemo")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoApplyCreditMemo;

  /**
   * Name: autoApplyUnappliedPayment (autoApplyUnappliedPayment), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("autoApplyUnappliedPayment")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoApplyUnappliedPayment;

  /** Name: batch (batch), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
   * Name: billCycleDay (billCycleDay), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleDay;

  /**
   * Name: billingRunId (billingRunId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billingRunId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingRunId;

  /**
   * Name: collectPayment (collectPayment), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("collectPayment")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean collectPayment;

  /**
   * Name: completedOn (completedOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("completedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String completedOn;

  /**
   * Name: consolidatedPayment (consolidatedPayment), Type: boolean. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("consolidatedPayment")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean consolidatedPayment;

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
   * Name: currency (currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: executedOn (executedOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("executedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String executedOn;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /** Name: number (number), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
   * Name: paymentGatewayId (paymentGatewayId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("paymentGatewayId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentGatewayId;

  /**
   * Name: processPaymentWithClosedPM (processPaymentWithClosedPM), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("processPaymentWithClosedPM")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean processPaymentWithClosedPM;

  /**
   * Name: runDate (runDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("runDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runDate;

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
    addCustomField("applyCreditBalance", applyCreditBalance, Boolean.class);
    addCustomField("autoApplyCreditMemo", autoApplyCreditMemo, Boolean.class);
    addCustomField("autoApplyUnappliedPayment", autoApplyUnappliedPayment, Boolean.class);
    addCustomField("batch", batch, String.class);
    addCustomField("billCycleDay", billCycleDay, String.class);
    addCustomField("billingRunId", billingRunId, String.class);
    addCustomField("collectPayment", collectPayment, Boolean.class);
    addCustomField("completedOn", completedOn, String.class);
    addCustomField("consolidatedPayment", consolidatedPayment, Boolean.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("executedOn", executedOn, String.class);
    addCustomField("id", id, String.class);
    addCustomField("number", number, String.class);
    addCustomField("paymentGatewayId", paymentGatewayId, String.class);
    addCustomField("processPaymentWithClosedPM", processPaymentWithClosedPM, Boolean.class);
    addCustomField("runDate", runDate, String.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

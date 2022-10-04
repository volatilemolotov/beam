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
import java.util.List;
import javax.annotation.Nullable;

/** Object name: CreatePaymentType (CreatePaymentType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CreatePaymentType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class CreatePaymentType extends BaseObject {
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
   * Name: comment (comment), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
   * Name: currency (currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: debitMemos (debitMemos), Type: array|PaymentDebitMemoApplicationCreateRequestType.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("debitMemos")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PaymentDebitMemoApplicationCreateRequestType")
  private List<PaymentDebitMemoApplicationCreateRequestType> debitMemos;

  /**
   * Name: effectiveDate (effectiveDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
   * Name: financeInformation (financeInformation), Type: CreatePaymentTypeFinanceInformationItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /**
   * Name: gatewayId (gatewayId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("gatewayId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayId;

  /**
   * Name: invoices (invoices), Type: array|PaymentInvoiceApplicationCreateRequestType. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoices")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PaymentInvoiceApplicationCreateRequestType")
  private List<PaymentInvoiceApplicationCreateRequestType> invoices;

  /**
   * Name: paymentMethodId (paymentMethodId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
   * Name: referenceId (referenceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("debitMemos", debitMemos, List.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("gatewayId", gatewayId, String.class);
    addCustomField("invoices", invoices, List.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("type", type, String.class);
  }
}

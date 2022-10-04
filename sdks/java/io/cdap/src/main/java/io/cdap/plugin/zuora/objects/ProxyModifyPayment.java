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

/** Object name: ProxyModifyPayment (ProxyModifyPayment). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyModifyPayment",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyModifyPayment extends BaseObject {
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
   * Name: PaymentMethodId (PaymentMethodId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
   * Name: ReferenceId (ReferenceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /** Name: Status (Status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

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

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("type", type, String.class);
  }
}

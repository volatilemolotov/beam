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

/** Object name: InvoiceType (InvoiceType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "InvoiceType", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class InvoiceType extends BaseObject {
  /**
   * Name: accountId (accountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: accountName (accountName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountName;

  /**
   * Name: accountNumber (accountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /** Name: amount (amount), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: balance (balance), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /** Name: body (body), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("body")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String body;

  /**
   * Name: createdBy (createdBy), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdBy;

  /**
   * Name: creditBalanceAdjustmentAmount (creditBalanceAdjustmentAmount), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditBalanceAdjustmentAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditBalanceAdjustmentAmount;

  /**
   * Name: dueDate (dueDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("dueDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dueDate;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: invoiceDate (invoiceDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("invoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceDate;

  /**
   * Name: invoiceFiles (invoiceFiles), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceFiles")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceFiles;

  /**
   * Name: invoiceItems (invoiceItems), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceItems;

  /**
   * Name: invoiceNumber (invoiceNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceNumber;

  /**
   * Name: invoiceTargetDate (invoiceTargetDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
   * Name: reversed (reversed), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("reversed")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean reversed;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountName", accountName, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("balance", balance, String.class);
    addCustomField("body", body, String.class);
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("creditBalanceAdjustmentAmount", creditBalanceAdjustmentAmount, String.class);
    addCustomField("dueDate", dueDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceDate", invoiceDate, String.class);
    addCustomField("invoiceFiles", invoiceFiles, String.class);
    addCustomField("invoiceItems", invoiceItems, String.class);
    addCustomField("invoiceNumber", invoiceNumber, String.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("reversed", reversed, Boolean.class);
    addCustomField("status", status, String.class);
  }
}

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

/**
 * Object name: ProxyGetCreditBalanceAdjustment (ProxyGetCreditBalanceAdjustment). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyGetCreditBalanceAdjustment",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyGetCreditBalanceAdjustment extends BaseObject {
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

  /**
   * Name: AdjustmentDate (AdjustmentDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("adjustmentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentDate;

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

  /** Name: Id (Id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /** Name: Number (Number), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
   * Name: ReasonCode (ReasonCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
   * Name: ReferenceId (ReferenceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
   * Name: SourceTransactionId (SourceTransactionId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("sourceTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceTransactionId;

  /**
   * Name: SourceTransactionNumber (SourceTransactionNumber), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("sourceTransactionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceTransactionNumber;

  /**
   * Name: SourceTransactionType (SourceTransactionType), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("sourceTransactionType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceTransactionType;

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
    addCustomField("adjustmentDate", adjustmentDate, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("number", number, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("sourceTransactionId", sourceTransactionId, String.class);
    addCustomField("sourceTransactionNumber", sourceTransactionNumber, String.class);
    addCustomField("sourceTransactionType", sourceTransactionType, String.class);
    addCustomField("status", status, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

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

/** Object name: CreditMemoItemPartType (CreditMemoItemPartType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CreditMemoItemPartType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class CreditMemoItemPartType extends BaseObject {
  /** Name: amount (amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

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
   * Name: creditMemoItemId (creditMemoItemId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("creditMemoItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoItemId;

  /**
   * Name: creditTaxItemId (creditTaxItemId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("creditTaxItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditTaxItemId;

  /**
   * Name: debitMemoItemId (debitMemoItemId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("debitMemoItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String debitMemoItemId;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: invoiceItemId (invoiceItemId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceItemId;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
   * Name: taxItemId (taxItemId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxItemId;

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
    addCustomField("amount", amount, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditMemoItemId", creditMemoItemId, String.class);
    addCustomField("creditTaxItemId", creditTaxItemId, String.class);
    addCustomField("debitMemoItemId", debitMemoItemId, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceItemId", invoiceItemId, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("taxItemId", taxItemId, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

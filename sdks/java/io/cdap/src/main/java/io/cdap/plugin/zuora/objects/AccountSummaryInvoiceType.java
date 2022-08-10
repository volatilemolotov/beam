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
* Object name: AccountSummaryInvoiceType (AccountSummaryInvoiceType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountSummaryInvoiceType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountSummaryInvoiceType extends BaseObject {
  /**
  * Name: amount (amount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: balance (balance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /**
  * Name: dueDate (dueDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("dueDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dueDate;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: invoiceDate (invoiceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceDate;

  /**
  * Name: invoiceNumber (invoiceNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceNumber;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("balance", balance, String.class);
    addCustomField("dueDate", dueDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceDate", invoiceDate, String.class);
    addCustomField("invoiceNumber", invoiceNumber, String.class);
    addCustomField("status", status, String.class);
  }
}

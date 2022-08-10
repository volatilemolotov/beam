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
* Object name: AccountTypeMetricsItem (AccountTypeMetricsItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountTypeMetricsItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountTypeMetricsItem extends BaseObject {
  /**
  * Name: balance (balance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /**
  * Name: contractedMrr (contractedMrr), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractedMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractedMrr;

  /**
  * Name: creditBalance (creditBalance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditBalance;

  /**
  * Name: totalDebitMemoBalance (totalDebitMemoBalance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalDebitMemoBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDebitMemoBalance;

  /**
  * Name: totalInvoiceBalance (totalInvoiceBalance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalInvoiceBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalInvoiceBalance;

  /**
  * Name: unappliedCreditMemoAmount (unappliedCreditMemoAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unappliedCreditMemoAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedCreditMemoAmount;

  /**
  * Name: unappliedPaymentAmount (unappliedPaymentAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unappliedPaymentAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedPaymentAmount;


  @Override
  public void addFields() {
    addCustomField("balance", balance, String.class);
    addCustomField("contractedMrr", contractedMrr, String.class);
    addCustomField("creditBalance", creditBalance, String.class);
    addCustomField("totalDebitMemoBalance", totalDebitMemoBalance, String.class);
    addCustomField("totalInvoiceBalance", totalInvoiceBalance, String.class);
    addCustomField("unappliedCreditMemoAmount", unappliedCreditMemoAmount, String.class);
    addCustomField("unappliedPaymentAmount", unappliedPaymentAmount, String.class);
  }
}

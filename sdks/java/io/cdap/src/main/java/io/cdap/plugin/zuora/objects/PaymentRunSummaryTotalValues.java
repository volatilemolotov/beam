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
* Object name: PaymentRunSummaryTotalValues (PaymentRunSummaryTotalValues).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PaymentRunSummaryTotalValues",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PaymentRunSummaryTotalValues extends BaseObject {
  /**
  * Name: totalValueOfCreditBalance (totalValueOfCreditBalance), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfCreditBalance;

  /**
  * Name: totalValueOfCreditMemos (totalValueOfCreditMemos), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfCreditMemos")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfCreditMemos;

  /**
  * Name: totalValueOfDebitMemos (totalValueOfDebitMemos), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfDebitMemos")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfDebitMemos;

  /**
  * Name: totalValueOfErrors (totalValueOfErrors), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfErrors")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfErrors;

  /**
  * Name: totalValueOfInvoices (totalValueOfInvoices), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfInvoices;

  /**
  * Name: totalValueOfPayments (totalValueOfPayments), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfPayments;

  /**
  * Name: totalValueOfReceivables (totalValueOfReceivables), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfReceivables")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfReceivables;

  /**
  * Name: totalValueOfUnappliedPayments (totalValueOfUnappliedPayments), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfUnappliedPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer totalValueOfUnappliedPayments;

  /**
  * Name: totalValueOfUnprocessedDebitMemos (totalValueOfUnprocessedDebitMemos), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfUnprocessedDebitMemos")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfUnprocessedDebitMemos;

  /**
  * Name: totalValueOfUnprocessedInvoices (totalValueOfUnprocessedInvoices), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfUnprocessedInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfUnprocessedInvoices;

  /**
  * Name: totalValueOfUnprocessedReceivables (totalValueOfUnprocessedReceivables), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalValueOfUnprocessedReceivables")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalValueOfUnprocessedReceivables;


  @Override
  public void addFields() {
    addCustomField("totalValueOfCreditBalance", totalValueOfCreditBalance, String.class);
    addCustomField("totalValueOfCreditMemos", totalValueOfCreditMemos, String.class);
    addCustomField("totalValueOfDebitMemos", totalValueOfDebitMemos, String.class);
    addCustomField("totalValueOfErrors", totalValueOfErrors, String.class);
    addCustomField("totalValueOfInvoices", totalValueOfInvoices, String.class);
    addCustomField("totalValueOfPayments", totalValueOfPayments, String.class);
    addCustomField("totalValueOfReceivables", totalValueOfReceivables, String.class);
    addCustomField("totalValueOfUnappliedPayments", totalValueOfUnappliedPayments, Integer.class);
    addCustomField("totalValueOfUnprocessedDebitMemos", totalValueOfUnprocessedDebitMemos, String.class);
    addCustomField("totalValueOfUnprocessedInvoices", totalValueOfUnprocessedInvoices, String.class);
    addCustomField("totalValueOfUnprocessedReceivables", totalValueOfUnprocessedReceivables, String.class);
  }
}

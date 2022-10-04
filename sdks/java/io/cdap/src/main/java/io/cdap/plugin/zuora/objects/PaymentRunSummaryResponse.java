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

/** Object name: PaymentRunSummaryResponse (PaymentRunSummaryResponse). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PaymentRunSummaryResponse",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PaymentRunSummaryResponse extends BaseObject {
  /**
   * Name: numberOfCreditBalanceAdjustments (numberOfCreditBalanceAdjustments), Type: integer.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfCreditBalanceAdjustments")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfCreditBalanceAdjustments;

  /**
   * Name: numberOfCreditMemos (numberOfCreditMemos), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfCreditMemos")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfCreditMemos;

  /**
   * Name: numberOfDebitMemos (numberOfDebitMemos), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("numberOfDebitMemos")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfDebitMemos;

  /**
   * Name: numberOfErrors (numberOfErrors), Type: integer. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("numberOfErrors")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfErrors;

  /**
   * Name: numberOfInvoices (numberOfInvoices), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("numberOfInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfInvoices;

  /**
   * Name: numberOfPayments (numberOfPayments), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("numberOfPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPayments;

  /**
   * Name: numberOfReceivables (numberOfReceivables), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfReceivables")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfReceivables;

  /**
   * Name: numberOfUnappliedPayments (numberOfUnappliedPayments), Type: integer. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfUnappliedPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfUnappliedPayments;

  /**
   * Name: numberOfUnprocessedDebitMemos (numberOfUnprocessedDebitMemos), Type: integer. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfUnprocessedDebitMemos")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfUnprocessedDebitMemos;

  /**
   * Name: numberOfUnprocessedInvoices (numberOfUnprocessedInvoices), Type: integer. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfUnprocessedInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfUnprocessedInvoices;

  /**
   * Name: numberOfUnprocessedReceivables (numberOfUnprocessedReceivables), Type: integer. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("numberOfUnprocessedReceivables")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfUnprocessedReceivables;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
   * Name: totalValues (totalValues), Type: array|PaymentRunSummaryTotalValues. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("totalValues")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PaymentRunSummaryTotalValues")
  private List<PaymentRunSummaryTotalValues> totalValues;

  @Override
  public void addFields() {
    addCustomField(
        "numberOfCreditBalanceAdjustments", numberOfCreditBalanceAdjustments, Integer.class);
    addCustomField("numberOfCreditMemos", numberOfCreditMemos, Integer.class);
    addCustomField("numberOfDebitMemos", numberOfDebitMemos, Integer.class);
    addCustomField("numberOfErrors", numberOfErrors, Integer.class);
    addCustomField("numberOfInvoices", numberOfInvoices, Integer.class);
    addCustomField("numberOfPayments", numberOfPayments, Integer.class);
    addCustomField("numberOfReceivables", numberOfReceivables, Integer.class);
    addCustomField("numberOfUnappliedPayments", numberOfUnappliedPayments, Integer.class);
    addCustomField("numberOfUnprocessedDebitMemos", numberOfUnprocessedDebitMemos, Integer.class);
    addCustomField("numberOfUnprocessedInvoices", numberOfUnprocessedInvoices, Integer.class);
    addCustomField("numberOfUnprocessedReceivables", numberOfUnprocessedReceivables, Integer.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("totalValues", totalValues, List.class);
  }
}

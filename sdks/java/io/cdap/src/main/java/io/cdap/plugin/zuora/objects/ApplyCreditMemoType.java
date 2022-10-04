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

/** Object name: ApplyCreditMemoType (ApplyCreditMemoType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ApplyCreditMemoType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ApplyCreditMemoType extends BaseObject {
  /**
   * Name: debitMemos (debitMemos), Type: array|CreditMemoApplyDebitMemoRequestType. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("debitMemos")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "CreditMemoApplyDebitMemoRequestType")
  private List<CreditMemoApplyDebitMemoRequestType> debitMemos;

  /**
   * Name: effectiveDate (effectiveDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
   * Name: invoices (invoices), Type: array|CreditMemoApplyInvoiceRequestType. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoices")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "CreditMemoApplyInvoiceRequestType")
  private List<CreditMemoApplyInvoiceRequestType> invoices;

  @Override
  public void addFields() {
    addCustomField("debitMemos", debitMemos, List.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("invoices", invoices, List.class);
  }
}

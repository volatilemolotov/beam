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

/** Object name: PutCreditMemoTaxItemType (PutCreditMemoTaxItemType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PutCreditMemoTaxItemType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PutCreditMemoTaxItemType extends BaseObject {
  /** Name: amount (amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: financeInformation (financeInformation), Type:
   * PutCreditMemoTaxItemTypeFinanceInformationItem. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: jurisdiction (jurisdiction), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("jurisdiction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String jurisdiction;

  /**
   * Name: locationCode (locationCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("locationCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String locationCode;

  /**
   * Name: taxCode (taxCode), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCode;

  /**
   * Name: taxCodeDescription (taxCodeDescription), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("taxCodeDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCodeDescription;

  /**
   * Name: taxDate (taxDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxDate;

  /**
   * Name: taxExemptAmount (taxExemptAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("taxExemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptAmount;

  /**
   * Name: taxName (taxName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxName;

  /**
   * Name: taxRate (taxRate), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxRate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRate;

  /**
   * Name: taxRateDescription (taxRateDescription), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("taxRateDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRateDescription;

  /**
   * Name: taxRateType (taxRateType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxRateType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRateType;

  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("id", id, String.class);
    addCustomField("jurisdiction", jurisdiction, String.class);
    addCustomField("locationCode", locationCode, String.class);
    addCustomField("taxCode", taxCode, String.class);
    addCustomField("taxCodeDescription", taxCodeDescription, String.class);
    addCustomField("taxDate", taxDate, String.class);
    addCustomField("taxExemptAmount", taxExemptAmount, String.class);
    addCustomField("taxName", taxName, String.class);
    addCustomField("taxRate", taxRate, String.class);
    addCustomField("taxRateDescription", taxRateDescription, String.class);
    addCustomField("taxRateType", taxRateType, String.class);
  }
}

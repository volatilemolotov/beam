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

/** Object name: ProxyModifyTaxationItem (ProxyModifyTaxationItem). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyModifyTaxationItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyModifyTaxationItem extends BaseObject {
  /**
   * Name: AccountingCode (AccountingCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /**
   * Name: ExemptAmount (ExemptAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("exemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptAmount;

  /**
   * Name: Jurisdiction (Jurisdiction), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("jurisdiction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String jurisdiction;

  /**
   * Name: LocationCode (LocationCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("locationCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String locationCode;

  /** Name: Name (Name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: TaxAmount (TaxAmount), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

  /**
   * Name: TaxCode (TaxCode), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCode;

  /**
   * Name: TaxCodeDescription (TaxCodeDescription), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("taxCodeDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCodeDescription;

  /**
   * Name: TaxDate (TaxDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxDate;

  /**
   * Name: TaxRate (TaxRate), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxRate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRate;

  /**
   * Name: TaxRateDescription (TaxRateDescription), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("taxRateDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRateDescription;

  /**
   * Name: TaxRateType (TaxRateType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxRateType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRateType;

  @Override
  public void addFields() {
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("exemptAmount", exemptAmount, String.class);
    addCustomField("jurisdiction", jurisdiction, String.class);
    addCustomField("locationCode", locationCode, String.class);
    addCustomField("name", name, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxCode", taxCode, String.class);
    addCustomField("taxCodeDescription", taxCodeDescription, String.class);
    addCustomField("taxDate", taxDate, String.class);
    addCustomField("taxRate", taxRate, String.class);
    addCustomField("taxRateDescription", taxRateDescription, String.class);
    addCustomField("taxRateType", taxRateType, String.class);
  }
}

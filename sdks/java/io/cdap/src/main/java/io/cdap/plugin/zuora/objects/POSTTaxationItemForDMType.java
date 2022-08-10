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
* Object name: POSTTaxationItemForDMType (POSTTaxationItemForDMType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTTaxationItemForDMType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTTaxationItemForDMType extends BaseObject {
  /**
  * Name: exemptAmount (exemptAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("exemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptAmount;

  /**
  * Name: financeInformation (financeInformation), Type: POSTTaxationItemForDMTypeFinanceInformationItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /**
  * Name: jurisdiction (jurisdiction), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("jurisdiction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String jurisdiction;

  /**
  * Name: locationCode (locationCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("locationCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String locationCode;

  /**
  * Name: memoItemId (memoItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("memoItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String memoItemId;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: sourceTaxItemId (sourceTaxItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceTaxItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceTaxItemId;

  /**
  * Name: taxAmount (taxAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;

  /**
  * Name: taxCode (taxCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCode;

  /**
  * Name: taxCodeDescription (taxCodeDescription), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxCodeDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCodeDescription;

  /**
  * Name: taxDate (taxDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxDate;

  /**
  * Name: taxRate (taxRate), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxRate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRate;

  /**
  * Name: taxRateDescription (taxRateDescription), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxRateDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRateDescription;

  /**
  * Name: taxRateType (taxRateType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxRateType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRateType;


  @Override
  public void addFields() {
    addCustomField("exemptAmount", exemptAmount, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("jurisdiction", jurisdiction, String.class);
    addCustomField("locationCode", locationCode, String.class);
    addCustomField("memoItemId", memoItemId, String.class);
    addCustomField("name", name, String.class);
    addCustomField("sourceTaxItemId", sourceTaxItemId, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxCode", taxCode, String.class);
    addCustomField("taxCodeDescription", taxCodeDescription, String.class);
    addCustomField("taxDate", taxDate, String.class);
    addCustomField("taxRate", taxRate, String.class);
    addCustomField("taxRateDescription", taxRateDescription, String.class);
    addCustomField("taxRateType", taxRateType, String.class);
  }
}

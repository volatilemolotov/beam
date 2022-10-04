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

/** Object name: AccountSummaryTypeTaxInfoItem (AccountSummaryTypeTaxInfoItem). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AccountSummaryTypeTaxInfoItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AccountSummaryTypeTaxInfoItem extends BaseObject {
  /** Name: VATId (VATId), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("vATId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String vATId;

  /**
   * Name: companyCode (companyCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("companyCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String companyCode;

  /**
   * Name: exemptCertificateId (exemptCertificateId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("exemptCertificateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptCertificateId;

  /**
   * Name: exemptCertificateType (exemptCertificateType), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("exemptCertificateType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptCertificateType;

  /**
   * Name: exemptDescription (exemptDescription), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("exemptDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptDescription;

  /**
   * Name: exemptEffectiveDate (exemptEffectiveDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("exemptEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptEffectiveDate;

  /**
   * Name: exemptEntityUseCode (exemptEntityUseCode), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("exemptEntityUseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptEntityUseCode;

  /**
   * Name: exemptExpirationDate (exemptExpirationDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("exemptExpirationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptExpirationDate;

  /**
   * Name: exemptIssuingJurisdiction (exemptIssuingJurisdiction), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("exemptIssuingJurisdiction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptIssuingJurisdiction;

  /**
   * Name: exemptStatus (exemptStatus), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("exemptStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String exemptStatus;

  @Override
  public void addFields() {
    addCustomField("vATId", vATId, String.class);
    addCustomField("companyCode", companyCode, String.class);
    addCustomField("exemptCertificateId", exemptCertificateId, String.class);
    addCustomField("exemptCertificateType", exemptCertificateType, String.class);
    addCustomField("exemptDescription", exemptDescription, String.class);
    addCustomField("exemptEffectiveDate", exemptEffectiveDate, String.class);
    addCustomField("exemptEntityUseCode", exemptEntityUseCode, String.class);
    addCustomField("exemptExpirationDate", exemptExpirationDate, String.class);
    addCustomField("exemptIssuingJurisdiction", exemptIssuingJurisdiction, String.class);
    addCustomField("exemptStatus", exemptStatus, String.class);
  }
}

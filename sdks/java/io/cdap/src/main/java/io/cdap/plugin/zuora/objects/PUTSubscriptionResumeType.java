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
* Object name: PUTSubscriptionResumeType (PUTSubscriptionResumeType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PUTSubscriptionResumeType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PUTSubscriptionResumeType extends BaseObject {
  /**
  * Name: applyCreditBalance (applyCreditBalance), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean applyCreditBalance;

  /**
  * Name: collect (collect), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("collect")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean collect;

  /**
  * Name: contractEffectiveDate (contractEffectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
  * Name: documentDate (documentDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentDate;

  /**
  * Name: extendsTerm (extendsTerm), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("extendsTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean extendsTerm;

  /**
  * Name: invoice (invoice), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoice;

  /**
  * Name: invoiceCollect (invoiceCollect), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceCollect")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceCollect;

  /**
  * Name: invoiceTargetDate (invoiceTargetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
  * Name: resumePeriods (resumePeriods), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumePeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumePeriods;

  /**
  * Name: resumePeriodsType (resumePeriodsType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumePeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumePeriodsType;

  /**
  * Name: resumePolicy (resumePolicy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumePolicy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumePolicy;

  /**
  * Name: resumeSpecificDate (resumeSpecificDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumeSpecificDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumeSpecificDate;

  /**
  * Name: runBilling (runBilling), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runBilling")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean runBilling;

  /**
  * Name: targetDate (targetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;


  @Override
  public void addFields() {
    addCustomField("applyCreditBalance", applyCreditBalance, Boolean.class);
    addCustomField("collect", collect, Boolean.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("documentDate", documentDate, String.class);
    addCustomField("extendsTerm", extendsTerm, Boolean.class);
    addCustomField("invoice", invoice, Boolean.class);
    addCustomField("invoiceCollect", invoiceCollect, Boolean.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("resumePeriods", resumePeriods, String.class);
    addCustomField("resumePeriodsType", resumePeriodsType, String.class);
    addCustomField("resumePolicy", resumePolicy, String.class);
    addCustomField("resumeSpecificDate", resumeSpecificDate, String.class);
    addCustomField("runBilling", runBilling, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
  }
}

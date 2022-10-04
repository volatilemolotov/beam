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

/** Object name: AmendmentType (AmendmentType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "AmendmentType", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AmendmentType extends BaseObject {
  /**
   * Name: autoRenew (autoRenew), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
   * Name: baseRatePlanId (baseRatePlanId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("baseRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String baseRatePlanId;

  /**
   * Name: baseSubscriptionId (baseSubscriptionId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("baseSubscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String baseSubscriptionId;

  /** Name: code (code), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("code")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String code;

  /**
   * Name: contractEffectiveDate (contractEffectiveDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
   * Name: currentTerm (currentTerm), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("currentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer currentTerm;

  /**
   * Name: currentTermPeriodType (currentTermPeriodType), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("currentTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currentTermPeriodType;

  /**
   * Name: customerAcceptanceDate (customerAcceptanceDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("customerAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerAcceptanceDate;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: destinationAccountId (destinationAccountId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("destinationAccountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String destinationAccountId;

  /**
   * Name: destinationInvoiceOwnerId (destinationInvoiceOwnerId), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("destinationInvoiceOwnerId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String destinationInvoiceOwnerId;

  /**
   * Name: effectiveDate (effectiveDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: newRatePlanId (newRatePlanId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("newRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String newRatePlanId;

  /**
   * Name: newSubscriptionId (newSubscriptionId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("newSubscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String newSubscriptionId;

  /**
   * Name: renewalSetting (renewalSetting), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("renewalSetting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalSetting;

  /**
   * Name: renewalTerm (renewalTerm), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("renewalTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer renewalTerm;

  /**
   * Name: renewalTermPeriodType (renewalTermPeriodType), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("renewalTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalTermPeriodType;

  /**
   * Name: resumeDate (resumeDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("resumeDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumeDate;

  /**
   * Name: serviceActivationDate (serviceActivationDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;

  /**
   * Name: specificUpdateDate (specificUpdateDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("specificUpdateDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String specificUpdateDate;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
   * Name: suspendDate (suspendDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("suspendDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String suspendDate;

  /**
   * Name: termStartDate (termStartDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("termStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termStartDate;

  /**
   * Name: termType (termType), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("termType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termType;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("baseRatePlanId", baseRatePlanId, String.class);
    addCustomField("baseSubscriptionId", baseSubscriptionId, String.class);
    addCustomField("code", code, String.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("currentTerm", currentTerm, Integer.class);
    addCustomField("currentTermPeriodType", currentTermPeriodType, String.class);
    addCustomField("customerAcceptanceDate", customerAcceptanceDate, String.class);
    addCustomField("description", description, String.class);
    addCustomField("destinationAccountId", destinationAccountId, String.class);
    addCustomField("destinationInvoiceOwnerId", destinationInvoiceOwnerId, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("name", name, String.class);
    addCustomField("newRatePlanId", newRatePlanId, String.class);
    addCustomField("newSubscriptionId", newSubscriptionId, String.class);
    addCustomField("renewalSetting", renewalSetting, String.class);
    addCustomField("renewalTerm", renewalTerm, Integer.class);
    addCustomField("renewalTermPeriodType", renewalTermPeriodType, String.class);
    addCustomField("resumeDate", resumeDate, String.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
    addCustomField("specificUpdateDate", specificUpdateDate, String.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("suspendDate", suspendDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
    addCustomField("type", type, String.class);
  }
}

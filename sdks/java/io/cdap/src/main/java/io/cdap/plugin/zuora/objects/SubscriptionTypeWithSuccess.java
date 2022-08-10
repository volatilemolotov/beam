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

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: SubscriptionTypeWithSuccess (SubscriptionTypeWithSuccess).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "SubscriptionTypeWithSuccess",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class SubscriptionTypeWithSuccess extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: accountName (accountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountName;

  /**
  * Name: accountNumber (accountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: autoRenew (autoRenew), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
  * Name: contractEffectiveDate (contractEffectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
  * Name: contractedMrr (contractedMrr), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractedMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractedMrr;

  /**
  * Name: currentTerm (currentTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer currentTerm;

  /**
  * Name: currentTermPeriodType (currentTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currentTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currentTermPeriodType;

  /**
  * Name: customerAcceptanceDate (customerAcceptanceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerAcceptanceDate;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: initialTerm (initialTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer initialTerm;

  /**
  * Name: initialTermPeriodType (initialTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String initialTermPeriodType;

  /**
  * Name: invoiceOwnerAccountId (invoiceOwnerAccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceOwnerAccountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerAccountId;

  /**
  * Name: invoiceOwnerAccountName (invoiceOwnerAccountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceOwnerAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerAccountName;

  /**
  * Name: invoiceOwnerAccountNumber (invoiceOwnerAccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceOwnerAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerAccountNumber;

  /**
  * Name: invoiceSeparately (invoiceSeparately), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceSeparately")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceSeparately;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: orderNumber (orderNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderNumber;

  /**
  * Name: ratePlans (ratePlans), Type: array|SubscriptionRatePlanType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratePlans")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "SubscriptionRatePlanType")
  private List<SubscriptionRatePlanType> ratePlans;

  /**
  * Name: renewalSetting (renewalSetting), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalSetting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalSetting;

  /**
  * Name: renewalTerm (renewalTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer renewalTerm;

  /**
  * Name: renewalTermPeriodType (renewalTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalTermPeriodType;

  /**
  * Name: serviceActivationDate (serviceActivationDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: subscriptionNumber (subscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: subscriptionStartDate (subscriptionStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionStartDate;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: termEndDate (termEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termEndDate;

  /**
  * Name: termStartDate (termStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termStartDate;

  /**
  * Name: termType (termType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termType;

  /**
  * Name: totalContractedValue (totalContractedValue), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalContractedValue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalContractedValue;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountName", accountName, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("contractedMrr", contractedMrr, String.class);
    addCustomField("currentTerm", currentTerm, Integer.class);
    addCustomField("currentTermPeriodType", currentTermPeriodType, String.class);
    addCustomField("customerAcceptanceDate", customerAcceptanceDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("initialTerm", initialTerm, Integer.class);
    addCustomField("initialTermPeriodType", initialTermPeriodType, String.class);
    addCustomField("invoiceOwnerAccountId", invoiceOwnerAccountId, String.class);
    addCustomField("invoiceOwnerAccountName", invoiceOwnerAccountName, String.class);
    addCustomField("invoiceOwnerAccountNumber", invoiceOwnerAccountNumber, String.class);
    addCustomField("invoiceSeparately", invoiceSeparately, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("orderNumber", orderNumber, String.class);
    addCustomField("ratePlans", ratePlans, List.class);
    addCustomField("renewalSetting", renewalSetting, String.class);
    addCustomField("renewalTerm", renewalTerm, Integer.class);
    addCustomField("renewalTermPeriodType", renewalTermPeriodType, String.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
    addCustomField("status", status, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("subscriptionStartDate", subscriptionStartDate, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("termEndDate", termEndDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
    addCustomField("totalContractedValue", totalContractedValue, String.class);
  }
}

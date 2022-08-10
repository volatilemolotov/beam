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
* Object name: POSTSubscriptionType (POSTSubscriptionType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTSubscriptionType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTSubscriptionType extends BaseObject {
  /**
  * Name: accountKey (accountKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountKey;

  /**
  * Name: applyCreditBalance (applyCreditBalance), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean applyCreditBalance;

  /**
  * Name: autoRenew (autoRenew), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

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
  * Name: customerAcceptanceDate (customerAcceptanceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerAcceptanceDate;

  /**
  * Name: documentDate (documentDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentDate;

  /**
  * Name: gatewayId (gatewayId), Type: string..
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayId;

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
  * Name: invoiceOwnerAccountKey (invoiceOwnerAccountKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceOwnerAccountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerAccountKey;

  /**
  * Name: invoiceSeparately (invoiceSeparately), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceSeparately")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceSeparately;

  /**
  * Name: invoiceTargetDate (invoiceTargetDate), Type: string
  * Options (custom, update, select): false, false, false.
  **/
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: paymentMethodId (paymentMethodId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

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
  * Name: runBilling (runBilling), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runBilling")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean runBilling;

  /**
  * Name: serviceActivationDate (serviceActivationDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;

  /**
  * Name: subscribeToRatePlans (subscribeToRatePlans), Type: array|POSTSrpCreateType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscribeToRatePlans")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTSrpCreateType")
  private List<POSTSrpCreateType> subscribeToRatePlans;

  /**
  * Name: subscriptionNumber (subscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: targetDate (targetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

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


  @Override
  public void addFields() {
    addCustomField("accountKey", accountKey, String.class);
    addCustomField("applyCreditBalance", applyCreditBalance, Boolean.class);
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("collect", collect, Boolean.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("customerAcceptanceDate", customerAcceptanceDate, String.class);
    addCustomField("documentDate", documentDate, String.class);
    addCustomField("gatewayId", gatewayId, String.class);
    addCustomField("initialTerm", initialTerm, Integer.class);
    addCustomField("initialTermPeriodType", initialTermPeriodType, String.class);
    addCustomField("invoice", invoice, Boolean.class);
    addCustomField("invoiceCollect", invoiceCollect, Boolean.class);
    addCustomField("invoiceOwnerAccountKey", invoiceOwnerAccountKey, String.class);
    addCustomField("invoiceSeparately", invoiceSeparately, Boolean.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("renewalSetting", renewalSetting, String.class);
    addCustomField("renewalTerm", renewalTerm, Integer.class);
    addCustomField("renewalTermPeriodType", renewalTermPeriodType, String.class);
    addCustomField("runBilling", runBilling, Boolean.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
    addCustomField("subscribeToRatePlans", subscribeToRatePlans, List.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
  }
}

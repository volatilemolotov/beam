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
* Object name: ProxyGetSubscription (ProxyGetSubscription).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetSubscription",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetSubscription extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AutoRenew (AutoRenew), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
  * Name: CancelledDate (CancelledDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledDate;

  /**
  * Name: ContractAcceptanceDate (ContractAcceptanceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractAcceptanceDate;

  /**
  * Name: ContractEffectiveDate (ContractEffectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: CreatorAccountId (CreatorAccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creatorAccountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creatorAccountId;

  /**
  * Name: CreatorInvoiceOwnerId (CreatorInvoiceOwnerId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creatorInvoiceOwnerId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creatorInvoiceOwnerId;

  /**
  * Name: CurrentTerm (CurrentTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer currentTerm;

  /**
  * Name: CurrentTermPeriodType (CurrentTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currentTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currentTermPeriodType;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: InitialTerm (InitialTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer initialTerm;

  /**
  * Name: InitialTermPeriodType (InitialTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String initialTermPeriodType;

  /**
  * Name: InvoiceOwnerId (InvoiceOwnerId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceOwnerId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerId;

  /**
  * Name: IsInvoiceSeparate (IsInvoiceSeparate), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("isInvoiceSeparate")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isInvoiceSeparate;

  /**
  * Name: Name (Name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: Notes (Notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: OriginalCreatedDate (OriginalCreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("originalCreatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalCreatedDate;

  /**
  * Name: OriginalId (OriginalId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("originalId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalId;

  /**
  * Name: PreviousSubscriptionId (PreviousSubscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("previousSubscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previousSubscriptionId;

  /**
  * Name: RenewalSetting (RenewalSetting), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalSetting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalSetting;

  /**
  * Name: RenewalTerm (RenewalTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer renewalTerm;

  /**
  * Name: RenewalTermPeriodType (RenewalTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalTermPeriodType;

  /**
  * Name: ServiceActivationDate (ServiceActivationDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;

  /**
  * Name: Status (Status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: SubscriptionEndDate (SubscriptionEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionEndDate;

  /**
  * Name: SubscriptionStartDate (SubscriptionStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionStartDate;

  /**
  * Name: TermEndDate (TermEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termEndDate;

  /**
  * Name: TermStartDate (TermStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termStartDate;

  /**
  * Name: TermType (TermType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termType;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;

  /**
  * Name: Version (Version), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("version")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer version;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("cancelledDate", cancelledDate, String.class);
    addCustomField("contractAcceptanceDate", contractAcceptanceDate, String.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creatorAccountId", creatorAccountId, String.class);
    addCustomField("creatorInvoiceOwnerId", creatorInvoiceOwnerId, String.class);
    addCustomField("currentTerm", currentTerm, Integer.class);
    addCustomField("currentTermPeriodType", currentTermPeriodType, String.class);
    addCustomField("id", id, String.class);
    addCustomField("initialTerm", initialTerm, Integer.class);
    addCustomField("initialTermPeriodType", initialTermPeriodType, String.class);
    addCustomField("invoiceOwnerId", invoiceOwnerId, String.class);
    addCustomField("isInvoiceSeparate", isInvoiceSeparate, Boolean.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("originalCreatedDate", originalCreatedDate, String.class);
    addCustomField("originalId", originalId, String.class);
    addCustomField("previousSubscriptionId", previousSubscriptionId, String.class);
    addCustomField("renewalSetting", renewalSetting, String.class);
    addCustomField("renewalTerm", renewalTerm, Integer.class);
    addCustomField("renewalTermPeriodType", renewalTermPeriodType, String.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
    addCustomField("status", status, String.class);
    addCustomField("subscriptionEndDate", subscriptionEndDate, String.class);
    addCustomField("subscriptionStartDate", subscriptionStartDate, String.class);
    addCustomField("termEndDate", termEndDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
    addCustomField("version", version, Integer.class);
  }
}

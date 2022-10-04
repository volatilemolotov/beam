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

/** Object name: ProxyModifyAccount (ProxyModifyAccount). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyModifyAccount",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyModifyAccount extends BaseObject {
  /**
   * Name: AccountNumber (AccountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
   * Name: AdditionalEmailAddresses (AdditionalEmailAddresses), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("additionalEmailAddresses")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String additionalEmailAddresses;

  /**
   * Name: AllowInvoiceEdit (AllowInvoiceEdit), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("allowInvoiceEdit")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean allowInvoiceEdit;

  /**
   * Name: AutoPay (AutoPay), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("autoPay")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoPay;

  /** Name: Batch (Batch), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
   * Name: BcdSettingOption (BcdSettingOption), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("bcdSettingOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bcdSettingOption;

  /**
   * Name: BillCycleDay (BillCycleDay), Type: integer. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer billCycleDay;

  /**
   * Name: BillToId (BillToId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("billToId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billToId;

  /**
   * Name: CommunicationProfileId (CommunicationProfileId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("communicationProfileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String communicationProfileId;

  /** Name: CrmId (CrmId), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("crmId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String crmId;

  /**
   * Name: Currency (Currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: CustomerServiceRepName (CustomerServiceRepName), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("customerServiceRepName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerServiceRepName;

  /**
   * Name: DefaultPaymentMethodId (DefaultPaymentMethodId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("defaultPaymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String defaultPaymentMethodId;

  /**
   * Name: InvoiceDeliveryPrefsEmail (InvoiceDeliveryPrefsEmail), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceDeliveryPrefsEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceDeliveryPrefsEmail;

  /**
   * Name: InvoiceDeliveryPrefsPrint (InvoiceDeliveryPrefsPrint), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceDeliveryPrefsPrint")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceDeliveryPrefsPrint;

  /**
   * Name: InvoiceTemplateId (InvoiceTemplateId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceTemplateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTemplateId;

  /** Name: Name (Name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: Notes (Notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
   * Name: ParentId (ParentId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("parentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String parentId;

  /**
   * Name: PaymentGateway (PaymentGateway), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentGateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentGateway;

  /**
   * Name: PaymentTerm (PaymentTerm), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("paymentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentTerm;

  /**
   * Name: PurchaseOrderNumber (PurchaseOrderNumber), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("purchaseOrderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String purchaseOrderNumber;

  /**
   * Name: SalesRepName (SalesRepName), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("salesRepName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String salesRepName;

  /**
   * Name: SoldToId (SoldToId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("soldToId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String soldToId;

  /** Name: Status (Status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: TaxCompanyCode (TaxCompanyCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("taxCompanyCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCompanyCode;

  /**
   * Name: TaxExemptCertificateID (TaxExemptCertificateID), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("taxExemptCertificateID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptCertificateID;

  /**
   * Name: TaxExemptCertificateType (TaxExemptCertificateType), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxExemptCertificateType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptCertificateType;

  /**
   * Name: TaxExemptDescription (TaxExemptDescription), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("taxExemptDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptDescription;

  /**
   * Name: TaxExemptEffectiveDate (TaxExemptEffectiveDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("taxExemptEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptEffectiveDate;

  /**
   * Name: TaxExemptExpirationDate (TaxExemptExpirationDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("taxExemptExpirationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptExpirationDate;

  /**
   * Name: TaxExemptIssuingJurisdiction (TaxExemptIssuingJurisdiction), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxExemptIssuingJurisdiction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptIssuingJurisdiction;

  /**
   * Name: TaxExemptStatus (TaxExemptStatus), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("taxExemptStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptStatus;

  /** Name: VATId (VATId), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("vATId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String vATId;

  @Override
  public void addFields() {
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("additionalEmailAddresses", additionalEmailAddresses, String.class);
    addCustomField("allowInvoiceEdit", allowInvoiceEdit, Boolean.class);
    addCustomField("autoPay", autoPay, Boolean.class);
    addCustomField("batch", batch, String.class);
    addCustomField("bcdSettingOption", bcdSettingOption, String.class);
    addCustomField("billCycleDay", billCycleDay, Integer.class);
    addCustomField("billToId", billToId, String.class);
    addCustomField("communicationProfileId", communicationProfileId, String.class);
    addCustomField("crmId", crmId, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("customerServiceRepName", customerServiceRepName, String.class);
    addCustomField("defaultPaymentMethodId", defaultPaymentMethodId, String.class);
    addCustomField("invoiceDeliveryPrefsEmail", invoiceDeliveryPrefsEmail, Boolean.class);
    addCustomField("invoiceDeliveryPrefsPrint", invoiceDeliveryPrefsPrint, Boolean.class);
    addCustomField("invoiceTemplateId", invoiceTemplateId, String.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("parentId", parentId, String.class);
    addCustomField("paymentGateway", paymentGateway, String.class);
    addCustomField("paymentTerm", paymentTerm, String.class);
    addCustomField("purchaseOrderNumber", purchaseOrderNumber, String.class);
    addCustomField("salesRepName", salesRepName, String.class);
    addCustomField("soldToId", soldToId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("taxCompanyCode", taxCompanyCode, String.class);
    addCustomField("taxExemptCertificateID", taxExemptCertificateID, String.class);
    addCustomField("taxExemptCertificateType", taxExemptCertificateType, String.class);
    addCustomField("taxExemptDescription", taxExemptDescription, String.class);
    addCustomField("taxExemptEffectiveDate", taxExemptEffectiveDate, String.class);
    addCustomField("taxExemptExpirationDate", taxExemptExpirationDate, String.class);
    addCustomField("taxExemptIssuingJurisdiction", taxExemptIssuingJurisdiction, String.class);
    addCustomField("taxExemptStatus", taxExemptStatus, String.class);
    addCustomField("vATId", vATId, String.class);
  }
}

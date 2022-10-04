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

/** Object name: ProxyGetInvoiceItem (ProxyGetInvoiceItem). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyGetInvoiceItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyGetInvoiceItem extends BaseObject {
  /**
   * Name: AccountingCode (AccountingCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /**
   * Name: AppliedToInvoiceItemId (AppliedToInvoiceItemId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("appliedToInvoiceItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedToInvoiceItemId;

  /**
   * Name: ChargeAmount (ChargeAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("chargeAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeAmount;

  /**
   * Name: ChargeDate (ChargeDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("chargeDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeDate;

  /**
   * Name: ChargeName (ChargeName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("chargeName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeName;

  /**
   * Name: CreatedById (CreatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
   * Name: CreatedDate (CreatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /** Name: Id (Id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: InvoiceId (InvoiceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
   * Name: ProcessingType (ProcessingType), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("processingType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processingType;

  /**
   * Name: ProductDescription (ProductDescription), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("productDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productDescription;

  /**
   * Name: ProductName (ProductName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("productName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productName;

  /**
   * Name: Quantity (Quantity), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
   * Name: RatePlanChargeId (RatePlanChargeId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("ratePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanChargeId;

  /**
   * Name: RevRecStartDate (RevRecStartDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("revRecStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecStartDate;

  /** Name: SKU (SKU), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("sKU")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sKU;

  /**
   * Name: ServiceEndDate (ServiceEndDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("serviceEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceEndDate;

  /**
   * Name: ServiceStartDate (ServiceStartDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("serviceStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceStartDate;

  /**
   * Name: SubscriptionId (SubscriptionId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

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
   * Name: TaxExemptAmount (TaxExemptAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("taxExemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxExemptAmount;

  /**
   * Name: TaxMode (TaxMode), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("taxMode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxMode;

  /** Name: UOM (UOM), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("uOM")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uOM;

  /**
   * Name: UnitPrice (UnitPrice), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("unitPrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unitPrice;

  /**
   * Name: UpdatedById (UpdatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
   * Name: UpdatedDate (UpdatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;

  @Override
  public void addFields() {
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("appliedToInvoiceItemId", appliedToInvoiceItemId, String.class);
    addCustomField("chargeAmount", chargeAmount, String.class);
    addCustomField("chargeDate", chargeDate, String.class);
    addCustomField("chargeName", chargeName, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("processingType", processingType, String.class);
    addCustomField("productDescription", productDescription, String.class);
    addCustomField("productName", productName, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratePlanChargeId", ratePlanChargeId, String.class);
    addCustomField("revRecStartDate", revRecStartDate, String.class);
    addCustomField("sKU", sKU, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxCode", taxCode, String.class);
    addCustomField("taxExemptAmount", taxExemptAmount, String.class);
    addCustomField("taxMode", taxMode, String.class);
    addCustomField("uOM", uOM, String.class);
    addCustomField("unitPrice", unitPrice, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

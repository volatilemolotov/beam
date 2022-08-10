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
* Object name: ProxyGetProductRatePlanCharge (ProxyGetProductRatePlanCharge).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetProductRatePlanCharge",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetProductRatePlanCharge extends BaseObject {
  /**
  * Name: AccountingCode (AccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /**
  * Name: ApplyDiscountTo (ApplyDiscountTo), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyDiscountTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyDiscountTo;

  /**
  * Name: BillCycleDay (BillCycleDay), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer billCycleDay;

  /**
  * Name: BillCycleType (BillCycleType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleType;

  /**
  * Name: BillingPeriod (BillingPeriod), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriod;

  /**
  * Name: BillingPeriodAlignment (BillingPeriodAlignment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingPeriodAlignment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriodAlignment;

  /**
  * Name: BillingTiming (BillingTiming), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingTiming")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingTiming;

  /**
  * Name: ChargeModel (ChargeModel), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeModel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeModel;

  /**
  * Name: ChargeType (ChargeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeType;

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
  * Name: DefaultQuantity (DefaultQuantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("defaultQuantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String defaultQuantity;

  /**
  * Name: DeferredRevenueAccount (DeferredRevenueAccount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("deferredRevenueAccount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deferredRevenueAccount;

  /**
  * Name: Description (Description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: DiscountLevel (DiscountLevel), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountLevel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountLevel;

  /**
  * Name: EndDateCondition (EndDateCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: IncludedUnits (IncludedUnits), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includedUnits")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String includedUnits;

  /**
  * Name: LegacyRevenueReporting (LegacyRevenueReporting), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("legacyRevenueReporting")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean legacyRevenueReporting;

  /**
  * Name: ListPriceBase (ListPriceBase), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("listPriceBase")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String listPriceBase;

  /**
  * Name: MaxQuantity (MaxQuantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("maxQuantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String maxQuantity;

  /**
  * Name: MinQuantity (MinQuantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("minQuantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String minQuantity;

  /**
  * Name: Name (Name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: NumberOfPeriod (NumberOfPeriod), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numberOfPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPeriod;

  /**
  * Name: OverageCalculationOption (OverageCalculationOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overageCalculationOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageCalculationOption;

  /**
  * Name: OverageUnusedUnitsCreditOption (OverageUnusedUnitsCreditOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overageUnusedUnitsCreditOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageUnusedUnitsCreditOption;

  /**
  * Name: PriceChangeOption (PriceChangeOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;

  /**
  * Name: PriceIncreasePercentage (PriceIncreasePercentage), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceIncreasePercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceIncreasePercentage;

  /**
  * Name: ProductRatePlanId (ProductRatePlanId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /**
  * Name: RecognizedRevenueAccount (RecognizedRevenueAccount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognizedRevenueAccount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenueAccount;

  /**
  * Name: RevRecCode (RevRecCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revRecCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecCode;

  /**
  * Name: RevRecTriggerCondition (RevRecTriggerCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revRecTriggerCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecTriggerCondition;

  /**
  * Name: RevenueRecognitionRuleName (RevenueRecognitionRuleName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueRecognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueRecognitionRuleName;

  /**
  * Name: SmoothingModel (SmoothingModel), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("smoothingModel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String smoothingModel;

  /**
  * Name: SpecificBillingPeriod (SpecificBillingPeriod), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
  * Name: TaxCode (TaxCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCode;

  /**
  * Name: TaxMode (TaxMode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxMode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxMode;

  /**
  * Name: Taxable (Taxable), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxable")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean taxable;

  /**
  * Name: TriggerEvent (TriggerEvent), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerEvent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerEvent;

  /**
  * Name: UOM (UOM), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uOM")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uOM;

  /**
  * Name: UpToPeriods (UpToPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("upToPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer upToPeriods;

  /**
  * Name: UpToPeriodsType (UpToPeriodsType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("upToPeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String upToPeriodsType;

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
  * Name: UseDiscountSpecificAccountingCode (UseDiscountSpecificAccountingCode), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("useDiscountSpecificAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean useDiscountSpecificAccountingCode;

  /**
  * Name: UseTenantDefaultForPriceChange (UseTenantDefaultForPriceChange), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("useTenantDefaultForPriceChange")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean useTenantDefaultForPriceChange;

  /**
  * Name: WeeklyBillCycleDay (WeeklyBillCycleDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("weeklyBillCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String weeklyBillCycleDay;


  @Override
  public void addFields() {
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("applyDiscountTo", applyDiscountTo, String.class);
    addCustomField("billCycleDay", billCycleDay, Integer.class);
    addCustomField("billCycleType", billCycleType, String.class);
    addCustomField("billingPeriod", billingPeriod, String.class);
    addCustomField("billingPeriodAlignment", billingPeriodAlignment, String.class);
    addCustomField("billingTiming", billingTiming, String.class);
    addCustomField("chargeModel", chargeModel, String.class);
    addCustomField("chargeType", chargeType, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("defaultQuantity", defaultQuantity, String.class);
    addCustomField("deferredRevenueAccount", deferredRevenueAccount, String.class);
    addCustomField("description", description, String.class);
    addCustomField("discountLevel", discountLevel, String.class);
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("id", id, String.class);
    addCustomField("includedUnits", includedUnits, String.class);
    addCustomField("legacyRevenueReporting", legacyRevenueReporting, Boolean.class);
    addCustomField("listPriceBase", listPriceBase, String.class);
    addCustomField("maxQuantity", maxQuantity, String.class);
    addCustomField("minQuantity", minQuantity, String.class);
    addCustomField("name", name, String.class);
    addCustomField("numberOfPeriod", numberOfPeriod, Integer.class);
    addCustomField("overageCalculationOption", overageCalculationOption, String.class);
    addCustomField("overageUnusedUnitsCreditOption", overageUnusedUnitsCreditOption, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("recognizedRevenueAccount", recognizedRevenueAccount, String.class);
    addCustomField("revRecCode", revRecCode, String.class);
    addCustomField("revRecTriggerCondition", revRecTriggerCondition, String.class);
    addCustomField("revenueRecognitionRuleName", revenueRecognitionRuleName, String.class);
    addCustomField("smoothingModel", smoothingModel, String.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("taxCode", taxCode, String.class);
    addCustomField("taxMode", taxMode, String.class);
    addCustomField("taxable", taxable, Boolean.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
    addCustomField("uOM", uOM, String.class);
    addCustomField("upToPeriods", upToPeriods, Integer.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
    addCustomField("useDiscountSpecificAccountingCode", useDiscountSpecificAccountingCode, Boolean.class);
    addCustomField("useTenantDefaultForPriceChange", useTenantDefaultForPriceChange, Boolean.class);
    addCustomField("weeklyBillCycleDay", weeklyBillCycleDay, String.class);
  }
}

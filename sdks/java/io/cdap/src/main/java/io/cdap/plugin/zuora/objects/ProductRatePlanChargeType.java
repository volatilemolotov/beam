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
* Object name: ProductRatePlanChargeType (ProductRatePlanChargeType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProductRatePlanChargeType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProductRatePlanChargeType extends BaseObject {
  /**
  * Name: applyDiscountTo (applyDiscountTo), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyDiscountTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyDiscountTo;

  /**
  * Name: billingDay (billingDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingDay;

  /**
  * Name: billingPeriod (billingPeriod), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriod;

  /**
  * Name: billingPeriodAlignment (billingPeriodAlignment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingPeriodAlignment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriodAlignment;

  /**
  * Name: billingTiming (billingTiming), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingTiming")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingTiming;

  /**
  * Name: defaultQuantity (defaultQuantity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("defaultQuantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String defaultQuantity;

  /**
  * Name: description (description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: discountClass (discountClass), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountClass")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountClass;

  /**
  * Name: discountLevel (discountLevel), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountLevel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountLevel;

  /**
  * Name: endDateCondition (endDateCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /**
  * Name: financeInformation (financeInformation), Type: ProductRatePlanChargeTypeFinanceInformationItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: includedUnits (includedUnits), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includedUnits")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String includedUnits;

  /**
  * Name: listPriceBase (listPriceBase), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("listPriceBase")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String listPriceBase;

  /**
  * Name: maxQuantity (maxQuantity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("maxQuantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String maxQuantity;

  /**
  * Name: minQuantity (minQuantity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("minQuantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String minQuantity;

  /**
  * Name: model (model), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("model")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String model;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: numberOfPeriods (numberOfPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numberOfPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPeriods;

  /**
  * Name: overageCalculationOption (overageCalculationOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overageCalculationOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageCalculationOption;

  /**
  * Name: overageUnusedUnitsCreditOption (overageUnusedUnitsCreditOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overageUnusedUnitsCreditOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageUnusedUnitsCreditOption;

  /**
  * Name: prepayPeriods (prepayPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("prepayPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer prepayPeriods;

  /**
  * Name: priceChangeOption (priceChangeOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;

  /**
  * Name: priceIncreasePercentage (priceIncreasePercentage), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceIncreasePercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceIncreasePercentage;

  /**
  * Name: pricing (pricing), Type: array|ProductRatePlanChargePricingType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pricing")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ProductRatePlanChargePricingType")
  private List<ProductRatePlanChargePricingType> pricing;

  /**
  * Name: pricingSummary (pricingSummary), Type: array|ProductRatePlanChargeTypePricingSummaryItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pricingSummary")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ProductRatePlanChargeTypePricingSummaryItem")
  private List<ProductRatePlanChargeTypePricingSummaryItem> pricingSummary;

  /**
  * Name: productDiscountApplyDetails (productDiscountApplyDetails), Type: array|ProductDiscountApplyDetailsType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productDiscountApplyDetails")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ProductDiscountApplyDetailsType")
  private List<ProductDiscountApplyDetailsType> productDiscountApplyDetails;

  /**
  * Name: ratingGroup (ratingGroup), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratingGroup")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratingGroup;

  /**
  * Name: revRecCode (revRecCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revRecCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecCode;

  /**
  * Name: revRecTriggerCondition (revRecTriggerCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revRecTriggerCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecTriggerCondition;

  /**
  * Name: revenueRecognitionRuleName (revenueRecognitionRuleName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueRecognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueRecognitionRuleName;

  /**
  * Name: smoothingModel (smoothingModel), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("smoothingModel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String smoothingModel;

  /**
  * Name: specificBillingPeriod (specificBillingPeriod), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
  * Name: taxCode (taxCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxCode;

  /**
  * Name: taxMode (taxMode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxMode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxMode;

  /**
  * Name: taxable (taxable), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxable")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean taxable;

  /**
  * Name: triggerEvent (triggerEvent), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerEvent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerEvent;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
  * Name: uom (uom), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uom")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uom;

  /**
  * Name: upToPeriods (upToPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("upToPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer upToPeriods;

  /**
  * Name: upToPeriodsType (upToPeriodsType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("upToPeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String upToPeriodsType;

  /**
  * Name: usageRecordRatingOption (usageRecordRatingOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("usageRecordRatingOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String usageRecordRatingOption;

  /**
  * Name: useDiscountSpecificAccountingCode (useDiscountSpecificAccountingCode), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("useDiscountSpecificAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean useDiscountSpecificAccountingCode;

  /**
  * Name: useTenantDefaultForPriceChange (useTenantDefaultForPriceChange), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("useTenantDefaultForPriceChange")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean useTenantDefaultForPriceChange;


  @Override
  public void addFields() {
    addCustomField("applyDiscountTo", applyDiscountTo, String.class);
    addCustomField("billingDay", billingDay, String.class);
    addCustomField("billingPeriod", billingPeriod, String.class);
    addCustomField("billingPeriodAlignment", billingPeriodAlignment, String.class);
    addCustomField("billingTiming", billingTiming, String.class);
    addCustomField("defaultQuantity", defaultQuantity, String.class);
    addCustomField("description", description, String.class);
    addCustomField("discountClass", discountClass, String.class);
    addCustomField("discountLevel", discountLevel, String.class);
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("id", id, String.class);
    addCustomField("includedUnits", includedUnits, String.class);
    addCustomField("listPriceBase", listPriceBase, String.class);
    addCustomField("maxQuantity", maxQuantity, String.class);
    addCustomField("minQuantity", minQuantity, String.class);
    addCustomField("model", model, String.class);
    addCustomField("name", name, String.class);
    addCustomField("numberOfPeriods", numberOfPeriods, Integer.class);
    addCustomField("overageCalculationOption", overageCalculationOption, String.class);
    addCustomField("overageUnusedUnitsCreditOption", overageUnusedUnitsCreditOption, String.class);
    addCustomField("prepayPeriods", prepayPeriods, Integer.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("pricing", pricing, List.class);
    addCustomField("pricingSummary", pricingSummary, List.class);
    addCustomField("productDiscountApplyDetails", productDiscountApplyDetails, List.class);
    addCustomField("ratingGroup", ratingGroup, String.class);
    addCustomField("revRecCode", revRecCode, String.class);
    addCustomField("revRecTriggerCondition", revRecTriggerCondition, String.class);
    addCustomField("revenueRecognitionRuleName", revenueRecognitionRuleName, String.class);
    addCustomField("smoothingModel", smoothingModel, String.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("taxCode", taxCode, String.class);
    addCustomField("taxMode", taxMode, String.class);
    addCustomField("taxable", taxable, Boolean.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
    addCustomField("type", type, String.class);
    addCustomField("uom", uom, String.class);
    addCustomField("upToPeriods", upToPeriods, Integer.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
    addCustomField("usageRecordRatingOption", usageRecordRatingOption, String.class);
    addCustomField("useDiscountSpecificAccountingCode", useDiscountSpecificAccountingCode, Boolean.class);
    addCustomField("useTenantDefaultForPriceChange", useTenantDefaultForPriceChange, Boolean.class);
  }
}

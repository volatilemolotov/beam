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
import java.util.List;
import javax.annotation.Nullable;

/**
 * Object name: SubscriptionRatePlanChargesType (SubscriptionRatePlanChargesType). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "SubscriptionRatePlanChargesType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class SubscriptionRatePlanChargesType extends BaseObject {
  /**
   * Name: applyDiscountTo (applyDiscountTo), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("applyDiscountTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyDiscountTo;

  /**
   * Name: billingDay (billingDay), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("billingDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingDay;

  /**
   * Name: billingPeriod (billingPeriod), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriod;

  /**
   * Name: billingPeriodAlignment (billingPeriodAlignment), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("billingPeriodAlignment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriodAlignment;

  /**
   * Name: billingTiming (billingTiming), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billingTiming")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingTiming;

  /**
   * Name: chargedThroughDate (chargedThroughDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("chargedThroughDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargedThroughDate;

  /**
   * Name: currency (currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: discountAmount (discountAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("discountAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountAmount;

  /**
   * Name: discountApplyDetails (discountApplyDetails), Type: array|DiscountApplyDetailsType.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("discountApplyDetails")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "DiscountApplyDetailsType")
  private List<DiscountApplyDetailsType> discountApplyDetails;

  /**
   * Name: discountClass (discountClass), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("discountClass")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountClass;

  /**
   * Name: discountLevel (discountLevel), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("discountLevel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountLevel;

  /**
   * Name: discountPercentage (discountPercentage), Type: number. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("discountPercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountPercentage;

  /** Name: dmrc (dmrc), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dmrc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dmrc;

  /** Name: done (done), Type: boolean. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("done")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean done;

  /** Name: dtcv (dtcv), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dtcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dtcv;

  /**
   * Name: effectiveEndDate (effectiveEndDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveEndDate;

  /**
   * Name: effectiveStartDate (effectiveStartDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveStartDate;

  /**
   * Name: endDateCondition (endDateCondition), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: includedUnits (includedUnits), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("includedUnits")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String includedUnits;

  /**
   * Name: listPriceBase (listPriceBase), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("listPriceBase")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String listPriceBase;

  /** Name: model (model), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("model")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String model;

  /** Name: mrr (mrr), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("mrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mrr;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: number (number), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
   * Name: numberOfPeriods (numberOfPeriods), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("numberOfPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPeriods;

  /**
   * Name: originalChargeId (originalChargeId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("originalChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalChargeId;

  /**
   * Name: overageCalculationOption (overageCalculationOption), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("overageCalculationOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageCalculationOption;

  /**
   * Name: overagePrice (overagePrice), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("overagePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overagePrice;

  /**
   * Name: overageUnusedUnitsCreditOption (overageUnusedUnitsCreditOption), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("overageUnusedUnitsCreditOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageUnusedUnitsCreditOption;

  /** Name: price (price), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
   * Name: priceChangeOption (priceChangeOption), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;

  /**
   * Name: priceIncreasePercentage (priceIncreasePercentage), Type: number. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("priceIncreasePercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceIncreasePercentage;

  /**
   * Name: pricingSummary (pricingSummary), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("pricingSummary")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pricingSummary;

  /**
   * Name: processedThroughDate (processedThroughDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("processedThroughDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processedThroughDate;

  /**
   * Name: productRatePlanChargeId (productRatePlanChargeId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
   * Name: quantity (quantity), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
   * Name: ratingGroup (ratingGroup), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("ratingGroup")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratingGroup;

  /**
   * Name: segment (segment), Type: integer. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("segment")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer segment;

  /**
   * Name: smoothingModel (smoothingModel), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("smoothingModel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String smoothingModel;

  /**
   * Name: specificBillingPeriod (specificBillingPeriod), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
   * Name: specificEndDate (specificEndDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("specificEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String specificEndDate;

  /** Name: tcv (tcv), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tcv;

  /**
   * Name: tiers (tiers), Type: array|TierType. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("tiers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TierType")
  private List<TierType> tiers;

  /**
   * Name: triggerDate (triggerDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("triggerDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerDate;

  /**
   * Name: triggerEvent (triggerEvent), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("triggerEvent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerEvent;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
   * Name: unusedUnitsCreditRates (unusedUnitsCreditRates), Type: number. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("unusedUnitsCreditRates")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unusedUnitsCreditRates;

  /** Name: uom (uom), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("uom")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uom;

  /**
   * Name: upToPeriods (upToPeriods), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("upToPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String upToPeriods;

  /**
   * Name: upToPeriodsType (upToPeriodsType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("upToPeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String upToPeriodsType;

  /**
   * Name: usageRecordRatingOption (usageRecordRatingOption), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("usageRecordRatingOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String usageRecordRatingOption;

  /**
   * Name: version (version), Type: integer. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("version")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer version;

  @Override
  public void addFields() {
    addCustomField("applyDiscountTo", applyDiscountTo, String.class);
    addCustomField("billingDay", billingDay, String.class);
    addCustomField("billingPeriod", billingPeriod, String.class);
    addCustomField("billingPeriodAlignment", billingPeriodAlignment, String.class);
    addCustomField("billingTiming", billingTiming, String.class);
    addCustomField("chargedThroughDate", chargedThroughDate, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("description", description, String.class);
    addCustomField("discountAmount", discountAmount, String.class);
    addCustomField("discountApplyDetails", discountApplyDetails, List.class);
    addCustomField("discountClass", discountClass, String.class);
    addCustomField("discountLevel", discountLevel, String.class);
    addCustomField("discountPercentage", discountPercentage, String.class);
    addCustomField("dmrc", dmrc, String.class);
    addCustomField("done", done, Boolean.class);
    addCustomField("dtcv", dtcv, String.class);
    addCustomField("effectiveEndDate", effectiveEndDate, String.class);
    addCustomField("effectiveStartDate", effectiveStartDate, String.class);
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("id", id, String.class);
    addCustomField("includedUnits", includedUnits, String.class);
    addCustomField("listPriceBase", listPriceBase, String.class);
    addCustomField("model", model, String.class);
    addCustomField("mrr", mrr, String.class);
    addCustomField("name", name, String.class);
    addCustomField("number", number, String.class);
    addCustomField("numberOfPeriods", numberOfPeriods, Integer.class);
    addCustomField("originalChargeId", originalChargeId, String.class);
    addCustomField("overageCalculationOption", overageCalculationOption, String.class);
    addCustomField("overagePrice", overagePrice, String.class);
    addCustomField("overageUnusedUnitsCreditOption", overageUnusedUnitsCreditOption, String.class);
    addCustomField("price", price, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("pricingSummary", pricingSummary, String.class);
    addCustomField("processedThroughDate", processedThroughDate, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratingGroup", ratingGroup, String.class);
    addCustomField("segment", segment, Integer.class);
    addCustomField("smoothingModel", smoothingModel, String.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("specificEndDate", specificEndDate, String.class);
    addCustomField("tcv", tcv, String.class);
    addCustomField("tiers", tiers, List.class);
    addCustomField("triggerDate", triggerDate, String.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
    addCustomField("type", type, String.class);
    addCustomField("unusedUnitsCreditRates", unusedUnitsCreditRates, String.class);
    addCustomField("uom", uom, String.class);
    addCustomField("upToPeriods", upToPeriods, String.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
    addCustomField("usageRecordRatingOption", usageRecordRatingOption, String.class);
    addCustomField("version", version, Integer.class);
  }
}

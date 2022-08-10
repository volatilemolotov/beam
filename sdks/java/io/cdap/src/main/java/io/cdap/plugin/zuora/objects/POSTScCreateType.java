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
* Object name: POSTScCreateType (POSTScCreateType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTScCreateType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTScCreateType extends BaseObject {
  /**
  * Name: applyDiscountTo (applyDiscountTo), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyDiscountTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyDiscountTo;

  /**
  * Name: billCycleDay (billCycleDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleDay;

  /**
  * Name: billCycleType (billCycleType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleType;

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
  * Name: description (description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: discountAmount (discountAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountAmount;

  /**
  * Name: discountLevel (discountLevel), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountLevel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountLevel;

  /**
  * Name: discountPercentage (discountPercentage), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountPercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountPercentage;

  /**
  * Name: endDateCondition (endDateCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /**
  * Name: includedUnits (includedUnits), Type: number.
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
  * Name: number (number), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
  * Name: numberOfPeriods (numberOfPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numberOfPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPeriods;

  /**
  * Name: overagePrice (overagePrice), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overagePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overagePrice;

  /**
  * Name: overageUnusedUnitsCreditOption (overageUnusedUnitsCreditOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overageUnusedUnitsCreditOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageUnusedUnitsCreditOption;

  /**
  * Name: price (price), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
  * Name: priceChangeOption (priceChangeOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;

  /**
  * Name: priceIncreasePercentage (priceIncreasePercentage), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceIncreasePercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceIncreasePercentage;

  /**
  * Name: productRatePlanChargeId (productRatePlanChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
  * Name: quantity (quantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: ratingGroup (ratingGroup), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratingGroup")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratingGroup;

  /**
  * Name: specificBillingPeriod (specificBillingPeriod), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
  * Name: specificEndDate (specificEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String specificEndDate;

  /**
  * Name: tiers (tiers), Type: array|POSTTierType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tiers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTTierType")
  private List<POSTTierType> tiers;

  /**
  * Name: triggerDate (triggerDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerDate;

  /**
  * Name: triggerEvent (triggerEvent), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerEvent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerEvent;

  /**
  * Name: unusedUnitsCreditRates (unusedUnitsCreditRates), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unusedUnitsCreditRates")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unusedUnitsCreditRates;

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
  * Name: weeklyBillCycleDay (weeklyBillCycleDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("weeklyBillCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String weeklyBillCycleDay;


  @Override
  public void addFields() {
    addCustomField("applyDiscountTo", applyDiscountTo, String.class);
    addCustomField("billCycleDay", billCycleDay, String.class);
    addCustomField("billCycleType", billCycleType, String.class);
    addCustomField("billingPeriod", billingPeriod, String.class);
    addCustomField("billingPeriodAlignment", billingPeriodAlignment, String.class);
    addCustomField("billingTiming", billingTiming, String.class);
    addCustomField("description", description, String.class);
    addCustomField("discountAmount", discountAmount, String.class);
    addCustomField("discountLevel", discountLevel, String.class);
    addCustomField("discountPercentage", discountPercentage, String.class);
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("includedUnits", includedUnits, String.class);
    addCustomField("listPriceBase", listPriceBase, String.class);
    addCustomField("number", number, String.class);
    addCustomField("numberOfPeriods", numberOfPeriods, Integer.class);
    addCustomField("overagePrice", overagePrice, String.class);
    addCustomField("overageUnusedUnitsCreditOption", overageUnusedUnitsCreditOption, String.class);
    addCustomField("price", price, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratingGroup", ratingGroup, String.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("specificEndDate", specificEndDate, String.class);
    addCustomField("tiers", tiers, List.class);
    addCustomField("triggerDate", triggerDate, String.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
    addCustomField("unusedUnitsCreditRates", unusedUnitsCreditRates, String.class);
    addCustomField("upToPeriods", upToPeriods, Integer.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
    addCustomField("weeklyBillCycleDay", weeklyBillCycleDay, String.class);
  }
}

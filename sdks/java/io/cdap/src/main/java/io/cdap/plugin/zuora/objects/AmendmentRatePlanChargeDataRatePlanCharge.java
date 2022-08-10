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
* Object name: AmendmentRatePlanChargeDataRatePlanCharge (AmendmentRatePlanChargeDataRatePlanCharge).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AmendmentRatePlanChargeDataRatePlanCharge",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AmendmentRatePlanChargeDataRatePlanCharge extends BaseObject {
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
  * Name: BillingTiming (BillingTiming), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingTiming")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingTiming;

  /**
  * Name: ChargeNumber (ChargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: DiscountAmount (DiscountAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountAmount;

  /**
  * Name: DiscountPercentage (DiscountPercentage), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountPercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountPercentage;

  /**
  * Name: EndDateCondition (EndDateCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /**
  * Name: ListPriceBase (ListPriceBase), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("listPriceBase")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String listPriceBase;

  /**
  * Name: Price (Price), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
  * Name: PriceChangeOption (PriceChangeOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;

  /**
  * Name: PriceIncreasePercentage (PriceIncreasePercentage), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceIncreasePercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceIncreasePercentage;

  /**
  * Name: ProductRatePlanChargeId (ProductRatePlanChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
  * Name: Quantity (Quantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: RatingGroup (RatingGroup), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratingGroup")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratingGroup;

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
  * Name: SpecificBillingPeriod (SpecificBillingPeriod), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
  * Name: SpecificEndDate (SpecificEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String specificEndDate;

  /**
  * Name: TriggerDate (TriggerDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerDate;

  /**
  * Name: TriggerEvent (TriggerEvent), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerEvent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerEvent;

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
  * Name: WeeklyBillCycleDay (WeeklyBillCycleDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("weeklyBillCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String weeklyBillCycleDay;


  @Override
  public void addFields() {
    addCustomField("billCycleType", billCycleType, String.class);
    addCustomField("billingPeriod", billingPeriod, String.class);
    addCustomField("billingTiming", billingTiming, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("discountAmount", discountAmount, String.class);
    addCustomField("discountPercentage", discountPercentage, String.class);
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("listPriceBase", listPriceBase, String.class);
    addCustomField("price", price, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratingGroup", ratingGroup, String.class);
    addCustomField("revRecCode", revRecCode, String.class);
    addCustomField("revRecTriggerCondition", revRecTriggerCondition, String.class);
    addCustomField("revenueRecognitionRuleName", revenueRecognitionRuleName, String.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("specificEndDate", specificEndDate, String.class);
    addCustomField("triggerDate", triggerDate, String.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
    addCustomField("upToPeriods", upToPeriods, Integer.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
    addCustomField("weeklyBillCycleDay", weeklyBillCycleDay, String.class);
  }
}

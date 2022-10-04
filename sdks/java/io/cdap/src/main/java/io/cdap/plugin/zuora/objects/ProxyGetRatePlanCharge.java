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

/** Object name: ProxyGetRatePlanCharge (ProxyGetRatePlanCharge). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyGetRatePlanCharge",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyGetRatePlanCharge extends BaseObject {
  /**
   * Name: AccountingCode (AccountingCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /**
   * Name: ApplyDiscountTo (ApplyDiscountTo), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("applyDiscountTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyDiscountTo;

  /**
   * Name: BillCycleDay (BillCycleDay), Type: integer. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer billCycleDay;

  /**
   * Name: BillCycleType (BillCycleType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleType;

  /**
   * Name: BillingPeriod (BillingPeriod), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriod;

  /**
   * Name: BillingPeriodAlignment (BillingPeriodAlignment), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("billingPeriodAlignment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriodAlignment;

  /**
   * Name: BillingTiming (BillingTiming), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billingTiming")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingTiming;

  /**
   * Name: ChargeModel (ChargeModel), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("chargeModel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeModel;

  /**
   * Name: ChargeNumber (ChargeNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
   * Name: ChargeType (ChargeType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("chargeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeType;

  /**
   * Name: ChargedThroughDate (ChargedThroughDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("chargedThroughDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargedThroughDate;

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

  /** Name: DMRC (DMRC), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dMRC")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dMRC;

  /** Name: DTCV (DTCV), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dTCV")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dTCV;

  /**
   * Name: Description (Description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: DiscountLevel (DiscountLevel), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("discountLevel")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountLevel;

  /**
   * Name: EffectiveEndDate (EffectiveEndDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveEndDate;

  /**
   * Name: EffectiveStartDate (EffectiveStartDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveStartDate;

  /**
   * Name: EndDateCondition (EndDateCondition), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /** Name: Id (Id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: IsLastSegment (IsLastSegment), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("isLastSegment")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isLastSegment;

  /**
   * Name: ListPriceBase (ListPriceBase), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("listPriceBase")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String listPriceBase;

  /** Name: MRR (MRR), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("mRR")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mRR;

  /** Name: Name (Name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: NumberOfPeriods (NumberOfPeriods), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("numberOfPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPeriods;

  /**
   * Name: OriginalId (OriginalId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("originalId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalId;

  /**
   * Name: OverageCalculationOption (OverageCalculationOption), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("overageCalculationOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageCalculationOption;

  /**
   * Name: OverageUnusedUnitsCreditOption (OverageUnusedUnitsCreditOption), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("overageUnusedUnitsCreditOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overageUnusedUnitsCreditOption;

  /**
   * Name: PriceChangeOption (PriceChangeOption), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;

  /**
   * Name: PriceIncreasePercentage (PriceIncreasePercentage), Type: number. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("priceIncreasePercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceIncreasePercentage;

  /**
   * Name: ProcessedThroughDate (ProcessedThroughDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("processedThroughDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String processedThroughDate;

  /**
   * Name: Quantity (Quantity), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
   * Name: RatePlanId (RatePlanId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("ratePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanId;

  /**
   * Name: RevRecCode (RevRecCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("revRecCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecCode;

  /**
   * Name: RevRecTriggerCondition (RevRecTriggerCondition), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("revRecTriggerCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecTriggerCondition;

  /**
   * Name: RevenueRecognitionRuleName (RevenueRecognitionRuleName), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("revenueRecognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueRecognitionRuleName;

  /**
   * Name: Segment (Segment), Type: integer. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("segment")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer segment;

  /**
   * Name: SpecificBillingPeriod (SpecificBillingPeriod), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
   * Name: SpecificEndDate (SpecificEndDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("specificEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String specificEndDate;

  /** Name: TCV (TCV), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tCV")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tCV;

  /**
   * Name: TriggerDate (TriggerDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("triggerDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerDate;

  /**
   * Name: TriggerEvent (TriggerEvent), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("triggerEvent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String triggerEvent;

  /** Name: UOM (UOM), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("uOM")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uOM;

  /**
   * Name: UpToPeriods (UpToPeriods), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("upToPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer upToPeriods;

  /**
   * Name: UpToPeriodsType (UpToPeriodsType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("upToPeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String upToPeriodsType;

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

  /**
   * Name: Version (Version), Type: integer. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("version")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer version;

  /**
   * Name: WeeklyBillCycleDay (WeeklyBillCycleDay), Type: string. Options (custom, update, select):
   * false, false, false
   */
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
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("chargeType", chargeType, String.class);
    addCustomField("chargedThroughDate", chargedThroughDate, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("dMRC", dMRC, String.class);
    addCustomField("dTCV", dTCV, String.class);
    addCustomField("description", description, String.class);
    addCustomField("discountLevel", discountLevel, String.class);
    addCustomField("effectiveEndDate", effectiveEndDate, String.class);
    addCustomField("effectiveStartDate", effectiveStartDate, String.class);
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("id", id, String.class);
    addCustomField("isLastSegment", isLastSegment, Boolean.class);
    addCustomField("listPriceBase", listPriceBase, String.class);
    addCustomField("mRR", mRR, String.class);
    addCustomField("name", name, String.class);
    addCustomField("numberOfPeriods", numberOfPeriods, Integer.class);
    addCustomField("originalId", originalId, String.class);
    addCustomField("overageCalculationOption", overageCalculationOption, String.class);
    addCustomField("overageUnusedUnitsCreditOption", overageUnusedUnitsCreditOption, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("processedThroughDate", processedThroughDate, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratePlanId", ratePlanId, String.class);
    addCustomField("revRecCode", revRecCode, String.class);
    addCustomField("revRecTriggerCondition", revRecTriggerCondition, String.class);
    addCustomField("revenueRecognitionRuleName", revenueRecognitionRuleName, String.class);
    addCustomField("segment", segment, Integer.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("specificEndDate", specificEndDate, String.class);
    addCustomField("tCV", tCV, String.class);
    addCustomField("triggerDate", triggerDate, String.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
    addCustomField("uOM", uOM, String.class);
    addCustomField("upToPeriods", upToPeriods, Integer.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
    addCustomField("version", version, Integer.class);
    addCustomField("weeklyBillCycleDay", weeklyBillCycleDay, String.class);
  }
}

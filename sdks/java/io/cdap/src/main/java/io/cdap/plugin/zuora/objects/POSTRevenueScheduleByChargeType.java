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
 * Object name: POSTRevenueScheduleByChargeType (POSTRevenueScheduleByChargeType). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTRevenueScheduleByChargeType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTRevenueScheduleByChargeType extends BaseObject {
  /** Name: amount (amount), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: deferredRevenueAccountingCode (deferredRevenueAccountingCode), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("deferredRevenueAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deferredRevenueAccountingCode;

  /**
   * Name: deferredRevenueAccountingCodeType (deferredRevenueAccountingCodeType), Type: string.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("deferredRevenueAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deferredRevenueAccountingCodeType;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
   * Name: overrideChargeAccountingCodes (overrideChargeAccountingCodes), Type: boolean. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("overrideChargeAccountingCodes")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean overrideChargeAccountingCodes;

  /**
   * Name: recognizedRevenueAccountingCode (recognizedRevenueAccountingCode), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("recognizedRevenueAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenueAccountingCode;

  /**
   * Name: recognizedRevenueAccountingCodeType (recognizedRevenueAccountingCodeType), Type: string.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("recognizedRevenueAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenueAccountingCodeType;

  /**
   * Name: referenceId (referenceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
   * Name: revenueDistributions (revenueDistributions), Type: array|POSTDistributionItemType.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("revenueDistributions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTDistributionItemType")
  private List<POSTDistributionItemType> revenueDistributions;

  /**
   * Name: revenueScheduleDate (revenueScheduleDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("revenueScheduleDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueScheduleDate;

  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("deferredRevenueAccountingCode", deferredRevenueAccountingCode, String.class);
    addCustomField(
        "deferredRevenueAccountingCodeType", deferredRevenueAccountingCodeType, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("overrideChargeAccountingCodes", overrideChargeAccountingCodes, Boolean.class);
    addCustomField(
        "recognizedRevenueAccountingCode", recognizedRevenueAccountingCode, String.class);
    addCustomField(
        "recognizedRevenueAccountingCodeType", recognizedRevenueAccountingCodeType, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("revenueDistributions", revenueDistributions, List.class);
    addCustomField("revenueScheduleDate", revenueScheduleDate, String.class);
  }
}

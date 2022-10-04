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

/**
 * Object name: CreateOrderChargeOverrideBillingItem (CreateOrderChargeOverrideBillingItem). Related
 * objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CreateOrderChargeOverrideBillingItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class CreateOrderChargeOverrideBillingItem extends BaseObject {
  /**
   * Name: billCycleDay (billCycleDay), Type: integer. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer billCycleDay;

  /**
   * Name: billCycleType (billCycleType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleType;

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
   * Name: specificBillingPeriod (specificBillingPeriod), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("specificBillingPeriod")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer specificBillingPeriod;

  /**
   * Name: weeklyBillCycleDay (weeklyBillCycleDay), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("weeklyBillCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String weeklyBillCycleDay;

  @Override
  public void addFields() {
    addCustomField("billCycleDay", billCycleDay, Integer.class);
    addCustomField("billCycleType", billCycleType, String.class);
    addCustomField("billingPeriod", billingPeriod, String.class);
    addCustomField("billingPeriodAlignment", billingPeriodAlignment, String.class);
    addCustomField("billingTiming", billingTiming, String.class);
    addCustomField("specificBillingPeriod", specificBillingPeriod, Integer.class);
    addCustomField("weeklyBillCycleDay", weeklyBillCycleDay, String.class);
  }
}

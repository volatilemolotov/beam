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

/** Object name: PUTScUpdateType (PUTScUpdateType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTScUpdateType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTScUpdateType extends BaseObject {
  /**
   * Name: billingPeriodAlignment (billingPeriodAlignment), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("billingPeriodAlignment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingPeriodAlignment;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: includedUnits (includedUnits), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("includedUnits")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String includedUnits;

  /**
   * Name: overagePrice (overagePrice), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("overagePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overagePrice;

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
   * Name: quantity (quantity), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
   * Name: ratePlanChargeId (ratePlanChargeId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("ratePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanChargeId;

  /**
   * Name: tiers (tiers), Type: array|POSTTierType. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("tiers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTTierType")
  private List<POSTTierType> tiers;

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

  @Override
  public void addFields() {
    addCustomField("billingPeriodAlignment", billingPeriodAlignment, String.class);
    addCustomField("description", description, String.class);
    addCustomField("includedUnits", includedUnits, String.class);
    addCustomField("overagePrice", overagePrice, String.class);
    addCustomField("price", price, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
    addCustomField("priceIncreasePercentage", priceIncreasePercentage, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratePlanChargeId", ratePlanChargeId, String.class);
    addCustomField("tiers", tiers, List.class);
    addCustomField("triggerDate", triggerDate, String.class);
    addCustomField("triggerEvent", triggerEvent, String.class);
  }
}

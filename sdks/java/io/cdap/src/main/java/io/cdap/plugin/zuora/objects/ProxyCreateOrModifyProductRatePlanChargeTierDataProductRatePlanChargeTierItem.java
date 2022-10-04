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
 * Object name: ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierItem
 * (ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierItem). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierItem
    extends BaseObject {
  /**
   * Name: Currency (Currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: DiscountAmount (DiscountAmount), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("discountAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountAmount;

  /**
   * Name: DiscountPercentage (DiscountPercentage), Type: number. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("discountPercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountPercentage;

  /**
   * Name: EndingUnit (EndingUnit), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("endingUnit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endingUnit;

  /**
   * Name: IsOveragePrice (IsOveragePrice), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("isOveragePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isOveragePrice;

  /** Name: Price (Price), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
   * Name: PriceFormat (PriceFormat), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("priceFormat")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceFormat;

  /**
   * Name: StartingUnit (StartingUnit), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("startingUnit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startingUnit;

  @Override
  public void addFields() {
    addCustomField("currency", currency, String.class);
    addCustomField("discountAmount", discountAmount, String.class);
    addCustomField("discountPercentage", discountPercentage, String.class);
    addCustomField("endingUnit", endingUnit, String.class);
    addCustomField("isOveragePrice", isOveragePrice, Boolean.class);
    addCustomField("price", price, String.class);
    addCustomField("priceFormat", priceFormat, String.class);
    addCustomField("startingUnit", startingUnit, String.class);
  }
}

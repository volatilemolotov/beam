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
* Object name: ProductRatePlanChargePricingType (ProductRatePlanChargePricingType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProductRatePlanChargePricingType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProductRatePlanChargePricingType extends BaseObject {
  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: discountAmount (discountAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountAmount;

  /**
  * Name: discountPercentage (discountPercentage), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("discountPercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountPercentage;

  /**
  * Name: includedUnits (includedUnits), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includedUnits")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String includedUnits;

  /**
  * Name: overagePrice (overagePrice), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("overagePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String overagePrice;

  /**
  * Name: price (price), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
  * Name: tiers (tiers), Type: array|ProductRatePlanChargePricingTierType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tiers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ProductRatePlanChargePricingTierType")
  private List<ProductRatePlanChargePricingTierType> tiers;


  @Override
  public void addFields() {
    addCustomField("currency", currency, String.class);
    addCustomField("discountAmount", discountAmount, String.class);
    addCustomField("discountPercentage", discountPercentage, String.class);
    addCustomField("includedUnits", includedUnits, String.class);
    addCustomField("overagePrice", overagePrice, String.class);
    addCustomField("price", price, String.class);
    addCustomField("tiers", tiers, List.class);
  }
}

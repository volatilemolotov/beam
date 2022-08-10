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
* Object name: DiscountPricingOverride (DiscountPricingOverride).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "DiscountPricingOverride",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class DiscountPricingOverride extends BaseObject {
  /**
  * Name: applyDiscountTo (applyDiscountTo), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyDiscountTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyDiscountTo;

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
  * Name: priceChangeOption (priceChangeOption), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceChangeOption")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceChangeOption;


  @Override
  public void addFields() {
    addCustomField("applyDiscountTo", applyDiscountTo, String.class);
    addCustomField("discountAmount", discountAmount, String.class);
    addCustomField("discountLevel", discountLevel, String.class);
    addCustomField("discountPercentage", discountPercentage, String.class);
    addCustomField("priceChangeOption", priceChangeOption, String.class);
  }
}

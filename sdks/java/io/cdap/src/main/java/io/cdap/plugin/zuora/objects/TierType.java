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
* Object name: TierType (TierType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "TierType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class TierType extends BaseObject {
  /**
  * Name: endingUnit (endingUnit), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endingUnit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endingUnit;

  /**
  * Name: price (price), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
  * Name: priceFormat (priceFormat), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("priceFormat")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceFormat;

  /**
  * Name: startingUnit (startingUnit), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startingUnit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startingUnit;

  /**
  * Name: tier (tier), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tier")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer tier;


  @Override
  public void addFields() {
    addCustomField("endingUnit", endingUnit, String.class);
    addCustomField("price", price, String.class);
    addCustomField("priceFormat", priceFormat, String.class);
    addCustomField("startingUnit", startingUnit, String.class);
    addCustomField("tier", tier, Integer.class);
  }
}

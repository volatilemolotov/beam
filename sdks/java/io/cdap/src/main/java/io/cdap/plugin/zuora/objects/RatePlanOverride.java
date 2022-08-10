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
* Object name: RatePlanOverride (RatePlanOverride).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "RatePlanOverride",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class RatePlanOverride extends BaseObject {
  /**
  * Name: chargeOverrides (chargeOverrides), Type: array|ChargeOverride.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeOverrides")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ChargeOverride")
  private List<ChargeOverride> chargeOverrides;

  /**
  * Name: newRatePlanId (newRatePlanId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("newRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String newRatePlanId;

  /**
  * Name: productRatePlanId (productRatePlanId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /**
  * Name: uniqueToken (uniqueToken), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uniqueToken")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uniqueToken;


  @Override
  public void addFields() {
    addCustomField("chargeOverrides", chargeOverrides, List.class);
    addCustomField("newRatePlanId", newRatePlanId, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("uniqueToken", uniqueToken, String.class);
  }
}

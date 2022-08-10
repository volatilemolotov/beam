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
* Object name: OrderForEvergreenSubscriptionsItem (OrderForEvergreenSubscriptionsItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "OrderForEvergreenSubscriptionsItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class OrderForEvergreenSubscriptionsItem extends BaseObject {
  /**
  * Name: baseVersion (baseVersion), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("baseVersion")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer baseVersion;

  /**
  * Name: newVersion (newVersion), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("newVersion")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer newVersion;

  /**
  * Name: orderActions (orderActions), Type: array|OrderActionForEvergreen.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderActions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "OrderActionForEvergreen")
  private List<OrderActionForEvergreen> orderActions;

  /**
  * Name: sequence (sequence), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sequence")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer sequence;

  /**
  * Name: subscriptionNumber (subscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;


  @Override
  public void addFields() {
    addCustomField("baseVersion", baseVersion, Integer.class);
    addCustomField("newVersion", newVersion, Integer.class);
    addCustomField("orderActions", orderActions, List.class);
    addCustomField("sequence", sequence, Integer.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
  }
}

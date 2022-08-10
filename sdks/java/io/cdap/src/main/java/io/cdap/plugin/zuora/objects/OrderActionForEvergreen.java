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
* Object name: OrderActionForEvergreen (OrderActionForEvergreen).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "OrderActionForEvergreen",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class OrderActionForEvergreen extends BaseObject {
  /**
  * Name: orderMetrics (orderMetrics), Type: array|OrderMetricsForEvergreen.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderMetrics")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "OrderMetricsForEvergreen")
  private List<OrderMetricsForEvergreen> orderMetrics;

  /**
  * Name: sequence (sequence), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sequence")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer sequence;

  /**
  * Name: triggerDates (triggerDates), Type: array|TriggerDate.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("triggerDates")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TriggerDate")
  private List<TriggerDate> triggerDates;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;


  @Override
  public void addFields() {
    addCustomField("orderMetrics", orderMetrics, List.class);
    addCustomField("sequence", sequence, Integer.class);
    addCustomField("triggerDates", triggerDates, List.class);
    addCustomField("type", type, String.class);
  }
}

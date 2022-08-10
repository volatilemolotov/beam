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
* Object name: OrderSuspend (OrderSuspend).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "OrderSuspend",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class OrderSuspend extends BaseObject {
  /**
  * Name: suspendDate (suspendDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("suspendDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String suspendDate;

  /**
  * Name: suspendPeriods (suspendPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("suspendPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer suspendPeriods;

  /**
  * Name: suspendPeriodsType (suspendPeriodsType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("suspendPeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String suspendPeriodsType;

  /**
  * Name: suspendPolicy (suspendPolicy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("suspendPolicy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String suspendPolicy;

  /**
  * Name: suspendSpecificDate (suspendSpecificDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("suspendSpecificDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String suspendSpecificDate;


  @Override
  public void addFields() {
    addCustomField("suspendDate", suspendDate, String.class);
    addCustomField("suspendPeriods", suspendPeriods, Integer.class);
    addCustomField("suspendPeriodsType", suspendPeriodsType, String.class);
    addCustomField("suspendPolicy", suspendPolicy, String.class);
    addCustomField("suspendSpecificDate", suspendSpecificDate, String.class);
  }
}

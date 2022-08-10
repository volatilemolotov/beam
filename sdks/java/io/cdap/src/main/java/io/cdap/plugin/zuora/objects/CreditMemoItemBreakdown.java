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
* Object name: CreditMemoItemBreakdown (CreditMemoItemBreakdown).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreditMemoItemBreakdown",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreditMemoItemBreakdown extends BaseObject {
  /**
  * Name: amount (amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: applyToChargeNumber (applyToChargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyToChargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String applyToChargeNumber;

  /**
  * Name: breakdownDetails (breakdownDetails), Type: array|BreakdownDetail.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("breakdownDetails")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "BreakdownDetail")
  private List<BreakdownDetail> breakdownDetails;

  /**
  * Name: chargeNumber (chargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: creditMemoItemId (creditMemoItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditMemoItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoItemId;

  /**
  * Name: endDate (endDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
  * Name: isNegativePrice (isNegativePrice), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("isNegativePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isNegativePrice;

  /**
  * Name: startDate (startDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;

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
    addCustomField("amount", amount, String.class);
    addCustomField("applyToChargeNumber", applyToChargeNumber, String.class);
    addCustomField("breakdownDetails", breakdownDetails, List.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("creditMemoItemId", creditMemoItemId, String.class);
    addCustomField("endDate", endDate, String.class);
    addCustomField("isNegativePrice", isNegativePrice, Boolean.class);
    addCustomField("startDate", startDate, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
  }
}

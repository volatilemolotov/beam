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
* Object name: RevenueItemType (RevenueItemType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "RevenueItemType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class RevenueItemType extends BaseObject {
  /**
  * Name: accountingPeriodEndDate (accountingPeriodEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingPeriodEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingPeriodEndDate;

  /**
  * Name: accountingPeriodName (accountingPeriodName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingPeriodName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingPeriodName;

  /**
  * Name: accountingPeriodStartDate (accountingPeriodStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingPeriodStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingPeriodStartDate;

  /**
  * Name: amount (amount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: isAccountingPeriodClosed (isAccountingPeriodClosed), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("isAccountingPeriodClosed")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isAccountingPeriodClosed;


  @Override
  public void addFields() {
    addCustomField("accountingPeriodEndDate", accountingPeriodEndDate, String.class);
    addCustomField("accountingPeriodName", accountingPeriodName, String.class);
    addCustomField("accountingPeriodStartDate", accountingPeriodStartDate, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("isAccountingPeriodClosed", isAccountingPeriodClosed, Boolean.class);
  }
}

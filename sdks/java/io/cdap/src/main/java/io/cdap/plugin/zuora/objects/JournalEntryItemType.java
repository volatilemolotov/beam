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
* Object name: JournalEntryItemType (JournalEntryItemType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "JournalEntryItemType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class JournalEntryItemType extends BaseObject {
  /**
  * Name: accountingCodeName (accountingCodeName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingCodeName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCodeName;

  /**
  * Name: accountingCodeType (accountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCodeType;

  /**
  * Name: amount (amount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: glAccountName (glAccountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("glAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String glAccountName;

  /**
  * Name: glAccountNumber (glAccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("glAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String glAccountNumber;

  /**
  * Name: homeCurrencyAmount (homeCurrencyAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("homeCurrencyAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String homeCurrencyAmount;

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
    addCustomField("accountingCodeName", accountingCodeName, String.class);
    addCustomField("accountingCodeType", accountingCodeType, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("glAccountName", glAccountName, String.class);
    addCustomField("glAccountNumber", glAccountNumber, String.class);
    addCustomField("homeCurrencyAmount", homeCurrencyAmount, String.class);
    addCustomField("type", type, String.class);
  }
}

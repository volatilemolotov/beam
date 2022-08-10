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
* Object name: AccountSummaryTypeBasicInfoDefaultPaymentMethodItem (AccountSummaryTypeBasicInfoDefaultPaymentMethodItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountSummaryTypeBasicInfoDefaultPaymentMethodItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountSummaryTypeBasicInfoDefaultPaymentMethodItem extends BaseObject {
  /**
  * Name: creditCardExpirationMonth (creditCardExpirationMonth), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardExpirationMonth")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardExpirationMonth;

  /**
  * Name: creditCardExpirationYear (creditCardExpirationYear), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardExpirationYear")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardExpirationYear;

  /**
  * Name: creditCardNumber (creditCardNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardNumber;

  /**
  * Name: creditCardType (creditCardType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardType;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: paymentMethodType (paymentMethodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodType;


  @Override
  public void addFields() {
    addCustomField("creditCardExpirationMonth", creditCardExpirationMonth, String.class);
    addCustomField("creditCardExpirationYear", creditCardExpirationYear, String.class);
    addCustomField("creditCardNumber", creditCardNumber, String.class);
    addCustomField("creditCardType", creditCardType, String.class);
    addCustomField("id", id, String.class);
    addCustomField("paymentMethodType", paymentMethodType, String.class);
  }
}

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
* Object name: AccountTypeBillingAndPaymentItem (AccountTypeBillingAndPaymentItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountTypeBillingAndPaymentItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountTypeBillingAndPaymentItem extends BaseObject {
  /**
  * Name: additionalEmailAddresses (additionalEmailAddresses), Type: array|AccountTypeBillingAndPaymentItemAdditionalEmailAddressesItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("additionalEmailAddresses")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AccountTypeBillingAndPaymentItemAdditionalEmailAddressesItem")
  private List<AccountTypeBillingAndPaymentItemAdditionalEmailAddressesItem> additionalEmailAddresses;

  /**
  * Name: billCycleDay (billCycleDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleDay;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: invoiceDeliveryPrefsEmail (invoiceDeliveryPrefsEmail), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDeliveryPrefsEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceDeliveryPrefsEmail;

  /**
  * Name: invoiceDeliveryPrefsPrint (invoiceDeliveryPrefsPrint), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDeliveryPrefsPrint")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceDeliveryPrefsPrint;

  /**
  * Name: paymentGateway (paymentGateway), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentGateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentGateway;

  /**
  * Name: paymentTerm (paymentTerm), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentTerm;


  @Override
  public void addFields() {
    addCustomField("additionalEmailAddresses", additionalEmailAddresses, List.class);
    addCustomField("billCycleDay", billCycleDay, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("invoiceDeliveryPrefsEmail", invoiceDeliveryPrefsEmail, Boolean.class);
    addCustomField("invoiceDeliveryPrefsPrint", invoiceDeliveryPrefsPrint, Boolean.class);
    addCustomField("paymentGateway", paymentGateway, String.class);
    addCustomField("paymentTerm", paymentTerm, String.class);
  }
}

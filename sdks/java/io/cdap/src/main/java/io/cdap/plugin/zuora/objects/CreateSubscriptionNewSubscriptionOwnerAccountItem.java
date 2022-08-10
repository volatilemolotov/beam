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
* Object name: CreateSubscriptionNewSubscriptionOwnerAccountItem (CreateSubscriptionNewSubscriptionOwnerAccountItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreateSubscriptionNewSubscriptionOwnerAccountItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreateSubscriptionNewSubscriptionOwnerAccountItem extends BaseObject {
  /**
  * Name: accountNumber (accountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: autoPay (autoPay), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoPay")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoPay;

  /**
  * Name: batch (batch), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
  * Name: billCycleDay (billCycleDay), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer billCycleDay;

  /**
  * Name: communicationProfileId (communicationProfileId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("communicationProfileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String communicationProfileId;

  /**
  * Name: crmId (crmId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("crmId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String crmId;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: hpmCreditCardPaymentMethodId (hpmCreditCardPaymentMethodId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("hpmCreditCardPaymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String hpmCreditCardPaymentMethodId;

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
  * Name: invoiceTemplateId (invoiceTemplateId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceTemplateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTemplateId;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: parentId (parentId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("parentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String parentId;

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
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("autoPay", autoPay, Boolean.class);
    addCustomField("batch", batch, String.class);
    addCustomField("billCycleDay", billCycleDay, Integer.class);
    addCustomField("communicationProfileId", communicationProfileId, String.class);
    addCustomField("crmId", crmId, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("hpmCreditCardPaymentMethodId", hpmCreditCardPaymentMethodId, String.class);
    addCustomField("invoiceDeliveryPrefsEmail", invoiceDeliveryPrefsEmail, Boolean.class);
    addCustomField("invoiceDeliveryPrefsPrint", invoiceDeliveryPrefsPrint, Boolean.class);
    addCustomField("invoiceTemplateId", invoiceTemplateId, String.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("parentId", parentId, String.class);
    addCustomField("paymentGateway", paymentGateway, String.class);
    addCustomField("paymentTerm", paymentTerm, String.class);
  }
}

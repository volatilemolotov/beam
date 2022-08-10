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
* Object name: CreatePaymentMethodCreditCard (CreatePaymentMethodCreditCard).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreatePaymentMethodCreditCard",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreatePaymentMethodCreditCard extends BaseObject {
  /**
  * Name: cardNumber (cardNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cardNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardNumber;

  /**
  * Name: cardType (cardType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cardType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardType;

  /**
  * Name: expirationMonth (expirationMonth), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("expirationMonth")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String expirationMonth;

  /**
  * Name: expirationYear (expirationYear), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("expirationYear")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String expirationYear;

  /**
  * Name: mitConsentAgreementRef (mitConsentAgreementRef), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mitConsentAgreementRef")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitConsentAgreementRef;

  /**
  * Name: mitConsentAgreementSrc (mitConsentAgreementSrc), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mitConsentAgreementSrc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitConsentAgreementSrc;

  /**
  * Name: mitNetworkTransactionId (mitNetworkTransactionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mitNetworkTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitNetworkTransactionId;

  /**
  * Name: mitProfileAction (mitProfileAction), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mitProfileAction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitProfileAction;

  /**
  * Name: mitProfileAgreedOn (mitProfileAgreedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mitProfileAgreedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitProfileAgreedOn;

  /**
  * Name: mitProfileType (mitProfileType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mitProfileType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitProfileType;

  /**
  * Name: securityCode (securityCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("securityCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String securityCode;


  @Override
  public void addFields() {
    addCustomField("cardNumber", cardNumber, String.class);
    addCustomField("cardType", cardType, String.class);
    addCustomField("expirationMonth", expirationMonth, String.class);
    addCustomField("expirationYear", expirationYear, String.class);
    addCustomField("mitConsentAgreementRef", mitConsentAgreementRef, String.class);
    addCustomField("mitConsentAgreementSrc", mitConsentAgreementSrc, String.class);
    addCustomField("mitNetworkTransactionId", mitNetworkTransactionId, String.class);
    addCustomField("mitProfileAction", mitProfileAction, String.class);
    addCustomField("mitProfileAgreedOn", mitProfileAgreedOn, String.class);
    addCustomField("mitProfileType", mitProfileType, String.class);
    addCustomField("securityCode", securityCode, String.class);
  }
}

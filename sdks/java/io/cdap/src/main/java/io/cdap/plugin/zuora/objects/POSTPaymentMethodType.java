/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import javax.annotation.Nullable;

/** Object name: POSTPaymentMethodType (POSTPaymentMethodType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTPaymentMethodType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTPaymentMethodType extends BaseObject {
  /**
   * Name: accountKey (accountKey), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountKey;

  /**
   * Name: creditCardNumber (creditCardNumber), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("creditCardNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardNumber;

  /**
   * Name: creditCardType (creditCardType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("creditCardType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardType;

  /**
   * Name: defaultPaymentMethod (defaultPaymentMethod), Type: boolean. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("defaultPaymentMethod")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean defaultPaymentMethod;

  /**
   * Name: expirationMonth (expirationMonth), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("expirationMonth")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String expirationMonth;

  /**
   * Name: expirationYear (expirationYear), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("expirationYear")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String expirationYear;

  /**
   * Name: mitConsentAgreementRef (mitConsentAgreementRef), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("mitConsentAgreementRef")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitConsentAgreementRef;

  /**
   * Name: mitConsentAgreementSrc (mitConsentAgreementSrc), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("mitConsentAgreementSrc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitConsentAgreementSrc;

  /**
   * Name: mitNetworkTransactionId (mitNetworkTransactionId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("mitNetworkTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitNetworkTransactionId;

  /**
   * Name: mitProfileAction (mitProfileAction), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("mitProfileAction")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitProfileAction;

  /**
   * Name: mitProfileAgreedOn (mitProfileAgreedOn), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("mitProfileAgreedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitProfileAgreedOn;

  /**
   * Name: mitProfileType (mitProfileType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("mitProfileType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mitProfileType;

  /**
   * Name: numConsecutiveFailures (numConsecutiveFailures), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("numConsecutiveFailures")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numConsecutiveFailures;

  /**
   * Name: securityCode (securityCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("securityCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String securityCode;

  @Override
  public void addFields() {
    addCustomField("accountKey", accountKey, String.class);
    addCustomField("creditCardNumber", creditCardNumber, String.class);
    addCustomField("creditCardType", creditCardType, String.class);
    addCustomField("defaultPaymentMethod", defaultPaymentMethod, Boolean.class);
    addCustomField("expirationMonth", expirationMonth, String.class);
    addCustomField("expirationYear", expirationYear, String.class);
    addCustomField("mitConsentAgreementRef", mitConsentAgreementRef, String.class);
    addCustomField("mitConsentAgreementSrc", mitConsentAgreementSrc, String.class);
    addCustomField("mitNetworkTransactionId", mitNetworkTransactionId, String.class);
    addCustomField("mitProfileAction", mitProfileAction, String.class);
    addCustomField("mitProfileAgreedOn", mitProfileAgreedOn, String.class);
    addCustomField("mitProfileType", mitProfileType, String.class);
    addCustomField("numConsecutiveFailures", numConsecutiveFailures, Integer.class);
    addCustomField("securityCode", securityCode, String.class);
  }
}

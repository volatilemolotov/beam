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
* Object name: ProxyModifyPaymentMethod (ProxyModifyPaymentMethod).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyModifyPaymentMethod",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyModifyPaymentMethod extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AchAbaCode (AchAbaCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAbaCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAbaCode;

  /**
  * Name: AchAccountName (AchAccountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAccountName;

  /**
  * Name: AchAccountType (AchAccountType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAccountType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAccountType;

  /**
  * Name: AchAddress1 (AchAddress1), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAddress1")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAddress1;

  /**
  * Name: AchAddress2 (AchAddress2), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAddress2")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAddress2;

  /**
  * Name: AchBankName (AchBankName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achBankName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achBankName;

  /**
  * Name: AchCity (AchCity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achCity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achCity;

  /**
  * Name: AchCountry (AchCountry), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achCountry")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achCountry;

  /**
  * Name: AchPostalCode (AchPostalCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achPostalCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achPostalCode;

  /**
  * Name: AchState (AchState), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achState;

  /**
  * Name: BankBranchCode (BankBranchCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankBranchCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankBranchCode;

  /**
  * Name: BankCheckDigit (BankCheckDigit), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankCheckDigit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankCheckDigit;

  /**
  * Name: BankTransferType (BankTransferType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankTransferType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankTransferType;

  /**
  * Name: BusinessIdentificationCode (BusinessIdentificationCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("businessIdentificationCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String businessIdentificationCode;

  /**
  * Name: City (City), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("city")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String city;

  /**
  * Name: CompanyName (CompanyName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("companyName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String companyName;

  /**
  * Name: Country (Country), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("country")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String country;

  /**
  * Name: CreditCardAddress1 (CreditCardAddress1), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardAddress1")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardAddress1;

  /**
  * Name: CreditCardAddress2 (CreditCardAddress2), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardAddress2")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardAddress2;

  /**
  * Name: CreditCardCity (CreditCardCity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardCity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardCity;

  /**
  * Name: CreditCardCountry (CreditCardCountry), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardCountry")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardCountry;

  /**
  * Name: CreditCardExpirationMonth (CreditCardExpirationMonth), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardExpirationMonth")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer creditCardExpirationMonth;

  /**
  * Name: CreditCardExpirationYear (CreditCardExpirationYear), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardExpirationYear")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer creditCardExpirationYear;

  /**
  * Name: CreditCardHolderName (CreditCardHolderName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardHolderName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardHolderName;

  /**
  * Name: CreditCardPostalCode (CreditCardPostalCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardPostalCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardPostalCode;

  /**
  * Name: CreditCardSecurityCode (CreditCardSecurityCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardSecurityCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardSecurityCode;

  /**
  * Name: CreditCardState (CreditCardState), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardState;

  /**
  * Name: CreditCardType (CreditCardType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardType;

  /**
  * Name: DeviceSessionId (DeviceSessionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("deviceSessionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deviceSessionId;

  /**
  * Name: Email (Email), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("email")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String email;

  /**
  * Name: ExistingMandate (ExistingMandate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("existingMandate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String existingMandate;

  /**
  * Name: FirstName (FirstName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("firstName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String firstName;

  /**
  * Name: IBAN (IBAN), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("iBAN")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String iBAN;

  /**
  * Name: IPAddress (IPAddress), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("iPAddress")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String iPAddress;

  /**
  * Name: IdentityNumber (IdentityNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("identityNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String identityNumber;

  /**
  * Name: IsCompany (IsCompany), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("isCompany")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isCompany;

  /**
  * Name: LastName (LastName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("lastName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastName;

  /**
  * Name: LastTransactionDateTime (LastTransactionDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("lastTransactionDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastTransactionDateTime;

  /**
  * Name: MandateCreationDate (MandateCreationDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mandateCreationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mandateCreationDate;

  /**
  * Name: MandateID (MandateID), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mandateID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mandateID;

  /**
  * Name: MandateReceived (MandateReceived), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mandateReceived")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mandateReceived;

  /**
  * Name: MandateUpdateDate (MandateUpdateDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("mandateUpdateDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mandateUpdateDate;

  /**
  * Name: MaxConsecutivePaymentFailures (MaxConsecutivePaymentFailures), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("maxConsecutivePaymentFailures")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer maxConsecutivePaymentFailures;

  /**
  * Name: NumConsecutiveFailures (NumConsecutiveFailures), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numConsecutiveFailures")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numConsecutiveFailures;

  /**
  * Name: PaymentMethodStatus (PaymentMethodStatus), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodStatus;

  /**
  * Name: PaymentRetryWindow (PaymentRetryWindow), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentRetryWindow")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer paymentRetryWindow;

  /**
  * Name: Phone (Phone), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("phone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String phone;

  /**
  * Name: PostalCode (PostalCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("postalCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postalCode;

  /**
  * Name: SecondTokenId (SecondTokenId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("secondTokenId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondTokenId;

  /**
  * Name: State (State), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("state")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String state;

  /**
  * Name: StreetName (StreetName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("streetName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String streetName;

  /**
  * Name: StreetNumber (StreetNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("streetNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String streetNumber;

  /**
  * Name: UseDefaultRetryRule (UseDefaultRetryRule), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("useDefaultRetryRule")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean useDefaultRetryRule;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("achAbaCode", achAbaCode, String.class);
    addCustomField("achAccountName", achAccountName, String.class);
    addCustomField("achAccountType", achAccountType, String.class);
    addCustomField("achAddress1", achAddress1, String.class);
    addCustomField("achAddress2", achAddress2, String.class);
    addCustomField("achBankName", achBankName, String.class);
    addCustomField("achCity", achCity, String.class);
    addCustomField("achCountry", achCountry, String.class);
    addCustomField("achPostalCode", achPostalCode, String.class);
    addCustomField("achState", achState, String.class);
    addCustomField("bankBranchCode", bankBranchCode, String.class);
    addCustomField("bankCheckDigit", bankCheckDigit, String.class);
    addCustomField("bankTransferType", bankTransferType, String.class);
    addCustomField("businessIdentificationCode", businessIdentificationCode, String.class);
    addCustomField("city", city, String.class);
    addCustomField("companyName", companyName, String.class);
    addCustomField("country", country, String.class);
    addCustomField("creditCardAddress1", creditCardAddress1, String.class);
    addCustomField("creditCardAddress2", creditCardAddress2, String.class);
    addCustomField("creditCardCity", creditCardCity, String.class);
    addCustomField("creditCardCountry", creditCardCountry, String.class);
    addCustomField("creditCardExpirationMonth", creditCardExpirationMonth, Integer.class);
    addCustomField("creditCardExpirationYear", creditCardExpirationYear, Integer.class);
    addCustomField("creditCardHolderName", creditCardHolderName, String.class);
    addCustomField("creditCardPostalCode", creditCardPostalCode, String.class);
    addCustomField("creditCardSecurityCode", creditCardSecurityCode, String.class);
    addCustomField("creditCardState", creditCardState, String.class);
    addCustomField("creditCardType", creditCardType, String.class);
    addCustomField("deviceSessionId", deviceSessionId, String.class);
    addCustomField("email", email, String.class);
    addCustomField("existingMandate", existingMandate, String.class);
    addCustomField("firstName", firstName, String.class);
    addCustomField("iBAN", iBAN, String.class);
    addCustomField("iPAddress", iPAddress, String.class);
    addCustomField("identityNumber", identityNumber, String.class);
    addCustomField("isCompany", isCompany, Boolean.class);
    addCustomField("lastName", lastName, String.class);
    addCustomField("lastTransactionDateTime", lastTransactionDateTime, String.class);
    addCustomField("mandateCreationDate", mandateCreationDate, String.class);
    addCustomField("mandateID", mandateID, String.class);
    addCustomField("mandateReceived", mandateReceived, String.class);
    addCustomField("mandateUpdateDate", mandateUpdateDate, String.class);
    addCustomField("maxConsecutivePaymentFailures", maxConsecutivePaymentFailures, Integer.class);
    addCustomField("numConsecutiveFailures", numConsecutiveFailures, Integer.class);
    addCustomField("paymentMethodStatus", paymentMethodStatus, String.class);
    addCustomField("paymentRetryWindow", paymentRetryWindow, Integer.class);
    addCustomField("phone", phone, String.class);
    addCustomField("postalCode", postalCode, String.class);
    addCustomField("secondTokenId", secondTokenId, String.class);
    addCustomField("state", state, String.class);
    addCustomField("streetName", streetName, String.class);
    addCustomField("streetNumber", streetNumber, String.class);
    addCustomField("useDefaultRetryRule", useDefaultRetryRule, Boolean.class);
  }
}

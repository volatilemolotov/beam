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
* Object name: SubscribeRequestPaymentMethodItem (SubscribeRequestPaymentMethodItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "SubscribeRequestPaymentMethodItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class SubscribeRequestPaymentMethodItem extends BaseObject {
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
  * Name: AchAccountNumber (AchAccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAccountNumber;

  /**
  * Name: AchAccountNumberMask (AchAccountNumberMask), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("achAccountNumberMask")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String achAccountNumberMask;

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
  * Name: Active (Active), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("active")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean active;

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
  * Name: BankCity (BankCity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankCity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankCity;

  /**
  * Name: BankCode (BankCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankCode;

  /**
  * Name: BankIdentificationNumber (BankIdentificationNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankIdentificationNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankIdentificationNumber;

  /**
  * Name: BankName (BankName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankName;

  /**
  * Name: BankPostalCode (BankPostalCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankPostalCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankPostalCode;

  /**
  * Name: BankStreetName (BankStreetName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankStreetName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankStreetName;

  /**
  * Name: BankStreetNumber (BankStreetNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankStreetNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankStreetNumber;

  /**
  * Name: BankTransferAccountName (BankTransferAccountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankTransferAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankTransferAccountName;

  /**
  * Name: BankTransferAccountNumber (BankTransferAccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankTransferAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankTransferAccountNumber;

  /**
  * Name: BankTransferAccountNumberMask (BankTransferAccountNumberMask), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankTransferAccountNumberMask")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankTransferAccountNumberMask;

  /**
  * Name: BankTransferAccountType (BankTransferAccountType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankTransferAccountType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankTransferAccountType;

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
  * Name: Country (Country), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("country")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String country;

  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

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
  * Name: CreditCardMaskNumber (CreditCardMaskNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardMaskNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardMaskNumber;

  /**
  * Name: CreditCardNumber (CreditCardNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditCardNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditCardNumber;

  /**
  * Name: CreditCardPostalCode (CreditCardPostalCode), Type: string..
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
  * Name: GatewayOptionData (GatewayOptionData), Type: SubscribeRequestPaymentMethodItemGatewayOptionDataItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayOptionData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOptionData;

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
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: LastFailedSaleTransactionDate (LastFailedSaleTransactionDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("lastFailedSaleTransactionDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastFailedSaleTransactionDate;

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
  * Name: LastTransactionStatus (LastTransactionStatus), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("lastTransactionStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastTransactionStatus;

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
  * Name: Name (Name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

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
  * Name: PaypalBaid (PaypalBaid), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paypalBaid")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paypalBaid;

  /**
  * Name: PaypalEmail (PaypalEmail), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paypalEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paypalEmail;

  /**
  * Name: PaypalPreapprovalKey (PaypalPreapprovalKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paypalPreapprovalKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paypalPreapprovalKey;

  /**
  * Name: PaypalType (PaypalType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paypalType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paypalType;

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
  * Name: SkipValidation (SkipValidation), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("skipValidation")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean skipValidation;

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
  * Name: TokenId (TokenId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tokenId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tokenId;

  /**
  * Name: TotalNumberOfErrorPayments (TotalNumberOfErrorPayments), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalNumberOfErrorPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer totalNumberOfErrorPayments;

  /**
  * Name: TotalNumberOfProcessedPayments (TotalNumberOfProcessedPayments), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalNumberOfProcessedPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer totalNumberOfProcessedPayments;

  /**
  * Name: Type (Type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;

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
    addCustomField("achAccountNumber", achAccountNumber, String.class);
    addCustomField("achAccountNumberMask", achAccountNumberMask, String.class);
    addCustomField("achAccountType", achAccountType, String.class);
    addCustomField("achAddress1", achAddress1, String.class);
    addCustomField("achAddress2", achAddress2, String.class);
    addCustomField("achBankName", achBankName, String.class);
    addCustomField("active", active, Boolean.class);
    addCustomField("bankBranchCode", bankBranchCode, String.class);
    addCustomField("bankCheckDigit", bankCheckDigit, String.class);
    addCustomField("bankCity", bankCity, String.class);
    addCustomField("bankCode", bankCode, String.class);
    addCustomField("bankIdentificationNumber", bankIdentificationNumber, String.class);
    addCustomField("bankName", bankName, String.class);
    addCustomField("bankPostalCode", bankPostalCode, String.class);
    addCustomField("bankStreetName", bankStreetName, String.class);
    addCustomField("bankStreetNumber", bankStreetNumber, String.class);
    addCustomField("bankTransferAccountName", bankTransferAccountName, String.class);
    addCustomField("bankTransferAccountNumber", bankTransferAccountNumber, String.class);
    addCustomField("bankTransferAccountNumberMask", bankTransferAccountNumberMask, String.class);
    addCustomField("bankTransferAccountType", bankTransferAccountType, String.class);
    addCustomField("bankTransferType", bankTransferType, String.class);
    addCustomField("businessIdentificationCode", businessIdentificationCode, String.class);
    addCustomField("city", city, String.class);
    addCustomField("country", country, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditCardAddress1", creditCardAddress1, String.class);
    addCustomField("creditCardAddress2", creditCardAddress2, String.class);
    addCustomField("creditCardCity", creditCardCity, String.class);
    addCustomField("creditCardCountry", creditCardCountry, String.class);
    addCustomField("creditCardExpirationMonth", creditCardExpirationMonth, Integer.class);
    addCustomField("creditCardExpirationYear", creditCardExpirationYear, Integer.class);
    addCustomField("creditCardHolderName", creditCardHolderName, String.class);
    addCustomField("creditCardMaskNumber", creditCardMaskNumber, String.class);
    addCustomField("creditCardNumber", creditCardNumber, String.class);
    addCustomField("creditCardPostalCode", creditCardPostalCode, String.class);
    addCustomField("creditCardSecurityCode", creditCardSecurityCode, String.class);
    addCustomField("creditCardState", creditCardState, String.class);
    addCustomField("creditCardType", creditCardType, String.class);
    addCustomField("deviceSessionId", deviceSessionId, String.class);
    addCustomField("email", email, String.class);
    addCustomField("existingMandate", existingMandate, String.class);
    addCustomField("firstName", firstName, String.class);
    addCustomField("gatewayOptionData", gatewayOptionData, String.class);
    addCustomField("iBAN", iBAN, String.class);
    addCustomField("iPAddress", iPAddress, String.class);
    addCustomField("id", id, String.class);
    addCustomField("lastFailedSaleTransactionDate", lastFailedSaleTransactionDate, String.class);
    addCustomField("lastName", lastName, String.class);
    addCustomField("lastTransactionDateTime", lastTransactionDateTime, String.class);
    addCustomField("lastTransactionStatus", lastTransactionStatus, String.class);
    addCustomField("mandateCreationDate", mandateCreationDate, String.class);
    addCustomField("mandateID", mandateID, String.class);
    addCustomField("mandateReceived", mandateReceived, String.class);
    addCustomField("mandateUpdateDate", mandateUpdateDate, String.class);
    addCustomField("maxConsecutivePaymentFailures", maxConsecutivePaymentFailures, Integer.class);
    addCustomField("name", name, String.class);
    addCustomField("numConsecutiveFailures", numConsecutiveFailures, Integer.class);
    addCustomField("paymentMethodStatus", paymentMethodStatus, String.class);
    addCustomField("paymentRetryWindow", paymentRetryWindow, Integer.class);
    addCustomField("paypalBaid", paypalBaid, String.class);
    addCustomField("paypalEmail", paypalEmail, String.class);
    addCustomField("paypalPreapprovalKey", paypalPreapprovalKey, String.class);
    addCustomField("paypalType", paypalType, String.class);
    addCustomField("phone", phone, String.class);
    addCustomField("postalCode", postalCode, String.class);
    addCustomField("secondTokenId", secondTokenId, String.class);
    addCustomField("skipValidation", skipValidation, Boolean.class);
    addCustomField("state", state, String.class);
    addCustomField("streetName", streetName, String.class);
    addCustomField("streetNumber", streetNumber, String.class);
    addCustomField("tokenId", tokenId, String.class);
    addCustomField("totalNumberOfErrorPayments", totalNumberOfErrorPayments, Integer.class);
    addCustomField("totalNumberOfProcessedPayments", totalNumberOfProcessedPayments, Integer.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
    addCustomField("useDefaultRetryRule", useDefaultRetryRule, Boolean.class);
  }
}

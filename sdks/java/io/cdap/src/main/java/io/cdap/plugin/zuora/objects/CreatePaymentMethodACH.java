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
* Object name: CreatePaymentMethodACH (CreatePaymentMethodACH).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreatePaymentMethodACH",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreatePaymentMethodACH extends BaseObject {
  /**
  * Name: addressLine1 (addressLine1), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("addressLine1")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String addressLine1;

  /**
  * Name: addressLine2 (addressLine2), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("addressLine2")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String addressLine2;

  /**
  * Name: bankABACode (bankABACode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankABACode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankABACode;

  /**
  * Name: bankAccountName (bankAccountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankAccountName;

  /**
  * Name: bankAccountNumber (bankAccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankAccountNumber;

  /**
  * Name: bankAccountType (bankAccountType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankAccountType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankAccountType;

  /**
  * Name: bankName (bankName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankName;

  /**
  * Name: city (city), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("city")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String city;

  /**
  * Name: country (country), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("country")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String country;

  /**
  * Name: phone (phone), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("phone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String phone;

  /**
  * Name: state (state), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("state")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String state;

  /**
  * Name: zipCode (zipCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("zipCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String zipCode;


  @Override
  public void addFields() {
    addCustomField("addressLine1", addressLine1, String.class);
    addCustomField("addressLine2", addressLine2, String.class);
    addCustomField("bankABACode", bankABACode, String.class);
    addCustomField("bankAccountName", bankAccountName, String.class);
    addCustomField("bankAccountNumber", bankAccountNumber, String.class);
    addCustomField("bankAccountType", bankAccountType, String.class);
    addCustomField("bankName", bankName, String.class);
    addCustomField("city", city, String.class);
    addCustomField("country", country, String.class);
    addCustomField("phone", phone, String.class);
    addCustomField("state", state, String.class);
    addCustomField("zipCode", zipCode, String.class);
  }
}

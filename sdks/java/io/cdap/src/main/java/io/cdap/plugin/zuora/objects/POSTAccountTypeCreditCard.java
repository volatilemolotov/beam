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

/** Object name: POSTAccountTypeCreditCard (POSTAccountTypeCreditCard). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTAccountTypeCreditCard",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTAccountTypeCreditCard extends BaseObject {
  /**
   * Name: cardHolderInfo (cardHolderInfo), Type: POSTAccountTypeCreditCardCardHolderInfoItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("cardHolderInfo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardHolderInfo;

  /**
   * Name: cardNumber (cardNumber), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("cardNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardNumber;

  /**
   * Name: cardType (cardType), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("cardType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardType;

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
   * Name: securityCode (securityCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("securityCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String securityCode;

  @Override
  public void addFields() {
    addCustomField("cardHolderInfo", cardHolderInfo, String.class);
    addCustomField("cardNumber", cardNumber, String.class);
    addCustomField("cardType", cardType, String.class);
    addCustomField("expirationMonth", expirationMonth, String.class);
    addCustomField("expirationYear", expirationYear, String.class);
    addCustomField("securityCode", securityCode, String.class);
  }
}

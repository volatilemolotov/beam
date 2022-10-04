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

/** Object name: POSTPaymentMethodDecryption (POSTPaymentMethodDecryption). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTPaymentMethodDecryption",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTPaymentMethodDecryption extends BaseObject {
  /**
   * Name: accountID (accountID), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountID;

  /**
   * Name: cardHolderInfo (cardHolderInfo), Type: POSTPaymentMethodDecryptionCardHolderInfoItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("cardHolderInfo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardHolderInfo;

  /**
   * Name: integrationType (integrationType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("integrationType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationType;

  /**
   * Name: invoiceID (invoiceID), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("invoiceID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceID;

  /**
   * Name: merchantID (merchantID), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("merchantID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String merchantID;

  /**
   * Name: paymentGateway (paymentGateway), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentGateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentGateway;

  /**
   * Name: paymentToken (paymentToken), Type: POSTPaymentMethodDecryptionPaymentTokenItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("paymentToken")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentToken;

  /**
   * Name: processPayment (processPayment), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("processPayment")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean processPayment;

  @Override
  public void addFields() {
    addCustomField("accountID", accountID, String.class);
    addCustomField("cardHolderInfo", cardHolderInfo, String.class);
    addCustomField("integrationType", integrationType, String.class);
    addCustomField("invoiceID", invoiceID, String.class);
    addCustomField("merchantID", merchantID, String.class);
    addCustomField("paymentGateway", paymentGateway, String.class);
    addCustomField("paymentToken", paymentToken, String.class);
    addCustomField("processPayment", processPayment, Boolean.class);
  }
}

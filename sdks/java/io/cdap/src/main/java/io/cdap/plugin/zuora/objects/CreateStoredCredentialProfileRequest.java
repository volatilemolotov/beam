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
* Object name: CreateStoredCredentialProfileRequest (CreateStoredCredentialProfileRequest).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreateStoredCredentialProfileRequest",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreateStoredCredentialProfileRequest extends BaseObject {
  /**
  * Name: action (action), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("action")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String action;

  /**
  * Name: agreedOn (agreedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("agreedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String agreedOn;

  /**
  * Name: authGateway (authGateway), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("authGateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String authGateway;

  /**
  * Name: cardSecurityCode (cardSecurityCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cardSecurityCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cardSecurityCode;

  /**
  * Name: consentAgreementRef (consentAgreementRef), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("consentAgreementRef")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String consentAgreementRef;

  /**
  * Name: consentAgreementSrc (consentAgreementSrc), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("consentAgreementSrc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String consentAgreementSrc;

  /**
  * Name: networkTransactionId (networkTransactionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("networkTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String networkTransactionId;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;


  @Override
  public void addFields() {
    addCustomField("action", action, String.class);
    addCustomField("agreedOn", agreedOn, String.class);
    addCustomField("authGateway", authGateway, String.class);
    addCustomField("cardSecurityCode", cardSecurityCode, String.class);
    addCustomField("consentAgreementRef", consentAgreementRef, String.class);
    addCustomField("consentAgreementSrc", consentAgreementSrc, String.class);
    addCustomField("networkTransactionId", networkTransactionId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("type", type, String.class);
  }
}

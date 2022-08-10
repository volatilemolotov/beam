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
* Object name: POSTQuoteDocType (POSTQuoteDocType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTQuoteDocType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTQuoteDocType extends BaseObject {
  /**
  * Name: apiuser (apiuser), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("apiuser")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String apiuser;

  /**
  * Name: documentType (documentType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentType;

  /**
  * Name: locale (locale), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("locale")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String locale;

  /**
  * Name: password (password), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("password")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String password;

  /**
  * Name: quoteId (quoteId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quoteId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quoteId;

  /**
  * Name: sandbox (sandbox), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sandbox")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sandbox;

  /**
  * Name: serverUrl (serverUrl), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serverUrl")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serverUrl;

  /**
  * Name: sessionId (sessionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sessionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sessionId;

  /**
  * Name: templateId (templateId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("templateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String templateId;

  /**
  * Name: token (token), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("token")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String token;

  /**
  * Name: useSFDCLocale (useSFDCLocale), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("useSFDCLocale")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String useSFDCLocale;

  /**
  * Name: username (username), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("username")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String username;

  /**
  * Name: zquotesMajorVersion (zquotesMajorVersion), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("zquotesMajorVersion")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String zquotesMajorVersion;

  /**
  * Name: zquotesMinorVersion (zquotesMinorVersion), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("zquotesMinorVersion")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String zquotesMinorVersion;


  @Override
  public void addFields() {
    addCustomField("apiuser", apiuser, String.class);
    addCustomField("documentType", documentType, String.class);
    addCustomField("locale", locale, String.class);
    addCustomField("password", password, String.class);
    addCustomField("quoteId", quoteId, String.class);
    addCustomField("sandbox", sandbox, String.class);
    addCustomField("serverUrl", serverUrl, String.class);
    addCustomField("sessionId", sessionId, String.class);
    addCustomField("templateId", templateId, String.class);
    addCustomField("token", token, String.class);
    addCustomField("useSFDCLocale", useSFDCLocale, String.class);
    addCustomField("username", username, String.class);
    addCustomField("zquotesMajorVersion", zquotesMajorVersion, String.class);
    addCustomField("zquotesMinorVersion", zquotesMinorVersion, String.class);
  }
}

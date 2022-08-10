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
* Object name: TokenResponse (TokenResponse).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "TokenResponse",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class TokenResponse extends BaseObject {
  /**
  * Name: access_token (access_token), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("access_token")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String access_token;

  /**
  * Name: expires_in (expires_in), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("expires_in")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String expires_in;

  /**
  * Name: jti (jti), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("jti")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String jti;

  /**
  * Name: scope (scope), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("scope")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String scope;

  /**
  * Name: token_type (token_type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("token_type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String token_type;


  @Override
  public void addFields() {
    addCustomField("access_token", access_token, String.class);
    addCustomField("expires_in", expires_in, String.class);
    addCustomField("jti", jti, String.class);
    addCustomField("scope", scope, String.class);
    addCustomField("token_type", token_type, String.class);
  }
}

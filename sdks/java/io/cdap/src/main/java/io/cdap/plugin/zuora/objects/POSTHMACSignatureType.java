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
* Object name: POSTHMACSignatureType (POSTHMACSignatureType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTHMACSignatureType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTHMACSignatureType extends BaseObject {
  /**
  * Name: accountKey (accountKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountKey;

  /**
  * Name: method (method), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("method")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String method;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: pageId (pageId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pageId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pageId;

  /**
  * Name: uri (uri), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uri")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uri;


  @Override
  public void addFields() {
    addCustomField("accountKey", accountKey, String.class);
    addCustomField("method", method, String.class);
    addCustomField("name", name, String.class);
    addCustomField("pageId", pageId, String.class);
    addCustomField("uri", uri, String.class);
  }
}

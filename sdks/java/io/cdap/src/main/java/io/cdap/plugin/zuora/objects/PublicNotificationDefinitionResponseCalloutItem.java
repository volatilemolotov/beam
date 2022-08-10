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
* Object name: PublicNotificationDefinitionResponseCalloutItem (PublicNotificationDefinitionResponseCalloutItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PublicNotificationDefinitionResponseCalloutItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PublicNotificationDefinitionResponseCalloutItem extends BaseObject {
  /**
  * Name: active (active), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("active")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean active;

  /**
  * Name: calloutBaseurl (calloutBaseurl), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("calloutBaseurl")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String calloutBaseurl;

  /**
  * Name: calloutRetry (calloutRetry), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("calloutRetry")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean calloutRetry;

  /**
  * Name: description (description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: eventTypeName (eventTypeName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("eventTypeName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventTypeName;

  /**
  * Name: httpMethod (httpMethod), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("httpMethod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String httpMethod;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: requiredAuth (requiredAuth), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("requiredAuth")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean requiredAuth;


  @Override
  public void addFields() {
    addCustomField("active", active, Boolean.class);
    addCustomField("calloutBaseurl", calloutBaseurl, String.class);
    addCustomField("calloutRetry", calloutRetry, Boolean.class);
    addCustomField("description", description, String.class);
    addCustomField("eventTypeName", eventTypeName, String.class);
    addCustomField("httpMethod", httpMethod, String.class);
    addCustomField("id", id, String.class);
    addCustomField("name", name, String.class);
    addCustomField("requiredAuth", requiredAuth, Boolean.class);
  }
}

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
* Object name: HostedPageType (HostedPageType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "HostedPageType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class HostedPageType extends BaseObject {
  /**
  * Name: pageId (pageId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pageId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pageId;

  /**
  * Name: pageName (pageName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pageName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pageName;

  /**
  * Name: pageType (pageType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pageType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pageType;

  /**
  * Name: pageVersion (pageVersion), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pageVersion")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pageVersion;


  @Override
  public void addFields() {
    addCustomField("pageId", pageId, String.class);
    addCustomField("pageName", pageName, String.class);
    addCustomField("pageType", pageType, String.class);
    addCustomField("pageVersion", pageVersion, String.class);
  }
}

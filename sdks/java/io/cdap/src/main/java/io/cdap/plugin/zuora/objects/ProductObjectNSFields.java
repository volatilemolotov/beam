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
* Object name: ProductObjectNSFields (ProductObjectNSFields).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProductObjectNSFields",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProductObjectNSFields extends BaseObject {
  /**
  * Name: IntegrationId__NS (IntegrationId__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("integrationId__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationId__NS;

  /**
  * Name: IntegrationStatus__NS (IntegrationStatus__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("integrationStatus__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationStatus__NS;

  /**
  * Name: ItemType__NS (ItemType__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("itemType__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String itemType__NS;

  /**
  * Name: SyncDate__NS (SyncDate__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("syncDate__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String syncDate__NS;


  @Override
  public void addFields() {
    addCustomField("integrationId__NS", integrationId__NS, String.class);
    addCustomField("integrationStatus__NS", integrationStatus__NS, String.class);
    addCustomField("itemType__NS", itemType__NS, String.class);
    addCustomField("syncDate__NS", syncDate__NS, String.class);
  }
}

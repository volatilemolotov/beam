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
* Object name: ARatedResultTypeAdditionalInfoItem (ARatedResultTypeAdditionalInfoItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ARatedResultTypeAdditionalInfoItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ARatedResultTypeAdditionalInfoItem extends BaseObject {
  /**
  * Name: isCredit (isCredit), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("isCredit")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isCredit;

  /**
  * Name: isOverage (isOverage), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("isOverage")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isOverage;

  /**
  * Name: quantity (quantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: uom (uom), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uom")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uom;


  @Override
  public void addFields() {
    addCustomField("isCredit", isCredit, Boolean.class);
    addCustomField("isOverage", isOverage, Boolean.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("uom", uom, String.class);
  }
}

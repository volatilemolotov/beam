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
* Object name: ProxyCreateUnitOfMeasure (ProxyCreateUnitOfMeasure).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyCreateUnitOfMeasure",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyCreateUnitOfMeasure extends BaseObject {
  /**
  * Name: Active (Active), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("active")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean active;

  /**
  * Name: DecimalPlaces (DecimalPlaces), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("decimalPlaces")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer decimalPlaces;

  /**
  * Name: DisplayedAs (DisplayedAs), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("displayedAs")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String displayedAs;

  /**
  * Name: RoundingMode (RoundingMode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("roundingMode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String roundingMode;

  /**
  * Name: UomName (UomName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uomName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uomName;


  @Override
  public void addFields() {
    addCustomField("active", active, Boolean.class);
    addCustomField("decimalPlaces", decimalPlaces, Integer.class);
    addCustomField("displayedAs", displayedAs, String.class);
    addCustomField("roundingMode", roundingMode, String.class);
    addCustomField("uomName", uomName, String.class);
  }
}

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
* Object name: POSTAccountingPeriodType (POSTAccountingPeriodType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTAccountingPeriodType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTAccountingPeriodType extends BaseObject {
  /**
  * Name: endDate (endDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
  * Name: fiscalYear (fiscalYear), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("fiscalYear")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fiscalYear;

  /**
  * Name: fiscal_quarter (fiscal_quarter), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("fiscal_quarter")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer fiscal_quarter;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: startDate (startDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;


  @Override
  public void addFields() {
    addCustomField("endDate", endDate, String.class);
    addCustomField("fiscalYear", fiscalYear, String.class);
    addCustomField("fiscal_quarter", fiscal_quarter, Integer.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("startDate", startDate, String.class);
  }
}

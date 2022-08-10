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
* Object name: POSTRevenueScheduleByTransactionRatablyCMType (POSTRevenueScheduleByTransactionRatablyCMType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTRevenueScheduleByTransactionRatablyCMType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTRevenueScheduleByTransactionRatablyCMType extends BaseObject {
  /**
  * Name: distributionType (distributionType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("distributionType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String distributionType;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: recognitionEnd (recognitionEnd), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognitionEnd")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognitionEnd;

  /**
  * Name: recognitionStart (recognitionStart), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognitionStart")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognitionStart;


  @Override
  public void addFields() {
    addCustomField("distributionType", distributionType, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("recognitionEnd", recognitionEnd, String.class);
    addCustomField("recognitionStart", recognitionStart, String.class);
  }
}

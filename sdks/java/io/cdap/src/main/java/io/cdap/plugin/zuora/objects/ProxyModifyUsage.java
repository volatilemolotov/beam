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
* Object name: ProxyModifyUsage (ProxyModifyUsage).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyModifyUsage",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyModifyUsage extends BaseObject {
  /**
  * Name: EndDateTime (EndDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateTime;

  /**
  * Name: Quantity (Quantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: RbeStatus (RbeStatus), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("rbeStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String rbeStatus;

  /**
  * Name: StartDateTime (StartDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDateTime;

  /**
  * Name: SubmissionDateTime (SubmissionDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("submissionDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submissionDateTime;

  /**
  * Name: UOM (UOM), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uOM")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uOM;


  @Override
  public void addFields() {
    addCustomField("endDateTime", endDateTime, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("rbeStatus", rbeStatus, String.class);
    addCustomField("startDateTime", startDateTime, String.class);
    addCustomField("submissionDateTime", submissionDateTime, String.class);
    addCustomField("uOM", uOM, String.class);
  }
}

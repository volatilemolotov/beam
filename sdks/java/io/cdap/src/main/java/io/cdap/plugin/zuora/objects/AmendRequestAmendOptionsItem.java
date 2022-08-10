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
* Object name: AmendRequestAmendOptionsItem (AmendRequestAmendOptionsItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AmendRequestAmendOptionsItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AmendRequestAmendOptionsItem extends BaseObject {
  /**
  * Name: ApplyCreditBalance (ApplyCreditBalance), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean applyCreditBalance;

  /**
  * Name: GenerateInvoice (GenerateInvoice), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("generateInvoice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean generateInvoice;

  /**
  * Name: ProcessPayments (ProcessPayments), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("processPayments")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean processPayments;


  @Override
  public void addFields() {
    addCustomField("applyCreditBalance", applyCreditBalance, Boolean.class);
    addCustomField("generateInvoice", generateInvoice, Boolean.class);
    addCustomField("processPayments", processPayments, Boolean.class);
  }
}

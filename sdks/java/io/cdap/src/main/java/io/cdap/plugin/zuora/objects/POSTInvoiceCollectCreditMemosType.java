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
* Object name: POSTInvoiceCollectCreditMemosType (POSTInvoiceCollectCreditMemosType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTInvoiceCollectCreditMemosType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTInvoiceCollectCreditMemosType extends BaseObject {
  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: memoAmount (memoAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("memoAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String memoAmount;

  /**
  * Name: memoNumber (memoNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("memoNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String memoNumber;


  @Override
  public void addFields() {
    addCustomField("id", id, String.class);
    addCustomField("memoAmount", memoAmount, String.class);
    addCustomField("memoNumber", memoNumber, String.class);
  }
}

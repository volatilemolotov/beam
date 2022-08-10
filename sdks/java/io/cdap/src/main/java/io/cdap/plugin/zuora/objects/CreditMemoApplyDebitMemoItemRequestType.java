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
* Object name: CreditMemoApplyDebitMemoItemRequestType (CreditMemoApplyDebitMemoItemRequestType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreditMemoApplyDebitMemoItemRequestType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreditMemoApplyDebitMemoItemRequestType extends BaseObject {
  /**
  * Name: amount (amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: creditMemoItemId (creditMemoItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditMemoItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoItemId;

  /**
  * Name: creditTaxItemId (creditTaxItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditTaxItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditTaxItemId;

  /**
  * Name: debitMemoItemId (debitMemoItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("debitMemoItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String debitMemoItemId;

  /**
  * Name: taxItemId (taxItemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxItemId;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("creditMemoItemId", creditMemoItemId, String.class);
    addCustomField("creditTaxItemId", creditTaxItemId, String.class);
    addCustomField("debitMemoItemId", debitMemoItemId, String.class);
    addCustomField("taxItemId", taxItemId, String.class);
  }
}

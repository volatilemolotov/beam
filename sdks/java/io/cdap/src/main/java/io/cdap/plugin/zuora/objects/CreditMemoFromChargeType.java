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

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: CreditMemoFromChargeType (CreditMemoFromChargeType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreditMemoFromChargeType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreditMemoFromChargeType extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: charges (charges), Type: array|CreditMemoFromChargeDetailType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("charges")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CreditMemoFromChargeDetailType")
  private List<CreditMemoFromChargeDetailType> charges;

  /**
  * Name: comment (comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: effectiveDate (effectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
  * Name: reasonCode (reasonCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("charges", charges, List.class);
    addCustomField("comment", comment, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
  }
}

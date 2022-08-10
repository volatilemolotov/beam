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
* Object name: RefundPaymentTypeFinanceInformationItem (RefundPaymentTypeFinanceInformationItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "RefundPaymentTypeFinanceInformationItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class RefundPaymentTypeFinanceInformationItem extends BaseObject {
  /**
  * Name: bankAccountAccountingCode (bankAccountAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankAccountAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankAccountAccountingCode;

  /**
  * Name: bankAccountAccountingCodeType (bankAccountAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("bankAccountAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bankAccountAccountingCodeType;

  /**
  * Name: transferredToAccounting (transferredToAccounting), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

  /**
  * Name: unappliedPaymentAccountingCode (unappliedPaymentAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unappliedPaymentAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedPaymentAccountingCode;

  /**
  * Name: unappliedPaymentAccountingCodeType (unappliedPaymentAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unappliedPaymentAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedPaymentAccountingCodeType;


  @Override
  public void addFields() {
    addCustomField("bankAccountAccountingCode", bankAccountAccountingCode, String.class);
    addCustomField("bankAccountAccountingCodeType", bankAccountAccountingCodeType, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("unappliedPaymentAccountingCode", unappliedPaymentAccountingCode, String.class);
    addCustomField("unappliedPaymentAccountingCodeType", unappliedPaymentAccountingCodeType, String.class);
  }
}

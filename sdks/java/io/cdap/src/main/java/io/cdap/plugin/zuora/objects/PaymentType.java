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
* Object name: PaymentType (PaymentType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PaymentType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PaymentType extends BaseObject {
  /**
  * Name: accountID (accountID), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountID;

  /**
  * Name: accountName (accountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountName;

  /**
  * Name: accountNumber (accountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: amount (amount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: effectiveDate (effectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
  * Name: gatewayTransactionNumber (gatewayTransactionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("gatewayTransactionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayTransactionNumber;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: paidInvoices (paidInvoices), Type: array|PaidInvoicesType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paidInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PaidInvoicesType")
  private List<PaidInvoicesType> paidInvoices;

  /**
  * Name: paymentMethodID (paymentMethodID), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodID")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodID;

  /**
  * Name: paymentNumber (paymentNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentNumber;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;


  @Override
  public void addFields() {
    addCustomField("accountID", accountID, String.class);
    addCustomField("accountName", accountName, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("gatewayTransactionNumber", gatewayTransactionNumber, String.class);
    addCustomField("id", id, String.class);
    addCustomField("paidInvoices", paidInvoices, List.class);
    addCustomField("paymentMethodID", paymentMethodID, String.class);
    addCustomField("paymentNumber", paymentNumber, String.class);
    addCustomField("status", status, String.class);
    addCustomField("type", type, String.class);
  }
}

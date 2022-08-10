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
* Object name: JobResult (JobResult).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "JobResult",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class JobResult extends BaseObject {
  /**
  * Name: accountNumber (accountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: creditMemoNumbers (creditMemoNumbers), Type: array|JobResultCreditMemoNumbersItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditMemoNumbers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JobResultCreditMemoNumbersItem")
  private List<JobResultCreditMemoNumbersItem> creditMemoNumbers;

  /**
  * Name: invoiceNumbers (invoiceNumbers), Type: array|JobResultInvoiceNumbersItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceNumbers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JobResultInvoiceNumbersItem")
  private List<JobResultInvoiceNumbersItem> invoiceNumbers;

  /**
  * Name: orderNumber (orderNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderNumber;

  /**
  * Name: paidAmount (paidAmount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paidAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paidAmount;

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
  * Name: subscriptionNumbers (subscriptionNumbers), Type: array|JobResultSubscriptionNumbersItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumbers")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JobResultSubscriptionNumbersItem")
  private List<JobResultSubscriptionNumbersItem> subscriptionNumbers;

  /**
  * Name: subscriptions (subscriptions), Type: array|JobResultSubscriptionsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JobResultSubscriptionsItem")
  private List<JobResultSubscriptionsItem> subscriptions;


  @Override
  public void addFields() {
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("creditMemoNumbers", creditMemoNumbers, List.class);
    addCustomField("invoiceNumbers", invoiceNumbers, List.class);
    addCustomField("orderNumber", orderNumber, String.class);
    addCustomField("paidAmount", paidAmount, String.class);
    addCustomField("paymentNumber", paymentNumber, String.class);
    addCustomField("status", status, String.class);
    addCustomField("subscriptionNumbers", subscriptionNumbers, List.class);
    addCustomField("subscriptions", subscriptions, List.class);
  }
}

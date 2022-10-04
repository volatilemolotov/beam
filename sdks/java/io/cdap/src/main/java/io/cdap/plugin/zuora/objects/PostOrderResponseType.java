/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import java.util.List;
import javax.annotation.Nullable;

/** Object name: PostOrderResponseType (PostOrderResponseType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PostOrder",
    RequiredPostArguments = {"body"},
    APIUrl = "orders",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class PostOrderResponseType extends BaseObject {
  /**
   * Name: accountId (accountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: accountNumber (accountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
   * Name: creditMemoIds (creditMemoIds), Type: array|PostOrderResponseTypeCreditMemoIdsItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditMemoIds")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeCreditMemoIdsItem")
  private List<PostOrderResponseTypeCreditMemoIdsItem> creditMemoIds;

  /**
   * Name: creditMemoNumbers (creditMemoNumbers), Type:
   * array|PostOrderResponseTypeCreditMemoNumbersItem. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("creditMemoNumbers")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeCreditMemoNumbersItem")
  private List<PostOrderResponseTypeCreditMemoNumbersItem> creditMemoNumbers;

  /**
   * Name: invoiceIds (invoiceIds), Type: array|PostOrderResponseTypeInvoiceIdsItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceIds")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeInvoiceIdsItem")
  private List<PostOrderResponseTypeInvoiceIdsItem> invoiceIds;

  /**
   * Name: invoiceNumbers (invoiceNumbers), Type: array|PostOrderResponseTypeInvoiceNumbersItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceNumbers")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeInvoiceNumbersItem")
  private List<PostOrderResponseTypeInvoiceNumbersItem> invoiceNumbers;

  /**
   * Name: orderId (orderId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("orderId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderId;

  /**
   * Name: orderNumber (orderNumber), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("orderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderNumber;

  /**
   * Name: paidAmount (paidAmount), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("paidAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paidAmount;

  /**
   * Name: paymentId (paymentId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
   * Name: paymentNumber (paymentNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentNumber;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: subscriptionIds (subscriptionIds), Type: array|PostOrderResponseTypeSubscriptionIdsItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("subscriptionIds")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeSubscriptionIdsItem")
  private List<PostOrderResponseTypeSubscriptionIdsItem> subscriptionIds;

  /**
   * Name: subscriptionNumbers (subscriptionNumbers), Type:
   * array|PostOrderResponseTypeSubscriptionNumbersItem. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subscriptionNumbers")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeSubscriptionNumbersItem")
  private List<PostOrderResponseTypeSubscriptionNumbersItem> subscriptionNumbers;

  /**
   * Name: subscriptions (subscriptions), Type: array|PostOrderResponseTypeSubscriptionsItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("subscriptions")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostOrderResponseTypeSubscriptionsItem")
  private List<PostOrderResponseTypeSubscriptionsItem> subscriptions;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("creditMemoIds", creditMemoIds, List.class);
    addCustomField("creditMemoNumbers", creditMemoNumbers, List.class);
    addCustomField("invoiceIds", invoiceIds, List.class);
    addCustomField("invoiceNumbers", invoiceNumbers, List.class);
    addCustomField("orderId", orderId, String.class);
    addCustomField("orderNumber", orderNumber, String.class);
    addCustomField("paidAmount", paidAmount, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("paymentNumber", paymentNumber, String.class);
    addCustomField("status", status, String.class);
    addCustomField("subscriptionIds", subscriptionIds, List.class);
    addCustomField("subscriptionNumbers", subscriptionNumbers, List.class);
    addCustomField("subscriptions", subscriptions, List.class);
  }
}

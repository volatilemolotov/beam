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

/**
 * Object name: POSTInvoiceCollectResponseType (POSTInvoiceCollectResponseType). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTInvoiceCollectResponseType",
    RequiredArguments = {"Request"},
    APIUrl = "operations/invoice-collect",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class POSTInvoiceCollectResponseType extends BaseObject {
  /**
   * Name: amountCollected (amountCollected), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("amountCollected")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amountCollected;

  /**
   * Name: creditMemos (creditMemos), Type: array|POSTInvoiceCollectCreditMemosType. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditMemos")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "POSTInvoiceCollectCreditMemosType")
  private List<POSTInvoiceCollectCreditMemosType> creditMemos;

  /**
   * Name: invoices (invoices), Type: array|POSTInvoiceCollectInvoicesType. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("invoices")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "POSTInvoiceCollectInvoicesType")
  private List<POSTInvoiceCollectInvoicesType> invoices;

  /**
   * Name: paymentId (paymentId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  @Override
  public void addFields() {
    addCustomField("amountCollected", amountCollected, String.class);
    addCustomField("creditMemos", creditMemos, List.class);
    addCustomField("invoices", invoices, List.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("success", success, Boolean.class);
  }
}

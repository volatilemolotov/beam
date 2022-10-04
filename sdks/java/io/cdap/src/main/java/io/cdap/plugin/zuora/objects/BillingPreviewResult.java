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

/** Object name: BillingPreviewResult (BillingPreviewResult). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "BillingPreviewResult",
    RequiredArguments = {"Request"},
    APIUrl = "operations/billing-preview",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class BillingPreviewResult extends BaseObject {
  /**
   * Name: accountId (accountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: creditMemoItems (creditMemoItems), Type: array|POSTBillingPreviewCreditMemoItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditMemoItems")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "POSTBillingPreviewCreditMemoItem")
  private List<POSTBillingPreviewCreditMemoItem> creditMemoItems;

  /**
   * Name: invoiceItems (invoiceItems), Type: array|POSTBillingPreviewInvoiceItem. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceItems")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "POSTBillingPreviewInvoiceItem")
  private List<POSTBillingPreviewInvoiceItem> invoiceItems;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("creditMemoItems", creditMemoItems, List.class);
    addCustomField("invoiceItems", invoiceItems, List.class);
    addCustomField("success", success, Boolean.class);
  }
}

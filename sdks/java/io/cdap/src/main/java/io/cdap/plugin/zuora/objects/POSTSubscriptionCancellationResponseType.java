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
* Object name: POSTSubscriptionCancellationResponseType (POSTSubscriptionCancellationResponseType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTSubscriptionCancellationResponseType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTSubscriptionCancellationResponseType extends BaseObject {
  /**
  * Name: cancelledDate (cancelledDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledDate;

  /**
  * Name: creditMemoId (creditMemoId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditMemoId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoId;

  /**
  * Name: invoiceId (invoiceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
  * Name: paidAmount (paidAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paidAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paidAmount;

  /**
  * Name: paymentId (paymentId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentId;

  /**
  * Name: subscriptionId (subscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: totalDeltaMrr (totalDeltaMrr), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalDeltaMrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDeltaMrr;

  /**
  * Name: totalDeltaTcv (totalDeltaTcv), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalDeltaTcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalDeltaTcv;


  @Override
  public void addFields() {
    addCustomField("cancelledDate", cancelledDate, String.class);
    addCustomField("creditMemoId", creditMemoId, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("paidAmount", paidAmount, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("totalDeltaMrr", totalDeltaMrr, String.class);
    addCustomField("totalDeltaTcv", totalDeltaTcv, String.class);
  }
}

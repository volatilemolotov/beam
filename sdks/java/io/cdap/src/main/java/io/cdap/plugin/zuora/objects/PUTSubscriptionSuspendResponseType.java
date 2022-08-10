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
* Object name: PUTSubscriptionSuspendResponseType (PUTSubscriptionSuspendResponseType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PUTSubscriptionSuspendResponseType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PUTSubscriptionSuspendResponseType extends BaseObject {
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
  * Name: resumeDate (resumeDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumeDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumeDate;

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
  * Name: suspendDate (suspendDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("suspendDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String suspendDate;

  /**
  * Name: termEndDate (termEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termEndDate;

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
    addCustomField("creditMemoId", creditMemoId, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("paidAmount", paidAmount, String.class);
    addCustomField("paymentId", paymentId, String.class);
    addCustomField("resumeDate", resumeDate, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("suspendDate", suspendDate, String.class);
    addCustomField("termEndDate", termEndDate, String.class);
    addCustomField("totalDeltaTcv", totalDeltaTcv, String.class);
  }
}

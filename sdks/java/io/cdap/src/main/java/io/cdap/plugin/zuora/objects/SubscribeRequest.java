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
* Object name: SubscribeRequest (SubscribeRequest).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "SubscribeRequest",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class SubscribeRequest extends BaseObject {
  /**
  * Name: PaymentMethod (PaymentMethod), Type: SubscribeRequestPaymentMethodItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethod;

  /**
  * Name: PreviewOptions (PreviewOptions), Type: SubscribeRequestPreviewOptionsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("previewOptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previewOptions;

  /**
  * Name: SubscribeOptions (SubscribeOptions), Type: SubscribeRequestSubscribeOptionsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscribeOptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscribeOptions;

  /**
  * Name: SubscriptionData (SubscriptionData), Type: SubscribeRequestSubscriptionDataItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionData;


  @Override
  public void addFields() {
    addCustomField("paymentMethod", paymentMethod, String.class);
    addCustomField("previewOptions", previewOptions, String.class);
    addCustomField("subscribeOptions", subscribeOptions, String.class);
    addCustomField("subscriptionData", subscriptionData, String.class);
  }
}

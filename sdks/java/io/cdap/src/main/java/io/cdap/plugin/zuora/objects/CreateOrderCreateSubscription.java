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

/** Object name: CreateOrderCreateSubscription (CreateOrderCreateSubscription). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CreateOrderCreateSubscription",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class CreateOrderCreateSubscription extends BaseObject {
  /**
   * Name: invoiceSeparately (invoiceSeparately), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceSeparately")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceSeparately;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
   * Name: subscribeToRatePlans (subscribeToRatePlans), Type: array|CreateOrderRatePlanOverride.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("subscribeToRatePlans")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CreateOrderRatePlanOverride")
  private List<CreateOrderRatePlanOverride> subscribeToRatePlans;

  /**
   * Name: subscriptionNumber (subscriptionNumber), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
   * Name: subscriptionOwnerAccountNumber (subscriptionOwnerAccountNumber), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("subscriptionOwnerAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionOwnerAccountNumber;

  /**
   * Name: terms (terms), Type: CreateOrderCreateSubscriptionTermsItem. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("terms")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String terms;

  @Override
  public void addFields() {
    addCustomField("invoiceSeparately", invoiceSeparately, Boolean.class);
    addCustomField("notes", notes, String.class);
    addCustomField("subscribeToRatePlans", subscribeToRatePlans, List.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("subscriptionOwnerAccountNumber", subscriptionOwnerAccountNumber, String.class);
    addCustomField("terms", terms, String.class);
  }
}

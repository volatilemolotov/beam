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
import javax.annotation.Nullable;

/** Object name: ProxyCreateUsage (ProxyCreateUsage). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyCreateUsage",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyCreateUsage extends BaseObject {
  /**
   * Name: AccountId (AccountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: AccountNumber (AccountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
   * Name: ChargeId (ChargeId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("chargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeId;

  /**
   * Name: ChargeNumber (ChargeNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
   * Name: Description (Description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: EndDateTime (EndDateTime), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("endDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateTime;

  /**
   * Name: Quantity (Quantity), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
   * Name: StartDateTime (StartDateTime), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("startDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDateTime;

  /**
   * Name: SubmissionDateTime (SubmissionDateTime), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("submissionDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submissionDateTime;

  /**
   * Name: SubscriptionId (SubscriptionId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
   * Name: SubscriptionNumber (SubscriptionNumber), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /** Name: UOM (UOM), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("uOM")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uOM;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("chargeId", chargeId, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("description", description, String.class);
    addCustomField("endDateTime", endDateTime, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("startDateTime", startDateTime, String.class);
    addCustomField("submissionDateTime", submissionDateTime, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("uOM", uOM, String.class);
  }
}

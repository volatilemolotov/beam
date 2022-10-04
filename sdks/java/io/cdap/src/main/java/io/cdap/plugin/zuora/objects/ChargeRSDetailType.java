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

/** Object name: ChargeRSDetailType (ChargeRSDetailType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ChargeRSDetailType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ChargeRSDetailType extends BaseObject {
  /**
   * Name: accountId (accountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /** Name: amount (amount), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: currency (currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /** Name: number (number), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
   * Name: recognitionRuleName (recognitionRuleName), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("recognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognitionRuleName;

  /**
   * Name: recognizedRevenue (recognizedRevenue), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("recognizedRevenue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenue;

  /**
   * Name: revenueItems (revenueItems), Type: array|RevenueItemType. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("revenueItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "RevenueItemType")
  private List<RevenueItemType> revenueItems;

  /**
   * Name: subscriptionChargeId (subscriptionChargeId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("subscriptionChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionChargeId;

  /**
   * Name: subscriptionId (subscriptionId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
   * Name: undistributedUnrecognizedRevenue (undistributedUnrecognizedRevenue), Type: string.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("undistributedUnrecognizedRevenue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String undistributedUnrecognizedRevenue;

  /**
   * Name: unrecognizedRevenue (unrecognizedRevenue), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("unrecognizedRevenue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unrecognizedRevenue;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("number", number, String.class);
    addCustomField("recognitionRuleName", recognitionRuleName, String.class);
    addCustomField("recognizedRevenue", recognizedRevenue, String.class);
    addCustomField("revenueItems", revenueItems, List.class);
    addCustomField("subscriptionChargeId", subscriptionChargeId, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField(
        "undistributedUnrecognizedRevenue", undistributedUnrecognizedRevenue, String.class);
    addCustomField("unrecognizedRevenue", unrecognizedRevenue, String.class);
  }
}

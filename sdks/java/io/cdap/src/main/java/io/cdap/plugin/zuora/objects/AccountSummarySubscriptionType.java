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
 * Object name: AccountSummarySubscriptionType (AccountSummarySubscriptionType). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AccountSummarySubscriptionType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AccountSummarySubscriptionType extends BaseObject {
  /**
   * Name: autoRenew (autoRenew), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: initialTerm (initialTerm), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("initialTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String initialTerm;

  /**
   * Name: ratePlans (ratePlans), Type: array|AccountSummarySubscriptionRatePlanType. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("ratePlans")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "AccountSummarySubscriptionRatePlanType")
  private List<AccountSummarySubscriptionRatePlanType> ratePlans;

  /**
   * Name: renewalTerm (renewalTerm), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("renewalTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalTerm;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: subscriptionNumber (subscriptionNumber), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
   * Name: subscriptionStartDate (subscriptionStartDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("subscriptionStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionStartDate;

  /**
   * Name: termEndDate (termEndDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("termEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termEndDate;

  /**
   * Name: termStartDate (termStartDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("termStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termStartDate;

  /**
   * Name: termType (termType), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("termType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termType;

  @Override
  public void addFields() {
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("id", id, String.class);
    addCustomField("initialTerm", initialTerm, String.class);
    addCustomField("ratePlans", ratePlans, List.class);
    addCustomField("renewalTerm", renewalTerm, String.class);
    addCustomField("status", status, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("subscriptionStartDate", subscriptionStartDate, String.class);
    addCustomField("termEndDate", termEndDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
  }
}

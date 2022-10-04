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

/** Object name: RatePlanDataRatePlan (RatePlanDataRatePlan). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "RatePlanDataRatePlan",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class RatePlanDataRatePlan extends BaseObject {
  /**
   * Name: AmendmentId (AmendmentId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("amendmentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amendmentId;

  /**
   * Name: AmendmentSubscriptionRatePlanId (AmendmentSubscriptionRatePlanId), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("amendmentSubscriptionRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amendmentSubscriptionRatePlanId;

  /**
   * Name: AmendmentType (AmendmentType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("amendmentType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amendmentType;

  /**
   * Name: CreatedById (CreatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
   * Name: CreatedDate (CreatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /** Name: Name (Name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: ProductRatePlanId (ProductRatePlanId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /**
   * Name: SubscriptionId (SubscriptionId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
   * Name: UpdatedById (UpdatedById), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
   * Name: UpdatedDate (UpdatedDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;

  @Override
  public void addFields() {
    addCustomField("amendmentId", amendmentId, String.class);
    addCustomField(
        "amendmentSubscriptionRatePlanId", amendmentSubscriptionRatePlanId, String.class);
    addCustomField("amendmentType", amendmentType, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("name", name, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

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
 * Object name: PostGenerateBillingDocumentType (PostGenerateBillingDocumentType). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PostGenerateBillingDocumentType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PostGenerateBillingDocumentType extends BaseObject {
  /**
   * Name: autoPost (autoPost), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("autoPost")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoPost;

  /**
   * Name: autoRenew (autoRenew), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
   * Name: chargeTypeToExclude (chargeTypeToExclude), Type:
   * array|PostGenerateBillingDocumentTypeChargeTypeToExcludeItem. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("chargeTypeToExclude")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostGenerateBillingDocumentTypeChargeTypeToExcludeItem")
  private List<PostGenerateBillingDocumentTypeChargeTypeToExcludeItem> chargeTypeToExclude;

  /**
   * Name: effectiveDate (effectiveDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
   * Name: subscriptionIds (subscriptionIds), Type:
   * array|PostGenerateBillingDocumentTypeSubscriptionIdsItem. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("subscriptionIds")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PostGenerateBillingDocumentTypeSubscriptionIdsItem")
  private List<PostGenerateBillingDocumentTypeSubscriptionIdsItem> subscriptionIds;

  /**
   * Name: targetDate (targetDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  @Override
  public void addFields() {
    addCustomField("autoPost", autoPost, Boolean.class);
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("chargeTypeToExclude", chargeTypeToExclude, List.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("subscriptionIds", subscriptionIds, List.class);
    addCustomField("targetDate", targetDate, String.class);
  }
}

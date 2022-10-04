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

/**
 * Object name: POSTSubscriptionPreviewResponseTypeChargeMetricsItem
 * (POSTSubscriptionPreviewResponseTypeChargeMetricsItem). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTSubscriptionPreviewResponseTypeChargeMetricsItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTSubscriptionPreviewResponseTypeChargeMetricsItem extends BaseObject {
  /** Name: dmrr (dmrr), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dmrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dmrr;

  /** Name: dtcv (dtcv), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dtcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dtcv;

  /** Name: mrr (mrr), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("mrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mrr;

  /** Name: number (number), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
   * Name: originRatePlanId (originRatePlanId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("originRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originRatePlanId;

  /**
   * Name: originalId (originalId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("originalId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalId;

  /**
   * Name: productRatePlanChargeId (productRatePlanChargeId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
   * Name: productRatePlanId (productRatePlanId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /** Name: tcv (tcv), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tcv;

  @Override
  public void addFields() {
    addCustomField("dmrr", dmrr, String.class);
    addCustomField("dtcv", dtcv, String.class);
    addCustomField("mrr", mrr, String.class);
    addCustomField("number", number, String.class);
    addCustomField("originRatePlanId", originRatePlanId, String.class);
    addCustomField("originalId", originalId, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("tcv", tcv, String.class);
  }
}

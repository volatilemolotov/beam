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

/** Object name: OrderMetric (OrderMetric). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "OrderMetric", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class OrderMetric extends BaseObject {
  /**
   * Name: chargeNumber (chargeNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
   * Name: elp (elp), Type: array|TimeSlicedElpNetMetrics. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("elp")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TimeSlicedElpNetMetrics")
  private List<TimeSlicedElpNetMetrics> elp;

  /**
   * Name: mrr (mrr), Type: array|TimeSlicedNetMetrics. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("mrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TimeSlicedNetMetrics")
  private List<TimeSlicedNetMetrics> mrr;

  /**
   * Name: originRatePlanId (originRatePlanId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("originRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originRatePlanId;

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

  /**
   * Name: quantity (quantity), Type: array|TimeSlicedMetrics. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TimeSlicedMetrics")
  private List<TimeSlicedMetrics> quantity;

  /**
   * Name: tcb (tcb), Type: array|TimeSlicedTcbNetMetrics. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("tcb")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TimeSlicedTcbNetMetrics")
  private List<TimeSlicedTcbNetMetrics> tcb;

  /**
   * Name: tcv (tcv), Type: array|TimeSlicedNetMetrics. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("tcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TimeSlicedNetMetrics")
  private List<TimeSlicedNetMetrics> tcv;

  @Override
  public void addFields() {
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("elp", elp, List.class);
    addCustomField("mrr", mrr, List.class);
    addCustomField("originRatePlanId", originRatePlanId, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("quantity", quantity, List.class);
    addCustomField("tcb", tcb, List.class);
    addCustomField("tcv", tcv, List.class);
  }
}

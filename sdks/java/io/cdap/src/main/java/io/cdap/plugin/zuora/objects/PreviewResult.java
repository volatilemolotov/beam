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

/** Object name: PreviewResult (PreviewResult). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "PreviewResult", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PreviewResult extends BaseObject {
  /**
   * Name: chargeMetrics (chargeMetrics), Type: array|PreviewResultChargeMetricsItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("chargeMetrics")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PreviewResultChargeMetricsItem")
  private List<PreviewResultChargeMetricsItem> chargeMetrics;

  /**
   * Name: creditMemos (creditMemos), Type: array|PreviewResultCreditMemosItem. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("creditMemos")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PreviewResultCreditMemosItem")
  private List<PreviewResultCreditMemosItem> creditMemos;

  /**
   * Name: invoices (invoices), Type: array|PreviewResultInvoicesItem. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("invoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PreviewResultInvoicesItem")
  private List<PreviewResultInvoicesItem> invoices;

  /**
   * Name: orderMetrics (orderMetrics), Type: array|PreviewResultOrderMetricsItem. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("orderMetrics")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PreviewResultOrderMetricsItem")
  private List<PreviewResultOrderMetricsItem> orderMetrics;

  @Override
  public void addFields() {
    addCustomField("chargeMetrics", chargeMetrics, List.class);
    addCustomField("creditMemos", creditMemos, List.class);
    addCustomField("invoices", invoices, List.class);
    addCustomField("orderMetrics", orderMetrics, List.class);
  }
}

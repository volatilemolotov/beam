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
 * Object name: TimeSlicedTcbNetMetricsForEvergreen (TimeSlicedTcbNetMetricsForEvergreen). Related
 * objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "TimeSlicedTcbNetMetricsForEvergreen",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class TimeSlicedTcbNetMetricsForEvergreen extends BaseObject {
  /** Name: amount (amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: discountChargeNumber (discountChargeNumber), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("discountChargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountChargeNumber;

  /**
   * Name: endDate (endDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
   * Name: invoiceOwner (invoiceOwner), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceOwner")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwner;

  /**
   * Name: startDate (startDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;

  /**
   * Name: subscriptionOwner (subscriptionOwner), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("subscriptionOwner")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionOwner;

  /** Name: tax (tax), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tax;

  /**
   * Name: termNumber (termNumber), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("termNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termNumber;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("discountChargeNumber", discountChargeNumber, String.class);
    addCustomField("endDate", endDate, String.class);
    addCustomField("invoiceOwner", invoiceOwner, String.class);
    addCustomField("startDate", startDate, String.class);
    addCustomField("subscriptionOwner", subscriptionOwner, String.class);
    addCustomField("tax", tax, String.class);
    addCustomField("termNumber", termNumber, String.class);
    addCustomField("type", type, String.class);
  }
}

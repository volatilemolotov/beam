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

/** Object name: ProxyModifyProductRatePlan (ProxyModifyProductRatePlan). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyModifyProductRatePlan",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyModifyProductRatePlan extends BaseObject {
  /**
   * Name: Description (Description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: EffectiveEndDate (EffectiveEndDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveEndDate;

  /**
   * Name: EffectiveStartDate (EffectiveStartDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveStartDate;

  /** Name: Name (Name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: ProductId (ProductId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("productId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productId;

  @Override
  public void addFields() {
    addCustomField("description", description, String.class);
    addCustomField("effectiveEndDate", effectiveEndDate, String.class);
    addCustomField("effectiveStartDate", effectiveStartDate, String.class);
    addCustomField("name", name, String.class);
    addCustomField("productId", productId, String.class);
  }
}

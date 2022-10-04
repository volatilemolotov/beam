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

/** Object name: RatePlanChargeTier (RatePlanChargeTier). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "RatePlanChargeTier",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class RatePlanChargeTier extends BaseObject {
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

  /**
   * Name: EndingUnit (EndingUnit), Type: number. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("endingUnit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endingUnit;

  /**
   * Name: IsOveragePrice (IsOveragePrice), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("isOveragePrice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isOveragePrice;

  /** Name: Price (Price), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("price")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String price;

  /**
   * Name: PriceFormat (PriceFormat), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("priceFormat")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String priceFormat;

  /**
   * Name: RatePlanChargeId (RatePlanChargeId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("ratePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanChargeId;

  /**
   * Name: StartingUnit (StartingUnit), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("startingUnit")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startingUnit;

  /** Name: Tier (Tier), Type: integer. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tier")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer tier;

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
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("endingUnit", endingUnit, String.class);
    addCustomField("isOveragePrice", isOveragePrice, Boolean.class);
    addCustomField("price", price, String.class);
    addCustomField("priceFormat", priceFormat, String.class);
    addCustomField("ratePlanChargeId", ratePlanChargeId, String.class);
    addCustomField("startingUnit", startingUnit, String.class);
    addCustomField("tier", tier, Integer.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

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

/** Object name: NewChargeMetrics (NewChargeMetrics). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "NewChargeMetrics",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class NewChargeMetrics extends BaseObject {
  /**
   * Name: ChargeNumber (ChargeNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /** Name: DMRR (DMRR), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dMRR")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dMRR;

  /** Name: DTCV (DTCV), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("dTCV")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dTCV;

  /** Name: MRR (MRR), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("mRR")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mRR;

  /**
   * Name: OriginalId (OriginalId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("originalId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalId;

  /**
   * Name: OriginalRatePlanId (OriginalRatePlanId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("originalRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalRatePlanId;

  /**
   * Name: ProductRatePlanChargeId (ProductRatePlanChargeId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
   * Name: ProductRatePlanId (ProductRatePlanId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /** Name: TCV (TCV), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tCV")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tCV;

  @Override
  public void addFields() {
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("dMRR", dMRR, String.class);
    addCustomField("dTCV", dTCV, String.class);
    addCustomField("mRR", mRR, String.class);
    addCustomField("originalId", originalId, String.class);
    addCustomField("originalRatePlanId", originalRatePlanId, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("tCV", tCV, String.class);
  }
}

/*
 *  Copyright © 2019 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;


import javax.annotation.Nullable;

/**
* Object name: ChargePreviewMetrics (ChargePreviewMetrics).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ChargePreviewMetrics",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ChargePreviewMetrics extends BaseObject {
  /**
  * Name: chargeNumber (chargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: cmrr (cmrr), Type: ChargePreviewMetricsCmrrItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cmrr")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cmrr;

  /**
  * Name: originRatePlanId (originRatePlanId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("originRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originRatePlanId;

  /**
  * Name: productRatePlanChargeId (productRatePlanChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
  * Name: productRatePlanId (productRatePlanId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /**
  * Name: tax (tax), Type: ChargePreviewMetricsTaxItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tax;

  /**
  * Name: tcb (tcb), Type: ChargePreviewMetricsTcbItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tcb")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tcb;

  /**
  * Name: tcv (tcv), Type: ChargePreviewMetricsTcvItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tcv")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tcv;


  @Override
  public void addFields() {
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("cmrr", cmrr, String.class);
    addCustomField("originRatePlanId", originRatePlanId, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("tax", tax, String.class);
    addCustomField("tcb", tcb, String.class);
    addCustomField("tcv", tcv, String.class);
  }
}

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
* Object name: ProductRatePlanChargeTypeFinanceInformationItem (ProductRatePlanChargeTypeFinanceInformationItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProductRatePlanChargeTypeFinanceInformationItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProductRatePlanChargeTypeFinanceInformationItem extends BaseObject {
  /**
  * Name: adjustmentLiabilityAccountingCode (adjustmentLiabilityAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("adjustmentLiabilityAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentLiabilityAccountingCode;

  /**
  * Name: adjustmentLiabilityAccountingCodeType (adjustmentLiabilityAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("adjustmentLiabilityAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentLiabilityAccountingCodeType;

  /**
  * Name: adjustmentRevenueAccountingCode (adjustmentRevenueAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("adjustmentRevenueAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentRevenueAccountingCode;

  /**
  * Name: adjustmentRevenueAccountingCodeType (adjustmentRevenueAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("adjustmentRevenueAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentRevenueAccountingCodeType;

  /**
  * Name: contractAssetAccountingCode (contractAssetAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractAssetAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractAssetAccountingCode;

  /**
  * Name: contractAssetAccountingCodeType (contractAssetAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractAssetAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractAssetAccountingCodeType;

  /**
  * Name: contractLiabilityAccountingCode (contractLiabilityAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractLiabilityAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractLiabilityAccountingCode;

  /**
  * Name: contractLiabilityAccountingCodeType (contractLiabilityAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractLiabilityAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractLiabilityAccountingCodeType;

  /**
  * Name: contractRecognizedRevenueAccountingCode (contractRecognizedRevenueAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractRecognizedRevenueAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractRecognizedRevenueAccountingCode;

  /**
  * Name: contractRecognizedRevenueAccountingCodeType (contractRecognizedRevenueAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractRecognizedRevenueAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractRecognizedRevenueAccountingCodeType;

  /**
  * Name: deferredRevenueAccountingCode (deferredRevenueAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("deferredRevenueAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deferredRevenueAccountingCode;

  /**
  * Name: deferredRevenueAccountingCodeType (deferredRevenueAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("deferredRevenueAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deferredRevenueAccountingCodeType;

  /**
  * Name: recognizedRevenueAccountingCode (recognizedRevenueAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognizedRevenueAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenueAccountingCode;

  /**
  * Name: recognizedRevenueAccountingCodeType (recognizedRevenueAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognizedRevenueAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenueAccountingCodeType;

  /**
  * Name: unbilledReceivablesAccountingCode (unbilledReceivablesAccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unbilledReceivablesAccountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unbilledReceivablesAccountingCode;

  /**
  * Name: unbilledReceivablesAccountingCodeType (unbilledReceivablesAccountingCodeType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unbilledReceivablesAccountingCodeType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unbilledReceivablesAccountingCodeType;


  @Override
  public void addFields() {
    addCustomField("adjustmentLiabilityAccountingCode", adjustmentLiabilityAccountingCode, String.class);
    addCustomField("adjustmentLiabilityAccountingCodeType", adjustmentLiabilityAccountingCodeType, String.class);
    addCustomField("adjustmentRevenueAccountingCode", adjustmentRevenueAccountingCode, String.class);
    addCustomField("adjustmentRevenueAccountingCodeType", adjustmentRevenueAccountingCodeType, String.class);
    addCustomField("contractAssetAccountingCode", contractAssetAccountingCode, String.class);
    addCustomField("contractAssetAccountingCodeType", contractAssetAccountingCodeType, String.class);
    addCustomField("contractLiabilityAccountingCode", contractLiabilityAccountingCode, String.class);
    addCustomField("contractLiabilityAccountingCodeType", contractLiabilityAccountingCodeType, String.class);
    addCustomField("contractRecognizedRevenueAccountingCode", contractRecognizedRevenueAccountingCode, String.class);
    addCustomField("contractRecognizedRevenueAccountingCodeType", contractRecognizedRevenueAccountingCodeType, String.class);
    addCustomField("deferredRevenueAccountingCode", deferredRevenueAccountingCode, String.class);
    addCustomField("deferredRevenueAccountingCodeType", deferredRevenueAccountingCodeType, String.class);
    addCustomField("recognizedRevenueAccountingCode", recognizedRevenueAccountingCode, String.class);
    addCustomField("recognizedRevenueAccountingCodeType", recognizedRevenueAccountingCodeType, String.class);
    addCustomField("unbilledReceivablesAccountingCode", unbilledReceivablesAccountingCode, String.class);
    addCustomField("unbilledReceivablesAccountingCodeType", unbilledReceivablesAccountingCodeType, String.class);
  }
}

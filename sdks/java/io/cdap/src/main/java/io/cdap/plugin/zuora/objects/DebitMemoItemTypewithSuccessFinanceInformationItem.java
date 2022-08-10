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
* Object name: DebitMemoItemTypewithSuccessFinanceInformationItem (DebitMemoItemTypewithSuccessFinanceInformationItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "DebitMemoItemTypewithSuccessFinanceInformationItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class DebitMemoItemTypewithSuccessFinanceInformationItem extends BaseObject {
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
  * Name: revenueRecognitionRuleName (revenueRecognitionRuleName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueRecognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueRecognitionRuleName;

  /**
  * Name: revenueScheduleNumber (revenueScheduleNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueScheduleNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueScheduleNumber;


  @Override
  public void addFields() {
    addCustomField("deferredRevenueAccountingCode", deferredRevenueAccountingCode, String.class);
    addCustomField("deferredRevenueAccountingCodeType", deferredRevenueAccountingCodeType, String.class);
    addCustomField("recognizedRevenueAccountingCode", recognizedRevenueAccountingCode, String.class);
    addCustomField("recognizedRevenueAccountingCodeType", recognizedRevenueAccountingCodeType, String.class);
    addCustomField("revenueRecognitionRuleName", revenueRecognitionRuleName, String.class);
    addCustomField("revenueScheduleNumber", revenueScheduleNumber, String.class);
  }
}

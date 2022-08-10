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
* Object name: ProcessingOptions (ProcessingOptions).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProcessingOptions",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProcessingOptions extends BaseObject {
  /**
  * Name: applyCreditBalance (applyCreditBalance), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("applyCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean applyCreditBalance;

  /**
  * Name: collectPayment (collectPayment), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("collectPayment")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean collectPayment;

  /**
  * Name: electronicPaymentOptions (electronicPaymentOptions), Type: ProcessingOptionsElectronicPaymentOptionsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("electronicPaymentOptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String electronicPaymentOptions;

  /**
  * Name: runBilling (runBilling), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runBilling")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean runBilling;


  @Override
  public void addFields() {
    addCustomField("applyCreditBalance", applyCreditBalance, Boolean.class);
    addCustomField("collectPayment", collectPayment, Boolean.class);
    addCustomField("electronicPaymentOptions", electronicPaymentOptions, String.class);
    addCustomField("runBilling", runBilling, Boolean.class);
  }
}

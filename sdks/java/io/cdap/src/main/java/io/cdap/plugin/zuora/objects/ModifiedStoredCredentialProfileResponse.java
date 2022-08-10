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
* Object name: ModifiedStoredCredentialProfileResponse (ModifiedStoredCredentialProfileResponse).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ModifiedStoredCredentialProfileResponse",
  RequiredArguments = {
    "payment-method-id", "profile-number"
  },
  APIUrl = "payment-methods/{payment-method-id}/profiles/{profile-number}/expire",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class ModifiedStoredCredentialProfileResponse extends BaseObject {
  /**
  * Name: number (number), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer number;

  /**
  * Name: paymentMethodId (paymentMethodId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;


  @Override
  public void addFields() {
    addCustomField("number", number, Integer.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("success", success, Boolean.class);
  }
}

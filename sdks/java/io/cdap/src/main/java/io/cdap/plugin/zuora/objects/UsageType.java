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
* Object name: UsageType (UsageType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "UsageType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class UsageType extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: accountName (accountName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountName;

  /**
  * Name: accountNumber (accountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: chargeNumber (chargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: quantity (quantity), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: sourceName (sourceName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceName;

  /**
  * Name: startDateTime (startDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDateTime;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: submissionDateTime (submissionDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("submissionDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submissionDateTime;

  /**
  * Name: subscriptionNumber (subscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: unitOfMeasure (unitOfMeasure), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unitOfMeasure")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unitOfMeasure;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountName", accountName, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("id", id, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("sourceName", sourceName, String.class);
    addCustomField("startDateTime", startDateTime, String.class);
    addCustomField("status", status, String.class);
    addCustomField("submissionDateTime", submissionDateTime, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
  }
}

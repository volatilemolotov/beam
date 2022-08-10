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
* Object name: BillingPreviewRunResponse (BillingPreviewRunResponse).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "BillingPreviewRunResponse",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class BillingPreviewRunResponse extends BaseObject {
  /**
  * Name: assumeRenewal (assumeRenewal), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("assumeRenewal")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String assumeRenewal;

  /**
  * Name: batch (batch), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
  * Name: chargeTypeToExclude (chargeTypeToExclude), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeTypeToExclude")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeTypeToExclude;

  /**
  * Name: createdById (createdById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: createdDate (createdDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: endDate (endDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
  * Name: errorMessage (errorMessage), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("errorMessage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String errorMessage;

  /**
  * Name: includingEvergreenSubscription (includingEvergreenSubscription), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includingEvergreenSubscription")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includingEvergreenSubscription;

  /**
  * Name: resultFileUrl (resultFileUrl), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resultFileUrl")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resultFileUrl;

  /**
  * Name: runNumber (runNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runNumber;

  /**
  * Name: startDate (startDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: succeededAccounts (succeededAccounts), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("succeededAccounts")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer succeededAccounts;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: targetDate (targetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
  * Name: totalAccounts (totalAccounts), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalAccounts")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer totalAccounts;

  /**
  * Name: updatedById (updatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: updatedDate (updatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("assumeRenewal", assumeRenewal, String.class);
    addCustomField("batch", batch, String.class);
    addCustomField("chargeTypeToExclude", chargeTypeToExclude, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("endDate", endDate, String.class);
    addCustomField("errorMessage", errorMessage, String.class);
    addCustomField("includingEvergreenSubscription", includingEvergreenSubscription, Boolean.class);
    addCustomField("resultFileUrl", resultFileUrl, String.class);
    addCustomField("runNumber", runNumber, String.class);
    addCustomField("startDate", startDate, String.class);
    addCustomField("status", status, String.class);
    addCustomField("succeededAccounts", succeededAccounts, Integer.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("totalAccounts", totalAccounts, Integer.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

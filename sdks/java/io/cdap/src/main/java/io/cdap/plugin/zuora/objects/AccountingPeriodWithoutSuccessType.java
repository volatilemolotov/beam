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
* Object name: AccountingPeriodWithoutSuccessType (AccountingPeriodWithoutSuccessType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountingPeriodWithoutSuccessType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountingPeriodWithoutSuccessType extends BaseObject {
  /**
  * Name: createdBy (createdBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdBy;

  /**
  * Name: createdOn (createdOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdOn;

  /**
  * Name: endDate (endDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDate;

  /**
  * Name: fileIds (fileIds), Type: AccountingPeriodWithoutSuccessTypeFileIdsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("fileIds")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fileIds;

  /**
  * Name: fiscalYear (fiscalYear), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("fiscalYear")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fiscalYear;

  /**
  * Name: fiscal_quarter (fiscal_quarter), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("fiscal_quarter")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer fiscal_quarter;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: runTrialBalanceEnd (runTrialBalanceEnd), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runTrialBalanceEnd")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runTrialBalanceEnd;

  /**
  * Name: runTrialBalanceErrorMessage (runTrialBalanceErrorMessage), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runTrialBalanceErrorMessage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runTrialBalanceErrorMessage;

  /**
  * Name: runTrialBalanceStart (runTrialBalanceStart), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runTrialBalanceStart")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runTrialBalanceStart;

  /**
  * Name: runTrialBalanceStatus (runTrialBalanceStatus), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runTrialBalanceStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runTrialBalanceStatus;

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
  * Name: updatedBy (updatedBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedBy;

  /**
  * Name: updatedOn (updatedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedOn;


  @Override
  public void addFields() {
    addCustomField("createdBy", createdBy, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("endDate", endDate, String.class);
    addCustomField("fileIds", fileIds, String.class);
    addCustomField("fiscalYear", fiscalYear, String.class);
    addCustomField("fiscal_quarter", fiscal_quarter, Integer.class);
    addCustomField("id", id, String.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("runTrialBalanceEnd", runTrialBalanceEnd, String.class);
    addCustomField("runTrialBalanceErrorMessage", runTrialBalanceErrorMessage, String.class);
    addCustomField("runTrialBalanceStart", runTrialBalanceStart, String.class);
    addCustomField("runTrialBalanceStatus", runTrialBalanceStatus, String.class);
    addCustomField("startDate", startDate, String.class);
    addCustomField("status", status, String.class);
    addCustomField("updatedBy", updatedBy, String.class);
    addCustomField("updatedOn", updatedOn, String.class);
  }
}

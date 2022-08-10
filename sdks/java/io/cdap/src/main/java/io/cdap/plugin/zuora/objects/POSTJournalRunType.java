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

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: POSTJournalRunType (POSTJournalRunType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTJournalRunType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTJournalRunType extends BaseObject {
  /**
  * Name: accountingPeriodName (accountingPeriodName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingPeriodName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingPeriodName;

  /**
  * Name: journalEntryDate (journalEntryDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("journalEntryDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String journalEntryDate;

  /**
  * Name: targetEndDate (targetEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetEndDate;

  /**
  * Name: targetStartDate (targetStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetStartDate;

  /**
  * Name: transactionTypes (transactionTypes), Type: array|POSTJournalRunTransactionType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transactionTypes")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTJournalRunTransactionType")
  private List<POSTJournalRunTransactionType> transactionTypes;


  @Override
  public void addFields() {
    addCustomField("accountingPeriodName", accountingPeriodName, String.class);
    addCustomField("journalEntryDate", journalEntryDate, String.class);
    addCustomField("targetEndDate", targetEndDate, String.class);
    addCustomField("targetStartDate", targetStartDate, String.class);
    addCustomField("transactionTypes", transactionTypes, List.class);
  }
}

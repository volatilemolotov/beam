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
* Object name: JournalRunType (JournalRunType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "JournalRunType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class JournalRunType extends BaseObject {
  /**
  * Name: aggregateCurrency (aggregateCurrency), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("aggregateCurrency")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean aggregateCurrency;

  /**
  * Name: executedOn (executedOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("executedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String executedOn;

  /**
  * Name: journalEntryDate (journalEntryDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("journalEntryDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String journalEntryDate;

  /**
  * Name: number (number), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
  * Name: segmentationRuleName (segmentationRuleName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("segmentationRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String segmentationRuleName;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: success (success), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

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
  * Name: totalJournalEntryCount (totalJournalEntryCount), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalJournalEntryCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer totalJournalEntryCount;

  /**
  * Name: transactionTypes (transactionTypes), Type: array|JournalRunTransactionType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transactionTypes")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JournalRunTransactionType")
  private List<JournalRunTransactionType> transactionTypes;


  @Override
  public void addFields() {
    addCustomField("aggregateCurrency", aggregateCurrency, Boolean.class);
    addCustomField("executedOn", executedOn, String.class);
    addCustomField("journalEntryDate", journalEntryDate, String.class);
    addCustomField("number", number, String.class);
    addCustomField("segmentationRuleName", segmentationRuleName, String.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("targetEndDate", targetEndDate, String.class);
    addCustomField("targetStartDate", targetStartDate, String.class);
    addCustomField("totalJournalEntryCount", totalJournalEntryCount, Integer.class);
    addCustomField("transactionTypes", transactionTypes, List.class);
  }
}

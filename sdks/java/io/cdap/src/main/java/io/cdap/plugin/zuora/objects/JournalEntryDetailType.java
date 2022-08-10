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
* Object name: JournalEntryDetailType (JournalEntryDetailType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "JournalEntryDetailType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class JournalEntryDetailType extends BaseObject {
  /**
  * Name: accountingPeriodName (accountingPeriodName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingPeriodName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingPeriodName;

  /**
  * Name: aggregateCurrency (aggregateCurrency), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("aggregateCurrency")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean aggregateCurrency;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: homeCurrency (homeCurrency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("homeCurrency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String homeCurrency;

  /**
  * Name: journalEntryDate (journalEntryDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("journalEntryDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String journalEntryDate;

  /**
  * Name: journalEntryItems (journalEntryItems), Type: array|JournalEntryItemType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("journalEntryItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JournalEntryItemType")
  private List<JournalEntryItemType> journalEntryItems;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: number (number), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
  * Name: segments (segments), Type: array|JournalEntrySegmentType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("segments")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "JournalEntrySegmentType")
  private List<JournalEntrySegmentType> segments;

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
  * Name: timePeriodEnd (timePeriodEnd), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("timePeriodEnd")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String timePeriodEnd;

  /**
  * Name: timePeriodStart (timePeriodStart), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("timePeriodStart")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String timePeriodStart;

  /**
  * Name: transactionType (transactionType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transactionType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transactionType;

  /**
  * Name: transferDateTime (transferDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferDateTime;

  /**
  * Name: transferredBy (transferredBy), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferredBy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredBy;

  /**
  * Name: transferredToAccounting (transferredToAccounting), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;


  @Override
  public void addFields() {
    addCustomField("accountingPeriodName", accountingPeriodName, String.class);
    addCustomField("aggregateCurrency", aggregateCurrency, Boolean.class);
    addCustomField("currency", currency, String.class);
    addCustomField("homeCurrency", homeCurrency, String.class);
    addCustomField("journalEntryDate", journalEntryDate, String.class);
    addCustomField("journalEntryItems", journalEntryItems, List.class);
    addCustomField("notes", notes, String.class);
    addCustomField("number", number, String.class);
    addCustomField("segments", segments, List.class);
    addCustomField("status", status, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("timePeriodEnd", timePeriodEnd, String.class);
    addCustomField("timePeriodStart", timePeriodStart, String.class);
    addCustomField("transactionType", transactionType, String.class);
    addCustomField("transferDateTime", transferDateTime, String.class);
    addCustomField("transferredBy", transferredBy, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
  }
}

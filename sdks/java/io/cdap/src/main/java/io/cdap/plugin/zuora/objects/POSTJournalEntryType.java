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
* Object name: POSTJournalEntryType (POSTJournalEntryType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTJournalEntryType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTJournalEntryType extends BaseObject {
  /**
  * Name: accountingPeriodName (accountingPeriodName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingPeriodName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingPeriodName;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: journalEntryDate (journalEntryDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("journalEntryDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String journalEntryDate;

  /**
  * Name: journalEntryItems (journalEntryItems), Type: array|POSTJournalEntryItemType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("journalEntryItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTJournalEntryItemType")
  private List<POSTJournalEntryItemType> journalEntryItems;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: segments (segments), Type: array|POSTJournalEntrySegmentType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("segments")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTJournalEntrySegmentType")
  private List<POSTJournalEntrySegmentType> segments;

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
    addCustomField("currency", currency, String.class);
    addCustomField("journalEntryDate", journalEntryDate, String.class);
    addCustomField("journalEntryItems", journalEntryItems, List.class);
    addCustomField("notes", notes, String.class);
    addCustomField("segments", segments, List.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
  }
}

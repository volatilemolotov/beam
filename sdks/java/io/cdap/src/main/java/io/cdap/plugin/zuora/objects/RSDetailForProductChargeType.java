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
* Object name: RSDetailForProductChargeType (RSDetailForProductChargeType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "RSDetailForProductChargeType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class RSDetailForProductChargeType extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: amount (amount), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: createdOn (createdOn), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdOn;

  /**
  * Name: currency (currency), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: linkedTransactionId (linkedTransactionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("linkedTransactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String linkedTransactionId;

  /**
  * Name: linkedTransactionNumber (linkedTransactionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("linkedTransactionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String linkedTransactionNumber;

  /**
  * Name: linkedTransactionType (linkedTransactionType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("linkedTransactionType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String linkedTransactionType;

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
  * Name: productChargeId (productChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productChargeId;

  /**
  * Name: recognitionRuleName (recognitionRuleName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognitionRuleName;

  /**
  * Name: recognizedRevenue (recognizedRevenue), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("recognizedRevenue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevenue;

  /**
  * Name: referenceId (referenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
  * Name: revenueItems (revenueItems), Type: array|RsRevenueItemType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "RsRevenueItemType")
  private List<RsRevenueItemType> revenueItems;

  /**
  * Name: revenueScheduleDate (revenueScheduleDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueScheduleDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueScheduleDate;

  /**
  * Name: undistributedUnrecognizedRevenue (undistributedUnrecognizedRevenue), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("undistributedUnrecognizedRevenue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String undistributedUnrecognizedRevenue;

  /**
  * Name: unrecognizedRevenue (unrecognizedRevenue), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unrecognizedRevenue")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unrecognizedRevenue;

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
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("createdOn", createdOn, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("linkedTransactionId", linkedTransactionId, String.class);
    addCustomField("linkedTransactionNumber", linkedTransactionNumber, String.class);
    addCustomField("linkedTransactionType", linkedTransactionType, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("number", number, String.class);
    addCustomField("productChargeId", productChargeId, String.class);
    addCustomField("recognitionRuleName", recognitionRuleName, String.class);
    addCustomField("recognizedRevenue", recognizedRevenue, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("revenueItems", revenueItems, List.class);
    addCustomField("revenueScheduleDate", revenueScheduleDate, String.class);
    addCustomField("undistributedUnrecognizedRevenue", undistributedUnrecognizedRevenue, String.class);
    addCustomField("unrecognizedRevenue", unrecognizedRevenue, String.class);
    addCustomField("updatedOn", updatedOn, String.class);
  }
}

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
* Object name: POSTSubscriptionPreviewType (POSTSubscriptionPreviewType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTSubscriptionPreviewType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTSubscriptionPreviewType extends BaseObject {
  /**
  * Name: accountKey (accountKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountKey;

  /**
  * Name: contractEffectiveDate (contractEffectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
  * Name: customerAcceptanceDate (customerAcceptanceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerAcceptanceDate;

  /**
  * Name: includeExistingDraftDocItems (includeExistingDraftDocItems), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includeExistingDraftDocItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includeExistingDraftDocItems;

  /**
  * Name: includeExistingDraftInvoiceItems (includeExistingDraftInvoiceItems), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includeExistingDraftInvoiceItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includeExistingDraftInvoiceItems;

  /**
  * Name: initialTerm (initialTerm), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer initialTerm;

  /**
  * Name: initialTermPeriodType (initialTermPeriodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String initialTermPeriodType;

  /**
  * Name: invoiceOwnerAccountKey (invoiceOwnerAccountKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceOwnerAccountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerAccountKey;

  /**
  * Name: invoiceTargetDate (invoiceTargetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: previewType (previewType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("previewType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previewType;

  /**
  * Name: serviceActivationDate (serviceActivationDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;

  /**
  * Name: subscribeToRatePlans (subscribeToRatePlans), Type: array|POSTSrpCreateType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscribeToRatePlans")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTSrpCreateType")
  private List<POSTSrpCreateType> subscribeToRatePlans;

  /**
  * Name: targetDate (targetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
  * Name: termStartDate (termStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termStartDate;

  /**
  * Name: termType (termType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("termType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termType;


  @Override
  public void addFields() {
    addCustomField("accountKey", accountKey, String.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("customerAcceptanceDate", customerAcceptanceDate, String.class);
    addCustomField("includeExistingDraftDocItems", includeExistingDraftDocItems, Boolean.class);
    addCustomField("includeExistingDraftInvoiceItems", includeExistingDraftInvoiceItems, Boolean.class);
    addCustomField("initialTerm", initialTerm, Integer.class);
    addCustomField("initialTermPeriodType", initialTermPeriodType, String.class);
    addCustomField("invoiceOwnerAccountKey", invoiceOwnerAccountKey, String.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("previewType", previewType, String.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
    addCustomField("subscribeToRatePlans", subscribeToRatePlans, List.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
  }
}

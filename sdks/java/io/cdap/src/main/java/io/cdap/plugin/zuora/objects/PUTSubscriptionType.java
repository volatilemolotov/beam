/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import java.util.List;
import javax.annotation.Nullable;

/** Object name: PUTSubscriptionType (PUTSubscriptionType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTSubscriptionType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTSubscriptionType extends BaseObject {
  /**
   * Name: add (add), Type: array|PUTSrpAddType. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("add")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PUTSrpAddType")
  private List<PUTSrpAddType> add;

  /**
   * Name: applyCreditBalance (applyCreditBalance), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("applyCreditBalance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean applyCreditBalance;

  /**
   * Name: autoRenew (autoRenew), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
   * Name: collect (collect), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("collect")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean collect;

  /**
   * Name: currentTerm (currentTerm), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("currentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer currentTerm;

  /**
   * Name: currentTermPeriodType (currentTermPeriodType), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("currentTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currentTermPeriodType;

  /**
   * Name: documentDate (documentDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("documentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentDate;

  /**
   * Name: includeExistingDraftDocItems (includeExistingDraftDocItems), Type: boolean. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("includeExistingDraftDocItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includeExistingDraftDocItems;

  /**
   * Name: includeExistingDraftInvoiceItems (includeExistingDraftInvoiceItems), Type: boolean.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("includeExistingDraftInvoiceItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includeExistingDraftInvoiceItems;

  /**
   * Name: invoice (invoice), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoice;

  /**
   * Name: invoiceCollect (invoiceCollect), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("invoiceCollect")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceCollect;

  /**
   * Name: invoiceSeparately (invoiceSeparately), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceSeparately")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceSeparately;

  /**
   * Name: invoiceTargetDate (invoiceTargetDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
   * Name: preview (preview), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("preview")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean preview;

  /**
   * Name: previewType (previewType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("previewType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previewType;

  /**
   * Name: remove (remove), Type: array|PUTSrpRemoveType. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("remove")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PUTSrpRemoveType")
  private List<PUTSrpRemoveType> remove;

  /**
   * Name: renewalSetting (renewalSetting), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("renewalSetting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalSetting;

  /**
   * Name: renewalTerm (renewalTerm), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("renewalTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer renewalTerm;

  /**
   * Name: renewalTermPeriodType (renewalTermPeriodType), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("renewalTermPeriodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalTermPeriodType;

  /**
   * Name: runBilling (runBilling), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("runBilling")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean runBilling;

  /**
   * Name: targetDate (targetDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
   * Name: termStartDate (termStartDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("termStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termStartDate;

  /**
   * Name: termType (termType), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("termType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String termType;

  /**
   * Name: update (update), Type: array|PUTSrpUpdateType. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("update")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PUTSrpUpdateType")
  private List<PUTSrpUpdateType> update;

  @Override
  public void addFields() {
    addCustomField("add", add, List.class);
    addCustomField("applyCreditBalance", applyCreditBalance, Boolean.class);
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("collect", collect, Boolean.class);
    addCustomField("currentTerm", currentTerm, Integer.class);
    addCustomField("currentTermPeriodType", currentTermPeriodType, String.class);
    addCustomField("documentDate", documentDate, String.class);
    addCustomField("includeExistingDraftDocItems", includeExistingDraftDocItems, Boolean.class);
    addCustomField(
        "includeExistingDraftInvoiceItems", includeExistingDraftInvoiceItems, Boolean.class);
    addCustomField("invoice", invoice, Boolean.class);
    addCustomField("invoiceCollect", invoiceCollect, Boolean.class);
    addCustomField("invoiceSeparately", invoiceSeparately, Boolean.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("preview", preview, Boolean.class);
    addCustomField("previewType", previewType, String.class);
    addCustomField("remove", remove, List.class);
    addCustomField("renewalSetting", renewalSetting, String.class);
    addCustomField("renewalTerm", renewalTerm, Integer.class);
    addCustomField("renewalTermPeriodType", renewalTermPeriodType, String.class);
    addCustomField("runBilling", runBilling, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
    addCustomField("update", update, List.class);
  }
}

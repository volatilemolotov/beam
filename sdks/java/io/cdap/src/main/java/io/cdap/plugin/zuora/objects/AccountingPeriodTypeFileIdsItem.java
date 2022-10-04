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
import javax.annotation.Nullable;

/**
 * Object name: AccountingPeriodTypeFileIdsItem (AccountingPeriodTypeFileIdsItem). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AccountingPeriodTypeFileIdsItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AccountingPeriodTypeFileIdsItem extends BaseObject {
  /**
   * Name: accountsReceivableAccountAgingDetailExportFileId
   * (accountsReceivableAccountAgingDetailExportFileId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("accountsReceivableAccountAgingDetailExportFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountsReceivableAccountAgingDetailExportFileId;

  /**
   * Name: accountsReceivableInvoiceAgingDetailExportFileId
   * (accountsReceivableInvoiceAgingDetailExportFileId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("accountsReceivableInvoiceAgingDetailExportFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountsReceivableInvoiceAgingDetailExportFileId;

  /**
   * Name: arRollForwardDetailExportFileId (arRollForwardDetailExportFileId), Type: string. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("arRollForwardDetailExportFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String arRollForwardDetailExportFileId;

  /**
   * Name: fxRealizedGainAndLossDetailExportFileId (fxRealizedGainAndLossDetailExportFileId), Type:
   * string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("fxRealizedGainAndLossDetailExportFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fxRealizedGainAndLossDetailExportFileId;

  /**
   * Name: fxUnrealizedGainAndLossDetailExportFileId (fxUnrealizedGainAndLossDetailExportFileId),
   * Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("fxUnrealizedGainAndLossDetailExportFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fxUnrealizedGainAndLossDetailExportFileId;

  /**
   * Name: revenueDetailCsvFileId (revenueDetailCsvFileId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("revenueDetailCsvFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueDetailCsvFileId;

  /**
   * Name: revenueDetailExcelFileId (revenueDetailExcelFileId), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("revenueDetailExcelFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueDetailExcelFileId;

  /**
   * Name: unprocessedChargesFileId (unprocessedChargesFileId), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("unprocessedChargesFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unprocessedChargesFileId;

  @Override
  public void addFields() {
    addCustomField(
        "accountsReceivableAccountAgingDetailExportFileId",
        accountsReceivableAccountAgingDetailExportFileId,
        String.class);
    addCustomField(
        "accountsReceivableInvoiceAgingDetailExportFileId",
        accountsReceivableInvoiceAgingDetailExportFileId,
        String.class);
    addCustomField(
        "arRollForwardDetailExportFileId", arRollForwardDetailExportFileId, String.class);
    addCustomField(
        "fxRealizedGainAndLossDetailExportFileId",
        fxRealizedGainAndLossDetailExportFileId,
        String.class);
    addCustomField(
        "fxUnrealizedGainAndLossDetailExportFileId",
        fxUnrealizedGainAndLossDetailExportFileId,
        String.class);
    addCustomField("revenueDetailCsvFileId", revenueDetailCsvFileId, String.class);
    addCustomField("revenueDetailExcelFileId", revenueDetailExcelFileId, String.class);
    addCustomField("unprocessedChargesFileId", unprocessedChargesFileId, String.class);
  }
}

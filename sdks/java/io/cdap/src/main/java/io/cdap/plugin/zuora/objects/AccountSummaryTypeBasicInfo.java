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

/** Object name: AccountSummaryTypeBasicInfo (AccountSummaryTypeBasicInfo). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AccountSummaryTypeBasicInfo",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AccountSummaryTypeBasicInfo extends BaseObject {
  /**
   * Name: accountNumber (accountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
   * Name: additionalEmailAddresses (additionalEmailAddresses), Type:
   * array|AccountSummaryTypeBasicInfoAdditionalEmailAddressesItem. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("additionalEmailAddresses")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "AccountSummaryTypeBasicInfoAdditionalEmailAddressesItem")
  private List<AccountSummaryTypeBasicInfoAdditionalEmailAddressesItem> additionalEmailAddresses;

  /**
   * Name: balance (balance), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /** Name: batch (batch), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
   * Name: billCycleDay (billCycleDay), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleDay;

  /**
   * Name: currency (currency), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
   * Name: defaultPaymentMethod (defaultPaymentMethod), Type:
   * AccountSummaryTypeBasicInfoDefaultPaymentMethodItem. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("defaultPaymentMethod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String defaultPaymentMethod;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: invoiceDeliveryPrefsEmail (invoiceDeliveryPrefsEmail), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceDeliveryPrefsEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceDeliveryPrefsEmail;

  /**
   * Name: invoiceDeliveryPrefsPrint (invoiceDeliveryPrefsPrint), Type: boolean. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceDeliveryPrefsPrint")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceDeliveryPrefsPrint;

  /**
   * Name: lastInvoiceDate (lastInvoiceDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("lastInvoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastInvoiceDate;

  /**
   * Name: lastPaymentAmount (lastPaymentAmount), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("lastPaymentAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastPaymentAmount;

  /**
   * Name: lastPaymentDate (lastPaymentDate), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("lastPaymentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastPaymentDate;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /** Name: tags (tags), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tags")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tags;

  @Override
  public void addFields() {
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("additionalEmailAddresses", additionalEmailAddresses, List.class);
    addCustomField("balance", balance, String.class);
    addCustomField("batch", batch, String.class);
    addCustomField("billCycleDay", billCycleDay, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("defaultPaymentMethod", defaultPaymentMethod, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceDeliveryPrefsEmail", invoiceDeliveryPrefsEmail, Boolean.class);
    addCustomField("invoiceDeliveryPrefsPrint", invoiceDeliveryPrefsPrint, Boolean.class);
    addCustomField("lastInvoiceDate", lastInvoiceDate, String.class);
    addCustomField("lastPaymentAmount", lastPaymentAmount, String.class);
    addCustomField("lastPaymentDate", lastPaymentDate, String.class);
    addCustomField("name", name, String.class);
    addCustomField("status", status, String.class);
    addCustomField("tags", tags, String.class);
  }
}

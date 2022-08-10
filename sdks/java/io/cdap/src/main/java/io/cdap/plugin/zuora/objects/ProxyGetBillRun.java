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
* Object name: ProxyGetBillRun (ProxyGetBillRun).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetBillRun",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetBillRun extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AutoEmail (AutoEmail), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoEmail;

  /**
  * Name: AutoPost (AutoPost), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoPost")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoPost;

  /**
  * Name: AutoRenewal (AutoRenewal), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoRenewal")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenewal;

  /**
  * Name: Batch (Batch), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
  * Name: BillCycleDay (BillCycleDay), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billCycleDay")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billCycleDay;

  /**
  * Name: BillRunNumber (BillRunNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billRunNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billRunNumber;

  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: ExecutedDate (ExecutedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("executedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String executedDate;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: InvoiceDate (InvoiceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceDate;

  /**
  * Name: InvoicesEmailed (InvoicesEmailed), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoicesEmailed")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoicesEmailed;

  /**
  * Name: LastEmailSentTime (LastEmailSentTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("lastEmailSentTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastEmailSentTime;

  /**
  * Name: NoEmailForZeroAmountInvoice (NoEmailForZeroAmountInvoice), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("noEmailForZeroAmountInvoice")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean noEmailForZeroAmountInvoice;

  /**
  * Name: NumberOfAccounts (NumberOfAccounts), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numberOfAccounts")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfAccounts;

  /**
  * Name: NumberOfInvoices (NumberOfInvoices), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numberOfInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfInvoices;

  /**
  * Name: Status (Status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: TargetDate (TargetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("autoEmail", autoEmail, Boolean.class);
    addCustomField("autoPost", autoPost, Boolean.class);
    addCustomField("autoRenewal", autoRenewal, Boolean.class);
    addCustomField("batch", batch, String.class);
    addCustomField("billCycleDay", billCycleDay, String.class);
    addCustomField("billRunNumber", billRunNumber, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("executedDate", executedDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceDate", invoiceDate, String.class);
    addCustomField("invoicesEmailed", invoicesEmailed, Boolean.class);
    addCustomField("lastEmailSentTime", lastEmailSentTime, String.class);
    addCustomField("noEmailForZeroAmountInvoice", noEmailForZeroAmountInvoice, Boolean.class);
    addCustomField("numberOfAccounts", numberOfAccounts, Integer.class);
    addCustomField("numberOfInvoices", numberOfInvoices, Integer.class);
    addCustomField("status", status, String.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

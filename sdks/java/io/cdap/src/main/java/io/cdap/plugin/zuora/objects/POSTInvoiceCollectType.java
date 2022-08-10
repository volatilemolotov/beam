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
* Object name: POSTInvoiceCollectType (POSTInvoiceCollectType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTInvoiceCollectType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTInvoiceCollectType extends BaseObject {
  /**
  * Name: accountKey (accountKey), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountKey;

  /**
  * Name: documentDate (documentDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentDate;

  /**
  * Name: invoiceDate (invoiceDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceDate;

  /**
  * Name: invoiceId (invoiceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
  * Name: invoiceTargetDate (invoiceTargetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceTargetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTargetDate;

  /**
  * Name: paymentGateway (paymentGateway), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentGateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentGateway;

  /**
  * Name: targetDate (targetDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;


  @Override
  public void addFields() {
    addCustomField("accountKey", accountKey, String.class);
    addCustomField("documentDate", documentDate, String.class);
    addCustomField("invoiceDate", invoiceDate, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("invoiceTargetDate", invoiceTargetDate, String.class);
    addCustomField("paymentGateway", paymentGateway, String.class);
    addCustomField("targetDate", targetDate, String.class);
  }
}

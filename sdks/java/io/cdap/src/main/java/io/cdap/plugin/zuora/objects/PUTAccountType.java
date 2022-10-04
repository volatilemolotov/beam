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

/** Object name: PUTAccountType (PUTAccountType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTAccountType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTAccountType extends BaseObject {
  /**
   * Name: additionalEmailAddresses (additionalEmailAddresses), Type:
   * array|PUTAccountTypeAdditionalEmailAddressesItem. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("additionalEmailAddresses")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "PUTAccountTypeAdditionalEmailAddressesItem")
  private List<PUTAccountTypeAdditionalEmailAddressesItem> additionalEmailAddresses;

  /**
   * Name: autoPay (autoPay), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("autoPay")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoPay;

  /** Name: batch (batch), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("batch")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String batch;

  /**
   * Name: communicationProfileId (communicationProfileId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("communicationProfileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String communicationProfileId;

  /**
   * Name: creditMemoTemplateId (creditMemoTemplateId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("creditMemoTemplateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String creditMemoTemplateId;

  /** Name: crmId (crmId), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("crmId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String crmId;

  /**
   * Name: debitMemoTemplateId (debitMemoTemplateId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("debitMemoTemplateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String debitMemoTemplateId;

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
   * Name: invoiceTemplateId (invoiceTemplateId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceTemplateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceTemplateId;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
   * Name: parentId (parentId), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("parentId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String parentId;

  /**
   * Name: paymentGateway (paymentGateway), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentGateway")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentGateway;

  /**
   * Name: salesRep (salesRep), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("salesRep")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String salesRep;

  /**
   * Name: sequenceSetId (sequenceSetId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("sequenceSetId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sequenceSetId;

  /**
   * Name: tagging (tagging), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("tagging")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tagging;

  /**
   * Name: taxInfo (taxInfo), Type: PUTAccountTypeTaxInfoItem. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("taxInfo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxInfo;

  @Override
  public void addFields() {
    addCustomField("additionalEmailAddresses", additionalEmailAddresses, List.class);
    addCustomField("autoPay", autoPay, Boolean.class);
    addCustomField("batch", batch, String.class);
    addCustomField("communicationProfileId", communicationProfileId, String.class);
    addCustomField("creditMemoTemplateId", creditMemoTemplateId, String.class);
    addCustomField("crmId", crmId, String.class);
    addCustomField("debitMemoTemplateId", debitMemoTemplateId, String.class);
    addCustomField("invoiceDeliveryPrefsEmail", invoiceDeliveryPrefsEmail, Boolean.class);
    addCustomField("invoiceDeliveryPrefsPrint", invoiceDeliveryPrefsPrint, Boolean.class);
    addCustomField("invoiceTemplateId", invoiceTemplateId, String.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("parentId", parentId, String.class);
    addCustomField("paymentGateway", paymentGateway, String.class);
    addCustomField("salesRep", salesRep, String.class);
    addCustomField("sequenceSetId", sequenceSetId, String.class);
    addCustomField("tagging", tagging, String.class);
    addCustomField("taxInfo", taxInfo, String.class);
  }
}

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

/** Object name: POSTAccountTypeSubscription (POSTAccountTypeSubscription). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTAccountTypeSubscription",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTAccountTypeSubscription extends BaseObject {
  /**
   * Name: autoRenew (autoRenew), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
   * Name: contractEffectiveDate (contractEffectiveDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
   * Name: customerAcceptanceDate (customerAcceptanceDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("customerAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerAcceptanceDate;

  /**
   * Name: initialTerm (initialTerm), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("initialTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer initialTerm;

  /**
   * Name: invoiceOwnerAccountKey (invoiceOwnerAccountKey), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("invoiceOwnerAccountKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceOwnerAccountKey;

  /**
   * Name: invoiceSeparately (invoiceSeparately), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("invoiceSeparately")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean invoiceSeparately;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
   * Name: renewalTerm (renewalTerm), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("renewalTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer renewalTerm;

  /**
   * Name: serviceActivationDate (serviceActivationDate), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;

  /**
   * Name: subscribeToRatePlans (subscribeToRatePlans), Type: array|POSTSrpCreateType. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("subscribeToRatePlans")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTSrpCreateType")
  private List<POSTSrpCreateType> subscribeToRatePlans;

  /**
   * Name: subscriptionNumber (subscriptionNumber), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

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

  @Override
  public void addFields() {
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("customerAcceptanceDate", customerAcceptanceDate, String.class);
    addCustomField("initialTerm", initialTerm, Integer.class);
    addCustomField("invoiceOwnerAccountKey", invoiceOwnerAccountKey, String.class);
    addCustomField("invoiceSeparately", invoiceSeparately, Boolean.class);
    addCustomField("notes", notes, String.class);
    addCustomField("renewalTerm", renewalTerm, Integer.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
    addCustomField("subscribeToRatePlans", subscribeToRatePlans, List.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("termStartDate", termStartDate, String.class);
    addCustomField("termType", termType, String.class);
  }
}

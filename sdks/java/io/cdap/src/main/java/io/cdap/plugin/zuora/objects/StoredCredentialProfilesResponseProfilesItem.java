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
 * Object name: StoredCredentialProfilesResponseProfilesItem
 * (StoredCredentialProfilesResponseProfilesItem). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "StoredCredentialProfilesResponseProfilesItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class StoredCredentialProfilesResponseProfilesItem extends BaseObject {
  /**
   * Name: activatedOn (activatedOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("activatedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String activatedOn;

  /**
   * Name: agreedOn (agreedOn), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("agreedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String agreedOn;

  /** Name: brand (brand), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("brand")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String brand;

  /**
   * Name: cancelledOn (cancelledOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("cancelledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledOn;

  /**
   * Name: consentAgreementRef (consentAgreementRef), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("consentAgreementRef")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String consentAgreementRef;

  /**
   * Name: consentAgreementSrc (consentAgreementSrc), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("consentAgreementSrc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String consentAgreementSrc;

  /**
   * Name: expiredOn (expiredOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("expiredOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String expiredOn;

  /** Name: number (number), Type: integer. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer number;

  /**
   * Name: paymentMethodId (paymentMethodId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("activatedOn", activatedOn, String.class);
    addCustomField("agreedOn", agreedOn, String.class);
    addCustomField("brand", brand, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("consentAgreementRef", consentAgreementRef, String.class);
    addCustomField("consentAgreementSrc", consentAgreementSrc, String.class);
    addCustomField("expiredOn", expiredOn, String.class);
    addCustomField("number", number, Integer.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("type", type, String.class);
  }
}

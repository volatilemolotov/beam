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
 * Object name: AccountSummaryTypeBillToContact (AccountSummaryTypeBillToContact). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "AccountSummaryTypeBillToContact",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class AccountSummaryTypeBillToContact extends BaseObject {
  /**
   * Name: address1 (address1), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("address1")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String address1;

  /**
   * Name: address2 (address2), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("address2")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String address2;

  /** Name: city (city), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("city")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String city;

  /**
   * Name: country (country), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("country")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String country;

  /** Name: county (county), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("county")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String county;

  /** Name: fax (fax), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("fax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fax;

  /**
   * Name: firstName (firstName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("firstName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String firstName;

  /** Name: id (id), Type: string . Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
   * Name: lastName (lastName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("lastName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastName;

  /** Name: state (state), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("state")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String state;

  /**
   * Name: taxRegion (taxRegion), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxRegion")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRegion;

  /**
   * Name: workEmail (workEmail), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("workEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String workEmail;

  /**
   * Name: workPhone (workPhone), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("workPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String workPhone;

  /**
   * Name: zipCode (zipCode), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("zipCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String zipCode;

  @Override
  public void addFields() {
    addCustomField("address1", address1, String.class);
    addCustomField("address2", address2, String.class);
    addCustomField("city", city, String.class);
    addCustomField("country", country, String.class);
    addCustomField("county", county, String.class);
    addCustomField("fax", fax, String.class);
    addCustomField("firstName", firstName, String.class);
    addCustomField("id", id, String.class);
    addCustomField("lastName", lastName, String.class);
    addCustomField("state", state, String.class);
    addCustomField("taxRegion", taxRegion, String.class);
    addCustomField("workEmail", workEmail, String.class);
    addCustomField("workPhone", workPhone, String.class);
    addCustomField("zipCode", zipCode, String.class);
  }
}

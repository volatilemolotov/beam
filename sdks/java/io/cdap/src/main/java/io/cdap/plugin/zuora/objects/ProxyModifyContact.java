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

/** Object name: ProxyModifyContact (ProxyModifyContact). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyModifyContact",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyModifyContact extends BaseObject {
  /**
   * Name: AccountId (AccountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
   * Name: Address1 (Address1), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("address1")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String address1;

  /**
   * Name: Address2 (Address2), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("address2")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String address2;

  /** Name: City (City), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("city")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String city;

  /**
   * Name: Country (Country), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("country")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String country;

  /** Name: County (County), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("county")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String county;

  /**
   * Name: Description (Description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /** Name: Fax (Fax), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("fax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fax;

  /**
   * Name: FirstName (FirstName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("firstName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String firstName;

  /**
   * Name: HomePhone (HomePhone), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("homePhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String homePhone;

  /**
   * Name: LastName (LastName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("lastName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String lastName;

  /**
   * Name: MobilePhone (MobilePhone), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("mobilePhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String mobilePhone;

  /**
   * Name: NickName (NickName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("nickName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String nickName;

  /**
   * Name: OtherPhone (OtherPhone), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("otherPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String otherPhone;

  /**
   * Name: OtherPhoneType (OtherPhoneType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("otherPhoneType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String otherPhoneType;

  /**
   * Name: PersonalEmail (PersonalEmail), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("personalEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String personalEmail;

  /**
   * Name: PostalCode (PostalCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("postalCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postalCode;

  /** Name: State (State), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("state")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String state;

  /**
   * Name: TaxRegion (TaxRegion), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("taxRegion")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxRegion;

  /**
   * Name: WorkEmail (WorkEmail), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("workEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String workEmail;

  /**
   * Name: WorkPhone (WorkPhone), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("workPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String workPhone;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("address1", address1, String.class);
    addCustomField("address2", address2, String.class);
    addCustomField("city", city, String.class);
    addCustomField("country", country, String.class);
    addCustomField("county", county, String.class);
    addCustomField("description", description, String.class);
    addCustomField("fax", fax, String.class);
    addCustomField("firstName", firstName, String.class);
    addCustomField("homePhone", homePhone, String.class);
    addCustomField("lastName", lastName, String.class);
    addCustomField("mobilePhone", mobilePhone, String.class);
    addCustomField("nickName", nickName, String.class);
    addCustomField("otherPhone", otherPhone, String.class);
    addCustomField("otherPhoneType", otherPhoneType, String.class);
    addCustomField("personalEmail", personalEmail, String.class);
    addCustomField("postalCode", postalCode, String.class);
    addCustomField("state", state, String.class);
    addCustomField("taxRegion", taxRegion, String.class);
    addCustomField("workEmail", workEmail, String.class);
    addCustomField("workPhone", workPhone, String.class);
  }
}

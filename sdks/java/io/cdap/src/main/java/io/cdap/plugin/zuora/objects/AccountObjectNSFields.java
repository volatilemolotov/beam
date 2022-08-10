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
* Object name: AccountObjectNSFields (AccountObjectNSFields).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountObjectNSFields",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountObjectNSFields extends BaseObject {
  /**
  * Name: Class__NS (Class__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("class__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String classNS;

  /**
  * Name: CustomerType__NS (CustomerType__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerType__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerTypeNS;

  /**
  * Name: Department__NS (Department__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("department__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String departmentNS;

  /**
  * Name: IntegrationId__NS (IntegrationId__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("integrationId__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationIdNS;

  /**
  * Name: IntegrationStatus__NS (IntegrationStatus__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("integrationStatus__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationStatusNS;

  /**
  * Name: Location__NS (Location__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("location__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String locationNS;

  /**
  * Name: Subsidiary__NS (Subsidiary__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subsidiary__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subsidiaryNS;

  /**
  * Name: SyncDate__NS (SyncDate__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("syncDate__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String syncDateNS;

  /**
  * Name: SynctoNetSuite__NS (SynctoNetSuite__NS), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("synctoNetSuite__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String synctoNetSuiteNS;


  @Override
  public void addFields() {
    addCustomField("class__NS", classNS, String.class);
    addCustomField("customerType__NS", customerTypeNS, String.class);
    addCustomField("department__NS", departmentNS, String.class);
    addCustomField("integrationId__NS", integrationIdNS, String.class);
    addCustomField("integrationStatus__NS", integrationStatusNS, String.class);
    addCustomField("location__NS", locationNS, String.class);
    addCustomField("subsidiary__NS", subsidiaryNS, String.class);
    addCustomField("syncDate__NS", syncDateNS, String.class);
    addCustomField("synctoNetSuite__NS", synctoNetSuiteNS, String.class);
  }
}

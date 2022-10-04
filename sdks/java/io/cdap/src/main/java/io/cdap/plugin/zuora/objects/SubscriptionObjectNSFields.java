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

/** Object name: SubscriptionObjectNSFields (SubscriptionObjectNSFields). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "SubscriptionObjectNSFields",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class SubscriptionObjectNSFields extends BaseObject {
  /**
   * Name: IntegrationId__NS (IntegrationId__NS), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("integrationId__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationId__NS;

  /**
   * Name: IntegrationStatus__NS (IntegrationStatus__NS), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("integrationStatus__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String integrationStatus__NS;

  /**
   * Name: Project__NS (Project__NS), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("project__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String project__NS;

  /**
   * Name: SalesOrder__NS (SalesOrder__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("salesOrder__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String salesOrder__NS;

  /**
   * Name: SyncDate__NS (SyncDate__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("syncDate__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String syncDate__NS;

  @Override
  public void addFields() {
    addCustomField("integrationId__NS", integrationId__NS, String.class);
    addCustomField("integrationStatus__NS", integrationStatus__NS, String.class);
    addCustomField("project__NS", project__NS, String.class);
    addCustomField("salesOrder__NS", salesOrder__NS, String.class);
    addCustomField("syncDate__NS", syncDate__NS, String.class);
  }
}

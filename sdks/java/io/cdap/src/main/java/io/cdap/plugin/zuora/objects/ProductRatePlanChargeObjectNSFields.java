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
 * Object name: ProductRatePlanChargeObjectNSFields (ProductRatePlanChargeObjectNSFields). Related
 * objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProductRatePlanChargeObjectNSFields",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProductRatePlanChargeObjectNSFields extends BaseObject {
  /**
   * Name: Class__NS (Class__NS), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("class__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String class__NS;

  /**
   * Name: DeferredRevAccount__NS (DeferredRevAccount__NS), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("deferredRevAccount__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String deferredRevAccount__NS;

  /**
   * Name: Department__NS (Department__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("department__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String department__NS;

  /**
   * Name: IncludeChildren__NS (IncludeChildren__NS), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("includeChildren__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String includeChildren__NS;

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
   * Name: ItemType__NS (ItemType__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("itemType__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String itemType__NS;

  /**
   * Name: Location__NS (Location__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("location__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String location__NS;

  /**
   * Name: RecognizedRevAccount__NS (RecognizedRevAccount__NS), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("recognizedRevAccount__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String recognizedRevAccount__NS;

  /**
   * Name: RevRecEnd__NS (RevRecEnd__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("revRecEnd__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecEnd__NS;

  /**
   * Name: RevRecStart__NS (RevRecStart__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("revRecStart__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecStart__NS;

  /**
   * Name: RevRecTemplateType__NS (RevRecTemplateType__NS), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("revRecTemplateType__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecTemplateType__NS;

  /**
   * Name: Subsidiary__NS (Subsidiary__NS), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("subsidiary__NS")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subsidiary__NS;

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
    addCustomField("class__NS", class__NS, String.class);
    addCustomField("deferredRevAccount__NS", deferredRevAccount__NS, String.class);
    addCustomField("department__NS", department__NS, String.class);
    addCustomField("includeChildren__NS", includeChildren__NS, String.class);
    addCustomField("integrationId__NS", integrationId__NS, String.class);
    addCustomField("integrationStatus__NS", integrationStatus__NS, String.class);
    addCustomField("itemType__NS", itemType__NS, String.class);
    addCustomField("location__NS", location__NS, String.class);
    addCustomField("recognizedRevAccount__NS", recognizedRevAccount__NS, String.class);
    addCustomField("revRecEnd__NS", revRecEnd__NS, String.class);
    addCustomField("revRecStart__NS", revRecStart__NS, String.class);
    addCustomField("revRecTemplateType__NS", revRecTemplateType__NS, String.class);
    addCustomField("subsidiary__NS", subsidiary__NS, String.class);
    addCustomField("syncDate__NS", syncDate__NS, String.class);
  }
}

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
 * Object name: PUTPublicNotificationDefinitionRequest (PUTPublicNotificationDefinitionRequest).
 * Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTPublicNotificationDefinitionRequest",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTPublicNotificationDefinitionRequest extends BaseObject {
  /** Name: active (active), Type: boolean. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("active")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean active;

  /**
   * Name: callout (callout), Type: PUTPublicNotificationDefinitionRequestCalloutItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("callout")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String callout;

  /**
   * Name: calloutActive (calloutActive), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("calloutActive")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean calloutActive;

  /**
   * Name: communicationProfileId (communicationProfileId), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("communicationProfileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String communicationProfileId;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: emailActive (emailActive), Type: boolean. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("emailActive")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean emailActive;

  /**
   * Name: emailTemplateId (emailTemplateId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("emailTemplateId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String emailTemplateId;

  /**
   * Name: filterRule (filterRule), Type: PUTPublicNotificationDefinitionRequestFilterRuleItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("filterRule")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String filterRule;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  @Override
  public void addFields() {
    addCustomField("active", active, Boolean.class);
    addCustomField("callout", callout, String.class);
    addCustomField("calloutActive", calloutActive, Boolean.class);
    addCustomField("communicationProfileId", communicationProfileId, String.class);
    addCustomField("description", description, String.class);
    addCustomField("emailActive", emailActive, Boolean.class);
    addCustomField("emailTemplateId", emailTemplateId, String.class);
    addCustomField("filterRule", filterRule, String.class);
    addCustomField("name", name, String.class);
  }
}

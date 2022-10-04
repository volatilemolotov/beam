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

/** Object name: Workflow (Workflow). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "Workflow", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class Workflow extends BaseObject {
  /**
   * Name: calloutTrigger (calloutTrigger), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("calloutTrigger")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean calloutTrigger;

  /**
   * Name: createdAt (createdAt), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createdAt")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdAt;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /** Name: id (id), Type: integer. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer id;

  /**
   * Name: interval (interval), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("interval")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String interval;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: ondemandTrigger (ondemandTrigger), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("ondemandTrigger")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean ondemandTrigger;

  /**
   * Name: scheduledTrigger (scheduledTrigger), Type: boolean. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("scheduledTrigger")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean scheduledTrigger;

  /**
   * Name: timezone (timezone), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("timezone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String timezone;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
   * Name: updatedAt (updatedAt), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("updatedAt")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedAt;

  @Override
  public void addFields() {
    addCustomField("calloutTrigger", calloutTrigger, Boolean.class);
    addCustomField("createdAt", createdAt, String.class);
    addCustomField("description", description, String.class);
    addCustomField("id", id, Integer.class);
    addCustomField("interval", interval, String.class);
    addCustomField("name", name, String.class);
    addCustomField("ondemandTrigger", ondemandTrigger, Boolean.class);
    addCustomField("scheduledTrigger", scheduledTrigger, Boolean.class);
    addCustomField("timezone", timezone, String.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedAt", updatedAt, String.class);
  }
}

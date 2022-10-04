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

/** Object name: Task (Task). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "Task", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class Task extends BaseObject {
  /**
   * Name: action_type (action_type), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("action_type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String action_type;

  /**
   * Name: call_type (call_type), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("call_type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String call_type;

  /**
   * Name: concurrent_limit (concurrent_limit), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("concurrent_limit")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer concurrent_limit;

  /**
   * Name: data (data), Type: TaskDataItem. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("data")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String data;

  /**
   * Name: end_time (end_time), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("end_time")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String end_time;

  /** Name: error (error), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("error")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String error;

  /**
   * Name: error_class (error_class), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("error_class")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String error_class;

  /**
   * Name: error_details (error_details), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("error_details")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String error_details;

  /** Name: id (id), Type: integer. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer id;

  /**
   * Name: instance (instance), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("instance")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean instance;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: object (object), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("object")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String object;

  /**
   * Name: object_id (object_id), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("object_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String object_id;

  /**
   * Name: original_task_id (original_task_id), Type: integer. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("original_task_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer original_task_id;

  /**
   * Name: original_workflow_id (original_workflow_id), Type: integer. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("original_workflow_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer original_workflow_id;

  /**
   * Name: parameters (parameters), Type: TaskParametersItem. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("parameters")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String parameters;

  /**
   * Name: start_time (start_time), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("start_time")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String start_time;

  /** Name: status (status), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
   * Name: tags (tags), Type: array|TaskTagsItem. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("tags")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "TaskTagsItem")
  private List<TaskTagsItem> tags;

  /**
   * Name: task_id (task_id), Type: integer. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("task_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer task_id;

  /**
   * Name: workflow_id (workflow_id), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("workflow_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer workflow_id;

  @Override
  public void addFields() {
    addCustomField("action_type", action_type, String.class);
    addCustomField("call_type", call_type, String.class);
    addCustomField("concurrent_limit", concurrent_limit, Integer.class);
    addCustomField("data", data, String.class);
    addCustomField("end_time", end_time, String.class);
    addCustomField("error", error, String.class);
    addCustomField("error_class", error_class, String.class);
    addCustomField("error_details", error_details, String.class);
    addCustomField("id", id, Integer.class);
    addCustomField("instance", instance, Boolean.class);
    addCustomField("name", name, String.class);
    addCustomField("object", object, String.class);
    addCustomField("object_id", object_id, String.class);
    addCustomField("original_task_id", original_task_id, Integer.class);
    addCustomField("original_workflow_id", original_workflow_id, Integer.class);
    addCustomField("parameters", parameters, String.class);
    addCustomField("start_time", start_time, String.class);
    addCustomField("status", status, String.class);
    addCustomField("tags", tags, List.class);
    addCustomField("task_id", task_id, Integer.class);
    addCustomField("workflow_id", workflow_id, Integer.class);
  }
}

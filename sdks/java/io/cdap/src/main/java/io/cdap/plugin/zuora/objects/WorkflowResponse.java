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
* Object name: WorkflowResponse (WorkflowResponse).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "WorkflowResponse",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class WorkflowResponse extends BaseObject {
  /**
  * Name: cpuTime (cpuTime), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cpuTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cpuTime;

  /**
  * Name: createdAt (createdAt), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdAt")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdAt;

  /**
  * Name: finishedAt (finishedAt), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("finishedAt")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String finishedAt;

  /**
  * Name: id (id), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer id;

  /**
  * Name: messages (messages), Type: WorkflowResponseMessagesItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("messages")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String messages;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: originalWorkflowId (originalWorkflowId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("originalWorkflowId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalWorkflowId;

  /**
  * Name: runTime (runTime), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("runTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String runTime;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: tasks (tasks), Type: WorkflowResponseTasksItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tasks")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tasks;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  /**
  * Name: updatedAt (updatedAt), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedAt")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedAt;


  @Override
  public void addFields() {
    addCustomField("cpuTime", cpuTime, String.class);
    addCustomField("createdAt", createdAt, String.class);
    addCustomField("finishedAt", finishedAt, String.class);
    addCustomField("id", id, Integer.class);
    addCustomField("messages", messages, String.class);
    addCustomField("name", name, String.class);
    addCustomField("originalWorkflowId", originalWorkflowId, String.class);
    addCustomField("runTime", runTime, String.class);
    addCustomField("status", status, String.class);
    addCustomField("tasks", tasks, String.class);
    addCustomField("type", type, String.class);
    addCustomField("updatedAt", updatedAt, String.class);
  }
}

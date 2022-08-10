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

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: UpdateTask (UpdateTask).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "UpdateTask",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class UpdateTask extends BaseObject {
  /**
  * Name: action_type (action_type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("action_type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String action_type;

  /**
  * Name: call_type (call_type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("call_type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String call_type;

  /**
  * Name: concurrent_limit (concurrent_limit), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("concurrent_limit")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer concurrent_limit;

  /**
  * Name: id (id), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer id;

  /**
  * Name: name (name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: object (object), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("object")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String object;

  /**
  * Name: object_id (object_id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("object_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String object_id;

  /**
  * Name: status (status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: tags (tags), Type: array|UpdateTaskTagsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("tags")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "UpdateTaskTagsItem")
  private List<UpdateTaskTagsItem> tags;

  /**
  * Name: workflow_id (workflow_id), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("workflow_id")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer workflow_id;


  @Override
  public void addFields() {
    addCustomField("action_type", action_type, String.class);
    addCustomField("call_type", call_type, String.class);
    addCustomField("concurrent_limit", concurrent_limit, Integer.class);
    addCustomField("id", id, Integer.class);
    addCustomField("name", name, String.class);
    addCustomField("object", object, String.class);
    addCustomField("object_id", object_id, String.class);
    addCustomField("status", status, String.class);
    addCustomField("tags", tags, List.class);
    addCustomField("workflow_id", workflow_id, Integer.class);
  }
}

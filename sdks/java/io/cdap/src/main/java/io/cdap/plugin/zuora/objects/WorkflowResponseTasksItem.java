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
* Object name: WorkflowResponseTasksItem (WorkflowResponseTasksItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "WorkflowResponseTasksItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class WorkflowResponseTasksItem extends BaseObject {
  /**
  * Name: error (error), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("error")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer error;

  /**
  * Name: pending (pending), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pending")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer pending;

  /**
  * Name: processing (processing), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("processing")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer processing;

  /**
  * Name: queued (queued), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("queued")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer queued;

  /**
  * Name: stopped (stopped), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("stopped")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer stopped;

  /**
  * Name: success (success), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer success;

  /**
  * Name: total (total), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("total")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer total;


  @Override
  public void addFields() {
    addCustomField("error", error, Integer.class);
    addCustomField("pending", pending, Integer.class);
    addCustomField("processing", processing, Integer.class);
    addCustomField("queued", queued, Integer.class);
    addCustomField("stopped", stopped, Integer.class);
    addCustomField("success", success, Integer.class);
    addCustomField("total", total, Integer.class);
  }
}

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
* Object name: PostCustomObjectDefinitionRequest (PostCustomObjectDefinitionRequest).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PostCustomObjectDefinitionRequest",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PostCustomObjectDefinitionRequest extends BaseObject {
  /**
  * Name: label (label), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("label")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String label;

  /**
  * Name: object (object), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("object")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String object;

  /**
  * Name: properties (properties), Type: PostCustomObjectDefinitionRequestPropertiesItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("properties")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String properties;

  /**
  * Name: relationships (relationships), Type: array|PostCustomObjectDefinitionRequestRelationshipsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("relationships")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PostCustomObjectDefinitionRequestRelationshipsItem")
  private List<PostCustomObjectDefinitionRequestRelationshipsItem> relationships;

  /**
  * Name: required (required), Type: array|PostCustomObjectDefinitionRequestRequiredItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("required")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PostCustomObjectDefinitionRequestRequiredItem")
  private List<PostCustomObjectDefinitionRequestRequiredItem> required;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;


  @Override
  public void addFields() {
    addCustomField("label", label, String.class);
    addCustomField("object", object, String.class);
    addCustomField("properties", properties, String.class);
    addCustomField("relationships", relationships, List.class);
    addCustomField("required", required, List.class);
    addCustomField("type", type, String.class);
  }
}

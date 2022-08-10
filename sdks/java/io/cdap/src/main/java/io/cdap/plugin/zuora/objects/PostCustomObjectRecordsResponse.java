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
* Object name: PostCustomObjectRecordsResponse (PostCustomObjectRecordsResponse).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PostCustomObjectRecordsResponse",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PostCustomObjectRecordsResponse extends BaseObject {
  /**
  * Name: records (records), Type: array|CustomObjectRecordWithAllFields.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("records")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CustomObjectRecordWithAllFields")
  private List<CustomObjectRecordWithAllFields> records;

  /**
  * Name: unprocessedRecords (unprocessedRecords), Type: array|CustomObjectRecordWithOnlyCustomFields.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unprocessedRecords")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CustomObjectRecordWithOnlyCustomFields")
  private List<CustomObjectRecordWithOnlyCustomFields> unprocessedRecords;


  @Override
  public void addFields() {
    addCustomField("records", records, List.class);
    addCustomField("unprocessedRecords", unprocessedRecords, List.class);
  }
}

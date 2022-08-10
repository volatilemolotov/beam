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
* Object name: ProxyGetImport (ProxyGetImport).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetImport",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetImport extends BaseObject {
  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: Id (Id), Type: string .
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: ImportType (ImportType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("importType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String importType;

  /**
  * Name: ImportedCount (ImportedCount), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("importedCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer importedCount;

  /**
  * Name: Md5 (Md5), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("md5")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String md5;

  /**
  * Name: Name (Name), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: OriginalResourceUrl (OriginalResourceUrl), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("originalResourceUrl")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String originalResourceUrl;

  /**
  * Name: ResultResourceUrl (ResultResourceUrl), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resultResourceUrl")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resultResourceUrl;

  /**
  * Name: Status (Status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: StatusReason (StatusReason), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("statusReason")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String statusReason;

  /**
  * Name: TotalCount (TotalCount), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalCount")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer totalCount;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("importType", importType, String.class);
    addCustomField("importedCount", importedCount, Integer.class);
    addCustomField("md5", md5, String.class);
    addCustomField("name", name, String.class);
    addCustomField("originalResourceUrl", originalResourceUrl, String.class);
    addCustomField("resultResourceUrl", resultResourceUrl, String.class);
    addCustomField("status", status, String.class);
    addCustomField("statusReason", statusReason, String.class);
    addCustomField("totalCount", totalCount, Integer.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

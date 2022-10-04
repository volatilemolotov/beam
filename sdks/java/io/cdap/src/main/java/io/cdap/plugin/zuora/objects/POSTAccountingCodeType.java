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

/** Object name: POSTAccountingCodeType (POSTAccountingCodeType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTAccountingCodeType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTAccountingCodeType extends BaseObject {
  /**
   * Name: glAccountName (glAccountName), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("glAccountName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String glAccountName;

  /**
   * Name: glAccountNumber (glAccountNumber), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("glAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String glAccountNumber;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /** Name: notes (notes), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /** Name: type (type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("glAccountName", glAccountName, String.class);
    addCustomField("glAccountNumber", glAccountNumber, String.class);
    addCustomField("name", name, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("type", type, String.class);
  }
}

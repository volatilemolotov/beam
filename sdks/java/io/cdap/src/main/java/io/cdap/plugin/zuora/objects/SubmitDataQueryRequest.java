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

/** Object name: SubmitDataQueryRequest (SubmitDataQueryRequest). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "SubmitDataQueryRequest",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class SubmitDataQueryRequest extends BaseObject {
  /**
   * Name: columnSeparator (columnSeparator), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("columnSeparator")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String columnSeparator;

  /**
   * Name: compression (compression), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("compression")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String compression;

  /**
   * Name: encryptionKey (encryptionKey), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("encryptionKey")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String encryptionKey;

  /**
   * Name: output (output), Type: SubmitDataQueryRequestOutputItem. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("output")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String output;

  /**
   * Name: outputFormat (outputFormat), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("outputFormat")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String outputFormat;

  /** Name: query (query), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("query")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String query;

  /**
   * Name: useIndexJoin (useIndexJoin), Type: boolean. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("useIndexJoin")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean useIndexJoin;

  @Override
  public void addFields() {
    addCustomField("columnSeparator", columnSeparator, String.class);
    addCustomField("compression", compression, String.class);
    addCustomField("encryptionKey", encryptionKey, String.class);
    addCustomField("output", output, String.class);
    addCustomField("outputFormat", outputFormat, String.class);
    addCustomField("query", query, String.class);
    addCustomField("useIndexJoin", useIndexJoin, Boolean.class);
  }
}

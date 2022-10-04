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

/**
 * Object name: CommonUsageErrorResponseErrorItemErrorsItem
 * (CommonUsageErrorResponseErrorItemErrorsItem). Related objects:
 */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CommonUsageErrorResponseErrorItemErrorsItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class CommonUsageErrorResponseErrorItemErrorsItem extends BaseObject {
  /** Name: field (field), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("field")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String field;

  /**
   * Name: message (message), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("message")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String message;

  /**
   * Name: objectName (objectName), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("objectName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String objectName;

  /** Name: reason (reason), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("reason")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reason;

  @Override
  public void addFields() {
    addCustomField("field", field, String.class);
    addCustomField("message", message, String.class);
    addCustomField("objectName", objectName, String.class);
    addCustomField("reason", reason, String.class);
  }
}

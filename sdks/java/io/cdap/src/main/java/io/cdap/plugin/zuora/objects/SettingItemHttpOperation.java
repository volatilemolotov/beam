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

/** Object name: SettingItemHttpOperation (SettingItemHttpOperation). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "SettingItemHttpOperation",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class SettingItemHttpOperation extends BaseObject {
  /** Name: method (method), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("method")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String method;

  /**
   * Name: parameters (parameters), Type: array|SettingItemHttpRequestParameter. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("parameters")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "SettingItemHttpRequestParameter")
  private List<SettingItemHttpRequestParameter> parameters;

  /**
   * Name: requestType (requestType), Type: SettingItemHttpOperationRequestTypeItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("requestType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String requestType;

  /**
   * Name: responseType (responseType), Type: SettingItemHttpOperationResponseTypeItem. Options
   * (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("responseType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String responseType;

  /** Name: url (url), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("url")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String url;

  @Override
  public void addFields() {
    addCustomField("method", method, String.class);
    addCustomField("parameters", parameters, List.class);
    addCustomField("requestType", requestType, String.class);
    addCustomField("responseType", responseType, String.class);
    addCustomField("url", url, String.class);
  }
}

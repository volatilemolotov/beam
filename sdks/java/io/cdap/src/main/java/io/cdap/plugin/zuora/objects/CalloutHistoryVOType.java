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

/** Object name: CalloutHistoryVOType (CalloutHistoryVOType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "CalloutHistoryVOType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class CalloutHistoryVOType extends BaseObject {
  /**
   * Name: attemptedNum (attemptedNum), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("attemptedNum")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String attemptedNum;

  /**
   * Name: createTime (createTime), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("createTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createTime;

  /**
   * Name: eventCategory (eventCategory), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("eventCategory")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventCategory;

  /**
   * Name: eventContext (eventContext), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("eventContext")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventContext;

  /**
   * Name: notification (notification), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("notification")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notification;

  /**
   * Name: requestMethod (requestMethod), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("requestMethod")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String requestMethod;

  /**
   * Name: requestUrl (requestUrl), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("requestUrl")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String requestUrl;

  /**
   * Name: responseCode (responseCode), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("responseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String responseCode;

  /**
   * Name: responseContent (responseContent), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("responseContent")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String responseContent;

  @Override
  public void addFields() {
    addCustomField("attemptedNum", attemptedNum, String.class);
    addCustomField("createTime", createTime, String.class);
    addCustomField("eventCategory", eventCategory, String.class);
    addCustomField("eventContext", eventContext, String.class);
    addCustomField("notification", notification, String.class);
    addCustomField("requestMethod", requestMethod, String.class);
    addCustomField("requestUrl", requestUrl, String.class);
    addCustomField("responseCode", responseCode, String.class);
    addCustomField("responseContent", responseContent, String.class);
  }
}

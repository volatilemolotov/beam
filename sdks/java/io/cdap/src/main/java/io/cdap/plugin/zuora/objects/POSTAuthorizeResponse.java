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

/** Object name: POSTAuthorizeResponse (POSTAuthorizeResponse). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTAuthorizeResponse",
    RequiredArguments = {"payment-method-id", "Request"},
    APIUrl = "payment-methods/{payment-method-id}/authorize",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class POSTAuthorizeResponse extends BaseObject {
  /**
   * Name: gatewayOrderId (gatewayOrderId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("gatewayOrderId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOrderId;

  /**
   * Name: resultCode (resultCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("resultCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resultCode;

  /**
   * Name: resultMessage (resultMessage), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("resultMessage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resultMessage;

  /**
   * Name: success (success), Type: boolean. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
   * Name: transactionId (transactionId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("transactionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transactionId;

  @Override
  public void addFields() {
    addCustomField("gatewayOrderId", gatewayOrderId, String.class);
    addCustomField("resultCode", resultCode, String.class);
    addCustomField("resultMessage", resultMessage, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("transactionId", transactionId, String.class);
  }
}

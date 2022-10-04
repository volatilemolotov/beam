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

/** Object name: POSTReversePaymentRequest (POSTReversePaymentRequest). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "POSTReversePaymentRequest",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class POSTReversePaymentRequest extends BaseObject {
  /** Name: amount (amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: gatewayResponse (gatewayResponse), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("gatewayResponse")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponse;

  /**
   * Name: gatewayResponseCode (gatewayResponseCode), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("gatewayResponseCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayResponseCode;

  /**
   * Name: referenceId (referenceId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
   * Name: secondReferenceId (secondReferenceId), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("secondReferenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondReferenceId;

  /**
   * Name: settledOn (settledOn), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("settledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String settledOn;

  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("gatewayResponse", gatewayResponse, String.class);
    addCustomField("gatewayResponseCode", gatewayResponseCode, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("secondReferenceId", secondReferenceId, String.class);
    addCustomField("settledOn", settledOn, String.class);
  }
}

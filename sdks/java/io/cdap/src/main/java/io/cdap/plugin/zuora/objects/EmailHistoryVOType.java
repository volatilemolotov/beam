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

/** Object name: EmailHistoryVOType (EmailHistoryVOType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "EmailHistoryVOType",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class EmailHistoryVOType extends BaseObject {
  /** Name: bcc (bcc), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("bcc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bcc;

  /** Name: cc (cc), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("cc")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cc;

  /**
   * Name: errorMessage (errorMessage), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("errorMessage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String errorMessage;

  /**
   * Name: eventCategory (eventCategory), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("eventCategory")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventCategory;

  /**
   * Name: fromEmail (fromEmail), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("fromEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fromEmail;

  /**
   * Name: notification (notification), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("notification")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notification;

  /**
   * Name: replyTo (replyTo), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("replyTo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String replyTo;

  /** Name: result (result), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("result")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String result;

  /**
   * Name: sendTime (sendTime), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("sendTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sendTime;

  /**
   * Name: subject (subject), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("subject")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subject;

  /**
   * Name: toEmail (toEmail), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("toEmail")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String toEmail;

  @Override
  public void addFields() {
    addCustomField("bcc", bcc, String.class);
    addCustomField("cc", cc, String.class);
    addCustomField("errorMessage", errorMessage, String.class);
    addCustomField("eventCategory", eventCategory, String.class);
    addCustomField("fromEmail", fromEmail, String.class);
    addCustomField("notification", notification, String.class);
    addCustomField("replyTo", replyTo, String.class);
    addCustomField("result", result, String.class);
    addCustomField("sendTime", sendTime, String.class);
    addCustomField("subject", subject, String.class);
    addCustomField("toEmail", toEmail, String.class);
  }
}

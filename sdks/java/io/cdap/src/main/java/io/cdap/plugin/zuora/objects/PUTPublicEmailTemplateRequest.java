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

/** Object name: PUTPublicEmailTemplateRequest (PUTPublicEmailTemplateRequest). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTPublicEmailTemplateRequest",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTPublicEmailTemplateRequest extends BaseObject {
  /** Name: active (active), Type: boolean. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("active")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean active;

  /**
   * Name: bccEmailAddress (bccEmailAddress), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("bccEmailAddress")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String bccEmailAddress;

  /**
   * Name: ccEmailAddress (ccEmailAddress), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("ccEmailAddress")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ccEmailAddress;

  /**
   * Name: ccEmailType (ccEmailType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("ccEmailType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ccEmailType;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: emailBody (emailBody), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("emailBody")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String emailBody;

  /**
   * Name: emailSubject (emailSubject), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("emailSubject")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String emailSubject;

  /**
   * Name: encodingType (encodingType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("encodingType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String encodingType;

  /**
   * Name: fromEmailAddress (fromEmailAddress), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("fromEmailAddress")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fromEmailAddress;

  /**
   * Name: fromEmailType (fromEmailType), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("fromEmailType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fromEmailType;

  /**
   * Name: fromName (fromName), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("fromName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fromName;

  /** Name: isHtml (isHtml), Type: boolean. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("isHtml")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean isHtml;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: replyToEmailAddress (replyToEmailAddress), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("replyToEmailAddress")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String replyToEmailAddress;

  /**
   * Name: replyToEmailType (replyToEmailType), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("replyToEmailType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String replyToEmailType;

  /**
   * Name: toEmailAddress (toEmailAddress), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("toEmailAddress")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String toEmailAddress;

  /**
   * Name: toEmailType (toEmailType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("toEmailType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String toEmailType;

  @Override
  public void addFields() {
    addCustomField("active", active, Boolean.class);
    addCustomField("bccEmailAddress", bccEmailAddress, String.class);
    addCustomField("ccEmailAddress", ccEmailAddress, String.class);
    addCustomField("ccEmailType", ccEmailType, String.class);
    addCustomField("description", description, String.class);
    addCustomField("emailBody", emailBody, String.class);
    addCustomField("emailSubject", emailSubject, String.class);
    addCustomField("encodingType", encodingType, String.class);
    addCustomField("fromEmailAddress", fromEmailAddress, String.class);
    addCustomField("fromEmailType", fromEmailType, String.class);
    addCustomField("fromName", fromName, String.class);
    addCustomField("isHtml", isHtml, Boolean.class);
    addCustomField("name", name, String.class);
    addCustomField("replyToEmailAddress", replyToEmailAddress, String.class);
    addCustomField("replyToEmailType", replyToEmailType, String.class);
    addCustomField("toEmailAddress", toEmailAddress, String.class);
    addCustomField("toEmailType", toEmailType, String.class);
  }
}

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
* Object name: PostRefundType (PostRefundType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PostRefundType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PostRefundType extends BaseObject {
  /**
  * Name: comment (comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: financeInformation (financeInformation), Type: PostRefundTypeFinanceInformationItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /**
  * Name: methodType (methodType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("methodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String methodType;

  /**
  * Name: reasonCode (reasonCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
  * Name: referenceId (referenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
  * Name: refundDate (refundDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("refundDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundDate;

  /**
  * Name: secondRefundReferenceId (secondRefundReferenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("secondRefundReferenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String secondRefundReferenceId;

  /**
  * Name: totalAmount (totalAmount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalAmount;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;


  @Override
  public void addFields() {
    addCustomField("comment", comment, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("methodType", methodType, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("refundDate", refundDate, String.class);
    addCustomField("secondRefundReferenceId", secondRefundReferenceId, String.class);
    addCustomField("totalAmount", totalAmount, String.class);
    addCustomField("type", type, String.class);
  }
}

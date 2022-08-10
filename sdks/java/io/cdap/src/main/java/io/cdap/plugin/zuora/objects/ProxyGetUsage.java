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
* Object name: ProxyGetUsage (ProxyGetUsage).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetUsage",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetUsage extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AccountNumber (AccountNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: ChargeId (ChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeId;

  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: Description (Description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: EndDateTime (EndDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateTime;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: Quantity (Quantity), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: RbeStatus (RbeStatus), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("rbeStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String rbeStatus;

  /**
  * Name: SourceType (SourceType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceType;

  /**
  * Name: StartDateTime (StartDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDateTime;

  /**
  * Name: SubmissionDateTime (SubmissionDateTime), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("submissionDateTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String submissionDateTime;

  /**
  * Name: SubscriptionId (SubscriptionId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: SubscriptionNumber (SubscriptionNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: UOM (UOM), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uOM")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uOM;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("chargeId", chargeId, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("description", description, String.class);
    addCustomField("endDateTime", endDateTime, String.class);
    addCustomField("id", id, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("rbeStatus", rbeStatus, String.class);
    addCustomField("sourceType", sourceType, String.class);
    addCustomField("startDateTime", startDateTime, String.class);
    addCustomField("submissionDateTime", submissionDateTime, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("uOM", uOM, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}

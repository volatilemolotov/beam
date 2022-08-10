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

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: PUTAllocateManuallyType (PUTAllocateManuallyType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PUTAllocateManuallyType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PUTAllocateManuallyType extends BaseObject {
  /**
  * Name: eventType (eventType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("eventType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventType;

  /**
  * Name: eventTypeSystemId (eventTypeSystemId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("eventTypeSystemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventTypeSystemId;

  /**
  * Name: notes (notes), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("notes")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String notes;

  /**
  * Name: revenueDistributions (revenueDistributions), Type: array|POSTDistributionItemType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueDistributions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTDistributionItemType")
  private List<POSTDistributionItemType> revenueDistributions;


  @Override
  public void addFields() {
    addCustomField("eventType", eventType, String.class);
    addCustomField("eventTypeSystemId", eventTypeSystemId, String.class);
    addCustomField("notes", notes, String.class);
    addCustomField("revenueDistributions", revenueDistributions, List.class);
  }
}

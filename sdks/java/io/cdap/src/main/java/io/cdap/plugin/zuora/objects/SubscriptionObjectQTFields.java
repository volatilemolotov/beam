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

/** Object name: SubscriptionObjectQTFields (SubscriptionObjectQTFields). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "SubscriptionObjectQTFields",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class SubscriptionObjectQTFields extends BaseObject {
  /**
   * Name: CpqBundleJsonId__QT (CpqBundleJsonId__QT), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("cpqBundleJsonId__QT")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cpqBundleJsonId__QT;

  /**
   * Name: OpportunityCloseDate__QT (OpportunityCloseDate__QT), Type: string. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("opportunityCloseDate__QT")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String opportunityCloseDate__QT;

  /**
   * Name: OpportunityName__QT (OpportunityName__QT), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("opportunityName__QT")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String opportunityName__QT;

  /**
   * Name: QuoteBusinessType__QT (QuoteBusinessType__QT), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("quoteBusinessType__QT")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quoteBusinessType__QT;

  /**
   * Name: QuoteNumber__QT (QuoteNumber__QT), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("quoteNumber__QT")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quoteNumber__QT;

  /**
   * Name: QuoteType__QT (QuoteType__QT), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("quoteType__QT")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quoteType__QT;

  @Override
  public void addFields() {
    addCustomField("cpqBundleJsonId__QT", cpqBundleJsonId__QT, String.class);
    addCustomField("opportunityCloseDate__QT", opportunityCloseDate__QT, String.class);
    addCustomField("opportunityName__QT", opportunityName__QT, String.class);
    addCustomField("quoteBusinessType__QT", quoteBusinessType__QT, String.class);
    addCustomField("quoteNumber__QT", quoteNumber__QT, String.class);
    addCustomField("quoteType__QT", quoteType__QT, String.class);
  }
}

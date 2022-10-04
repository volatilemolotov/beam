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

/** Object name: ChargePreviewMetricsCmrrItem (ChargePreviewMetricsCmrrItem). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ChargePreviewMetricsCmrrItem",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ChargePreviewMetricsCmrrItem extends BaseObject {
  /**
   * Name: discount (discount), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("discount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discount;

  /**
   * Name: discountDelta (discountDelta), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("discountDelta")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String discountDelta;

  /**
   * Name: regular (regular), Type: number. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("regular")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String regular;

  /**
   * Name: regularDelta (regularDelta), Type: number. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("regularDelta")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String regularDelta;

  @Override
  public void addFields() {
    addCustomField("discount", discount, String.class);
    addCustomField("discountDelta", discountDelta, String.class);
    addCustomField("regular", regular, String.class);
    addCustomField("regularDelta", regularDelta, String.class);
  }
}

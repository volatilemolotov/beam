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
import java.util.List;
import javax.annotation.Nullable;

/** Object name: PUTWriteOffInvoiceRequest (PUTWriteOffInvoiceRequest). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "PUTWriteOffInvoiceRequest",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class PUTWriteOffInvoiceRequest extends BaseObject {
  /**
   * Name: comment (comment), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
   * Name: items (items), Type: array|CreditMemoItemFromWriteOffInvoice. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("items")
  @ObjectFieldDefinition(
      FieldType = Schema.Type.ARRAY,
      NestedClass = "CreditMemoItemFromWriteOffInvoice")
  private List<CreditMemoItemFromWriteOffInvoice> items;

  /**
   * Name: memoDate (memoDate), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("memoDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String memoDate;

  /**
   * Name: reasonCode (reasonCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  @Override
  public void addFields() {
    addCustomField("comment", comment, String.class);
    addCustomField("items", items, List.class);
    addCustomField("memoDate", memoDate, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
  }
}

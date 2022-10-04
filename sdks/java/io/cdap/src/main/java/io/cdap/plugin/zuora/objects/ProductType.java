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

/** Object name: ProductType (ProductType). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "Products",
    responseRootElement = "products",
    APIUrl = "catalog/products",
    ObjectType = ObjectDefinition.ObjectDefinitionType.BASE)
public class ProductType extends BaseObject {
  /**
   * Name: category (category), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("category")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String category;

  /**
   * Name: description (description), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
   * Name: effectiveEndDate (effectiveEndDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveEndDate;

  /**
   * Name: effectiveStartDate (effectiveStartDate), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("effectiveStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveStartDate;

  /** Name: id (id), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /** Name: name (name), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
   * Name: productFeatures (productFeatures), Type: array|ProductFeatureType. Options (custom,
   * update, select): false, false, false
   */
  @Nullable
  @SerializedName("productFeatures")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ProductFeatureType")
  private List<ProductFeatureType> productFeatures;

  /**
   * Name: productRatePlans (productRatePlans), Type: string. Options (custom, update, select):
   * false, false, false
   */
  @Nullable
  @SerializedName("productRatePlans")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlans;

  /** Name: sku (sku), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("sku")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sku;

  /** Name: tags (tags), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("tags")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String tags;

  @Override
  public void addFields() {
    addCustomField("category", category, String.class);
    addCustomField("description", description, String.class);
    addCustomField("effectiveEndDate", effectiveEndDate, String.class);
    addCustomField("effectiveStartDate", effectiveStartDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("name", name, String.class);
    addCustomField("productFeatures", productFeatures, List.class);
    addCustomField("productRatePlans", productRatePlans, String.class);
    addCustomField("sku", sku, String.class);
    addCustomField("tags", tags, String.class);
  }
}

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

/** Object name: DataQueryJob (DataQueryJob). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(Name = "DataQueryJob", ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class DataQueryJob extends BaseObject {
  /**
   * Name: dataFile (dataFile), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("dataFile")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dataFile;

  /**
   * Name: outputRows (outputRows), Type: integer. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("outputRows")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer outputRows;

  /**
   * Name: processingTime (processingTime), Type: integer. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("processingTime")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer processingTime;

  /**
   * Name: queryStatus (queryStatus), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("queryStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String queryStatus;

  @Override
  public void addFields() {
    addCustomField("dataFile", dataFile, String.class);
    addCustomField("outputRows", outputRows, Integer.class);
    addCustomField("processingTime", processingTime, Integer.class);
    addCustomField("queryStatus", queryStatus, String.class);
  }
}

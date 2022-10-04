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
package io.cdap.plugin.zuora.plugin.batch.source;

import com.google.common.collect.ImmutableList;
import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** Provides all required configuration for reading Zuora objects. */
public class ZuoraSourceConfig extends BaseConfig {
  public static final String PROPERTY_BASE_OBJECTS_TO_PULL = "baseObjects";

  @Macro
  @Name(PROPERTY_BASE_OBJECTS_TO_PULL)
  @Description("Top-level Zuora objects")
  @Nullable
  private String baseObjectsToPull;

  public ZuoraSourceConfig(String referenceName) {
    super(referenceName);
  }

  @Override
  public void validate(FailureCollector failureCollector) {
    new ZuoraSourceConfigValidator(failureCollector, this).validate();
  }

  /** Determines plugin working mode. */
  public boolean isSingleObjectMode() {
    List<String> objects = getObjects();
    return objects == null || objects.size() <= 1;
  }

  /**
   * Generated schema according to user configuration.
   *
   * @return user configured schema
   */
  public Schema getSchema(boolean forceGeneration) {
    List<String> objects = getObjects();

    if (objects == null || objects.size() == 0) {
      return null;
    }

    if (objects.size() == 1 || forceGeneration) {
      return ObjectHelper.buildSchema(objects.get(0), null);
    }
    return null;
  }

  /**
   * Returns the list of string.
   *
   * @return list of string
   */
  public List<String> getObjects() {
    ImmutableList.Builder<String> objectsBuilder = new ImmutableList.Builder<>();
    if (baseObjectsToPull != null && !baseObjectsToPull.isEmpty()) {
      objectsBuilder.add(baseObjectsToPull.split(","));
    }
    return objectsBuilder.build();
  }

  /**
   * Returns the list of ZuoraSplitArgument.
   *
   * @return list of ZuoraSplitArgument
   */
  public List<ZuoraSplitArgument> getObjectsWithSchema() {
    return getObjects().stream()
        .map(x -> new ZuoraSplitArgument(x, ObjectHelper.buildSchema(x, null).toString()))
        .collect(Collectors.toList());
  }

  public Map<String, String> getArguments() {
    return null;
  }
}

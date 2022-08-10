/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.cdap.plugin.zuora.restobjects.objects;

import com.google.common.collect.ImmutableMap;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.client.schema.SchemaFieldType;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nullable;


/**
 * Interface for all REST objects
 *
 * Any child, implemented current interface should provide all
 * fields outside through {@link BaseObject#asMap()} method.
 *
 * No getters allowed, unless any custom object usage planed.
 */
public abstract class BaseObject implements Serializable {
  /**
   * Custom object fields.
   */
  private transient ImmutableMap.Builder<String, Object> objectFieldsBuilder = new ImmutableMap.Builder<>();
  private transient Map<String, Object> objectFields;

  /**
   * Add custom field to the object .
   * @param name name of the field
   * @param value value of the field
   */
  @SuppressWarnings("unchecked")
  public void addCustomField(String name, Object value) {
    if (objectFields != null) {
      throw new IllegalStateException("Object fields r already constructed and cannot be modified");
    }
    //  check if it is a list of BaseObjects
    if (value instanceof List && ((List) value).size() > 0 && ((List) value).get(0) instanceof BaseObject) {
      List<BaseObject> objects = (List<BaseObject>) value;
      value = objects.parallelStream().map(BaseObject::asMap).collect(Collectors.toList());
    }
    objectFieldsBuilder.put(name, value);
  }

  /**
   * Add custom field to the object.
   * @param name name of the field
   * @param value value of the field
   * @param type type of the field
   */
  public void addCustomField(String name, @Nullable Object value, Class<?> type) {
    if (value == null) {
      try {
        value = SchemaFieldType.getDefaultValue(type);
      } catch (IllegalAccessException | InstantiationException e) {
        throw new IllegalArgumentException(String.format("Field '%s' doe not provide default value", name));
      }
    }
    addCustomField(name, value);
  }

  /**
   * Add custom field to the object.
   * @param name name of the field
   * @param object value of the field
   */
  public void addCustomField(String name, @Nullable BaseObject object) {
    if (object == null) {
      addCustomField(name, Collections.EMPTY_MAP, Map.class);
      return;
    }
    addCustomField(name, object.asMap());
  }

  /**
   * Add custom field to the object if the value is not null.
   * @param name name of the field
   * @param object value of the field
   * @param skipAddIfNull add field if it's value is not {@code null}
   */
  public void addCustomField(String name, @Nullable BaseObject object, Boolean skipAddIfNull) {
    if (skipAddIfNull) {
      return;
    }
    addCustomField(name, object);
  }

  /**
   * Add custom field to the object.
   * @param name name of the field
   * @param value value of the field
   * @param type type of the field
   * @param skipAddIfNull add field if it's value is not {@code null}
   */
  public void addCustomField(String name, @Nullable Object value, Class<?> type, Boolean skipAddIfNull) {
    if (skipAddIfNull) {
      return;
    }
    addCustomField(name, value, type);
  }

  /**
   * Each field of the object should be added.
   */
  public abstract void addFields();

  /**
   * Construct object fields and return the map of them. No more fields could be added after
   * calling this method.
   */
  @ObjectFieldDefinition(FieldName = "customFields", FieldType = Schema.Type.MAP)
  public Map<String, Object> asMap() {
    if (objectFields == null) {
      addFields();
      objectFields = objectFieldsBuilder.build();
    }
    return objectFields;
  }

  /**
   * Provide access to object fields mentioned in {@link Schema}.
   *
   * @param schema generated or customized schema for the object
   */
  public Map<String, Object> asFilteredMap(Schema schema) {
    ImmutableMap.Builder<String, Object> fields = new ImmutableMap.Builder<>();
    Map<String, Object> allFields = asMap();

    Objects.requireNonNull(schema.getFields()).stream()
        .map(Schema.Field::getName)
        .forEach(name -> fields.put(name, allFields.getOrDefault(name, new EmptyObject())));

    return fields.build();
  }
}

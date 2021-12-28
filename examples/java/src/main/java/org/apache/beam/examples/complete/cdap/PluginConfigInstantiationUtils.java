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
package org.apache.beam.examples.complete.cdap;

import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.plugin.PluginConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for getting any filled {@link io.cdap.cdap.api.plugin.PluginConfig} configuration object
 */
public class PluginConfigInstantiationUtils {

  private static final Logger LOG = LoggerFactory.getLogger(PluginConfigInstantiationUtils.class);

  /**
   * @param params map of config fields, where key is the name of the field, value must be String or boxed primitive
   * @return Config object for given map of arguments and configuration class
   */
  public static <T extends PluginConfig> T getPluginConfig(Map<String, Object> params, Class<T> configClass) {
    //Validate configClass
    if (configClass == null || configClass.isPrimitive()
        || configClass.isArray()) {
      throw new IllegalArgumentException("Config class must be correct!");
    }
    List<Field> allFields = new ArrayList<>();
    Class<?> currClass = configClass;
    while (!currClass.equals(Object.class)) {
      allFields.addAll(Arrays.stream(currClass.getDeclaredFields())
          .filter(f -> !Modifier.isStatic(f.getModifiers())
              && f.isAnnotationPresent(Name.class)).collect(Collectors.toList()));
      currClass = currClass.getSuperclass();
    }
    T config = getEmptyObjectOf(configClass);

    for (Field field : allFields) {
      field.setAccessible(true);

      Class<?> fieldType = field.getType();

      String fieldName = field.getDeclaredAnnotation(Name.class).value();
      Object fieldValue = params.get(fieldName);

      if (fieldValue != null && fieldType.equals(fieldValue.getClass())) {
        try {
          field.set(config, fieldValue);
        } catch (IllegalAccessException e) {
          LOG.error("Can not set a field", e);
        }
      }
    }
    return config;
  }

  /**
   * @return empty {@link Object} of {@param tClass}
   */
  private static <T> T getEmptyObjectOf(Class<T> tClass) {
    for (Constructor<?> constructor : tClass.getDeclaredConstructors()) {
      constructor.setAccessible(true);
      Class<?>[] parameterTypes = constructor.getParameterTypes();
      Object[] parameters = Arrays.stream(parameterTypes).map(type ->
          type.isPrimitive() ? getEmptyPrimitive(type) : null).toArray();
      try {
        return (T) constructor.newInstance(parameters);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
        LOG.error("Can not instantiate an empty object", e);
      }
    }
    return null;
  }

  /**
   * @return empty primitive {@link Object} of {@param tClass}
   */
  private static Object getEmptyPrimitive(Class<?> tClass) {
    if (tClass.equals(Boolean.TYPE)) {
      return false;
    }
    if (tClass.equals(Character.TYPE)) {
      return Character.MIN_VALUE;
    }
    if (tClass.equals(Byte.TYPE)) {
      return Byte.MIN_VALUE;
    }
    if (tClass.equals(Short.TYPE)) {
      return Short.MIN_VALUE;
    }
    if (tClass.equals(Double.TYPE)) {
      return Double.MIN_VALUE;
    }
    if (tClass.equals(Integer.TYPE)) {
      return Integer.MIN_VALUE;
    }
    if (tClass.equals(Float.TYPE)) {
      return Float.MIN_VALUE;
    }
    if (tClass.equals(Long.TYPE)) {
      return Long.MIN_VALUE;
    }
    return null;
  }
}

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
package io.cdap.plugin.zuora.restobjects.objects;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * Key-Value pair object.
 *
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> implements Map.Entry<K, V>, Serializable {
  private K key;
  private V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public K getKey() {
    return key;
  }

  @Override
  public V getValue() {
    return value;
  }

  @Override
  public V setValue(V value) {
    V val = this.value;
    this.value = value;
    return val;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Pair)) {
      return false;
    }
    Pair<K, V> pair = (Pair<K, V>) o;
    return key == pair.key && value == pair.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    return String.format(
        "Pair<%s, %s> [key=%s, value=%s]",
        key.getClass().getCanonicalName(),
        value.getClass().getCanonicalName(),
        key.toString(),
        value.toString());
  }
}

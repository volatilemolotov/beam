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
package org.apache.beam.sdk.io.sparkreceiver;

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;

import com.google.auto.value.AutoValue;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SparkReceiverIO {

  private static final Logger LOG = LoggerFactory.getLogger(SparkReceiverIO.class);

  public static <K, V> Read<K, V> read() {
    return new AutoValue_SparkReceiverIO_Read.Builder<K, V>().build();
  }

  @AutoValue
  @AutoValue.CopyAnnotations
  public abstract static class Read<K, V> extends PTransform<PBegin, PCollection<KV<K, V>>> {
    abstract @Nullable Coder<K> getKeyCoder();

    abstract @Nullable Coder<V> getValueCoder();

    abstract Builder<K, V> toBuilder();

    // TODO: Decide which fields and methods are needed

    @AutoValue.Builder
    abstract static class Builder<K, V> {
      abstract Builder<K, V> setKeyCoder(Coder<K> keyCoder);

      abstract Builder<K, V> setValueCoder(Coder<V> valueCoder);

      public abstract Read<K, V> build();

      // TODO: Add setup steps
    }

    public Read<K, V> withKeyCoder(Coder<K> keyCoder) {
      return toBuilder().setKeyCoder(keyCoder).build();
    }

    public Read<K, V> withValueCoder(Coder<V> valueCoder) {
      return toBuilder().setValueCoder(valueCoder).build();
    }

    @Override
    public PCollection<KV<K, V>> expand(PBegin input) {
      checkArgument(getKeyCoder() != null, "withKeyClass() is withKeyCoder");
      checkArgument(getValueCoder() != null, "withValueClass() is withValueCoder");
      PCollection<KV<K, V>> read = null;
      return read;
    }
  }
}

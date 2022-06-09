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
package org.apache.beam.sdk.io.cdap;

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;

import com.google.auto.value.AutoValue;
import io.cdap.cdap.api.plugin.PluginConfig;
import org.apache.beam.sdk.annotations.Experimental;
import org.apache.beam.sdk.io.hadoop.format.HDFSSynchronization;
import org.apache.beam.sdk.io.hadoop.format.HadoopFormatIO;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PDone;
import org.apache.hadoop.conf.Configuration;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An unbounded/bounded sources and sinks from <a
 * href="https://github.com/data-integrations">CDAP</a> plugins.
 */
@SuppressWarnings({
  "argument.type.incompatible",
  "return.type.incompatible",
  "dereference.of.nullable",
  "UnnecessaryParentheses"
})
public class CdapIO {

  public static <K, V> Read<K, V> read() {
    return new AutoValue_CdapIO_Read.Builder<K, V>().build();
  }

  public static <K, V> Write<K, V> write() {
    return new AutoValue_CdapIO_Write.Builder<K, V>().build();
  }

  /** A {@link PTransform} to read from CDAP source. */
  @AutoValue
  @AutoValue.CopyAnnotations
  public abstract static class Read<K, V> extends PTransform<PBegin, PCollection<KV<K, V>>> {

    abstract @Nullable PluginConfig getPluginConfig();

    abstract @Nullable Plugin getCdapPlugin();

    abstract @Nullable Class<K> getKeyClass();

    abstract @Nullable Class<V> getValueClass();

    abstract Builder<K, V> toBuilder();

    @Experimental(Experimental.Kind.PORTABILITY)
    @AutoValue.Builder
    abstract static class Builder<K, V> {

      abstract Builder<K, V> setPluginConfig(PluginConfig config);

      abstract Builder<K, V> setCdapPlugin(Plugin plugin);

      abstract Builder<K, V> setKeyClass(Class<K> keyClass);

      abstract Builder<K, V> setValueClass(Class<V> valueClass);

      abstract Read<K, V> build();
    }

    public Read<K, V> withCdapPlugin(Plugin plugin) {
      checkArgument(plugin != null, "Cdap plugin can not be null");
      return toBuilder().setCdapPlugin(plugin).build();
    }

    public Read<K, V> withCdapPluginClass(Class<?> cdapPluginClass) {
      checkArgument(cdapPluginClass != null, "Cdap plugin class can not be null");
      Plugin plugin = MappingUtils.getPluginByClass(cdapPluginClass);
      checkArgument(plugin != null, "Can not instantiate Plugin object from provided plugin class");
      return toBuilder().setCdapPlugin(plugin).build();
    }

    public Read<K, V> withPluginConfig(PluginConfig pluginConfig) {
      checkArgument(pluginConfig != null, "Plugin config can not be null");
      return toBuilder().setPluginConfig(pluginConfig).build();
    }

    public Read<K, V> withKeyClass(Class<K> keyClass) {
      checkArgument(keyClass != null, "Key class can not be null");
      return toBuilder().setKeyClass(keyClass).build();
    }

    public Read<K, V> withValueClass(Class<V> valueClass) {
      checkArgument(valueClass != null, "Value class can not be null");
      return toBuilder().setValueClass(valueClass).build();
    }

    @Override
    public PCollection<KV<K, V>> expand(PBegin input) {
      validateTransform();

      getCdapPlugin()
          .withConfig(getPluginConfig())
          .withHadoopConfiguration(getKeyClass(), getValueClass())
          .prepareRun();

      if (getCdapPlugin().isUnbounded()) {
        // TODO: implement SparkReceiverIO.<~>read()
        return null;
      } else {
        Configuration hConf = getCdapPlugin().getHadoopConfiguration();
        HadoopFormatIO.Read<K, V> readFromHadoop =
            HadoopFormatIO.<K, V>read().withConfiguration(hConf);
        return input.apply(readFromHadoop);
      }
    }

    public void validateTransform() {
      checkArgument(getCdapPlugin() != null, "withCdapPluginClass() is required");
      checkArgument(getPluginConfig() != null, "withPluginConfig() is required");
      checkArgument(getKeyClass() != null, "withKeyClass() is required");
      checkArgument(getValueClass() != null, "withValueClass() is required");
    }
  }

  /** A {@link PTransform} to read from CDAP source. */
  @AutoValue
  @AutoValue.CopyAnnotations
  public abstract static class Write<K, V> extends PTransform<PCollection<KV<K, V>>, PDone> {

    abstract @Nullable PluginConfig getPluginConfig();

    abstract @Nullable Plugin getCdapPlugin();

    abstract @Nullable Class<K> getKeyClass();

    abstract @Nullable Class<V> getValueClass();

    abstract @Nullable String getLocksDirPath();

    abstract Builder<K, V> toBuilder();

    @Experimental(Experimental.Kind.PORTABILITY)
    @AutoValue.Builder
    abstract static class Builder<K, V> {

      abstract Builder<K, V> setPluginConfig(PluginConfig config);

      abstract Builder<K, V> setCdapPlugin(Plugin plugin);

      abstract Builder<K, V> setKeyClass(Class<K> keyClass);

      abstract Builder<K, V> setValueClass(Class<V> valueClass);

      abstract Builder<K, V> setLocksDirPath(String path);

      abstract Write<K, V> build();
    }

    public Write<K, V> withCdapPluginClass(Class<?> cdapPluginClass) {
      return toBuilder().setCdapPlugin(MappingUtils.getPluginByClass(cdapPluginClass)).build();
    }

    public Write<K, V> withPluginConfig(PluginConfig pluginConfig) {
      return toBuilder().setPluginConfig(pluginConfig).build();
    }

    public Write<K, V> withKeyClass(Class<K> keyClass) {
      return toBuilder().setKeyClass(keyClass).build();
    }

    public Write<K, V> withLocksDirPath(String locksDirPath) {
      return toBuilder().setLocksDirPath(locksDirPath).build();
    }

    public Write<K, V> withValueClass(Class<V> valueClass) {
      return toBuilder().setValueClass(valueClass).build();
    }

    @Override
    public PDone expand(PCollection<KV<K, V>> input) {
      checkArgument(getLocksDirPath() != null, "withPluginConfig() is required");
      checkArgument(getPluginConfig() != null, "withPluginConfig() is required");
      checkArgument(getCdapPlugin() != null, "withCdapPluginClass() is required");
      checkArgument(getKeyClass() != null, "withKeyClass() is required");
      checkArgument(getValueClass() != null, "withValueClass() is required");

      getCdapPlugin()
          .withConfig(getPluginConfig())
          .withHadoopConfiguration(getKeyClass(), getValueClass())
          .prepareRun();

      if (getCdapPlugin().isUnbounded()) {
        // TODO: implement SparkReceiverIO.<~>write()
        return null;
      } else {
        Configuration hConf = getCdapPlugin().getHadoopConfiguration();
        HadoopFormatIO.Write<K, V> writeHadoop =
            HadoopFormatIO.<K, V>write()
                .withConfiguration(hConf)
                .withPartitioning()
                .withExternalSynchronization(new HDFSSynchronization(getLocksDirPath()));
        return input.apply(writeHadoop);
      }
    }
  }
}

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

import io.cdap.cdap.api.plugin.PluginConfig;
import org.apache.hadoop.conf.Configuration;

/**
 * Class wrapper for a CDAP plugin.
 */
public abstract class Plugin<F, FP, PC extends PluginConfig> {
    protected Class<?> pluginClass;
    protected Class<F> formatClass;
    protected Class<FP> formatProviderClass;

    public PC pluginConfig;
    public Configuration hadoopConfiguration;

    /**
     * Sets the main class of a plugin.
     */
    public void setPluginClass(Class<?> pluginClass) {
        this.pluginClass = pluginClass;
    }

    /**
     * Gets the main class of a plugin.
     */
    public Class<?> getPluginClass() {
        return pluginClass;
    }

    /**
     * Sets InputFormat or OutputFormat class for a plugin.
     */
    public void setFormatClass(Class<F> formatClass) {
        this.formatClass = formatClass;
    }

    /**
     * Gets InputFormat or OutputFormat class for a plugin.
     */
    public Class<F> getFormatClass() {
        return formatClass;
    }

    /**
     * Sets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public void setFormatProviderClass(Class<FP> formatProviderClass) {
        this.formatProviderClass = formatProviderClass;
    }

    /**
     * Gets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public Class<FP> getFormatProviderClass() {
        return formatProviderClass;
    }

    /**
     * Sets a plugin config.
     */
    public Plugin<F, FP, PC> withConfig(PC pluginConfig) {
        this.pluginConfig = pluginConfig;
        return this;
    }

    /**
     * Gets a plugin config.
     */
    public PC getPluginConfig() {
        return pluginConfig;
    }

    /**
     * Sets a plugin Hadoop configuration.
     */
    public abstract Plugin<F, FP, PC> withHadoopConfiguration(Class<?> FormatKeyClass, Class<?> FormatValueClass);

    /**
     * Gets a plugin Hadoop configuration.
     */
    public Configuration getHadoopConfiguration() {
        return hadoopConfiguration;
    }
}

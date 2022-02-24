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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class wrapper for a CDAP plugin.
 */
public class Plugin {
    private final Class<?> formatClass;
    private final Class<?> formatProviderClass;

    private final Class<?> pluginClass;
    private PluginConfig pluginConfig;
    private Configuration hadoopConfiguration;
    private final PluginConstants.PluginType pluginType;

    private static final Logger LOG = LoggerFactory.getLogger(Plugin.class);

    /**
     * Constructor for a plugin.
     */
    public Plugin(Class<?> pluginClass, PluginConstants.PluginType pluginType,
                  Class<?> formatClass, Class<?> formatProviderClass) {

        this.pluginClass = pluginClass;
        this.pluginType = pluginType;
        this.formatClass = formatClass;
        this.formatProviderClass = formatProviderClass;

        try {
            validatePluginClass();
        } catch (IllegalArgumentException e) {
            LOG.error("Validation error", e);
            throw e;
        }
    }

    /**
     * Gets the main class of a plugin.
     */
    public Class<?> getPluginClass() {
        return pluginClass;
    }

    /**
     * Gets InputFormat or OutputFormat class for a plugin.
     */
    public Class<?> getFormatClass() {
        return formatClass;
    }

    /**
     * Gets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public Class<?> getFormatProviderClass() {
        return formatProviderClass;
    }

    /**
     * Sets a plugin config.
     */
    public Plugin withConfig(PluginConfig pluginConfig) {
        this.pluginConfig = pluginConfig;
        return this;
    }

    /**
     * Gets a plugin config.
     */
    public PluginConfig getPluginConfig() {
        return pluginConfig;
    }

    /**
     * Sets a plugin Hadoop configuration.
     */
    public Plugin withHadoopConfiguration(Class<?> formatKeyClass,
                                              Class<?> formatValueClass) {
        PluginConstants.Format formatType = getFormatType();
        PluginConstants.Hadoop hadoopType = getHadoopType();

        this.hadoopConfiguration = new Configuration(false);

        this.hadoopConfiguration.setClass(hadoopType.getFormatClass(), formatClass, formatType.getFormatClass());
        this.hadoopConfiguration.setClass(hadoopType.getKeyClass(), formatKeyClass, Object.class);
        this.hadoopConfiguration.setClass(hadoopType.getValueClass(), formatValueClass, Object.class);

        return this;
    }

    /**
     * Sets a plugin Hadoop configuration.
     */
    public Plugin withHadoopConfiguration(Configuration hadoopConfiguration) {
        this.hadoopConfiguration = hadoopConfiguration;

        return this;
    }

    /**
     * Gets a plugin Hadoop configuration.
     */
    public Configuration getHadoopConfiguration() {
        return hadoopConfiguration;
    }

    /**
     * Gets a plugin type.
     */
    public PluginConstants.PluginType getPluginType() {
        return pluginType;
    }

    /**
     * Validates plugin fields.
     */
    public void validatePluginClass() {
        PluginConstants.Format formatType = getFormatType();

        if (formatClass == null) {
            throw new IllegalArgumentException(
                    String.format("%s must be not null", formatType.getFormatName())
            );
        }

        PluginConstants.FormatProvider formatProviderType = getFormatProviderType();

        if (formatProviderClass == null) {
            throw new IllegalArgumentException(
                    String.format("%s must be not null", formatProviderType.getFormatProviderName())
            );
        }
    }

    private PluginConstants.Format getFormatType() {
        return pluginType == PluginConstants.PluginType.SOURCE
                ? PluginConstants.Format.INPUT
                : PluginConstants.Format.OUTPUT;
    }

    private PluginConstants.FormatProvider getFormatProviderType() {
        return pluginType == PluginConstants.PluginType.SOURCE
                ? PluginConstants.FormatProvider.INPUT
                : PluginConstants.FormatProvider.OUTPUT;
 }

    private PluginConstants.Hadoop getHadoopType() {
        return pluginType == PluginConstants.PluginType.SOURCE
                ? PluginConstants.Hadoop.SOURCE
                : PluginConstants.Hadoop.SINK;
    }
}

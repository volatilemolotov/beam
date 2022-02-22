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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for building {@link Plugin} object.
 */
public class PluginBuilder {
    private final Class<?> pluginClass;
    private Class<?> formatClass;
    private Class<?> formatProviderClass;

    private PluginConstants.PluginType pluginType;

    private static final Logger LOG = LoggerFactory.getLogger(PluginBuilder.class);

    /**
     * Constructor for a plugin builder.
     * @param pluginClass The main class of a plugin.
     */
    public PluginBuilder(Class<?> pluginClass) {
        this.pluginClass = pluginClass;

        try {
            this.setPluginType();
        } catch (IllegalArgumentException e) {
            LOG.error("Error occurred while setting plugin class", e);
            throw e;
        }
    }

    /**
     * Sets InputFormat or OutputFormat class for a plugin.
     */
    public PluginBuilder withFormat(Class<?> formatClass) {
        validateFormat(formatClass);

        this.formatClass = formatClass;
        return this;
    }

    /**
     * Sets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public PluginBuilder withFormatProvider(Class<?> formatProviderClass) {
        validateFormatProvider(formatProviderClass);

        this.formatProviderClass = formatProviderClass;
        return this;
    }

    /**
     * Builds instance of a plugin.
     */
    public Plugin build() {
        Plugin plugin = new Plugin();

        plugin.setPluginClass(pluginClass);
        plugin.setPluginType(pluginType);
        plugin.setFormatClass(formatClass);
        plugin.setFormatProviderClass(formatProviderClass);

        try {
            plugin.validatePluginClass();
        } catch (IllegalArgumentException e) {
            LOG.error("Validation error", e);
            throw e;
        }

        return plugin;
    }

    /**
     * Validates InputFormat or OutputFormat class for a plugin.
     */
    private void validateFormat(Class<?> formatClass) {
        PluginConstants.Format formatType =
                pluginType == PluginConstants.PluginType.SOURCE
                        ? PluginConstants.Format.INPUT
                        : PluginConstants.Format.OUTPUT;

        if (!formatType.getFormatClass().isAssignableFrom(formatClass)) {
            throw new IllegalArgumentException(
                    String.format("Provided class must be extended from %s", formatType.getFormatName())
            );
        }
    }

    /**
     * Validates InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    private void validateFormatProvider(Class<?> formatClassProvider) {
        PluginConstants.FormatProvider formatProviderType =
                pluginType == PluginConstants.PluginType.SOURCE
                        ? PluginConstants.FormatProvider.INPUT
                        : PluginConstants.FormatProvider.OUTPUT;

        if (!formatProviderType.getFormatProviderClass().isAssignableFrom(formatClassProvider)) {
            throw new IllegalArgumentException(
                    String.format("Provided class must be extended from %s", formatProviderType.getFormatProviderName())
            );
        }
    }

    /**
     * Sets a plugin type.
     */
    private void setPluginType() throws IllegalArgumentException {
        String pluginName = pluginClass.getSimpleName();
        this.setPluginType(pluginName);
    }

    /**
     * Sets a plugin type.
     */
    private void setPluginType(String pluginClassName) throws IllegalArgumentException {
        String lowerPluginClassName = pluginClassName.toLowerCase();

        if (lowerPluginClassName.contains("source")) {
            this.pluginType = PluginConstants.PluginType.SOURCE;
        } else if (lowerPluginClassName.contains("sink")) {
            this.pluginType = PluginConstants.PluginType.SINK;
        } else {
            throw new IllegalArgumentException("Provided class should be source or sink plugin");
        }
    }
}

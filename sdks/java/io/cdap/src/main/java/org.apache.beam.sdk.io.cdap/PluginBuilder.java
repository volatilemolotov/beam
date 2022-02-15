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

/**
 * Class for building {@link Plugin} object.
 */
public abstract class PluginBuilder {
    protected Class<?> pluginClass;

    protected Class<?> formatClass;
    protected Class<?> formatProviderClass;

    /**
     * Constructor for a plugin builder.
     * @param pluginClass The main class of a plugin.
     */
    public PluginBuilder(Class<?> pluginClass) {
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
    public PluginBuilder withFormat(Class<?> formatClass) {
        this.formatClass = formatClass;
        return this;
    }

    /**
     * Sets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public PluginBuilder withFormatProvider(Class<?> formatProviderClass) {
        this.formatProviderClass = formatProviderClass;
        return this;
    }

    /**
     * Validates plugin fields.
     */
    protected abstract void validatePluginClass();

    /**
     * Builds instance of a plugin.
     */
    public abstract Plugin build();
}

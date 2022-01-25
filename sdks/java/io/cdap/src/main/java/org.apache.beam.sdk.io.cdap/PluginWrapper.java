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
 * Class wrapper for a plugin.
 */
public class PluginWrapper {
    protected PluginInfo pluginInfo;

    /**
     * Constructor for a plugin wrapper.
     * @param pluginClass The main class of a plugin.
     */
    public PluginWrapper(Class pluginClass) {
        this.pluginInfo = new PluginInfo();
        this.pluginInfo.pluginClass = pluginClass;
    }

    /**
     * Gets the main class of a plugin.
     */
    public Class getPluginClass() { return pluginInfo.pluginClass; }

    /**
     * Gets InputFormat or OutputFormat class for a plugin.
     */
    public Class getFormatClass() {
        return pluginInfo.formatClass;
    }

    /**
     * Sets InputFormat or OutputFormat class for a plugin.
     */
    public void setFormatClass(Class formatClass) {
        this.pluginInfo.formatClass = formatClass;
    }

    /**
     * Gets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public Class getFormatProviderClass() {
        return pluginInfo.formatProviderClass;
    }

    /**
     * Sets InputFormatProvider or OutputFormatProvider class for a plugin.
     */
    public void setFormatProviderClass(Class formatProviderClass) {
        this.pluginInfo.formatProviderClass = formatProviderClass;
    }

    /**
     * Gets config for a plugin.
     */
    public PluginConfig getPluginConfig() {
        return pluginInfo.pluginConfig;
    }

    /**
     * Sets config for a plugin.
     */
    public void setPluginConfig(PluginConfig pluginConfig) {
        this.pluginInfo.pluginConfig = pluginConfig;
    }
}

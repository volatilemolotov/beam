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
 * Class for building {@link PluginWrapper} object.
 */
public class PluginWrapperBuilder {
    private PluginInfo pluginInfo;

    /**
     * Constructor for a plugin wrapper builder.
     * @param pluginClass The main class of a plugin.
     */
    public PluginWrapperBuilder(Class pluginClass) {
        this.pluginInfo = new PluginInfo();
        this.pluginInfo.pluginClass = pluginClass;
    }

    protected PluginWrapperBuilder withFormat(Class formatClass) {
        this.pluginInfo.formatClass = formatClass;
        return this;
    }

    protected PluginWrapperBuilder withFormatProvider(Class formatProviderClass) {
        this.pluginInfo.formatProviderClass = formatProviderClass;
        return this;
    }

    /**
     * Class for building {@link PluginWrapper} object.
     */
    public PluginWrapperBuilder withConfig(PluginConfig pluginConfig) {
        this.pluginInfo.pluginConfig = pluginConfig;
        return this;
    }

    /**
     * Builds plugin wrapper instance.
     */
    public PluginWrapper build() {
        PluginWrapper pw = new PluginWrapper(pluginInfo.pluginClass);

        if (pluginInfo.formatClass != null) {
            pw.setFormatClass(pluginInfo.formatClass);
        }

        if (pluginInfo.formatProviderClass != null) {
            pw.setFormatProviderClass(pluginInfo.formatProviderClass);
        }

        if (pluginInfo.pluginConfig != null) {
            pw.setPluginConfig(pluginInfo.pluginConfig);
        }

        return pw;
    }
}

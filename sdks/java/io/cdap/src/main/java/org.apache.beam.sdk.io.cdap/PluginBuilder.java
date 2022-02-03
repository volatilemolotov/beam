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

public abstract class PluginBuilder<F, FP, PC extends PluginConfig> {
    protected final Class<?> pluginClass;

    protected Class<F> format;
    protected Class<FP> formatProvider;

    public PluginBuilder(Class<?> pluginClass) {
        this.pluginClass = pluginClass;
    }

    public Class<?> getPluginClass() {
        return pluginClass;
    }

    public PluginBuilder<F, FP, PC> withFormat(Class<F> format) {
        this.format = format;
        return this;
    }

    public PluginBuilder<F, FP, PC> withFormatProvider(Class<FP> formatProvider) {
        this.formatProvider = formatProvider;
        return this;
    }

    public abstract void validatePluginClass();
    public abstract Plugin<F, FP, PC> build();
}

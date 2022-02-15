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
import org.apache.hadoop.mapreduce.InputFormat;
import io.cdap.cdap.api.data.batch.InputFormatProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for building {@link SourcePlugin} object.
 */
@SuppressWarnings("rawtypes")
public class SourcePluginBuilder<IF extends InputFormat, IFP extends InputFormatProvider, PC extends PluginConfig>
        extends PluginBuilder<IF, IFP, PC> {

    private static final Logger LOG = LoggerFactory.getLogger(SourcePluginBuilder.class);

    /**
     * Constructor for a source plugin builder.
     * @param pluginClass The main class of a plugin.
     */
    public SourcePluginBuilder(Class<?> pluginClass) {
        super(pluginClass);
    }

    /**
     * Validates source plugin fields.
     */
    @Override
    protected void validatePluginClass() throws IllegalArgumentException {
        if (formatClass == null) {
            throw new IllegalArgumentException("InputFormat must be not null");
        }
        if (formatProviderClass == null) {
            throw new IllegalArgumentException("InputFormatProvider must be not null");
        }
    }

    /**
     * Builds instance of a source plugin.
     */
    @Override
    public SourcePlugin<IF, IFP, PC> build() throws IllegalArgumentException {
        try {
            validatePluginClass();
        } catch (IllegalArgumentException e) {
            LOG.error("Validation error", e);
            throw e;
        }

        SourcePlugin<IF, IFP, PC> sp = new SourcePlugin<>();
        sp.setPluginClass(pluginClass);
        sp.setFormatClass(formatClass);
        sp.setFormatProviderClass(formatProviderClass);

        return sp;
    }
}

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

public class SourcePluginBuilder<IF extends InputFormat, IFP extends InputFormatProvider, PC extends PluginConfig>
        extends PluginBuilder<IF, IFP, PC> {

    private static Logger LOG = LoggerFactory.getLogger(SourcePluginBuilder.class);

    public SourcePluginBuilder(Class<?> pluginClass) {
        super(pluginClass);
    }

    public SourcePluginBuilder<IF, IFP, PC> withHadoopConfiguration() {
        return null;
    }

    @Override
    public void validatePluginClass() {
        if (format == null) {
            throw new IllegalArgumentException("InputFormat must be not null");
        }
        if (formatProvider == null) {
            throw new IllegalArgumentException("InputFormatProvider must be not null");
        }
    }

    @Override
    public SourcePlugin build() {
        try {
            validatePluginClass();
        } catch (Exception e) {
            LOG.error("Validation error", e);
        }

        SourcePlugin sp = new SourcePlugin();
        return sp;
    }
}

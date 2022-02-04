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

import io.cdap.cdap.api.data.batch.InputFormatProvider;
import io.cdap.cdap.api.plugin.PluginConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputFormat;

/**
 * Class wrapper for a CDAP Source plugin.
 */
public class SourcePlugin<IF extends InputFormat, IFP extends InputFormatProvider, PC extends PluginConfig>
        extends Plugin<IF, IFP, PC> {

    /**
     * Sets a plugin Hadoop configuration.
     */
    @Override
    public SourcePlugin<IF, IFP, PC> withHadoopConfiguration(Class<?> InputFormatKeyClass,
                                                     Class<?> InputFormatValueClass) {
        this.hadoopConfiguration = new Configuration(false);

        this.hadoopConfiguration.setClass("mapreduce.job.inputformat.class",
                formatClass, InputFormat.class);
        this.hadoopConfiguration.setClass("key.class", InputFormatKeyClass, Object.class);
        this.hadoopConfiguration.setClass("value.class", InputFormatValueClass, Object.class);

        return this;
    }

    @Override
    public SourcePlugin<IF, IFP, PC> withHadoopConfiguration(Configuration hadoopConfiguration) {
        this.hadoopConfiguration = hadoopConfiguration;

        return this;
    }


}

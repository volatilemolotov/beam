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

import io.cdap.cdap.api.data.batch.OutputFormatProvider;
import io.cdap.cdap.api.plugin.PluginConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.OutputFormat;

public class SinkPlugin<OF extends OutputFormat, OFP extends OutputFormatProvider, PC extends PluginConfig>
        extends Plugin<OF, OFP, PC> {

    @Override
    public SinkPlugin<OF, OFP, PC> withHadoopConfiguration(Class<?> InputFormatKeyClass,
                                                     Class<?> InputFormatValueClass) {
        this.hadoopConfiguration = new Configuration(false);

        this.hadoopConfiguration.setClass("mapreduce.job.outputformat.class",
                formatClass, InputFormat.class);
        this.hadoopConfiguration.setClass("mapreduce.job.output.key.class",
                InputFormatKeyClass, Object.class);
        this.hadoopConfiguration.setClass("mapreduce.job.output.value.class",
                InputFormatValueClass, Object.class);

        return this;
    }

}

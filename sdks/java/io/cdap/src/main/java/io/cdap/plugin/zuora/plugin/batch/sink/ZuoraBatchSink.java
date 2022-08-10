/*
 *  Copyright © 2020 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.cdap.plugin.zuora.plugin.batch.sink;

import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.annotation.Plugin;
import io.cdap.cdap.api.data.batch.Output;
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.cdap.api.dataset.lib.KeyValue;
import io.cdap.cdap.etl.api.Emitter;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.cdap.etl.api.PipelineConfigurer;
import io.cdap.cdap.etl.api.batch.BatchSink;
import io.cdap.cdap.etl.api.batch.BatchSinkContext;
import io.cdap.plugin.common.IdUtils;
import io.cdap.plugin.common.LineageRecorder;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import io.cdap.plugin.zuora.restobjects.SendObject;
import org.apache.hadoop.io.NullWritable;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Sink Plugin.
 */
@Plugin(type = BatchSink.PLUGIN_TYPE)
@Name(BaseConfig.PLUGIN_NAME)
@Description("Sends data to Zuora")
public class ZuoraBatchSink extends BatchSink<StructuredRecord, NullWritable, SendObject> {

  private ZuoraSinkConfig config;

  public ZuoraBatchSink(ZuoraSinkConfig config) {
    this.config = config;
  }

  @Override
  @SuppressWarnings("ThrowableNotThrown")
  public void configurePipeline(PipelineConfigurer pipelineConfigurer) {
    FailureCollector failureCollector = pipelineConfigurer.getStageConfigurer().getFailureCollector();

    validateConfiguration(failureCollector, pipelineConfigurer.getStageConfigurer().getInputSchema());
  }

  @Override
  public void prepareRun(BatchSinkContext batchSinkContext) {
    Schema inputSchema = batchSinkContext.getInputSchema();
    config.validate(inputSchema);

    batchSinkContext.addOutput(Output.of(config.referenceName, new ZuoraOutputFormatProvider(config)));

    LineageRecorder lineageRecorder = new LineageRecorder(batchSinkContext, config.referenceName);
    lineageRecorder.createExternalDataset(inputSchema);

    if (Objects.requireNonNull(inputSchema).getFields() != null
      && !Objects.requireNonNull(inputSchema.getFields()).isEmpty()) {

      String operationDescription = "Wrote to Zuora %s";
      lineageRecorder.recordWrite("Write", operationDescription,
        inputSchema.getFields().stream()
          .map(Schema.Field::getName)
          .collect(Collectors.toList()));
    }
  }

  @SuppressWarnings("ThrowableNotThrown")
  private void validateConfiguration(FailureCollector failureCollector, Schema schema) {
    config.validate(failureCollector);
    config.validate(schema);
    failureCollector.getOrThrowException();
  }

  @Override
  public void transform(StructuredRecord record, Emitter<KeyValue<NullWritable, SendObject>> emitter) {
    SendObject sendObject = ZuoraSinkTransformer.transform(config, record);
    emitter.emit(new KeyValue<>(null, sendObject));
  }

}

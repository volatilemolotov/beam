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

package io.cdap.plugin.zuora.plugin.batch.source;

import com.google.common.base.Preconditions;
import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.annotation.Plugin;
import io.cdap.cdap.api.data.batch.Input;
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.cdap.api.dataset.lib.KeyValue;
import io.cdap.cdap.etl.api.Emitter;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.cdap.etl.api.PipelineConfigurer;
import io.cdap.cdap.etl.api.batch.BatchSource;
import io.cdap.cdap.etl.api.batch.BatchSourceContext;
import io.cdap.plugin.common.LineageRecorder;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Plugin returns records from Zuora API.
 */
@Plugin(type = BatchSource.PLUGIN_TYPE)
@Name(BaseConfig.PLUGIN_NAME)
@Description("Reads objects from Zuora API")
public class ZuoraBatchSource extends BatchSource<ZuoraSplitArgument, BaseObject, StructuredRecord> {

  ZuoraSourceConfig config;

  public ZuoraBatchSource(ZuoraSourceConfig config) {
    this.config = config;
  }

  @Override
  public void prepareRun(BatchSourceContext batchSourceContext) {
    validateConfiguration(batchSourceContext.getFailureCollector());

    LineageRecorder lineageRecorder = new LineageRecorder(batchSourceContext, config.referenceName);
    lineageRecorder.createExternalDataset(config.getSchema(true));
    lineageRecorder.recordRead("Read", String.format("Reading %s Objects", ZuoraSourceConfig.PLUGIN_NAME),
      Preconditions.checkNotNull(config.getSchema(true).getFields())
        .stream()
        .map(Schema.Field::getName)
        .collect(Collectors.toList()));

    batchSourceContext.setInput(Input.of(config.referenceName, new ZuoraInputFormatProvider(config)));
  }

  @Override
  public void configurePipeline(PipelineConfigurer pipelineConfigurer) {
    FailureCollector failureCollector = pipelineConfigurer.getStageConfigurer().getFailureCollector();

    validateConfiguration(failureCollector);
    pipelineConfigurer.getStageConfigurer().setOutputSchema(config.getSchema(false));
  }

  @Override
  public void transform(KeyValue<ZuoraSplitArgument, BaseObject> input, Emitter<StructuredRecord> emitter)
    throws IOException {

    Schema schema = (input.getKey().getObjectSchema() == null)
    ? ObjectHelper.buildSchema(input.getKey().getObjectName(), null)
    : Schema.parseJson(input.getKey().getObjectSchema());

    emitter.emit(ZuoraSourceTransformer.transform(input.getValue(), schema));
  }

  @SuppressWarnings("ThrowableNotThrown")
  private void validateConfiguration(FailureCollector failureCollector) {
    config.validate(failureCollector);
    failureCollector.getOrThrowException();
  }
}

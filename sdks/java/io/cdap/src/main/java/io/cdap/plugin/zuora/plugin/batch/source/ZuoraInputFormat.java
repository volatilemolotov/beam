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

import com.google.gson.Gson;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * InputFormat for mapreduce job, which provides a single split of data.
 */
@SuppressWarnings("unchecked")
public class ZuoraInputFormat<K, V> extends InputFormat<K, V> {
  private static final Gson gson = new Gson();

  /**
   * Creates splits to execute
   *
   * Minimal unit for the parallelization is an object.
   *
   * In the single-object mode would be always only one split, as REST API does not
   * provide information on amount of records returned.
   *
   * In multi-object mode, amount of splits would be the same as amount of
   * the objects selected by the user.
   *
   * @param jobContext context of the job
   * @return splits
   */
  @Override
  public List<InputSplit> getSplits(JobContext jobContext) {
    Configuration configuration = jobContext.getConfiguration();
    ZuoraSourceConfig conf = gson.fromJson(
      configuration.get(ZuoraSourceConfig.PROPERTY_CONFIG_JSON),
      ZuoraSourceConfig.class
    );

    return conf.getObjectsWithSchema()
      .parallelStream()
      .map(ZuoraSourceSplit::new)
      .collect(Collectors.toList());
  }

  @Override
  @SuppressWarnings("rawtypes")
  public RecordReader createRecordReader(InputSplit inputSplit, TaskAttemptContext taskAttemptContext)
    throws IOException {

    Configuration configuration = taskAttemptContext.getConfiguration();
    ZuoraSourceConfig conf = gson.fromJson(
      configuration.get(ZuoraSourceConfig.PROPERTY_CONFIG_JSON),
      ZuoraSourceConfig.class
    );

    ZuoraSourceSplit sourceSplit = (ZuoraSourceSplit) inputSplit;

    return (conf.isSingleObjectMode())
      ? new ZuoraRecordReader(sourceSplit.getArguments())
      : new ZuoraRecordMultiReader(sourceSplit.getArguments());
  }
}

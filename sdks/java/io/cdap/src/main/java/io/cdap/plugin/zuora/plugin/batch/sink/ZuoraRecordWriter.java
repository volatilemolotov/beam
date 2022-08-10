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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cdap.plugin.zuora.client.ZuoraRestClient;
import io.cdap.plugin.zuora.restobjects.SendObject;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import java.io.IOException;

/**
 * Writes {@link SendObject} into batches and submit them to Zuora send API.
 */
public class ZuoraRecordWriter  extends RecordWriter<NullWritable, SendObject> {
  private static final Gson gson = new GsonBuilder().create();
  private ZuoraRestClient client;

  /**
   * Constructor for ZuoraRecordWriter object.
   * @param taskAttemptContext
   */
  public ZuoraRecordWriter(TaskAttemptContext taskAttemptContext) {
    Configuration conf = taskAttemptContext.getConfiguration();
    String serializedConfig = conf.get(ZuoraOutputFormatProvider.PROPERTY_CONFIG_JSON);
    ZuoraSinkConfig sgConfig  = gson.fromJson(serializedConfig, ZuoraSinkConfig.class);

    client = new ZuoraRestClient(sgConfig);
  }
  @Override
  public void write(NullWritable nullWritable, SendObject sendObject) throws IOException {
    client.sendObject(sendObject);
  }

  @Override
  public void close(TaskAttemptContext taskAttemptContext) {
    //no-op
  }
}

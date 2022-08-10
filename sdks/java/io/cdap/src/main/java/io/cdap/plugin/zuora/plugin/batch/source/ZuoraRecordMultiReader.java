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

import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RecordReader implementation, which reads {@link BaseObject} instances from Zuora API.
 */
public class ZuoraRecordMultiReader extends ZuoraRecordReader {

  /**
   * Constructor for ZuoraRecordMultiReader object.
   * @param arguments
   * @throws IOException in case if resource not found
   */
  public ZuoraRecordMultiReader(ZuoraSplitArgument arguments) throws IOException {
    super(arguments);

    Schema schema = Schema.parseJson(arguments.getObjectSchema());
    List<Pair<String, Schema.Type>> multiObjectFields = new ArrayList<>();
    multiObjectFields.add(new Pair<>(BaseConfig.OBJECT_NAME_FIELD, Schema.Type.STRING));

    schema = ObjectHelper.alterSchema(arguments.getObjectName(), schema, multiObjectFields);
    this.arguments = new ZuoraSplitArgument(arguments.getObjectName(), schema.toString());
  }

  @Override
  public BaseObject getCurrentValue() {
    currentRecord.addCustomField(BaseConfig.OBJECT_NAME_FIELD, arguments.getObjectName());
    return currentRecord;
  }
}

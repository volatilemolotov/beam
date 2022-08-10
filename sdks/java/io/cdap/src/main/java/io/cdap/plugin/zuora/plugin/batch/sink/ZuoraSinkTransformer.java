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

import com.google.common.collect.ImmutableMap;
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.ObjectInfo;
import io.cdap.plugin.zuora.restobjects.SendObject;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import java.util.Map;

/**
 * {@link StructuredRecord} to {@link BaseObject}.
 */
public class ZuoraSinkTransformer {

  private static Object readRecordField(StructuredRecord record, String fieldName, Schema.Type fieldType) {
    Schema.Field field = record.getSchema().getField(fieldName);
    if (field == null) {
      throw new IllegalArgumentException(String.format("Input schema does not provide column '%s'", fieldName));
    }
    Schema fieldSchema = field.getSchema();

    if (fieldSchema.getType() == Schema.Type.UNION) {  // check the situation if field is nullable
      if (fieldSchema.getUnionSchemas().stream().noneMatch(x -> x.getType() == fieldType)) {
        throw new IllegalArgumentException(String.format("Column '%s' does not belong to type '%s'''",
          fieldName, fieldType.name()));
      }
    } else if (field.getSchema().getType() != fieldType) {
      throw new IllegalArgumentException(String.format("Column '%s' does not belong to type '%s'''",
        fieldName, fieldType.name()));
    }
    Object objRecipients = record.get(fieldName);
    if (objRecipients == null) {
      throw new IllegalArgumentException("Record provided empty list of recipients");
    }
    return objRecipients;
  }

  /**
   * Returns the SendObject.
   * @param config the ZuoraSinkConfig
   * @param record the StructuredRecord
   * @return SendObject
   */
  public static SendObject transform(ZuoraSinkConfig config, StructuredRecord record) {
    ObjectInfo objectInfo = ObjectHelper.getObjectInfo(config.getObjectName());

    if (objectInfo == null) {
      throw new IllegalArgumentException(String.format("Unsupported object name '%s'", config.getObjectName()));
    }

    String body = (String) readRecordField(record, config.getBodyColumnName(), Schema.Type.STRING);
    Map<String, String> arguments;

    if (config.getArgumentsSource() == ZuoraSinkConfig.ToArgumentsSource.INPUT) {
      ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
       config.getRequestArguments().keySet().forEach(x -> {
         String value = (String) readRecordField(record, x, Schema.Type.STRING);
         builder.put(x, value);
       });
       arguments = builder.build();
    } else {
      arguments = config.getRequestArguments();
    }

    return new SendObject(objectInfo, body, arguments);
  }
}

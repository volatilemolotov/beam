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
package org.apache.beam.examples.ml.iris;

import static org.apache.beam.vendor.guava.v26_0_jre.com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class KafkaUtils {

  public static void checkBootstrapServers(String bootstrapServers) {
    checkArgument(
        StringUtils.isNoneBlank(bootstrapServers), "Bootstrap servers of Kafka cannot be empty.");
  }

  public static List<String> checkAndGetTopicsAsList(String topics) {
    checkArgument(StringUtils.isNoneBlank(topics), "Input kafka topics cannot be empty.");

    return Arrays.asList(splitByComma(topics));
  }

  public static Map<String, Object> getConsumerConfig(String kafkaConsumerConfig) {
    if (StringUtils.isBlank(kafkaConsumerConfig)) {
      return Collections.emptyMap();
    }

    return Arrays.stream(splitBySemicolon(kafkaConsumerConfig))
        .map(KafkaUtils::splitBySign)
        .collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
  }

  private static String[] splitBySemicolon(String value) {
    final String semicolon = ";";

    return value.split(semicolon);
  }

  private static String[] splitByComma(String value) {
    final String comma = ",";

    return value.split(comma);
  }

  private static String[] splitBySign(String value) {
    final String sign = "=";

    return value.split(sign);
  }
}

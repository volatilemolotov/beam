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
package io.cdap.plugin.zuora.restobjects;

import java.util.Map;

/** Represents the object which could be posted to the API. */
public class SendObject {
  private String apiUrl;
  private String body;
  private Map<String, String> arguments;

  /**
   * Constructor for SendObject object.
   *
   * @param objectInfo the objectInfo
   * @param body the body
   * @param arguments the arguments
   */
  public SendObject(ObjectInfo objectInfo, String body, Map<String, String> arguments) {
    this.apiUrl = objectInfo.getRestAPIUrl();
    this.body = body;
    this.arguments = arguments;
  }

  public String getApiUrl() {
    return apiUrl;
  }

  public String getBody() {
    return body;
  }

  public Map<String, String> getArguments() {
    return arguments;
  }
}

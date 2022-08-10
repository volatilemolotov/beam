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

package io.cdap.plugin.zuora.restobjects.objects;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.gson.annotations.SerializedName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * API Response Wrapper.
 *
 * @param <T> Any {@link BaseObject} object
 */
public class BaseResult<T> {
  @SerializedName("result")
  private List<T> result;

  @SerializedName(value = "nextPage")
  private String nextPage;

  @SerializedName(value = "success")
  private Boolean success;

  @SerializedName(value = "httpCode")
  private Integer httpCode; // restClient setting this field in case is request were not successful

  @SerializedName("processId")
  private String processId;

  @SerializedName("reasons")
  private List<BaseResultErrorReason> reasons;

  @SerializedName(value = "cdapObjectName")
  private String cdapObjectName;

  @SerializedName(value = "restApiEndpoint")
  private String restApiEndpoint;

  public List<T> getResult() {
    return result;
  }

  /**
   * Returns the map of string.
   * @return map of string
   */
  public Map<String, String> getNextPageArguments() {
    if (Strings.isNullOrEmpty(nextPage)) {
      return null;
    }
    URL url;
    try {
      url = new URL(restApiEndpoint + nextPage);
    } catch (MalformedURLException e) {
      // Next page field default is null, consider wrong url in the same way
      return null;
    }
    ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
    Arrays.stream(url.getQuery().split("&"))
      .map(x -> x.split("="))
      .forEach(x -> builder.put(x[0], x[1]));
    return builder.build();
  }

  /**
   * Returns the string.
   * @return string
   */
  public String getNextPage() {
    if (Strings.isNullOrEmpty(nextPage)) {
      return null;
    }

    URL url;
    try {
      url = new URL(restApiEndpoint + nextPage);
    } catch (MalformedURLException e) {
      // Next page field default is null, consider wrong url in the same way
      return null;
    }
    return url.getPath();
  }

  public String getCdapObjectName() {
    return cdapObjectName;
  }

  public void setCdapObjectName(String cdapObjectName) {
    this.cdapObjectName = cdapObjectName;
  }

  public Boolean isSuccess() {
    return success;
  }

  public String getProcessId() {
    return processId;
  }

  /**
   * Return exception messages from the API.
   * @param flatMessage only compile messages, without exception codes
   */
  public String getReason(boolean flatMessage) {
    if (reasons == null || reasons.isEmpty()) {
      return "Unknown exception";
    }
    StringBuilder builder = new StringBuilder();
      reasons.forEach(x -> {
        if (!flatMessage) {
          builder
            .append("code:")
            .append(x.getCode())
            .append(", message:");
        }
        builder
          .append(x.getMessage())
          .append("; ");
      });
    return builder.toString();
  }

  public Integer getHttpCode() {
    return (httpCode == null) ? 200 : httpCode;
  }

  public String getRestApiHost() {
    return restApiEndpoint;
  }

  public void setRestApiEndpoint(String restApiEndpoint) {
    this.restApiEndpoint = restApiEndpoint;
  }
}

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

import com.google.auto.value.AutoValue;
import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.PredictRequest;
import com.google.cloud.aiplatform.v1.PredictResponse;
import com.google.cloud.aiplatform.v1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1.PredictionServiceSettings;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.List;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.vendor.grpc.v1p26p0.com.google.gson.Gson;
import org.springframework.util.CollectionUtils;

public class IrisPrediction {

  @AutoValue
  public abstract static class IrisPredictionTransform
      extends PTransform<PCollection<String>, PCollection<String>> {

    public static Builder newBuilder() {
      return new AutoValue_IrisPrediction_IrisPredictionTransform.Builder();
    }

    public abstract String endpointUrl();

    public abstract String projectId();

    public abstract String location();

    public abstract String endpointId();

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract IrisPredictionTransform.Builder setEndpointUrl(String endpoint);

      public abstract IrisPredictionTransform.Builder setProjectId(String projectId);

      public abstract IrisPredictionTransform.Builder setLocation(String location);

      public abstract IrisPredictionTransform.Builder setEndpointId(String endpointId);

      public abstract IrisPredictionTransform build();
    }

    @Override
    public PCollection<String> expand(PCollection<String> input) {
      return input.apply(
          ParDo.of(new IrisPredictionFn(endpointUrl(), projectId(), location(), endpointId())));
    }
  }

  public static class IrisPredictionFn extends DoFn<String, String> {

    private final String endpointUrl;
    private final String projectId;
    private final String location;
    private final String endpointId;

    public IrisPredictionFn(
        String endpointUrl, String projectId, String location, String endpointId) {
      this.endpointUrl = endpointUrl;
      this.projectId = projectId;
      this.location = location;
      this.endpointId = endpointId;
    }

    @ProcessElement
    public void process(ProcessContext context) throws IOException {
      try {
        final PredictionServiceSettings settings =
            PredictionServiceSettings.newBuilder().setEndpoint(endpointUrl).build();

        final EndpointName endpointName = EndpointName.of(projectId, location, endpointId);
        final List<Value> instanceList = parseInstanceFromJson(context.element());
        final PredictResponse predictResponse = predict(settings, endpointName, instanceList);

        if (!CollectionUtils.isEmpty(predictResponse.getPredictionsList())) {
          predictResponse
              .getPredictionsList()
              .forEach(
                  p -> {
                    int maxIndex = maxIndex(p.getListValue().getValuesList());
                    context.output(String.valueOf(maxIndex));
                  });
        }
      } catch (Exception e) {
        context.output(e.getMessage());
      }
    }

    private List<Value> parseInstanceFromJson(String json) throws InvalidProtocolBufferException {
      final Gson gson = new Gson();
      final IrisJsonParams irisModel = gson.fromJson(json, IrisJsonParams.class);

      ListValue.Builder listValue = ListValue.newBuilder();
      JsonFormat.parser().merge(irisModel.getInstance(), listValue);

      return listValue.getValuesList();
    }

    private PredictResponse predict(
        PredictionServiceSettings settings, EndpointName endpointName, List<Value> instanceList)
        throws IOException {
      PredictRequest request =
          PredictRequest.newBuilder()
              .setEndpoint(endpointName.toString())
              .addAllInstances(instanceList)
              .build();

      try (PredictionServiceClient client = PredictionServiceClient.create(settings)) {
        return client.predict(request);
      }
    }

    private static int maxIndex(List<Value> values) {
      int maxIndex = -1;
      Double maxValue = null;

      for (int i = 0; i < values.size(); i++) {
        Double numberValue = values.get(i).getNumberValue();

        if (maxValue == null || numberValue > maxValue) {
          maxValue = numberValue;
          maxIndex = i;
        }
      }

      return maxIndex;
    }
  }
}

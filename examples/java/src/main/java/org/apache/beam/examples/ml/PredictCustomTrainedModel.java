package org.apache.beam.examples.ml;

import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.PredictRequest;
import com.google.cloud.aiplatform.v1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1.PredictionServiceSettings;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.List;

public class PredictCustomTrainedModel {

  public static void main(String[] args) throws IOException {
    final String aiplatform = "us-central1-aiplatform.googleapis.com:443";
    PredictionServiceSettings settings =
        PredictionServiceSettings.newBuilder()
            .setEndpoint(aiplatform)
            .build();

    final String endpointId ="5006964846659371008";
    final String projectId ="1023172886594";
    final String location = "us-central1";
    EndpointName endpoint = EndpointName.of(projectId, location, endpointId);

    predict(settings, endpoint);
  }

  private static void predict(PredictionServiceSettings settings, EndpointName endpoint)
      throws IOException {
    final String instance = "[[5.1, 3.3, 1.7, 0.5]]";

    try (PredictionServiceClient client = PredictionServiceClient.create(settings)) {
      ListValue.Builder listValue = ListValue.newBuilder();
      JsonFormat.parser().merge(instance, listValue);
      List<Value> instanceList = listValue.getValuesList();

      PredictRequest request = PredictRequest.newBuilder()
          .setEndpoint(endpoint.toString())
          .addAllInstances(instanceList)
          .build();

      client.predict(request);
    }
  }
}

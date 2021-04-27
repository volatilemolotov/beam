package org.apache.beam.examples.complete.redispubsubtofile;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;

public interface RedisPubSubToFileOptions extends PipelineOptions {

  @Description("Host of Redis.")
  @Validation.Required
  String getHost();

  void setHost(String host);

  @Description("Port of Redis.")
  @Validation.Required
  int getPort();

  void setPort(int port);

  @Description("Filepath for save data from Redis.")
  @Validation.Required
  String getOutputFilePath();

  void setOutputFilePath(String filePath);

  @Description("Comma separated list of Redis Channel(s) to read input from (eg: channel1, channel2).")
  @Validation.Required
  String[] getChannels();

  void setChannels(String... channels);
}

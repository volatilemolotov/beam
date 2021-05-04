<!--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
-->

# Apache Beam example to show how can use trained model that deployed in AI Platform in streaming pipeline

This directory contains an [Apache Beam](https://beam.apache.org/) pipeline example that creates a pipeline to read data
from a single or multiple topics from [Apache Kafka](https://kafka.apache.org/), 
gets predictions from model trained on [dataset](https://storage.googleapis.com/download.tensorflow.org/data/iris_training.csv) and deployed on [AI Platform](https://cloud.google.com/ai-platform/). 
Model trained to follow the [example](https://www.tensorflow.org/tutorials/customization/custom_training_walkthrough).

The IrisPredictionPipeline is streaming pipeline which ingests data in JSON format:
```
{ "sepalLength": X, "sepalWidth": Y, "petalLength": Z, "petalWidth": W }
```
from Kafka, gets prediction from AI Platform and saves it in file in CSV format: 
```
0 (Iris setosa), 1 (Iris versicolor), 2 (Iris virginica) or error.
```

## Requirements

- Java 8
- Kafka Bootstrap Server(s) up and running
- Existing source Kafka topic(s)
- Trained and deployed model in AI Platform (Unified)  
- An existing output directory path

## Getting Started

This section describes what is needed to get the example up and running.

- Gradle preparation
- Local execution
- Running as a Dataflow Template

## Gradle preparation

To run this example your `build.gradle` file should contain the following task to execute the pipeline:

```
task execute (type:JavaExec) {
    main = System.getProperty("mainClass")
    classpath = sourceSets.main.runtimeClasspath
    systemProperties System.getProperties()
    args System.getProperty("exec.args", "").split()
}
```

This task allows to run the pipeline via the following command:

```bash
gradle clean execute -DmainClass=org.apache.beam.examples.ml.iris.IrisPredictionPipeline \
     -Dexec.args="--<argument>=<value> --<argument>=<value>"
```

## Running the pipeline

To execute this pipeline, specify the parameters:

- Kafka Bootstrap servers
- Kafka input topics
- AI Platform regional endpoint
- Project ID that trained model deployed in
- Region that used for trained model
- Endpoint ID of trained model  
- Output path

in the following format:

```bash
--bootstrapServers=host:port \
--inputTopics=your-input-topic \
--endpointUrl=region-host:port \
--projectId=your-model-project-id \
--endpointId=your-model-endpoint-id \
--location=your-model-region \
--outputDirectory=your-local-directory
```

By default this will run the pipeline locally with the DirectRunner. To change the runner, specify:

```bash
--runner=YOUR_SELECTED_RUNNER
```

See the [documentation](http://beam.apache.org/get-started/quickstart/) and
the [Examples README](../../../../../../../../../README.md) for more information about how to run this example.
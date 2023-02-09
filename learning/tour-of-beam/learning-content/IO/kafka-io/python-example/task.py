#   Licensed to the Apache Software Foundation (ASF) under one
#   or more contributor license agreements.  See the NOTICE file
#   distributed with this work for additional information
#   regarding copyright ownership.  The ASF licenses this file
#   to you under the Apache License, Version 2.0 (the
#   "License"); you may not use this file except in compliance
#   with the License.  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.

# beam-playground:
#   name: read-query
#   description: TextIO read query example.
#   multifile: false
#   context_line: 34
#   categories:
#     - Quickstart
#   complexity: ADVANCED
#   tags:
#     - hellobeam


import apache_beam as beam
from apache_beam.io.kafka import ReadFromKafka, WriteToKafka

def process_data(element):
    # Do some processing on the data
    return element

options = beam.options.pipeline_options.PipelineOptions()
p = beam.Pipeline(options=options)

input_topic = 'input-topic'
output_topic = 'output-topic'
bootstrap_servers = {"bootstrap.servers": "localhost:9092"}

(p | "Read from Kafka" >> ReadFromKafka(
      topics=[input_topic],
      consumer_config=bootstrap_servers)
 | "Process data" >> beam.Map(process_data)
 | "Write to Kafka" >> WriteToKafka(
      topic=output_topic,
      producer_config = bootstrap_servers,
      key='key',
      value='value')
)

p.run().wait_until_finish()

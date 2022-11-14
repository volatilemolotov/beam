#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#

project_id           = "sandbox-playground-001"          #GCP Project ID
network_name         = "test-network-del-after"        #GCP VPC Network Name for Playground deployment
gke_name             = "playground-backend-test"  #Playground GKE Cluster name
region               = "us-west1"            #Set the deployment region
location             = "us-west1-b"          #Select the deployment location from available in the specified region
state_bucket         = "playground-state-bucket"         #GCS bucket name for Beam Playground temp files
bucket_examples_name = "playground-examples-bucket" #GCS bucket name for Playground examples storage

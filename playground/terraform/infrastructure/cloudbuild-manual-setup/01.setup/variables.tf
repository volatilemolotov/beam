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
<<<<<<<< HEAD:playground/terraform/infrastructure/cloudbuild-manual-setup/01.setup/variables.tf

variable "project_id" {
  type        = string
  description = "The ID of the Google Cloud project within which resources are provisioned"
}

variable "cloudbuild_service_account_id" {
  type        = string
  description = "The ID of the cloud build service account responsible for provisioning Google Cloud resources"
  default     = "playground-cloudbuild-sa"
}
========
#

sdk:
  - Java
  - Python
  - Go
id: combine
name: Combine
content:
  - simple-function
  - combine-fn
  - combine-per-key
>>>>>>>> tob-core-transforms-module:learning/tour-of-beam/learning-content/core-transforms/combine/group-info.yaml

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

<<<<<<<< HEAD:playground/terraform/infrastructure/cloudbuild-manual-setup/01.setup/terraform.tf
terraform {
  backend "gcs" {
    prefix = "01.setup"
  }
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "~> 4.0.0"
    }
  }
}
========
sdk:
  - Java
  - Python
  - Go
id: map
name: Map
content:
  - pardo-one-to-one
  - pardo-one-to-many
  - map-elements
  - flat-map-elements
  - group-by-key
  - co-group-by-key
>>>>>>>> tob-core-transforms-module:learning/tour-of-beam/learning-content/core-transforms/map/group-info.yaml

# Copyright 2019 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.


locals {
  env = "dev"
}

provider "google" {
  project = var.project_id
  region = var.region
}

module "setup" {
  source             = '../../modules/setup'
  project_id         = var.project_id
  service_account_id = var.service_account_id
}

module "buckets" {
  source        = "../../modules/buckets"
  project_id    = var.project_id
  name          = var.function_bucket_name
  storage_class = var.function_bucket_storage_class
  location      = var.function_bucket_location
}

module "cloud-functions" {
  source = "../../modules/cloud-functions"
  project_id = var.project_id
  service_account_email = module.setup.service-account-email
  region = var.region
}
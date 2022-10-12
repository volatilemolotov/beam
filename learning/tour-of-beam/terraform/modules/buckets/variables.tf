#Generates archive of source code
data "archive_file" "source" {
  type        = "zip"
  source_dir  = "../../../backend"
  output_path = "/tmp/backend.zip"
}

variable "name" {
  description = "Name of Bucket to Store Cloud Functions"
  default     = "tour-of-beam-cloudfunction-bucket"
}

variable "region" {
  description = "Cloud Functions Bucket Region"
  default     = "us-central1"
}

variable "project_id" {
  description = "The GCP Project ID where ToB Cloud Functions will be created"
}

variable "storage_class" {
  description = "Functions Bucket Storage Class"
  default     = "STANDARD"
}
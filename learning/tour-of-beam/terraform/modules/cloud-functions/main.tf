module "buckets" {
  source = "../buckets"
}

module "setup" {
  source = "../setup"
}

resource "google_cloudfunctions_function" "cloud_function" {
  name                  = "tour-of-beam-backend-cloud-function"
  runtime               = "go116"
  service_account_email = module.setup.service-account-email
  region                = var.region
  ingress_settings      = "ALLOW_ALL"
  # Get the source code of the cloud function as a Zip compression
  source_archive_bucket = module.buckets.function-bucket-name
  source_archive_object = module.buckets.function-bucket-object

  trigger_http = true
  # Name of the function that will be executed when the Google Cloud Function is triggered (def hello_gcs)
  entry_point           = "init"

}
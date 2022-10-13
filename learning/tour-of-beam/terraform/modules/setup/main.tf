module "cloud-functions" {
  source = "../cloud-functions"
}

resource "google_service_account" "sa_cloud_function" {
  account_id   = var.service_account_id
  display_name = "Service Account to run Cloud Functions"
  project      = var.project_id
}

resource "google_project_iam_member" "terraform_service_account_roles" {
  for_each = toset([
    "roles/cloudfunctions.developer", "roles/storage.objectViewer", "roles/storage.objectCreator",
  ])
  role    = each.key
  member  = "serviceAccount:${google_service_account.sa_cloud_function.email}"
  project = var.project_id
}

resource "google_cloudfunctions_function_iam_member" "invoker" {
  project        = var.project_id
  region         = module.cloud-functions.cloud-function-region
  cloud_function = module.cloud-functions.cloud-function-name

  role   = "roles/cloudfunctions.invoker"
  member = "allUsers"
}

#API enable
# Enable API for Cloud Build
resource "google_project_service" "cloud_build" {
  project = var.project_id
  service = "cloudbuild.googleapis.com"
}

# Enable API for Cloud Function
resource "google_project_service" "cloud_function" {
  project = var.project_id
  service = "cloudfunctions.googleapis.com"
}

# Enable API for Resource Manager
resource "google_project_service" "resource_manager" {
  project = var.project_id
  service = "cloudresourcemanager.googleapis.com"
}

# Enable API for IAM
resource "google_project_service" "iam" {
  project = var.project_id
  service = "iam.googleapis.com"
}
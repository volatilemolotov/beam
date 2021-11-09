/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * License); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


plugins {
  id("com.gradle.enterprise") version "3.4.1" apply false
}


// Plugins which require online access should not be enabled when running in offline mode.
if (!gradle.startParameter.isOffline) {
  apply(plugin = "com.gradle.enterprise")
}

// JENKINS_HOME and BUILD_ID set automatically during Jenkins execution
val isJenkinsBuild = arrayOf("JENKINS_HOME", "BUILD_ID").all { System.getenv(it) != null }
// GITHUB_REPOSITORY and GITHUB_RUN_ID set automatically during Github Actions run
val isGithubActionsBuild = arrayOf("GITHUB_REPOSITORY", "GITHUB_RUN_ID").all { System.getenv(it) != null }
if (isJenkinsBuild || isGithubActionsBuild) {
  gradleEnterprise {
    buildScan {
      // Build Scan enabled and TOS accepted for Jenkins lab build. This does not apply to builds on
      // non-Jenkins machines. Developers need to separately enable and accept TOS to use build scans.
      termsOfServiceUrl = "https://gradle.com/terms-of-service"
      termsOfServiceAgree = "yes"
      publishAlways()
    }
  }
}

rootProject.name = "beam"


include(":playground")
include(":playground:backend")
include(":playground:frontend")


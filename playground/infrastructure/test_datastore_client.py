# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.


from typing import List
from unittest.mock import MagicMock, ANY

import mock
import pytest
from mock.mock import call

from api.v1.api_pb2 import SDK_JAVA, STATUS_UNSPECIFIED
from datastore_client import DatastoreClient, DatastoreException
from helper import Example, Tag

"""
Unit tests for the Cloud Datastore client
"""


class TestDatastoreClient:

    @mock.patch("config.Config.GOOGLE_CLOUD_PROJECT")
    @mock.patch("google.cloud.datastore.Client")
    def test_save_to_cloud_datastore_when_schema_version_not_found(self, _, mock_config_project):
        """
        Test saving examples to the cloud datastore when the schema version not found
        """
        mock_config_project.return_value = "MOCK_PROJECT_ID"
        with pytest.raises(DatastoreException, match="Schema versions not found. Schema versions must be downloaded during application startup"):
            examples = self._get_examples(1)
            client = DatastoreClient()
            client.save_to_cloud_datastore(examples)

    def test_save_to_cloud_datastore_when_google_cloud_project_id_not_set(self):
        """
        Test saving examples to the cloud datastore when the Google Cloud Project ID is not set
        """
        with pytest.raises(KeyError, match="GOOGLE_CLOUD_PROJECT environment variable should be specified in os"):
            DatastoreClient()

    @mock.patch("datastore_client.DatastoreClient._get_all_examples")
    @mock.patch("datastore_client.DatastoreClient._get_actual_schema_version_key")
    @mock.patch("config.Config.GOOGLE_CLOUD_PROJECT")
    @mock.patch("google.cloud.datastore.Client")
    def test_save_to_cloud_datastore_in_the_usual_case(self, mock_client, mock_config_project, mock_get_schema, mock_get_examples):
        """
        Test saving examples to the cloud datastore in the usual case
        """
        mock_schema_key = MagicMock()
        mock_get_schema.return_value = mock_schema_key
        mock_examples = MagicMock()
        mock_get_examples.return_value = mock_examples
        mock_config_project.return_value = "MOCK_PROJECT_ID"

        examples = self._get_examples(1)
        client = DatastoreClient()
        client.save_to_cloud_datastore(examples)
        mock_client.assert_called_once()
        mock_get_schema.assert_called_once()
        mock_get_examples.assert_called_once()
        calls = [call().key('pg_sdks', 'SDK_JAVA'),
                 call().key('pg_examples', 'MOCK_NAME_0_SDK_JAVA'),
                 call().key('pg_snippets', 'MOCK_NAME_0_SDK_JAVA'),
                 call().key('pg_pc_objects', 'MOCK_NAME_0_SDK_JAVA_OUTPUT'),
                 call().key('pg_files', 'MOCK_NAME_0_SDK_JAVA_0'),
                 call().put_multi(ANY),
                 call().put_multi(ANY),
                 call().put_multi(ANY),
                 call().put_multi(ANY)]
        mock_client.assert_has_calls(calls, any_order=False)
        mock_client.delete_multi.assert_not_called()

    def _get_examples(self, number_of_examples: int) -> List[Example]:
        examples = []
        for number in range(number_of_examples):
            object_meta = {
                "name": f"MOCK_NAME_{number}",
                "description": f"MOCK_DESCRIPTION_{number}",
                "multifile": False,
                "categories": ["MOCK_CATEGORY_1", "MOCK_CATEGORY_2"],
                "pipeline_options": "--MOCK_OPTION MOCK_OPTION_VALUE"
            }
            example = Example(
                name=f"MOCK_NAME_{number}",
                pipeline_id=f"MOCK_PIPELINE_ID_{number}",
                sdk=SDK_JAVA,
                filepath=f"MOCK_FILEPATH_{number}",
                code=f"MOCK_CODE_{number}",
                output=f"MOCK_OUTPUT_{number}",
                status=STATUS_UNSPECIFIED,
                tag=Tag(**object_meta),
                link=f"MOCK_LINK_{number}")
            examples.append(example)
        return examples

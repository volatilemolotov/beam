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

# import unittest
# import mock
import os
import shutil
from pathlib import Path

import pytest

from cd_helper import CDHelper, TEMP_FOLDER
from api.v1.api_pb2 import SDK_JAVA, STATUS_UNSPECIFIED

# class Test(unittest.TestCase):
#     @mock.patch('cd_helper.CDHelper._get_outputs')
#     @mock.patch('cd_helper.CDHelper._save_to_cloud_storage')
#     def test_store_examples(self, mock_get_outputs, mock_save_to_cloud_storage):
#         helper = CDHelper()
#         helper.store_examples([])
#
#         mock_get_outputs.assert_called_once_with([])
#         mock_save_to_cloud_storage.assert_called_once_with([])
from helper import Example


@pytest.fixture
def delete_temp_folder():
    """Create temp folder for tests with storing files"""
    yield delete_temp_folder
    if os.path.exists(TEMP_FOLDER):
        shutil.rmtree(TEMP_FOLDER)


def upload_blob():
    """
    Fake method for mocking
    Returns: None

    """
    return None


def test__get_cloud_file_name():
    """
    Test getting the path where file will be stored at the bucket
    Returns:

    """
    expected_result = "SDK_JAVA/base_folder/file.java"
    expected_result_with_extension = "SDK_JAVA/base_folder/file.output"
    assert CDHelper()._get_cloud_file_name(SDK_JAVA, "base_folder", "file") == expected_result
    assert CDHelper()._get_cloud_file_name(SDK_JAVA, "base_folder", "file", "output") == expected_result_with_extension


def test__get_data_from_template():
    """
    Test finding beam-playground tag and extract the information of the example to dictionary
    Returns:

    """
    code = '''
    Some text
    
    /*
    Beam-playground:
      name: name
      description: description
      multifile: false
      categories:
        - category-1
        - category-2
    */
    
    More of some text
    '''
    expected_result = {'name': 'name', 'description': 'description', 'multifile': False,
                       'categories': ['category-1', 'category-2']}
    assert CDHelper()._get_data_from_template(code) == expected_result


def test__write_to_os(delete_temp_folder):
    """
    Test writing code of an example, output and meta info to the filesystem (in temp folder)
    Args:
        delete_temp_folder:

    Returns:

    """
    example = Example("name", "pipeline_id", SDK_JAVA, "filepath", "code_of_example",
                      "output_of_example", STATUS_UNSPECIFIED)
    object_meta = {'name': 'name', 'description': 'description', 'multifile': False,
                   'categories': ['category-1', 'category-2']}
    expected_result = {'SDK_JAVA/name/name.java': 'temp/pipeline_id/SDK_JAVA/name/name.java',
                       'SDK_JAVA/name/name.output': 'temp/pipeline_id/SDK_JAVA/name/name.output',
                       'SDK_JAVA/name/meta.info': 'temp/pipeline_id/SDK_JAVA/name/meta.info'}
    assert CDHelper()._write_to_os(example, object_meta) == expected_result

    object_meta.pop('name')
    with pytest.raises(KeyError):
        CDHelper()._write_to_os(example, object_meta)  # "object_meta should contain 'name' field"


def test__save_to_cloud_storage(mocker):
    """
    Test saving examples, outputs and meta to bucket
    Args:
        mocker:

    Returns:

    """
    mocker.patch(
        'cd_helper.CDHelper._upload_blob',
        return_value=upload_blob
    )
    mocker.patch(
        'cd_helper.CDHelper._write_to_os',
        return_value={"": ""}
    )
    example = Example("name", "pipeline_id", SDK_JAVA, "filepath", "code_of_example",
                      "output_of_example", STATUS_UNSPECIFIED)

    CDHelper()._save_to_cloud_storage([example])


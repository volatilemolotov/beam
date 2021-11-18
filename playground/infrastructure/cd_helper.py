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
import asyncio
import os
import re
import yaml
import shutil
from pathlib import Path
from google.cloud import storage
from api.v1.api_pb2 import Sdk
from helper import Example, get_statuses
from grpc_client import GRPCClient

BUCKET_NAME = "test_public_bucket_akvelon"
TEMP_FOLDER = "temp"
PATTERN = 'Beam-playground:\n {2} *name: \w+\n {2} *description: .+\n {2} *multifile: (true|false)\n {2} *categories:\n( {4} *- [\w\-]+\n)+'
PLAYGROUND_TAG = "Beam-playground"
EXTENSIONS = {"SDK_JAVA": "java", "SDK_GO": "go", "SDK_PYTHON": "py"}


class CDHelper:
    """ Helper for CD step.

    It is used to save beam examples/katas/tests and their output on the Google Cloud.
    """

    def store_examples(self, examples: [Example]):
        """ Store beam examples and their output in the Google Cloud.
        """
        asyncio.run(self.get_outputs(examples))
        self._save_to_cloud_storage(examples)
        self.clear_temp_folder()

    async def get_outputs(self, examples: [Example]):
        """ Run beam examples and keep their output.

        Call the backend to start code processing for the examples. Then receive code output.

        Args:
            examples: beam examples that should be run
        """
        get_statuses(examples)  # run examples code and wait until all are executed
        tasks = []
        client = GRPCClient()
        for example in examples:
            tasks.append(client.get_run_output(example.pipeline_id))
        outputs = await asyncio.gather(*tasks)
        for output, example in zip(outputs, examples):
            example.output = output

    def _save_to_cloud_storage(self, examples: [Example]):
        """
        Save beam examples and their outputs using backend instance.

        Args:
            examples: precompiled examples
        """
        for example in examples:
            object_meta = self._get_data_from_template(example.code)
            file_names = self._write_to_os(example, object_meta)
            for cloud_file_name, local_file_name in file_names.items():
                self._upload_blob(source_file=local_file_name, destination_blob_name=cloud_file_name)

    def _write_to_os(self, example: Example, object_meta: dict):
        """
        Write code of an example, output and meta info to the filesystem (in temp folder)

        Args:
            example: example object
            object_meta: meta information of this example

        Returns: dict {path_at_the_bucket:path_at_the_os}

        """
        path_to_object_folder = os.path.join(TEMP_FOLDER, example.pipeline_id, Sdk.Name(example.sdk),
                                             object_meta["name"])
        Path(path_to_object_folder).mkdir(parents=True, exist_ok=True)

        file_names = dict()
        code_path = self._get_cloud_file_name(sdk=example.sdk, base_folder_name=object_meta["name"],
                                              file_name=object_meta["name"])
        output_path = self._get_cloud_file_name(sdk=example.sdk, base_folder_name=object_meta["name"],
                                                file_name=object_meta["name"], extension="output")
        meta_path = self._get_cloud_file_name(sdk=example.sdk, base_folder_name=object_meta["name"],
                                              file_name="meta", extension="info")
        file_names[code_path] = example.code
        file_names[output_path] = example.output
        file_names[meta_path] = str(object_meta)
        for file_name, file_content in file_names.items():
            local_file_path = os.path.join(TEMP_FOLDER, example.pipeline_id, file_name)
            with open(local_file_path, 'w') as file:
                file.write(file_content)
            file_names[file_name] = local_file_path  # don't need content anymore, instead save the local path
        return file_names

    def _get_data_from_template(self, code):
        """
        Find beam-playground tag and extract the information of the example.
        Args:
            code: code of an example

        Returns: dictionary with name, description, categories, etc of the source code

        """
        res = re.search(PATTERN, code)
        if res is not None and res.span() is not None:
            m = res.span()
            yaml_code = code[m[0]:m[1]]
            try:
                object_meta = yaml.load(yaml_code, Loader=yaml.SafeLoader)
                return object_meta[PLAYGROUND_TAG]
            except Exception as exp:
                print(exp)  ## todo add logErr

    def _get_cloud_file_name(self, sdk: Sdk, base_folder_name: str, file_name: str, extension: str = None):
        """
        Get the path where file will be stored at the bucket.
        Args:
            sdk: sdk of the example
            file_name: name of the example
            base_folder_name: name of the folder where example is stored (eq. to example name)
            extension: extension of the file

        Returns: file name
        """
        if extension is None:
            extension = EXTENSIONS[Sdk.Name(sdk)]
        return os.path.join(Sdk.Name(sdk), base_folder_name, "{}.{}".format(file_name, extension))

    def _upload_blob(self, source_file: str, destination_blob_name: str):
        """
        Upload a file to the bucket.
        Args:
            source_file: name of the file to be stored
            destination_blob_name: "storage-object-name"
        """
        storage_client = storage.Client()
        bucket = storage_client.bucket(BUCKET_NAME)
        blob = bucket.blob(destination_blob_name)
        blob.upload_from_filename(source_file)
        # change caching to no caching
        blob.cache_control = 'no-store'
        blob.patch()
        print("File uploaded to {}.".format(destination_blob_name))

    def clear_temp_folder(self):
        """
        Remove temporary folder with source files.
        """
        shutil.rmtree(TEMP_FOLDER)

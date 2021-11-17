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

import os
import re
from pathlib import Path

import yaml
from helper import find_examples, Example
from google.cloud import storage
from api.v1.api_pb2 import Sdk, SDK_JAVA

folder_prefix = "./{}/{}/{}"

file_prefix = "./{}/{}"

playground_tag = "beam-playground"
bucket_name = "test_public_bucket_akvelon"

extensions = {"SDK_JAVA": "java", "SDK_GO": "go", "SDK_PYTHON": "py"}
PATTERN = 'beam-playground:\n {2} *name: \w+\n {2} *description: .+\n {2} *multifile: (true|false)\n {2} ' \
          '*categories:\n( {4} *- [\w\-]+\n)+ '
pattern_start = 'beam-playground'


class CDHelper:
    """ Helper for CD step.

    It is used to save beam examples/katas/tests and their output on the Google Cloud.
    """

    def get_examples_and_store(self):
        """ Store beam examples and their output in the Google Cloud.
        """
        root_dir = os.getenv("BEAM_ROOT_DIR")
        examples = find_examples(root_dir)
        self._run_code_all_examples(examples)
        self._save_to_cloud_storage(examples)

    def _run_code_all_examples(self, examples: [Example]):
        """ Run beam examples and keep their ouput.

        Call the backend to start code processing for the examples. Then receive code output.

        Args:
            examples: beam examples that should be run
        """
        # TODO [BEAM-13258] Implement logic
        for example in examples:
            example.output = "output"
            example.pipelineId = "testPipelineId"
            example.sdk = SDK_JAVA

    def _save_to_cloud_storage(self, examples: [Example]):
        """ Save beam examples and their output using backend instance.

        Args:
            examples: beam examples with their output
        """
        for example in examples:
            object_meta = self.get_data_from_template(example.code)
            file_names = self._write_to_os(example, object_meta)
            for file_name in file_names:
                self.upload_blob(source_file=file_prefix.format(example.pipelineId, file_name),
                                 destination_blob_name=file_name)

    def _write_to_os(self, example: Example, object_meta: dict):
        """

        Args:
            example: example object
            object_meta: meta information to this example

        Returns: array of file names

        """
        Path(folder_prefix.format(example.pipelineId, example.sdk, example.name)).mkdir(parents=True, exist_ok=True)

        file_names = dict()
        code_path = self.get_full_file_name(sdk=example.sdk, base_folder_name=object_meta["name"],
                                            file_name=object_meta["name"])
        output_path = self.get_full_file_name(sdk=example.sdk, base_folder_name=object_meta["name"],
                                              file_name=object_meta["name"], extension="output")
        meta_path = self.get_full_file_name(sdk=example.sdk, base_folder_name=object_meta["name"], file_name="meta",
                                            extension="info")
        file_names[code_path] = example.code
        file_names[output_path] = example.output
        file_names[meta_path] = str(object_meta)
        for file_name, file_content in file_names:
            with open(file_prefix.format(example.pipelineId, file_name), 'w') as file:
                file.write(file_content)
        return file_names.keys()

    def get_data_from_template(self, code):
        """
        Args:
            code:  source code of an example

        Returns: dictionary with name, description, categories, etc of the source code

        """
        res = re.search(PATTERN, code)
        if res.span() is not None:
            m = res.span()
            yaml_code = code[m[0]:m[1]]
            try:
                object_meta = yaml.load(yaml_code, Loader=yaml.SafeLoader)
                return object_meta[pattern_start]
            except Exception as exp:
                print(exp)  ## todo add logErr

    def get_full_file_name(self, sdk: Sdk, base_folder_name: str, file_name: str, extension: str = None):
        """
        Args:
            sdk:
            file_name:
            base_folder_name:
            extension:

        Returns:

        """
        if extension is None:
            extension = extensions[sdk]
        return "{}/{}/{}.{}".format(sdk, base_folder_name, file_name, extension)

    def upload_blob(self, source_file: str, destination_blob_name: str):
        """
        Uploads a file to the bucket.
        Args:
            source_file: name of the file to be stored
            destination_blob_name: "storage-object-name"
        Returns:

        """
        # os.environ[
        #     'GOOGLE_APPLICATION_CREDENTIALS'] = "/home/daria/IdeaProjects/beam/playground/infrastructure/play" \
        #                                         "-test-key.json "
        # storage_client = storage.Client()
        # bucket = storage_client.bucket(bucket_name)
        # blob = bucket.blob(destination_blob_name)
        # blob.upload_from_filename(source_file)

        print("Source name = " + source_file)
        print("Destination name = " + destination_blob_name)
        print("File uploaded to {}.".format(destination_blob_name))


if __name__ == '__main__':
    cd = CDHelper()
    cd.get_examples_and_store()

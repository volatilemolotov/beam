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

import logging
import os
from typing import List

from api.v1.api_pb2 import Sdk, SDK_JAVA, SDK_GO, SDK_PYTHON, SDK_SCIO

SUPPORTED_SDK = {'java': SDK_JAVA}


class CIHelper:
    """ Helper for CI step.

    It is used to find and verify correctness if beam examples/katas/tests.
    """

    def __init__(self):
        self.examples_output = {}
        logging.info("Start validation examples")

    def verify(self):
        """ Verify correctness of beam examples.

        1. Find all beam examples starting from directory os.getenv("BEAM_ROOT_DIR").
        2. Group code of examples by their SDK.
        3. Run processing for all examples and keep output to self.examples_sources
        4. Keep all examples code and their output to self.examples_output {code : output}
        """
        root_dir = os.getenv("BEAM_ROOT_DIR")
        examples = self._find_examples(root_dir)
        code_by_sdk = self._group_by_sdk(examples)
        self._verify_all_examples(code_by_sdk)

    def get_run_outputs(self) -> {}:
        """ Returns beam examples and their output
        """
        return self.examples_output

    def _find_examples(self, work_dir: str) -> List[str]:
        """ Find and return filepath to beam examples/tests/katas.

        Search throws all child files of work_dir directory files with beam tag:
        /*
        Beam-playground:
            name: NameOfExample
            description: Description of NameOfExample.
            multifile: false
            categories:
                - category-1
                - category-2
        */

        Args:
            work_dir: directory where to search examples.

        Returns:
            List of paths to all tagged files.
        """
        examples = [""]
        return examples

    def _get_sdk(self, example) -> Sdk:
        """ Return SDK of example.

        Get extension of the example by his filepath and returns associated SDK.

        Args:
            example: filepath of the beam example.

        Returns:
            Sdk according to file extension.
        """
        extension = example.split(os.extsep)[-1]
        if SUPPORTED_SDK.get(extension) is not None:
            return SUPPORTED_SDK[extension]
        else:
            raise ValueError(extension + " is not supported now")

    def _group_by_sdk(self, examples: List[str]) -> {}:
        """ Group code of beam examples by their SDK.

        Args:
            examples: beam examples' filepath.

        Returns:
             Map of {sdk : [code of beam examples]}
        """
        examples_by_sdk = {}
        for example in examples:
            if example.split(os.sep)[-1] == "ci_helper.py":
                continue
            sdk = self._get_sdk(example)

            already_added_examples = examples_by_sdk.get(sdk, [])

            with open(example) as parsed_file:
                content = parsed_file.read()

            already_added_examples.append(content)
            examples_by_sdk[sdk] = already_added_examples
        return examples_by_sdk

    def _verify_all_examples(self, examples_by_sdk: {}):
        """ Verify beam examples using backend instance.

        Args:
            examples_by_sdk: map of {sdk : [code of beam examples]}
            self.example_output: map of {code of example : output}
        """
        for example_sdk, list_code in examples_by_sdk:
            for example_code in list_code:
                # TODO [BEAM-13256] Implement logic of calling backend to receive correct output using example_sdk and example_code
                output = ""
                self.examples_output[example_code] = output

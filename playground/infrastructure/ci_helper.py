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

from api.v1.api_pb2 import SDK_JAVA
from helper import find_examples, Example

SUPPORTED_SDK = {'java': SDK_JAVA}


class CIHelper:
    """ Helper for CI step.

    It is used to find and verify correctness if beam examples/katas/tests.
    """

    def __init__(self):
        logging.info("Start validation examples")

    def verify(self):
        """ Verify correctness of beam examples.

        1. Find all beam examples starting from directory os.getenv("BEAM_ROOT_DIR").
        2. Group code of examples by their SDK.
        3. Run processing for all examples to verify examples' code.
        """
        root_dir = os.getenv("BEAM_ROOT_DIR")
        examples = find_examples(root_dir)
        self._verify_all_examples(examples)

    def _verify_all_examples(self, examples: [Example]):
        """ Verify beam examples using backend instance.

        Call the backend to start code processing for the examples. Then check status of processing.
        If status is some error status, then log error case and raise error

        Args:
            examples: beam examples that should be verified
        """
        for example in examples:
            # TODO [BEAM-13256] Implement logic of calling backend to verify example's code
            continue

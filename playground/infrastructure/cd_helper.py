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

from ci_helper import CIHelper


class CDHelper:
    """ Helper for CD step.

    It is used to save beam examples/katas/tests and their output on the Google Cloud.
    """

    def __init__(self):
        self.ci_helper = CIHelper()

    def get_run_output(self):
        """ Returns beam examples and their output.
        """
        self.ci_helper.verify()
        self.ci_helper.get_run_outputs()

    def store_precompiled_objects(self):
        """ Save beam examples and their output in the Google Cloud.
        """
        pass

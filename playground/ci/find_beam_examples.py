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
import logging
from typing import List

EXTENSIONS = ["java", "go", "py", ".scala"]
PATTERN = re.compile('Beam-playground:\n {4}name: \w+\n {4}description: .+\n {4}multifile: (true|false)\n {4}categories:\n( {8}- [\w\-]+\n)+')


def find_examples(work_dir: str) -> List[str]:
    """Find examples files

    Find all files which contain the beam-playground tag.

    Args:
        work_dir: directory where to search examples.

    Returns:
        List of paths to all tagged files.
    """
    result = []
    for root, _, files in os.walk(work_dir):
        for filename in files:
            filepath = os.path.join(root, filename)
            if match_pattern(filepath):
                result.append(filepath)
    return result


def match_pattern(filepath: str) -> bool:
    """Check file to matching

    Check that file has the correct extension and contains the beam-playground tag.

    Args:
        filepath: path to the file.

    Returns:
        True if file matched. False if not
    """
    extension = filepath.split(os.extsep)[-1]
    if extension in EXTENSIONS:
        with open(filepath) as parsed_file:
            content = parsed_file.read()
        return re.search(PATTERN, content) is not None

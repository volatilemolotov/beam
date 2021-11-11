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
from playground.ci.find_beam_examples import get_examples
from playground.ci.verify_beam_example import verify_example


def main():
    example_map = []
    # find all examples and returns file path to each of them
    examples = get_examples()
    if examples is None:
        logging.error("error during get examples")
        # TODO add return from CI step with a fail
        return

    for example in examples:
        # get sdk based on filepath of example
        sdk = get_sdk(example)

        # read code from example's file
        with open(example) as parsed_file:
            content = parsed_file.read()

        # verify example using code and sdk
        output = verify_example(content, sdk)
        if output is None:
            logging.error("error during validate example: " + example)
            # TODO add return from CI step with a fail
            return
        example_map[content] = output


# TODO add returning of SDK form proto file instead of string
def get_sdk(example):
    """Return SDK of example

    Based on extension of example's file return correct SDK

    Args:
        example: path to the example's file.

    Returns:
        SDK of the example.
    """
    return "JAVA"


if __name__ == '__main__':
    main()

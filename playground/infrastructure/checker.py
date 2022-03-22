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

"""
Module implements check to define if it is needed to run CI step for Beam
Playground examples
"""
import argparse
import logging
import os

from config import Config
from helper import get_tag

root_dir = os.getenv("BEAM_ROOT_DIR")
from logger import setup_logger
parser = argparse.ArgumentParser(
    description="Check before CI step")
parser.add_argument(
    "--paths",
    dest="paths",
    type=lambda s: [item for item in s.split("\\n")],
    required=True,
    help="Paths to the files")


def _check_envs():
  if root_dir is None:
    raise KeyError(
        "BEAM_ROOT_DIR environment variable should be specified in os")


def check() -> bool:
  flags = parser.parse_args()
  _check_envs()
  setup_logger()
  logging.info("%s files", len(flags.paths))
  for filepath in flags.paths:
    extension = filepath.split(os.extsep)[-1]
    if extension not in Config.SDK_TO_EXTENSION.values():
      continue
    filepath = root_dir + "/" + filepath
    if get_tag(filepath) is not None:
      logging.info("%s contains a tag", filepath)
      return True
  return False

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

import uuid
from unittest.mock import AsyncMock
import pytest

from ci.api import api_pb2
from ci.grpc_client import GRPCClient


class TestGRPCClient:

    @pytest.fixture()
    def mock_run_code(self, mocker):
        async_mock = AsyncMock()
        mocker.patch('ci.grpc_client.GRPCClient.run_code', side_effect=async_mock)
        return async_mock

    @pytest.mark.asyncio
    async def test_run_code(self, mock_run_code):
        mock_run_code.return_value = str(uuid.uuid4())
        result = await GRPCClient().run_code("", api_pb2.SDK_GO)
        assert isinstance(result, str)

    @pytest.fixture()
    def mock_check_status(self, mocker):
        async_mock = AsyncMock()
        mocker.patch('ci.grpc_client.GRPCClient.check_status', side_effect=async_mock)
        return async_mock

    @pytest.mark.asyncio
    async def test_check_status(self, mock_check_status):
        mock_check_status.return_value = api_pb2.SDK_GO
        result = await GRPCClient().check_status(str(uuid.uuid4()))
        assert result == api_pb2.SDK_GO

    @pytest.fixture()
    def mock_get_run_error(self, mocker):
        async_mock = AsyncMock()
        mocker.patch('ci.grpc_client.GRPCClient.get_run_error', side_effect=async_mock)
        return async_mock

    async def test_get_run_error(self, mock_get_run_error):
        expected_error = "MOCK_ERROR"
        mock_get_run_error.return_value = expected_error
        result = await GRPCClient().get_run_error(str(uuid.uuid4()))
        assert result == expected_error

    @pytest.fixture()
    def mock_get_run_output(self, mocker):
        async_mock = AsyncMock()
        mocker.patch('ci.grpc_client.GRPCClient.get_run_output', side_effect=async_mock)
        return async_mock

    async def test_get_run_output(self, mock_get_run_output):
        expected_error = "MOCK_RUN_OUTPUT"
        mock_get_run_output.return_value = expected_error
        result = await GRPCClient().get_run_output(str(uuid.uuid4()))
        assert result == expected_error

    @pytest.fixture()
    def mock_get_compile_output(self, mocker):
        async_mock = AsyncMock()
        mocker.patch('ci.grpc_client.GRPCClient.get_compile_output', side_effect=async_mock)
        return async_mock

    async def test_get_compile_output(self, mock_get_compile_output):
        expected_error = "MOCK_compile_OUTPUT"
        mock_get_compile_output.return_value = expected_error
        result = await GRPCClient().get_compile_output(str(uuid.uuid4()))
        assert result == expected_error

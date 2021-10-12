/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import 'package:grpc/grpc_web.dart';
import 'package:playground/generated/playground.pbgrpc.dart';
import 'package:playground/modules/editor/repository/code_repository/run_code_request.dart';
import 'package:playground/modules/editor/repository/code_repository/run_code_result.dart';

const kPipelineCheckDelay = Duration(seconds: 1);

class CodeRepository {
  late final GrpcWebClientChannel _channel;
  late final PlaygroundServiceClient _client;

  CodeRepository() {
    _channel = GrpcWebClientChannel.xhr(
      Uri.parse('https://datatokenization.uc.r.appspot.com'),
    );
    _client = PlaygroundServiceClient(_channel);
  }

  Stream<RunCodeResult> runCode(RunCodeRequestWrapper request) async* {
    try {
      yield RunCodeResult(status: RunCodeStatus.running);
      var runCodeResponse = await _client.runCode(request.toGrpcRequest());
      final pipelineUuid = runCodeResponse.pipelineUuid;
      final resultStatus = await _waitPipelineExecution(pipelineUuid);
      final result = await _getPipelineResult(pipelineUuid, resultStatus);
      yield result;
    } on GrpcError catch (error) {
      yield RunCodeResult(
        status: RunCodeStatus.error,
        errorMessage: error.message,
      );
    }
  }

  Future<Status> _waitPipelineExecution(String pipelineUuid) async {
    final statusResponse = await _client.checkStatus(
      CheckStatusRequest(pipelineUuid: pipelineUuid),
    );
    final isFinished = statusResponse.status == Status.STATUS_ERROR ||
        statusResponse.status == Status.STATUS_FINISHED;
    if (isFinished) {
      return statusResponse.status;
    }

    return Future.delayed(
      kPipelineCheckDelay,
      () => _waitPipelineExecution(pipelineUuid),
    );
  }

  Future<RunCodeResult> _getPipelineResult(
    String pipelineUuid,
    Status resultStatus,
  ) async {
    final output = await _getPipelineOutput(pipelineUuid, resultStatus);
    final status = resultStatus == Status.STATUS_ERROR
        ? RunCodeStatus.error
        : RunCodeStatus.success;
    return RunCodeResult(status: status, output: output);
  }

  Future<String> _getPipelineOutput(String pipelineUuid, Status status) async {
    if (status == Status.STATUS_ERROR) {
      try {
        final compileOutput = await _client.getCompileOutput(
          GetCompileOutputRequest(pipelineUuid: pipelineUuid),
        );
        if (compileOutput.output.isNotEmpty) {
          return compileOutput.output;
        }
      } on Exception {}
    }
    final runOutput = await _client.getRunOutput(
      GetRunOutputRequest(pipelineUuid: pipelineUuid),
    );
    return runOutput.output;
  }
}

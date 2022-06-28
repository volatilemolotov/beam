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

import 'dart:convert';

import 'package:onmessage/onmessage.dart';
import 'package:playground/modules/sdk/models/sdk.dart';

class SetContentMessage {
  final SDK? sdk;
  final String? code;

  SetContentMessage({
    this.sdk,
    this.code,
  });

  static SetContentMessage? tryParseMessageEvent(MessageEvent event) {
    final data = event.data;
    return SetContentMessage.tryParseMap(data) ??
        SetContentMessage.tryParseJson(data);
  }

  static SetContentMessage? tryParseMap(Object? map) {
    return map is Map ? SetContentMessage.fromMap(map) : null;
  }

  SetContentMessage.fromMap(Map map)
      : sdk = _parseSdk(map),
        code = _tryParseCode(map);

  static SetContentMessage? tryParseJson(Object? json) {
    if (json is String) {
      try {
        final map = jsonDecode(json);

        if (map is Map) {
          return SetContentMessage.fromMap(map);
        }
      } on FormatException catch (ex) {
        // TODO: Log
      }
    }

    return null;
  }

  static SDK? _parseSdk(Map map) {
    final sdkString = map['sdk'];
    return sdkString == null ? null : SDK.values.byName(sdkString);
  }

  static String? _tryParseCode(Map map) {
    final code = map['code'];
    return code?.toString();
  }

  @override
  int get hashCode {
    return code.hashCode;
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) {
      return true;
    }

    return other is SetContentMessage && code == other.code;
  }
}

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

import 'package:playground/modules/messages/models/abstract_message.dart';
import 'package:playground/modules/sdk/models/sdk.dart';

class SetContentMessage extends AbstractMessage {
  final SDK? sdk;
  final String? content;

  static const type = 'SetContentMessage';

  const SetContentMessage({
    this.sdk,
    this.content,
  });

  static SetContentMessage? fromMap(Map eventData) {
    if (eventData['type'] != type) {
      return null;
    }

    return fromMapNoCheck(eventData);
  }

  /// Identical to [fromMap], but does not check `type` field in the map.
  /// Use this when messages are known to be of this class and so miss `type`.
  static SetContentMessage fromMapNoCheck(Map eventData) {
    return SetContentMessage(
      sdk: _tryParseSdk(eventData),
      content: _tryParseContent(eventData),
    );
  }

  static SDK? _tryParseSdk(Map map) {
    return SDK.tryParse(map['sdk']);
  }

  static String? _tryParseContent(Map map) {
    final code = map['content'];
    return code?.toString();
  }

  @override
  int get hashCode {
    return content.hashCode;
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) {
      return true;
    }

    return other is SetContentMessage &&
        sdk == other.sdk &&
        content == other.content;
  }
}

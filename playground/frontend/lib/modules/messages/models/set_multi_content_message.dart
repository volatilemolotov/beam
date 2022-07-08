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

import 'package:collection/collection.dart';
import 'package:playground/modules/messages/models/abstract_message.dart';

import 'set_content_message.dart';

class SetMultiContentMessage extends AbstractMessage {
  final List<SetContentMessage> content;

  static const type = 'SetMultiContentMessage';

  const SetMultiContentMessage({
    required this.content,
  });

  static SetMultiContentMessage? fromMap(Map map) {
    if (map['type'] != type) {
      return null;
    }

    return SetMultiContentMessage(
      content: _tryParseContent(map['content']),
    );
  }

  static List<SetContentMessage> _tryParseContent(Object? list) {
    if (list is! List) {
      return [];
    }

    return list
        .map((e) => e is Map ? SetContentMessage.fromMapNoCheck(e) : null)
        .whereNotNull()
        .toList(growable: false);
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

    return other is SetMultiContentMessage &&
        const ListEquality().equals(content, other.content);
  }
}

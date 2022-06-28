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

import 'package:flutter_test/flutter_test.dart';
import 'package:onmessage/onmessage.dart';
import 'package:playground/modules/messages/models/set_content_message.dart';

const _code = 'my_code';

void main() {
  group('SetContentMessage parsing null and empty', () {
    test(
      'SetContentMessage.tryParseMessageEvent returns null for null',
      () {
        final event = _getMessageEventWithData(null);

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, null);
      },
    );

    test(
      'SetContentMessage.tryParseMessageEvent returns null for non-sting and non-map',
      () {
        final event = _getMessageEventWithData(DateTime(2022));

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, null);
      },
    );

    test(
      'SetContentMessage.tryParseMessageEvent returns null for non-JSON sting',
      () {
        final event = _getMessageEventWithData('non-JSON string');

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, null);
      },
    );

    test(
      'SetContentMessage.tryParseMessageEvent returns null for JSON scalar',
      () {
        final event = _getMessageEventWithData('123');

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, null);
      },
    );

    test(
      'SetContentMessage.tryParseMessageEvent returns empty message for alien JSON map',
      () {
        final event = _getMessageEventWithData('{"unknownName": "value"}');

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, SetContentMessage());
      },
    );
  });

  group('SetContentMessage.tryParseMessageEvent parses code', () {
    test(
      'SetContentMessage.tryParseMessageEvent parses numeric code',
      () {
        final event = _getMessageEventWithData('{"code": 123}');

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, SetContentMessage(code: '123'));
      },
    );

    test(
      'SetContentMessage.tryParseMessageEvent parses string code',
      () {
        final event = _getMessageEventWithData('{"code": "$_code"}');

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, SetContentMessage(code: _code));
      },
    );

    test(
      'SetContentMessage.tryParseMessageEvent takes code from map',
      () {
        final event = _getMessageEventWithData({'code': _code});

        final parsed = SetContentMessage.tryParseMessageEvent(event);

        expect(parsed, SetContentMessage(code: _code));
      },
    );
  });
}

MessageEvent _getMessageEventWithData(dynamic data) {
  return MessageEvent(
    bubbles: true,
    cancellable: true,
    data: data,
    origin: 'origin',
    lastEventId: 'lastEventId',
    source: null,
    ports: [],
  );
}

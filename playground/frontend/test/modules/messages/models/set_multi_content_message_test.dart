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
import 'package:playground/modules/messages/models/set_content_message.dart';
import 'package:playground/modules/messages/models/set_multi_content_message.dart';
import 'package:playground/modules/sdk/models/sdk.dart';

const _content = 'my_code';
const _sdk = SDK.python;

void main() {
  group('SetMultiContentMessage.fromMap', () {
    test(
      'SetMultiContentMessage.fromMap returns null for other types',
      () {
        const map = {'type': 'any-other'};

        final parsed = SetMultiContentMessage.fromMap(map);

        expect(parsed, null);
      },
    );

    test(
      'SetMultiContentMessage.fromMap parses empty message',
      () {
        const map = {
          'type': SetMultiContentMessage.type,
        };

        final parsed = SetMultiContentMessage.fromMap(map);

        expect(parsed, const SetMultiContentMessage(content: []));
      },
    );

    test(
      'SetMultiContentMessage.fromMap parses messages',
      () {
        final map = {
          'type': SetMultiContentMessage.type,
          'content': [
            null,
            1,
            1.0,
            'string',
            [],
            {'type': 'any-other'},
            {
              'type': SetContentMessage.type,
              'sdk': _sdk.name,
              'content': _content,
            },
          ],
        };

        final parsed = SetMultiContentMessage.fromMap(map);

        expect(
          parsed,
          const SetMultiContentMessage(
            content: [
              SetContentMessage(),
              SetContentMessage(sdk: _sdk, content: _content),
            ],
          ),
        );
      },
    );
  });
}

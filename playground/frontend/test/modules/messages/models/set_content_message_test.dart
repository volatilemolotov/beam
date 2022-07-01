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
import 'package:playground/modules/sdk/models/sdk.dart';

const _content = 'my_code';
const _sdk = SDK.python;

void main() {
  group('SetContentMessage.fromMap', () {
    test(
      'SetContentMessage.fromMap returns null for other types',
      () {
        const map = {'type': 'any-other'};

        final parsed = SetContentMessage.fromMap(map);

        expect(parsed, null);
      },
    );

    test(
      'SetContentMessage.fromMap parses empty message',
      () {
        const map = {'type': SetContentMessage.type};

        final parsed = SetContentMessage.fromMap(map);

        expect(parsed, const SetContentMessage());
      },
    );

    test(
      'SetContentMessage.fromMap parses SDK',
      () {
        final map = {'type': SetContentMessage.type, 'sdk': _sdk.name};

        final parsed = SetContentMessage.fromMap(map);

        expect(parsed, const SetContentMessage(sdk: _sdk));
      },
    );

    test(
      'SetContentMessage.fromMap parses empty for unknown SDK',
      () {
        const map = {'type': SetContentMessage.type, 'sdk': 'not-existing'};

        final parsed = SetContentMessage.fromMap(map);

        expect(parsed, const SetContentMessage());
      },
    );

    test(
      'SetContentMessage.fromMap parses content',
      () {
        const map = {'type': SetContentMessage.type, 'content': _content};

        final parsed = SetContentMessage.fromMap(map);

        expect(parsed, const SetContentMessage(content: _content));
      },
    );
  });
}

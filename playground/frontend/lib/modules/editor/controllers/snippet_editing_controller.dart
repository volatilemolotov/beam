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

import 'package:code_text_field/code_text_field.dart';
import 'package:flutter/widgets.dart';
import 'package:playground/modules/examples/models/example_model.dart';
import 'package:playground/modules/sdk/models/sdk.dart';

class SnippetEditingController extends ChangeNotifier {
  // TODO: Add pipeline options
  final SDK sdk;
  final CodeController codeController;
  ExampleModel? _selectedExample;

  SnippetEditingController({
    required this.sdk,
    ExampleModel? selectedExample,
  })  : codeController = CodeController(
          language: sdk.highlight,
          webSpaceFix: false,
        ),
        _selectedExample = selectedExample;

  set selectedExample(ExampleModel? value) {
    _selectedExample = value;
    codeController.text = _selectedExample?.source ?? '';
    notifyListeners();
  }

  ExampleModel? get selectedExample => _selectedExample;

  void reset() {
    codeController.text = _selectedExample?.source ?? '';
  }
}

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

import 'package:flutter/material.dart';
import 'package:playground/components/dropdown_button/dropdown_button.dart';
import 'package:playground/modules/examples/example_selector_body.dart';
import 'package:playground/pages/playground/states/examples_state.dart';
import 'package:playground/pages/playground/states/playground_state.dart';
import 'package:provider/provider.dart';

const double kLgContainerHeight = 490.0;
const double kLgContainerWidth = 400.0;

class ExampleSelector extends StatelessWidget {
  const ExampleSelector({super.key});

  @override
  Widget build(BuildContext context) {
    return Consumer2<PlaygroundState, ExampleState>(
      builder: (context, playgroundState, exampleState, child) =>
          AppDropdownButton(
        buttonText: Text(playgroundState.examplesTitle),
        height: kLgContainerHeight,
        width: kLgContainerWidth,
        createDropdown: (close) => ExampleSelectorBody(
          playgroundState: playgroundState,
          exampleState: exampleState,
          close: close,
        ),
      ),
    );
  }
}

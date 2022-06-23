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

import 'package:flutter/widgets.dart';
import 'package:playground/config/theme.dart';
import 'package:playground/modules/editor/components/editor_themes.dart';
import 'package:provider/provider.dart';

import '../../../pages/playground/states/playground_state.dart';

class ThemeListenerWidget extends StatelessWidget {
  final Widget child;

  const ThemeListenerWidget({
    required this.child,
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Consumer<ThemeProvider>(
      builder: (context, theme, child) {
        final playgroundState = Provider.of<PlaygroundState>(context);
        playgroundState.codeController.theme =
            theme.isDarkMode ? kDarkCodeTheme : kLightCodeTheme;

        return this.child;
      },
    );
  }
}

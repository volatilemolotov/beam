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
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:playground/components/loading_indicator/loading_indicator.dart';
import 'package:playground/config/theme.dart';
import 'package:playground/constants/links.dart';
import 'package:playground/constants/sizes.dart';
import 'package:playground/modules/examples/models/popover_state.dart';
import 'package:playground/pages/playground/states/example_selector_state.dart';
import 'package:playground/pages/playground/states/examples_state.dart';
import 'package:playground/pages/playground/states/playground_state.dart';
import 'package:provider/provider.dart';
import 'package:url_launcher/url_launcher.dart';

import 'components/examples_components.dart';

class ExampleSelectorBody extends StatefulWidget {
  final PlaygroundState playgroundState;
  final ExampleState exampleState;
  final VoidCallback close;

  const ExampleSelectorBody({
    super.key,
    required this.playgroundState,
    required this.exampleState,
    required this.close,
  });

  @override
  State<ExampleSelectorBody> createState() => _ExampleSelectorBodyState();
}

class _ExampleSelectorBodyState extends State<ExampleSelectorBody> {
  final TextEditingController textController = TextEditingController();
  final ScrollController scrollController = ScrollController();

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<PopoverState>(
      create: (context) => PopoverState(false),
      builder: (context, state) => ChangeNotifierProvider(
        create: (context) => ExampleSelectorState(
          widget.exampleState,
          widget.playgroundState,
          widget.exampleState.getCategories(widget.playgroundState.sdk)!,
        ),
        builder: (context, _) => widget.exampleState.sdkCategories == null ||
                widget.playgroundState.selectedExample == null
            ? const LoadingIndicator(size: kContainerHeight)
            : Column(
                children: [
                  SearchField(controller: textController),
                  const TypeFilter(),
                  ExampleList(
                    controller: scrollController,
                    selectedExample: widget.playgroundState.selectedExample!,
                    close: widget.close,
                  ),
                  Divider(
                    height: kDividerHeight,
                    color: ThemeColors.of(context).greyColor,
                    indent: kLgSpacing,
                    endIndent: kLgSpacing,
                  ),
                  SizedBox(
                    width: double.infinity,
                    child: TextButton(
                      child: Padding(
                        padding: const EdgeInsets.all(kXlSpacing),
                        child: Align(
                          alignment: Alignment.centerLeft,
                          child: Text(
                            AppLocalizations.of(context)!.addExample,
                            style: TextStyle(
                              color: ThemeColors.of(context).primary,
                            ),
                          ),
                        ),
                      ),
                      onPressed: () => launchUrl(Uri.parse(kAddExampleLink)),
                    ),
                  )
                ],
              ),
      ),
    );
  }
}

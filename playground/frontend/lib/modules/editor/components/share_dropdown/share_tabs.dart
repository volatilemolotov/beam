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
import 'package:playground/config/theme.dart';
import 'package:playground/constants/params.dart';
import 'package:playground/modules/editor/components/share_dropdown/share_tab_body.dart';
import 'package:playground/modules/examples/repositories/models/shared_file_model.dart';
import 'package:playground/pages/playground/states/examples_state.dart';
import 'package:playground/pages/playground/states/playground_state.dart';
import 'package:provider/provider.dart';

const kLoadingIndicatorSize = 50.0;

class ShareTabs extends StatelessWidget {
  final TabController tabController;

  const ShareTabs({super.key, required this.tabController});

  @override
  Widget build(BuildContext context) {
    AppLocalizations appLocale = AppLocalizations.of(context)!;

    return Container(
      color: Theme.of(context).backgroundColor,
      child: Consumer2<PlaygroundState, ExampleState>(
        builder: (context, playgroundState, exampleState, _) {
          if (playgroundState.isExampleChanged) {
            return FutureBuilder(
              future: exampleState.getSnippetId(
                [SharedFile(playgroundState.source, true, '')],
                playgroundState.sdk,
                playgroundState.pipelineOptions,
              ),
              builder: (context, snapshot) {
                if (!snapshot.hasData) {
                  return Center(
                    heightFactor: 1,
                    child: SizedBox(
                      height: kLoadingIndicatorSize,
                      width: kLoadingIndicatorSize,
                      child: CircularProgressIndicator(
                        color: ThemeColors.of(context).primary,
                      ),
                    ),
                  );
                } else {
                  return TabBarView(
                    controller: tabController,
                    physics: const NeverScrollableScrollPhysics(),
                    children: [
                      ShareTabBody(
                        descriptionText: appLocale.linkReady,
                        isCopyLinkTab: true,
                        snippetIdParam:
                            '$kSnippetId=${snapshot.data.toString()}',
                      ),
                      ShareTabBody(
                        descriptionText: appLocale.iframeCodeReady,
                        isCopyLinkTab: false,
                        snippetIdParam:
                            '$kSnippetId=${snapshot.data.toString()}',
                      ),
                    ],
                  );
                }
              },
            );
          } else {
            return TabBarView(
              controller: tabController,
              physics: const NeverScrollableScrollPhysics(),
              children: [
                ShareTabBody(
                  descriptionText: appLocale.linkReady,
                  isCopyLinkTab: true,
                  snippetIdParam:
                      '$kExampleParam=${playgroundState.selectedExample!.path}',
                ),
                ShareTabBody(
                  descriptionText: appLocale.iframeCodeReady,
                  isCopyLinkTab: false,
                  snippetIdParam:
                      '$kExampleParam=${playgroundState.selectedExample!.path}',
                ),
              ],
            );
          }
        },
      ),
    );
  }
}

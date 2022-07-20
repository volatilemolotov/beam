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
import 'package:playground/constants/sizes.dart';
import 'package:playground/pages/playground/states/playground_state.dart';
import 'package:provider/provider.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

const kTabBarWidth = 180.0;

class ShareTabsHeaders extends StatelessWidget {
  final TabController tabController;

  const ShareTabsHeaders({
    super.key,
    required this.tabController,
  });

  @override
  Widget build(BuildContext context) {
    AppLocalizations appLocale = AppLocalizations.of(context)!;

    return Consumer<PlaygroundState>(builder: (context, state, child) {
      return SizedBox(
        width: kTabBarWidth,
        child: TabBar(
          controller: tabController,
          tabs: <Widget>[
            Padding(
              padding: const EdgeInsets.only(bottom: kMdSpacing),
              child: Wrap(
                direction: Axis.horizontal,
                alignment: WrapAlignment.center,
                spacing: kMdSpacing,
                children: [Text(appLocale.link)],
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(bottom: kMdSpacing),
              child: Wrap(
                direction: Axis.horizontal,
                alignment: WrapAlignment.center,
                spacing: kMdSpacing,
                children: [Text(appLocale.embed)],
              ),
            ),
          ],
        ),
      );
    });
  }
}

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

import 'package:easy_localization/easy_localization.dart';
import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

import '../config/theme/colors_provider.dart';
import '../constants/links.dart';
import '../constants/sizes.dart';

class Footer extends StatelessWidget {
  const Footer();

  @override
  Widget build(BuildContext context) {
    final linkButtonStyle = TextButton.styleFrom(
      textStyle: const TextStyle(
        fontWeight: FontWeight.normal,
      ),
    );

    return Container(
      decoration: BoxDecoration(
        color: ThemeColors.of(context).secondaryBackground,
        border: Border(
          top: BorderSide(color: ThemeColors.of(context).divider),
        ),
      ),
      width: double.infinity,
      child: Padding(
        padding: const EdgeInsets.symmetric(
          vertical: ProjectSizes.size4,
          horizontal: ProjectSizes.size16,
        ),
        child: Wrap(
          spacing: ProjectSizes.size16,
          crossAxisAlignment: WrapCrossAlignment.center,
          children: [
            TextButton(
              style: linkButtonStyle,
              onPressed: () {
                launchUrl(Uri.parse(ProjectLinks.reportIssue));
              },
              child: const Text('ui.reportIssue').tr(),
            ),
            TextButton(
              style: linkButtonStyle,
              onPressed: () {
                launchUrl(Uri.parse(ProjectLinks.privacyPolicy));
              },
              child: const Text('ui.privacyPolicy').tr(),
            ),
            const Text('ui.copyright').tr(),
          ],
        ),
      ),
    );
  }
}

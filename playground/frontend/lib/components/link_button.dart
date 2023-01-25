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
import 'package:flutter_svg/svg.dart';
import 'package:playground/src/assets/assets.gen.dart';
import 'package:playground_components/playground_components.dart';
import 'package:url_launcher/url_launcher.dart';

const datasetsFolderPath =
    'https://github.com/apache/beam/blob/master/playground/backend/datasets/';

class LinkButton extends StatelessWidget {
  final String iconPath;
  final String text;
  final Iterable<String> urls;
  final Color? Function(BuildContext context)? iconColorBuilder;

  const LinkButton._({
    required this.iconPath,
    required this.text,
    required this.urls,
    this.iconColorBuilder,
  });

  factory LinkButton.colab(String url) {
    return LinkButton._(
      iconPath: Assets.colab,
      text: 'intents.playground.openGoogleColab'.tr(),
      urls: [url],
    );
  }

  factory LinkButton.github(String url) {
    return LinkButton._(
      iconPath: Assets.github,
      text: 'intents.playground.viewOnGithub'.tr(),
      urls: [url],
    );
  }

  factory LinkButton.dataset(List<Dataset> datasets) {
    return LinkButton._(
      iconColorBuilder: (context) =>
          Theme.of(context).extension<BeamThemeExtension>()?.iconColor,
      iconPath: Assets.streaming,
      text: 'intents.playground.showDatasets'.tr(),
      urls: datasets.map((d) => '$datasetsFolderPath${d.datasetPath}'),
    );
  }

  @override
  Widget build(BuildContext context) {
    return TextButton.icon(
      icon: SvgPicture.asset(
        iconPath,
        color: iconColorBuilder != null ? iconColorBuilder!(context) : null,
      ),
      onPressed: () {
        for (final url in urls) {
          launchUrl(Uri.parse(url));
        }
      },
      label: Text(text),
    );
  }
}

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
import 'package:url_launcher/url_launcher.dart';

class LinkButton extends StatelessWidget {
  final String iconPath;
  final String text;
  final String url;

  const LinkButton({
    required this.iconPath,
    required this.text,
    required this.url,
  });

  factory LinkButton.colab(String url) {
    return LinkButton(
      iconPath: Assets.colab,
      text: 'intents.playground.openGoogleColab'.tr(),
      url: url,
    );
  }

  factory LinkButton.github(String url) {
    return LinkButton(
      iconPath: Assets.github,
      text: 'intents.playground.viewOnGithub'.tr(),
      url: url,
    );
  }

  @override
  Widget build(BuildContext context) {
    return TextButton.icon(
      icon: SvgPicture.asset(iconPath),
      onPressed: () {
        launchUrl(Uri.parse(url));
      },
      label: Text(text),
    );
  }
}

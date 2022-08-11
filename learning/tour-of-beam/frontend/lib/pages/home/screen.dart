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
import 'package:flutter_svg/svg.dart';

import '../../components/page_container.dart';
import '../../constants/assets.dart';
import '../../constants/colors.dart';
import '../../constants/sizes.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen();

  @override
  Widget build(BuildContext context) {
    return PageContainer(
      content: SingleChildScrollView(
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: const [
            Expanded(child: _SdkSelection()),
            Expanded(child: _TourSummary()),
          ],
        ),
      ),
    );
  }
}

class _SdkSelection extends StatelessWidget {
  const _SdkSelection();

  @override
  Widget build(BuildContext context) {
    return DecoratedBox(
      decoration: BoxDecoration(
        color: Theme.of(context).brightness == Brightness.dark
            ? ProjectDarkThemeColors.primaryBackground
            : ProjectLightThemeColors.primaryBackground,
        border: const Border(
          right: BorderSide(
            color: ProjectColors.greyCBCBCB,
          ),
        ),
      ),
      child: Column(
        children: [
          Padding(
            padding: const EdgeInsets.fromLTRB(50, 60, 50, 20),
            child: Column(
              children: const [
                _IntroText(),
                SizedBox(height: ProjectSpacing.size32),
                _SdkButtons(),
              ],
            ),
          ),
          Image.asset(ProjectAssets.welcomeLaptop),
        ],
      ),
    );
  }
}

class _IntroText extends StatelessWidget {
  const _IntroText();

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          'Welcome to the Tour of Beam!',
          style: Theme.of(context).textTheme.displayMedium,
        ),
        Container(
          margin: const EdgeInsets.symmetric(vertical: 32),
          height: 2,
          color: ProjectColors.greyA0A4AB,
          constraints: const BoxConstraints(maxWidth: 150),
        ),
        Text(
          'Your journey is broken down into learning modules. If you would like to save your progress and track completed modules, please sign in. \n\nPlease select the default language (you may change the language at any time):',
          style: Theme.of(context).textTheme.bodyLarge,
        ),
      ],
    );
  }
}

class _SdkButtons extends StatelessWidget {
  const _SdkButtons();

  @override
  Widget build(BuildContext context) {
    const String sdk = 'Java';

    // TODO(nausharipov): make it responsive
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: ['Java', 'Python', 'Go']
              .map(
                (e) => Padding(
                  padding: const EdgeInsets.only(right: 15),
                  child: OutlinedButton(
                    style: OutlinedButton.styleFrom(
                      side: sdk == e
                          ? null
                          : const BorderSide(
                              color: ProjectColors.greyDFE1E3,
                            ),
                    ),
                    onPressed: () {
                      // TODO(nausharipov): select the language
                    },
                    child: Text(e),
                  ),
                ),
              )
              .toList(),
        ),
        ElevatedButton(
          onPressed: () {
            // TODO(nausharipov): redirect
          },
          child: const Text('Start your tour'),
        ),
      ],
    );
  }
}

class _TourSummary extends StatelessWidget {
  const _TourSummary();

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(
        vertical: ProjectSpacing.size20,
        horizontal: 27,
      ),
      child: Column(
        children: ['Core Transforms', 'Common Transforms']
            .map(
              (e) => _Module(title: e),
            )
            .toList(),
      ),
    );
  }
}

class _Module extends StatelessWidget {
  final String title;
  const _Module({required this.title});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        _ModuleHeader(title: title),
        const _ModuleBody(),
      ],
    );
  }
}

class _ModuleHeader extends StatelessWidget {
  final String title;
  const _ModuleHeader({required this.title});

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: [
            Padding(
              padding: const EdgeInsets.all(ProjectSpacing.size4),
              child: SvgPicture.asset(
                ProjectAssets.welcomeProgress0,
                color: Theme.of(context).brightness == Brightness.dark
                    ? ProjectColors.greyDFE1E3
                    : null,
              ),
            ),
            const SizedBox(width: ProjectSpacing.size16),
            Text(
              title,
              style: Theme.of(context).textTheme.titleLarge,
            ),
          ],
        ),
        const Text('Medium level'),
      ],
    );
  }
}

class _ModuleBody extends StatelessWidget {
  const _ModuleBody();

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(left: 21),
      decoration: const BoxDecoration(
        border: Border(
          left: BorderSide(
            color: ProjectColors.greyCBCBCB,
          ),
        ),
      ),
      padding: const EdgeInsets.only(left: 39, top: 10),
      child: Column(
        children: const [
          Text(
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam velit purus, tincidunt id velit vitae, mattis dictum velit. Nunc sit amet nunc at turpis eleifend commodo ac ut libero. Aenean rutrum rutrum nulla ut efficitur. Vestibulum pulvinar eros dictum lectus volutpat dignissim vitae quis nisi. Maecenas sem erat, elementum in euismod ut, interdum ac massa.',
          ),
          SizedBox(height: ProjectSpacing.size16),
          Divider(
            color: ProjectColors.greyCBCBCB,
          ),
        ],
      ),
    );
  }
}

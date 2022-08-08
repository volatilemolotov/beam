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

class HomeScreen extends StatelessWidget {
  const HomeScreen();

  @override
  Widget build(BuildContext context) {
    return PageContainer(
      content: SingleChildScrollView(
        child: Row(
          children: const [
            Expanded(
              child: _SdkSelection(),
            ),
            Expanded(
              child: _TourSummary(),
            ),
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
    return Column(
      children: [
        const Text('Welcome to the Tour of Beam!'),
        const Text(
          'Your journey is broken down into learning modules. If you would like to save your progress and track completed modules, please sign in. \n\nPlease select the default language (you may change the language at any time):',
        ),
        const _SdkButtons(),
        Image.asset(kWelcomeLaptopAsset),
      ],
    );
  }
}

class _SdkButtons extends StatelessWidget {
  const _SdkButtons();

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: ['Java', 'Python', 'Go']
              .map(
                (e) => OutlinedButton(
                  onPressed: () {},
                  child: Text(e),
                ),
              )
              .toList(),
        ),
        ElevatedButton(
          onPressed: () {},
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
    return Column(
      children: ['Core Transforms']
          .map(
            (e) => const _Module(),
          )
          .toList(),
    );
  }
}

class _Module extends StatelessWidget {
  const _Module();

  @override
  Widget build(BuildContext context) {
    return Column(
      children: const [
        _ModuleHeader(),
        _ModuleBody(),
      ],
    );
  }
}

class _ModuleHeader extends StatelessWidget {
  const _ModuleHeader();

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        SvgPicture.asset(kWelcomeProgress0Asset),
        const Text('Core Transforms'),
      ],
    );
  }
}

class _ModuleBody extends StatelessWidget {
  const _ModuleBody();

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(left: 17),
      decoration: const BoxDecoration(
        border: Border(
          left: BorderSide(),
        ),
      ),
      child: Column(
        children: const [
          Text(
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam velit purus, tincidunt id velit vitae, mattis dictum velit. Nunc sit amet nunc at turpis eleifend commodo ac ut libero. Aenean rutrum rutrum nulla ut efficitur. Vestibulum pulvinar eros dictum lectus volutpat dignissim vitae quis nisi. Maecenas sem erat, elementum in euismod ut, interdum ac massa.',
          ),
          Divider(),
        ],
      ),
    );
  }
}

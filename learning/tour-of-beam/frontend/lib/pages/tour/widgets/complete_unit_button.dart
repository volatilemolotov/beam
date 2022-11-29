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
import 'package:get_it/get_it.dart';
import 'package:playground_components/playground_components.dart';

import '../../../cache/user_progress.dart';
import '../state.dart';

class CompleteUnitButton extends StatelessWidget {
  final TourNotifier tourNotifier;
  const CompleteUnitButton(this.tourNotifier);

  @override
  Widget build(BuildContext context) {
    final themeData = Theme.of(context);
    final userProgressCache = GetIt.instance.get<UserProgressCache>();

    return AnimatedBuilder(
      animation: userProgressCache,
      builder: (context, child) {
        final canComplete =
            userProgressCache.canCompleteUnit(tourNotifier.currentUnitId);
        final borderColor =
            canComplete ? themeData.primaryColor : themeData.disabledColor;
        final onPressed = canComplete
            ? tourNotifier.currentUnitController?.completeUnit
            : null;

        return Flexible(
          child: OutlinedButton(
            style: OutlinedButton.styleFrom(
              foregroundColor: themeData.primaryColor,
              side: BorderSide(color: borderColor),
              shape: const RoundedRectangleBorder(
                borderRadius: BorderRadius.all(
                  Radius.circular(BeamSizes.size4),
                ),
              ),
            ),
            onPressed: onPressed,
            child: const Text(
              'pages.tour.completeUnit',
              overflow: TextOverflow.visible,
            ).tr(),
          ),
        );
      },
    );
  }
}

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
import 'package:flutter/services.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:playground/modules/analytics/analytics_event.dart';
import 'package:playground/modules/analytics/analytics_events.dart';
import 'package:playground/modules/analytics/analytics_service.dart';
import 'package:playground/modules/output/models/output_placement.dart';
import 'package:playground_components/playground_components.dart';
import 'package:playground_components_dev/playground_components_dev.dart';

import 'common/common.dart';
import 'common/common_finders.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();
  testWidgets(
    'Check UI, not connected with running examples',
    (WidgetTester wt) async {
      await init(wt);

      await _checkEnjoyPlayground(wt);
      await _checkDescription(wt);
      await _checkOutputPlacement(wt);
      await _checkResizeOutput(wt);
      await _checkShortcutsModal(wt);
      await _checkToggleBrightnessMode(wt);
    },
  );
}

Future<void> _checkEnjoyPlayground(WidgetTester wt) async {
  expect(find.feedbackDropdownContent(), findsNothing);

  // enjoying and send feedback
  await wt.tap(find.feedbackThumbUp());
  await wt.pumpAndSettle();

  expect(find.feedbackDropdownContent(), findsOneWidget);

  const text = 'This is a test';
  await wt.enterText(find.feedbackDropdownTextField(), text);
  await wt.pumpAndSettle();

  expect(find.text(text), findsOneWidget);

  await wt.tap(find.feedbackDropdownSendButton());
  await wt.pumpAndSettle();

  final context = wt.element(find.feedbackThumbUp());
  final lastSentEvent = AnalyticsService.get(context).lastSentEvent;
  expect(
    lastSentEvent,
    AnalyticsEvent(
      category: kFeedbackCategory,
      action: kClickSendFeedbackEvent,
      label: text,
    ),
  );

  expect(find.feedbackDropdownContent(), findsNothing);

  // not enjoying and close
  await wt.tap(find.feedbackThumbDown());
  await wt.pumpAndSettle();

  expect(find.feedbackDropdownContent(), findsOneWidget);

  await wt.tap(find.feedbackDropdownCancelButton());
  await wt.pumpAndSettle();

  expect(find.feedbackDropdownContent(), findsNothing);
}

Future<void> _checkDescription(WidgetTester wt) async {
  expect(find.descriptionPopoverButton(), findsOneWidget);

  await wt.tap(find.descriptionPopoverButton());
  await wt.pumpAndSettle();

  expect(find.descriptionPopover(), findsOneWidget);

  final example = wt.findPlaygroundController().selectedExample!;

  expectContains(find.descriptionPopover(), find.text(example.name));
  expectContains(find.descriptionPopover(), find.text(example.description));

  await wt.tap(find.descriptionPopoverButton());
  await wt.pumpAndSettle();

  expect(find.descriptionPopover(), findsNothing);
}

Future<void> _checkOutputPlacement(WidgetTester wt) async {
  Offset getCodeAreaCenter() => wt.getCenter(find.codeTextAreaWrapper());
  Offset getOutputCenter() => wt.getCenter(find.outputWidget());

  expect(find.splitView(), findsOneWidget);

  await wt.tap(find.byKey(const ValueKey(OutputPlacement.left)));
  await wt.pumpAndSettle();
  expect(getCodeAreaCenter().dx > getOutputCenter().dx, true);

  await wt.tap(find.byKey(const ValueKey(OutputPlacement.right)));
  await wt.pumpAndSettle();
  expect(getCodeAreaCenter().dx < getOutputCenter().dx, true);

  await wt.tap(find.byKey(const ValueKey(OutputPlacement.bottom)));
  await wt.pumpAndSettle();
  expect(getCodeAreaCenter().dy < getOutputCenter().dy, true);
}

Future<void> _checkResizeOutput(WidgetTester wt) async {
  final dragHandleStartPosition = wt.getCenter(find.dragHandle());
  Future<void> returnDragHandleToStartPosition() async {
    final currentPosition = wt.getCenter(find.dragHandle());
    final offset = dragHandleStartPosition - currentPosition;
    await wt.drag(find.dragHandle(), offset);
    await wt.pumpAndSettle();
  }

  await _checkDragVertically(wt);
  await returnDragHandleToStartPosition();

  await _checkExcessivelyDragVertically(wt);
  await returnDragHandleToStartPosition();

  await wt.tap(find.byKey(const ValueKey(OutputPlacement.left)));
  await wt.pumpAndSettle();

  await _checkDragHorizontally(wt);
  await returnDragHandleToStartPosition();

  await _checkExcessivelyDragHorizontally(wt);
  await returnDragHandleToStartPosition();
}

Future<void> _checkShortcutsModal(WidgetTester wt) async {
  expect(find.shortcutsModal(), findsNothing);

  expect(find.moreActions(), findsOneWidget);

  AppLocalizations appLocale =
      AppLocalizations.of(wt.element(find.moreActions()))!;

  await wt.tap(find.moreActions());
  await wt.pumpAndSettle();

  expect(find.text(appLocale.shortcuts), findsOneWidget);

  await wt.tap(find.text(appLocale.shortcuts));
  await wt.pumpAndSettle();

  expect(find.shortcutsModal(), findsOneWidget);

  await wt.tap(find.text(appLocale.close));
  await wt.pumpAndSettle();

  expect(find.shortcutsModal(), findsNothing);

  await wt.sendKeyEvent(LogicalKeyboardKey.escape);
  await wt.pumpAndSettle();
}

Future<void> _checkToggleBrightnessMode(WidgetTester wt) async {
  expect(find.toggleThemeButton(), findsOneWidget);

  Brightness getBrightness() {
    return Theme.of(wt.element(find.toggleThemeButton())).brightness;
  }

  Future<void> toggleTheme() async {
    await wt.tap(find.toggleThemeButton());
    await wt.pumpAndSettle();
  }

  final startBrightness = getBrightness();
  final invertedBrightness =
      startBrightness == Brightness.light ? Brightness.dark : Brightness.light;

  await toggleTheme();
  expect(getBrightness(), invertedBrightness);
  await toggleTheme();
  expect(getBrightness(), startBrightness);
}

Future<void> _checkDragVertically(WidgetTester wt) async {
  final height = wt.getSize(find.splitView()).height;
  var dragHandlePosition = wt.getCenter(find.dragHandle());

  await wt.drag(find.dragHandle(), Offset(0, height * 0.1));
  await wt.pumpAndSettle();

  var newPosition = wt.getCenter(find.dragHandle());
  expectSimilar(newPosition.dy, dragHandlePosition.dy + height * 0.1);
}

Future<void> _checkExcessivelyDragVertically(WidgetTester wt) async {
  final height = wt.getSize(find.splitView()).height;
  final dragHandlePosition = wt.getCenter(find.dragHandle());

  await wt.drag(find.dragHandle(), Offset(0, height * 0.9));
  await wt.pumpAndSettle();

  final newPosition = wt.getCenter(find.dragHandle());
  final maxDy = height * (maxRatio - defaultRatio);
  expectSimilar(
    newPosition.dy,
    dragHandlePosition.dy + maxDy,
  );
}

Future<void> _checkDragHorizontally(WidgetTester wt) async {
  final width = wt.getSize(find.splitView()).width;
  final dragHandlePosition = wt.getCenter(find.dragHandle());

  await wt.drag(find.dragHandle(), Offset(width * 0.1, 0));
  await wt.pumpAndSettle();

  final newPosition = wt.getCenter(find.dragHandle());
  expectSimilar(newPosition.dx, dragHandlePosition.dx + width * 0.1);
}

Future<void> _checkExcessivelyDragHorizontally(WidgetTester wt) async {
  final width = wt.getSize(find.splitView()).width;
  final dragHandlePosition = wt.getCenter(find.dragHandle());

  await wt.drag(find.dragHandle(), Offset(width * 0.9, 0));
  await wt.pumpAndSettle();

  final newPosition = wt.getCenter(find.dragHandle());
  final maxDx = width * (maxRatio - defaultRatio);
  expectSimilar(
    newPosition.dx,
    dragHandlePosition.dx + maxDx,
  );
}

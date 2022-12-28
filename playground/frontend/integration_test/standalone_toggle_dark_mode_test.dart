import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';

import 'common.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  testWidgets(
    'Change dark mode',
    (WidgetTester wt) async {
      await init(wt);

      expect(find.toggleThemeButton(), findsOneWidget);

      Brightness getBrightness() {
        return Theme.of(wt.element(find.toggleThemeButton())).brightness;
      }

      Future<void> toggleTheme() async {
        await wt.tap(find.toggleThemeButton());
        await wt.pumpAndSettle();
      }

      expect(getBrightness(), Brightness.light);
      await toggleTheme();
      expect(getBrightness(), Brightness.dark);
      await toggleTheme();
      expect(getBrightness(), Brightness.light);
    },
  );
}

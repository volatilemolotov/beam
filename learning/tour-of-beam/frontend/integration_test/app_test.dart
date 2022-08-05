import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:tour_of_beam/components/toggle_theme_button.dart';
import 'package:tour_of_beam/main.dart' as app;

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  group('theme', () {
    testWidgets('mode toggle', (tester) async {
      app.main();
      await tester.pumpAndSettle();
      final Finder switchToDarkModeButton =
          find.widgetWithText(ToggleThemeButton, 'Dark Mode');
      expect(switchToDarkModeButton, findsOneWidget);
      await tester.tap(switchToDarkModeButton);
      await tester.pumpAndSettle();
      expect(
        find.widgetWithText(ToggleThemeButton, 'Light Mode'),
        findsOneWidget,
      );
    });
  });
}

import 'package:flutter_test/flutter_test.dart';
import 'package:tour_of_beam/config/theme/switch_notifier.dart';

void main() {
  group('theme mode', () {
    test('light mode is default', () {
      expect(ThemeSwitchNotifier().isDarkMode, false);
    });
  });
}

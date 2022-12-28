import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';

import 'common.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  testWidgets('Shortcuts window test', (WidgetTester wt) async {
    await init(wt);

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
  });
}

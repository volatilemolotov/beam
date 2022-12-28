import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:playground/modules/examples/components/description_popover/description_popover.dart';

import 'common/common.dart';
import 'common/common_finders.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  testWidgets(
    'Example description',
    (WidgetTester wt) async {
      await init(wt);

      expect(find.descriptionPopoverButton(), findsOneWidget);

      await wt.tap(find.descriptionPopoverButton());
      await wt.pumpAndSettle();

      expect(find.descriptionPopover(), findsOneWidget);

      final example =
          (wt.element(find.descriptionPopover()).widget as DescriptionPopover)
              .example;
      expect(
        find.text(example.name),
        findsNWidgets(2),
      ); // in example selector and in popover
      expect(find.text(example.description), findsOneWidget);

      await wt.tap(find.descriptionPopoverButton());
      await wt.pumpAndSettle();

      expect(find.descriptionPopover(), findsNothing);
    },
  );
}

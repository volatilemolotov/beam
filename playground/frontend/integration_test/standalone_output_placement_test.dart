import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:playground/modules/output/models/output_placement.dart';
import 'package:playground_components_dev/playground_components_dev.dart';

import 'common/common.dart';
import 'common/common_finders.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  testWidgets(
    'Output placement test',
    (WidgetTester wt) async {
      await init(wt);

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
    },
  );
}

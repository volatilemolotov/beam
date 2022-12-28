import 'package:flutter/widgets.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:playground/modules/output/models/output_placement.dart';
import 'package:playground_components/src/widgets/split_view.dart';
import 'package:playground_components_dev/playground_components_dev.dart';

import 'common/common.dart';
import 'common/common_finders.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();
  testWidgets('Resizes horizontally as expected', (WidgetTester wt) async {
    await init(wt);

    expect(find.dragHandle(), findsOneWidget);

    await wt.tap(find.byKey(const ValueKey(OutputPlacement.left)));
    await wt.pumpAndSettle();

    final width = wt.getSize(find.splitView()).width;
    final dragHandlePosition = wt.getCenter(find.dragHandle());

    await wt.drag(find.dragHandle(), Offset(width * 0.9, 0));
    await wt.pumpAndSettle();

    final newPosition = wt.getCenter(find.dragHandle());
    expectSimilar(newPosition.dx,
        dragHandlePosition.dx + width * (maxRatio - defaultRatio));
  });
}

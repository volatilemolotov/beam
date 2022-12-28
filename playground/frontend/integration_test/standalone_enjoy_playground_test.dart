import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:playground/pages/standalone_playground/widgets/feedback/feedback_dropdown_content.dart';
import 'package:playground/pages/standalone_playground/widgets/feedback/playground_feedback.dart';

import 'common.dart';

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  testWidgets('Enjoy playground works correctly', (WidgetTester wt) async {
    await init(wt);

    expect(find.feedbackDropdownContent(), findsNothing);

    // enjoying and send feedback
    await wt.tap(find.byKey(PlaygroundFeedback.enjoyingKey));
    await wt.pumpAndSettle();

    expect(find.feedbackDropdownContent(), findsOneWidget);

    const text = 'This is a test';
    await wt.enterText(
        find.byKey(FeedbackDropdownContent.feedbackTextFieldKey), text);
    await wt.pumpAndSettle();

    expect(find.text(text), findsOneWidget);

    await wt.tap(find.byKey(FeedbackDropdownContent.sendFeedbackButtonKey));
    await wt.pumpAndSettle();

    expect(find.feedbackDropdownContent(), findsNothing);

    // not enjoying and close
    await wt.tap(find.byKey(PlaygroundFeedback.notEnjoyingKey));
    await wt.pumpAndSettle();

    expect(find.feedbackDropdownContent(), findsOneWidget);

    await wt.tap(find.byKey(FeedbackDropdownContent.cancelButtonKey));
    await wt.pumpAndSettle();

    expect(find.feedbackDropdownContent(), findsNothing);
  });
}

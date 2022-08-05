import 'package:flutter/material.dart';

import 'footer.dart';
import 'logo.dart';
import 'sign_in_button.dart';
import 'toggle_theme_button.dart';

class PageContainer extends StatelessWidget {
  final Widget content;

  const PageContainer({
    super.key,
    required this.content,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Logo(),
        actions: const [
          ToggleThemeButton(),
          SignInButton(),
        ],
      ),
      body: Column(
        children: [
          Expanded(child: content),
          const Footer(),
        ],
      ),
    );
  }
}

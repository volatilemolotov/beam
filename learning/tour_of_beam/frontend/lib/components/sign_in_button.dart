import 'package:easy_localization/easy_localization.dart';
import 'package:flutter/material.dart';

import '../constants/sizes.dart';

class SignInButton extends StatelessWidget {
  const SignInButton({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(
        vertical: kSmSpacing,
        horizontal: kMdSpacing,
      ),
      child: TextButton(
        child: const Text('header.signIn').tr(),
        onPressed: () {},
      ),
    );
  }
}

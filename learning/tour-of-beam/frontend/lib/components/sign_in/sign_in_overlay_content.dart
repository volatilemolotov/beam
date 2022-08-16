import 'package:easy_localization/easy_localization.dart';
import 'package:flutter/material.dart';

import '../../../constants/colors.dart';
import '../../../constants/sizes.dart';

class SignInOverlayContent extends StatelessWidget {
  const SignInOverlayContent();

  @override
  Widget build(BuildContext context) {
    return Material(
      elevation: TobSizes.size10,
      borderRadius: BorderRadius.circular(10),
      child: Container(
        width: TobSizes.authOverlayWidth,
        padding: const EdgeInsets.all(TobSizes.size24),
        child: Column(
          children: [
            Text(
              'ui.signIn',
              style: Theme.of(context).textTheme.titleLarge,
            ).tr(),
            const SizedBox(height: TobSizes.size10),
            const Text(
              'dialogs.signInIf',
              textAlign: TextAlign.center,
            ).tr(),
            const _Divider(),
            // TODO(nausharipov): check branded buttons in firebase_auth
            ElevatedButton(
              onPressed: () {},
              child: const Text('ui.continueGitHub').tr(),
            ),
            const SizedBox(height: TobSizes.size16),
            ElevatedButton(
              onPressed: () {},
              child: const Text('ui.continueGoogle').tr(),
            ),
          ],
        ),
      ),
    );
  }
}

class _Divider extends StatelessWidget {
  const _Divider();

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.symmetric(vertical: 20),
      width: TobSizes.size32,
      height: TobSizes.size1,
      color: TobColors.grey3,
    );
  }
}

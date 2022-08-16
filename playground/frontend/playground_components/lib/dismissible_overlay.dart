import 'package:flutter/material.dart';

class DismissibleOverlay extends StatelessWidget {
  final void Function() close;
  final Positioned child;

  const DismissibleOverlay({
    required this.close,
    required this.child,
  });

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        Positioned.fill(
          child: GestureDetector(
            onTap: close,
          ),
        ),
        child,
      ],
    );
  }
}

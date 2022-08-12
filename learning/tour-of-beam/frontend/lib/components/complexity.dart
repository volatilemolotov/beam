import 'package:flutter/material.dart';

import '../constants/colors.dart';
import '../constants/sizes.dart';

enum Complexity { basic, medium, advanced }

class ComplexityWidget extends StatelessWidget {
  final Complexity complexity;

  const ComplexityWidget({required this.complexity});

  @override
  Widget build(BuildContext context) {
    const Map<Complexity, List<Widget>> dots = {
      Complexity.basic: [_Dot.green, _Dot.grey, _Dot.grey],
      Complexity.medium: [_Dot.orange, _Dot.orange, _Dot.grey],
      Complexity.advanced: [_Dot.red, _Dot.red, _Dot.red],
    };

    return Row(children: dots[complexity]!);
  }
}

class _Dot extends StatelessWidget {
  final Color color;

  const _Dot({required this.color});

  static const grey = _Dot(color: TobColors.greyA0A4AB);
  static const green = _Dot(color: TobColors.green);
  static const orange = _Dot(color: TobColors.orange);
  static const red = _Dot(color: TobColors.red);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(left: 1),
      width: TobSizes.size4,
      height: TobSizes.size4,
      decoration: BoxDecoration(
        shape: BoxShape.circle,
        color: color,
      ),
    );
  }
}

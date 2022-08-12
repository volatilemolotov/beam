import 'package:flutter/material.dart';

import '../constants/colors.dart';
import '../constants/sizes.dart';

enum DifficultyLevel { basic, medium, advanced }

class Difficulty extends StatelessWidget {
  final DifficultyLevel level;
  const Difficulty({required this.level});

  @override
  Widget build(BuildContext context) {
    final List<Color> colors = [
      TobColors.greyA0A4AB,
      TobColors.greyA0A4AB,
      TobColors.greyA0A4AB,
    ];

    switch (level) {
      case DifficultyLevel.basic:
        colors[0] = TobColors.green;
        break;
      case DifficultyLevel.medium:
        colors.fillRange(0, 2, TobColors.orange);
        break;
      case DifficultyLevel.advanced:
        colors.fillRange(0, 3, TobColors.red);
        break;
    }

    return Row(
      children: colors
          .map(
            (color) => _Dot(color: color),
          )
          .toList(),
    );
  }
}

class _Dot extends StatelessWidget {
  final Color color;
  const _Dot({required this.color});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(left: 1),
      width: TobSizes.size4,
      height: TobSizes.size4,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(100),
        color: color,
      ),
    );
  }
}

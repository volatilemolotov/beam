import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../constants/colors.dart';

class ThemeColorsProvider extends StatelessWidget {
  final ThemeColors data;
  final Widget child;

  const ThemeColorsProvider({
    super.key,
    required this.data,
    required this.child,
  });

  @override
  Widget build(BuildContext context) {
    return Provider<ThemeColors>.value(
      value: data,
      child: child,
    );
  }
}

class ThemeColors {
  final Color? _background;

  final bool isDark;

  static ThemeColors of(BuildContext context, {bool listen = true}) {
    return Provider.of<ThemeColors>(context, listen: listen);
  }

  ThemeColors({
    required this.isDark,
    Color? background,
  }) : _background = background;

  const ThemeColors.fromBrightness({
    required this.isDark,
  }) : _background = null;

  ThemeColors copyWith({
    Color? background,
  }) {
    return ThemeColors(
      isDark: isDark,
      background: background ?? this.background,
    );
  }

  Color get divider => isDark ? kDarkGrey : kLightGrey;

  Color get primary => isDark ? kLightPrimary : kDarkPrimary;

  Color get primaryBackgroundTextColor => Colors.white;

  Color get lightGreyBackgroundTextColor => Colors.black;

  Color get secondaryBackground =>
      isDark ? kDarkSecondaryBackground : kLightSecondaryBackground;

  Color get background =>
      _background ??
      (isDark ? kDarkPrimaryBackground : kLightPrimaryBackground);

  Color get textColor => isDark ? kDarkText : kLightText;
}

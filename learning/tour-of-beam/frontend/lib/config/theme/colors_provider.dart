/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

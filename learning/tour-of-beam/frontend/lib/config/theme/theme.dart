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
import 'package:google_fonts/google_fonts.dart';

import '../../constants/colors.dart';
import '../../constants/sizes.dart';

final kLightTheme = ThemeData(
  brightness: Brightness.light,
  primaryColor: ProjectLightThemeColors.primary,
  scaffoldBackgroundColor: ProjectLightThemeColors.secondaryBackground,
  backgroundColor: ProjectLightThemeColors.primaryBackground,
  textTheme: _getTextTheme(ProjectLightThemeColors.text),
  textButtonTheme: _getTextButtonTheme(ProjectLightThemeColors.text),
  outlinedButtonTheme: _getOutlineButtonTheme(
    ProjectLightThemeColors.text,
    ProjectLightThemeColors.primary,
  ),
  elevatedButtonTheme: _getElevatedButtonTheme(ProjectLightThemeColors.primary),
  appBarTheme: _getAppBarTheme(ProjectLightThemeColors.secondaryBackground),
);

final kDarkTheme = ThemeData(
  brightness: Brightness.dark,
  primaryColor: ProjectDarkThemeColors.primary,
  scaffoldBackgroundColor: ProjectDarkThemeColors.secondaryBackground,
  backgroundColor: ProjectDarkThemeColors.primaryBackground,
  textTheme: _getTextTheme(ProjectDarkThemeColors.text),
  textButtonTheme: _getTextButtonTheme(ProjectDarkThemeColors.text),
  outlinedButtonTheme: _getOutlineButtonTheme(
    ProjectDarkThemeColors.text,
    ProjectDarkThemeColors.primary,
  ),
  elevatedButtonTheme: _getElevatedButtonTheme(ProjectDarkThemeColors.primary),
  appBarTheme: _getAppBarTheme(ProjectDarkThemeColors.secondaryBackground),
);

TextTheme _getTextTheme(Color textColor) {
  return GoogleFonts.sourceSansProTextTheme(
    const TextTheme(
      displayLarge: TextStyle(),
      displayMedium: TextStyle(
        fontSize: 48,
        fontWeight: FontWeight.w900,
      ),
      displaySmall: TextStyle(
        fontFamily: 'Roboto_regular',
        fontSize: 18,
        fontWeight: FontWeight.w400,
      ),
      headlineLarge: TextStyle(),
      headlineMedium: TextStyle(),
      headlineSmall: TextStyle(),
      titleLarge: TextStyle(
        fontSize: 24,
        fontWeight: FontWeight.w600,
      ),
      titleMedium: TextStyle(),
      titleSmall: TextStyle(),
      labelLarge: TextStyle(
        fontSize: 16,
        fontWeight: FontWeight.w600,
      ),
      labelMedium: TextStyle(),
      labelSmall: TextStyle(),
      bodyLarge: TextStyle(
        fontSize: 24,
        fontWeight: FontWeight.w400,
      ),
      bodyMedium: TextStyle(
        fontSize: 13,
        fontWeight: FontWeight.w400,
      ),
      bodySmall: TextStyle(),
    ).apply(
      bodyColor: textColor,
      displayColor: textColor,
    ),
  );
}

TextButtonThemeData _getTextButtonTheme(Color textColor) {
  return TextButtonThemeData(
    style: TextButton.styleFrom(
      primary: textColor,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.all(
          Radius.circular(ProjectBorderRadius.large),
        ),
      ),
    ),
  );
}

OutlinedButtonThemeData _getOutlineButtonTheme(
  Color textColor,
  Color outlineColor,
) {
  return OutlinedButtonThemeData(
    style: OutlinedButton.styleFrom(
      primary: textColor,
      side: BorderSide(color: outlineColor, width: 3),
      padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 40),
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.all(
          Radius.circular(ProjectBorderRadius.small),
        ),
      ),
    ),
  );
}

ElevatedButtonThemeData _getElevatedButtonTheme(Color color) {
  return ElevatedButtonThemeData(
    style: ElevatedButton.styleFrom(
      onPrimary: ProjectColors.white,
      primary: color,
      padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 40),
      elevation: 0,
    ),
  );
}

AppBarTheme _getAppBarTheme(Color backgroundColor) {
  return AppBarTheme(
    color: backgroundColor,
    elevation: 1,
    centerTitle: false,
  );
}

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

import '../../constants/colors.dart';
import '../../constants/font_weights.dart';
import '../../constants/fonts.dart';
import '../../constants/sizes.dart';

TextTheme _createTextTheme(Color textColor) {
  return getBaseFontTheme(
    const TextTheme(
      headline1: TextStyle(),
      headline2: TextStyle(),
      headline3: TextStyle(),
      headline4: TextStyle(),
      headline5: TextStyle(),
      headline6: TextStyle(),
      subtitle1: TextStyle(),
      subtitle2: TextStyle(),
      bodyText1: TextStyle(),
      bodyText2: TextStyle(),
      caption: TextStyle(),
      overline: TextStyle(),
      button: TextStyle(fontWeight: kBoldWeight),
    ).apply(
      bodyColor: textColor,
      displayColor: textColor,
    ),
  );
}

TextButtonThemeData _createTextButtonTheme(Color textColor) {
  return TextButtonThemeData(
    style: TextButton.styleFrom(
      primary: textColor,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.all(Radius.circular(kLgBorderRadius)),
      ),
    ),
  );
}

OutlinedButtonThemeData _createOutlineButtonTheme(Color textColor) {
  return OutlinedButtonThemeData(
    style: OutlinedButton.styleFrom(
      primary: textColor,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.all(Radius.circular(kSmBorderRadius)),
      ),
    ),
  );
}

AppBarTheme _createAppBarTheme(Color backgroundColor) {
  return AppBarTheme(
    color: backgroundColor,
    elevation: 1,
    centerTitle: false,
  );
}

final kLightTheme = ThemeData(
  brightness: Brightness.light,
  primaryColor: kLightPrimary,
  backgroundColor: kLightPrimaryBackground,
  textTheme: _createTextTheme(kLightText),
  textButtonTheme: _createTextButtonTheme(kLightText),
  outlinedButtonTheme: _createOutlineButtonTheme(kLightText),
  appBarTheme: _createAppBarTheme(kLightSecondaryBackground),
);

final kDarkTheme = ThemeData(
  brightness: Brightness.dark,
  primaryColor: kDarkPrimary,
  backgroundColor: kDarkPrimaryBackground,
  textTheme: _createTextTheme(kDarkText),
  textButtonTheme: _createTextButtonTheme(kDarkText),
  outlinedButtonTheme: _createOutlineButtonTheme(kDarkText),
  appBarTheme: _createAppBarTheme(kDarkSecondaryBackground),
);

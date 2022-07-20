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
import 'package:flutter/services.dart';
import 'package:playground/config/theme.dart';
import 'package:playground/constants/font_weight.dart';
import 'package:playground/constants/sizes.dart';

const kTextFieldMaxHeight = 45.0;

class LinkTextField extends StatefulWidget {
  final TextEditingController textEditingController;

  const LinkTextField({super.key, required this.textEditingController});

  @override
  State<LinkTextField> createState() => _LinkTextFieldState();
}

class _LinkTextFieldState extends State<LinkTextField> {
  bool isPressed = false;

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: ThemeColors.of(context).greyColor,
        borderRadius: BorderRadius.circular(kSmBorderRadius),
      ),
      child: Container(
        margin: const EdgeInsets.symmetric(horizontal: kMdSpacing),
        child: Center(
          child: TextFormField(
            controller: widget.textEditingController,
            decoration: InputDecoration(
              constraints: const BoxConstraints(maxHeight: kTextFieldMaxHeight),
              border: InputBorder.none,
              suffixIcon: MouseRegion(
                cursor: SystemMouseCursors.click,
                child: GestureDetector(
                  onTap: () {
                    copyLinkText();
                    setState(() {
                      isPressed = true;
                    });
                  },
                  child: isPressed
                      ? Icon(
                          Icons.check,
                          color: ThemeColors.of(context).grey1Color,
                          size: kIconSizeMd,
                        )
                      : Icon(
                          Icons.file_copy_outlined,
                          color: ThemeColors.of(context).grey1Color,
                          size: kIconSizeSm,
                        ),
                ),
              ),
            ),
            readOnly: true,
            style: TextStyle(
              fontSize: kLabelFontSize,
              fontWeight: kNormalWeight,
              color: ThemeColors.of(context).primary,
            ),
          ),
        ),
      ),
    );
  }

  void copyLinkText() async {
    await Clipboard.setData(ClipboardData(
      text: widget.textEditingController.text,
    ));
  }
}

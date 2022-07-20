// ignore_for_file: leading_newlines_in_multiline_strings

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
import 'package:playground/constants/sizes.dart';
import 'package:playground/modules/editor/components/share_dropdown/link_text_field.dart';
import 'package:playground/pages/playground/states/examples_state.dart';
import 'package:playground/pages/playground/states/playground_state.dart';
import 'package:provider/provider.dart';

import 'link_text_field.dart';

class ShareTabBody extends StatefulWidget {
  final String descriptionText;
  final bool isCopyLinkTab;
  final String snippetIdParam;

  const ShareTabBody({
    super.key,
    required this.descriptionText,
    required this.isCopyLinkTab,
    required this.snippetIdParam,
  });

  @override
  State<ShareTabBody> createState() => _ShareTabBodyState();
}

class _ShareTabBodyState extends State<ShareTabBody> {
  final TextEditingController textEditingController = TextEditingController();

  @override
  void initState() {
    super.initState();
    _setLinks();
  }

  @override
  Widget build(BuildContext context) {
    return Consumer2<ExampleState, PlaygroundState>(
      builder: (context, exampleState, playgroundState, child) => Padding(
        padding: const EdgeInsets.symmetric(
          // vertical: kXlSpacing,
          horizontal: kXlSpacing,
        ),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Text(widget.descriptionText),
              LinkTextField(
                textEditingController: textEditingController,
              ),
            ],
          ),
        ),
      ),
    );
  }

  void _setLinks() {
    String baseUrl = Uri.base.toString().split('?')[0];
    if (widget.isCopyLinkTab) {
      textEditingController.text = '$baseUrl?${widget.snippetIdParam}';
    } else {
      textEditingController.text =
          '''<iframe src="${baseUrl}embedded?enabled=true&${widget.snippetIdParam}"
          width="90%"
          height=600px
          allow="clipboard-write">
          </iframe>''';
    }
  }
}

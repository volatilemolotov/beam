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
import 'package:flutter/services.dart';
import 'package:playground/config/theme.dart';
import 'package:playground/constants/font_weight.dart';
import 'package:playground/constants/params.dart';
import 'package:playground/constants/sizes.dart';
import 'package:playground/modules/editor/components/share_dropdown/link_text_field.dart';
import 'package:playground/modules/editor/components/share_dropdown/share_link_field.dart';
import 'package:playground/modules/examples/repositories/models/shared_file_model.dart';
import 'package:playground/pages/playground/states/examples_state.dart';
import 'package:playground/pages/playground/states/playground_state.dart';
import 'package:provider/provider.dart';

import 'link_text_field.dart';

const kLoadingIndicatorSize = 20.0;

class ShareTabBody extends StatefulWidget {
  final String buttonText;
  final String descriptionText;
  final String copiedText;
  final String loadingText;
  final bool isCopyLinkTab;

  const ShareTabBody({
    super.key,
    required this.buttonText,
    required this.descriptionText,
    required this.copiedText,
    required this.loadingText,
    required this.isCopyLinkTab,
  });

  @override
  State<ShareTabBody> createState() => _ShareTabBodyState();
}

class _ShareTabBodyState extends State<ShareTabBody> {
  final TextEditingController textEditingController = TextEditingController();
  bool isPressed = false;

  @override
  Widget build(BuildContext context) {
    return Consumer2<ExampleState, PlaygroundState>(
      builder: (context, exampleState, playgroundState, child) => Padding(
        padding: const EdgeInsets.symmetric(
          vertical: kXlSpacing,
          horizontal: kXlSpacing,
        ),
        child: Center(
          child: isPressed
              ? FutureBuilder(
                  future: exampleState.getSnippetId(
                    [SharedFile(playgroundState.source, true, '')],
                    playgroundState.sdk,
                    playgroundState.pipelineOptions,
                  ),
                  builder: (context, snapshot) {
                    return _buildButton(playgroundState, snapshot);
                  },
                )
              : Column(
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                  children: [
                    Text(widget.descriptionText),
                    GestureDetector(
                      onTap: () async {
                        setState(() {
                          isPressed = true;
                        });
                      },
                      child: ShareLinkField(
                        isPressed: isPressed,
                        child: Text(
                          widget.buttonText,
                          style: TextStyle(
                            fontSize: kLabelFontSize,
                            fontWeight: kBoldWeight,
                            color: ThemeColors.of(context).primary,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
        ),
      ),
    );
  }

  Widget _buildButton(
    PlaygroundState playgroundState,
    AsyncSnapshot snapshot,
  ) {
    if (playgroundState.isExampleChanged) {
      if (snapshot.hasData) {
        if (widget.isCopyLinkTab) {
          setAndCopyLinkText('${Uri.base.toString().split('?')[0]}?snippetId=${snapshot.data.toString()}');
        } else {
          setAndCopyLinkText('''<iframe src="https://frontend-beta-dot-apache-beam-testing.appspot.com/embedded?enabled=true&snippetId=${snapshot.data.toString()}"
            width="100%"
            height=800px
            class="code-snippet playground"
            allow="clipboard-write">
          </iframe>''');
        }

        return Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Text(widget.copiedText),
            ShareLinkField(
              isPressed: isPressed,
              child: LinkTextField(
                textEditingController: textEditingController,
              ),
            ),
          ],
        );
      } else {
        return Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Text(widget.loadingText),
            ShareLinkField(
              isPressed: isPressed,
              child: SizedBox(
                height: kLoadingIndicatorSize,
                width: kLoadingIndicatorSize,
                child: CircularProgressIndicator(
                  color: ThemeColors.of(context).primary,
                ),
              ),
            ),
          ],
        );
      }
    } else {
      if (widget.isCopyLinkTab) {
        setAndCopyLinkText(
          '${Uri.base.toString().split('?')[0]}?$kExampleParam=${playgroundState.selectedExample!.path}',
        );
      } else {
        setAndCopyLinkText('''<iframe src="https://frontend-beta-dot-apache-beam-testing.appspot.com/embedded?enabled=true&snippetId=${playgroundState.selectedExample!.path}"
          width="100%"
          height=800px
          class="code-snippet playground"
          allow="clipboard-write">
        </iframe>''');
      }

      return Column(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          Text(widget.copiedText),
          ShareLinkField(
            isPressed: isPressed,
            child: LinkTextField(
              textEditingController: textEditingController,
            ),
          ),
        ],
      );
    }
  }

  void setAndCopyLinkText(String link) async {
    textEditingController.text = link;
    await Clipboard.setData(ClipboardData(
      text: textEditingController.text,
    ));
  }
}

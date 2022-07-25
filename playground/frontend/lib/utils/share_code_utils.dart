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

import 'package:playground/constants/params.dart';

class ShareCodeUtils {
  static String currentBaseUrl = Uri.base.toString().split('?')[0];

  static String snippetIdToPlaygroundUrl({required String snippetId}) {
    return '$currentBaseUrl?$kSnippetIdParam=$snippetId';
  }

  static String examplePathToPlaygroundUrl({required String examplePath}) {
    return '$currentBaseUrl?$kExampleParam=$examplePath';
  }

  static String snippetIdToIframeCode({
    required String snippetId,
    String widthInPercents = '90%',
    String heightInPixels = '600px',
  }) {
    return '''<iframe src="${currentBaseUrl}embedded?editable=1&$kSnippetIdParam=$snippetId"
          width="$widthInPercents"
          height=$heightInPixels
          allow="clipboard-write">
          </iframe>''';
  }

  static String examplePathToIframeCode({
    required String examplePath,
    String widthInPercents = '90%',
    String heightInPixels = '600px',
  }) {
    return '''<iframe src="${currentBaseUrl}embedded?editable=1&$kExampleParam=$examplePath"
          width="$widthInPercents"
          height=$heightInPixels
          allow="clipboard-write">
          </iframe>''';
  }
}

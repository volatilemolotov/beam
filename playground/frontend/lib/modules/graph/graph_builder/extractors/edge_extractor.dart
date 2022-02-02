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

import 'package:playground/modules/graph/graph_builder/extractors/extractors.dart';
import 'package:playground/modules/graph/models/graph.dart';

final RegExp kEdgeRegExp = RegExp(r'''\d+ -> \d+ \[style=.+ label=".*"\]''');
const kPrimaryEdgeStyle = 'solid';
const kEdgeSeparator = ' -> ';
const kStyleStart = '[';

class EdgeExtractor implements Extractor<Edge> {
  @override
  Edge? extract(String line) {
    final lineWithoutSpaces = line.trim();
    final edgesString =
    lineWithoutSpaces.substring(0, lineWithoutSpaces.indexOf(kStyleStart));
    final edges = edgesString.split(kEdgeSeparator);
    final isPrimary = lineWithoutSpaces.contains(kPrimaryEdgeStyle);
    return Edge(
        startId: edges[0].trim(), endId: edges[1].trim(), isPrimary: isPrimary);
  }

  @override
  bool check(String line) {
    return kEdgeRegExp.hasMatch(line);
  }
}

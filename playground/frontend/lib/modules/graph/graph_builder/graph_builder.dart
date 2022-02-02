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

import 'dart:convert';

import 'package:playground/modules/graph/graph_builder/extractors/edge_extractor.dart';
import 'package:playground/modules/graph/graph_builder/extractors/element_extractor.dart';
import 'package:playground/modules/graph/graph_builder/extractors/label_extractor.dart';
import 'package:playground/modules/graph/graph_builder/painters/edge_painter.dart';
import 'package:playground/modules/graph/graph_builder/painters/graph_painter.dart';
import 'package:playground/modules/graph/graph_builder/painters/node_painter.dart';
import 'package:playground/modules/graph/models/graph.dart';
import 'package:playground/modules/graph/models/table_cell.dart';

final kGraphElementExtractor = GraphElementExtractor();
final kLabelExtractor = LabelExtractor();
final kEdgeExtractor = EdgeExtractor();

class GraphBuilder {
  final List<GraphElement> elements = [];
  final List<Edge> edges = [];
  final List<GraphElement> parentElements = [];
  final Map<String, GraphElement> elementsMap = {};
  GraphElement? lastElement;

  static GraphBuilder parseDot(String dot) {
    LineSplitter ls = const LineSplitter();
    List<String> lines = ls.convert(dot);
    GraphBuilder builder = GraphBuilder();
    for (var line in lines) {
      builder._parseNextLine(line);
    }
    builder.finish();
    return builder;
  }

  void _parseNextLine(String line) {
    try {
      if (kGraphElementExtractor.check(line)) {
        final element = kGraphElementExtractor.extract(line);
        if (element == null) {
          return;
        }
        elements.add(element);
        setParent(element);
        if (element.type != NodeType.node) {
          parentElements.add(element);
          lastElement = element;
        }
        elementsMap[element.name] = element;
      } else if (kLabelExtractor.check(line)) {
        final label = kLabelExtractor.extract(line);
        lastElement?.label = label ?? '';
      } else if (kEdgeExtractor.check(line)) {
        final edge = kEdgeExtractor.extract(line);
        if (edge != null) {
          edges.add(edge);
        }
      }
    } catch (e) {
      print(e);
    }
  }

  setParent(GraphElement element) {
    final lastParent = parentElements.isNotEmpty ? parentElements.last : null;
    if (lastParent != null) {
      if (lastParent.depth >= element.depth) {
        while (parentElements.isNotEmpty &&
            parentElements.last.depth >= element.depth) {
          parentElements.removeLast();
        }
      }
      final prevParent = parentElements.isNotEmpty ? parentElements.last : null;
      element.parent = prevParent;
      prevParent?.child.add(element);
    }
  }

  GraphPainter getPainter() {
    final List<Node> nodeElements = elements
        .where((element) => element.type == NodeType.node)
        .toList()
        .cast<Node>();
    // nodes without incoming edges
    final List<Node> startNodes =
        nodeElements.where((element) => element.inEdges.isEmpty).toList();

    final List<Node> nodesInTopologicalOrder =
        sortElementsInTopologicalOrder(startNodes);

    final Map<String, int> nodeToColumnsMap = determineNodesColumns(
        nodeElements, startNodes, nodesInTopologicalOrder);
    final Map<String, TableCell<int>> nodeToCellMap = getNodeToCellMap(
      nodesInTopologicalOrder,
      nodeToColumnsMap,
    );

    return GraphPainter(
      elementsPainter: elements
          .where((element) => element.type == NodeType.node)
          .map<NodeElementPainter>((element) => NodeElementPainter(
                element: element as Node,
                row: nodeToCellMap[element.name]!.row,
                column: nodeToCellMap[element.name]!.column,
              ))
          .toList(),
      edges: edges.map((e) => EdgePainter(e)).toList(),
    );
  }

  /// Use Kahn's algorithm to sort elements in topological order
  sortElementsInTopologicalOrder(List<Node> startNodes) {
    final List<Node> startNodesCopy = [...startNodes];
    final List<Node> topologicalOrder = [];
    final Set<Edge> visitedEdges = {};
    while (startNodesCopy.isNotEmpty) {
      final currentNode = startNodesCopy.removeAt(0);
      topologicalOrder.add(currentNode);
      for (var edge in currentNode.outEdges) {
        final edgeNode = elementsMap[edge.endId] as Node;
        visitedEdges.add(edge);
        final hasInEdges =
            edgeNode.inEdges.where((e) => !visitedEdges.contains(e)).isNotEmpty;
        if (!hasInEdges) {
          startNodesCopy.add(edgeNode);
        }
      }
    }
  }

  Map<String, int> determineNodesColumns(List<Node> nodeElements,
      List<Node> startNodes, List<Node> nodesInTopologicalOrder) {
    final Map<String, int> nodeToColumnsMap = {};
    for (var element in nodeElements) {
      nodeToColumnsMap[element.name] = -1;
    }
    nodeToColumnsMap[nodesInTopologicalOrder.first.name] = 0;
    final nodeInTopologicalOrderCopy = [...nodesInTopologicalOrder];
    while (nodeInTopologicalOrderCopy.isNotEmpty) {
      Node node = nodeInTopologicalOrderCopy.removeAt(0);
      // Update distances of all adjacent vertices ;
      if (nodeToColumnsMap[node.name] != -1) {
        for (var edge in node.outEdges) {
          if (nodeToColumnsMap[edge.endId]! <
              nodeToColumnsMap[edge.startId]! + 1) {
            nodeToColumnsMap[edge.endId] = nodeToColumnsMap[edge.startId]! + 1;
          }
        }
      }
    }
    for (var element in startNodes) {
      final column = nodeToColumnsMap[element.name]!;
      if (column < 0) {
        nodeToColumnsMap[element.name] = 0;
      }
    }
    return nodeToColumnsMap;
  }

  Map<String, TableCell<int>> getNodeToCellMap(
      List<Node> nodesInTopologicalOrder, Map<String, int> nodeToColumnsMap) {
    final Map<String, TableCell<int>> nodeToCellMap = {};
    final Map<int, int> rowToColumn = {};

    for (var node in nodesInTopologicalOrder) {
      final column = nodeToColumnsMap[node.name]!;
      final row = (rowToColumn[column] ?? -1) + 1;
      rowToColumn[column] = row;
      nodeToCellMap[node.name] = TableCell(row: row, column: column);
    }
    return nodeToCellMap;
  }

  void finish() {
    for (var edge in edges) {
      (elementsMap[edge.startId] as Node).outEdges.add(edge);
      (elementsMap[edge.endId] as Node).inEdges.add(edge);
    }
  }
}

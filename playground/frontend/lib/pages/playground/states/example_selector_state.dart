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
import 'package:playground/modules/examples/models/category_model.dart';
import 'package:playground/modules/examples/models/example_model.dart';
import 'package:playground/pages/playground/states/playground_state.dart';

import 'examples_state.dart';

class ExampleSelectorState with ChangeNotifier {
  final ExampleState _exampleState;
  final PlaygroundState _playgroundState;
  String _filterText;
  List<CategoryModel> categories;
  List<String> selectedTags = [];

  ExampleSelectorState(
    this._exampleState,
    this._playgroundState,
    this.categories, [
    this._filterText = '',
  ]);

  String get filterText => _filterText;

  addSelectedTag(String tag) {
    selectedTags.add(tag);
    notifyListeners();
  }

  removeSelectedTag(String tag) {
    selectedTags.remove(tag);
    notifyListeners();
  }

  setFilterText(String text) {
    _filterText = text;
    notifyListeners();
  }

  setCategories(List<CategoryModel>? categories) {
    this.categories = categories ?? [];
    notifyListeners();
  }

  sortCategories() {
    final categories = _exampleState.getCategories(_playgroundState.sdk)!;
    final sortedCategories = categories
        .map((category) => CategoryModel(
            name: category.name,
            examples: _sortCategoryExamples(category.examples)))
        .where((category) => category.examples.isNotEmpty)
        .toList();
    setCategories(sortedCategories);
  }

  List<ExampleModel> _sortCategoryExamples(List<ExampleModel> examples) {
    if (selectedTags.isEmpty && filterText.isEmpty) {
      return examples;
    }
    if (selectedTags.isNotEmpty && filterText.isEmpty) {
      return sortExamplesByTags(examples);
    }
    if (selectedTags.isEmpty && filterText.isNotEmpty) {
      return sortExamplesByName(examples);
    }
    final sorted = sortExamplesByTags(examples);
    return sortExamplesByName(sorted);
  }

  List<ExampleModel> sortExamplesByTags(List<ExampleModel> examples) {
    List<ExampleModel> sorted = [];
    for (var example in examples) {
      if (example.tags.toSet().containsAll(selectedTags)) {
        sorted.add(example);
      }
    }
    return sorted;
  }

  List<ExampleModel> sortExamplesByName(List<ExampleModel> examples) {
    return examples
        .where((example) =>
            example.name.toLowerCase().contains(filterText.toLowerCase()))
        .toList();
  }
}

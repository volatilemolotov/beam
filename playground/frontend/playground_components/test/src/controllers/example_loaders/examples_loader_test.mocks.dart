// Mocks generated by Mockito 5.2.0 from annotations
// in playground_components/test/src/controllers/example_loaders/examples_loader_test.dart.
// Do not manually edit this file.

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'dart:async' as _i12;
import 'dart:ui' as _i13;

import 'package:mockito/mockito.dart' as _i1;
import 'package:playground_components/src/cache/example_cache.dart' as _i2;
import 'package:playground_components/src/controllers/example_loaders/examples_loader.dart'
    as _i3;
import 'package:playground_components/src/controllers/playground_controller.dart'
    as _i9;
import 'package:playground_components/src/controllers/snippet_editing_controller.dart'
    as _i5;
import 'package:playground_components/src/models/category_with_examples.dart'
    as _i14;
import 'package:playground_components/src/models/example.dart' as _i8;
import 'package:playground_components/src/models/example_base.dart' as _i7;
import 'package:playground_components/src/models/example_loading_descriptors/examples_loading_descriptor.dart'
    as _i6;
import 'package:playground_components/src/models/loading_status.dart' as _i15;
import 'package:playground_components/src/models/outputs.dart' as _i10;
import 'package:playground_components/src/models/sdk.dart' as _i11;
import 'package:playground_components/src/models/shortcut.dart' as _i4;
import 'package:playground_components/src/repositories/models/shared_file.dart'
    as _i16;

// ignore_for_file: type=lint
// ignore_for_file: avoid_redundant_argument_values
// ignore_for_file: avoid_setters_without_getters
// ignore_for_file: comment_references
// ignore_for_file: implementation_imports
// ignore_for_file: invalid_use_of_visible_for_testing_member
// ignore_for_file: prefer_const_constructors
// ignore_for_file: unnecessary_parenthesis
// ignore_for_file: camel_case_types

class _FakeExampleCache_0 extends _i1.Fake implements _i2.ExampleCache {}

class _FakeExamplesLoader_1 extends _i1.Fake implements _i3.ExamplesLoader {}

class _FakeBeamShortcut_2 extends _i1.Fake implements _i4.BeamShortcut {}

class _FakeSnippetEditingController_3 extends _i1.Fake
    implements _i5.SnippetEditingController {}

class _FakeExamplesLoadingDescriptor_4 extends _i1.Fake
    implements _i6.ExamplesLoadingDescriptor {}

class _FakeExampleBase_5 extends _i1.Fake implements _i7.ExampleBase {}

class _FakeExample_6 extends _i1.Fake implements _i8.Example {}

/// A class which mocks [PlaygroundController].
///
/// See the documentation for Mockito's code generation for more information.
class MockPlaygroundController extends _i1.Mock
    implements _i9.PlaygroundController {
  MockPlaygroundController() {
    _i1.throwOnMissingStub(this);
  }

  @override
  _i2.ExampleCache get exampleCache => (super.noSuchMethod(
        Invocation.getter(#exampleCache),
        returnValue: _FakeExampleCache_0(),
      ) as _i2.ExampleCache);
  @override
  _i3.ExamplesLoader get examplesLoader => (super.noSuchMethod(
        Invocation.getter(#examplesLoader),
        returnValue: _FakeExamplesLoader_1(),
      ) as _i3.ExamplesLoader);
  @override
  _i10.OutputType get selectedOutputFilterType => (super.noSuchMethod(
        Invocation.getter(#selectedOutputFilterType),
        returnValue: _i10.OutputType.all,
      ) as _i10.OutputType);
  @override
  set selectedOutputFilterType(_i10.OutputType? _selectedOutputFilterType) =>
      super.noSuchMethod(
        Invocation.setter(
          #selectedOutputFilterType,
          _selectedOutputFilterType,
        ),
        returnValueForMissingStub: null,
      );
  @override
  String get outputResult => (super.noSuchMethod(
        Invocation.getter(#outputResult),
        returnValue: '',
      ) as String);
  @override
  set outputResult(String? _outputResult) => super.noSuchMethod(
        Invocation.setter(
          #outputResult,
          _outputResult,
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i4.BeamShortcut get runShortcut => (super.noSuchMethod(
        Invocation.getter(#runShortcut),
        returnValue: _FakeBeamShortcut_2(),
      ) as _i4.BeamShortcut);
  @override
  set runShortcut(_i4.BeamShortcut? _runShortcut) => super.noSuchMethod(
        Invocation.setter(
          #runShortcut,
          _runShortcut,
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i4.BeamShortcut get resetShortcut => (super.noSuchMethod(
        Invocation.getter(#resetShortcut),
        returnValue: _FakeBeamShortcut_2(),
      ) as _i4.BeamShortcut);
  @override
  set resetShortcut(_i4.BeamShortcut? _resetShortcut) => super.noSuchMethod(
        Invocation.setter(
          #resetShortcut,
          _resetShortcut,
        ),
        returnValueForMissingStub: null,
      );
  @override
  String get examplesTitle => (super.noSuchMethod(
        Invocation.getter(#examplesTitle),
        returnValue: '',
      ) as String);
  @override
  bool get isCodeRunning => (super.noSuchMethod(
        Invocation.getter(#isCodeRunning),
        returnValue: false,
      ) as bool);
  @override
  bool get isExampleChanged => (super.noSuchMethod(
        Invocation.getter(#isExampleChanged),
        returnValue: false,
      ) as bool);
  @override
  bool get graphAvailable => (super.noSuchMethod(
        Invocation.getter(#graphAvailable),
        returnValue: false,
      ) as bool);
  @override
  List<_i4.BeamShortcut> get shortcuts => (super.noSuchMethod(
        Invocation.getter(#shortcuts),
        returnValue: <_i4.BeamShortcut>[],
      ) as List<_i4.BeamShortcut>);
  @override
  bool get hasListeners => (super.noSuchMethod(
        Invocation.getter(#hasListeners),
        returnValue: false,
      ) as bool);
  @override
  _i5.SnippetEditingController requireSnippetEditingController() =>
      (super.noSuchMethod(
        Invocation.method(
          #requireSnippetEditingController,
          [],
        ),
        returnValue: _FakeSnippetEditingController_3(),
      ) as _i5.SnippetEditingController);
  @override
  void setEmptyIfNoSdk(_i11.Sdk? sdk) => super.noSuchMethod(
        Invocation.method(
          #setEmptyIfNoSdk,
          [sdk],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setEmptyIfNotExists(
    _i11.Sdk? sdk, {
    bool? setCurrentSdk,
  }) =>
      super.noSuchMethod(
        Invocation.method(
          #setEmptyIfNotExists,
          [sdk],
          {#setCurrentSdk: setCurrentSdk},
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setExample(
    _i8.Example? example, {
    bool? setCurrentSdk,
  }) =>
      super.noSuchMethod(
        Invocation.method(
          #setExample,
          [example],
          {#setCurrentSdk: setCurrentSdk},
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setSdk(
    _i11.Sdk? sdk, {
    bool? notify = true,
  }) =>
      super.noSuchMethod(
        Invocation.method(
          #setSdk,
          [sdk],
          {#notify: notify},
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setSource(String? source) => super.noSuchMethod(
        Invocation.method(
          #setSource,
          [source],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setSelectedOutputFilterType(_i10.OutputType? type) => super.noSuchMethod(
        Invocation.method(
          #setSelectedOutputFilterType,
          [type],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setOutputResult(String? outputs) => super.noSuchMethod(
        Invocation.method(
          #setOutputResult,
          [outputs],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void clearOutput() => super.noSuchMethod(
        Invocation.method(
          #clearOutput,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void reset() => super.noSuchMethod(
        Invocation.method(
          #reset,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void resetError() => super.noSuchMethod(
        Invocation.method(
          #resetError,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setPipelineOptions(String? options) => super.noSuchMethod(
        Invocation.method(
          #setPipelineOptions,
          [options],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void runCode({void Function()? onFinish}) => super.noSuchMethod(
        Invocation.method(
          #runCode,
          [],
          {#onFinish: onFinish},
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i12.Future<void> cancelRun() => (super.noSuchMethod(
        Invocation.method(
          #cancelRun,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i12.Future<void>);
  @override
  void filterOutput(_i10.OutputType? type) => super.noSuchMethod(
        Invocation.method(
          #filterOutput,
          [type],
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i12.Future<String> saveSnippet() => (super.noSuchMethod(
        Invocation.method(
          #saveSnippet,
          [],
        ),
        returnValue: Future<String>.value(''),
      ) as _i12.Future<String>);
  @override
  _i6.ExamplesLoadingDescriptor getLoadingDescriptor() => (super.noSuchMethod(
        Invocation.method(
          #getLoadingDescriptor,
          [],
        ),
        returnValue: _FakeExamplesLoadingDescriptor_4(),
      ) as _i6.ExamplesLoadingDescriptor);
  @override
  void addListener(_i13.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #addListener,
          [listener],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void removeListener(_i13.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #removeListener,
          [listener],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void dispose() => super.noSuchMethod(
        Invocation.method(
          #dispose,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void notifyListeners() => super.noSuchMethod(
        Invocation.method(
          #notifyListeners,
          [],
        ),
        returnValueForMissingStub: null,
      );
}

/// A class which mocks [ExampleCache].
///
/// See the documentation for Mockito's code generation for more information.
class MockExampleCache extends _i1.Mock implements _i2.ExampleCache {
  MockExampleCache() {
    _i1.throwOnMissingStub(this);
  }

  @override
  Map<_i11.Sdk, List<_i14.CategoryWithExamples>> get categoryListsBySdk =>
      (super.noSuchMethod(
        Invocation.getter(#categoryListsBySdk),
        returnValue: <_i11.Sdk, List<_i14.CategoryWithExamples>>{},
      ) as Map<_i11.Sdk, List<_i14.CategoryWithExamples>>);
  @override
  Map<_i11.Sdk, _i8.Example> get defaultExamplesBySdk => (super.noSuchMethod(
        Invocation.getter(#defaultExamplesBySdk),
        returnValue: <_i11.Sdk, _i8.Example>{},
      ) as Map<_i11.Sdk, _i8.Example>);
  @override
  bool get isSelectorOpened => (super.noSuchMethod(
        Invocation.getter(#isSelectorOpened),
        returnValue: false,
      ) as bool);
  @override
  set isSelectorOpened(bool? _isSelectorOpened) => super.noSuchMethod(
        Invocation.setter(
          #isSelectorOpened,
          _isSelectorOpened,
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i12.Future<void> get allExamplesFuture => (super.noSuchMethod(
        Invocation.getter(#allExamplesFuture),
        returnValue: Future<void>.value(),
      ) as _i12.Future<void>);
  @override
  _i15.LoadingStatus get catalogStatus => (super.noSuchMethod(
        Invocation.getter(#catalogStatus),
        returnValue: _i15.LoadingStatus.loading,
      ) as _i15.LoadingStatus);
  @override
  bool get hasListeners => (super.noSuchMethod(
        Invocation.getter(#hasListeners),
        returnValue: false,
      ) as bool);
  @override
  _i12.Future<void> loadAllPrecompiledObjectsIfNot() => (super.noSuchMethod(
        Invocation.method(
          #loadAllPrecompiledObjectsIfNot,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i12.Future<void>);
  @override
  List<_i14.CategoryWithExamples> getCategories(_i11.Sdk? sdk) =>
      (super.noSuchMethod(
        Invocation.method(
          #getCategories,
          [sdk],
        ),
        returnValue: <_i14.CategoryWithExamples>[],
      ) as List<_i14.CategoryWithExamples>);
  @override
  _i12.Future<_i7.ExampleBase> getPrecompiledObject(
    String? path,
    _i11.Sdk? sdk,
  ) =>
      (super.noSuchMethod(
        Invocation.method(
          #getPrecompiledObject,
          [
            path,
            sdk,
          ],
        ),
        returnValue: Future<_i7.ExampleBase>.value(_FakeExampleBase_5()),
      ) as _i12.Future<_i7.ExampleBase>);
  @override
  _i12.Future<_i8.Example> loadSharedExample(String? id) => (super.noSuchMethod(
        Invocation.method(
          #loadSharedExample,
          [id],
        ),
        returnValue: Future<_i8.Example>.value(_FakeExample_6()),
      ) as _i12.Future<_i8.Example>);
  @override
  _i12.Future<String> saveSnippet({
    List<_i16.SharedFile>? files,
    _i11.Sdk? sdk,
    String? pipelineOptions,
  }) =>
      (super.noSuchMethod(
        Invocation.method(
          #saveSnippet,
          [],
          {
            #files: files,
            #sdk: sdk,
            #pipelineOptions: pipelineOptions,
          },
        ),
        returnValue: Future<String>.value(''),
      ) as _i12.Future<String>);
  @override
  _i12.Future<_i8.Example> loadExampleInfo(_i7.ExampleBase? example) =>
      (super.noSuchMethod(
        Invocation.method(
          #loadExampleInfo,
          [example],
        ),
        returnValue: Future<_i8.Example>.value(_FakeExample_6()),
      ) as _i12.Future<_i8.Example>);
  @override
  void changeSelectorVisibility() => super.noSuchMethod(
        Invocation.method(
          #changeSelectorVisibility,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i12.Future<_i8.Example?> getDefaultExampleBySdk(_i11.Sdk? sdk) =>
      (super.noSuchMethod(
        Invocation.method(
          #getDefaultExampleBySdk,
          [sdk],
        ),
        returnValue: Future<_i8.Example?>.value(),
      ) as _i12.Future<_i8.Example?>);
  @override
  _i12.Future<void> loadDefaultPrecompiledObjects() => (super.noSuchMethod(
        Invocation.method(
          #loadDefaultPrecompiledObjects,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i12.Future<void>);
  @override
  _i12.Future<void> loadDefaultPrecompiledObjectsIfNot() => (super.noSuchMethod(
        Invocation.method(
          #loadDefaultPrecompiledObjectsIfNot,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i12.Future<void>);
  @override
  _i12.Future<_i7.ExampleBase?> getCatalogExampleByPath(String? path) =>
      (super.noSuchMethod(
        Invocation.method(
          #getCatalogExampleByPath,
          [path],
        ),
        returnValue: Future<_i7.ExampleBase?>.value(),
      ) as _i12.Future<_i7.ExampleBase?>);
  @override
  void addListener(_i13.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #addListener,
          [listener],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void removeListener(_i13.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #removeListener,
          [listener],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void dispose() => super.noSuchMethod(
        Invocation.method(
          #dispose,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void notifyListeners() => super.noSuchMethod(
        Invocation.method(
          #notifyListeners,
          [],
        ),
        returnValueForMissingStub: null,
      );
}

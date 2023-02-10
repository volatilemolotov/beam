// Mocks generated by Mockito 5.2.0 from annotations
// in playground_components/test/src/controllers/example_loaders/examples_loader_test.dart.
// Do not manually edit this file.

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'dart:async' as _i14;
import 'dart:ui' as _i16;

import 'package:mockito/mockito.dart' as _i1;
import 'package:playground_components/src/cache/example_cache.dart' as _i2;
import 'package:playground_components/src/controllers/code_runner.dart' as _i5;
import 'package:playground_components/src/controllers/example_loaders/examples_loader.dart'
    as _i3;
import 'package:playground_components/src/controllers/output_filter_type_controller.dart'
    as _i4;
import 'package:playground_components/src/controllers/playground_controller.dart'
    as _i12;
import 'package:playground_components/src/controllers/snippet_editing_controller.dart'
    as _i7;
import 'package:playground_components/src/models/category_with_examples.dart'
    as _i17;
import 'package:playground_components/src/models/example.dart' as _i11;
import 'package:playground_components/src/models/example_base.dart' as _i10;
import 'package:playground_components/src/models/example_loading_descriptors/example_loading_descriptor.dart'
    as _i15;
import 'package:playground_components/src/models/example_loading_descriptors/examples_loading_descriptor.dart'
    as _i9;
import 'package:playground_components/src/models/example_loading_descriptors/user_shared_example_loading_descriptor.dart'
    as _i8;
import 'package:playground_components/src/models/loading_status.dart' as _i18;
import 'package:playground_components/src/models/sdk.dart' as _i13;
import 'package:playground_components/src/models/shortcut.dart' as _i6;
import 'package:playground_components/src/models/snippet_file.dart' as _i19;

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

class _FakeOutputFilterTypeController_2 extends _i1.Fake
    implements _i4.OutputFilterTypeController {}

class _FakeCodeRunner_3 extends _i1.Fake implements _i5.CodeRunner {}

class _FakeBeamShortcut_4 extends _i1.Fake implements _i6.BeamShortcut {}

class _FakeSnippetEditingController_5 extends _i1.Fake
    implements _i7.SnippetEditingController {}

class _FakeUserSharedExampleLoadingDescriptor_6 extends _i1.Fake
    implements _i8.UserSharedExampleLoadingDescriptor {}

class _FakeExamplesLoadingDescriptor_7 extends _i1.Fake
    implements _i9.ExamplesLoadingDescriptor {}

class _FakeExampleBase_8 extends _i1.Fake implements _i10.ExampleBase {}

class _FakeExample_9 extends _i1.Fake implements _i11.Example {}

/// A class which mocks [PlaygroundController].
///
/// See the documentation for Mockito's code generation for more information.
class MockPlaygroundController extends _i1.Mock
    implements _i12.PlaygroundController {
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
  _i4.OutputFilterTypeController get outputTypeController =>
      (super.noSuchMethod(
        Invocation.getter(#outputTypeController),
        returnValue: _FakeOutputFilterTypeController_2(),
      ) as _i4.OutputFilterTypeController);
  @override
  _i5.CodeRunner get codeRunner => (super.noSuchMethod(
        Invocation.getter(#codeRunner),
        returnValue: _FakeCodeRunner_3(),
      ) as _i5.CodeRunner);
  @override
  set codeRunner(_i5.CodeRunner? _codeRunner) => super.noSuchMethod(
        Invocation.setter(
          #codeRunner,
          _codeRunner,
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i6.BeamShortcut get runShortcut => (super.noSuchMethod(
        Invocation.getter(#runShortcut),
        returnValue: _FakeBeamShortcut_4(),
      ) as _i6.BeamShortcut);
  @override
  set runShortcut(_i6.BeamShortcut? _runShortcut) => super.noSuchMethod(
        Invocation.setter(
          #runShortcut,
          _runShortcut,
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i6.BeamShortcut get resetShortcut => (super.noSuchMethod(
        Invocation.getter(#resetShortcut),
        returnValue: _FakeBeamShortcut_4(),
      ) as _i6.BeamShortcut);
  @override
  set resetShortcut(_i6.BeamShortcut? _resetShortcut) => super.noSuchMethod(
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
  bool get graphAvailable => (super.noSuchMethod(
        Invocation.getter(#graphAvailable),
        returnValue: false,
      ) as bool);
  @override
  List<_i6.BeamShortcut> get shortcuts => (super.noSuchMethod(
        Invocation.getter(#shortcuts),
        returnValue: <_i6.BeamShortcut>[],
      ) as List<_i6.BeamShortcut>);
  @override
  bool get hasListeners => (super.noSuchMethod(
        Invocation.getter(#hasListeners),
        returnValue: false,
      ) as bool);
  @override
  _i7.SnippetEditingController requireSnippetEditingController() =>
      (super.noSuchMethod(
        Invocation.method(
          #requireSnippetEditingController,
          [],
        ),
        returnValue: _FakeSnippetEditingController_5(),
      ) as _i7.SnippetEditingController);
  @override
  void setEmptyIfNoSdk(_i13.Sdk? sdk) => super.noSuchMethod(
        Invocation.method(
          #setEmptyIfNoSdk,
          [sdk],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setEmptyIfNotExists(
    _i13.Sdk? sdk, {
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
  _i14.Future<void> setExampleBase(_i10.ExampleBase? exampleBase) =>
      (super.noSuchMethod(
        Invocation.method(
          #setExampleBase,
          [exampleBase],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i14.Future<void>);
  @override
  void setExample(
    _i11.Example? example, {
    _i15.ExampleLoadingDescriptor? descriptor,
    bool? setCurrentSdk,
  }) =>
      super.noSuchMethod(
        Invocation.method(
          #setExample,
          [example],
          {
            #descriptor: descriptor,
            #setCurrentSdk: setCurrentSdk,
          },
        ),
        returnValueForMissingStub: null,
      );
  @override
  void setSdk(
    _i13.Sdk? sdk, {
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
  _i14.Future<void> reset() => (super.noSuchMethod(
        Invocation.method(
          #reset,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i14.Future<void>);
  @override
  void resetErrorMessageText() => super.noSuchMethod(
        Invocation.method(
          #resetErrorMessageText,
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
  _i14.Future<_i8.UserSharedExampleLoadingDescriptor> saveSnippet() =>
      (super.noSuchMethod(
        Invocation.method(
          #saveSnippet,
          [],
        ),
        returnValue: Future<_i8.UserSharedExampleLoadingDescriptor>.value(
            _FakeUserSharedExampleLoadingDescriptor_6()),
      ) as _i14.Future<_i8.UserSharedExampleLoadingDescriptor>);
  @override
  _i9.ExamplesLoadingDescriptor getLoadingDescriptor() => (super.noSuchMethod(
        Invocation.method(
          #getLoadingDescriptor,
          [],
        ),
        returnValue: _FakeExamplesLoadingDescriptor_7(),
      ) as _i9.ExamplesLoadingDescriptor);
  @override
  void dispose() => super.noSuchMethod(
        Invocation.method(
          #dispose,
          [],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void addListener(_i16.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #addListener,
          [listener],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void removeListener(_i16.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #removeListener,
          [listener],
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
  Map<_i13.Sdk, List<_i17.CategoryWithExamples>> get categoryListsBySdk =>
      (super.noSuchMethod(
        Invocation.getter(#categoryListsBySdk),
        returnValue: <_i13.Sdk, List<_i17.CategoryWithExamples>>{},
      ) as Map<_i13.Sdk, List<_i17.CategoryWithExamples>>);
  @override
  Map<_i13.Sdk, _i11.Example> get defaultExamplesBySdk => (super.noSuchMethod(
        Invocation.getter(#defaultExamplesBySdk),
        returnValue: <_i13.Sdk, _i11.Example>{},
      ) as Map<_i13.Sdk, _i11.Example>);
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
  _i14.Future<void> get allExamplesFuture => (super.noSuchMethod(
        Invocation.getter(#allExamplesFuture),
        returnValue: Future<void>.value(),
      ) as _i14.Future<void>);
  @override
  _i18.LoadingStatus get catalogStatus => (super.noSuchMethod(
        Invocation.getter(#catalogStatus),
        returnValue: _i18.LoadingStatus.loading,
      ) as _i18.LoadingStatus);
  @override
  bool get hasListeners => (super.noSuchMethod(
        Invocation.getter(#hasListeners),
        returnValue: false,
      ) as bool);
  @override
  _i14.Future<void> loadAllPrecompiledObjectsIfNot() => (super.noSuchMethod(
        Invocation.method(
          #loadAllPrecompiledObjectsIfNot,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i14.Future<void>);
  @override
  List<_i17.CategoryWithExamples> getCategories(_i13.Sdk? sdk) =>
      (super.noSuchMethod(
        Invocation.method(
          #getCategories,
          [sdk],
        ),
        returnValue: <_i17.CategoryWithExamples>[],
      ) as List<_i17.CategoryWithExamples>);
  @override
  _i14.Future<_i10.ExampleBase> getPrecompiledObject(
    String? path,
    _i13.Sdk? sdk,
  ) =>
      (super.noSuchMethod(
        Invocation.method(
          #getPrecompiledObject,
          [
            path,
            sdk,
          ],
        ),
        returnValue: Future<_i10.ExampleBase>.value(_FakeExampleBase_8()),
      ) as _i14.Future<_i10.ExampleBase>);
  @override
  _i14.Future<_i11.Example> loadSharedExample(String? id) =>
      (super.noSuchMethod(
        Invocation.method(
          #loadSharedExample,
          [id],
        ),
        returnValue: Future<_i11.Example>.value(_FakeExample_9()),
      ) as _i14.Future<_i11.Example>);
  @override
  _i14.Future<String> saveSnippet({
    List<_i19.SnippetFile>? files,
    _i13.Sdk? sdk,
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
      ) as _i14.Future<String>);
  @override
  _i14.Future<_i11.Example> loadExampleInfo(_i10.ExampleBase? example) =>
      (super.noSuchMethod(
        Invocation.method(
          #loadExampleInfo,
          [example],
        ),
        returnValue: Future<_i11.Example>.value(_FakeExample_9()),
      ) as _i14.Future<_i11.Example>);
  @override
  void setSelectorOpened(bool? value) => super.noSuchMethod(
        Invocation.method(
          #setSelectorOpened,
          [value],
        ),
        returnValueForMissingStub: null,
      );
  @override
  _i14.Future<_i11.Example?> getDefaultExampleBySdk(_i13.Sdk? sdk) =>
      (super.noSuchMethod(
        Invocation.method(
          #getDefaultExampleBySdk,
          [sdk],
        ),
        returnValue: Future<_i11.Example?>.value(),
      ) as _i14.Future<_i11.Example?>);
  @override
  _i14.Future<void> loadDefaultPrecompiledObjects() => (super.noSuchMethod(
        Invocation.method(
          #loadDefaultPrecompiledObjects,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i14.Future<void>);
  @override
  _i14.Future<void> loadDefaultPrecompiledObjectsIfNot() => (super.noSuchMethod(
        Invocation.method(
          #loadDefaultPrecompiledObjectsIfNot,
          [],
        ),
        returnValue: Future<void>.value(),
        returnValueForMissingStub: Future<void>.value(),
      ) as _i14.Future<void>);
  @override
  _i14.Future<_i10.ExampleBase?> getCatalogExampleByPath(String? path) =>
      (super.noSuchMethod(
        Invocation.method(
          #getCatalogExampleByPath,
          [path],
        ),
        returnValue: Future<_i10.ExampleBase?>.value(),
      ) as _i14.Future<_i10.ExampleBase?>);
  @override
  void addListener(_i16.VoidCallback? listener) => super.noSuchMethod(
        Invocation.method(
          #addListener,
          [listener],
        ),
        returnValueForMissingStub: null,
      );
  @override
  void removeListener(_i16.VoidCallback? listener) => super.noSuchMethod(
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

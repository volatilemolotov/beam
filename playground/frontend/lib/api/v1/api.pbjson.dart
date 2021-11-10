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
///
//  Generated code. Do not modify.
//  source: api/v1/api.proto
//
// @dart = 2.12
// ignore_for_file: annotate_overrides,camel_case_types,unnecessary_const,non_constant_identifier_names,library_prefixes,unused_import,unused_shown_name,return_of_invalid_type,unnecessary_this,prefer_final_fields,deprecated_member_use_from_same_package

import 'dart:core' as $core;
import 'dart:convert' as $convert;
import 'dart:typed_data' as $typed_data;
@$core.Deprecated('Use sdkDescriptor instead')
const Sdk$json = const {
  '1': 'Sdk',
  '2': const [
    const {'1': 'SDK_UNSPECIFIED', '2': 0},
    const {'1': 'SDK_JAVA', '2': 1},
    const {'1': 'SDK_GO', '2': 2},
    const {'1': 'SDK_PYTHON', '2': 3},
    const {'1': 'SDK_SCIO', '2': 4},
  ],
};

/// Descriptor for `Sdk`. Decode as a `google.protobuf.EnumDescriptorProto`.
final $typed_data.Uint8List sdkDescriptor = $convert.base64Decode('CgNTZGsSEwoPU0RLX1VOU1BFQ0lGSUVEEAASDAoIU0RLX0pBVkEQARIKCgZTREtfR08QAhIOCgpTREtfUFlUSE9OEAMSDAoIU0RLX1NDSU8QBA==');
@$core.Deprecated('Use statusDescriptor instead')
const Status$json = const {
  '1': 'Status',
  '2': const [
    const {'1': 'STATUS_UNSPECIFIED', '2': 0},
    const {'1': 'STATUS_VALIDATING', '2': 1},
    const {'1': 'STATUS_VALIDATION_ERROR', '2': 2},
    const {'1': 'STATUS_PREPARING', '2': 3},
    const {'1': 'STATUS_PREPARATION_ERROR', '2': 4},
    const {'1': 'STATUS_COMPILING', '2': 5},
    const {'1': 'STATUS_COMPILE_ERROR', '2': 6},
    const {'1': 'STATUS_EXECUTING', '2': 7},
    const {'1': 'STATUS_FINISHED', '2': 8},
    const {'1': 'STATUS_RUN_ERROR', '2': 9},
    const {'1': 'STATUS_ERROR', '2': 10},
    const {'1': 'STATUS_RUN_TIMEOUT', '2': 11},
  ],
};

/// Descriptor for `Status`. Decode as a `google.protobuf.EnumDescriptorProto`.
final $typed_data.Uint8List statusDescriptor = $convert.base64Decode('CgZTdGF0dXMSFgoSU1RBVFVTX1VOU1BFQ0lGSUVEEAASFQoRU1RBVFVTX1ZBTElEQVRJTkcQARIbChdTVEFUVVNfVkFMSURBVElPTl9FUlJPUhACEhQKEFNUQVRVU19QUkVQQVJJTkcQAxIcChhTVEFUVVNfUFJFUEFSQVRJT05fRVJST1IQBBIUChBTVEFUVVNfQ09NUElMSU5HEAUSGAoUU1RBVFVTX0NPTVBJTEVfRVJST1IQBhIUChBTVEFUVVNfRVhFQ1VUSU5HEAcSEwoPU1RBVFVTX0ZJTklTSEVEEAgSFAoQU1RBVFVTX1JVTl9FUlJPUhAJEhAKDFNUQVRVU19FUlJPUhAKEhYKElNUQVRVU19SVU5fVElNRU9VVBAL');
@$core.Deprecated('Use precompiledObjectTypeDescriptor instead')
const PrecompiledObjectType$json = const {
  '1': 'PrecompiledObjectType',
  '2': const [
    const {'1': 'EXAMPLE', '2': 0},
    const {'1': 'KATA', '2': 1},
    const {'1': 'UNIT_TEST', '2': 2},
  ],
};

/// Descriptor for `PrecompiledObjectType`. Decode as a `google.protobuf.EnumDescriptorProto`.
final $typed_data.Uint8List precompiledObjectTypeDescriptor = $convert.base64Decode('ChVQcmVjb21waWxlZE9iamVjdFR5cGUSCwoHRVhBTVBMRRAAEggKBEtBVEEQARINCglVTklUX1RFU1QQAg==');
@$core.Deprecated('Use runCodeRequestDescriptor instead')
const RunCodeRequest$json = const {
  '1': 'RunCodeRequest',
  '2': const [
    const {'1': 'code', '3': 1, '4': 1, '5': 9, '10': 'code'},
    const {'1': 'sdk', '3': 2, '4': 1, '5': 14, '6': '.api.v1.Sdk', '10': 'sdk'},
  ],
};

/// Descriptor for `RunCodeRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List runCodeRequestDescriptor = $convert.base64Decode('Cg5SdW5Db2RlUmVxdWVzdBISCgRjb2RlGAEgASgJUgRjb2RlEh0KA3NkaxgCIAEoDjILLmFwaS52MS5TZGtSA3Nkaw==');
@$core.Deprecated('Use runCodeResponseDescriptor instead')
const RunCodeResponse$json = const {
  '1': 'RunCodeResponse',
  '2': const [
    const {'1': 'pipeline_uuid', '3': 1, '4': 1, '5': 9, '10': 'pipelineUuid'},
  ],
};

/// Descriptor for `RunCodeResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List runCodeResponseDescriptor = $convert.base64Decode('Cg9SdW5Db2RlUmVzcG9uc2USIwoNcGlwZWxpbmVfdXVpZBgBIAEoCVIMcGlwZWxpbmVVdWlk');
@$core.Deprecated('Use checkStatusRequestDescriptor instead')
const CheckStatusRequest$json = const {
  '1': 'CheckStatusRequest',
  '2': const [
    const {'1': 'pipeline_uuid', '3': 1, '4': 1, '5': 9, '10': 'pipelineUuid'},
  ],
};

/// Descriptor for `CheckStatusRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List checkStatusRequestDescriptor = $convert.base64Decode('ChJDaGVja1N0YXR1c1JlcXVlc3QSIwoNcGlwZWxpbmVfdXVpZBgBIAEoCVIMcGlwZWxpbmVVdWlk');
@$core.Deprecated('Use checkStatusResponseDescriptor instead')
const CheckStatusResponse$json = const {
  '1': 'CheckStatusResponse',
  '2': const [
    const {'1': 'status', '3': 1, '4': 1, '5': 14, '6': '.api.v1.Status', '10': 'status'},
  ],
};

/// Descriptor for `CheckStatusResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List checkStatusResponseDescriptor = $convert.base64Decode('ChNDaGVja1N0YXR1c1Jlc3BvbnNlEiYKBnN0YXR1cxgBIAEoDjIOLmFwaS52MS5TdGF0dXNSBnN0YXR1cw==');
@$core.Deprecated('Use getCompileOutputRequestDescriptor instead')
const GetCompileOutputRequest$json = const {
  '1': 'GetCompileOutputRequest',
  '2': const [
    const {'1': 'pipeline_uuid', '3': 1, '4': 1, '5': 9, '10': 'pipelineUuid'},
  ],
};

/// Descriptor for `GetCompileOutputRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getCompileOutputRequestDescriptor = $convert.base64Decode('ChdHZXRDb21waWxlT3V0cHV0UmVxdWVzdBIjCg1waXBlbGluZV91dWlkGAEgASgJUgxwaXBlbGluZVV1aWQ=');
@$core.Deprecated('Use getCompileOutputResponseDescriptor instead')
const GetCompileOutputResponse$json = const {
  '1': 'GetCompileOutputResponse',
  '2': const [
    const {'1': 'output', '3': 1, '4': 1, '5': 9, '10': 'output'},
    const {'1': 'compilation_status', '3': 2, '4': 1, '5': 14, '6': '.api.v1.Status', '10': 'compilationStatus'},
  ],
};

/// Descriptor for `GetCompileOutputResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getCompileOutputResponseDescriptor = $convert.base64Decode('ChhHZXRDb21waWxlT3V0cHV0UmVzcG9uc2USFgoGb3V0cHV0GAEgASgJUgZvdXRwdXQSPQoSY29tcGlsYXRpb25fc3RhdHVzGAIgASgOMg4uYXBpLnYxLlN0YXR1c1IRY29tcGlsYXRpb25TdGF0dXM=');
@$core.Deprecated('Use getRunOutputRequestDescriptor instead')
const GetRunOutputRequest$json = const {
  '1': 'GetRunOutputRequest',
  '2': const [
    const {'1': 'pipeline_uuid', '3': 1, '4': 1, '5': 9, '10': 'pipelineUuid'},
  ],
};

/// Descriptor for `GetRunOutputRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getRunOutputRequestDescriptor = $convert.base64Decode('ChNHZXRSdW5PdXRwdXRSZXF1ZXN0EiMKDXBpcGVsaW5lX3V1aWQYASABKAlSDHBpcGVsaW5lVXVpZA==');
@$core.Deprecated('Use getRunOutputResponseDescriptor instead')
const GetRunOutputResponse$json = const {
  '1': 'GetRunOutputResponse',
  '2': const [
    const {'1': 'output', '3': 1, '4': 1, '5': 9, '10': 'output'},
  ],
};

/// Descriptor for `GetRunOutputResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getRunOutputResponseDescriptor = $convert.base64Decode('ChRHZXRSdW5PdXRwdXRSZXNwb25zZRIWCgZvdXRwdXQYASABKAlSBm91dHB1dA==');
@$core.Deprecated('Use getRunErrorRequestDescriptor instead')
const GetRunErrorRequest$json = const {
  '1': 'GetRunErrorRequest',
  '2': const [
    const {'1': 'pipeline_uuid', '3': 1, '4': 1, '5': 9, '10': 'pipelineUuid'},
  ],
};

/// Descriptor for `GetRunErrorRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getRunErrorRequestDescriptor = $convert.base64Decode('ChJHZXRSdW5FcnJvclJlcXVlc3QSIwoNcGlwZWxpbmVfdXVpZBgBIAEoCVIMcGlwZWxpbmVVdWlk');
@$core.Deprecated('Use getRunErrorResponseDescriptor instead')
const GetRunErrorResponse$json = const {
  '1': 'GetRunErrorResponse',
  '2': const [
    const {'1': 'output', '3': 1, '4': 1, '5': 9, '10': 'output'},
  ],
};

/// Descriptor for `GetRunErrorResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getRunErrorResponseDescriptor = $convert.base64Decode('ChNHZXRSdW5FcnJvclJlc3BvbnNlEhYKBm91dHB1dBgBIAEoCVIGb3V0cHV0');
@$core.Deprecated('Use getPrecompiledObjectsRequestDescriptor instead')
const GetPrecompiledObjectsRequest$json = const {
  '1': 'GetPrecompiledObjectsRequest',
  '2': const [
    const {'1': 'sdk', '3': 1, '4': 1, '5': 14, '6': '.api.v1.Sdk', '10': 'sdk'},
    const {'1': 'category', '3': 2, '4': 1, '5': 9, '10': 'category'},
  ],
};

/// Descriptor for `GetPrecompiledObjectsRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getPrecompiledObjectsRequestDescriptor = $convert.base64Decode('ChxHZXRQcmVjb21waWxlZE9iamVjdHNSZXF1ZXN0Eh0KA3NkaxgBIAEoDjILLmFwaS52MS5TZGtSA3NkaxIaCghjYXRlZ29yeRgCIAEoCVIIY2F0ZWdvcnk=');
@$core.Deprecated('Use precompiledObjectDescriptor instead')
const PrecompiledObject$json = const {
  '1': 'PrecompiledObject',
  '2': const [
    const {'1': 'cloud_path', '3': 1, '4': 1, '5': 9, '10': 'cloudPath'},
    const {'1': 'name', '3': 2, '4': 1, '5': 9, '10': 'name'},
    const {'1': 'description', '3': 3, '4': 1, '5': 9, '10': 'description'},
    const {'1': 'type', '3': 4, '4': 1, '5': 14, '6': '.api.v1.PrecompiledObjectType', '10': 'type'},
  ],
};

/// Descriptor for `PrecompiledObject`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List precompiledObjectDescriptor = $convert.base64Decode('ChFQcmVjb21waWxlZE9iamVjdBIdCgpjbG91ZF9wYXRoGAEgASgJUgljbG91ZFBhdGgSEgoEbmFtZRgCIAEoCVIEbmFtZRIgCgtkZXNjcmlwdGlvbhgDIAEoCVILZGVzY3JpcHRpb24SMQoEdHlwZRgEIAEoDjIdLmFwaS52MS5QcmVjb21waWxlZE9iamVjdFR5cGVSBHR5cGU=');
@$core.Deprecated('Use categoriesDescriptor instead')
const Categories$json = const {
  '1': 'Categories',
  '2': const [
    const {'1': 'sdk', '3': 1, '4': 1, '5': 14, '6': '.api.v1.Sdk', '10': 'sdk'},
    const {'1': 'categories', '3': 2, '4': 3, '5': 11, '6': '.api.v1.Categories.Category', '10': 'categories'},
  ],
  '3': const [Categories_Category$json],
};

@$core.Deprecated('Use categoriesDescriptor instead')
const Categories_Category$json = const {
  '1': 'Category',
  '2': const [
    const {'1': 'category_name', '3': 1, '4': 1, '5': 9, '10': 'categoryName'},
    const {'1': 'precompiled_objects', '3': 2, '4': 3, '5': 11, '6': '.api.v1.PrecompiledObject', '10': 'precompiledObjects'},
  ],
};

/// Descriptor for `Categories`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List categoriesDescriptor = $convert.base64Decode('CgpDYXRlZ29yaWVzEh0KA3NkaxgBIAEoDjILLmFwaS52MS5TZGtSA3NkaxI7CgpjYXRlZ29yaWVzGAIgAygLMhsuYXBpLnYxLkNhdGVnb3JpZXMuQ2F0ZWdvcnlSCmNhdGVnb3JpZXMaewoIQ2F0ZWdvcnkSIwoNY2F0ZWdvcnlfbmFtZRgBIAEoCVIMY2F0ZWdvcnlOYW1lEkoKE3ByZWNvbXBpbGVkX29iamVjdHMYAiADKAsyGS5hcGkudjEuUHJlY29tcGlsZWRPYmplY3RSEnByZWNvbXBpbGVkT2JqZWN0cw==');
@$core.Deprecated('Use getPrecompiledObjectsResponseDescriptor instead')
const GetPrecompiledObjectsResponse$json = const {
  '1': 'GetPrecompiledObjectsResponse',
  '2': const [
    const {'1': 'sdk_categories', '3': 1, '4': 3, '5': 11, '6': '.api.v1.Categories', '10': 'sdkCategories'},
  ],
};

/// Descriptor for `GetPrecompiledObjectsResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getPrecompiledObjectsResponseDescriptor = $convert.base64Decode('Ch1HZXRQcmVjb21waWxlZE9iamVjdHNSZXNwb25zZRI5Cg5zZGtfY2F0ZWdvcmllcxgBIAMoCzISLmFwaS52MS5DYXRlZ29yaWVzUg1zZGtDYXRlZ29yaWVz');
@$core.Deprecated('Use getPrecompiledObjectRequestDescriptor instead')
const GetPrecompiledObjectRequest$json = const {
  '1': 'GetPrecompiledObjectRequest',
  '2': const [
    const {'1': 'cloud_path', '3': 1, '4': 1, '5': 9, '10': 'cloudPath'},
  ],
};

/// Descriptor for `GetPrecompiledObjectRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getPrecompiledObjectRequestDescriptor = $convert.base64Decode('ChtHZXRQcmVjb21waWxlZE9iamVjdFJlcXVlc3QSHQoKY2xvdWRfcGF0aBgBIAEoCVIJY2xvdWRQYXRo');
@$core.Deprecated('Use getPrecompiledObjectCodeResponseDescriptor instead')
const GetPrecompiledObjectCodeResponse$json = const {
  '1': 'GetPrecompiledObjectCodeResponse',
  '2': const [
    const {'1': 'code', '3': 1, '4': 1, '5': 9, '10': 'code'},
  ],
};

/// Descriptor for `GetPrecompiledObjectCodeResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getPrecompiledObjectCodeResponseDescriptor = $convert.base64Decode('CiBHZXRQcmVjb21waWxlZE9iamVjdENvZGVSZXNwb25zZRISCgRjb2RlGAEgASgJUgRjb2Rl');

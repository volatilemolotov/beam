// Licensed to the Apache Software Foundation (ASF) under one or more
// contributor license agreements.  See the NOTICE file distributed with
// this work for additional information regarding copyright ownership.
// The ASF licenses this file to You under the Apache License, Version 2.0
// (the "License"); you may not use this file except in compliance with
// the License.  You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package mapper

import (
	"beam.apache.org/playground/backend/internal/db/dto"
	"beam.apache.org/playground/backend/internal/db/entity"
)

type PrecompiledObjectMapper struct {
}

func NewPrecompiledObjectMapper() *PrecompiledObjectMapper {
	return &PrecompiledObjectMapper{}
}

func (pom *PrecompiledObjectMapper) ToObjectInfo(exampleDTO *dto.ExampleDTO) *dto.ObjectInfo {
	return &dto.ObjectInfo{
		Name:            exampleDTO.Example.Name,
		Description:     exampleDTO.Example.Descr,
		Type:            exampleDTO.GetType(),
		Categories:      exampleDTO.Example.Cats,
		PipelineOptions: exampleDTO.Snippet.PipeOpts,
		Link:            exampleDTO.Example.Path,
		Multifile:       exampleDTO.HasMultiFiles(),
		ContextLine:     exampleDTO.GetContextLine(),
		DefaultExample:  exampleDTO.IsDefault(),
	}
}

func (pom *PrecompiledObjectMapper) ToSdkToCategories(catalogDTO *dto.CatalogDTO, targetCategory string) *dto.SdkToCategories {
	numberOfExamples := len(catalogDTO.Examples)
	sdkToCategories := make(dto.SdkToCategories, 0)
	for exampleIndx := 0; exampleIndx < numberOfExamples; exampleIndx++ {
		example := catalogDTO.Examples[exampleIndx]
		snippet := catalogDTO.Snippets[exampleIndx]
		files := []*entity.FileEntity{catalogDTO.Files[exampleIndx]}
		objInfo := pom.ToObjectInfo(&dto.ExampleDTO{
			Example:               example,
			Snippet:               snippet,
			Files:                 files,
			DefaultPrecompiledObj: catalogDTO.DefaultPrecompiledObj,
		})
		for _, objCategory := range objInfo.Categories {
			if targetCategory == "" || targetCategory == objCategory {
				appendPrecompiledObject(*objInfo, &sdkToCategories, objCategory, catalogDTO.Sdk)
			}
		}
	}
	return &sdkToCategories
}

// appendPrecompiledObject add precompiled object to the common structure of precompiled objects
func appendPrecompiledObject(objectInfo dto.ObjectInfo, sdkToCategories *dto.SdkToCategories, categoryName string, sdk string) {
	categoryToPrecompiledObjects, ok := (*sdkToCategories)[sdk]
	if !ok {
		(*sdkToCategories)[sdk] = make(dto.CategoryToPrecompiledObjects, 0)
		categoryToPrecompiledObjects = (*sdkToCategories)[sdk]
	}
	objects, ok := categoryToPrecompiledObjects[categoryName]
	if !ok {
		categoryToPrecompiledObjects[categoryName] = make(dto.PrecompiledObjects, 0)
		objects = categoryToPrecompiledObjects[categoryName]
	}
	categoryToPrecompiledObjects[categoryName] = append(objects, objectInfo)
}

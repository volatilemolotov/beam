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

func (rm *PrecompiledObjectMapper) ToObjectInfo(example *entity.ExampleEntity, snippet *entity.SnippetEntity) *dto.ObjectInfo {
	return &dto.ObjectInfo{
		Name:            example.Name,
		Description:     example.Descr,
		Type:            0,
		Categories:      example.Cats,
		PipelineOptions: snippet.PipeOpts,
		Link:            example.Path,
		Multifile:       false,
		ContextLine:     0,
		DefaultExample:  false,
	}
}

func isMultifile() {

}

func (rm *PrecompiledObjectMapper) ToSdkToCategories(examples []*entity.ExampleEntity, snippets []*entity.SnippetEntity) *dto.SdkToCategories {
	number_of_examples := len(examples)
	for i := 0; i < number_of_examples; i++ {
		example := examples[i]
		snippet := snippets[i]
		objInfo := rm.ToObjectInfo(example, snippet)
		precompiledObjects := make(dto.SdkToCategories, number_of_examples)

	}

	return nil
}

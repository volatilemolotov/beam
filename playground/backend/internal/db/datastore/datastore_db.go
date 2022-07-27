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

package datastore

import (
	"context"
	"fmt"
	"time"

	"cloud.google.com/go/datastore"

	pb "beam.apache.org/playground/backend/internal/api/v1"
	"beam.apache.org/playground/backend/internal/db/dto"
	"beam.apache.org/playground/backend/internal/db/entity"
	"beam.apache.org/playground/backend/internal/db/mapper"
	"beam.apache.org/playground/backend/internal/logger"
)

const (
	Namespace = "Playground"

	SnippetKind  = "pg_snippets"
	SchemaKind   = "pg_schema_versions"
	SdkKind      = "pg_sdks"
	FileKind     = "pg_files"
	ExampleKind  = "pg_examples"
	PCObjectKind = "pg_pc_objects"
)

type Datastore struct {
	Client         *datastore.Client
	ResponseMapper mapper.ResponseMapper
}

func New(ctx context.Context, responseMapper mapper.ResponseMapper, projectId string) (*Datastore, error) {
	client, err := datastore.NewClient(ctx, projectId)
	if err != nil {
		logger.Errorf("Datastore: connection to store: error during connection, err: %s\n", err.Error())
		return nil, err
	}
	return &Datastore{Client: client, ResponseMapper: responseMapper}, nil
}

// PutSnippet puts the snippet entity to datastore
func (d *Datastore) PutSnippet(ctx context.Context, snipId string, snip *entity.Snippet) error {
	if snip == nil {
		logger.Errorf("Datastore: PutSnippet(): snippet is nil")
		return nil
	}
	snipKey := getSnippetKey(snipId)
	tx, err := d.Client.NewTransaction(ctx)
	if err != nil {
		logger.Errorf("Datastore: PutSnippet(): error during the transaction creating, err: %s\n", err.Error())
		return err
	}
	if _, err = tx.Put(snipKey, snip.Snippet); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: PutSnippet(): error during the snippet entity saving, err: %s\n", err.Error())
		return err
	}

	var fileKeys []*datastore.Key
	for index := range snip.Files {
		fileKeys = append(fileKeys, getFileKey(fmt.Sprintf("%s_%d", snipId, index)))
	}

	if _, err = tx.PutMulti(fileKeys, snip.Files); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: PutSnippet(): error during the file entity saving, err: %s\n", err.Error())
		return err
	}

	if _, err = tx.Commit(); err != nil {
		logger.Errorf("Datastore: PutSnippet(): error during the transaction committing, err: %s\n", err.Error())
		return err
	}

	return nil
}

// GetSnippet returns the snippet entity by identifier
func (d *Datastore) GetSnippet(ctx context.Context, id string) (*entity.SnippetEntity, error) {
	key := getSnippetKey(id)
	snip := new(entity.SnippetEntity)
	tx, err := d.Client.NewTransaction(ctx)
	if err != nil {
		logger.Errorf("Datastore: GetSnippet(): error during the transaction creating, err: %s\n", err.Error())
		return nil, err
	}
	if err = tx.Get(key, snip); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: GetSnippet(): error during snippet getting, err: %s\n", err.Error())
		return nil, err
	}
	snip.LVisited = time.Now()
	snip.VisitCount += 1
	if _, err = tx.Put(key, snip); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: GetSnippet(): error during snippet setting, err: %s\n", err.Error())
		return nil, err
	}
	if _, err = tx.Commit(); err != nil {
		logger.Errorf("Datastore: GetSnippet(): error during the transaction committing, err: %s\n", err.Error())
		return nil, err
	}
	return snip, nil
}

// PutSchemaVersion puts the schema entity to datastore
func (d *Datastore) PutSchemaVersion(ctx context.Context, id string, schema *entity.SchemaEntity) error {
	if schema == nil {
		logger.Errorf("Datastore: PutSchemaVersion(): schema version is nil")
		return nil
	}
	key := getSchemaVerKey(id)
	if _, err := d.Client.Put(ctx, key, schema); err != nil {
		logger.Errorf("Datastore: PutSchemaVersion(): error during entity saving, err: %s\n", err.Error())
		return err
	}
	return nil
}

// PutSDKs puts the SDK entity to datastore
func (d *Datastore) PutSDKs(ctx context.Context, sdks []*entity.SDKEntity) error {
	if sdks == nil || len(sdks) == 0 {
		logger.Errorf("Datastore: PutSDKs(): sdks are empty")
		return nil
	}
	var keys []*datastore.Key
	for _, sdk := range sdks {
		keys = append(keys, getSdkKey(sdk.Name))
	}
	if _, err := d.Client.PutMulti(ctx, keys, sdks); err != nil {
		logger.Errorf("Datastore: PutSDK(): error during entity saving, err: %s\n", err.Error())
		return err
	}
	return nil
}

//GetFiles returns the file entities by a snippet identifier
func (d *Datastore) GetFiles(ctx context.Context, snipId string, numberOfFiles int) ([]*entity.FileEntity, error) {
	if numberOfFiles == 0 {
		logger.Errorf("The number of files must be more than zero")
		return []*entity.FileEntity{}, nil
	}
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("Datastore: GetFiles(): error during the transaction creating, err: %s\n", err.Error())
		return nil, err
	}
	var fileKeys []*datastore.Key
	for fileIndx := 0; fileIndx < numberOfFiles; fileIndx++ {
		fileKeys = append(fileKeys, getFileKey(fmt.Sprintf("%s_%d", snipId, fileIndx)))
	}
	var files = make([]*entity.FileEntity, numberOfFiles)
	if err = tx.GetMulti(fileKeys, files); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: GetFiles(): error during file getting, err: %s\n", err.Error())
		return nil, err
	}
	if _, err = tx.Commit(); err != nil {
		logger.Errorf("Datastore: GetFiles(): error during the transaction committing, err: %s\n", err.Error())
		return nil, err
	}
	return files, nil
}

//GetSDKs returns sdk entities by an identifier
func (d *Datastore) GetSDKs(ctx context.Context) ([]*entity.SDKEntity, error) {
	var sdkKeys []*datastore.Key
	for sdkName := range pb.Sdk_value {
		if sdkName != pb.Sdk_SDK_UNSPECIFIED.String() {
			sdkKeys = append(sdkKeys, getSdkKey(sdkName))
		}
	}
	var sdks = make([]*entity.SDKEntity, len(sdkKeys))
	if err := d.Client.GetMulti(ctx, sdkKeys, sdks); err != nil {
		logger.Errorf("Datastore: GetSDKs(): error during the getting sdks, err: %s\n", err.Error())
		return nil, err
	}
	for sdkIndex, sdk := range sdks {
		sdk.Name = sdkKeys[sdkIndex].Name
	}
	return sdks, nil
}

//GetCatalog returns all examples
func (d *Datastore) GetCatalog(ctx context.Context, sdkCatalog []*entity.SDKEntity) ([]*pb.Categories, error) {
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("Datastore: GetCatalog(): error during the transaction creating, err: %s\n", err.Error())
		return nil, err
	}
	exampleQuery := datastore.NewQuery(ExampleKind).Namespace(Namespace).Transaction(tx)
	//Retrieving examples
	var examples []*entity.ExampleEntity
	exampleKeys, err := d.Client.GetAll(ctx, exampleQuery, &examples)
	if err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: GetCatalog(): error during the getting examples, err: %s\n", err.Error())
		return nil, err
	}

	//Retrieving snippets
	var snippetKeys []*datastore.Key
	for _, exampleKey := range exampleKeys {
		snippetKeys = append(snippetKeys, getSnippetKey(exampleKey.Name))
	}
	snippets := make([]*entity.SnippetEntity, len(snippetKeys))
	if err = tx.GetMulti(snippetKeys, snippets); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: GetCatalog(): error during the getting snippets, err: %s\n", err.Error())
		return nil, err
	}

	//Retrieving files
	var fileKeys []*datastore.Key
	for snpIndx, snippet := range snippets {
		for fileIndx := 0; fileIndx < snippet.NumberOfFiles; fileIndx++ {
			fileKey := getFileKey(fmt.Sprintf("%s_%d", exampleKeys[snpIndx].Name, fileIndx))
			fileKeys = append(fileKeys, fileKey)
		}
	}
	files := make([]*entity.FileEntity, len(fileKeys))
	if err = tx.GetMulti(fileKeys, files); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("Datastore: GetCatalog(): error during the getting files, err: %s\n", err.Error())
		return nil, err
	}

	return d.ResponseMapper.ToArrayCategories(&dto.CatalogDTO{
		Examples:   examples,
		Snippets:   snippets,
		Files:      files,
		SdkCatalog: sdkCatalog,
	}, ""), nil
}

//GetDefaultExamples returns the default examples
func (d *Datastore) GetDefaultExamples(ctx context.Context, sdks []*entity.SDKEntity) (map[pb.Sdk]*pb.PrecompiledObject, error) {
	var exampleKeys []*datastore.Key
	for _, sdk := range sdks {
		exampleKeys = append(exampleKeys, getExampleKey(fmt.Sprintf("%s_%s", sdk.Name, sdk.DefaultExample)))
	}
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("error during the transaction creating, err: %s\n", err.Error())
		return nil, err
	}
	//Retrieving examples
	var examplesWithNils = make([]*entity.ExampleEntity, len(exampleKeys))
	if err = tx.GetMulti(exampleKeys, examplesWithNils); err != nil {
		if errors, ok := err.(datastore.MultiError); ok {
			for _, errVal := range errors {
				if errVal == datastore.ErrNoSuchEntity {
					goto outsideExamples
				}
			}
		}
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during the getting default examples, err: %s\n", err.Error())
		return nil, err
	}
outsideExamples:
	examples := make([]*entity.ExampleEntity, 0)
	for _, exampleVal := range examplesWithNils {
		if exampleVal != nil {
			examples = append(examples, exampleVal)
		}
	}
	//Retrieving snippets
	var snippetKeys []*datastore.Key
	for _, exampleKey := range exampleKeys {
		snippetKeys = append(snippetKeys, getSnippetKey(exampleKey.Name))
	}
	snippetsWithNils := make([]*entity.SnippetEntity, len(snippetKeys))
	if err = tx.GetMulti(snippetKeys, snippetsWithNils); err != nil {
		if errors, ok := err.(datastore.MultiError); ok {
			for _, errVal := range errors {
				if errVal == datastore.ErrNoSuchEntity {
					goto outsideSnippets
				}
			}
		}
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during the getting snippets, err: %s\n", err.Error())
		return nil, err
	}
outsideSnippets:
	snippets := make([]*entity.SnippetEntity, 0)
	for _, snipVal := range snippetsWithNils {
		if snipVal != nil {
			snippets = append(snippets, snipVal)
		}
	}

	//Retrieving files
	var fileKeys []*datastore.Key
	for snpIndx, snippet := range snippets {
		for fileIndx := 0; fileIndx < snippet.NumberOfFiles; fileIndx++ {
			fileKey := getFileKey(fmt.Sprintf("%s_%s_%d", examples[snpIndx].Sdk.Name, examples[snpIndx].Name, fileIndx))
			fileKeys = append(fileKeys, fileKey)
		}
	}
	files := make([]*entity.FileEntity, len(fileKeys))
	if err = tx.GetMulti(fileKeys, files); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during the getting files, err: %s\n", err.Error())
		return nil, err
	}

	return d.ResponseMapper.ToDefaultPrecompiledObjects(&dto.DefaultExamplesDTO{
		Examples: examples,
		Snippets: snippets,
		Files:    files,
	}), nil
}

func (d *Datastore) GetExample(ctx context.Context, id string, sdks []*entity.SDKEntity) (*pb.PrecompiledObject, error) {
	exampleKey := getExampleKey(id)
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("error during the transaction creating, err: %s\n", err.Error())
		return nil, err
	}

	var example = new(entity.ExampleEntity)
	if err = tx.Get(exampleKey, example); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting example by identifier, err: %s", err.Error())
		return nil, err
	}

	snpKey := getSnippetKey(id)
	var snippet = new(entity.SnippetEntity)
	if err = tx.Get(snpKey, snippet); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting snippet by identifier, err: %s", err.Error())
		return nil, err
	}

	fileKey := getFileKey(fmt.Sprintf("%s_%d", id, 0))
	var file = new(entity.FileEntity)
	if err = tx.Get(fileKey, file); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting file by identifier, err: %s", err.Error())
		return nil, err
	}

	sdkToExample := make(map[string]string)
	for _, sdk := range sdks {
		sdkToExample[sdk.Name] = sdk.DefaultExample
	}

	return d.ResponseMapper.ToPrecompiledObj(&dto.ExampleDTO{
		Example:            example,
		Snippet:            snippet,
		Files:              []*entity.FileEntity{file},
		DefaultExampleName: sdkToExample[example.Sdk.Name],
	}), err
}

func (d *Datastore) GetExampleCode(ctx context.Context, id string) (string, error) {
	fileKey := getFileKey(fmt.Sprintf("%s_%d", id, 0))
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("error during the transaction creating, err: %s\n", err.Error())
		return "", err
	}
	var file = new(entity.FileEntity)
	if err = tx.Get(fileKey, file); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting file by identifier, err: %s", err.Error())
		return "", err
	}
	return file.Content, nil
}

func (d *Datastore) GetExampleOutput(ctx context.Context, id string) (string, error) {
	pcObjKey := getPCObjectKey(fmt.Sprintf("%s_%s", id, "OUTPUT"))
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("error during the transaction creating, err: %s\n", err.Error())
		return "", err
	}
	var pcObj = new(entity.PrecompiledObjectEntity)
	if err = tx.Get(pcObjKey, pcObj); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting example output by identifier, err: %s", err.Error())
		return "", err
	}
	return pcObj.Content, nil
}

func (d *Datastore) GetExampleLogs(ctx context.Context, id string) (string, error) {
	pcObjKey := getPCObjectKey(fmt.Sprintf("%s_%s", id, "LOG"))
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("error during the transaction creating, err: %s\n", err.Error())
		return "", err
	}
	var pcObj = new(entity.PrecompiledObjectEntity)
	if err = tx.Get(pcObjKey, pcObj); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting example logs by identifier, err: %s", err.Error())
		return "", err
	}
	return pcObj.Content, nil
}

func (d *Datastore) GetExampleGraph(ctx context.Context, id string) (string, error) {
	pcObjKey := getPCObjectKey(fmt.Sprintf("%s_%s", id, "GRAPH"))
	tx, err := d.Client.NewTransaction(ctx, datastore.ReadOnly)
	if err != nil {
		logger.Errorf("error during the transaction creating, err: %s\n", err.Error())
		return "", err
	}
	var pcObj = new(entity.PrecompiledObjectEntity)
	if err = tx.Get(pcObjKey, pcObj); err != nil {
		if rollBackErr := tx.Rollback(); rollBackErr != nil {
			err = rollBackErr
		}
		logger.Errorf("error during getting example graph by identifier, err: %s", err.Error())
		return "", err
	}
	return pcObj.Content, nil
}

func getExampleKey(id string) *datastore.Key {
	return getNameKey(ExampleKind, id, Namespace, nil)
}

func getSdkKey(id string) *datastore.Key {
	return getNameKey(SdkKind, id, Namespace, nil)
}

func getFileKey(id string) *datastore.Key {
	return getNameKey(FileKind, id, Namespace, nil)
}

func getSchemaVerKey(id string) *datastore.Key {
	return getNameKey(SchemaKind, id, Namespace, nil)
}

func getSnippetKey(id string) *datastore.Key {
	return getNameKey(SnippetKind, id, Namespace, nil)
}

func getPCObjectKey(id string) *datastore.Key {
	return getNameKey(PCObjectKind, id, Namespace, nil)
}

// GetNameKey returns the datastore key
func getNameKey(kind, id, namespace string, parentId *datastore.Key) *datastore.Key {
	key := datastore.NameKey(kind, id, nil)
	if parentId != nil {
		key.Parent = parentId
	}
	key.Namespace = namespace
	return key
}

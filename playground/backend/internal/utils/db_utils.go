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

package utils

import (
	"crypto/sha256"
	"encoding/base64"
	"fmt"
	"io"
	"strings"

	"cloud.google.com/go/datastore"

	"beam.apache.org/playground/backend/internal/constants"
	"beam.apache.org/playground/backend/internal/errors"
	"beam.apache.org/playground/backend/internal/logger"
)

func ID(salt, content string, length int8) (string, error) {
	hash := sha256.New()
	if _, err := io.WriteString(hash, salt); err != nil {
		logger.Errorf("ID(): error during K generation: %s", err.Error())
		return "", errors.InternalError("Error during K generation", "Error writing K and salt")
	}
	hash.Write([]byte(content))
	sum := hash.Sum(nil)
	b := make([]byte, base64.URLEncoding.EncodedLen(len(sum)))
	base64.URLEncoding.Encode(b, sum)
	hashLen := int(length)
	for hashLen <= len(b) && b[hashLen-1] == '_' {
		hashLen++
	}
	return string(b)[:hashLen], nil
}

func GetExampleKey(id string) *datastore.Key {
	return getNameKey(constants.ExampleKind, id, constants.Namespace, nil)
}

func GetSdkKey(id string) *datastore.Key {
	return getNameKey(constants.SdkKind, id, constants.Namespace, nil)
}

func GetFileKey(id string) *datastore.Key {
	return getNameKey(constants.FileKind, id, constants.Namespace, nil)
}

func GetSchemaVerKey(id string) *datastore.Key {
	return getNameKey(constants.SchemaKind, id, constants.Namespace, nil)
}

func GetSnippetKey(id string) *datastore.Key {
	return getNameKey(constants.SnippetKind, id, constants.Namespace, nil)
}

func GetPCObjectKey(id string) *datastore.Key {
	return getNameKey(constants.PCObjectKind, id, constants.Namespace, nil)
}

func GetExampleID(cloudPath string) (string, error) {
	cloudPathParams := strings.Split(cloudPath, constants.CloudPathDelimiter)
	if len(cloudPathParams) < 3 {
		logger.Error("the wrong cloud path from a client")
		return "", fmt.Errorf("cloud path doesn't have all options. The minimum size must be 3")
	}
	return fmt.Sprintf("%s%s%s", cloudPathParams[0], constants.IDDelimiter, cloudPathParams[2]), nil
}

// getNameKey returns the datastore key
func getNameKey(kind, id, namespace string, parentId *datastore.Key) *datastore.Key {
	key := datastore.NameKey(kind, id, nil)
	if parentId != nil {
		key.Parent = parentId
	}
	key.Namespace = namespace
	return key
}

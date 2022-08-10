/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.cdap.plugin.zuora.restobjects;

import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Entity meta-info holder for {@link ObjectDefinition}.
 */
public class ObjectInfo {
  private String cdapObjectName;

  private String restAPIUrl;
  private Class<?> objectClass;
  private List<ObjectFieldInfo> fieldDefinitions;
  private List<String> requiredArguments;
  private List<String> requiredPostArguments;
  private ObjectDefinition.ObjectDefinitionType objectType;
  private String responseRootElement;

  /**
   * Constructor for ObjectInfo object.
   * @param cdapObjectName the cdap object name
   * @param fieldDefinitions the field definitions
   * @param restAPIUrl the result api url
   * @param objectClass the object class
   * @param requiredArguments required arguments
   * @param requiredPostArguments required post arguments
   * @param responseRootElement response root element
   * @param objectType object type
   */
  public ObjectInfo(String cdapObjectName, List<ObjectFieldInfo> fieldDefinitions, String restAPIUrl,
                    Class<?> objectClass, List<String> requiredArguments, List<String> requiredPostArguments,
                    String responseRootElement, ObjectDefinition.ObjectDefinitionType objectType) {
    this.cdapObjectName = cdapObjectName;
    this.fieldDefinitions = fieldDefinitions;
    this.restAPIUrl = restAPIUrl;
    this.objectClass = objectClass;
    this.requiredArguments = requiredArguments;
    this.requiredPostArguments = requiredPostArguments;
    this.objectType = objectType;
    this.responseRootElement = responseRootElement;
  }

  public String getCdapObjectName() {
    return cdapObjectName;
  }

  public String getRestAPIUrl() {
    return restAPIUrl;
  }

  public List<ObjectFieldInfo> getFieldDefinitions() {
    return fieldDefinitions;
  }

  /**
   * Returns the list of ObjectFieldInfo.
   * @param fields
   * @return list of ObjectFieldInfo
   */
  public List<ObjectFieldInfo> getFieldsDefinitions(List<String> fields) {
    return fieldDefinitions.stream()
      .filter(x -> fields.stream().anyMatch(y -> x.getName().equals(y)))
      .collect(Collectors.toList());
  }

  public Class<?> getObjectClass() {
    return objectClass;
  }

  public List<String> getRequiredArguments() {
    return requiredArguments.stream().filter(x -> !x.equals("")).collect(Collectors.toList());
  }

  public List<String> getRequiredPostArguments() {
    return requiredPostArguments.stream().filter(x -> !x.equals("")).collect(Collectors.toList());
  }

  public ObjectDefinition.ObjectDefinitionType getObjectType() {
    return objectType;
  }

  public String getResponseRootElement() {
    return responseRootElement;
  }
}

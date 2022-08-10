/*
 *  Copyright © 2020 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.cdap.plugin.zuora.client.schema;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cdap.plugin.zuora.restobjects.objects.Pair;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;

/**
 * Data transformer from swagger.
 */
@SuppressWarnings({"DefaultCharset", "StringSplitter"})
public class SwaggerTransformer {
  private static boolean topLevelObjects = false;  // process only top-level objects and ignore nested
  private static Gson gson = new GsonBuilder().create();

  private JsonObject rawObjects;
  private JsonObject rawPaths;
  private JsonObject newDocument;
  private JsonArray objectsArray = new JsonArray();
  private Map<String, String> objectMapping;
  private Map<String, Pair<String, List<String>>> paths;

  /**
   * Constructor for SwaggerTransformer object.
   * @param uri the uri
   * @throws IOException in case if resource not found
   */
  public SwaggerTransformer(Path uri) throws IOException {
    String jsonData = new String(Files.readAllBytes(uri));
    JsonParser parser = new JsonParser();

    JsonObject document = parser.parse(jsonData).getAsJsonObject();
    rawObjects = document.getAsJsonObject("definitions");
    rawPaths = document.getAsJsonObject("paths");
    objectMapping = new HashMap<>();
  }

  private JsonArray transformElement(String name, JsonElement rootObject) {
    JsonElement allOf = rootObject.getAsJsonObject().get("allOf");

    if (allOf != null) {
      JsonArray array = (JsonArray) allOf;
      for (JsonElement arrayItem: array) {
        if (arrayItem.getAsJsonObject().get("properties") != null) {
          return transformElement(name, arrayItem);
        }
      }
    }
    JsonElement properties = rootObject.getAsJsonObject().get("properties");
    JsonArray jsonFields = new JsonArray();

    if (properties != null) {
      properties.getAsJsonObject().entrySet().forEach(x -> {
        JsonElement field = addField(name, x.getKey(), x.getValue());
        if (field != null) {
          jsonFields.add(field);
        }
      });
    }
    return jsonFields;
  }

  /**
   * Add resolved object to the list of objects.
   * @param name name of the object
   * @param fields fields of the object
   * @param onlyIfWithPath  add only object with the rest api path notation
   */
  private void addObject(String name, JsonElement fields, boolean onlyIfWithPath) {
    JsonObject el = new JsonObject();
    String objectName = getObjectName(name);

    JsonArray jsonFields = transformElement(objectName, fields);

    Spliterator<JsonElement> spliterator = Spliterators.spliterator(jsonFields.iterator(), jsonFields.size(), 0);
    List<JsonObject> fieldNames = StreamSupport.stream(spliterator, true)
      .map(JsonElement::getAsJsonObject)
      .collect(Collectors.toList());

    boolean isTransitiveObject = fieldNames.stream()
      .map(x -> x.get("name").getAsString())
      .anyMatch(x -> x.equals("nextPage") || x.equals("success"));

    if (isTransitiveObject) {
      List<JsonObject> filteredFields = fieldNames.stream()
        .filter(x -> !x.get("name").getAsString().equals("nextPage") && !x.get("name").getAsString().equals("success"))
        .collect(Collectors.toList());

      if (filteredFields.size() == 1) {
        String newType = filteredFields.get(0).get("subtype").getAsString();
        objectMapping.put(name, newType);

        if (paths.containsKey(objectName)) {  // copy meta info for the mapped object
          paths.put(newType, paths.get(objectName));
        }
        return;
      }
    }

    JsonObject fieldsObject = new JsonObject();
    fieldsObject.addProperty("name", objectName);
    fieldsObject.addProperty("label", objectName);
    fieldsObject.add("relatedObjects", new JsonArray());
    fieldsObject.add("fields", jsonFields);

    if (paths.containsKey(objectName)) {
      Pair<String, List<String>> objectMeta = paths.get(objectName);
      fieldsObject.addProperty("api", objectMeta.getKey());
      fieldsObject.addProperty("requiredFields", objectMeta.getValue().stream()
        .map(x -> String.format("\"%s\"", x))
        .collect(Collectors.joining(","))
      );
    } else if (onlyIfWithPath) {
      return;
    }

    el.addProperty("name", objectName);
    el.addProperty("label", objectName);
    el.addProperty("href",  fieldsObject.toString());

    objectsArray.add(el);
  }

  @Nullable
  private JsonElement addField(String parentName, String name, JsonElement field) {
    JsonObject props = field.getAsJsonObject();
    String fieldDescription = "";

    if (props.get("type") == null) {
      return null;
    }
    if (props.get("description") != null) {
      fieldDescription = props.get("description").getAsString();
    }

    JsonObject newField = new JsonObject();
    String fieldType = props.get("type").getAsString();
    String subType = fieldType;

    if (fieldType.equals("object")) {
      fieldType = String.format("%s%sItem", parentName, getObjectName(name));
      if (objectMapping.containsKey(fieldType)) {
        fieldType = objectMapping.get(fieldType);
      }
      subType = fieldType;
      addObject(fieldType, field, topLevelObjects);
    }

    if (fieldType.equals("array")) {
      if (!field.getAsJsonObject().get("items").getAsJsonObject().has("$ref")) {
        subType = String.format("%s%sItem", parentName, getObjectName(name));
        if (objectMapping.containsKey(subType)) {
          subType = objectMapping.get(subType);
        }
        fieldType = "array|" + subType;
        addObject(subType, field.getAsJsonObject().get("items"), topLevelObjects);
      } else {
        String [] refPath = field.getAsJsonObject().get("items").getAsJsonObject().get("$ref").getAsString().split("/");
        subType = getObjectName(refPath[refPath.length - 1]);
        if (objectMapping.containsKey(subType)) {
          subType = objectMapping.get(subType);
        }
        fieldType = String.format("array|%s", subType);
      }
    }

    newField.addProperty("name", name);
    newField.addProperty("label", name);
    newField.addProperty("selectable", false);
    newField.addProperty("creatable", false);
    newField.addProperty("updatable", false);
    newField.addProperty("filterable", false);
    newField.addProperty("custom", false);
    newField.addProperty("maxlength", 0);
    newField.addProperty("required", false);
    newField.addProperty("description", fieldDescription);
    newField.addProperty("type", fieldType);
    newField.addProperty("subtype", subType);

    return newField;
  }

  private String getJavaName(String name) {
    char[] c = name.toCharArray();
    c[0] = Character.toUpperCase(c[0]);
    return new String(c);
  }

  private String getObjectName(String objectName) {
    if (objectName.length() >= 4 && objectName.substring(0, 3).equalsIgnoreCase("GET")) {
      objectName = objectName.substring(3);
    }
    return getJavaName(objectName);
  }

  private void parsePaths() {
    paths = new HashMap<>();
    rawPaths.entrySet().forEach(x -> {
      String path = x.getKey();
      if (!path.contains("/v1")) {
        return;
      }
      String[] pathChunks = path.split("/v1/");
      path = pathChunks[pathChunks.length - 1];
      JsonObject pathObject = x.getValue().getAsJsonObject();
      JsonElement reqType = pathObject.get("post");
      if (reqType == null) {
        return;
      }

      JsonArray parameters = reqType.getAsJsonObject().getAsJsonArray("parameters");
      String schemaName;

      try {
        schemaName = reqType.getAsJsonObject()
          .get("responses").getAsJsonObject()
          .get("200").getAsJsonObject()
          .get("schema").getAsJsonObject()
          .get("$ref").getAsString();
      } catch (NullPointerException e) {
        // no interest in api endpoint without schema assigned
        return;
      }

      String[] schemaNameArr = schemaName.split("/");
      schemaName = getObjectName(schemaNameArr[schemaNameArr.length - 1]);
      List<String> arguments = new ArrayList<>();

      parameters.forEach(y -> {
        JsonElement argName = y.getAsJsonObject().get("name");
        if (argName == null) {
          return;
        }

        JsonElement requiredEl = y.getAsJsonObject().get("required");
        boolean required = (requiredEl != null) && requiredEl.getAsBoolean();

        if (required) {
          arguments.add(argName.getAsString());
        }
      });
      paths.put(schemaName, new Pair<>(path, arguments));
    });
  }

  /**
   * Retrieves definition of the objects.
   * @param onlyWithPath only objects with rest api endpoint and all their children
   */
  public ZuoraDefinitions getDefinitions(boolean onlyWithPath) {
    if (newDocument != null) {
      return gson.fromJson(newDocument.toString(), ZuoraDefinitions.class);
    }

    parsePaths();

    newDocument = new JsonObject();
    objectMapping.clear();
    rawObjects.entrySet().forEach(e -> {
      addObject(e.getKey(), e.getValue(), onlyWithPath || topLevelObjects);
    });

    newDocument.addProperty("isSwagger", true);
    newDocument.add("objects", objectsArray);

    System.out.println("Base objects: " + String.join(", ", paths.keySet()));

    return gson.fromJson(newDocument.toString(), ZuoraDefinitions.class);
  }
}

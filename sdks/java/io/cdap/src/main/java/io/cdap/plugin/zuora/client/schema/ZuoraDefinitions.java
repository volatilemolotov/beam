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
import com.google.gson.annotations.SerializedName;
import io.cdap.plugin.zuora.client.ZuoraRestClient;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Base XML document which describing Zuora Objects.
 */
@SuppressWarnings("DefaultCharset")
@XmlRootElement(name = "objects")
public class ZuoraDefinitions {
  private static Gson gson = new GsonBuilder().create();

  @XmlElement(name = "object")
  @SerializedName("objects")
  private List<ZuoraObjectDefinition> objects;

  @XmlTransient
  @SerializedName("isSwagger")
  private boolean isSwagger;

  public List<ZuoraObjectDefinition> getObjects() {
    return objects;
  }

  /**
   * Just creating dump objects to directory.
   * @param client the zuora rest client
   * @param path the path
   */
  public void dumpToDirectory(ZuoraRestClient client, final String path) {
    System.out.println("Dumping objects:");
    getObjects().forEach(x -> {
      try {
        ZuoraObjectSchema schema = (isSwagger)
          ? gson.fromJson(x.getHref(), ZuoraObjectSchema.class)
          : client.getObjectSchema(x.getName());


        File file = new File(String.format("%s\\%s.java", path, x.getName()));
        try (PrintWriter printWriter = new PrintWriter(file)) {
          printWriter.println("package io.cdap.plugin.zuora.objects;");
          printWriter.println();
          printWriter.println("import com.google.gson.annotations.SerializedName;");
          printWriter.println("import io.cdap.cdap.api.data.schema.Schema;");
          printWriter.println("import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;");
          printWriter.println("import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;");
          printWriter.println("import io.cdap.plugin.zuora.restobjects.objects.BaseObject;");
          printWriter.println();
          if (schema.hasListFields()) {
            printWriter.println("import java.util.List;");
          }
          printWriter.println();
          printWriter.println("import javax.annotation.Nullable;");
          printWriter.println();
          printWriter.print(schema.toString());
        }
        System.out.println(schema.getLabel());
      } catch (JAXBException | IOException e) {
        // no-op
      }
    });
  }
}

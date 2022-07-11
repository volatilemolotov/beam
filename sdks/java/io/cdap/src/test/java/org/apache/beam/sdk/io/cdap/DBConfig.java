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
package org.apache.beam.sdk.io.cdap;

import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.common.ReferencePluginConfig;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link io.cdap.cdap.api.plugin.PluginConfig} for {@link DBBatchSource} and {@link DBBatchSink}
 * CDAP plugins. Used to test {@link CdapIO#read()} and {@link CdapIO#write()}.
 */
public class DBConfig extends ReferencePluginConfig {

  public static final String DB_URL = "dbUrl";
  public static final String POSTGRES_USERNAME = "pgUsername";
  public static final String POSTGRES_PASSWORD = "pgPassword";

  @Name(DB_URL)
  @Macro
  public String dbUrl;

  @Name(DB_URL)
  @Macro
  public String pgUsername;

  @Name(DB_URL)
  @Macro
  public String pgPassword;

  public DBConfig(String dbUrl, String pgUsername, String pgPassword, String referenceName) {
    super(referenceName);
    this.dbUrl = dbUrl;
    this.pgUsername = pgUsername;
    this.pgPassword = pgPassword;
  }

  public Schema getSchema() {
    Set<Schema.Field> schemaFields = new HashSet<>();
    schemaFields.add(Schema.Field.of("id", Schema.nullableOf(Schema.of(Schema.Type.STRING))));
    schemaFields.add(Schema.Field.of("name", Schema.nullableOf(Schema.of(Schema.Type.STRING))));
    return Schema.recordOf("etlSchemaBody", schemaFields);
  }

  public void validate(FailureCollector failureCollector) {
    if (dbUrl == null) {
      failureCollector.addFailure("DB URL must be not null.", null).withConfigProperty(DB_URL);
    }
    if (pgUsername == null) {
      failureCollector
          .addFailure("Postgres username must be not null.", null)
          .withConfigProperty(POSTGRES_USERNAME);
    }
    if (pgPassword == null) {
      failureCollector
          .addFailure("Postgres password must be not null.", null)
          .withConfigProperty(POSTGRES_PASSWORD);
    }
  }
}

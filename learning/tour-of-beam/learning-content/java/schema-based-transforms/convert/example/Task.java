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
/*
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// beam-playground:
//   name: convert
//   description: Convert example.
//   multifile: false
//   context_line: 46
//   categories:
//     - Quickstart
//   complexity: ADVANCED
//   tags:
//     - hellobeam

import lombok.EqualsAndHashCode;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaCreate;
import org.apache.beam.sdk.schemas.transforms.Convert;
import org.apache.beam.sdk.schemas.transforms.RenameFields;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test {
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    @DefaultSchema(JavaFieldSchema.class)
    @EqualsAndHashCode
    public static class Game {
        public String userId;
        public Integer score;
        public String gameId;
        public String date;

        @SchemaCreate
        public Game(String userId, Integer score, String gameId, String date) {
            this.userId = userId;
            this.score = score;
            this.gameId = gameId;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "userId='" + userId + '\'' +
                    ", score='" + score + '\'' +
                    ", gameId='" + gameId + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    // User schema
    @DefaultSchema(JavaFieldSchema.class)
    @EqualsAndHashCode
    public static class User {

        public String userId;
        public String userName;
        public Game game;

        @SchemaCreate
        public User(String userId, String userName
                , Game game
        ) {
            this.userId = userId;
            this.userName = userName;
            this.game = game;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userId='" + userId + '\'' +
                    ", userName='" + userName + '\'' +
                    ", game=" + game +
                    '}';
        }
    }

    @DefaultSchema(JavaFieldSchema.class)
    @EqualsAndHashCode
    public static class Result {

        public String userId;
        public String userName;
        public Integer score;
        public String gameId;
        public String date;

        @SchemaCreate
        public Result(String userId, String userName, Integer score, String gameId, String date) {
            this.userId = userId;
            this.userName = userName;
            this.score = score;
            this.gameId = gameId;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "userId='" + userId + '\'' +
                    ", userName='" + userName + '\'' +
                    ", score=" + score +
                    ", gameId='" + gameId + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();
        Pipeline pipeline = Pipeline.create(options);

        PCollection<User> fullStatistics = getProgressPCollection(pipeline);

        Schema type = Schema.builder()
                .addStringField("userId")
                .addStringField("userName")
                .addInt32Field("score")
                .addStringField("gameId")
                .addStringField("date")
                .build();

        PCollection<Object> pCollection = fullStatistics
                .apply(MapElements.into(TypeDescriptor.of(Object.class)).via(it -> it))
                .setSchema(type,
                        TypeDescriptor.of(Object.class), input ->
                        {
                            User user = (User) input;
                            return Row.withSchema(type)
                                    .addValues(user.userId, user.userName, user.game.score, user.game.gameId, user.game.date)
                                    .build();
                        },
                        input -> new User(input.getString(0), input.getString(1),
                                new Game(input.getString(0), input.getInt32(2), input.getString(3), input.getString(4))));

        pCollection
                .apply(Convert.toRows())
                .apply("User", ParDo.of(new LogOutput<>("ToRows")));

        pCollection
                .apply(Convert.to(Result.class))
                .apply("User", ParDo.of(new LogOutput<>("Convert to Result")));


        pipeline.run();
    }

    public static PCollection<User> getProgressPCollection(Pipeline pipeline) {
        PCollection<String> rides = pipeline.apply(TextIO.read().from("gs://apache-beam-samples/game/small/gaming_data.csv"));
        final PTransform<PCollection<String>, PCollection<Iterable<String>>> sample = Sample.fixedSizeGlobally(10);
        return rides.apply(sample).apply(Flatten.iterables()).apply(ParDo.of(new ExtractUserProgressFn()));
    }

    static class ExtractUserProgressFn extends DoFn<String, User> {
        @ProcessElement
        public void processElement(ProcessContext c) {
            String[] items = c.element().split(",");
            c.output(new User(items[0], items[1], new Game(items[0], Integer.valueOf(items[2]), items[3], items[4])
            ));
        }
    }

    static class LogOutput<T> extends DoFn<T, T> {

        private final String prefix;

        LogOutput() {
            this.prefix = "Processing element";
        }

        LogOutput(String prefix) {
            this.prefix = prefix;
        }

        @ProcessElement
        public void processElement(ProcessContext c) throws Exception {
            LOG.info(prefix + ": {}", c.element());
        }
    }
}

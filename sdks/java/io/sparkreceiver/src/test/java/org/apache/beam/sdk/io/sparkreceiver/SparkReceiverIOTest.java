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
package org.apache.beam.sdk.io.sparkreceiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.apache.beam.runners.direct.DirectOptions;
import org.apache.beam.runners.direct.DirectRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test class for {@link SparkReceiverIO}. */
@RunWith(JUnit4.class)
public class SparkReceiverIOTest {

  @Test
  public void testReadBuildsCorrectly() {
    ReceiverBuilder<String, CustomReceiverWithoutOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithoutOffset.class).withConstructorArgs();
    SerializableFunction<String, Long> offsetFn = Long::valueOf;
    CustomSparkConsumer<String> sparkConsumer = new CustomSparkConsumer<>();

    SparkReceiverIO.Read<String> read =
        SparkReceiverIO.<String>read()
            .withSparkConsumer(sparkConsumer)
            .withValueClass(String.class)
            .withGetOffsetFn(offsetFn)
            .withSparkReceiverBuilder(receiverBuilder);

    assertEquals(sparkConsumer, read.getSparkConsumer());
    assertEquals(offsetFn, read.getGetOffsetFn());
    assertEquals(receiverBuilder, read.getSparkReceiverBuilder());
    assertEquals(String.class, read.getValueClass());
  }

  @Test
  public void testReadObjectCreationFailsIfReceiverBuilderIsNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> SparkReceiverIO.<String>read().withSparkReceiverBuilder(null));
  }

  @Test
  public void testReadObjectCreationFailsIfGetOffsetFnIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> SparkReceiverIO.<String>read().withGetOffsetFn(null));
  }

  @Test
  public void testReadObjectCreationFailsIfSparkConsumerIsNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> SparkReceiverIO.<String>read().withSparkConsumer(null));
  }

  @Test
  public void testReadObjectCreationFailsIfValueClassIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> SparkReceiverIO.<String>read().withValueClass(null));
  }

  @Test
  public void testReadValidationFailsMissingReceiverBuilder() {
    SparkReceiverIO.Read<String> read = SparkReceiverIO.read();
    assertThrows(IllegalStateException.class, read::validateTransform);
  }

  @Test
  public void testReadValidationFailsMissingSparkConsumer() {
    ReceiverBuilder<String, CustomReceiverWithOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> read =
        SparkReceiverIO.<String>read().withSparkReceiverBuilder(receiverBuilder);
    assertThrows(IllegalStateException.class, read::validateTransform);
  }
  @Test
  public void testReadFromCustomReceiverWithOffset() {
    DirectOptions options = PipelineOptionsFactory.as(DirectOptions.class);
    options.setBlockOnRun(false);
    options.setRunner(DirectRunner.class);
    Pipeline p = Pipeline.create(options);

    ReceiverBuilder<String, CustomReceiverWithOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> reader =
        SparkReceiverIO.<String>read()
            .withValueClass(String.class)
            .withGetOffsetFn(Long::valueOf)
            .withSparkReceiverBuilder(receiverBuilder);

    PCollection<String> output = p.apply(reader).setCoder(StringUtf8Coder.of());
    PAssert.that(output).empty();
    p.run().waitUntilFinish(Duration.standardSeconds(10));
  }

  @Test
  public void testReadFromCustomReceiverWithoutOffset() {
    DirectOptions options = PipelineOptionsFactory.as(DirectOptions.class);
    options.setBlockOnRun(false);
    options.setRunner(DirectRunner.class);
    Pipeline p = Pipeline.create(options);

    ReceiverBuilder<String, CustomReceiverWithoutOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithoutOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> reader =
        SparkReceiverIO.<String>read()
            .withValueClass(String.class)
            .withGetOffsetFn(Long::valueOf)
            .withSparkConsumer(new CustomSparkConsumer<>())
            .withSparkReceiverBuilder(receiverBuilder);

    PCollection<String> output = p.apply(reader).setCoder(StringUtf8Coder.of());
    PAssert.that(output).empty();
    p.run().waitUntilFinish(Duration.standardSeconds(10));
  }
}

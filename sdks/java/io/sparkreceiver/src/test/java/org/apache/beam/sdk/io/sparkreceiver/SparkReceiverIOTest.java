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

import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.joda.time.Duration;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test class for {@link SparkReceiverIO}. */
@RunWith(JUnit4.class)
public class SparkReceiverIOTest {

  @Rule public final transient TestPipeline p = TestPipeline.create();

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
            .withValueCoder(StringUtf8Coder.of())
            .withGetOffsetFn(offsetFn)
            .withSparkReceiverBuilder(receiverBuilder);

    assertEquals(sparkConsumer, read.getSparkConsumer());
    assertEquals(StringUtf8Coder.of(), read.getValueCoder());
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
  public void testReadObjectCreationFailsIfValueCoderIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> SparkReceiverIO.<String>read().withValueCoder(null));
  }

  @Test
  public void testReadObjectCreationFailsIfValueClassIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> SparkReceiverIO.<String>read().withValueClass(null));
  }

  @Test
  public void testReadValidationFailsMissingReceiverBuilder() {
    SparkReceiverIO.Read<String> read = SparkReceiverIO.read();
    assertThrows(IllegalArgumentException.class, read::validateTransform);
  }

  @Test
  public void testReadValidationFailsMissingSparkConsumer() {
    ReceiverBuilder<String, CustomReceiverWithOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> read =
        SparkReceiverIO.<String>read().withSparkReceiverBuilder(receiverBuilder);
    assertThrows(IllegalArgumentException.class, read::validateTransform);
  }

  @Test
  @Ignore
  public void testReadFromCustomReceiverWithOffset() {

    ReceiverBuilder<String, CustomReceiverWithOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> reader =
        SparkReceiverIO.<String>read()
            .withValueClass(String.class)
            .withValueCoder(StringUtf8Coder.of())
            .withGetOffsetFn(Long::valueOf)
            .withSparkReceiverBuilder(receiverBuilder);

    p.apply(reader).setCoder(StringUtf8Coder.of());
    p.run().waitUntilFinish(Duration.standardSeconds(30));
  }

  @Test
  @Ignore
  public void testReadFromCustomReceiverWithoutOffset() {

    ReceiverBuilder<String, CustomReceiverWithoutOffset> receiverBuilder =
        new ReceiverBuilder<>(CustomReceiverWithoutOffset.class).withConstructorArgs();
    SparkReceiverIO.Read<String> reader =
        SparkReceiverIO.<String>read()
            .withValueClass(String.class)
            .withValueCoder(StringUtf8Coder.of())
            .withGetOffsetFn(Long::valueOf)
            .withSparkConsumer(new CustomSparkConsumer<>())
            .withSparkReceiverBuilder(receiverBuilder);

    p.apply(reader).setCoder(StringUtf8Coder.of());
    p.run().waitUntilFinish(Duration.standardSeconds(30));
  }
}

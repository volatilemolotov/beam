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

import io.cdap.plugin.gcp.publisher.source.PubSubMessage;
import io.cdap.plugin.gcp.publisher.source.PubSubReceiver;
import io.cdap.plugin.gcp.publisher.source.PubSubSubscriberConfig;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.apache.commons.lang.ClassUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.collection.Iterator;
import scala.collection.mutable.ArrayBuffer;

/** Class for working with {@link Receiver}s with or without using Spark environment. */
@SuppressWarnings({"unchecked", "UnusedVariable"})
public class ProxyBuilder<X, T extends Receiver<X>> {

  private static final Logger LOG = LoggerFactory.getLogger(ProxyBuilder.class);
  private final Class<T> sparkReceiverClass;
  private Constructor<?> currentConstructor;
  private Object[] constructorArgs;

  public ProxyBuilder(Class<T> sparkReceiverClass) {
    this.sparkReceiverClass = sparkReceiverClass;
  }

  public ProxyBuilder<X, T> withConstructorArgs(Object... args) {
    for (Constructor<?> constructor : sparkReceiverClass.getConstructors()) {
      if (constructor.getParameterCount() == args.length) {
        boolean matches = true;
        for (int i = 0; i < args.length; i++) {
          Object arg = args[i];
          Class<?> currArgClass = constructor.getParameterTypes()[i];
          if (currArgClass.isPrimitive()) {
            currArgClass = ClassUtils.primitiveToWrapper(currArgClass);
          }
          if (!currArgClass.equals(arg.getClass())) {
            matches = false;
            break;
          }
        }
        if (matches) {
          currentConstructor = constructor;
          this.constructorArgs = args;
          return this;
        }
      }
    }
    throw new IllegalArgumentException("Can not find appropriate constructor for given args");
  }

  /**
   * @return Proxy for given {@param receiver} that doesn't use Spark environment and uses Apache
   *     Beam mechanisms instead.
   */
  public T build() throws Exception {

    T receiver = (T) currentConstructor.newInstance(constructorArgs);

    WrappedSupervisor wrappedSupervisor = new WrappedSupervisor(receiver, new SparkConf());

    MethodInterceptor handler =
        (obj, method, args, proxy) -> {
          if (method.getName().equals("supervisor")) {
            return wrappedSupervisor;
          } else if (method.getName().equals("_supervisor")) {
            return wrappedSupervisor;
          } else if (method.getName().equals("onStart")) {
            LOG.info("STARTED!!!!!!!");
            return null;
          } else if (method.getName().equals("stop")) {
            LOG.info("STOPED!!!!!!! message = " + args[0]);
            return null;
          } else if (method.getName().equals("store") && method.getParameterCount() == 1) {
            if (method.getParameterTypes()[0].equals(Iterator.class)) {
              Iterator<X> dataIterator = (Iterator<X>) args[0];
            } else if (method.getParameterTypes()[0].equals(java.util.Iterator.class)) {
              java.util.Iterator<X> dataIterator = (java.util.Iterator<X>) args[0];
            } else if (method.getParameterTypes()[0].equals(ByteBuffer.class)) {
              ByteBuffer byteBuffer = (ByteBuffer) args[0];
            } else if (method.getParameterTypes()[0].equals(ArrayBuffer.class)) {
              ArrayBuffer<X> dataBuffer = (ArrayBuffer<X>) args[0];
            } else {
              X dataItem = (X) args[0];
            }
            return null;
          }
          return proxy.invoke(receiver, args);
        };

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(sparkReceiverClass);
    enhancer.setCallback(handler);
    return (T) enhancer.create(currentConstructor.getParameterTypes(), constructorArgs);
  }

  private static final String PUBSUB_CONFIG_JSON_STRING =
      "{\n"
          + " \"project\": \"datatokenization\",\n"
          + " \"serviceAccountType\": \"JSON\",\n"
          + " \"serviceFilePath\": \"/something.json\",\n"
          + " \"subscription\": \"cdap-sub\",\n"
          + " \"topic\": \"cdap\",\n"
          + " \"numberOfReaders\": 1\n"
          + "}";

  public static void main(String[] args) {
    try {
      PubSubSubscriberConfig pubsubConfig =
          new ConfigWrapper<>(PubSubSubscriberConfig.class)
              .fromJsonString(PUBSUB_CONFIG_JSON_STRING)
              .build();
      ProxyBuilder<PubSubMessage, PubSubReceiver> builder =
          new ProxyBuilder<>(PubSubReceiver.class);

      PubSubReceiver proxyReciever =
          builder.withConstructorArgs(pubsubConfig, false, StorageLevel.DISK_ONLY()).build();
      proxyReciever.onStart();
    } catch (Exception e) {
      LOG.error("Can not get proxy", e);
    }
  }
}

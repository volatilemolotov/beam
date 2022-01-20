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

import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.util.function.Consumer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.apache.commons.lang.ClassUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.collection.Iterator;
import scala.collection.mutable.ArrayBuffer;

/**
 * Class for building proxy for {@link Receiver} that uses Apache Beam mechanisms instead of Spark
 * environment.
 */
@SuppressWarnings({"unchecked", "UnusedVariable"})
public class ProxyBuilder<X, T extends Receiver<X>> {

  private static final Logger LOG = LoggerFactory.getLogger(ProxyBuilder.class);
  private final Class<T> sparkReceiverClass;
  private Constructor<?> currentConstructor;
  private Object[] constructorArgs;
  private Consumer<Object[]> storeConsumer;
  private T proxy;
  private WrappedSupervisor wrappedSupervisor;

  public ProxyBuilder(Class<T> sparkReceiverClass) {
    this.sparkReceiverClass = sparkReceiverClass;
    withDefaultStoreConsumer();
  }

  /** Method for specifying constructor arguments for corresponding {@link #sparkReceiverClass} */
  public ProxyBuilder<X, T> withConstructorArgs(Object... args) {
    for (Constructor<?> constructor : sparkReceiverClass.getDeclaredConstructors()) {
      if (constructor.getParameterCount() == args.length) {
        boolean matches = true;
        for (int i = 0; i < args.length; i++) {
          Object arg = args[i];
          if (arg == null) {
            throw new IllegalArgumentException("All args must be not null!");
          }
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

  /** Method for specifying custom realization of {@link Receiver#store(Object)} method. */
  public ProxyBuilder<X, T> withCustomStoreConsumer(Consumer<Object[]> storeConsumer) {
    this.storeConsumer = storeConsumer;
    return this;
  }

  /** Method for setting default realization of {@link Receiver#store(Object)} method. */
  public ProxyBuilder<X, T> withDefaultStoreConsumer() {
    this.storeConsumer = this::store;
    return this;
  }

  /**
   * @return Proxy for given {@param receiver} that doesn't use Spark environment and uses Apache
   *     Beam mechanisms instead.
   */
  public T build() throws Exception {

    if (currentConstructor == null || constructorArgs == null || storeConsumer == null) {
      throw new IllegalStateException(
          "It is not possible to build a Receiver proxy without setting the obligatory parameters.");
    }
    if (proxy != null) {
      throw new IllegalStateException("Proxy already built.");
    }
    currentConstructor.setAccessible(true);
    T originalReceiver = (T) currentConstructor.newInstance(constructorArgs);

    MethodInterceptor handler =
        (obj, method, args, proxy) -> {
          if (method.getName().equals("supervisor")) {
            return getWrappedSupervisor();
          } else if (method.getName().equals("_supervisor")) {
            return getWrappedSupervisor();
          } else if (method.getName().equals("onStart")) {
            LOG.info("Custom Receiver was started");
            return null;
          } else if (method.getName().equals("stop")) {
            LOG.info("Custom Receiver was stopped. Message = {}", args[0]);
            return null;
          } else if (method.getName().equals("store")) {
            storeConsumer.accept(args);
            return null;
          }
          return proxy.invoke(originalReceiver, args);
        };

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(sparkReceiverClass);
    enhancer.setCallback(handler);
    this.proxy = (T) enhancer.create(currentConstructor.getParameterTypes(), constructorArgs);
    return this.proxy;
  }

  /**
   * @return {@link org.apache.spark.streaming.receiver.ReceiverSupervisor} that uses Apache Beam
   *     mechanisms.
   */
  private WrappedSupervisor getWrappedSupervisor() {
    if (this.wrappedSupervisor == null) {
      if (this.proxy == null) {
        throw new IllegalStateException(
            "Can not create WrappedSupervisor, because proxy Receiver was not built yet");
      }
      this.wrappedSupervisor = new WrappedSupervisor(this.proxy, new SparkConf());
    }
    return this.wrappedSupervisor;
  }

  /**
   * Default realization of {@link Receiver#store(Object)} method, that uses Apache Beam mechanisms
   * instead of Spark environment.
   */
  private void store(Object[] args) {
    if (args.length == 1) {
      Object arg = args[0];
      if (arg instanceof Iterator) {
        Iterator<X> dataIterator = (Iterator<X>) arg;
      } else if (arg instanceof java.util.Iterator) {
        java.util.Iterator<X> dataIterator = (java.util.Iterator<X>) arg;
      } else if (arg instanceof ByteBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) arg;
      } else if (arg instanceof ArrayBuffer) {
        ArrayBuffer<X> dataBuffer = (ArrayBuffer<X>) arg;
      } else {
        X dataItem = (X) arg;
      }
    }
    // TODO: implement storing
  }
}

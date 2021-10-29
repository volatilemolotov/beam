###############################################################################
#  Licensed to the Apache Software Foundation (ASF) under one
#  or more contributor license agreements.  See the NOTICE file
#  distributed with this work for additional information
#  regarding copyright ownership.  The ASF licenses this file
#  to you under the Apache License, Version 2.0 (the
#  "License"); you may not use this file except in compliance
#  with the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
# limitations under the License.
###############################################################################

#FROM golang:1.17-buster AS build
#
## Setup Go Environment
#ENV GOPATH /go
#ENV PATH $GOPATH/bin:$PATH
#RUN mkdir -p "$GOPATH/src" "$GOPATH/bin" && chmod -R 777 "$GOPATH"
#RUN go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.27.1 &&\
#    go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.1
#
## Prepare Application
#COPY src /go/src/playground/backend
#COPY playground /go/src/playground/playground
#WORKDIR /go/src/playground/backend
#
## Build Application
#RUN go mod download &&\
#    go mod tidy &&\
#    cd cmd/server &&\
#    go build -o /go/bin/server_java_backend

FROM apache/beam_java8_sdk:2.33.0
ENV BEAM_VERSION=2.33.0
ENV SERVER_IP=localhost
ENV SERVER_PORT=8080
ENV FLUTTER_VERSION=2.5.2-stable
ENV GO_VERSION=1.16.9


#Install Go
RUN cd /tmp &&\
    wget https://golang.org/dl/go$GO_VERSION.linux-amd64.tar.gz &&\
    rm -rf /usr/local/go &&\
    tar -C /usr/local -xzf go$GO_VERSION.linux-amd64.tar.gz &&\
    ln -s /usr/local/go/bin/go /usr/bin/go && \
    ln -s /usr/local/go/bin/gofmt /usr/bin/gofmt && \
    go get -u golang.org/x/tools/...

#Setup Go Environment
ENV GOPATH /go
ENV PATH $GOPATH/bin:$PATH
RUN mkdir -p "$GOPATH/src" "$GOPATH/bin" && chmod -R 777 "$GOPATH"

# Install Beam DirectRunner
RUN wget https://repo1.maven.org/maven2/org/apache/beam/beam-runners-direct-java/$BEAM_VERSION/beam-runners-direct-java-$BEAM_VERSION.jar &&\
    mv beam-runners-direct-java-$BEAM_VERSION.jar /opt/apache/beam/jars/beam-runners-direct.jar

RUN apt-get update && apt-get install -y wget xz-utils git gcc
RUN wget https://storage.googleapis.com/flutter_infra_release/releases/stable/linux/flutter_linux_$FLUTTER_VERSION.tar.xz &&\
        tar -xf flutter_linux_$FLUTTER_VERSION.tar.xz &&\
        mv flutter /opt/ &&\
        ln -s /opt/flutter/bin/flutter /usr/bin/flutter &&\
        ln -s /opt/flutter/bin/dart /usr/bin/dart &&\
        dart pub global activate protoc_plugin &&\
        ln -s /root/.pub-cache/bin/protoc-gen-dart /usr/bin/


RUN mkdir "/beam" && mkdir -p "/beam/gradle/wrapper"
COPY ./gradlew /beam/gradlew
COPY ./playground/dev-env/build.gradle.kts /beam/build.gradle.kts
COPY ./playground/dev-env/settings.gradle.kts /beam/settings.gradle.kts
COPY ./gradle.properties /beam/gradle.properties
COPY ./buildSrc /beam/buildSrc
COPY ./gradle/wrapper/* /beam/gradle/wrapper

RUN cd /beam && ./gradlew --daemon

RUN mkdir /go/src/tmp
COPY playground/backend/go.mod /go/src/tmp
COPY playground/backend/go.sum /go/src/tmp
RUN cd /go/src/tmp &&\
    go mod download

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

FROM apache/beam_java8_sdk
ENV GRADLE_VERSION=6.9.1
ENV GO_VERSION=1.17.1
ENV BEAM_VERSION=2.32.0

#Install Gradle
RUN cd /tmp &&\
    wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip &&\
    unzip gradle-$GRADLE_VERSION-bin.zip &&\
    mv gradle-$GRADLE_VERSION /opt/gradle &&\
    ln -s /opt/gradle/bin/gradle /usr/bin/gradle

#Install Go
RUN cd /tmp &&\
    wget https://golang.org/dl/go$GO_VERSION.linux-amd64.tar.gz &&\
    rm -rf /usr/local/go &&\
    tar -C /usr/local -xzf go$GO_VERSION.linux-amd64.tar.gz &&\
    ln -s /usr/local/go/bin/go /usr/bin/go

#Install Beam DirectRunner
RUN cd /tmp &&\
    wget https://repo1.maven.org/maven2/org/apache/beam/beam-runners-direct-java/$BEAM_VERSION/beam-runners-direct-java-$BEAM_VERSION.jar &&\
    mv beam-runners-direct-java-$BEAM_VERSION.jar /opt/apache/beam/jars/beam-runners-direct.jar

#Setup Go Environment
ENV GOPATH /go
ENV PATH $GOPATH/bin:$PATH
RUN mkdir -p "$GOPATH/src" "$GOPATH/bin" && chmod -R 777 "$GOPATH"
RUN go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.26 &&\
    go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.1
RUN apt-get update && apt-get install -y protobuf-compiler

#Prepare Application
COPY src /go/src/playground/backend
COPY playground /go/src/playground/playground
RUN ls /go/src/playground/backend
#Build Application
RUN cd /go/src/playground && \
    mkdir backend/pkg/api && \
    protoc --go_out=backend/pkg/api --go_opt=paths=source_relative --go-grpc_out=backend/pkg/api --go-grpc_opt=paths=source_relative --proto_path=playground/v1 playground/v1/playground.proto
RUN cd /go/src/playground/backend &&\
    go mod download &&\
    go mod tidy

WORKDIR $GOPATH/src/playground/backend/cmd/server
ENTRYPOINT ["go", "run", "."]


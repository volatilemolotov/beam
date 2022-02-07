#!/usr/bin/env bash

# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
GO_LINTER_VERSION=2021.1.2

# Install GO Linter
#wget https://github.com/golangci/golangci-lint/releases/download/v1.42.1/golangci-lint-$GO_LINTER_VERSION-linux-amd64.deb
#dpkg -i golangci-lint-$GO_LINTER_VERSION-linux-amd64.deb

kernelname=$(uname -s)

# Running on Linux
if [ "$kernelname" = "Linux" ]; then
    curl -OL "https://github.com/dominikh/go-tools/releases/download/${GO_LINTER_VERSION}/staticcheck_linux_amd64.tar.gz" | tar -xf staticcheck_linux_amd64.tar.gz -C $(go env GOPATH)/bin
    chmod 777 $(go env GOPATH)/bin/*

# Running on Mac
elif [ "$kernelname" = "Darwin" ]; then
     curl -OL "https://github.com/dominikh/go-tools/releases/download/${GO_LINTER_VERSION}/staticcheck_darwin_amd64.tar.gz" | tar -xf staticcheck_linux_amd64.tar.gz -C $(go env GOPATH)/bin
     chmod 777 $(go env GOPATH)/bin/*
else echo "Unrecognized Kernel Name: $kernelname"
fi

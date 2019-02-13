#!/bin/bash

pushd simpleEJB
mvn install
popd

docker stop $(docker ps | grep tomee-server | tail -n 1 | awk '{ print $1 }')
docker build -t tomee-server .

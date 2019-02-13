#!/bin/sh

pushd clientEJB
mvn install
popd

docker stop $(docker ps | grep tomee-client | tail -n 1 | awk '{ print $1 }')
docker build -t tomee-client .

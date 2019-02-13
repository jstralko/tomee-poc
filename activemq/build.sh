#!/bin/sh

docker stop $(docker ps | grep activemq | tail -n 1 | awk '{ print $1 }')
docker build -t activemq .

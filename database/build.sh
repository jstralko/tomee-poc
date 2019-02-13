#!/bin/sh

docker stop $(docker ps | grep database | tail -n 1 | awk '{ print $1 }')
docker build -t database .

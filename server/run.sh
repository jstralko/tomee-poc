#!/bin/sh

docker stop $(docker ps | grep tomee-server | tail -n 1 | awk '{ print $1 }')
docker run -dit \
	-p 8080:8080 \
	tomee-server

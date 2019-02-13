#!/bin/bash

#-p host:container port mapping

docker stop $(docker ps | grep tomee-client | tail -n 1 | awk '{ print $1 }')

docker run -dit \
	-p 9090:8080 \
	tomee-client
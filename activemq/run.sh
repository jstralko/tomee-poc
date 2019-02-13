#!/bin/bash

#-p host:container port mapping

docker stop $(docker ps | grep activemq | tail -n 1 | awk '{ print $1 }')

docker run -dit \
	-p 61616:61616 \
	-p 8161:8161 \
	activemq
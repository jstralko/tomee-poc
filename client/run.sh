#!/bin/bash

#-p host:container port mapping

docker run -dit \
	-p 9090:8080 \
	tomee

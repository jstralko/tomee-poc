#!/bin/sh

docker run -dit \
	-p 8080:8080 \
	-p 3700:3700 \
	tomee

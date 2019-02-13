#!/bin/bash

#-p host:container port mapping

docker stop $(docker ps | grep database | tail -n 1 | awk '{ print $1 }')

docker run -dit \
	-e "MYSQL_ROOT_PASSWORD=root" \
	database

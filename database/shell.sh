#!/bin/bash


#-e "drop schema test; create schema test;" \

docker exec \
-it $(docker ps | grep database | tail -n 1 | awk '{ print $1 }') bash

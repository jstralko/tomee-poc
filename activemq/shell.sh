#!/bin/bash

docker exec -it $(docker ps | grep activemq | tail -n 1 | awk '{ print $1 }') bash

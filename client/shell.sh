#!/bin/bash

docker exec -it $(docker ps | grep tomee-client | tail -n 1 | awk '{ print $1 }') bash

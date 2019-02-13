#!/bin/bash

docker exec -it $(docker ps | grep database | tail -n 1 | awk '{ print $1 }') bash

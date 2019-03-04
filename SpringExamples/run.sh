#!/bin/sh

java \
	-cp target/SpringExamples-1.0-SNAPSHOT.jar:target/SpringExamples-1.0-SNAPSHOT-jar-with-dependencies.jar \
	local.gerb.App

#!/bin/bash

javac -cp ".:src/main/resources:lib/lombok.jar:lib/jackson-core-2.9.9.jar:lib/jackson-databind-2.18.3.jar" \
  -processorpath lib/lombok.jar \
  -d bin src/main/java/org/**/*.java

java -cp "bin:src/main/resources:lib/lombok.jar:lib/jackson-core-2.9.9.jar:lib/jackson-databind-2.18.3.jar" org.App


#!/bin/bash

cd user
mvn clean install -DskipTests
mvn spring-boot:run

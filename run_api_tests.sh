#!/bin/sh
mvn clean
mvn -Dtest=api.CucumberRunner test

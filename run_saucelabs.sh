#!/bin/sh
mvn clean
mvn -Dtest=webautomation.CucumberRunner -Denvironment="saucelabs" test

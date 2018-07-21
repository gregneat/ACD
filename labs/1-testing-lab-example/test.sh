#!/bin/bash
DIR="$( cd -P "$( dirname "$0" )" && pwd )"
cd "$DIR"

javac *Test.java

java org.junit.runner.JUnitCore CalculatorTest

echo 'Press enter to close'
read

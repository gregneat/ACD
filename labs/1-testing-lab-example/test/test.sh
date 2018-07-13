#!/bin/bash
cd "`dirname "$0"`"

buildClasspath() {
  appDir=$1
  classpath=.
  for jar in $appDir/lib/*
  do
      classpath=$classpath:$jar
  done
}

compile="javac -cp \"$classpath\" *.java"

run="java -cp \"$classpath\" org.junit.runner.JUnitCore"

javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest

echo 'Press enter to close'
read

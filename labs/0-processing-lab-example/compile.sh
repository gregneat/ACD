#!/bin/bash
DIR="$( cd "$( dirname "$0" )" && pwd )"
cd "$DIR"

buildClasspath() {
  appDir=$1
  classpath=.
  for jar in $appDir/lib/*
  do
      classpath=$classpath:$jar
  done
}
buildClasspath "$DIR"
javac -cp $classpath *.java

echo 'Press enter to close'
read

#!/bin/bash
DIR="$( cd "$( dirname "$0" )" && pwd )"
cd "$DIR"
javac *.java

echo 'Press enter to close'
read

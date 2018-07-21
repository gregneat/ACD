#!/bin/bash
DIR="$( cd "$( dirname "$0" )" && pwd )"
cd "$DIR"
java MoveRect

echo 'Press enter to close'
read

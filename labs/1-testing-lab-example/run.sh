#!/bin/bash
DIR="$( cd "$( dirname "$0" )" && pwd )"
cd "$DIR"

java Calculator

echo 'Press enter to close'
read

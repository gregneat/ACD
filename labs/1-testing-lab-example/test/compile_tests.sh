cd "`dirname "$0"`"

javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *Test.java

echo 'Press enter to close'
read

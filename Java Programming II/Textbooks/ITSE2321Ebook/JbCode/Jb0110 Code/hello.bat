echo off
cls

del *.class

javac -cp .; hello.java
java -cp .; hello

pause
echo off
cls

del *.class

javac -cp .; hello1.java
java -cp .; hello1

pause
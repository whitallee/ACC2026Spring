echo off
cls

del *.class

javac -cp .; Memory01.java
java -cp .; Memory01

pause
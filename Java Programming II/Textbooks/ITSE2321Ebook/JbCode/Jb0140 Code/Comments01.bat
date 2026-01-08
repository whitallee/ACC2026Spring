echo off
cls

del *.class

javac -cp .; Comments01.java
java -cp .; Comments01

pause
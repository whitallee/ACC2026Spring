echo off
cls

del *.class

javac -cp .; template.java
java -cp .; template

pause
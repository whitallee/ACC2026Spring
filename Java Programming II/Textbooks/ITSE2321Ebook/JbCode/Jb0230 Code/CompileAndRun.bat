echo off
path="C:\Program Files\Java\jdk-13\bin";%path%
del *.class
javac -version
javac Odd.java
java Odd
pause

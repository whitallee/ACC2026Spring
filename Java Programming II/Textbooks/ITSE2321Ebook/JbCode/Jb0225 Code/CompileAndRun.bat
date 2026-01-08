echo off

rem Compiles and runs Jb0225Code.
set PATH=C:\Program Files\Java\jdk-13\bin
del *.class

javac -cp .; *.java
java -cp .; Jb0225Code 5



pause
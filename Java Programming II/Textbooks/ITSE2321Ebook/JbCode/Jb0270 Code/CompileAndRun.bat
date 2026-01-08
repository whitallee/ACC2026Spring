echo off

del Combined\Java\*.class
del Combined\Java\p1\*.class
del Combined\Java\p2\*.class

javac -cp "M:\Baldwin\AA-School\Connexions\Java OOP\h-Programming Fundamentals\Part06\Jb0270\Code" Combined\Java\Package00.java

java -cp "M:\Baldwin\AA-School\Connexions\Java OOP\h-Programming Fundamentals\Part06\Jb0270\Code" Combined.Java.Package00

pause
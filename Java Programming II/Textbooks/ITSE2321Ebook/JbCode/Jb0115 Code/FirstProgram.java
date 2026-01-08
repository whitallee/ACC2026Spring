/* Begin block comment ***********************************
This is the beginning of a block comment in Java.
Everything in this block comment is for human consumption
and will be ignored by the Java compiler.

File: FirstProgram.java
Copyright, R.G. Baldwin

This program is designed to illustrate the most common
forms of the three pillars of procedural programming in
Java code:

sequence
selection
loop

The program also illustrates calling a method, passing
a parameter to the method, and receiving a returned 
value from the method.

Assuming that the Java Development Kit (JDK) is properly
installed on your computer, do the following to compile 
and run this program.

1. Copy this program into a file named FirstProgram.java
and store the file in a folder on your disk.
2. Open a command-line window in the folder containing
the file.
3. Type the following command to compile the program:
javac FirstProgram.java
4. Type the following command to run the program:
java FirstProgram

Any text that begins with // in the following program
code is a comment. The compiler will ignore everything
from the // to the end of the line.

The compiler also ignores blank lines.

Note that this program was designed to illustrate the
concepts while being as non-cryptic as possible.

The program should display the following text on the
screen except that the time will be different each time
that you run the program.

value in = 5
Odd time = 1353849164875
countA = 0
countA = 1
countA = 2
countB = 0
countB = 1
countB = 2
value out = 10

End block comment ***************************************/

//The actual program begins with the next line.
import java.util.*;

class FirstProgram{
  //The program consists of a sequence of statements.
  
  //The next statement is the beginning of the main
  // method, which is required in all Java applications.
  public static void main(String[] args){
    //Program execution begins here.
    
    //Declare and initialize a variable.
    int var = 5;
    
    //Statements of the following type display
    // information on the screen
    System.out.println("value in = " + var);
    
    //Call a method and pass a parameter to the method.
    //Save the returned value in var, replacing what
    // was previously stored there.
    //Control is passed to the method named firstMethod.
    var = firstMethod(var);

    //Control has returned from the method named
    // firstMethod.
    System.out.println("value out = " + var);
    
    //Program execution ends here
  }//end main method
  
  /****visual separator comment**************************/
  
  public static int firstMethod(int inData){
    //Control is now in this method.
    
    //Illustrate selection
    //Get the elapsed time in milliseconds since Jan 1970.
    long time = new Date().getTime();
    
    //Select even or odd time and display the results
    if(time % 2 == 0){
      System.out.println("Even time = " + time);
    }else{
      System.out.println("Odd time = " + time);
    }//end if-else selection
    
    //Illustrate a while loop
    int countA = 0;
    while(countA < 3){
      System.out.println("countA = " + countA);
      //Increment the counter
      countA = countA + 1;
    }//end while loop
    
    //Illustrate a for loop
    for(int countB = 0; countB < 3; countB = countB + 1){
      System.out.println("countB = " + countB);
    }//end for loop
    
    //Illustrate returning a value from a method and
    // returning control back to the calling method.
    return 2*inData;
  }//end firstMethod
  
}//end class FirstProgram
//The program ends with the previous line.
/*File Ap0010b1.java Copyright, R.G.Baldwin

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Receives and displays an incoming parameter of type int. 

The result should be similar to the following but the
values should be different each time the program is
run.

484495695
484495695
**********************************************************/
//Student is not expected to understand import directives
// at this point.
import java.util.Random;
import java.util.Date;

public class Ap0010b1{
  public static void main(String args[]){
    //Create a random number for testing. Student is not
    // expected to understand how this works at this point.
    Random random = new Random(new Date().getTime());
    int intVar = random.nextInt();
    
    //Student should understand the following
    int var = intVar;
    System.out.println(var);
    new Worker().doIt(var);
  }//end main()
}//end class definition 
//=======================================================//

class Worker{
  //-----------------------------------------------------//
  //Student: insert the method named doIt between these
  // lines.
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

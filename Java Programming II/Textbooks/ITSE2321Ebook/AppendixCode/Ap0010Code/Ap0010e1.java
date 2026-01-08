/*File Ap0010e1.java Copyright, R.G.Baldwin

Instructions to student:
This program refuses to compile without errors.

Make the necessary corrections to cause the program to
compile and run successfully to produce an output similar
to that shown below. Note that the values should be
different each time the program is
run.

-1.30240579E8
-1.30240579E8
**********************************************************/
//Student is not expected to understand import directives
// at this point.
import java.util.Random;
import java.util.Date;

public class Ap0010e1{
  public static void main(String args[]){
    //Create a random number for testing. Student is not
    // expected to understand how this works at this point.
    Random random = new Random(new Date().getTime());
    double doubleVar = random.nextInt()/1.0;

    //Student should understand the following
    double var = doubleVar;
    System.out.println(doubleVar);
    new Worker().doIt(doubleVar);
  }//end main()
}//end class definition
//=======================================================//

class Worker{
  public void doIt(double val){
    int var = val;
    System.out.println(var);
  }//end doIt()
}//end class definition
//=======================================================//

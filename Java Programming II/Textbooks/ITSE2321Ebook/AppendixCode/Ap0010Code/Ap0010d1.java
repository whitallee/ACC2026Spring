/*File Ap0010d1.java Copyright, R.G.Baldwin

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Receives an incoming parameter of type double.
2. Converts that value to type int.
3. Returns the int

The result should be similar to the following but the
values should be different each time the program is
run.

6.672032181818181E8
667203218
**********************************************************/
//Student is not expected to understand import directives
// at this point.
import java.util.Random;
import java.util.Date;

public class Ap0010d1{
  public static void main(String args[]){
    //Create a random number for testing. Student is not
    // expected to understand how this works at this point.
    Random random = new Random(new Date().getTime());
    int intVar = random.nextInt();
    
    //Student should understand the following
    double var = intVar/1.1;
    System.out.println(var);
    System.out.println(new Worker().doIt(var));
  }//end main()
}//end class definition 
//=======================================================//

class Worker{
  //-----------------------------------------------------//
  //Student: insert the method named doIt between these
  // lines.
  //Instructor: remove the entire method named doIt for
  // the test version of this program.
  public int doIt(double val){
    return (int)val;
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

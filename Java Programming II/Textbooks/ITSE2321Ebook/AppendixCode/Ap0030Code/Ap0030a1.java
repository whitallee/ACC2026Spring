/*File Ap0030a1.java Copyright, R.G.Baldwin
  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Compares an incoming random parameter value with zero.
2. Returns a string containing three concatenated
substrings, each of which is either true or false. The
three substrings indicate whether the value is less than,
greater than, or equal to the value zero in that order.

For example, for a random value of -38, the output should
be:

-38
true false false
**********************************************************/
//Student is not expected to understand import directives
// at this point.
import java.util.Random;
import java.util.Date;

public class Ap0030a1{
  public static void main(String args[]){
    //Create a random number for testing. Student is not
    // expected to understand how this works at this point.
    Random random = new Random(new Date().getTime());
    int intVar = (byte)random.nextInt();

    //Student should understand the following
    System.out.println(intVar);
    System.out.println(new Worker().doIt(intVar));
  }//end main()
}//end class definition
//=======================================================//

class Worker{
  //-----------------------------------------------------//
  //Student: insert the method named doIt between these
  // lines.
  public String doIt(int val){
    String var = "";
    var += ((val < 0) + " ");
    var += ((val > 0) + " ");
    var += ((val == 0) + " ");
    return var;
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

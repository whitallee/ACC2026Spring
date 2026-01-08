/*File Ap0030d1.java Copyright, R.G.Baldwin
  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Illustrates the difference in behavior between the
prefix and postfix versions of the increment operator.

For example, you might want to cause your program to
produce an output similar to the following:

varA = 3
varB = 4
Increment varA and add = 7
varA = 4

varA = 3
varB = 4
Increment varA and add = 8
varA = 4
**********************************************************/

public class Ap0030d1{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class definition
//=======================================================//

class Worker{
  //-----------------------------------------------------//
  //Student: insert the method named doIt between these
  // lines.
  public void doIt(){
    int varA = 3;
    System.out.println("varA = " + varA);
    int varB = 4;
    System.out.println("varB = " + varB);
    System.out.println(
           "Increment varA and add = " + (varA++ + varB));
    System.out.println("varA = " + varA);
    System.out.println();

    //Reset to original value
    varA = 3;
    System.out.println("varA = " + varA);
    System.out.println("varB = " + varB);
    System.out.println(
            "Increment varA and add = " + (++varA + varB));
    System.out.println("varA = " + varA);
    System.out.println();

  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

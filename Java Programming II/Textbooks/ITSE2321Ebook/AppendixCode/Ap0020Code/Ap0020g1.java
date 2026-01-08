/*File Ap0020g1.java Copyright, R.G.Baldwin

  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Illustrates the concatenation of the following strings
separated by space characters.

"This"
"is"
"fun"

Cause your program to produce the following output:
This
is
fun
This is fun
**********************************************************/
public class Ap0020g1{
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
    String varA = "This";
    System.out.println(varA);
    String varB = "is";
    System.out.println(varB);
    String varC = "fun";
    System.out.println(varC);
    System.out.println(varA + " " + varB + " " +varC);

  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

/*File Ap0020d1.java Copyright, R.G.Baldwin

  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Illustrates the effect of double divide by zero.
2. Illustrates the effect of integer divide by zero.

**********************************************************/
public class Ap0020d1{
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
    double varA = 10;
    System.out.println(varA);
    int varB = 10;
    System.out.println(varB);
    System.out.println(varA/0);
    System.out.println(varB/0);
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

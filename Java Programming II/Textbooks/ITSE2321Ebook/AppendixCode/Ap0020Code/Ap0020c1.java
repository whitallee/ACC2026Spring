/*File Ap0020c1.java Copyright, R.G.Baldwin

  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Illustrates the effect of integer truncation that 
occurs with integer division.

**********************************************************/
public class Ap0020c1{
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
    int varA = 10;
    System.out.println(varA);
    int varB = 3;
    System.out.println(varB);
    System.out.println(varA/varB);
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

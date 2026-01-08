/*File Ap0020b1.java Copyright, R.G.Baldwin

  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Illustrates the detrimental impact of integer arihmetic
overflow.

**********************************************************/
public class Ap0020b1{
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
    int var = Integer.MAX_VALUE;
    System.out.println(var);
    var += Integer.MAX_VALUE;
    System.out.println(var);
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

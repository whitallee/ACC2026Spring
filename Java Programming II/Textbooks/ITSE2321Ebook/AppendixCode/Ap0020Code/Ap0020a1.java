/*File Ap0020a1.java Copyright, R.G.Baldwin

  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Illustrates the proper use of the combined 
arithmetic/assignment operators such as the following
operators:

+= 
*=

**********************************************************/
public class Ap0020a1{
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
    int var = 5;
    var += 6;
    System.out.println(var);
    var *= 6;
    System.out.println(var);
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

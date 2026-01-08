/*File Ap0030c1.java Copyright, R.G.Baldwin

  //Instructor: remove the entire method named doIt for
  // the test version of this program.

Instructions to student:
Beginning with the code fragment shown below, write a
method named doIt that:
1. Returns the boolean result of comparing two object
references from the class Dummy using the inherited
method named equals.
2. Does so in such a way that the boolean result is true.

**********************************************************/

public class Ap0030c1{
  public static void main(String args[]){
    System.out.println(new Worker().doIt());
  }//end main()
}//end class definition
//=======================================================//

class Worker{
  //-----------------------------------------------------//
  //Student: insert the method named doIt between these
  // lines.
  public boolean doIt(){
    Dummy objA = new Dummy();
    Dummy objB = objA;
    return objA.equals(objB);
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//
class Dummy{
  int x = 5;
}//end class Dummy
//=======================================================//
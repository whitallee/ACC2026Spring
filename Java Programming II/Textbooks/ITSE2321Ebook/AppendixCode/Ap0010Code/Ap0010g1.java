/*File Ap0010g1.java Copyright, R.G.Baldwin

Instructions to student:
Beginning with the code shown below, modify the
code in the method named doIt so that the program
displays

2048 instead of 2730

Did you notice anything particularly interesting about the
values involved?
**********************************************************/
public class Ap0010g1{
  public static void main(String args[]){
    new Worker().doIt(16384);
  }//end main()
}//end class definition
//=======================================================//

class Worker{
  public void doIt(int val){
    System.out.println(val/6);
  }//end doIt()
}//end class definition
//=======================================================//

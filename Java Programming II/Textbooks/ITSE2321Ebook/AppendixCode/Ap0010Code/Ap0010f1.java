/*File Ap0010f1.java Copyright, R.G.Baldwin

Instructions to student:
Beginning with the code shown below, modify the
code in the method named doIt so that the program
displays

3.3333333333333335 instead of 3

Then modify the method again so that the program displays

3.3333333 instead of 3
**********************************************************/
public class Ap0010f1{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class definition
//=======================================================//

class Worker{
  public void doIt(){
    System.out.println(10/3);
  }//end doIt()
}//end class definition
//=======================================================//

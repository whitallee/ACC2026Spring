/*File Ap0010c1.java Copyright, R.G.Baldwin
Beginning with the code fragment shown below, write a
method named doIt that returns the largest value of type 
int as type float. 

The result should be 2.14748365E9
**********************************************************/
public class Ap0010c1{
  public static void main(String args[]){
    float val = new Worker().doIt();
    System.out.println(val);
  }//end main()
}//end class definition 
//=======================================================//

class Worker{
  //Insert the method named doIt between these lines.
  //-----------------------------------------------------//
  public float doIt(){
    float var = Integer.MAX_VALUE;
    return var;
  }//end doIt()
  //-----------------------------------------------------//
}//end class definition
//=======================================================//

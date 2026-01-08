//3456789012345678901234567890123456789

import java.awt.*;
class Q101{
  public static void main(
                        String args[]){
    try{
      Button[] var = new Button[5];
      System.out.println(
        var.getClass().isArray());
    }catch(Exception e){
      System.out.println(
                   "Exception Thrown");
    }//end catch
  }//end main()
}//end class definition
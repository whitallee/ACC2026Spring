/*File Q20.java Copyright, R.G.Baldwin
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q20 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUInterface object
  }//end main
}//end class Q20
//=======================================================//

class GUI{
  public GUI(){//constructor
    JFrame displayWindow = new JFrame();
    displayWindow.setSize(300,200);
    displayWindow.setTitle("Q20");
    //Following is available in recent Java versions
    displayWindow.setDefaultCloseOperation(
                                     JFrame.EXIT_ON_CLOSE);
    displayWindow.addWindowListener(new WProc2());
    displayWindow.setVisible(true);

  }//end constructor
}//end class GUI definition
//=======================================================//

class WProc2 extends WindowAdapter{
  public void windowIconified(WindowEvent e){
    System.out.println(
              "******** WProc2 windowIconified test msg");
  }//end windowIconified()

  public void windowDeiconified(WindowEvent e){
    System.out.println(
            "******** WProc2 windowDeiconified test msg");
  }//end windowDeiconified()
}//end class WProc2
//=======================================================//
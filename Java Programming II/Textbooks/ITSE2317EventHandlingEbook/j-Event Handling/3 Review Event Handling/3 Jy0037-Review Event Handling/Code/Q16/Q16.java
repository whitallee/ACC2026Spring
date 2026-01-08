/*File Q16.java
**********************************************************/
import java.awt.*;
import java.awt.event.*;

public class Q16 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUInterface object
  }//end main
}//end class Q16
//=======================================================//

class GUI{
  public GUI(){//constructor
    //Create a new Frame object
    Frame displayWindow = new Frame();
    displayWindow.setSize(300,200);
    displayWindow.setTitle("Q16");

    WProc1 winProcCmd1 = new WProc1(displayWindow);
    displayWindow.addWindowListener(winProcCmd1);
    displayWindow.setVisible(true);
  }//end constructor
}//end class GUI definition
//=======================================================//

class WProc1 implements WindowListener{
  Frame displayWindowRef;

  WProc1(Frame windowIn){//constructor
    this.displayWindowRef = windowIn;
  }//end constructor

  public void windowClosed(WindowEvent e){
    System.out.println("WProc1 windowClosed test msg");
  }//end windowClosed()

  public void windowIconified(WindowEvent e){
    System.out.println("WProc1 windowIconified test msg");
  }//end windowIconified()

  public void windowOpened(WindowEvent e){
    System.out.println("WProc1 windowOpened test msg");
  }//end windowOpened()

  public void windowClosing(WindowEvent e){
    System.out.println("WProc1 windowClosing test msg");
    displayWindowRef.dispose();//generate WindowClosed
  }//end windowClosing()

  public void windowDeiconified(WindowEvent e){
    System.out.println(
                      "WProc1 windowDeiconified test msg");
  }//end windowDeiconified()

  public void windowActivated(WindowEvent e){
    System.out.println("WProc1 windowActivated test msg");
  }//end windowActivated()

  public void windowDeactivated(WindowEvent e){
    System.out.println(
                     "WProc1 windowDeactivated test msg");
  }//end windowDeactivated()
}//end class WProc1
//=======================================================//
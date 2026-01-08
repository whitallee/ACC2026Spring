/*File Q19.java
*/
import java.awt.*;
import java.awt.event.*;

public class Q19 {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class Q19
//---------------------------------------------------------

class MyFrame extends Frame{
  int clickX;
  int clickY;

  public void paint(Graphics g){
    g.drawString(
              "" + clickX + ", " + clickY, clickX, clickY);
  }//end paint()
}//end class MyFrame
//---------------------------------------------------------

class GUI {
  public GUI(){//constructor
    MyFrame displayWindow = new MyFrame();
    displayWindow.setSize(300,300);
    displayWindow.setTitle("Q19");
    displayWindow.setVisible(true);

    displayWindow.addWindowListener(new WProc1());

    //Instantiate and register a Listener object that will
    // process mouse events to determine and display the
    // coordinates when the user presses the mouse button.
    displayWindow.addMouseListener(
      new MProc1(displayWindow));
  }//end constructor
}//end class GUI definition
//---------------------------------------------------------

//This listener class monitors for mouse presses and
// displays the coordinates of the mouse pointer when the
// mouse is pressed.
class MProc1 extends MouseAdapter{
  MyFrame refToWin; //save a reference to the window here

  MProc1(MyFrame inWin){//constructor
    refToWin = inWin;//save ref to window
  }//end constructor

  //Override the mousePressed method to determine and
  // display the coordinates when the mouse is pressed.
  public void mousePressed(MouseEvent e){
    //Get X and Y coordinates of mouse pointer
    // and store in the Frame object.
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();
    refToWin.repaint();//display coordinate information
  }//end mousePressed()
}//end class MProc1
//---------------------------------------------------------
class WProc1 extends WindowAdapter{

  public void windowClosed(WindowEvent e){
    System.exit(0);
  }//end windowClosed()

}//end class Wproc1

//Note: need to override WindowClosing instead of WindowClosed.
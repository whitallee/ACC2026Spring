/*File Event10A.java Copyright, R.G.Baldwin
Rewrite the program named Event10 and eliminate the 
requirement to pass parameters to the constructors for the
event Listener objects.

This program is designed to be compiled and run under 
JDK 1.1

The program illustrates the sharing of a single listener 
object among two different visual components of the same 
type.

The program detects mouse events occuring on either of two
different Frame objects.  It distinguishes between the two 
objects and displays the coordinates of a mouse click on 
whichever object experienced the mouse click.

These results were produced using JDK 1.1.3 running under 
Windows 95.

Note that when the program starts, the two visual 
components overlay one another.  It is necessary to move 
one of them in order to access the other.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;

public class Event10A {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Event10A
//=======================================================//

//Subclass Frame in order to override the paint method.
class MyFrame extends Frame{
  int xCoor;
  int yCoor;

  MyFrame(){//constructor
    setTitle("Copyright, R.G.Baldwin");
    setSize(300,200);
  }//end constructor
  
  public void paint(Graphics g){
    //display coordinate information on the visual object
    g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
  }//end paint()
}//end class MyFrame
//=======================================================//

//The following class is used to instantiate a graphical 
// user interface object.
class GUI {
  public GUI(){//constructor
    //Create two visual objects of type MyFrame and make 
    // them visible.
    MyFrame myFrame1 = new MyFrame();
    myFrame1.setVisible(true);
    
    MyFrame myFrame2 = new MyFrame();
    myFrame2.setVisible(true);    
    
    //Instantiate and register Listener object which will 
    // terminate the program when the user closes either 
    // window.
    WProc1 winProcCmd1 = new WProc1();
    myFrame1.addWindowListener(winProcCmd1);
    myFrame2.addWindowListener(winProcCmd1);    
    
    //Instantiate and register Listener object which will 
    // process mouse events on either MyFrame object.
    MouseProc mouseProcCmd = new MouseProc();
    myFrame1.addMouseListener(mouseProcCmd);
    myFrame2.addMouseListener(mouseProcCmd);    
  }//end constructor
}//end class GUI definition
//=======================================================//

//This listener class monitors for mouse presses and 
// displays the coordinates of the mouse pointer when the 
// mouse is pressed.  The listener object distinguishes 
// between two different visual objects and displays the 
// coordinate information on the visual object which 
// generated the mouse event.

class MouseProc extends MouseAdapter{
  //Override the mousePressed() method to respond whenever 
  // the mouse is pressed on one of the frame objects.  
  public void mousePressed(MouseEvent e){
    //Get X and Y coordinates of mouse pointer and store in
    // the Frame object.  Distinguish between the two
    // components on the basis of the source of the event.
    // Note that the following two formulations for X and Y
    // can be used to produce the same results in this
    // situation.
    ((MyFrame)e.getComponent()).xCoor = e.getX();
    ((MyFrame)e.getSource()).yCoor = e.getY();
    
    //display coordinate information   
    e.getComponent().repaint();
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

//The following listener is used to terminate the program 
// when the user closes either frame object.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//

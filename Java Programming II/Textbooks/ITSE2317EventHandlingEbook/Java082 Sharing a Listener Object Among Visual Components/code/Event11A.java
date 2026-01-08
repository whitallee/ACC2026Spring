/*File Event11A.java Copyright, R.G.Baldwin
Rewrite the program named Event11 and eliminate the 
requirement to pass parameters to the constructor for the
listener objects.

This program is designed to be compiled and run under 
JDK 1.1

The program illustrates the sharing of a single listener 
object between two different visual components of different
types.

The program detects mouse events occuring on either a 
visual Frame object or on a visual Window object.  It 
distinguishes between the two objects and displays a 
message indicating which object generated the event.

Clicking inside the Frame object but outside the Window 
object produces the following message:

Got mousePressed event from Frame object

Clicking inside the Window object produces the following 
message:

Got mousePressed event from Window object

Closing the Frame object produces the following message and
terminates the program:

Got windowClosing event from Frame object

These results were produced using JDK 1.1.3 running under 
Windows 95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;

public class Event11A {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Event11A
//=======================================================//

//The following class is used to instantiate a graphical 
// user interface object.
class GUI {
  public GUI(){//constructor
    //Create a visual Frame object
    Frame myFrame = new Frame();
    myFrame.setSize(200,300);
    myFrame.setTitle("Copyright, R.G.Baldwin");
    myFrame.setVisible(true);
    
    //Create a visual Window object inside the Frame object
    Window myWindow = new Window(myFrame);
    myWindow.setSize(100,100);
    myWindow.setVisible(true);    
    
    //Instantiate and register a Listener object which will
    // process mouse events on either the Frame object or 
    // the Window object.
    MouseProc mouseProcCmd = new MouseProc();
    myFrame.addMouseListener(mouseProcCmd);
    myWindow.addMouseListener(mouseProcCmd);    

    //Instantiate and register a Listener object which will
    // display a mesaage and terminate the program when the
    // user closes the Frame object
    WProc1 winProcCmd1 = new WProc1();
    myFrame.addWindowListener(winProcCmd1);
  }//end constructor
}//end class GUI definition
//=======================================================//

//This listener class monitors for mouse presses and 
// displays a message when a mousPressed() event occurs on
// either the Frame object or the Window object.  The 
// message identifies which visual object generated the 
// event. The listener object distinguishes between the two
// visual objects.

class MouseProc extends MouseAdapter{

  //Override the mousePressed() method to respond whenever
  // the mouse is pressed on one of the visual objects.  
  public void mousePressed(MouseEvent e){
    System.out.print("Got mousePressed event from ");
    if(e.getSource().toString().indexOf("Frame") >= 0)
      System.out.println("Frame object");
    else
      System.out.println("Window object");
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

//The following listener is used to display a message and 
// terminate the program when the user closes the Frame 
// object.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.out.println(
              "Got windowClosing event from Frame object");
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//
/*File SwingEvent09.java Copyright, R.G.Baldwin
Rev 5/9/98 by RGB
This is a Swing version of the program named Event09.

The purpose of this program is to illustrate that in some
cases, conversion of an AWT program to a Swing program
isn't as simple as importing the Swing package and replacing
the AWT components with Swing components.

That is what was done with this program.  In other words,
this program is identical to the AWT program named Event09
except that all instances of Frame were replaced by JFrame
and the Swing package was imported.

At the surface, the program appears to work correctly.
However, as each new click occurs on the client area of
the JFrame, a new pair of coordinate values is displayed,
but the previous pairs of coordinate values don't disappear
as is the case with the program named Event09.

Furthermore, in some cases, while this GUI is on the screen,
if focus is transferred to a different application, all of
the coordinate values except the last one created will;
disappear.

It will be left as an exercise for the student to dig into
the (currently very sparse) documentation on Swing in order
to understand and explain this behavior.

Illustrates the use of Event Sources, Event Listeners, and;
Adapters in the Delegation Event Model for Swing.

This program instantiates a Listener object to process;
mouse events. When a mouse press occurs in a JFrame object,
the program gets the coordinates and then displays those
coordinates near the point of the mouse press.

Tested using JDK 1.1.6 and Swing 1.0.1 under Win95.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingEvent09 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUI
  }//end main
}//end class SwingEvent09
//=======================================================//

//Subclass JFrame in order to override the paint method.
class MyFrame extends JFrame{
  int clickX;
  int clickY;

  public void paint(Graphics g){
    g.drawString(
             "" + clickX + ", " + clickY, clickX, clickY);
  }//end paint()
}//end class MyFrame
//=======================================================//

//The following class is used to instantiate a;
// graphical user interface object.
class GUI {
  public GUI(){//constructor
    //Create a new JFrame object, set size, title, etc.
    MyFrame displayWindow = new MyFrame();
    displayWindow.setSize(300,300);
    displayWindow.setTitle("Copyright, R.G.Baldwin");
    displayWindow.setVisible(true);

    //Instantiate and register an anonymous Listener;
    // object which will terminate the program when the;
    // user closes the JFrame.
    displayWindow.addWindowListener(new WProc1());

    //Instantiate and register an anonymous Listener;
    // object that will process mouse events to determine
    // and display the coordinates when the user presses
    // the mouse button in the client area of the JFrame.
    displayWindow.addMouseListener(
                             new MouseProc(displayWindow));
  }//end constructor
}//end class GUI definition
//=======================================================//

//This listener class monitors for mouse presses and;
// displays the coordinates of the mouse pointer when the
// mouse is pressed on the source object. Note that this
// class extends is an adapter class.
class MouseProc extends MouseAdapter{
  MyFrame refToWin; //save a reference to the source here

  MouseProc(MyFrame inWin){//constructor
    refToWin = inWin;//save ref to window
  }//end constructor

  //Override the mousePressed method to determine and;
  // display the coordinates when the mouse is pressed.
  public void mousePressed(MouseEvent e){
    //Get X and Y coordinates of mouse pointer and store
    // in an instance variable of the JFrame object
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();

    //Force the JFrame object to be repainted in order to
    // display the coordinate information.
    refToWin.repaint();
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

//The following listener is used to terminate the program
// when the user closes the frame.  Note that this class
// extends an adapter class.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//

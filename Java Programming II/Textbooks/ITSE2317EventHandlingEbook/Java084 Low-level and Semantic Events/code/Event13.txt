/*File Event13.java Copyright, R.G.Baldwin
Revised 03/09/98 to make it fit the page better.

This program is designed to be compiled and run
under JDK 1.1

The program demonstrates the object-manipulation capability
of low-level events.

A Button object and a TextField object are placed in a
Frame object.

A MouseListener object is instantiated and registered to
monitor for low-level mousePressed() events on all three
objects.  Whenever a mousePressed() event occurs, the
Listener object obtains and displays several pieces of
information about the object that generated the event.
Although this demonstration program only obtains and
displays information as a result of mousePressed() events,
all of the methods of the Component class are available for
use at that point.  Thus the code in the event handler
method could also modify some of the attributes of the
object that generated the event.

Finally, a WindowListener object is instantiated and
registered to terminate the program when the user closes
the Frame object.

Starting the program and then clicking sucessively on the
Button, the TextField, and the interior of the Frame
produces the following output.

Name = Button1
Parent's name = Frame
Location = java.awt.Point[x=4,y=23]
Minimum Size = java.awt.Dimension[width=54,height=21]
Size = java.awt.Dimension[width=192,height=21]

Name = TextField1
Parent's name = Frame
Location = java.awt.Point[x=4,y=275]
Minimum Size = java.awt.Dimension[width=104,height=21]
Size = java.awt.Dimension[width=192,height=21]

Name = Frame
No parent name available at this level
Location = java.awt.Point[x=0,y=0]
Minimum Size = java.awt.Dimension[width=112,height=69]
Size = java.awt.Dimension[width=200,height=300]


These results were produced using JDK 1.1.3, under Win95.
**********************************************************/

import java.awt.*;
import java.awt.event.*;

public class Event13 {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Event13
//=======================================================//

class GUI {
  public GUI(){//constructor
    //Create a visual TextField object
    TextField myTextField = new TextField("Initial String");
    myTextField.setName("TextField1");

    //Create a visual Button object
    Button myButton = new Button("Click me");
    myButton.setName("Button1");

    //Create a visual Frame object
    Frame myFrame = new Frame();
    myFrame.setSize(200,300);
    myFrame.setTitle("Copyright, R.G.Baldwin");
    myFrame.setName("Frame");

    //Add the Button and the TextField to the Frame object
    myFrame.add("North",myButton);
    myFrame.add("South",myTextField);
    myFrame.setVisible(true);

    //Instantiate and register a MouseListener object which
    // will process mouse events on the Frame object, the
    // Button object, and the TextField object.
    MouseProc mouseProcCmd = new MouseProc();
    myFrame.addMouseListener(mouseProcCmd);
    myTextField.addMouseListener(mouseProcCmd);
    myButton.addMouseListener(mouseProcCmd);

    //Instantiate and register a Listener object which will
    // terminate the program when the user closes the
    // Frame object
    WProc1 winProcCmd1 = new WProc1();
    myFrame.addWindowListener(winProcCmd1);
  }//end constructor
}//end class GUI definition
//=======================================================//

//Low-level event monitor.
// This listener class monitors for low-level
// mousePressed() events. Whenever  mousePressed() event
// occurs,  event handler obtains and displays several
// pieces of information about  object that generated
//  event.

class MouseProc extends MouseAdapter{
  public void mousePressed(MouseEvent e){
    System.out.println(
                   "Name = " + e.getComponent().getName());
    try{
      System.out.println("Parent's name = " +
                   e.getComponent().getParent().getName());
    }catch(NullPointerException exception){
      System.out.println(
                 "No parent name available at this level");
    }//end try/catch
    System.out.println("Location = " +
                e.getComponent().getLocation().toString());
    System.out.println("Minimum Size = " +
             e.getComponent().getMinimumSize().toString());
    System.out.println("Size = " +
                    e.getComponent().getSize().toString());
    System.out.println();//blank line
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

//The following listener class is used to terminate the
// program when the user closes the Frame object.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//

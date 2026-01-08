/*File Event08.java Copyright, R.G.Baldwin
Rev 01/10/98

Illustrates the use of Event Sources, Event Listeners, and
Adapters in the Delegation Event Model.

Briefly, this application instantiates an object which
creates a user interface consisting of a simple Frame
object.  This object is an Event Source which notifies two
different Event Listener objects of Window events.

One of the Listener objects implements the WindowListener
interface and overrides all of the methods declared in
that interface.

The other Listener object extends the Adapter class named
WindowAdapter.  The purpose of Adapter classes is to
implement the  Listener interfaces and to define all of
the methods with empty methods.  Classes which extend the
Adapter classes can then selectively override only those
methods of interest.  This Listener object overrides only
two of the methods.

Note that this application does not terminate and return
control to the operating system.  You must forcefully
terminate it.

This program was tested using JDK 1.1.3 under Win95.

When executed, this application places a simple empty
Frame object on the screen.

Starting the program produces the following output:
WProc1 windowActivated test msg
Wproc1 windowOpened test msg

Pressing the minimize button on the Frame produces the
following output:

WProc1 windowIconified test msg
******** WProc2 windowIconified test msg
WProc1 windowDeactivated test msg

Restoring the Frame after minimization produces the
following output:

WProc1 windowActivated test msg
WProc1 windowDeiconified test msg
******** WProc2 windowDeiconified test msg
WProc1 windowActivated test msg

Closing the Frame by pressing the X-icon in the upper
right of the Frame produces the following output.

WProc1 windowClosing test msg
WProc1 windowDeactivated test msg
WProc1 windowClosed test msg
**********************************************************/

import java.awt.*;
import java.awt.event.*;

public class Event08 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUInterface object
  }//end main
}//end class Event08
//=======================================================//

//The following class is used to instantiate a user
// interface object, to instantiate two Listener objects,
// and to register those two objects for notification
// whenever a Window event occurs.
class GUI{
  public GUI(){//constructor
    //Create a new Frame object
    Frame displayWindow = new Frame();
    displayWindow.setSize(300,200);
    displayWindow.setTitle("Copyright, R.G.Baldwin");

    //Instantiate two Listener objects which will process
    // Window events
    WProc1 winProcCmd1 = new WProc1(displayWindow);
    WProc2 winProcCmd2 = new WProc2();

    //Register the Listener objects for notification of
    // Window events. This object is the Event Source.
    displayWindow.addWindowListener(winProcCmd1);
    displayWindow.addWindowListener(winProcCmd2);

    //windowActivated and windowOpened test messages
    // are produced here
    displayWindow.setVisible(true);

  }//end constructor
}//end class GUI definition
//=======================================================//

//The following two classs can be used to instantiate
// Listener objects. Note that this class implements the
// WindowListener interface.  This requires that all the
// methods declared in the interface be overridden in this
// class. This class overrides all of the methods  and
// displays a descriptive message whenever one of the
// methods is invoked.
class WProc1 implements WindowListener{
  //used to save a reference to the Frame object
  Frame displayWindowRef;

  WProc1(Frame windowIn){//constructor
    // save ref to Frame object
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

//This and the previous class can be used to instantiate
// Listener objects. Note that this class extends an
// Adapter class which can be used to avoid the
// requirement to define all of the methods of the
// actual Listener class named WindowListener. This class
// overrides only two of the methods declared in the
// interface.  It displays a message whenever one of the
// methods is invoked.
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

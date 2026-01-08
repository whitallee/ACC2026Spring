/*File Event09.java Copyright, R.G.Baldwin
This program is designed to be compiled under JDK 1.1

Illustrates the use of Event Sources, Event Listeners, and 
Adapters in the Delegation Event Model.

This program instantiates a Listener object to process 
mouse events. When a mouse press occurs in a Frame object,
the program gets the coordinates and then displays those
coordinates near the point of the mouse press.

This program was tested using JDK 1.1.3 under Win95.
**********************************************************/
import java.awt.*;
import java.awt.event.*;

public class Event09 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUI
  }//end main
}//end class Event09
//=======================================================//

//Subclass Frame in order to override the paint method.
class MyFrame extends Frame{
  int clickX;
  int clickY;
  
  public void paint(Graphics g){
    g.drawString(
             "" + clickX + ", " + clickY, clickX, clickY);
  }//end paint()
}//end class MyFrame
//=======================================================//

//The following class is used to instantiate a 
// graphical user interface object.
class GUI {
  public GUI(){//constructor
    //Create a new Frame object, set size, title, etc.
    MyFrame displayWindow = new MyFrame();
    displayWindow.setSize(300,300);
    displayWindow.setTitle("Copyright, R.G.Baldwin");
    displayWindow.setVisible(true);
    
    //Instantiate and register an anonymous Listener 
    // object which will terminate the program when the 
    // user closes the Frame.
    displayWindow.addWindowListener(new WProc1());
    
    //Instantiate and register an anonymous Listener 
    // object that will process mouse events to determine
    // and display the coordinates when the user presses
    // the mouse button in the client area of the Frame.
    displayWindow.addMouseListener(
                             new MouseProc(displayWindow));
  }//end constructor
}//end class GUI definition
//=======================================================//

//This listener class monitors for mouse presses and 
// displays the coordinates of the mouse pointer when the
// mouse is pressed on the source object. Note that this
// class extends is an adapter class.
class MouseProc extends MouseAdapter{
  MyFrame refToWin; //save a reference to the source here
  
  MouseProc(MyFrame inWin){//constructor
    refToWin = inWin;//save ref to window
  }//end constructor

  //Override the mousePressed method to determine and 
  // display the coordinates when the mouse is pressed.
  public void mousePressed(MouseEvent e){
    //Get X and Y coordinates of mouse pointer and store
    // in an instance variable of the Frame object
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();
    
    //Force the Frame object to be repainted in order to
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
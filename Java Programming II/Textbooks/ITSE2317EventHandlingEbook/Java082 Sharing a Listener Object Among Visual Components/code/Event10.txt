/*File Event10.java Copyright, R.G.Baldwin
This program is designed to be compiled and run under 
JDK 1.1

The program illustrates the sharing of a single listener 
object among two different visual components of the same 
type.

The program detects mouse events occuring on either of two
different Frame objects.  It distinguishes between the two
objects on the basis of the component name, and displays 
the coordinates of a mouse click on whichever object 
experienced the mouse click.

This program was tested using JDK 1.1.3 under Win95.

Note that when the program starts, the two visual 
components overlay one another.  It is necessary to move 
one of them in order to access the other.
**********************************************************/

import java.awt.*;
import java.awt.event.*;

public class Event10 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUI
  }//end main
}//end class Event10
//=======================================================//

//Subclass Frame in order to override the paint method.
class MyFrame extends Frame{
  int xCoor;
  int yCoor;

  MyFrame(String name){//constructor
    setTitle("Copyright, R.G.Baldwin");
    setSize(300,200);
    //Name used to distinguish between the two objects
    setName(name);
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
    // them visible. Name them Frame1 and Frame2.
    MyFrame myFrame1 = new MyFrame("Frame1");
    myFrame1.setVisible(true);
    
    MyFrame myFrame2 = new MyFrame("Frame2");
    myFrame2.setVisible(true);    
    
    //Instantiate and register Listener object which will
    // terminate the program when the user closes either 
    // window.
    WProc1 winProcCmd1 = new WProc1();
    myFrame1.addWindowListener(winProcCmd1);
    myFrame2.addWindowListener(winProcCmd1);    
    
    //Instantiate and register Listener object which will
    // process mouse events on either MyFrame object.
    MouseProc mouseProcCmd = 
                         new MouseProc(myFrame1,myFrame2);
    myFrame1.addMouseListener(mouseProcCmd);
    myFrame2.addMouseListener(mouseProcCmd);    
  }//end constructor
}//end class GUI definition
//=======================================================//

//This listener class monitors for mouse presses and 
// displays the coordinates of the mouse pointer when the 
// mouse is pressed.  The listener object distinguishes 
// between two different visual objects on the basis of 
// their component names and displays the coordinate 
// information on the visual object which generated the 
// mouse event.

class MouseProc extends MouseAdapter{
  //save references to the objects here
  MyFrame refToFrame1,refToFrame2; 
  
  MouseProc(MyFrame inFrame1,MyFrame inFrame2){//construct
    refToFrame1 = inFrame1;//save references to the frames
    refToFrame2 = inFrame2;
  }//end constructor

  //Override the mousePressed() method to respond whenever
  // the mouse is pressed on one of the frame objects.  
  // Distinguish between the two frame objects using the 
  // component name and display the coordinates of the 
  // mouse on the correct object.
  public void mousePressed(MouseEvent e){
    if( e.getComponent().getName().compareTo("Frame1") 
                                                    == 0 ){
      //Get X and Y coordinates of mouse pointer
      // and store in the Frame object
      refToFrame1.xCoor = e.getX();
      refToFrame1.yCoor = e.getY();
      //display coordinate information
      refToFrame1.repaint();
    }else{
      //Get X and Y coordinates of mouse pointer
      //and store in the Frame object
      refToFrame2.xCoor = e.getX();
      refToFrame2.yCoor = e.getY();
      //display coordinate information    
      refToFrame2.repaint();
    }//end if-else
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

//The following listener is used to terminate the program
// when the user closes either frame object. Note that 
// class extends the adapter class
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//

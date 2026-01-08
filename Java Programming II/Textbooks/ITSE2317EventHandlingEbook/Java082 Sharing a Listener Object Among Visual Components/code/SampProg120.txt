/*File SampProg120.java from lesson 82
Copyright, R.G.Baldwin

Without viewing the solution that follows, write a Java
application that displays two Frame objects on the screen.

Each object has a width of 300 pixels and a height of 200
pixels.

One object is located in the upper left-hand corner of the
screen.  The top left-hand corner of the other object barely
touches the bottom right-hand corner of the first object.

Make your name and the name of each object appear in the
banner at the top of each object.

Do not assign names to the objects.

Cause the two objects to share a single Listener object
to respond to mouse events.

Whenever the mouse is pressed internal to either object,
the coordinates of the mouse pointer are displayed near
the pointer on that object with the horizontal coordinate
being displayed first followed by the vertical coordinate.
The two coordinate values are separated by a comma and a
space.

Also cause the two objects to share a sigle Listener
object that will terminate the program whenever the user
clicks the "close" button on either object.

Make certain that your application terminates and returns
control to the operating system when the user clicks on 
the "close" button in the upper right-hand corner of the 
object.

*/
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class SampProg120 {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class SampProg120
//---------------------------------------------------------

//Subclass Frame in order to override the paint method.
class MyFrame extends Frame{
  int xCoor;
  int yCoor;

  MyFrame(){//constructor
    setTitle("Baldwin " + this.getName());
    setSize(300,200);
  }//end constructor
  
  public void paint(Graphics g){//override paint() method
    //display coordinate information on the object
    g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
  }//end paint()
}//end class MyFrame
//---------------------------------------------------------

class GUI {
  public GUI(){//constructor
    //Create two visual objects of type MyFrame, specify
    // their locations, and make them visible.
    MyFrame myFrame1 = new MyFrame();
    myFrame1.setLocation(new Point(0,0));
    myFrame1.setVisible(true);
    
    MyFrame myFrame2 = new MyFrame();
    myFrame2.setLocation(new Point(300,200));    
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
//---------------------------------------------------------

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
  
  MouseProc(MyFrame inFrame1,MyFrame inFrame2){//constructor
    refToFrame1 = inFrame1;//save references to the frames
    refToFrame2 = inFrame2;
  }//end constructor

  //Override the mousePressed() method to respond whenever 
  // the mouse is pressed on one of the frame objects.  
  // Distinguish between the two frame objects using the 
  // component name and display the coordinates of the 
  // mouse on the correct object.
  public void mousePressed(MouseEvent e){
     if( e.getComponent().getName().
          compareTo(refToFrame1.getName()) == 0)
    { 
      refToFrame1.xCoor = e.getX();
      refToFrame1.yCoor = e.getY();
      //display coordinates on Frame1
      refToFrame1.repaint();
    }else{ 
      refToFrame2.xCoor = e.getX();
      refToFrame2.yCoor = e.getY();
      //display coordinates on Frame2
      refToFrame2.repaint();
    }//end if-else
  }//end mousePressed()
}//end class MouseProc
//---------------------------------------------------------

//The following listener is used to terminate the program 
// when the user closes either frame object.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//---------------------------------------------------------
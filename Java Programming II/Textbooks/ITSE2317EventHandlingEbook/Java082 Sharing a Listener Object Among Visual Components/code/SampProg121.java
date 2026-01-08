/*File SampProg121.java from lesson 82
Copyright, R.G.Baldwin

Without viewing the solution that follows, write a Java
application that displays two Frame objects on the screen.
Place a red Panel object in the upper-left quadrant of the
second Frame object.

Each Frame object has a width of 300 pixels and a height 
of 200 pixels.

One Frame object is located in the upper left-hand corner 
of the screen.  The top left-hand corner of the second
Frame object barely touches the bottom right-hand corner of
the first Frame object.

Make your name and the name of each Frame object appear in 
the banner at the top of each Frame object.

Cause the first Frame object and the Panel object to 
share a single Listener object to respond to mouse events.
Do not allow the second Frame object to share the Listener
object for mouse events.

Whenever the mouse is pressed internal to the first Frame
object, or on the red portion of the Panel object, the 
coordinates of the mouse pointer are displayed near
the pointer on that object with the horizontal coordinate
being displayed first followed by the vertical coordinate.
The two coordinate values are separated by a comma and a
space.

Whenever the mouse is pressed internal to the second Frame
object, but not on the red Panel object, coordinate values
are not displayed.

Also cause the two Frame objects to share a single Listener
object that will terminate the program whenever the user
clicks the "close" button on either Frame object.

Make certain that your application terminates and returns
control to the operating system when the user clicks on 
the "close" button in the upper right-hand corner of either
Frame object.

*/
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class SampProg121 {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class SampProg121
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

//Subclass Panel in order to override the paint method.
class MyPanel extends Panel{
  int xCoor;
  int yCoor;

  MyPanel(){//constructor
    setBounds(new Rectangle(0,0,150,100));  
    setBackground(Color.red);
  }//end constructor
  
  public void paint(Graphics g){//override paint() method
    //display coordinate information on the object
    g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
  }//end paint()
}//end class MyFrame
//---------------------------------------------------------

class GUI {
  public GUI(){//constructor
    //Instantiate an object of type MyPanel
    MyPanel myPanel = new MyPanel();    
  
    //Instantiate two objects of type MyFrame, specify
    // their locations, and make them visible.  Place the
    // MyPanel object in the second MyFrame object.
    MyFrame myFrame1 = new MyFrame();
    myFrame1.setLocation(new Point(0,0));
    myFrame1.setVisible(true);
    
    MyFrame myFrame2 = new MyFrame();
    myFrame2.setLayout(null);
    myFrame2.setLocation(new Point(300,200));
    myFrame2.add(myPanel);
    myFrame2.setVisible(true);
   
    //Instantiate and register a Listener object which will 
    // terminate the program when the user closes either 
    // window.
    WProc1 winProcCmd1 = new WProc1();
    myFrame1.addWindowListener(winProcCmd1);
    myFrame2.addWindowListener(winProcCmd1);    
    
    //Instantiate and register a Listener object which will 
    // process mouse events on either the MyFrame object
    // or the myPanel object.
    MouseProc mouseProcCmd = 
      new MouseProc(myFrame1,myPanel);
    myFrame1.addMouseListener(mouseProcCmd);
    myPanel.addMouseListener(mouseProcCmd);    
    
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
  MyFrame refToFrame1;
  MyPanel refToPanel;
  
  MouseProc(MyFrame inFrame1,MyPanel inPanel){//constructor
    refToFrame1 = inFrame1;//save references to the frames
    refToPanel = inPanel;
  }//end constructor

  //Override the mousePressed() method to respond whenever 
  // the mouse is pressed on one of the frame objects.  
  // Distinguish between the two frame objects using the 
  // component name and display the coordinates of the 
  // mouse on the correct object.
  public void mousePressed(MouseEvent e){
     if( e.getComponent().getName().
          compareTo(refToFrame1.getName()) == 0)
    { //display coordinates on the Frame object
      refToFrame1.xCoor = e.getX();
      refToFrame1.yCoor = e.getY();
      refToFrame1.repaint();
    }else{//display coordinates on the Panel object
      refToPanel.xCoor = e.getX();
      refToPanel.yCoor = e.getY();
      refToPanel.repaint();
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

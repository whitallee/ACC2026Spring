/*File Event21A.java Copyright, R.G.Baldwin
This program is designed to be compiled and run under JDK 1.1.3

The program illustrates the mouseDragged event used in
conjunction with the mousePressed() event to drag a label
object on a Panel object within a Frame object in a
crude form of Drag-and-Drop.

The program also illustrates the mouseMoved event by
displaying the contents of the object passed as a parameter
to the event when the mouse is moved within the label
without pressing a mouse button.

A yellow Label is placed on a Panel which is placed in a 
Frame.

A MouseListener object and a MouseMotionListener object are
instantiated and registered to receive mouse events on the 
Label object.

The user can drag the yellow Label object by dragging the 
mouse internal to the Label object.

Comments within the code explain the algorithm which uses
the information provided by the mouseDown and mouseDragged
events to move the label object.

The purpose of this program is simply to demonstrate the 
use of the MouseMotionListener interface as compared to the
MouseListener unterface.  It is not intended to be a 
polished Drag-and-Drop program.  

Finally, a WindowListener object is instantiated and 
registered to terminate the program when the user closes 
the Frame object.

These results were produced using JDK 1.1.3 running under 
Windows 95.

Possible bugs in JDK 1.1.3 for Win 95 relative to the
mouseDragged and mouseMoved events are described by 
comments in the code.  Briefly, when the mouse is moved
in such a manner as to cause a large number of such events
to be generated over an extended period, the system 
simply stops generating events.
*/
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class Event21A {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class Event21A
//=========================================================

class GUI {
  Label myLabel;//reference variables passed as parameters
  LabelInfo myLabelInfo;
  int initialX = 50; //initial location of the label object
  int initialY = 25;

  public GUI(){//constructor
    //Create visual components
    myLabel = new Label("LabelObject");//create a label
    myLabel.setBackground(Color.yellow);//make it yellow

    //create a panel to place the panel on
    Panel myPanel = new Panel(); 
    myPanel.setLayout(null); //no layout manager wanted
    myPanel.add(myLabel); //place the label on the panel
    //Adjust x,y,width & height
    myLabel.setBounds(initialX,initialY,125,100); 
    
    Frame myFrame = new Frame();//frame to contain it all
    myFrame.setSize(600,600);
    myFrame.setTitle("Copyright, R.G.Baldwin");
    myFrame.add("Center",myPanel); //place panel in frame
    myFrame.setVisible(true);//make it all visible

    //Create bject to maintain info about the label
    // while it is being dragged about.
    myLabelInfo = new LabelInfo();
    myLabelInfo.labelX = initialX;
    myLabelInfo.labelY = initialY;

    //Instantiate and register MouseListener 
    // and MouseMotionListener    
    myLabel.addMouseMotionListener(
          new MyMouseMotionProcessor(myLabelInfo,myLabel));
    myLabel.addMouseListener(
                new MyMouseProcessor(myLabelInfo,myLabel));    

    //Instantiate and register a WindowListener object 
    // which will terminate the program when the user 
    // closes the Frame object
    WProc1 winProcCmd1 = new WProc1();
    myFrame.addWindowListener(winProcCmd1);
  }//end constructor
}//end class GUI definition
//=========================================================

//This is a simple wrapper class used to maintain info for
// several position parameters used while dragging the 
// label object.
class LabelInfo{//class to maintain info about a label which is dragged
  int labelX;
  int labelY;
  int mousePressedX;
  int mousePressedY;
  int mouseDraggedX;
  int mouseDraggedY;
}//end class LabelInfo

//=========================================================

//This class recognizes mousePressed().  This method is 
// used to determine the starting position of the mouse
// pointer.
class MyMouseProcessor extends MouseAdapter{
  LabelInfo theLabelInfo;
  Label theLabel;
  
  //Constructor
  MyMouseProcessor(LabelInfo inLabelInfo, Label inLabel){
    //save references to the input objects
    theLabelInfo = inLabelInfo;
    theLabel = inLabel;
  }//end constructor
  
  public void mousePressed(MouseEvent e){
    //save starting position of mouse pointer
    theLabelInfo.mousePressedX = e.getX();
    theLabelInfo.mousePressedY = e.getY();
  }//end mousePressed()

}//end MyMouseProcessor

//=======================================================================
class MyMouseMotionProcessor extends MouseMotionAdapter{
  LabelInfo theLabelInfo;
  Label theLabel;

  //Constructor  
  MyMouseMotionProcessor(
                     LabelInfo inLabelInfo, Label inLabel){
    //save incoming object reference
    theLabelInfo = inLabelInfo;
    theLabel = inLabel;
  }// end constructor
  
  public void mouseDragged(MouseEvent e){
    System.out.println("Drag = " + e);
    //Save mouse coordinates during the drag operation.
    theLabelInfo.mouseDraggedX = e.getX();
    theLabelInfo.mouseDraggedY = e.getY();


    /* How does this work?
    Dragging the mouse on the yellow label produces a
    stream of events of this type.  This method is called
    once for each event. When an event occurs, if the
    mouse has been dragged a distance equal to a full
    pixel (or more), in either or both directions, 
    the X and Y values of the mouseDragged event
    are used to reposition the label by that distance in 
    one or both of those directions.  This causes the
    label to slide under the mouse pointer so that the
    X and Y values of the next mouseDragged event revert
    back to the original Y and Y values of the original
    mouseDown event.  In other words, the motion of the
    label is such as to cause the coordinates of the
    mouseDragged event to continue to be equal to the
    coordinates of the original mouseDown event, or to
    cause the difference between the two to be zero.
    
    Think of the following expressions as a feedback system
    that strives to drive an error signal to zero where
    the error signal is the difference between the
    coordinates of the current mouseDragged event and the
    coordinates of the original mouseDown event.
    
    Note that when the yellow label is dragged rapidly
    and randomly for an extended period of time, the system
    simply quits generating mouseDragged events.  This may
    be a bug in JDK 1.1.3 for Win95.
    */
 
    int newX = theLabelInfo.labelX
                              + theLabelInfo.mouseDraggedX
                              - theLabelInfo.mousePressedX;
    int newY = theLabelInfo.labelY
                              + theLabelInfo.mouseDraggedY
                              - theLabelInfo.mousePressedY;
      
    //move label to the new location
    theLabel.setLocation(newX,newY);
    
    //save the new location information
    theLabelInfo.labelX = newX; 
    theLabelInfo.labelY = newY;
    
  }//end mouseDragged()
  
  public void mouseMoved(MouseEvent e){
  /*This method is implemented here simply for 
    illustration.  It displays the contents of the
    object passed in for each mouseMoved event.  
    
    It also illustrates a possible bug in JDK 1.1.3
    for Win 95.  In particular, when the mouse is moved
    rapidly and randomly within the yellow label for
    an extended period, at some point, mouseMoved
    events cease to be generated.
    */
    System.out.println("Move = " + e);  
  }//
}//end class MyMouseMotionProcessor  
//=======================================================================

//The following listener is used to terminate the 
// program when the user closes the Frame object.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================================
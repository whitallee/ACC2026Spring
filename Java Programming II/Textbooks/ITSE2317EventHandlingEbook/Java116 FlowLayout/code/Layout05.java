/*File Layout05.java Copyright, R.G.Baldwin
Revised 10/28/97 to better accommodate the display width
of the document.

This program is designed to be compiled and run under 
JDK 1.1

This program has more substance that the previous one in 
this lesson. Although it doesn't do anything particularly 
useful, it does illustrate how to modify a flow layout 
dynamically at runtime.

Five buttons are added to a frame using a FlowLayout object
as the layout manager with a three-pixel gap between 
components in both the horizontal and vertical direction.

An action listener object is instantiated and registered to
listen for action events on all five of the buttons, with 
all five buttons sharing the same event handler.

The behavior of the ActionEvent handler is to increase the
spacing between components whenever any of the buttons is 
pressed.  This is accomplished by increasing the Vgap and 
Hgap attributes of the FlowLayout object, setting the 
layout manager of the frame to the modified FlowLayout 
object, and validating the frame.  The validation step is 
required in order for the change to become visible.

Repeatedly clicking any of the buttons causes the buttons 
to move apart. Eventually they will not all fit on the 
frame and they begin to disappear off the edges.  They can
be made to reappear by enlarging the frame.

A windowClosing() event listener object is instantiated and
registered on the frame to terminate the program when the 
frame is closed.

The program was tested using JDK 1.1.3 running under Win95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;
//=======================================================//
public class Layout05 {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Layout05
//=======================================================//

class GUI {
  public GUI(){//constructor
    Frame myFrame = new Frame(
                            "Copyright, R.G.Baldwin");
    //Instantiate a FlowLayout object with CENTER 
    // alignment and a Vgap and Hgap of 3 pixels.
    FlowLayout myFlowLayout = 
                     new FlowLayout(FlowLayout.CENTER,3,3);
    //Set the layout manager for the frame to be the 
    // FlowLayout object.
    myFrame.setLayout(myFlowLayout);

    //Instantiate five Button objects    
    Button button1 = new Button("First");
    Button button2 = new Button("Second");
    Button button3 = new Button("Third");
    Button button4 = new Button("Fourth");
    Button button5 = new Button("Fifth");

    //Add the five Button objects to the Frame object in 
    // the order specified.
    myFrame.add(button1);
    myFrame.add(button2);
    myFrame.add(button3);
    myFrame.add(button4);
    myFrame.add(button5);

    myFrame.setSize(250,150);
    myFrame.setVisible(true);

    //Instantiate an action listener object and register it
    // on all five buttons.    
    MyActionListener myActionListener = 
        new MyActionListener(myFlowLayout,myFrame);
    button1.addActionListener(myActionListener);
    button2.addActionListener(myActionListener);
    button3.addActionListener(myActionListener);
    button4.addActionListener(myActionListener);
    button5.addActionListener(myActionListener);
    
    //Instantiate and register a window listener to 
    // terminate the program when the Frame is closed.    
    myFrame.addWindowListener(new Terminate());
  }//end constructor
}//end class GUI definition
//=======================================================//

class MyActionListener implements ActionListener{
  FlowLayout myFlowLayoutObject;
  Frame myFrameObject;
  
  //constructor
  MyActionListener(FlowLayout layoutObject,Frame inFrame){
    myFlowLayoutObject = layoutObject;
    myFrameObject = inFrame;
  }//end constructor
  
  //When an action event occurs, increase the horizontal 
  // and vertical gap between components in the FlowLayout 
  // object.  Then set the layout manager for the frame to
  // be the newly-modified FlowLayout object.  Then 
  // validate the frame to ensure a valid layout so that 
  // the new visual will take effect.
  public void actionPerformed(ActionEvent e){
    myFlowLayoutObject.setHgap(
                        myFlowLayoutObject.getHgap() + 5 );
    myFlowLayoutObject.setVgap(
                        myFlowLayoutObject.getVgap() + 5 );    
    myFrameObject.setLayout(myFlowLayoutObject);
    myFrameObject.validate();
  }//end actionPerformed()
}//end class MyActionListener

//=======================================================//

class Terminate extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    //terminate the program when the window is closed
    System.exit(0);  
  }//end windowClosing
}//end class Terminate
//=======================================================//

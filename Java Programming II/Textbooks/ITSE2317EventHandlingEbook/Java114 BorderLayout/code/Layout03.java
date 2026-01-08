/*File Layout03.java Copyright, R.G.Baldwin
Revised 10/26/97 to cause the source code to better fit in
the allocated space in the lesson.

This program is designed to be compiled and run under 
JDK 1.1

This program has more substance that the previous one in 
this lesson, although it doesn't do anything particularly 
useful.

Five buttons are added to a frame using a BorderLayout 
object as the layout manager with a three-pixel gap between
components in both the horizontal and vertical direction.

An action listener object is instantiated and registered to
listen for action events on all five of the buttons, with 
all five buttons sharing the same event handler.

The behavior of the action event handler is to increase the
spacing between components whenever any of the buttons is 
pressed.  This is accomplished by increasing the Vgap and 
Hgap attributes of the BorderLayout object, setting the 
layout manager of the frame to the modified BorderLayout 
object, and validating the frame.  The validation step is 
required in order for the change to become visible.

If you continue to click the buttons long enough, three of 
the buttons will shrink entirely out of sight.  They can be
made to reappear by manually enlarging the frame.

A windowClosing() event listener object is instantiated and
registered on the frame to terminate the program when the 
frame is closed.

The program was tested using JDK 1.1.3 running under Win95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;
//=======================================================//
public class Layout03 {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Layout03
//=======================================================//

class GUI {
  public GUI(){//constructor
    Frame myFrame = new Frame(
                            "Copyright, R.G.Baldwin");
    //Instantiate a BorderLayout object with default Center
    // alignment and a Vgap and Hgap of 3 pixels.
    BorderLayout myBorderLayout = new BorderLayout(3,3);
    //Set the layout manager for the frame to be the 
    // BorderLayout object.
    myFrame.setLayout(myBorderLayout);

    //Instantiate five Button objects    
    Button button1 = new Button("South");
    Button button2 = new Button("West");
    Button button3 = new Button("North");
    Button button4 = new Button("East");
    Button button5 = new Button("Center");

    //Add the five Button objects to the Frame object in 
    // the positions specified.
    myFrame.add(button1,"South");
    myFrame.add(button2,"West");
    myFrame.add(button3,"North");
    myFrame.add(button4,"East");
    myFrame.add(button5,"Center");

    myFrame.setSize(250,150);
    myFrame.setVisible(true);

    //Instantiate an action listener object and register 
    // it on all five buttons.    
    MyActionListener myActionListener = 
        new MyActionListener(myBorderLayout,myFrame);
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
  BorderLayout myBorderLayoutObject;
  Frame myFrameObject;
  
  //constructor
  MyActionListener(
                  BorderLayout layoutObject,Frame inFrame){
    myBorderLayoutObject = layoutObject;//save references
    myFrameObject = inFrame;
  }//end constructor
  
  //When an action event occurs, increase the horizontal 
  // and vertical gap between components in the 
  // BorderLayout object.  Then set the layout manager for 
  // the frame to be the newly-modified BorderLayout 
  // object.  Then validate the frame to ensure a valid
  // layout so that the new visual will take effect.
  public void actionPerformed(ActionEvent e){
    myBorderLayoutObject.setHgap(
                      myBorderLayoutObject.getHgap() + 5 );
    myBorderLayoutObject.setVgap(
                      myBorderLayoutObject.getVgap() + 5 );
    myFrameObject.setLayout(myBorderLayoutObject);
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

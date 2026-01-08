/*File Layout01.java Copyright, R.G.Baldwin
Revised 10/27/97 to improve the layout on the page.

This program is designed to be compiled and run under 
JDK 1.1

The program shows how to use the new methods in JDK 1.1 to 
set the size and position of components in a Frame object 
using absolute coordinates.

The program also illustrates some of the problems 
associated with the use of absolute coordinates.

A button and a yellow label are placed in a Frame object.  
Note that the two objects may overlap, and that the initial
height of the Frame object may clip off the bottom of the 
Label.

Note also that if the Frame is resized by the user, the 
Button and the Label remain fixed in size and position.  
The Frame can be resized to the point where the two 
components are no longer visible.

Note also that the specified size of the Label may not be
sufficient to display all of the initial text placed in the
label.

For simplicity, no event handler is provided for the Button
and no event handler is provided for the "Close" button on 
the Frame. Therefore, it is necessary to terminate the 
program using some other method.

The program was tested using JDK 1.1.3 running under Win95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;
//=======================================================//
public class Layout01 {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Layout01
//=======================================================//

//The following class is used to instantiate a graphical 
// user interface object.
class GUI {
  public GUI(){//constructor
    //Create a Button object with the specified caption and
    // the specified size and location within its container
    // (in pixels).
    Button myButton = new Button("Button");
    //Arguments are x,y,width,height
    myButton.setBounds(new Rectangle(25,50,100,75));
    
    //Create a Label object with the specified initial text
    // and the specified size and location within its 
    // container (in pixels).  Make it yellow so that its 
    // outline will be visible.    
    Label myLabel = new Label(
                            "Copyright, R.G.Baldwin");
    //Arguments are x,y,width,height
    myLabel.setBounds(new Rectangle(100,100,100,75));    
    myLabel.setBackground(Color.yellow);

    //Create a Frame object with the specified title, and 
    // with no layout manager so that size and location of 
    // components shown above will be effective.
    Frame myFrame = new Frame(
                            "Copyright, R.G.Baldwin");
    //Note the following null argument.
    myFrame.setLayout(null);

    //Add the two components to the Frame, set its size in
    // pixels, and make it visible.    
    myFrame.add(myButton);
    myFrame.add(myLabel);
    myFrame.setSize(250,150);
    myFrame.setVisible(true);
  }//end constructor
}//end class GUI definition
//=======================================================//


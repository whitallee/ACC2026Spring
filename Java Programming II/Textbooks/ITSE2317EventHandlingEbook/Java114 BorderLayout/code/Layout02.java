/*File Layout02.java Copyright, R.G.Baldwin
Revised 10/27/97 to better fit within the space alloted.
This program is designed to be compiled and run under 
JDK 1.1

This program creates a "Plain Vanilla" visual object by 
placing five non-functional Button objects on a Frame 
object using the default BorderLayout manager.

One of the buttons is given a long label in order to force
the layout manager to allocate space according to the 
minimum size requirement of that particular button.

The program was tested using JDK 1.1 running under Win95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;
//=======================================================//
public class Layout02 {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Layout02
//=======================================================//

class GUI {
  public GUI(){//constructor
    Frame myFrame = new Frame(
                            "Copyright, R.G.Baldwin");
    myFrame.add(new Button("South"),"South");
    myFrame.add(new Button("West"),"West");
    myFrame.add(new Button("North"),"North");
    myFrame.add(new Button(
                         "East with a long label"),"East");
    myFrame.add(new Button("Center"),"Center");
    myFrame.setSize(250,150);
    myFrame.setVisible(true);
  }//end constructor
}//end class GUI definition
//=======================================================//


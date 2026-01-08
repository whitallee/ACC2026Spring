/*File Layout06.java Copyright, R.G.Baldwin
Revised 10/29/97 to correct a logic error in the
earlier version.

This program is designed to be compiled and run under 
JDK 1.1

This program illustrates use of the GridLayout manager.  
Equally important, this program illustrates  building a 
fairly complex user interface object through the 
composition of subunits. Finally, the program illustrates
the process of dynamically modifying a layout at runtime.

The top-level user interface consists of a Frame object.  
Two Panel objects are placed on the Frame object using the 
default BorderLayout manager.

One of the Panel objects contains six Button objects which 
are placed there using a GridLayout manager.  These buttons
are placed on the Panel object using a GridLayout manager 
for illustration of layout only, and they are not 
functional (they have no registered listener objects).

The buttons are initially placed on this panel in a grid 
pattern consisting of two rows and three columns.  This is 
accomplished by passing the appropriate parameters to the 
constructor for the GridLayout object used to establish the
layout manager for the panel.

The other Panel object contains two Button objects labeled
3x2 and 2x3.  These buttons are placed on the panel using 
the default FlowLayout manager. These buttons are 
functional.  When the user clicks the button labeled 3x2,
the buttons on the other Panel object are arranged into 
three rows and two colums.  Similarly, when the user clicks
the button labeled 2x3, the buttons on the other Panel 
object are arranged into two rows and three columns.

A windowClosing() event listener object is instantiated and
registered on the frame to terminate the program when the 
frame is closed.

The program was tested using JDK 1.1.3 running under Win95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;
//=======================================================//
public class Layout06 {
  public static void main(String[] args){
    //instantiate a Graphical User Interface object
    GUI gui = new GUI();
  }//end main
}//end class Layout06
//=======================================================//

class GUI {
  Panel panel1;
  
  public GUI(){//constructor
    //Instantiate two button objects that will later 
    // become functional
    Button button7 = new Button("3x2");
    Button button8= new Button("2x3");    

    //Instantiate a layout manager object to be used with 
    // a Panel object
    GridLayout myGridLayout = new GridLayout(2,3);//row,col

    //Instantiate the first of two Panel objects that will 
    // be composited onto a Frame object.
    panel1 = new Panel();
    //Specify the GridLayout manager for the Panel object
    panel1.setLayout(myGridLayout);
    //Place six Button objects on the Panel with labels 
    // as shwon
    for(int cnt = 0; cnt < 6; cnt++)
      panel1.add(new Button("Button" + cnt));

    //Instantiate the second Panel object using default 
    // FlowLayout and place two Botton objects on it.  
    // These buttons will become functional later when 
    // ActionListener objects are registered on them.
    Panel panel2 = new Panel();
    panel2.add(button7);
    panel2.add(button8);  

    //Instantiate a Frame object which will become the 
    // top-level user-interface object.  
    Frame myFrame = new Frame(
                            "Copyright, R.G.Baldwin");
    
    //IMPORTANT Add the two previously prepared Panel 
    // objects to the Frame object to create the composite 
    // user-interface object.
    myFrame.add(panel1,"North");
    myFrame.add(panel2,"South");

    myFrame.setSize(250,150);
    myFrame.setVisible(true);

    //Instantiate action listener objects and register on 
    // button7 & button8
    button7.addActionListener(
        new A3x2ActionListener(myGridLayout,myFrame,this));
    button8.addActionListener(
        new A2x3ActionListener(myGridLayout,myFrame,this));
    
    //Instantiate and register a window listener to 
    // terminate the program when the Frame is closed.    
    myFrame.addWindowListener(new Terminate());
  }//end constructor
}//end class GUI definition
//=======================================================//

//The next two classes are ActionListener classes.  One 
// object of each is instantiated and registered on the two
// active buttons respectively.  The purpose of these event
// handlers is to modify the GridLayout manager for one of 
// the Panel objects that make up the composite 
// user-interface object.  The first of these two classes 
// sets the grid to 3 rows by 2 columns.  The other class 
// sets the grid to 2 rows by 3 columns.

//=======================================================//
class A3x2ActionListener implements ActionListener{
  GridLayout myGridLayoutObject;
  Frame myFrameObject;
  GUI myGuiObject;
  
  //constructor  
  A3x2ActionListener(GridLayout layoutObject,
                           Frame inFrame,GUI inGuiObject){
    myGridLayoutObject = layoutObject;
    myFrameObject = inFrame;
    myGuiObject = inGuiObject;
  }//end constructor
  
  //When an action event occurs, set the rows to 3 and the 
  // columns to 2 in the GridLayout object.  Then set the 
  // layout manager for the frame to be the newly-modified 
  // GridLayout object.  Then validate the frame to ensure 
  // a valid layout so that the new visual will 
  // take effect.
  public void actionPerformed(ActionEvent e){
    myGridLayoutObject.setRows(3);
    myGridLayoutObject.setColumns(2);
    myGuiObject.panel1.setLayout(myGridLayoutObject);
    myFrameObject.validate();
  }//end actionPerformed()
}//end class A3x2ActionListener
//=======================================================//

class A2x3ActionListener implements ActionListener{
  GridLayout myGridLayoutObject;
  Frame myFrameObject;
  GUI myGuiObject;
  
  //constructor
  A2x3ActionListener(GridLayout layoutObject,
                            Frame inFrame,GUI inGuiObject){
    myGridLayoutObject = layoutObject;
    myFrameObject = inFrame;
    myGuiObject = inGuiObject;
  }//end constructor
  
  //When an action event occurs, set the rows to 2 and the 
  // columns to 3 in the GridLayout object.  Then set the 
  // layout manager for the frame to be the newly-modified 
  // GridLayout object.  Then validate the frame to ensure 
  // a valid layout so that the new visual will 
  // take effect.
  public void actionPerformed(ActionEvent e){
    myGridLayoutObject.setRows(2);
    myGridLayoutObject.setColumns(3);
    myGuiObject.panel1.setLayout(myGridLayoutObject);
    myFrameObject.validate();
  }//end actionPerformed()
}//end class A3x2ActionListener
//=======================================================//

class Terminate extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    //terminate the program when the window is closed  
    System.exit(0);
  }//end windowClosing
}//end class Terminate
//=======================================================//
//Note:  Doesn't generate key events under v1.4.0
//Maybe has something to do with focus.
//Fixed the problem by adding the following statement
// to the constructor for the Frame:
// myCustomComp.requestFocus();


/*File Event30.java Copyright, R.G.Baldwin
Reformatted on 10/4/97.
This program was designed to be compiled and executed under
JDK 1.1.1.  The reformatted version was tested 
under JDK 1.1.3

This program demonstrates the use of the postEvent() method
to post events to the system EventQueue.

These features are used to intercept key events and convert
them into mouse events.

The main GUI object is of a class that extends Frame.

A custom component class named CustomComponent is defined.
Objects of this class are capable of responding to mouse 
events and key events.  An object of this class is added 
to the main Frame object.

An overridden processMouseEvent() method is provided for 
the CustomComponent class. Mouse events are enabled on 
objects of the class so that any mouse event on the object 
will be delivered to the processMouseEvent() method.  As is
always required, the overridden processMouseEvent() method 
passes the object to the method of the same name in the 
superclass before it terminates.

Physical mouse clicks on the CustomComponent object are 
delivered to the processMouseEvent() method where 
information about the events is displayed on the screen.  

Key events are trapped by a KeyListener object.  Whenever 
a key event is trapped, a synthetic MouseEvent object is 
created and posted to the system EventQueue.

The KeyListener object creates synthetic mouse events 
according to the following JDK 1.1.1 definition.
----------------------------------------------
  public MouseEvent(Component source,
                    int id,
                    long when,
                    int modifiers,
                    int x,
                    int y,
                    int clickCount,
                    boolean popupTrigger)

     Constructs a MouseEvent object with the specified 
       source component, type, modifiers, coordinates, and 
       click count. 

     Parameters: 
          source - the object where the event originated 
----------------------------------------------
In this case, the "source" parameter is a reference to the 
CustomComponent object. Values of -1 for x and y are 
provided to make the object easy to recognize when it 
emerges in the processEvent()method. Arbitrary values are 
provided for the when, modifiers, clidkCount, and 
popupTrigger parameters.

Arbitrary values were not assigned to the id parameter.  It
is absolutely critical that in constructing the mouse event
object, the value of the id field match one of the 
following symbolic constants defined in the MouseEvent 
class:

  MOUSE_CLICKED 
     The mouse clicked event type. 
  MOUSE_DRAGGED 
     The mouse dragged event type. 
  MOUSE_ENTERED 
     The mouse entered event type. 
  MOUSE_EXITED 
     The mouse exited event type. 
  MOUSE_FIRST 
     Marks the first integer id for the range of 
       mouse event ids. 
  MOUSE_LAST 
     Marks the last integer id for the range of 
       mouse event ids. 
  MOUSE_MOVED 
     The mouse moved event type. 
  MOUSE_PRESSED 
     The mouse pressed event type. 
  MOUSE_RELEASED 
     The mouse released event type. 

If the value of the id field doesn't match one of these 
values, the system will not deliver the object to its 
intended receiver.

Typical program output while the mouse is moved around and 
clicked on the component and while the x and y keys are 
pressed is shown below.  Note the x and y coordinates of -1
for the synthetic mouse events generated inside the 
KeyEvent Listener object.

Note also that line breaks were manually inserted in this
replica of the output to cause the material to fit easily
on the width of the page.

In processMouseEvent in CustomComponent. 
  ID = 504 java.awt.Point[x=156,y=70]
In processMouseEvent in CustomComponent. 
  ID = 505 java.awt.Point[x=0,y=32]
In processMouseEvent in CustomComponent. 
  ID = 504 java.awt.Point[x=4,y=9]
In processMouseEvent in CustomComponent. 
  ID = 501 java.awt.Point[x=25,y=13]
In processMouseEvent in CustomComponent. 
  ID = 502 java.awt.Point[x=25,y=13]
In processMouseEvent in CustomComponent. 
  ID = 500 java.awt.Point[x=25,y=13]
In keyPressed() method, the key pressed was x
In processMouseEvent in CustomComponent. 
  ID = 500 java.awt.Point[x=-1,y=-1]
In keyPressed() method, the key pressed was y
In processMouseEvent in CustomComponent. 
  ID = 500 java.awt.Point[x=-1,y=-1]
In processMouseEvent in CustomComponent. 
  ID = 505 java.awt.Point[x=105,y=96]

The program was originally tested using JDK 1.1.1 and Win95
and the reformatted version was tested using JDK 1.1.3.  
*/

import java.awt.*;
import java.awt.event.*;

//=========================================================
public class Event30 extends Frame{
  public static void main(String[] args){
    Event30 displayWindow = new Event30(); 
  }//end main
  //--------------------------------------------------------

  public Event30(){//constructor
    setTitle("Copyright, R.G.Baldwin");  
    CustomComponent myCustomComp = new CustomComponent();
    this.add(myCustomComp);
    setSize(250,100);//set frame size    
    setVisible(true);//display the frame
myCustomComp.requestFocus();
    //The following KeyListener object converts key events 
    // to mouse events.
    myCustomComp.addKeyListener(
                          new MyKeyListener(myCustomComp));
    
    //terminate when Frame is closed    
    this.addWindowListener(new Terminate());
  }//end constructor
}//end class Event30
//=========================================================

//This class listens for key events on a custom components.
// Whenever a key event is trapped, code in the overridden 
// keyPressed() method displays the character (some keys 
// don't generate characters that can be displayed). Then 
// it creates a synthetic MouseEvent object and posts it in
// the system EventQueue to be delivered to the same 
// custom component.  Thus, Listener objects of this type 
// convert key events to mouse events.
class MyKeyListener extends KeyAdapter{
  //reference to the custom component
  CustomComponent myCustomComp;
  //-------------------------------------------------------
  
  //constructor
  MyKeyListener(CustomComponent inCustomComponent){
    //save reference to custom component
    myCustomComp = inCustomComponent;
  }//end constructor
  //-------------------------------------------------------
  
  public void keyPressed(KeyEvent e){//overridden method
    System.out.println(
            "In keyPressed() method, the key pressed was " 
            + e.getKeyChar());

    //Note, the id parameter in the construction of the 
    // following MouseEvent object must be a valid 
    // MouseEvent id.  This event is constructed with
    // x and y coordinate values of -1 to make the event 
    // easily identifiable. Note the reference to the 
    // custom component as the first parameter to the 
    // constructor.  That is where the object will be 
    // delivered.  Note also that the following several
    // lines of code comprise a single statement.
    Toolkit.getDefaultToolkit().
        getSystemEventQueue().
        postEvent(new MouseEvent(myCustomComp,
                                 MouseEvent.MOUSE_CLICKED,
                                 0,0,-1,-1,2,false));
  }//end overridden keyPressed() method
}//end MyKeyListener
//=========================================================

//This class defines a custom component created by 
// extending Label.  It can respond to key events if an 
// appropriate KeyListener object is registered on its 
// behalf.  It overrides processMouseEvent() for the 
// purpose of capturing and displaying the MouseEvent 
// objects created and posted by the KeyListener object 
// with a reference to an object of this type as the 
// first parameter in the MouseEvent constructor.
class CustomComponent extends Label{
  CustomComponent(){//constructor
    this.setText("Custom Component");
    //The following statement is required to cause the 
    // processMouseEvent() method to be invoked whenever a 
    // mouse event is queued for an object of this class.
    enableEvents(AWTEvent.MOUSE_EVENT_MASK );        
  }//end constructor

//---------------------------------------------------------
  public void processMouseEvent(MouseEvent e) {
    //Announce that the method has been invoked and display
    // the ID and coordinate values of the MouseEvent 
    // object passed in as a parameter.
    System.out.println(
           "In processMouseEvent in CustomComponent. ID = " 
           + e.getID() + " " + e.getPoint());
    
    //ALWAYS DO THIS IF YOU OVERRIDE the 
    // processMouseEvent() method.       
    super.processMouseEvent(e); 
  }//end processMouseEvent    
}//end class CustomComponent
//=========================================================

class Terminate extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    //terminate the program when the window is closed  
    System.exit(0);
  }//end windowClosing
}//end class Terminate
//=========================================================

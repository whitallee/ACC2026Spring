/*File Event22.java Copyright, R.G.Baldwin
Revised 9/17/97
This program is designed to be compiled and run under 
JDK 1.1

The program illustrates the use of Inner Classes with event 
handling under the JDK 1.1 Delegation Event Handling model.

The use of anonymous Inner Classes is also illustrated.
See the program named Event23 for an example of Inner
Classes that does not use anonymous Inner Classes.

The controlling class is named Event22.  An Inner Class 
named GUI is defined inside the class named Event22 and an 
object of that class is instantiated inside the main() 
method.

In addition, two "data processing" methods named sing() and
whistle() are defined inside the controlling class named
Event22.  They are defined in such a way as to be separated
from the event handling activity except that they are 
invoked by the event handler methods.

Abbreviated notation is used to anonymously define the 
classes for and instantiate three anonymous listener 
objects inside the Inner Class named GUI. The first two 
implement the ActionListener interface while the third 
extends the WindowListener adapter.

The first two implement the actionPerformed() method of the
ActionListener interface while the third overrides the 
windowClosing() method of the WindowListener interface.

The class named GUI extends Frame.  Two Button objects 
labeled Sing and Whistle are instantiated in the GUI 
constructor. They are referenced by variables named 
singButton and whistleButton respectively.  Both buttons
are added to the Frame object.

The first two anonymous listener objects mentioned above 
are registered to listen for actionPerformed() events on 
the two buttons respectively.  The third anonymous listener
object is registered to listen for windowClosing() events 
on the Frame object.

When the program starts, a Frame object containing the two 
buttons appears on the screen.  When the user clicks on the
button labeled Sing, the event handler registered to listen
for Action events on that button invokes the method named 
sing() causing the message

"I am singing, Tra la la" 

to be displayed on the screen.

When the user clicks one the button labeled Whistle, the 
event handler registered to listen for Action events on 
that button invokes the method named whistle() causing the 
message 

"I am whistling, Tweet, Tweet, Tweet"

to be displayed on the screen.

When the user clicks the "close" box on the Frame, the 
event handler registered to listen for windowClosing() 
events on the Frame terminates the program.

This version of the program uses abbreviated notation to 
define anonymous classes and instantiate anonymous listener
objects.  The abbreviated notation is fairly cryptic.  See 
the program named Event23 for a version that does the same 
thing without using the abbreviated notation.

These results were produced using JDK 1.1 running under 
Windows 95.
*/
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class Event22 {
  void sing() {System.out.println(
                               "I am singing, Tra la la");}
  void whistle() {System.out.println(
                     "I am whistling, Tweet Tweet Tweet");}
  
  //-------------------------------------------------------
  static public void main(String[] args){
    Event22 app = new Event22();
    //Note the following syntax which instantiates an
    // object of the class GUI which is an inner-class of
    // the class Event22.  The new operator is invokec on
    // the object named app which is of class Event22.
    GUI gui = app.new GUI();
  }//end main()
    
  //-------------------------------------------------------
  //Note that the GUI class is defined inside the Event22 
  // class and thus becomes an inner-class of Event22.
  class GUI extends Frame{

    public GUI(){//constructor for GUI inner-class
      this.setTitle("Copyright, R.G.Baldwin");
      Button singButton;
      this.add(singButton = new Button("Sing"),"North");
      Button whistleButton;
      this.add(whistleButton = new Button("Whistle"),
                                                  "South");
      
      //---------------------------------------------------
      //The code which follows instantiates three 
      // anonymous objects of types ActionListener and 
      // WindowAdapter, and registers them for handling 
      // events on the two corresponding Button objects and
      // the Frame object.  This code uses the abbreviated 
      // syntax which defines the listener classes
      // anonymously (the listener classes do not have
      // class names and the objects instantiated from
      // those classes do not have names).
      
      //Begin statement -----------------------------------
      singButton.addActionListener(
        //The following object is passed as a parameter
        // to the addActionListener() method.
        new //instantiate anonymous object of the class
          ActionListener(){//anonymous class definition
            //Implement the actionPerformed() method 
            // which is declared in the ActionListener
            // interface.
            public void actionPerformed(ActionEvent e){
              //The methods in this inner-class have direct
              // access to the members of the enclosing
              // outer-class named Event22.  Thus, the 
              // direct invocation of the sing() method
              // is possible without the requirement to
              // instantiate an object of type Event22.
              sing();//call the sing() method
            }//end actionPerformed()
          }//end ActionListener class definition
        );//end addActionListener() statement
      //End statement -------------------------------------  

      //Begin statement -----------------------------------
      whistleButton.addActionListener(
      //See above discussion for explanation of this code
          new ActionListener(){//anonymous class definition
            public void actionPerformed(ActionEvent e){
              //See note above regarding the method sing()
              whistle();//call the whistle() method
            }//end actionPerformed()
          }//end ActionListener
        );//end addActionListener()
      //End statement -------------------------------------
          
      //Begin statement -----------------------------------
      this.addWindowListener(
      //See above discussion for explanation of this code
           new WindowAdapter(){//anonymous class definition
             public void windowClosing(WindowEvent e){
               System.exit(0);//terminate the program
             }//end windowClosing()
           }//end WindowAdapter
         );//end addWindowListener
      //End statement -------------------------------------
 
      //---------------------------------------------------
      //Set frame size and make it visible.                    
      this.setSize(300,100);
      this.setVisible(true);
    }//end GUI constructor
  }//end class GUI
}//end class Event22
//=========================================================


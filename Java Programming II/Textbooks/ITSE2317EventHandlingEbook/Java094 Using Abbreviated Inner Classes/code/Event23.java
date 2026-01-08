/*File Event23.java Copyright, R.G.Baldwin
Revised 9/17/97
This program is designed to be compiled and run under 
JDK 1.1

The program illustrates the use of Inner Classes with event 
handling under the JDK 1.1 Delegation Event Handling model.

The controlling class is named Event23.  An Inner Class 
named GUI is defined inside the class named Event23 and an
object of that class is instantiated inside the main() 
method.

In addition, two "data processing" methods named sing() and
whistle() are defined inside the controlling class.  They 
are defined in such a way as to be separated from the event
handling activity except that they are invoked by the event
handler methods.

Three more Inner Classes are defined inside the Inner Class
named GUI. They are named SingActionListener, 
WhistleActionListener, and Terminator.  All three of these 
are Listener classes.  The first two implement the 
ActionListener interface while the third extends the
WindowListener adapter.

The first two override the actionPerformed() method of the 
ActionListener interface while the third overrides the 
windowClosing() method of the WindowListener interface.

The class named GUI extends Frame.  Two Button objects 
labeled Sing and Whistle are instantiated in the GUI 
constructor. They are referenced by variables named 
singButton and whistleButton respectively.  Both buttons
are added to the Frame object.

Anonymous Listener objects of the classes 
SingActionListener and WhistleActionListener are 
instantiated and registered for event handling on the two 
Button objects having similar names.

An anonymous Listener object of the class Terminator is 
registered for event handling on the Frame object of class 
GUI.

When the program starts, a Frame object containing the two 
buttons appears on the screen.  When the user clicks on the
button labeled Sing, the event handler registered to 
listen for Action events on that button invokes the method 
named sing() causing the message

"I am singing, Tra la la" 

to be displayed on the screen.

When the user clicks ont the button labeled Whistle, the 
event handler registered to listen for Action events on 
that button invokes the method named whistle() causing the 
message 

"I am whistling, Tweet, Tweet, Tweet"

to be displayed on the screen.

When the user clicks the "close" box on the Frame, the 
event handler registered to listen for windowClosing() 
events on the Frame terminates the program.

This version uses long form notation as opposed to the use
of anonymous inner classes.  See the program named Event22 
for a version that uses the more cryptic abbreviated 
notation attributable to the use of anonymous inner 
classes.

These results were produced using JDK 1.1 running under 
Windows 95.
*/
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class Event23 {
  //The following two methods are invoked directly from
  // code in methods defined in classes which are inner-
  // classes of this class.
  void sing() {System.out.println(
                               "I am singing, Tra la la");}
  void whistle() {System.out.println(
                     "I am whistling, Tweet Tweet Tweet");}

  //-------------------------------------------------------
  static public void main(String[] args){
//    Event23 app = new Event23();
    //Note the syntax in the following statement where the
    // new operator is joined to the reference to the
    // object of a class in which the GUI inner class is
    // defined in order to instantiate an object of the
    // GUI class.
//    GUI gui = app.new GUI();
    //Alternative syntax
    GUI gui = new Event23().new GUI(); 
  }//end main()
      
  //-------------------------------------------------------
  //Note that the following GUI class is defined inside 
  // the Event23 class and thus is an inner-class of the
  // Event23 class.
  class GUI extends Frame{
    
    //-----------------------------------------------------
    //Note that the SingActionListener class is defined
    // inside the GUI class which is defined inside the
    // Event23 class.
    class SingActionListener implements ActionListener{
      //Implement the actionPerformed method which is
      // declared in the ActionListener interface.
      public void actionPerformed(ActionEvent e){
        //Note that because this class is defined inside
        // the GUI class which is defined inside the 
        // Event23 class, this method has direct
        // access to the members of the Event23 class.
        // Therefore, this method can directly access the
        // method named sing() without having to access
        // it via an object of type Event23.
        sing();
      }//end actionPerformed()
    }//end SingActionListener class defined inside GUI 
    
    //-----------------------------------------------------
    //Note that the WhistleActionListener class is defined
    // inside the GUI class which is defined inside the
    // Event23 class.
    class WhistleActionListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
        //As mentioned earlier, this inner-class of the
        // has direct access to the members of the 
        // Event23 class without the requirement to
        // access via an object of type Event23.
        whistle();
      }//end actionPerformed()
    }//end WhistleActionListener class defined inside GUI
    
    //-----------------------------------------------------
    //Note that the Terminator class is defined inside the 
    // GUI class which is defined inside the Event23 class.
    class Terminator extends WindowAdapter{
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }//end windowClosing()
    }//end class Terminator defined inside GUI class
    
    //-----------------------------------------------------  
    public GUI(){//constructor for GUI class
      setTitle("Copyright, R.G.Baldwin");

      Button singButton;
      add(singButton = new Button("Sing"),"North");
      singButton.addActionListener(
                                new SingActionListener() );

      Button whistleButton;
      add(whistleButton = new Button("Whistle"),"South");
      whistleButton.addActionListener(
                             new WhistleActionListener() );

      //Register a Listener object for event handling on 
      // the Frame object of class GUI.
      this.addWindowListener(new Terminator());
      
      //Set frame size and make visible      
      setSize(300,100);
      setVisible(true);
    }//end GUI constructor
    //-----------------------------------------------------
  }//end class GUI which is defined inside Event23 class
  //-------------------------------------------------------
}//end class Event23
//=========================================================
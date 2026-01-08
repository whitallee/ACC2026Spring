//34567890123456789012345678901234567890123456789
//Note: this is wide format for small fonts.
//=============================================//


/*File Event29.java Copyright, R.G.Baldwin

This program illustrates the ability to handle
events in
extended components without the requirement to
use Listener
objects.

The program extends TextField to create a new
type of text
field named NumericTextField.  Objects of the
new type will
only accept numeric input.  If the user attempts
to enter
any character other than 0 thru 9, an audible
alarm sounds
and the character is not accepted.

The controlling class for the program extends
Frame.  Thus,
all the GUI action takes place inside a Frame
object.

Three component objects are instantiated and
added to the
Frame object. One of the objects is an object of
the
NumericTextField class described above.

A second object is a standard Button object.  The
 third
object is a Label object.

Whenever the user clicks on the Button, the
String data
inside the NumericTextField object is copied into
the
Label object.

If the user clicks on the close button on the
Frame, the
program terminates.

The custom component named NumericTextField is
created by
extending the TextField class and providing the
capability
to use key events to filter the characters
entered into
the NumericTextField object.  Only numbers are
allowed
through the filter.

Although the operation of the new component
requires the
use of key events, it does not operate on the
basis of the
Source/Listener model of the Delegation Event
Model.

Rather, key events are enabled on all objects of
the class
using the enableEvents() method with a
KEY_EVENT_MASK.
Once this is done, the method named
processKeyEvent() is
invoked whenever a key event occurs on an object
of the
class.  The method named processKeyEvent()is
overridden to
provide all of the processing necessary to
filter out
non-numeric characters without the requirement
to
instantiate a separate Listener object.

The processing inside the processKeyEvent()
method is
straightforward. Whenever a KEY_TYPED event
occurs, the
character typed is intercepted and tested to
confirm that
it is one of the numeric characters.  If not, it
is
replaced by a character with a zero value.  This
is not a
legal character, so the runtime system beeps and
refuses
to accept it into the component.

Whenever you override one of the
processXxxxEvent()
methods, you should always invoke the same method
in the
superclass passing the event object as a
parameter.  This
makes certain that all necessary default
processing takes
place.

The remaining code consists of a couple of
standard
Listener classes. One is used with the Button
object to
copy the contents of the NumericTextField object
to the
Label object.  The other terminates the program
when the
user clicks on the close box on the Frame.

The program was tested using JDK 1.1.3 running
under Win95.
************************************************/
//=============================================//
import java.awt.*;
import java.awt.event.*;

//=============================================//

public class Event29 extends Frame{
  public static void main(String[] args){
    new Event29();//object of new type
  }//end main
//---------------------------------------------//
  public Event29(){//constructor
    this.setTitle("Copyright, R.G.Baldwin");
    this.setLayout(new FlowLayout());
    this.setSize(250,100);

    Button myButton;
    add(myButton = new Button("Copy to Label"));

    NumericTextField myNumericTextField;
    //add a custom component
    add(myNumericTextField =
                         new NumericTextField());

    Label myLabel;
    add(myLabel = new Label("Initial Text"));

    this.setVisible(true);
    myNumericTextField.requestFocus();

    myButton.addActionListener(
         new MyActionListener(
                    myLabel,myNumericTextField));
    this.addWindowListener(new Terminate());
  }//end constructor

}//end class Event29
//=============================================//

//Class to define a new type of TextField.  This
// is a
// custom TextField component, extended from
// TextField.
// It will only accept numeric values.  Note that
// it
// depends on key events for its operation but it
// does not
// use the source/listener mode of the Delegation
// Event
// Model.
class NumericTextField extends TextField{

  NumericTextField(){//constructor
    this.setColumns(10);//set the size
    //Enable key events so that the
    // processKeyEvent()
    // method will be invoked whenever a key
    // event occurs
    // on an object of this class.
    enableEvents(AWTEvent.KEY_EVENT_MASK);
  }//end constructor
//---------------------------------------------//


  //Because key events are enabled, this
  // overridden method
  // will automatically be invoked whenever a
  // key event
  // occurs on an object of the class.
  protected void processKeyEvent(KeyEvent e){
    //KEY_TYPED is key-down and key-up
    if(e.getID() == KeyEvent.KEY_TYPED)
      //If the char is not numeric, substitute an
      // illegal
      // character so that the runtime system
      // will reject
      // it and beep.
      if(!((e.getKeyChar() >= '0')
                     && (e.getKeyChar() <= '9')))
        e.setKeyChar('\000');
    //always do this when overriding
    // processXxEvent
    super.processKeyEvent(e);
  }//end processKeyEvent
}//end class NumericTextField
//=============================================//

//Class to create an ActionListener for the
// Button object.
// Transfers the data from the NumericTextField
// to the
// Label.
class MyActionListener implements ActionListener{
  Label myLabel;
  NumericTextField myNumericTextField;
//---------------------------------------------//

  MyActionListener( //constructor
      Label inLbl, NumericTextField inNumTxtFld){
    myLabel = inLbl;
    myNumericTextField = inNumTxtFld;
  }//end constructor
  //-------------------------------------------//

  public void actionPerformed(ActionEvent e){
    myLabel.setText(myNumericTextField
                                     .getText());
  }//end actionPerformed()
}//end MyActionListener
//=============================================//

class Terminate extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    //terminate the program when the window is
    // closed
    System.exit(0);
  }//end windowClosing
}//end class Terminate
//=============================================//


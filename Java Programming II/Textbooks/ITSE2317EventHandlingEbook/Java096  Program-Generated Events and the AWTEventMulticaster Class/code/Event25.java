/*File Event25.java Copyright, R.G.Baldwin
This program is designed to be compiled and run under JDK 1.1

This is a bare-bones program that illustrates Program Generated 
Events under JDK 1.1.

A non-visual object class (named NonVisual) is defined.  Objects of 
this class are capable of generating Action events.  

The essential ingrediants of such a class are:
1.  A reference variable to a list of registered ActionListener objects
2.  A method for creating the list mentioned above.  In this program
    it is named makeActionListenerList() but for consistency, it should
    be named addActionListener(). This list should be constructed using
    a call to the AWTEventMulticaster.add() method.
3.  A method which invokes the actionPerformed() method on the list.  In
    this program, that method is called generateActionEvent().
4.  The class should extend the Component class.		

One object of the NonVisual class is instantiated.

One ActionListener class is defined.  An object of this class is 
instantiated and registered to listen for Action events on the NonVisual
object mentioned above.

Then the generateActionEvent() method is invoked on the NonVisual objects 
causing an Action events to occur and to be trapped and processed by the 
ActionListener object.  

The output from the program for one particular run is:

Copyright, R.G.Baldwin
actionPerformed() method invoked on NonVisualObject

The program was tested using JDK 1.1 running under Win95.
*/
//=======================================================================
import java.awt.*;
import java.awt.event.*;
//=======================================================================

public class Event25 {
  public static void main(String[] args){
    new Event25();//instantiate an object of this type
  }//end main
//-------------------------------------------------------------------------
  public Event25(){//constructor
    System.out.println("Copyright, R.G.Baldwin");
    NonVisual nonVisualObject = new NonVisual("NonVisualObject");
    nonVisualObject.makeActionListenerList(new AnActionListenerClass());
    nonVisualObject.generateActionEvent();
  }//end constructor
}//end class Event25
//========================================================================

//Class to respond to action events
class AnActionListenerClass implements ActionListener{
  public void actionPerformed(ActionEvent e){
    System.out.println(
      "actionPerformed() method invoked on " + e.getActionCommand());
  }//end actionPerformed
}//end class AnActionListenerClass
//========================================================================

//Class to create object capable of generating Action events.
//========================================================================
class NonVisual extends Component {
  String ID; // The ID of the object
  ActionListener actionListener;//list of registered action listener objects
  //-----------------------------------------------------------------------
  public NonVisual(String ID) {//Constructs a NonVisual object
      this.ID = ID;
  }//end constructor
  //-----------------------------------------------------------------------
  public void makeActionListenerList(ActionListener listener) {
    actionListener = AWTEventMulticaster.add(actionListener, listener);
  }//end makeActionListenerList()
  //-----------------------------------------------------------------------
  public void generateActionEvent() {
    actionListener.actionPerformed(
        new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ID));
  }//end generateActionEvent
}//end class NonVisual
//===========================================================



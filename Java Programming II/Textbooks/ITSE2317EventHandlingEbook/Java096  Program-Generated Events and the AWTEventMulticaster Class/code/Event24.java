/*File Event24.java Copyright, R.G.Baldwin
This program is designed to be compiled and run under JDK 1.1

This program illustrates Program Generated Events under JDK 1.1.

A non-visual object class (named NonVisual) is defined.  Objects of 
this class are capable of generating Action events.  The mechanism for 
causing an object of this type to generate an Action event is to call 
the generateActionEvent() method on an object of the class.

Two objects of the NonVisual class are instantiated.

Two different ActionListener classes are defined.  An ActionListener
object of one of these classes is instantiated and registered to 
listen for Action events on both of the objects of the NonVisual class.

In addition, an object of the other ActionListener class is instantiated
and registered to listen for Action events on only one of the NonVisual
objects.

Thus, one NonVisual object is registered with only one ActionListener
object.  The other NonVisual object is registered with two different
ActionListener objects.

Then the generateActionEvent() method is called on each of the
NonVisual objects causing Action events to occur and to be trapped and 
processed by the respective ActionListener objects.  

Numerous statements are displayed to explain what is happening along
the way.  All of the output from the program goes to the standard 
output device.  

The output from the program for one particular run was:

Copyright, R.G.Baldwin
Instantiate two NonVisual objects with the ability to generate Action events.
Name of first NonVisual object: NonVisualObjA
Name of second NonVisual object: NonVisualObjB

Register ActionListener objects on the NonVisual objects

addActionListener() method called
NonVisualObj A:   Listener to add is: FirstActionListener@1cc728
call AWTEventMulticaster.add() to get reference to ActionListener
NonVisualObj A:   Ref to ActionListener is: FirstActionListener@1cc728


addActionListener() method called
NonVisualObj B:   Listener to add is: FirstActionListener@1cc761
call AWTEventMulticaster.add() to get reference to ActionListener
NonVisualObj B:   Ref to ActionListener is: FirstActionListener@1cc761


addActionListener() method called
NonVisualObj B:   Listener to add is: SecondActionListener@1cc783
call AWTEventMulticaster.add() to get reference to ActionListener
NonVisualObj B:   Ref to ActionListener is: java.awt.AWTEventMulticaster@1cc799

call generateActionEvent() method on the object named NonVisualObjA
which has only one registered ActionListener object.
In generateActionEvent() method, dispatching ACTION_PERFORMED event to 
FirstActionListener@1cc728 for NonVisualObj A
In actionPerformed() method of FirstActionListener object
actionPerformed() method called on NonVisualObj A

call generateActionEvent() method on the object named NonVisualObjB
which has two registered ActionListener objects.
In generateActionEvent() method, dispatching ACTION_PERFORMED event to 
java.awt.AWTEventMulticaster@1cc799 for NonVisualObj B
In actionPerformed() method of FirstActionListener object
actionPerformed() method called on NonVisualObj B
In actionPerformed() method of SecondActionListener object
actionPerformed() method called on NonVisualObj B


The program was tested using JDK 1.1 running under Win95.
*/
//=======================================================================
import java.awt.*;
import java.awt.event.*;
//=======================================================================

public class Event24 {
  public static void main(String[] args){
    new Event24();//instantiate an object of this type
  }//end main
//-------------------------------------------------------------------------
  public Event24(){//constructor
    System.out.println("Copyright, R.G.Baldwin");
    System.out.println("Instantiate two NonVisual objects with the "
      + "ability to generate Action events.");
    NonVisual aNonVisual = new NonVisual("NonVisualObj A");
    aNonVisual.setName("NonVisualObjA");
    NonVisual bNonVisual = new NonVisual("NonVisualObj B");
    bNonVisual.setName("NonVisualObjB");
    
    System.out.println("Name of first NonVisual object: " + aNonVisual.getName());
    System.out.println("Name of second NonVisual object: " + bNonVisual.getName());    

    //Register cross-linked ActionListener objects on the NonVisual objects.
    // One NonVisual object is registered on a single ActionListener object.
    // The other NonVisual object is registered on two different ActionListener
    // objects, one of which is of the same class as the object registered on
    // the first NonVisual object.
    System.out.println(
      "\nRegister ActionListener objects on the NonVisual objects");
    aNonVisual.addActionListener(new FirstActionListener());
    bNonVisual.addActionListener(new FirstActionListener());
    bNonVisual.addActionListener(new SecondActionListener());

    //Now cause each of the NonVisual objects to generate an Action event.
    System.out.println("call generateActionEvent() method on the object named " 
      + aNonVisual.getName());    
    System.out.println("which has only one registered ActionListener object.");
    aNonVisual.generateActionEvent();//do it
    System.out.println();//blank line
    System.out.println("call generateActionEvent() method on the object named " 
      + bNonVisual.getName());
    System.out.println("which has two registered ActionListener objects.");
    bNonVisual.generateActionEvent();//do it

  }//end constructor
}//end class Event24
//========================================================================
//The following two classes are standard ActionListener classes. Objects
// of these classes simply trap Action events and display some information
// about them.

//First class to respond to action events
class FirstActionListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
    System.out.println(
      "In actionPerformed() method of FirstActionListener object");
    System.out.println(
      "actionPerformed() method called on " + e.getActionCommand());
  }//end actionPerformed
}//end class FirstActionListener
//========================================================================
//Second class to respond to action events
class SecondActionListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
    System.out.println(
      "In actionPerformed() method of SecondActionListener object");
    System.out.println(
      "actionPerformed() method called on " + e.getActionCommand());  
  }//end actionPerformed
}//end class FirstActionListener


//////////////////////////////////////////////////////////////////////////
//  The following class produces a NonVisual object capable of generating
//  Action events.
//========================================================================
class NonVisual extends Component {
  //The state of a NonVisual object at any time is defined by the following
  // instance variables.
  String ID; // The ID of the object
  ActionListener actionListener;//Refers to a list of ActionListener
                                // objects to be notified when an Action
                                // event occurs.  (See addActionListener
                                // description below).

  //-----------------------------------------------------------------------
  public NonVisual(String ID) {//Constructs a NonVisual object
      this.ID = ID;
  }//end constructor

  //-----------------------------------------------------------------------
  //The behavior of a NonVisual object is defined by the following
  // instance methods.
  //-----------------------------------------------------------------------

  /*
  The following method adds ActionListener objects passed in as parameters 
   to the list of ActionListener objects designated to be notified of 
   action events from a NonVisual object.  
  
  Notification takes place in a different method by calling the 
   actionPerformed() method of each of the ActionListener objects on 
   the list.
  
  New objects are added to the list by calling the static add() method
   of Class java.awt.AWTEventMulticaster and passing to it the instance 
   variable which references the list along with the new listener object 
   to be added.  
  
  For the first listener object added to the list, a reference to the 
   Listener object itself is returned.  Hence, in that case the reference 
   to the list is simply a reference to the Listener object.
  
  When additional listener objects are added to the list, a reference 
   to an object of type java.awt.AWTEventMulticaster is returned by the 
   add() method of Class AWTEventMulticaster.
  
  According to the JDK 1.1 documentation on Class AWTEventMulticaster, 
   "This class will manage the structure of a chain of event 
   listeners and dispatch events to those listeners."
  
  When the actionPerformed() method is later called on the reference to
   the list, either the actionPerformed() method is called on a single
   object, or the AWTEventMulticaster object assumes responsibility for
   calling the actionPerformed() method on all of the Listener objects
   that it is maintaining in its list of Listener objects.
  */
  public void addActionListener(ActionListener listener) {
    System.out.println();//blank line
    System.out.println("addActionListener() method called");
    System.out.println(ID + ":   Listener to add is: " + listener);
    System.out.println("call AWTEventMulticaster.add() to get "
      + "reference to ActionListener");
    actionListener = AWTEventMulticaster.add(actionListener, listener);
    System.out.println(ID + ":   Ref to ActionListener is: " + 
      actionListener);
    System.out.println();//blank line
  }//end addActionListener()
  //-----------------------------------------------------------------------
  //The  purpose of this method is to call the actionPerformed() method 
  // on all the Listener objects that are contained in a list of Listener
  // objects that are registered to listen for Action events being
  // generated by this NonVisual object.  This is accomplished by calling
  // the actionPerformed() method on the reference to the list.  When this
  // is done, an ActionEvent object is instantiated and passed as a parameter.
  public void generateActionEvent() {
    if(actionListener != null) {//confirm that an ActionListener is registered
      System.out.println("In generateActionEvent() method, dispatching "
        + "ACTION_PERFORMED event to ");
      System.out.println(actionListener + " for " + ID);
      actionListener.actionPerformed(new ActionEvent(
        this, ActionEvent.ACTION_PERFORMED, ID));
    }//end if on actionListener
  }//end paint
}//end class NonVisual
//===========================================================



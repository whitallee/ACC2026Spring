/*File Event26.java Copyright, R.G.Baldwin
This program is designed to be compiled and run under JDK 1.1

This is a bare-bones program that illustrates the ability to create, trap,
and process events of new custom types.  

The program also illustrates program-generated events, but this capability 
was also illustrated in an earlier sample program.  It would be good to 
understand that material before tackling this lesson.

A non-visual object class (named NonVisual) is defined.  Objects of 
this class are capable of generating Custom events.  

The essential ingredients for creating, trapping, and processing events of
new custom types, as used in this example program are:
1.  Define a class from which objects of the new custom event type can 
be instantiated.  It should extend EventObject.
2.  Define an EventListener interface for the new custom event type to be 
implemented by Listener classes. It should extend EventListener.
3.  Define a Listener class that implements the interface for the new 
custom event type.
4.  Define a class for instantiating objects capable of generating the 
new custom event type. In this program, that class extends Component.
5.  Define a method, preferably named add<CustomEvent>Listener, that can 
maintain a list of Listener objects registered to listen for events of the 
new custom type on another object (In this bare-bones program, to avoid
complexity, the length of the list is limited to only one Listener object.)
6.  Define a method that dispatches an event object of the new custom 
event type to all Listener objects registered in the above list by 
invoking the central event-trapping method of those Listener objects.  
This event-trapping method is the method declared in the EventListener
interface for the new custom event type.  In this program, it is named
customEventTrapped().

In this program, two objects of the NonVisual class are instantiated.

One CustomEventListener class is defined.  An object of this class is 
instantiated and registered to listen for Custom events on both of the 
NonVisual objects mentioned above.

The generateCustomEvent() method is invoked on each the NonVisual objects 
causing Custom events to occur and to be trapped and processed by the 
CustomEventListener objects.  

The output from the program for one particular run was:

Copyright, R.G.Baldwin
customEventTrapped() method invoked on First NonVisualObject
Source of event was NonVisual[,0,0,0x0,invalid]
customEventTrapped() method invoked on Second NonVisualObject
Source of event was NonVisual[,0,0,0x0,invalid]

The program was tested using JDK 1.1 running under Win95.
*/
//=======================================================================
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.util.EventObject;
//=======================================================================

public class Event26 {
  public static void main(String[] args){
    new Event26();//instantiate an object of this type
  }//end main
//-------------------------------------------------------------------------
  public Event26(){//constructor
    System.out.println("Copyright, R.G.Baldwin");
    NonVisual firstNonVisualObject = new NonVisual("First NonVisualObject");
    firstNonVisualObject.addCustomEventListener(new CustomEventListenerClass());
    firstNonVisualObject.generateCustomEvent();//create an event

    NonVisual secondNonVisualObject = new NonVisual("Second NonVisualObject");
    secondNonVisualObject.addCustomEventListener(new CustomEventListenerClass());
    //The following statement causes the program to terminate with the message
    // "No support for multiple Listener objects" because it violates the 
    // restriction that this bare-bones program only allows one Listener object
    // to be registered on each NonVisual object.  Therefore, the statement
    // has been disabled by making it a comment. It is included here for 
    // illustration purposes only.
    //secondNonVisualObject.addCustomEventListener(new CustomEventListenerClass());
    secondNonVisualObject.generateCustomEvent();//create an event
    
  }//end constructor
}//end class Event26
//========================================================================

//Class to define a new type of event
class CustomEvent extends EventObject{
  String id;//instance variable for an object of this type
  //---------------------------------------------------------------------
  CustomEvent(Object obj, String id){//constructor
    super(obj);//pass the Object parameter to the superclass
    this.id = id;//save the String parameter
  }//end constructor
  //---------------------------------------------------------------------
  String getCustomID(){//method to return the saved String parameter
    return id;
  }//end getCustomID
}//end class CustomEvent
//========================================================================

//Define interface for the new type of event listener
interface CustomEventListener extends EventListener{
  void customEventTrapped(CustomEvent e);
}//
//========================================================================

//Listener class to respond to custom events
class CustomEventListenerClass implements CustomEventListener{
  public void customEventTrapped(CustomEvent e){
    System.out.println(
      "customEventTrapped() method invoked on " + e.getCustomID());
    System.out.println("Source of event was " + e.getSource());      
  }//end customEventTrapped
}//end class CustomEventListenerClass
//========================================================================

//Class to create object capable of generating Custom events.
// Note:  This is a bare-bones version which can only support a single
// Listener object for the Custom event type.
class NonVisual extends Component {
  String ID; // The ID of this object
  CustomEventListenerClass customListener;//Reference to single Listener object
  //-----------------------------------------------------------------------
  public NonVisual(String ID) {//Constructs a NonVisual object
      this.ID = ID;
  }//end constructor
  //-----------------------------------------------------------------------
  public void addCustomEventListener(CustomEventListenerClass listener) {
    //Do not attempt to add more than one Listener object.
    if(customListener == null) customListener = listener;//one listener only
    else{
      System.out.println("No support for multiple Listener objects");
      System.exit(0);//terminate on attempt to register multiple Listener objects
    }
  }//end addCustomEventListener()
  //-----------------------------------------------------------------------
  public void generateCustomEvent() {
    customListener.customEventTrapped(
        new CustomEvent(this, ID));
  }//end generateCustomEvent
}//end class NonVisual
//===========================================================



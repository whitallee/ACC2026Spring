/*File Event18.java Copyright, R.G.Baldwin
Revised 12/18/97
This program was designed to be compiled and executed under
JDK 1.1.3 or later version.

In an earlier version of this program compiled under 
JDK 1.1, in February 1997, I reported numerous bugs in the
JDK Scrollbar handling.  I have now recompiled the program 
and can report that most of the bugs seem to have been fixed,
although a couple of bugs still seem to exist.

One remaining bug is that if you adjust the scrollbar by
dragging the bubble into an area which would report negative
values, large positive values are reported instead of small
negative values (ie: something like 65536 instead of -1).
This does not happen if the scrollbar is adjusted by 
clicking on the end buttons or in the area between the
bubble and the buttons.  A numeric workaround was
implemented in this program to work around that bug. Note
that the bug still exists in JDK 1.1.6 but was fixed in the
first release of JDK 1.2.

Another possible bug is that the scrollbar seems to be able
to report a value that is one unitIncrement too large for 
the specified maximum value and bubble width.  Note
that the bug still exists in JDK 1.1.6 but was fixed in the
first release of JDK 1.2.

This program places a Scrollbar object and a TextField 
object in a Frame.  Whenever the bubble in the Scrollbar is
moved using any of the five available methods for moving 
the bubble the value of the Scrollbar (which should 
represent the position of the bubble) is displayed in the
TextField object.

Also, whenever the bubble is moved, several other pieces of
information are displayed on the screen which identify
various parameters of the adjustment.

Closing the frame terminates the program.
*/
//=========================================================
import java.awt.*;
import java.awt.event.*;

class Event18{
  public static void main(String[] args){
    GUI gui = new GUI(); 
  }//end main
}//end class Event18
//==========================================================
class GUI{
  Scrollbar myScrollbar;
  TextField displayWindow;
  int bubbleWidth;//needs to be accessible by event handler
  
  GUI(){
    Frame myFrame = new Frame("Copyright, R.G.Baldwin");
    
    //Instantiate a horizontal Scrollbar object with range 
    // from 0 to 100, initial position at 50, bubble width 
    // (page size) of 20, unitIncrement of 2 and a 
    // blockIncrement of 15.  
    
    // The Scrollbar component does not center the bubble on
    // the value.  Rather, the left edge of the bubble is 
    // lined up with the value.  The result is that values 
    // in the upper end of the range cannot be reached 
    // unless appropriate adjustments are made using half
    // the bubble width.  This distributes the unreachable
    // values at each end of the Scrollbar. You can then
    // set the min and max values to extend beyond the
    // desired values by one-half the bubble width.
    bubbleWidth = 20;
    int initialPosition = 50 - bubbleWidth/2;
    int min = 0 - bubbleWidth/2;
    int max = 100 + bubbleWidth/2;
    myScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 
                    initialPosition, bubbleWidth, min, max);
    
    //It would have been nice to have included unitIncrement
    // and blockIncrement as parameters to the constructor 
    // along with the other constructor parameteters. See 
    // next two statements which set the unitIncrement and
    // the blockIncrement.  The unitIncrement is the amount
    // of change resulting from clicking a button on the
    // end of the Scrollbar.  The blockIncrement is the 
    // amount of change resulting from clicking between the
    // bubble and the button on the end.
    myScrollbar.setBlockIncrement(15);
    myScrollbar.setUnitIncrement(2);
    
    displayWindow = new TextField("Initial Text");
    displayWindow.setEditable(false);//make non-editable

    //add components to the GUI
    myFrame.add("South", myScrollbar); 
    myFrame.add("North", displayWindow);
    myFrame.setSize(300,75);
    myFrame.setVisible(true);

    //Instantiate a listener object for the Scrollbar and 
    // register it to receive notification of adjustment 
    // events.    
    MyScrollbarListener myScrollbarListener = 
      new MyScrollbarListener(this);    
    //Note that the Scrollbar listener is not added as a 
    // ScrollbarListener but rather is added as an 
    // AdjustmentListener.
    myScrollbar.addAdjustmentListener(myScrollbarListener);

    //Close Frame to terminate.    
    myFrame.addWindowListener(new MyWindowListener());
  }//end constructor
}//end class GUI
//=========================================================

//Note that unlike some other components which have their 
// own listener interface, this class does not implement 
// ScrollbarListener because there is no such interface.
// Rather, the AdjustmentListener interface is used as a 
// listener interface for Scrollbars.
class MyScrollbarListener implements AdjustmentListener{
  GUI thisObject; //save ref to GUI object here
  
  MyScrollbarListener(GUI objectIn){//constructor
    thisObject = objectIn;
  }//end constructor
  
  public void adjustmentValueChanged(AdjustmentEvent e){
    int value;
    //Display the entire AdjustmentEvent object
    System.out.println(e); 
    System.out.println("Adjustable = " + e.getAdjustable());
    System.out.println("AdjustmentType = " 
                                   + e.getAdjustmentType());
     
    //Display the value of the Scrollbar object in the 
    // TextField.  The value should represent the position 
    // of the bubble.
    value = e.getValue();//get and save the value
    
    //The following code is here to work around a possible
    // bug in the Scrollbar object where small negative
    // values are reported as very large positive values
    // when the Scrollbar is adjusted by sliding the bubble.
    // Note that this bug still exists in JDK 1.1.6 but has
    // been fixed in JDK 1.2.
    System.out.println("value = " + value);
    if(value > 65000) value = value - 65536;
    System.out.println("value = " + value);
    thisObject.displayWindow.setText("Value = " 
                      + (value + thisObject.bubbleWidth/2));
            
    //The following seems like a kludge but is required to
    // make the scrollbar bubble stay put. Otherwise, it
    // jumps back to the previous value when you try to
    // move it.
    //Note that this statement is required for JDK 1.1.6
    // but is not required for the first release of JDK 1.2
    thisObject.myScrollbar.setValue(value);
  }//end adjustmentValueChanged()
  
}//end class MyScrollbarListener
//=========================================================
//Listener to terminate the program when the Frame is 
// closed.
class MyWindowListener extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class MyWindowListener
//=========================================================
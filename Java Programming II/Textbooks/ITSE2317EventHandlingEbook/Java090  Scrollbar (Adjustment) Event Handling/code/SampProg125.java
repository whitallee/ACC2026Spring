/*File SampProg125.java  from lesson 90
Copyright, R. G. Baldwin
Without viewing the following solution, write a Java
application that meets the specifications given below.

To accommodate this program, you will need to be using
JDK 1.1.3 or a later version.

Write an application that places a vertical Scrollbar and a
Label on a Frame.  The Label is used to display the 
position of the center of the bubble in the Scrollbar.

The Scrollbar values should range from approximately -50
to +50 (exact end points are difficult to achieve).

The width of the bubble should be 10 units.

When you click on the buttons at the end of the Scrollbar,
the bubble should move by 3 units.

When you click in the area between the bubble and the
buttons, the bubble should move by 6 units.

When the program starts, the bubble should be centered
and the Label should indicate a bubble position of 0.

Closing the frame terminates the program.

End of specifications.
*/
//=========================================================
import java.awt.*;
import java.awt.event.*;

class SampProg125{
  public static void main(String[] args){
    GUI gui = new GUI(); 
  }//end main
}//end class SampProg125
//==========================================================
class GUI{
  Scrollbar myScrollbar;
  Label displayWindow;
  int bubbleWidth;//needs to be accessible by event handler
  
  GUI(){
    Frame myFrame = new Frame("Copyright, R.G.Baldwin");
    
    bubbleWidth = 10;
    int initialPosition = 0 - bubbleWidth/2;
    int min = -50 - bubbleWidth/2;
    int max = 50 + bubbleWidth/2;
    myScrollbar = new Scrollbar(Scrollbar.VERTICAL, 
                    initialPosition, bubbleWidth, min, max);
       
    myScrollbar.setBlockIncrement(6);
    myScrollbar.setUnitIncrement(3);    
    
    displayWindow = new Label("value = 0");

    //add components to the GUI
    myFrame.add("East", myScrollbar); 
    myFrame.add("North", displayWindow);
    myFrame.setSize(300,300);
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
     
    //Display the value of the Scrollbar object in the 
    // Label.  The value should represent the position 
    // of the bubble.
    value = e.getValue();//get and save the value
    
    //The following code is here to work around a possible
    // bug in the Scrollbar object where small negative
    // values are reported as very large positive values
    // when the Scrollbar is adjusted by sliding the bubble.
    if(value > 65000) value = value - 65536;
    thisObject.displayWindow.setText("Value = " 
                      + (value + thisObject.bubbleWidth/2));
            
    //The following seems like a kludge but is required to
    // make the scrollbar bubble stay put. Otherwise, it
    // jumps back to the previous value when you try to
    // move it.
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

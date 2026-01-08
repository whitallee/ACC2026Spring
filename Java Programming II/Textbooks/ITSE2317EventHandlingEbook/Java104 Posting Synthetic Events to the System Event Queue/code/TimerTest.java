/*File TimerTest.java
Copyright, R.G.Baldwin

This application illustrates the use of the system event 
queue for the posting of synthetic events.

A Frame object appears on the screen containing a TextField
object and a Quit Button object.

If the user clicks the Quit button, the program terminates
by invoking the ActionPerformed() method on the Button.

If the user enters text into the TextField object, a ten-
second timer is reset on each keystroke and the ten-second
interval starts over.

If the user fails to enter text into the TextField object
for ten seconds, the ten-second elapsed time programmed
into the timer expires, causing the timer object to 
create a synthetic ActionPerformed event, attribute it to
the Quit button, and place it in the system event queue.

Because the timer creates a synthetic ActionPerformed()
event and attributes it to the Quit button, the end result 
of a timeout is exactly the same as if the user were to 
click the Quit button.  Either action causes the same 
ActionPerformed() method to be invoked.  This makes it 
possible to place code in the ActionPerformed method to do 
any cleanup or other useful work that might be appropriate
before the program actually terminates.

This is a case of program code simulating the action of a
human user by creating a synthetic click event on a button.

The general putpose timer class used in this program is 
designed to accept a timeout interval and a component as 
parameters.  When the timeout interval expires, a 
synthetic ActionPerformed() event is generated. That event
is attributed to the component that is passed in as a 
parameter.

This is accomplished using a separate thread object of type 
Timer.  When the Timer object is instantiated, a reference
to the Quit button and the ten-second timeout interval 
in milliseconds are passed in as parameters.

When the Timer object is instantiated, it goes to 
sleep for the prescribed time interval.  It will wake up 
under either of two conditions:

One condition is that it is interrupted by code in another 
thread.  In this case, it throws an InterruptedException 
object which is caught and processed to implement the reset
logic of the Timer class.

The other case is that the elapsed time expires. In this 
case, it doesn't throw an InterruptedException object and
the Timer object is not reset.

If it's sleep is interrupted, it resets and goes back to 
sleep for the prescribed period.  

If it wakes up without being interrupted, it generates a 
synthetic actionPerformed() event on the component that 
is passed in as a parameter and places the synthetic event
in the system event queue.  The synthetic event contains 
a command that can be extracted in the ActionPerformed()
method to determine that the event was actually generated
by the timer if such determination is needed.  In this
simple example, the command is simply displayed on the
screen to indicate whether the actionPerformed() method was
invoked by a click on the button, or was invoked by the
Timer object.  

Placing the synthtic event in the system event queue 
causes the actionPerformed() method to be invoked on the 
specified component just as though the user had clicked
the Quit button.

A KeyListener object is registered for the text field and
an ActionListener object is registered for the button.

The only function of the KeyListener object in this simple
example is to interrupt the Timer object and cause it
to wake up, reset the time interval, and go back to sleep.  

The ActionListener object is used to simulate cleanup and
shutdown whenever the user clicks the Quit button or allows
the system to time out.

A WindowListener object is also instantiated to support the
close button on the Frame object just in case it is needed.
*/
//=========================================================

import  java.applet.Applet;
import  java.awt.*;
import  java.awt.event.*;

//=========================================================
class TimerTest{//controlling class
  static public void main(String[] args){
    new PresentationGUI();
	}//end main
}//end class TimerTest

//=========================================================
//Note that this class implements the listener interfaces
// which means that an object of this class is a listener 
// object.  An object of this class is added to the
// lists of listener objects later using the keyword this.
class PresentationGUI 
                    implements ActionListener, KeyListener{
  Frame myFrame;  //references to various objects
  Button quitButton;
  TextField inputField; 
  Thread myTimer; 
	//-------------------------------------------------------
 
	PresentationGUI(){//constructor 
	  myFrame = new Frame("Copyright, R.G.Baldwin");
	  myFrame.setLayout(new FlowLayout());
	  myFrame.setSize(400,100);

	  //Add the TextField to the Frame 
	  myFrame.add(inputField = new TextField(10));

    //Add a KeyListener object to the TextField object    
    //See the above note regarding use of the keyword this
    // as a parameter to the add...Listener method.  The
    // code in the KeyListener object causes the timer to
    // be reset on each keystroke on the TextField object.  
	  inputField.addKeyListener(this);

    //Add the Button to the Frame		  
	  quitButton = new Button("Quit");
    //The foldlowing ActionCommand is displayed by the
    // ActionPerformed method if the user clicks the
    // quitButton.
	  quitButton.setActionCommand("Quit Button was Clicked");

	  myFrame.add(quitButton);
    
    //Add an ActionListener object to the Button.
    //Note that because this class implements the action
    // listener interface and the ActionPerformed()
    // method is defined in this class, an object of this
    // class is an ActionListener object.  Thus the keyword
    // this is registered to listen for Action events on 
    // the quitButton by the following statement.
	  quitButton.addActionListener(this);
    
		//make visible and redraw everything to proper size
    myFrame.setVisible(true);    
    myFrame.validate();
		
		//Instantiate the timer object for a prescribed ten-
    // second delay period.  Pass a reference to the Quit 
    // button so that the timer object can create a 
    // synthetic actionPerformed event on that button 
    // whenever it times out.
    //The timer object is instantiated to run in a 
    // separate unsynchronized thread.
    myTimer = new Thread(new Timer(quitButton,10000));
    //start the Timer thread
    myTimer.start();	
		
    //The following listener object services the close
    // button on the Frame object if needed, but it is
    // really not needed because the quitButton can be
    // used to terminate the program.		
    WProc1 winProcCmd1 = new WProc1();
    myFrame.addWindowListener(winProcCmd1);
  };  // end constructor
	//-------------------------------------------------------
	
  //The next two empty methods are provided simply to
  // satisfy the requirement to implement all methods
  // declared in the KeyListener interface.
  public void keyPressed(KeyEvent e){}
  public void keyReleased(KeyEvent e){}
  
  //The following method responds to keyTyped events and
  // resets the timer on each keystroke.
  public void keyTyped(KeyEvent e){
    myTimer.interrupt();//reset the timer
  }//end method keyTyped
  //-------------------------------------------------------

  //The following actionPerformed() method is invoked
  // whenever an actionPerformed event is placed in the 
  // system event queue.  In this program, that can happen 
  // either by the user clicking on the quitButton or by 
  // the timer object experiencing a timeout. 
  public void actionPerformed(ActionEvent  e){
    //Display the ActionCommand that identifies the actual
    // source of the event:  quitButton or timer.
    System.out.println(e.getActionCommand());
    
    //Do something useful here prior to termination
    System.out.println(
                   "This method will be invoked if the\n" +
		                "user clicks on the Quit button, or\n" +
		                "if the system is allowed to time \n" +
		                "out.  In either case, the necessary\n"+
		                "cleanup can be performed before\n" +
		                "actually terminating the program.");

    System.exit(0);//terminate the program
  };  // end actionPerformed()
}; // end class PresentationGUI
//=========================================================

//The following listener class is used to terminate the 
// program when the user closes the frame object.
class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=========================================================

/*This is a custom Timer class that generates a synthetic 
actionPerformed() event on the source object passed in 
as a parameter after sleeping for a specified period of 
time.  The specified period of time to sleep is also passed
in as a parameter.

In the event that sleep is interrupted by another thread 
invoking the interrupt() method on this thread, the timer 
is reset and then goes back to sleep.

If sleep is not interrupted, a synthetic actionPerformed()
event is placed in the system event queue and attributed
to the source object passed in as a parameter.

Note that this class implements the Runnable interface, and
defines a run() method.  Therefore, it can be run in its
own thread.
*/

class Timer implements Runnable{
  Object source;//reference to the source component
  int delay;//time interval to sleep
	//-------------------------------------------------------
	
  Timer(Object inSource, int inDelay){//constructor
    source = inSource;//save references
    delay = inDelay;
  }//end constructor
	//-------------------------------------------------------
	
	//The significant functionality of all thread objects is
	// written into the run() method for the object.
  public void run(){
    boolean keepLooping = true;
		
		//Keep looping and resetting as long as the
		// keepLooping variable is true.  Keystrokes in the 
		// TextField object have the effect of setting the
		// variable named keepLooping to true.
    while(keepLooping){//while keepLooping is true
      keepLooping = false;
      //In order to avoid exiting the loop, it is necessary
      // that sleep be interrupted which will cause the
      // keepLooping variable to be restored to true.
			
      try{
	      Thread.currentThread().sleep(delay);
      }catch(InterruptedException e){
        //Control is transferred here when interrupt() 
        // is invoked on this thread
				
        //Display the InterruptedException object
        System.out.println("" + e.toString());
				
        //Reset the timer when thread is interrupted by
        // restoring keepLooping to true and looping back
        // to the top of the loop
        keepLooping = true;
      }//end catch
			
      //Exit the loop if keepLooping is still false.  
      // Go back to the top of the loop if keepLooping has
      // been restored to true in the catch block.
    }//end while(keepLooping)
		
    //Control is transferred here when the loop is
		// allowed to terminate indicating that sleep was not 
		// interrupted by a keystroke during the prescribed 
		// timeout period.
		//Create a synthetic actionPerformed() event on the 
		// source object.  Note the continuation of the 
		// following very long statement on the next several
		// lines.
		Toolkit.getDefaultToolkit().
		    getSystemEventQueue().
		    postEvent(	
		      new ActionEvent(source, 
		                      ActionEvent.ACTION_PERFORMED,
		                      "Timeout Period Elapsed"));
  }//end run method
}//end Timer class	
//=========================================================
			
			
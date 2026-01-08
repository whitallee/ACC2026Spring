/*File Event32.java
Copyright, R.G.Baldwin

This program illustrates container events.  

It also illustrates the use of inner classes.  

It also illustrates the use of the controlling class as a 
listener class that implements multiple listener 
interfaces.  In this situation, the listener methods are
defined as methods of the controlling class rather than
being defined as methods of separately compiled listener
classes.

It also illustrates the fact that the code in one event 
handler can register event listeners for other components.

In particular, a ContainerListener object monitors for the 
addition of buttons to a Frame object.  Each time a new
button is added to the Frame, an ActionEvent listener is
registered on that new Button object.  All of the 
ActionEvent listener objects that are registered on the
buttons are of the same ActionEvent class.

To make the whole thing interesting, this program creates 
the keyboard and provides the skeleton code for a 
four-function calculator, including the event handler 
needed to respond to keystrokes and identify the key.  
However, it does not provide the code that would be 
required to process the keystrokes or display the results 
of the calculations since that is not the primary purpose 
of the program. It does provide a place to display results
in the form of a yellow Label object.

When you run the program and click on the buttons in the
Frame object, the labels on the buttons are displayed in
the yellow display area.
        
This program was tested using JDK 1.1.3 under Win95.

**********************************************************/
import java.awt.*;
import java.awt.event.*;

//Note that the controlling class implements both the
// ContainerListener interface and the ActionListener
// interface.
class Event32 extends Frame
  implements ContainerListener,ActionListener{
    
    Label displayLabel;//reference to a Label for display
    
  //=====================================================//
  
  public static void main(String[] args){
    new Event32();//instantiate this object
   }//end main
  //=====================================================//
  
  //This method adds a series of Button objects to this
  // Frame object.  The number of buttons added and the 
  // labels on the buttons are determines from the length 
  // and the substring values of an incoming String object.
  void addButtons(String labels){
    for(int cnt = 0; cnt < labels.length();cnt++){
      this.add(new Button(labels.substring(cnt,cnt+1)));
    }//end for loop
  }//end addButtons()  
  
  //=====================================================//
  
  public Event32(){//constructor

    //Set the layout manager to GridLayout with 4 col and
    // an unspecified number of rows (0) with a three-pixel
    // horizontal and vertical gap.
    this.setLayout(new GridLayout(0,4,3,3));

    this.setSize(280,280);
    this.setTitle("Copyright R.G.Baldwin");

    //Add a container listener which will receive an event
    // notification each time a component is added to the 
    // container. The container is this Frame object.  Also
    // the listener class that implements the 
    // ContainerListener interface is this extended Frame 
    // class (hence this as an argument).
    this.addContainerListener(this);

    //Add a series of buttons to this Frame object with
    // the labels determined by the individual characters
    // in the String object passed as a parameter.
    this.addButtons("789+456-123=0.X/C");
    
    //Add a display label and make it yellow.
    displayLabel = new Label("00000");
    this.add(displayLabel);
    displayLabel.setBackground(Color.yellow);
    

    this.setVisible(true);
    
    //---------------------------------------------------//
    //Anonymous inner-class listener to terminate program
    this.addWindowListener(
      new WindowAdapter(){//anonymous class definition
        public void windowClosing(WindowEvent e){
          System.exit(0);//terminate the program
        }//end windowClosing()
      }//end WindowAdapter
    );//end addWindowListener
  }//end constructor     
                                
  //=====================================================//
  //This is the overridden componentAdded method of the
  // ContainerListener class.  It is invoked each time a
  // new component is added to this Frame object.  Note
  // that each time a component is added, it confirms that
  // the component is a button, and if so, it registers an
  // ActionListener object to process Action events on that
  // individual button.  All of the ActionListener objects
  // are of the same class.  The ActionListener class is
  // this extended Frame class which implements the
  // ActionListener interface and overrides the 
  // actionPerformed method of that interface.  
  public void componentAdded(ContainerEvent e){
    if(e.getID() == ContainerEvent.COMPONENT_ADDED){
      if(e.getChild() instanceof Button){
        Button button = (Button)e.getChild();
        //Register an ActionListener object on the button
        button.addActionListener(this);
      }//end if statement
    }//end if statement  
  }//end componentAdded()

  //This empty method is required to satisfy the compiler
  // because this extended Frame class implements the
  // ContainerListener interface.
  public void componentRemoved(ContainerEvent e){}

  //=====================================================//
  //This is the actionPerformed method that is invoked
  // whenever the user clicks one of the buttons that are
  // added to the Frame object.  All it does is display
  // the button's label on the.
  // However, if you wanted to expend the programming
  // effort, you could implement the calculator at this
  // point. 
  public void actionPerformed(ActionEvent e){
    displayLabel.setText(e.getActionCommand());
  }//end actionPerformed
  //=====================================================//
}//end class Event32   
//=======================================================//

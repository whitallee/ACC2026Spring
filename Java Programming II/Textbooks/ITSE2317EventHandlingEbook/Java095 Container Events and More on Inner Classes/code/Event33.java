/*File Event33.java
Copyright, R.G.Baldwin

This program replicates the functionality of the program
named Event32.java.  However, it does so using only
anonymous inner classes.  This program is provided so
that you can compare the syntax using only anonymous
inner classes with a comparable version named Event32 that
uses named inner classes for the listener classes.
        
This program was tested using JDK 1.1.3 under Win95.

**********************************************************/
import java.awt.*;
import java.awt.event.*;

//Note that this controlling class does not implement any
// listener interfaces.  They are effectively implemented
// in the inner classes.
class Event33 extends Frame{
  
  Label displayLabel;//reference to a Label for display
  
  //=====================================================//
  public static void main(String[] args){
    new Event33();//instantiate this object
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
  
  public Event33(){//constructor
  
    this.setLayout(new GridLayout(0,4,3,3));
    this.setSize(280,280);
    this.setTitle("Copyright R.G.Baldwin");

 
    //The following anonymous class definition registers an 
    // anonymous ContainerListener object on this Frame
    // object.  The ContainerListener object in turn 
    // registers an anonymous Action Listener object on
    // each of the buttons that are added to the Frame
    // object.
    this.addContainerListener(//add anonymous Listener
      new ContainerListener(){
        public void componentAdded(ContainerEvent e){
          if(e.getID() == ContainerEvent.COMPONENT_ADDED){
            if(e.getChild() instanceof Button){
              Button button = (Button)e.getChild();
              //The following code registers an anonymous
              // ActionListener object on each button 
              // object that is added to the Frame object.
              button.addActionListener(
                new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                    displayLabel.setText(e.getActionCommand());
                  }//end actionPerformed
                }//end new actionListener
              );//end add anonymous ActionListener
            }//end if statement
          }//end if statement  
        }//end componentAdded()
				
        //The following empty method is required to satisfy
        // the requirement to define all of the methods
        // that are declared in the ContainerListener
        // interface.        
        public void componentRemoved(ContainerEvent e){}
      }//end new ContainerListener    
    );//end add anonymous ContainerListener

    //---------------------------------------------------//
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
}//end class Event33   
//=======================================================//
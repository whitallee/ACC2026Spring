/*File Event35.java, Copyright, R.G.Baldwin
Illustrates Item events.

This program creates three radio buttons in a group.  When
any of the three buttons is selected, the other two are
automatically deselected.

An ItemListener object is registered on all three buttons.
When a button is selected, an ItemEvent occurs.

The program also creates an ordinary checkbox. The
ItemListener object is also registered on the checkbox.  
When the checkbox is either selected or deselected an 
ItemEvent occurs.

When an ItemEvent occurs, the itemStateChanged() method
of the ItemListener object is invoked.  Code in this method
invokes methods of the ItemEvent object received as a 
parameter to display 

1. the label of the item, 
2. the "StateChange" of the item, and 
3. the new state of the item.

The labels on the three buttons are AButton, BButton, and
CButton.  The label on the checkbox is Check Box.

The following is the output produced by selecting BButton,
selecting Check Box, and then deselecting Check Box, in 
that order.

Item: BButton
State Change: 1
State: true

Item: Check Box
State Change: 1
State: true

Item: Check Box
State Change: 2
State: false

Several things are worthy of note here.  First, a state
change from deselected to selected produces a state 
change value of 1, while a change from selected to
deselected produces a value of 2.  So far, I have found no
documentation to explain the significance of these values.

Second, the checkbox generates an item event when it is
selected, and also when it is deselected.

Third, whenever one of the radio buttons is selected, the
others are automatically deselected.  However, only one
item event results, and it is attributed to the button
that is selected.  Automatic deselection of the other
buttons does not cause them to generate item events.

Tested using JDK1.1.6 under Win95.
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
//=======================================================//
public class Event35 extends Frame implements ItemListener{
  public static void main(String[] args){
    new Event35();
  }//end main
  //-----------------------------------------------------//

  Event35(){//constructor
    //Create a CheckboxGroup object
    CheckboxGroup cbGrp = new CheckboxGroup();

    //Create three radio buttons in the group
    Checkbox aButton = new Checkbox("AButton",true, cbGrp);
    Checkbox bButton = new Checkbox("BButton",false,cbGrp);
    Checkbox cButton = new Checkbox("CButton",false,cbGrp);
    
    //Register item listener object on each radio button
    aButton.addItemListener(this);
    bButton.addItemListener(this);
    cButton.addItemListener(this);
    
    //Create an ordinary checkbox and register the item
    // listener on it.
    Checkbox theCheckbox = new Checkbox("Check Box");
    theCheckbox.addItemListener(this);
    
    //Add the radio buttons and the checkbox to the Frame
    this.add(aButton);
    this.add(bButton);
    this.add(cButton);
    this.add(theCheckbox);

    //Adjust Frame parameters and make it visible
    this.setLayout(new FlowLayout());
    this.setSize(350,100);
    this.setTitle("Copyright, R.G.Baldwin");
    this.setVisible(true);
    
    // Anonymous inner class to terminate program.
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);}});//end WindowListener
  }//end constructor
  //-----------------------------------------------------//
 
  //Define the method of the ItemListener interface
  public void itemStateChanged(ItemEvent e){
    System.out.println("Item: " + e.getItem());
    System.out.println("State Change: " 
                                     + e.getStateChange());

    //Note the cast in the following statement    
    System.out.println("State: " 
                   + ((Checkbox)e.getSource()).getState());
    System.out.println();//blank line
  }//end itemStateChanged()

}//end class Event35 definition
//=======================================================//
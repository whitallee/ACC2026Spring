/*File SampProg128.java from chapter 94
Revised 02/21/98 to correct an earlier problem which
caused the program to violate the specifications.

Copyright, R.G.Baldwin
This program is designed to be compiled and run under
JDK 1.1

These results were produced using JDK 1.1.3 running under
Windows 95.
**********************************************************/

import java.awt.*;
import java.awt.event.*;

public class SampProg128 extends Frame {
 Label myLabel;
 //-----------------------------------------------------//
 static public void main(String[] args){
 SampProg128 app = new SampProg128();
 }//end main()
 //-----------------------------------------------------//

 public SampProg128(){//constructor
 this.setTitle("Copyright, R.G.Baldwin");
 Button myButton;
 this.add(myButton = new Button("Button"),"North");
 this.add(myLabel = new Label(
 "Initial Text in Label"),"South");
 //---------------------------------------------------//

 //The code which follows instantiates two
 // anonymous objects of types ActionListener and
 // WindowAdapter, and registers them for handling
 // events on the corresponding Button object and
 // the Frame object. This code uses the abbreviated
 // syntax which defines the listener classes
 // anonymously (the listener classes do not have
 // class names and the objects instantiated from
 // those classes do not have names).

 //Begin statement -----------------------------------
 myButton.addActionListener(
 //The following object is passed as a parameter
 // to the addActionListener() method.
 new //instantiate anonymous object of the class
 ActionListener(){//anonymous class definition
 //Implement the actionPerformed() method
 // which is declared in the ActionListener
 // interface.
 public void actionPerformed(ActionEvent e){
 //The methods in this inner-class have direct
 // access to the members of the enclosing
 // outer-classes named SampProg128.
 // Thus, direct access to the reference
 // variable named myLabel
 // is possible
 myLabel.setText("Ouch");
 }//end actionPerformed()
 }//end ActionListener class definition
 );//end addActionListener() statement
 //End statement -------------------------------------

 //Begin statement -----------------------------------
 this.addWindowListener(
 //See above discussion for explanation of this code
 new WindowAdapter(){//anonymous class definition
 public void windowClosing(WindowEvent e){
 System.exit(0);//terminate the program
 }//end windowClosing()
 }//end WindowAdapter
 );//end addWindowListener
 //End statement -------------------------------------

 //---------------------------------------------------
 //Set frame size and make it visible.
 this.setSize(300,100);
 this.setVisible(true);
 }//end SampProg128 constructor
}//end class SampProg128
//=========================================================
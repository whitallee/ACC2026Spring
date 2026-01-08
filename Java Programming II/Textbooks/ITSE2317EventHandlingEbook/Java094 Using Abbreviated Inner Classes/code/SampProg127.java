
/*File SampProg127.java Copyright, R.G.Baldwin
Revised 9/17/97

These results were produced using JDK 1.1.3 running under
Windows 95.
*/
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class SampProg127 {

 //-------------------------------------------------------
 static public void main(String[] args){
 SampProg127 app = new SampProg127();
 //Note the syntax in the following statement where the
 // new operator is joined to the reference to the
 // object of a class in which the GUI inner class is
 // defined in order to instantiate an object of the
 // GUI class.
 GUI gui = app.new GUI();
 }//end main()

 //-------------------------------------------------------
 //Note that the following GUI class is defined inside
 // the SampProg127 class and thus is an inner-class of
 // the SampProg127 class.
 class GUI extends Frame{
 //The object referenced by the following reference
 // variable is accessed directly by code in an
 // inner-class of the GUI class.
 Label myLabel;

 //-----------------------------------------------------
 public GUI(){//constructor for GUI class
 setTitle("Copyright, R.G.Baldwin");

 Button myButton;
 this.add(myButton = new Button("Button"),"North");
 myButton.addActionListener(
 new ButtonActionListener() );

 this.add(myLabel = new Label(
 "Initial Text in Label"),"South");

 //Register a Listener object for event handling on
 // the Frame object of class GUI.
 this.addWindowListener(new Terminator());

 //Set frame size and make visible
 setSize(300,100);
 setVisible(true);
 }//end GUI constructor

 //-----------------------------------------------------
 //Note that the ButtonActionListener class is defined
 // inside the GUI class which is defined inside the
 // SampProg127 class.
 class ButtonActionListener implements ActionListener{
 //Implement the actionPerformed method which is
 // declared in the ActionListener interface.
 public void actionPerformed(ActionEvent e){
 //Note that because this class is defined inside
 // the GUI class which is defined inside the
 // SampProg127 class, this method has direct
 // access to the members of both the SampProg127
 // class and the GUI class. Therefore, this method
 // can directly access the reference variable named
 // myLabel without having to access it via an
 // object of type GUI.
 myLabel.setText("Ouch");

 }//end actionPerformed()
 }//end ButtonActionListener class defined inside GUI

 //-----------------------------------------------------
 //Note that the Terminator class is defined inside the
 // GUI class which is defined inside the SampProg127
 // class.
 class Terminator extends WindowAdapter{
 public void windowClosing(WindowEvent e){
 System.exit(0);
 }//end windowClosing()
 }//end class Terminator defined inside GUI class
 //-----------------------------------------------------
 }//end class GUI defined inside SampProg127 class
 //-------------------------------------------------------
}//end class SampProg127
//=========================================================

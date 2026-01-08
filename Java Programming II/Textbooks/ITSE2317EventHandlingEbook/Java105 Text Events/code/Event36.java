/*File Event36.java, Copyright, R.G.Baldwin
Illustrates Text events.

This program puts a TextField object in a Frame object and
registers a TextListener object on the TextField.  Whenever
the text contents of the TextField change, a TextEvent is
generated causing the textValueChanged() method of the
listener object to be invoked.

Code in the method extracts the source of the event from 
the incoming TextEvent object, and uses that information
to get and display the current text contents of the
TextField object.

Tested using JDK1.1.6 under Win95.
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
//=======================================================//
public class Event36 extends Frame implements TextListener{
  public static void main(String[] args){
    new Event36();
  }//end main
  //-----------------------------------------------------//

  Event36(){//constructor
    TextField myTextField = 
                        new TextField("Initial String",30);
    myTextField.addTextListener(this);
    this.add(myTextField);        
    
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
 
  //Define the method of the TextListener interface
  public void textValueChanged(TextEvent e){
    System.out.println(
                     ((TextField)e.getSource()).getText());
  }//end TextValueChanged()

}//end class Event36 definition
//=======================================================//
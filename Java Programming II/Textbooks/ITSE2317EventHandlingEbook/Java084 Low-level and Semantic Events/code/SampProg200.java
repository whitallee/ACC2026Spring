/*From lesson 84

Note that this appears to be a duplicate of SampProg122.

 Copyright, R.G.Baldwin

 Without viewing the following solution, write a Java
 application that originally displays a Frame object
 containing a button at the top and a TextField object
 at the bottom.

 Cause the TextField to have red letters on a yellow
 background.

 When you click on the TextField object, it disappears.
 When you click on the Button object, the TextField object
 reappears.

 Use only low level events.

 When you click on the close button in the upper right-hand
 corner of the Frame object, the program terminates and
 control is properly returned to the operating system.
 //=========================================================
 */

 import java.awt.*;
 import java.awt.event.*;

 public class SampProg200 {
   public static void main(String[] args){
     GUI gui = new GUI();
   }//end main
 }//end class SampProg200
 //=========================================================

 class GUI {
   public GUI(){//constructor
     //Create a visual TextField object 
     TextField myTextField = new TextField("Initial String");
     myTextField.setName("TextField1");
     myTextField.setBackground(Color.yellow);
     myTextField.setForeground(Color.red);

     //Create a visual Button object
     Button myButton = new Button("Click me");
     myButton.setName("Button1");
   
     //Create a visual Frame object
     Frame myFrame = new Frame();
     myFrame.setSize(300,100);
     myFrame.setTitle("Copyright, R.G.Baldwin");
     
     //Add the Button and the TextField to the Frame object
     myFrame.add("North",myButton);
     myFrame.add("South",myTextField);
     myFrame.setVisible(true);
    
     //Instantiate and register a MouseListener object which
     // will process mouse events on the Button object, and 
     // the TextField object.
     MouseProc mouseProcCmd = new MouseProc(
       myButton,myTextField);
     myTextField.addMouseListener(mouseProcCmd);
     myButton.addMouseListener(mouseProcCmd);

     //Instantiate and register a Listener object which will
     // terminate the program when the user closes the 
     // Frame object
     myFrame.addWindowListener(new WProc1());
   }//end constructor
 }//end class GUI definition
 //=========================================================

 //Low-level event monitor.
 // This listener class monitors for low-level mousePressed()
 // events. Whenever a mousePressed() event occurs, the 
 // event handler determines which object was the source of
 // the event and takes the appropriate action.

 class MouseProc extends MouseAdapter{
   Button refToButton = null;
   TextField refToTextField = null;
   String refToButtonName = null;
   String refToTextFieldName = null;
   
   public MouseProc(//constructor
         Button inRefToButton, TextField inRefToTextField){
     refToButton = inRefToButton;
     refToTextField = inRefToTextField;
     refToButtonName = inRefToButton.getName();
     refToTextFieldName = inRefToTextField.getName();
   }//end constructor
   
   public void mousePressed(MouseEvent e){
     if(e.getComponent().getName().compareTo(refToTextFieldName) == 0)
       refToTextField.setVisible(false);
     if(e.getComponent().getName().compareTo(refToButtonName) == 0)
       refToTextField.setVisible(true);
   }//end mousePressed()
 }//end class MouseProc
 //====================================================================

 //The following listener class is used to terminate the 
 // program when the user closes the Frame object.
 class WProc1 extends WindowAdapter{
   public void windowClosing(WindowEvent e){
     System.exit(0);
   }//end windowClosing()
 }//end class WProc1
 //====================================================================

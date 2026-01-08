/*From lesson 84

Note that this appears to be a duplicate of SampProg123
 Copyright, R.G.Baldwin
 */

 import java.awt.*;
 import java.awt.event.*;

 public class SampProg201 {
   public static void main(String[] args){
     GUI gui = new GUI();
   }//end main
 }//end class SampProg201
 //=========================================================

 class GUI {
   public GUI(){//constructor
     //Create a visual TextField object 
     TextField myTxtField = new TextField("Initial String");
     myTxtField.setBackground(Color.yellow);
     myTxtField.setForeground(Color.red);

     //Create a visual Button object
     Button myButton = new Button("Click me");
   
     //Create a visual Frame object
     Frame myFrame = new Frame();
     myFrame.setSize(300,100);
     myFrame.setTitle("Copyright, R.G.Baldwin");
     
     //Add the Button and the TextField to the Frame object
     myFrame.add("North",myButton);
     myFrame.add("South",myTxtField);
     myFrame.setVisible(true);
    
     //Instantiate and register a MouseListener object which
     // will process mouse events on the TextField object.
     myTxtField.addMouseListener(new MouseProc(myTxtField));
     
     //Instantiate and register an ActionListener object 
     // which will process action events on the Button 
     // object.
     myButton.addActionListener(
       new MyActionProcessor(myTxtField));

     //Instantiate and register a Listener object which will
     // terminate the program when the user closes the 
     // Frame object
     myFrame.addWindowListener(new WProc1());
   }//end constructor
 }//end class GUI definition
 //=========================================================

 //Low-level event monitor.
 // This listener class monitors for low-level 
 // mousePressed() events. 
 class MouseProc extends MouseAdapter{
   TextField refToTextField = null;

   public MouseProc(TextField inRefToTextField){
     refToTextField = inRefToTextField;  
   }//end constructor
   
   public void mousePressed(MouseEvent e){
     refToTextField.setVisible(false);
   }//end mousePressed()
 }//end class MouseProc
 //=========================================================
 //Semantic event monitor.
 // This listener class monitors for semantic action events.

 class MyActionProcessor implements ActionListener{
   TextField refToTextField = null;
   
   MyActionProcessor(TextField inRefToTextField){//construct
     refToTextField = inRefToTextField;
   }//end constructor

   public void actionPerformed(ActionEvent e){
     refToTextField.setVisible(true);   
   }//end overridden actionPerformed method

 }//end class MyActionProcessor


 //=========================================================

 //The following listener class is used to terminate the 
 // program when the user closes the Frame object.
 class WProc1 extends WindowAdapter{
   public void windowClosing(WindowEvent e){
     System.exit(0);
   }//end windowClosing()
 }//end class WProc1
 //=========================================================

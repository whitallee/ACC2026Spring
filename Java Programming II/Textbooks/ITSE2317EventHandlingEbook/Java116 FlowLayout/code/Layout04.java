/*File Layout04.java Copyright, R.G.Baldwin
 Revised 10/28/97 to better accommodate the width
 requirements of the document.

 This program is designed to be compiled and run under 
 JDK 1.1

 This program creates a "Plain Vanilla" visual object by 
 placing five non-functional Button objects on a Frame 
 object using the FlowLayout manager. The buttons are 
 non-functional because no event listener objects were 
 created and registered on the buttons.

 The FlowLayout object is constructed with LEFT alignment, 
 a ten-pixel horizontal gap between components, and a 
 fifteen-pixel vertical gap between components.

 Resizing the Frame object causes the positions of the 
 components to adjust automatically.

 For simplicity, no event listeners were created and 
 registered.  Therefore, the "close" box is not operational
 and you will need to use some other method to terminate 
 the program.

 The program was tested using JDK 1.1.3 running under Win95.
 */
 //=======================================================//

 import java.awt.*;
 import java.awt.event.*;
 //=======================================================//
 public class Layout04 {
   public static void main(String[] args){
     //instantiate a Graphical User Interface object
     GUI gui = new GUI();
   }//end main
 }//end class Layout04
 //=======================================================//

 class GUI {
   public GUI(){//constructor
     Frame myFrame = new Frame(
                             "Copyright, R.G.Baldwin");
     myFrame.setLayout(//align,Hgap,Vgap
                     new FlowLayout(FlowLayout.LEFT,10,15));
     myFrame.add(new Button("First"));
     myFrame.add(new Button("Second"));
     myFrame.add(new Button("Third"));
     myFrame.add(new Button("Fourth"));
     myFrame.add(new Button("Fifth"));
     myFrame.setSize(250,150);
     myFrame.setVisible(true);
   }//end constructor
 }//end class GUI definition
 //=======================================================//
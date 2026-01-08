/*File SwingPane01 Copyright, R.G.Baldwin
Revised 1/12/99 for JDK 1.2 Swing compatibility

The purpose of this program is to illustrate the use of
the content pane and the layered pane.

The program places a JFrame object on the screen as the
primary GUI.

A red JTextField and a white JLabel are placed on the 
content pane on the JFrame object.  (The white label is
actually rendered as gray in the metal L&F.)
  
The JTextField is placed in the Center of the JFrame using
the default border layout.  The JLabel is placed in the
South position on the JFrame object.

A green JButton and a yellow JButton are placed on the
layered pane of the JFrame object.  Appareltly the default
layout for the layered pane is absolute or null.  The 
JButton objects are purposely placed so as to partially
overlap.  Both buttons appear on top of the JTextField
object on the content pane.

The green JButton is initially placed at layer position +1
on the layered pane and the yellow JButton is initially 
placed at layer position -29999 which is the limit in the 
negative direction.

Action listeners are registered on the two buttons.  When
the top button is clicked, the action is to swap the layer
positions of the two buttons causing the other one to
move to the top layer position.

Several lines of code are included to investigate the
parent child relationships of the various panes.  The
output from this part of the program follows.  Note that
line breaks were manually inserted here to force the
material to fit in this format.


Root pane is: class com.sun.java.swing.JRootPane
Parent of root pane is SwingPane01
     [frame0,0,0,0x0,invalid,hidden,
     layout=java.awt.BorderLayout,resizable,title=]

Glass pane is: class com.sun.java.swing.JPanel
Parent of glass pane is com.sun.java.swing.JRootPane
     [,0,0,0x0,invalid,
     layout=com.sun.java.swing.JRootPane$RootLayout]

Layered pane is: class com.sun.java.swing.JLayeredPane
Parent of layered pane is com.sun.java.swing.JRootPane
     [,0,0,0x0,invalid,
     layout=com.sun.java.swing.JRootPane$RootLayout]

Content pane is: class com.sun.java.swing.JPanel
Parent of content pane is com.sun.java.swing.JLayeredPane
     [null.layeredPane,0,0,0x0,invalid]

An interpretation of the above is:
  The root pane is a child of the JFrame object.
  The glass page is a child of the root pane.
  The layered pane is a child of the root pane.
  The content pane is a child of the layered pane.
  
  The root pane is of type JRootPane.
  The glass pane is of type JPanel.
  The layered pane is of type JLayeredPane.
  The content pane is of type JPanel.
  
The JavaSoft documentation indicates that the content pane
is placed at layer position -30000 in the layered pane.

The glass pane is something of a mystery at this point.
I was unable to draw upon the glass pane.  An attempt to 
place either a JButton object or a JTooltip object on the
glass plane was rejected by the compiler with error
messages that the JButton and the JToolTip could not be
converted to type JPopupMenu.

Tested using JDK 1.1.6 and Swing 1.0.1 under Win95.
**********************************************************/

import java.awt.*;
import java.awt.event.*;
//import com.sun.java.swing.*;//JDK 1.1 version
import javax.swing.*;//JDK 1.2 version

class SwingPane01 extends JFrame{//subclass JFrame
  JLayeredPane theLayeredPane;
  JButton greenButton;
  JButton yellowButton;
  
  public static void main(String[] args){
    new SwingPane01();
  }//end main
  //-----------------------------------------------------//
  
  SwingPane01(){//constructor
    //Get a ref to the layered pane for later use.
    theLayeredPane = this.getLayeredPane();
    int frameWidth = 300;
    int frameHeight = 200;
    
    //Get and display types of different panes along with
    // parent-child hierarchy.
    System.out.println("Root pane is: " + 
                            this.getRootPane().getClass());
    System.out.println("Parent of root pane is " + 
                    this.getRootPane().getParent() + "\n");

    System.out.println("Glass pane is: " + 
                           this.getGlassPane().getClass());
    System.out.println("Parent of glass pane is " + 
                   this.getGlassPane().getParent() + "\n");

    System.out.println("Layered pane is: " + 
                         this.getLayeredPane().getClass());
    System.out.println("Parent of layered pane is " + 
                 this.getLayeredPane().getParent() + "\n");
                         
    System.out.println("Content pane is: " + 
                         this.getContentPane().getClass());
    System.out.println("Parent of content pane is " + 
                 this.getContentPane().getParent() + "\n");
          

    //Put instructons in a JLabel on the content pane.
    JLabel theLabel = new JLabel(
         "  Click buttons to swap their layer positions.");
    this.getContentPane().add(theLabel,"South");
    
    //Put a red JTextField in the Center of the JFrame on
    // the content pane.
    JTextField redTextField = new JTextField(
                        "    redTextField on contentPane");
    redTextField.setBackground(Color.red);
    this.getContentPane().add(redTextField,"Center");
    
    //Put a green JButton on the layered pane at a layer
    // position of +1.
    greenButton = new JButton(
                            "greenButton on Layered Pane");
    greenButton.setBackground(Color.green);
    greenButton.setBounds(10,10,240,40);
    greenButton.addActionListener(new MyActionListener());
    theLayeredPane.add(greenButton,new Integer(1));
      
    //Put a yellow JButton on the layered pane at a layer
    // position of -29999.
    yellowButton = new JButton(
                           "yellowButton on Layered Pane");
    yellowButton.setBackground(Color.yellow);
    yellowButton.setBounds(40,20,240,40);
    yellowButton.addActionListener(new MyActionListener());
    theLayeredPane.add(yellowButton,new Integer(-29999));

    //Set title, size, and visibility of JFrame object.   
    this.setTitle("Copyright, R.G.Baldwin");
    this.setSize(frameWidth,frameHeight);
    this.setVisible(true);
    //===================================================//
    //Anonymous inner class to terminate program.
    this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
          System.exit(0);}});//end addWindowListener
          
  }//end constructor
  //=====================================================//
  
  //Inner class for listener objects which swap the layer
  // positions of the two JButton objects when the one on
  // the top is clicked.
  class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getActionCommand().equals(
                           "greenButton on Layered Pane")){
        theLayeredPane.setLayer(greenButton,-29999);
        theLayeredPane.setLayer(yellowButton,1);
      }else{
        theLayeredPane.setLayer(greenButton,1);
        theLayeredPane.setLayer(yellowButton,-29999);
      }//end else
    }//end actionPerformed()
  }//end class MyActionListener


}//end class SwingPane01
//=======================================================//
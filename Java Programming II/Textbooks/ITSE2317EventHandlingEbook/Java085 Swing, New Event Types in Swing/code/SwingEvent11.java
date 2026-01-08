/*File SwingEvent11.java Copyright, R.G.Baldwin
Revised 1.12/98 for JDK 1.2 Swing compatibility.

Further illustrates use of AncestorListener on a JButton.
Also see SwingEvent10.java.

Illustrates that JButton objects are containers that 
can contain other JButton objects.

This program stacks three JButton objects on top of one
another with the stack of three JButton objects being
placed on a JFrame object.

Running the program and carefully clicking each of the
three buttons in succession from the top of the stack to
the bottom of the stack, and then moving the JFrame object
on the screen produces the following output. Note that
some blank lines were manually inserted to make it easier
to follow this material.

Make JFrame visible
In ancestorAdded method
Event source: First Button
In ancestorAdded method
Event source: Second Button
In ancestorAdded method
Event source: Third Button

In ancestorMoved method
Event source: First Button
In ancestorMoved method
Event source: Second Button
In ancestorMoved method
Event source: Third Button

In ancestorMoved method
Event source: First Button
In ancestorMoved method
Event source: Second Button
In ancestorMoved method
Event source: Third Button

In ancestorMoved method
Event source: Second Button
In ancestorMoved method
Event source: Third Button
In ancestorMoved method
Event source: Third Button

In actionPerformed method
Event source: Third Button
In actionPerformed method
Event source: Second Button
In actionPerformed method
Event source: First Button

In ancestorMoved method
Event source: First Button
In ancestorMoved method
Event source: Second Button
In ancestorMoved method
Event source: Third Button


Tested using JDK 1.1.6 and Swing 1.0.1 under Win95.
**********************************************************/
import java.awt.*;
import java.awt.event.*;
//import com.sun.java.swing.*;//JDK 1.1 version
//import com.sun.java.swing.event.*;//JDK 1.1 version
import javax.swing.*;//JDK 1.2 version
import javax.swing.event.*;//JDK 1.2 version

public class SwingEvent11 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUI
  }//end main
}//end class SwingEvent11
//=======================================================//

//The following class is used to instantiate a 
// graphical user interface object.
class GUI {
  public GUI(){//constructor
    //Create a new JFrame object, set size, title, etc.
    JFrame displayWindow = new JFrame();
    displayWindow.setSize(300,100);
    displayWindow.setTitle("Copyright, R.G.Baldwin");
    
    //Note required use of getContentPane() in following
    // statement.
    displayWindow.getContentPane().setLayout(
                                          new FlowLayout());
    //Add window listener to terminate the program
    displayWindow.addWindowListener(new WProc1());
    
    //Create three JButton objects
    JButton firstButton = new JButton("First Button");
    JButton secondButton = new JButton("Second Button");
    JButton thirdButton = new JButton("Third Button");
    
    //Stack the three JButton objects on top of one
    // another.
    firstButton.add(secondButton);
    secondButton.add(thirdButton);
    
    //Register an AncestorListener object on each JButton
    firstButton.addAncestorListener(
                                 new MyAncestorListener());
    secondButton.addAncestorListener(
                                 new MyAncestorListener());
    thirdButton.addAncestorListener(
                                 new MyAncestorListener());
    
    //Register an ActionListener object on each JButton
    firstButton.addActionListener(new MyActionListener());
    secondButton.addActionListener(new MyActionListener());
    thirdButton.addActionListener(new MyActionListener());
    
    //Add the JButton to the JFrame using content pane
    displayWindow.getContentPane().add(firstButton);

    System.out.println("Make JFrame visible");
    displayWindow.setVisible(true);    
  }//end constructor
  //.....................................................//
  //Begin inner class definitions

  //The following listener is used to terminate the 
  // program when the user closes the frame.
  class WProc1 extends WindowAdapter{
    public void windowClosing(WindowEvent e){
      System.exit(0);
    }//end windowClosing()
  }//end class WProc1
  //.....................................................//

  //Define an AncestorListener class
  class MyAncestorListener implements AncestorListener{
    //Define three methods declared in AncestorListener
    // interface.  Note the required downcasting.
    
    public void ancestorAdded(AncestorEvent e){
      System.out.println("In ancestorAdded method");
      System.out.println("Event source: " + 
              ((JButton)e.getSource()).getActionCommand());
    }//end ancestorAdded()
      
    public void ancestorRemoved(AncestorEvent e){
      System.out.println("In ancestorRemoved method");
      System.out.println("Event source: " + 
              ((JButton)e.getSource()).getActionCommand());
    }//end ancestorRemoved()
      
    public void ancestorMoved(AncestorEvent e){
      System.out.println("In ancestorMoved method");
      System.out.println("Event source: " + 
              ((JButton)e.getSource()).getActionCommand());

    }//end ancestorMoved
  }//end class MyAncestorListener
  //.....................................................//

  //Define an ActionListener class
  class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("In actionPerformed method");
      System.out.println("Event source: " + 
              ((JButton)e.getSource()).getActionCommand());
    }//end actionPerformed()
  }//end class MyActionListener
  //.....................................................//

}//end class GUI definition
//=======================================================//
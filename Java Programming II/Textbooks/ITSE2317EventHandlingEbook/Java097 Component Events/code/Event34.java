/*File Event34.java
Copyright, R.G.Baldwin

This program illustrates component events, and invokes the
componentShown() and componentHidden() methods of the
ComponentListener interface under program control.

The user can invoke the componentMoved() and 
componentResized() methods by moving and resizing the
Frame object.  

The program also illustrates the use of an anonymous
inner class.  

It also illustrates the use of the controlling class as a 
listener class.  In this situation, the listener methods 
are defined as methods of the controlling class rather than
being defined as methods of separately compiled listener
classes.

Typical output from the program with line breaks manually
inserted is shown below:
  
Shown
Event34[frame0,0,0,350x100,layout=java.awt.BorderLayout,
resizable,title=Copyright R.G.Baldwin]
Hidden
Event34[frame0,0,0,350x100,layout=java.awt.BorderLayout,
resizable,title=Copyright R.G.Baldwin]
Shown
Event34[frame0,0,0,350x100,layout=java.awt.BorderLayout,
resizable,title=Copyright R.G.Baldwin]
Moved
Event34[frame0,31,43,350x100,layout=java.awt.BorderLayout,
resizable,title=Copyright R.G.Baldwin]
Resized
Event34[frame0,31,43,282x139,layout=java.awt.BorderLayout,
resizable,title=Copyright R.G.Baldwin]

        
This program was tested using JDK 1.1.6 under Win95.
**********************************************************/
import java.awt.*;
import java.awt.event.*;

//Note that the controlling class implements the
// ComponentListener interface.
class Event34 extends Frame implements ComponentListener{
  
  public static void main(String[] args){
    new Event34();//instantiate this object
   }//end main
  //=====================================================//

  public Event34(){//constructor
    //Add a component listener
    this.addComponentListener(this);
    this.setSize(350,100);
    this.setTitle("Copyright R.G.Baldwin");
    this.setVisible(true);//invoke shown event
    this.setVisible(false);//invoke hidden event
    this.setVisible(true);//invoke shown event
    
    //Anonymous inner-class listener to terminate program
    this.addWindowListener(
      new WindowAdapter(){//anonymous class definition
        public void windowClosing(WindowEvent e){
          System.exit(0);//terminate the program
        }//end windowClosing()
      }//end WindowAdapter
    );//end addWindowListener
  }//end constructor     
  //-----------------------------------------------------//
  
  //Define the methods of the ComponentListener interface
  public void componentResized(ComponentEvent e){
    System.out.println("Resized\n" + e.getSource());
  }//end componentResized()

  public void componentMoved(ComponentEvent e){
    System.out.println("Moved\n" + e.getSource());
  }//end componentMoved()

  public void componentShown(ComponentEvent e){
    System.out.println("Shown\n" + e.getSource());
  }//end componentShown()

  public void componentHidden(ComponentEvent e){
    System.out.println("Hidden\n" + e.getSource());
  }//end componentHidden()

}//end class Event34   
//=======================================================//

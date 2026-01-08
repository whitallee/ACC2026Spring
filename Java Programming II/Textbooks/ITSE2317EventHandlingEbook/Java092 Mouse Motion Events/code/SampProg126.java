/*File SampProg126.java from chapter 92
Copyright, R. G. Baldwin
Without viewing the following solution, write a Java
application that meets the specifications given below.

The solution shown below was successfully tested using
JDK 1.1.3 under Win95.

Write an application that displays a Frame object with
a width of 300 pixels and a height of 200 pixels. Put
your name in the banner at the top of the Frame.

When you move your mouse pointer into the client area of
the Frame, the coordinates of the mouse pointer appear
directly above the pointer. As you move the mouse pointer
around in the client area, the coordinates of the pointer
continue to be displayed above the pointer.

When you move the mouse pointer out of the client area, the
coordinates of the exit point appear and remain in view
until you again move the pointer into the client area.

If you press one of the mouse buttons while moving the
mouse in the client area, the coordinates of the point
where you pressed the button appear and remain there until
you release the mouse button, at which time the
coordinates of the mouse pointer resume being displayed.

Closing the frame terminates the program and returns
control to the operating system.

End of specifications.

*/
//=========================================================
import java.awt.*;
import java.awt.event.*;

public class SampProg126 {
 public static void main(String[] args){
 GUI gui = new GUI();
 }//end main
}//end class SampProg126
//=========================================================

//Subclass Frame in order to override the paint method.
class MyFrame extends Frame{
 int xCoor;
 int yCoor;

 MyFrame(String name){//constructor
 this.setTitle("Copyright, R.G.Baldwin");
 this.setSize(300,200);
 this.setName(name);
 }//end constructor

 public void paint(Graphics g){
 //display coordinate information on the Frame
 g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
 }//end paint()
}//end class MyFrame
//==========================================================

class GUI {
 public GUI(){//constructor
 //Create a visual object of type MyFrame named Frame1
 MyFrame myFrame1 = new MyFrame("Frame1");
 myFrame1.setVisible(true);

 //Instantiate and register Listener object which will
 // terminate the program when the user closes
 // the Frame.
 WProc1 winProcCmd1 = new WProc1();
 myFrame1.addWindowListener(winProcCmd1);

 //Instantiate and register Listener object which will
 // process mouseMoved events to display coordinate
 // information on the Frame object named myFrame1.
 MyMouseMotionProcessor mouseMotionProc =
 new MyMouseMotionProcessor(myFrame1);
 myFrame1.addMouseMotionListener(mouseMotionProc);

 }//end constructor
}//end class GUI definition
//=========================================================

//This listener class monitors for mouseMove events and
// displays the coordinates of the mouse pointer when the
// mouse is moved inside the client area of the Frame.
class MyMouseMotionProcessor extends MouseMotionAdapter{
 MyFrame refToFrame1; //save references to the Frame

 //Constructor
 MyMouseMotionProcessor(MyFrame inFrame1){
 //save incoming object reference
 refToFrame1 = inFrame1;
 }// end constructor

 public void mouseMoved(MouseEvent e){
 //Get X and Y coordinates of mouse pointer and store
 // in instance variables of the Frame object
 refToFrame1.xCoor = e.getX();
 refToFrame1.yCoor = e.getY();
 //Force a repaint to display the coordinate information
 refToFrame1.repaint();
 }//end mouseMoved()

}//end class MyMouseMotionProcessor

//=========================================================

//The following listener is used to terminate the program
// when the user closes the frame object.
class WProc1 extends WindowAdapter{
 public void windowClosing(WindowEvent e){
 System.exit(0);
 }//end windowClosing()
}//end class WProc1
//=========================================================
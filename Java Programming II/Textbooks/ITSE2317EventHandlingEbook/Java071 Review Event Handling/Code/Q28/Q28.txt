/*File Q28.java  from lesson 92
**********************************************************/
import java.awt.*;
import java.awt.event.*;

public class Q28 {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class Q28
//=========================================================

class MyFrame extends Frame{
  int xCoor;
  int yCoor;

  MyFrame(String name){//constructor
    this.setTitle("Q28");
    this.setSize(300,200);
    this.setName(name);
  }//end constructor

  public void paint(Graphics g){
    g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
  }//end paint()
}//end class MyFrame
//==========================================================

class GUI {
  public GUI(){//constructor
    MyFrame myFrame1 = new MyFrame("Frame1");
    myFrame1.setVisible(true);

    myFrame1.addWindowListener(new WProc1());

    MyMouseMotionProcessor mouseMotionProc =
                    new MyMouseMotionProcessor(myFrame1);
    myFrame1.addMouseMotionListener(mouseMotionProc);

  }//end constructor
}//end class GUI definition
//=========================================================

class MyMouseMotionProcessor extends MouseMotionAdapter{
  MyFrame refToFrame1; //save references to the Frame

  MyMouseMotionProcessor(MyFrame inFrame1){
    refToFrame1 = inFrame1;
  }// end constructor

  public void mouseMoved(MouseEvent e){
    refToFrame1.xCoor = e.getX();
    refToFrame1.yCoor = e.getY();
    refToFrame1.repaint();
  }//end mouseMoved()

}//end class MyMouseMotionProcessor
//=========================================================

class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=========================================================
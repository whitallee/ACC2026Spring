/*File Q23.java
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;

public class Q23 {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class Q23
//=======================================================//

class MyFrame extends Frame{
  int xCoor;
  int yCoor;

  MyFrame(){//constructor
    setTitle("Q3");
    setSize(200,200);
  }//end constructor

  public void paint(Graphics g){
    g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
  }//end paint()
}//end class MyFrame
//=======================================================//

class GUI {
  public GUI(){//constructor

    MyFrame myFrame1 = new MyFrame();
    myFrame1.setVisible(true);

    MyFrame myFrame2 = new MyFrame();
    myFrame2.setLocation(201,0);
    myFrame2.setVisible(true);

    WProc1 winProcCmd1 = new WProc1();
    myFrame1.addWindowListener(winProcCmd1);
    myFrame2.addWindowListener(winProcCmd1);

    MouseProc mouseProcCmd = new MouseProc();
    myFrame1.addMouseListener(mouseProcCmd);
    myFrame2.addMouseListener(mouseProcCmd);
  }//end constructor
}//end class GUI definition
//=======================================================//

class MouseProc extends MouseAdapter{
  public void mousePressed(MouseEvent e){
    ((MyFrame)e.getComponent()).xCoor = e.getX();
    ((MyFrame)e.getSource()).yCoor = e.getY();
    e.getComponent().repaint();
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

class WProc1 extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//

/*File Q32.java Copyright R.G.Baldwin
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q32 {
  public static void main(String[] args){
    new Q32gui();
  }//end main
}//end class Q32
//=======================================================//

class Q32gui {
  public Q32gui(){//constructor
    JFrame theFrame = new JFrame();
    theFrame.setSize(200,200);
    theFrame.setTitle("Q32");
    DisplaySpace displayWindow = new DisplaySpace();

    theFrame.getContentPane().add(displayWindow,"Center");
    theFrame.setDefaultCloseOperation(
                                     JFrame.EXIT_ON_CLOSE);
    theFrame.setVisible(true);

    displayWindow.addMouseListener(
                                new MProc1(displayWindow));
  }//end constructor
//=======================================================//

class DisplaySpace extends JPanel{

  int clickX;
  int clickY;

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawString(
              "" + clickX + ", " + clickY, clickX, clickY);
  }//end paintComponent
}//end class DisplaySpace
//=======================================================//

//class MProc1 implements MouseListener{
class MProc1 extends MouseAdapter{
  DisplaySpace refToWin;

  MProc1(DisplaySpace inWin){//constructor
    refToWin = inWin;//save ref to window
  }//end constructor

  public void mousePressed(MouseEvent e){
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();
    refToWin.repaint();//display coordinate information
  }//end mousePressed()
}//end class MProc1
}//end GUI class
//=======================================================//

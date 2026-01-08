/*File Q35.java
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q35 {
  public static void main(String[] args){
    new Q35gui();
  }//end main
}//end class Q35
//=======================================================//

class Q35gui extends JFrame{
  public Q35gui(){//constructor
    setSize(200,200);
    setTitle("Q35");
    getContentPane().add(new DisplaySpace(),"Center");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }//end constructor
}//end Q35gui
//=======================================================//

class DisplaySpace extends JPanel{

  int clickX;
  int clickY;

  DisplaySpace(){
    addMouseMotionListener(
      new MouseMotionAdapter(){//anonymous class definition
        public void mouseMoved(MouseEvent e){
          setForeground(Color.RED);
          clickX = e.getX();
          clickY = e.getY();
          repaint();
        }//end mouseMoved
        public void mouseDragged(MouseEvent e){
          setForeground(Color.BLACK);
          clickX = e.getX();
          clickY = e.getY();
          repaint();
        }//end mouseDragged
      }//end MouseAdapter
    );//end addMouseListener()
  }//end constructor
  //-----------------------------------------------------//

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawString(
              "" + clickX + ", " + clickY, clickX, clickY);
  }//end paintComponent
}//end class DisplaySpace
//=======================================================//


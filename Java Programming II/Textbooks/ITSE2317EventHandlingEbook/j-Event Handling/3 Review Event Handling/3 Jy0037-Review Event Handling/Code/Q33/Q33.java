/*File Q33.java
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q33 {
  public static void main(String[] args){
    new Q33gui();
  }//end main
}//end class Q33
//=======================================================//

class Q33gui extends JFrame{
  public Q33gui(){//constructor
    setSize(200,200);
    setTitle("Q33");
    getContentPane().add(new DisplaySpace(),"Center");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }//end constructor
}//end Q33gui
//=======================================================//

class DisplaySpace extends JPanel{

  int clickX;
  int clickY;

  DisplaySpace(){
    addMouseListener(
      new MouseAdapter(){//anonymous class definition
        public void onMouseEvent(MouseEvent e){
          clickX = e.getX();
          clickY = e.getY();
          repaint();
        }//end onMouseEvent()
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


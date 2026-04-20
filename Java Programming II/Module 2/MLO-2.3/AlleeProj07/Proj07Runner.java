/*File Proj07Runner.java
Whit Allee
04/10/2026
ITSE 2317-001
Professor Baldwin
************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Proj07Runner {
  JFrame theJFrame;

  public Proj07Runner() {
    System.out.println(
      "I certify that this program is my own work\n" +
      "and is not the work of others. I agree not\n" +
      "to share my solution with others.\n" +
      "Whit Allee\n"
    );

    theJFrame = new JFrame("Whit Allee");
    theJFrame.setSize(300, 100);
    theJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DisplaySpace displaySpace = new DisplaySpace();
    theJFrame.getContentPane().add(displaySpace);

    MProc mouseProc = new MProc(displaySpace);
    displaySpace.addMouseListener(mouseProc);

    theJFrame.setVisible(true);
  }//end constructor

  public JFrame getJFrame() {
    return theJFrame;
  }//end getJFrame

  //-------------------------------------------------------//

  class DisplaySpace extends JPanel {
    int xCoor = 160;
    int yCoor = 60;

    public void paintComponent(Graphics g) {
      super.paintComponent(g);//clears background, erasing old coordinates
      g.setColor(Color.black);
      g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
    }//end paintComponent
  }//end class DisplaySpace

  //-------------------------------------------------------//

  class MProc extends MouseAdapter {
    DisplaySpace refToDisplay;

    MProc(DisplaySpace inDisplay) {
      refToDisplay = inDisplay;
    }//end constructor

    public void mousePressed(MouseEvent e) {
      refToDisplay.xCoor = e.getX();
      refToDisplay.yCoor = e.getY();
      refToDisplay.repaint();
    }//end mousePressed
  }//end class MProc

}//end class Proj07Runner

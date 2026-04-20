/*File Proj08Runner.java
Whit Allee
04/13/2026
ITSE 2317-001
Professor Baldwin
************************************************************/

import java.awt.*;
import java.awt.event.*;

public class Proj08Runner extends Frame {
  int xCoor = 79;
  int yCoor = 91;
  Color textColor = Color.black;

  public Proj08Runner() {
    System.out.println(
      "I certify that this program is my own work\n" +
      "and is not the work of others. I agree not\n" +
      "to share my solution with others.\n" +
      "Whit Allee\n"
    );

    setTitle("Whit Allee");
    setSize(300, 100);
    setVisible(true);

    MouseEventHandler myMouseEventHandler = new MouseEventHandler(this);
    addMouseMotionListener(myMouseEventHandler);

    WindowEventHandler myWindowEventHandler = new WindowEventHandler();
    addWindowListener(myWindowEventHandler);
  }//end constructor

  public void paint(Graphics g) {
    g.setColor(textColor);
    g.drawString("" + xCoor + ", " + yCoor, xCoor, yCoor);
  }//end paint

  //-------------------------------------------------------//

  class MouseEventHandler extends MouseMotionAdapter {
    Proj08Runner refToFrame;

    MouseEventHandler(Proj08Runner inFrame) {
      refToFrame = inFrame;
    }//end constructor

    public void mouseMoved(MouseEvent e) {
      refToFrame.xCoor = e.getX();
      refToFrame.yCoor = e.getY();
      refToFrame.textColor = Color.black;
      refToFrame.repaint();
    }//end mouseMoved

    public void mouseDragged(MouseEvent e) {
      refToFrame.xCoor = e.getX();
      refToFrame.yCoor = e.getY();
      refToFrame.textColor = Color.red;
      refToFrame.repaint();
    }//end mouseDragged
  }//end class MouseEventHandler

  //-------------------------------------------------------//

  class WindowEventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }//end windowClosing
  }//end class WindowEventHandler

}//end class Proj08Runner

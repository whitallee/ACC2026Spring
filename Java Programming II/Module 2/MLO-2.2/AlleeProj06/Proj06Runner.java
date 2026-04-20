/*File Proj06Runner.java
 * By Whit Allee
 ************************************************************/
import java.awt.*;
import java.awt.event.*;

public class Proj06Runner {

  private static final String STUDENT_NAME = "Whit Allee";

  Frame frame;

  public Proj06Runner() {
    System.out.println("I certify that this program is my own work");
    System.out.println("and is not the work of others. I agree not");
    System.out.println("to share my solution with others.");
    System.out.println(STUDENT_NAME);

    GUI gui = new GUI(STUDENT_NAME);
    frame = gui.getDisplayWindow();
  }//end constructor

  public Frame getFrame() {
    return frame;
  }//end getFrame()
}//end class Proj06Runner
//=======================================================//

// Subclass Frame in order to override the paint method.
class MyFrame extends Frame {
  int labelX = 120;
  int labelY = 91;
  int pressX;
  int pressY;
  boolean mouseWasPressed = false;

  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.RED);

    Insets ins = getInsets();
    FontMetrics fm = g.getFontMetrics();
    int topBaseline = ins.top + fm.getAscent();
    g.drawString("Bottom inset value: " + ins.bottom, ins.left, topBaseline);

    String bottom = "x=" + labelX + ",y=" + labelY;
    int bw = fm.stringWidth(bottom);
    int clientW = getWidth() - ins.left - ins.right;
    int bx = ins.left + (clientW - bw) / 2;
    int bottomBaseline = getHeight() - ins.bottom - fm.getDescent();
    g.drawString(bottom, bx, bottomBaseline);

    if (mouseWasPressed) {
      g.drawString(bottom, pressX, pressY);
    }//end if
  }//end paint()
}//end class MyFrame
//=======================================================//

// Instantiates the frame, registers listeners on the source, shows window.
class GUI {
  MyFrame displayWindow;

  public GUI(String title) {
    displayWindow = new MyFrame();
    displayWindow.setSize(300, 100);
    displayWindow.setTitle(title);
    displayWindow.setBackground(Color.WHITE);
    displayWindow.setVisible(true);

    // Register listener objects on the event source (the Frame).
    displayWindow.addWindowListener(new WProc1());
    displayWindow.addMouseListener(new MouseProc(displayWindow));
  }//end constructor

  public Frame getDisplayWindow() {
    return displayWindow;
  }//end getDisplayWindow()
}//end class GUI
//=======================================================//

// Mouse listener: store coordinates on the source and repaint.
class MouseProc extends MouseAdapter {
  MyFrame refToWin;

  MouseProc(MyFrame inWin) {
    refToWin = inWin;
  }//end constructor

  public void mousePressed(MouseEvent e) {
    refToWin.labelX = e.getX();
    refToWin.labelY = e.getY();
    refToWin.pressX = refToWin.labelX;
    refToWin.pressY = refToWin.labelY;
    refToWin.mouseWasPressed = true;

    refToWin.repaint();
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

// Terminate when the user closes the frame.
class WProc1 extends WindowAdapter {
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
//=======================================================//

/*File Q21.java
**********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Q21 {
  public static void main(String[] args){
    GUI gui = new GUI();//instantiate a GUI
  }//end main
}//end class Q21
//=======================================================//

class MyFrame extends JFrame{
  int clickX;
  int clickY;

  public void paint(Graphics g){
    g.drawString(
             "" + clickX + ", " + clickY, clickX, clickY);
  }//end paint()
}//end class MyFrame
//=======================================================//

class GUI {
  public GUI(){//constructor
    MyFrame displayWindow = new MyFrame();
    displayWindow.setSize(300,300);
    displayWindow.setTitle("Q21");
    displayWindow.setVisible(true);
    displayWindow.setDefaultCloseOperation(
                                     JFrame.EXIT_ON_CLOSE);
    displayWindow.addMouseListener(
                             new MouseProc(displayWindow));
  }//end constructor
}//end class GUI definition
//=======================================================//

class MouseProc extends MouseAdapter{
  MyFrame refToWin; //save a reference to the source here

  MouseProc(MyFrame inWin){//constructor
    refToWin = inWin;//save ref to window
  }//end constructor

  public void mousePressed(MouseEvent e){
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();
    refToWin.repaint();
  }//end mousePressed()
}//end class MouseProc
//=======================================================//

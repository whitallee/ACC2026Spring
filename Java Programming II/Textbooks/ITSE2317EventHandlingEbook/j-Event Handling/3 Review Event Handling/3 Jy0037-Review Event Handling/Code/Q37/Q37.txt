/*File Q37.java Copyright R.G.Baldwin
**********************************************************/
//import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Label;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Q37{
  public static void main(String[] args){
    Frame aFrame = new Q37gui();
  }//end main
}//end class Q37
//=======================================================//

class Q37gui extends Frame
                implements WindowListener, ActionListener{
  Button button1 = new Button("Top");
  Button button2 = new Button("Bottom");
  Label label = new Label("Top");
//-------------------------------------------------------//

  public Q37gui(){//constructor

    this.setTitle("Q37");
    add(button1,BorderLayout.NORTH);
    label.setBackground(Color.GREEN);
    label.setForeground(Color.BLUE);
    add(label,BorderLayout.CENTER);
    add(button2,BorderLayout.SOUTH);
    button1.addActionListener(this);
    button2.addActionListener(this);
    this.setSize(150,100);
    this.setVisible(true);

    this.addWindowListener(this);
  }//end constructor
//-------------------------------------------------------//

  public void windowClosing(WindowEvent e){
    //terminate the program when the window is closed
    System.exit(0);
  }//end windowClosing
//-------------------------------------------------------//

  public void windowOpened(WindowEvent e){}//dummy
  public void windowClosed(WindowEvent e){}//dummy
  public void windowIconified(WindowEvent e){}//dummy
  public void windowDeiconified(WindowEvent e){}//dummy
  public void windowActivated(WindowEvent e){}//dummy
  public void windowDeactivated(WindowEvent e){}//dummy
//-------------------------------------------------------//

  public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().indexOf("Top") != -1)
      label.setText("Top");
    else
      label.setText("Bottom");
  }//end actionPerformed()

}//end class Q37gui
//=======================================================//
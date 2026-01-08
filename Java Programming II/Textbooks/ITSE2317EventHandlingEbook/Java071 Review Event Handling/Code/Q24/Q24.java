/*File Q24
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Q24 extends JFrame{//subclass JFrame
  JLayeredPane theLayeredPane;
  JButton greenButton;
  JButton yellowButton;

  public static void main(String[] args){
    new Q24();
  }//end main
  //-----------------------------------------------------//

  Q24(){//constructor
    theLayeredPane = this.getLayeredPane();
    int frameWidth = 300;
    int frameHeight = 100;

    JTextField redTextField = new JTextField("");
    redTextField.setBackground(Color.red);
    this.getContentPane().add(redTextField,"Center");

    greenButton = new JButton(
                            "greenButton on Layered Pane");
    greenButton.setBackground(Color.green);
    greenButton.setBounds(10,10,240,40);
    greenButton.addActionListener(new MyActionListener());
    theLayeredPane.add(greenButton,new Integer(1));

    yellowButton = new JButton(
                           "yellowButton on Layered Pane");
    yellowButton.setBackground(Color.yellow);
    yellowButton.setBounds(40,20,240,40);
    yellowButton.addActionListener(new MyActionListener());
    theLayeredPane.add(yellowButton,new Integer(-29999));

    //Set title, size, and visibility of JFrame object.
    this.setTitle("Q24");
    this.setSize(frameWidth,frameHeight);
    this.setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }//end constructor
  //=====================================================//

  class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getActionCommand().equals(
                           "greenButton on Layered Pane")){
        theLayeredPane.setLayer(greenButton,-29999);
        theLayeredPane.setLayer(yellowButton,1);
      }else{
        theLayeredPane.setLayer(greenButton,1);
        theLayeredPane.setLayer(yellowButton,-29999);
      }//end else
    }//end actionPerformed()
  }//end class MyActionListener
  //=====================================================//
}//end class Q24
//=======================================================//
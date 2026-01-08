/*File Q36.java
**********************************************************/
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Q36{
  public static void main(String[] args){
    JFrame aFrame = new Q36gui();
  }//end main
}//end class Q36
//=======================================================//

class Q36gui extends JFrame implements ActionListener{
  JButton button1 = new JButton("Top");
  JButton button2 = new JButton("Bottom");
  JLabel label = new JLabel("Top");
//-------------------------------------------------------//

  public Q36gui(){//constructor
    this.setTitle("Q36");
    this.getContentPane().add(button1,BorderLayout.NORTH);
    label.setBackground(Color.GREEN);
    label.setForeground(Color.BLUE);
    label.setOpaque(true);
    this.getContentPane().add(label,BorderLayout.CENTER);
    this.getContentPane().add(button2,BorderLayout.SOUTH);
    button1.addActionListener(this);
    button2.addActionListener(this);
    this.setSize(150,100);
    this.setVisible(true);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }//end constructor
//-------------------------------------------------------//

  public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().indexOf("Top") != -1)
      label.setText("Top");
    else
      label.setText("Bottom");
  }//end actionPerformed()

}//end class Q36gui
//=======================================================//
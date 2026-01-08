/*File Q30.java
**********************************************************/
import java.awt.*;
import java.awt.event.*;

public class Q30 extends Frame {
  Label myLabel;
  //-----------------------------------------------------//
  static public void main(String[] args){
    Q30 app = new Q30();
  }//end main()
  //-----------------------------------------------------//

  public Q30(){//constructor
    this.setTitle("Q30");
    this.setLayout(new FlowLayout());
    Button myButton;
    this.add(myButton = new Button("Button"));
    this.add(myLabel = new Label("Initial Text"));
    //---------------------------------------------------//

    myButton.addActionListener(
      new //instantiate anonymous object of the class
        ActionListener(){//anonymous class definition
          public void actionPerformed(ActionEvent e){
            myLabel.setText("Ouch");
          }//end actionPerformed()
        }//end ActionListener class definition
      );//end addActionListener() statement

    this.addWindowListener(
         new WindowAdapter(){//anonymous class definition
           public void windowClosing(WindowEvent e){
             System.exit(0);//terminate the program
           }//end windowClosing()
         }//end WindowAdapter
       );//end addWindowListener
    //---------------------------------------------------

    this.setSize(300,100);
    this.setVisible(true);
  }//end Q30 constructor
}//end class Q30
//=========================================================
/*File Q29.java Copyright, R.G.Baldwin
**********************************************************/
import java.awt.*;
import java.awt.event.*;

public class Q29 {
  void whistle() {System.out.println(
                     "I am whistling, Tweet Tweet Tweet");}
  //-------------------------------------------------------

  static public void main(String[] args){
    Q29 app = new Q29();
    GUI gui = app.new GUI();
  }//end main()
  //-------------------------------------------------------

  //The GUI class is defined inside the Q29 class and is
  // an inner-class of Q29.
  class GUI extends Frame{

    public GUI(){//constructor for GUI inner-class
      this.setTitle("Q29");
      Button whistleButton;
      this.add(whistleButton =
                          new Button("Whistle"),"Center");
      //---------------------------------------------------
      //Instantiates two anonymous objects of types
      // ActionListener and WindowAdapter. registers them
      // for handling
      // events on the Button object and  the Frame object.
      //Begin statement -----------------------------------
      whistleButton.addActionListener(
          new ActionListener(){//anonymous class definition
            public void actionPerformed(ActionEvent e){
              whistle();//call the whistle() method
            }//end actionPerformed()
          }//end ActionListener
        );//end addActionListener()
      //End statement -------------------------------------

      //Begin statement -----------------------------------
      this.addWindowListener(
           new WindowAdapter(){//anonymous class definition
             public void windowClosing(WindowEvent e){
               System.exit(0);//terminate the program
             }//end windowClosing()
           }//end WindowAdapter
         );//end addWindowListener
      //End statement -------------------------------------

      //---------------------------------------------------
      //Set frame size and make it visible.
      this.setSize(300,100);
      this.setVisible(true);
    }//end GUI constructor
  }//end class GUI
}//end class Q29
//=========================================================
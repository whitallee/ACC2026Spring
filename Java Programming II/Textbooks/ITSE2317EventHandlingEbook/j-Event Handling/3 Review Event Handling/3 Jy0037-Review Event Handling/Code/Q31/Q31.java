//34567890123456789012345678901234567890123456789012345678
/*File Q31
*********************************************************/
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
public class Q31{

  public static void main(String[] args){
    new Q31gui();
  }//end main method
}//end class Q31
//======================================================//

class Q31gui extends JFrame{

  private JSlider slider = new JSlider(-100,100);

  public Q31gui(){//constructor
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    slider.setMajorTickSpacing(20);
    slider.setMinorTickSpacing(10);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);

    getContentPane().add(slider);

    setSize(300,100);
    setTitle("Q31");
    setVisible(true);
    //--------------------------------------------------//

    slider.addChangeListener(
      new ChangeListener(){
        public void stateChanged(ChangeEvent e){
          System.out.print(" " + slider.getValue());
        }//end stateChanged
      }//end new ChangeListener
    );//end addChangeListener
    //--------------------------------------------------//
  }//end constructor
  //----------------------------------------------------//

}//end class Q31gui
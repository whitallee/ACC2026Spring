import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Proj05Runner {
    Proj05Runner() {
        System.out.println("I certify that this program is my own work\n" +
                            "and is not the work of others. I agree not\n" +
                            "to share my solution with others.\n" +
                            "Whit Allee\n");

        final JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setTitle("Whit Allee");
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }

                public void windowIconified(WindowEvent e) {
                    System.out.println("Good Night");
                }

                public void windowDeiconified(WindowEvent e) {
                    frame.setLocation(0, 0);
                    System.out.println("Good Morning");
                }
            }
        );

        frame.setVisible(true);
    }
}
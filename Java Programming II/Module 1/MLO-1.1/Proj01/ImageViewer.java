import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageViewer {
    private BufferedImage image;

    public ImageViewer(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        createAndShowGUI(); 
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(image.getWidth(), image.getHeight());
        ImagePanel imagePanel = new ImagePanel();
        frame.add(imagePanel);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                imagePanel.setImage(image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH));
            }
        });
        frame.setVisible(true);
    }

    private class ImagePanel extends JPanel {
        private Image scaledImage;

        public void setImage(Image image) {
            this.scaledImage = image;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (scaledImage != null) {
                g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "png", "jpg");
            fileChooser.setFileFilter(filter);
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                new ImageViewer(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("No file selected. Exiting.");
                System.exit(0);
            }
        } else {
            new ImageViewer(args[0]);
        }
    }
}

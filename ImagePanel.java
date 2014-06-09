
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;


public class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
 
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}

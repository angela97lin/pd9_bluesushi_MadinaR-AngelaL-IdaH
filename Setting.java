import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

// A GUI program is written as a subclass of Frame - the top-level container  
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class Setting extends JFrame {
    
    
    //Constructor to setup the GUI components
    public Setting(){
	setLayout(new FlowLayout());
	setSize(500,500);
	setDefaultCloseOperation(EXIT_ON_CLOSE);	   
	setVisible(true);
	   
	JPanel panel = new JPanel();
	getContentPane().add(panel);
	  
	
	//declare + instantiate a JButton instance called
	JButton setButton = new JButton("Setting"); 	   
	
	//event handling: source object(button), event object, listener object
	setButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    JLabel label1 = new JLabel("CHOOSE YOUR CHARACTER");
		    ImageIcon char1 = new ImageIcon(getClass().getResource("girl.jpg"));
		    JLabel label2 = new JLabel(char1);	 
		    add(label2);
		       
		}
	    });

	setButton.setPreferredSize(new Dimension(100,25));
	
	panel.add(setButton);
    }

    //adding buttons
    public static void main (String[] args){
	new Setting();
    }
}

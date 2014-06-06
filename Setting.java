// For the images of characters

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

// A GUI program is written as a subclass of Frame - the top-level container  
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class Setting extends JFrame {
    
    //INSTANCE VARIABLES
    private JPanel panel;
    private ImageIcon image;
    private JButton setButton;
    private JButton girl;
    private JButton elmo;
    private GridBagConstraints c;
    
    //Constructor to setup the GUI components
    public Setting(){
	//setLayout(new FlowLayout()); //left to right

	setSize(500,500);
	setDefaultCloseOperation(EXIT_ON_CLOSE); //so you can close when you press X	   
	setVisible(true);
	   
	panel = new JPanel(new GridBagLayout());
	getContentPane().add(panel);
	

	c = new GridBagConstraints();

	//declare + instantiate a JButton instance called
	setButton = new JButton("Settings"); 	   
	setButton.setPreferredSize(new Dimension(100,25));
      	panel.add(setButton); //add the button to the panel

	// image = new ImageIcon(getClass().getResource("girl.jpg"));
	// JLabel we = new JLabel(image);
	// panel.add(we);

	//event handling: source object(button), event object, listener object
	setButton.addActionListener ( new ActionListener(){
		public void actionPerformed ( ActionEvent e )
		{
		    setButton.setVisible(false);
		    
		    JLabel label = new JLabel( "Please choose your character" );
		    label.setLocation(250, 10);

		    //JPanel is where you can draw graphics and images
		    panel.add( label );

		    /* uncomment 3 lines below to show just an image
		    image = new ImageIcon(getClass().getResource("girl.jpg"));
		    JLabel mgirl = new JLabel(image);
		    panel.add(mgirl);
		    */
		    
		    //creating image buttons for user to select
		    girl = new JButton();
		    elmo = new JButton();
		    c.gridx = 150;
		    c.gridy = 50;
		    girl.setIcon(new ImageIcon("girl.JPG"));
		    panel.add( girl );
		    //girl.setLocation(150, 30);
		    //elmo.setLocation(300, 30);
		    
		    c.gridx = 300;
		    c.gridy = 50;
		    elmo.setIcon(new ImageIcon("elmo.jpg"));

		    panel.add( elmo );		    
		    
		}
	    });


	// if you click girl then your image is a girl
	girl.addActionListener (new ActionListener(){
		public void actionPerformed ( ActionEvent e )
		{
		    // image = new ImageIcon(getClass().getResource("girl.JPG"));
		    // JLabel we = new JLabel(image);
		    
		}
	    });


	// if you click elmo then your image is a elmo
	elmo.addActionListener (new ActionListener(){
		public void actionPerformed ( ActionEvent e )
		{
		    // image = new ImageIcon(getClass().getResource("elmo.jpg"));
		    // JLabel we = new JLabel(image);
		    
		}
	    });


    }//end constructor 

    // public void paintComponent(Graphics g){
    // 	super.paintComponent(g);
    // 	image = new ImageIcon("girl.jpg");
    // 	image.paintIcon(this, g, 100, 100);
    // }
    
    public static void main (String[] args){
	new Setting();
    }
}

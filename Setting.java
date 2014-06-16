import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;

// A GUI program is written as a subclass of Frame - the top-level container  
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane

public class Setting {  

    public Setting(){
    }

    public void draw(Graphics g){
	g.setColor(new Color(255,255,255));
	g.setFont(new Font("Courier New", Font.BOLD, 19));
	g.drawString("Please click on an image to choose your profile picture.", GamePlay.myWidth/2 - 250, 200);
	g.drawImage(GamePlay.image, GamePlay.myWidth/2 - 81, 230, null);
	g.drawImage(GamePlay.image2, GamePlay.myWidth/2, 230, null);
	g.setColor(new Color(168,168,230,63));
	g.fillRect(0,0,80,80);
	g.setColor(new Color(255,255,255));
	g.setFont(new Font("Courier New",Font.BOLD,19));
	g.drawString("Menu",20,45);

	g.setColor(new Color(168,168,230,63));
	g.fillRect(GamePlay.myWidth/2-81,400,200,75);
	g.fillRect(GamePlay.myWidth/2-81,480,200,75);
	g.fillRect(GamePlay.myWidth/2-81,560,200,75);

	g.setFont(new Font("Courier New",Font.BOLD,36));
	g.setColor(new Color(255,255,255));
	g.drawString("Easy", GamePlay.myWidth/2-30, 440);
	g.drawString("Medium", GamePlay.myWidth/2-50, 520);
	g.drawString("Hard", GamePlay.myWidth/2-30, 600);

    }
	



    }



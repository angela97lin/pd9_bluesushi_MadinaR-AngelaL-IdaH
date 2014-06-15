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
	g.drawImage(GamePlay.image, GamePlay.myWidth/2 - 81, 230, null);
	g.drawImage(GamePlay.image2, GamePlay.myWidth/2, 230, null);
	g.setColor(new Color(168,168,230,63));
	g.fillRect(0,0,80,80);
	g.setColor(new Color(255,255,255));
	g.setFont(new Font("Courier New",Font.BOLD,19));
	g.drawString("Menu",20,45);

    }
	



    }



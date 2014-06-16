import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class Menu extends Rectangle{

    public void draw(Graphics g){
	g.setColor(new Color(168,168,230,63));
	g.fillRect(350,225,400,100);
	g.fillRect(350,425,400,100);
	g.setColor(new Color(255,255,255));
	g.setFont(new Font("Courier New", Font.BOLD,64));
	g.drawString("Play",475,290);
	g.drawString("Settings",400,490);
	
    }



}

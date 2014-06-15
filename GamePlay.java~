import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class GamePlay extends JPanel implements Runnable{
    
    public Thread thread;
    public static boolean isFirst;
    public static int myWidth, myHeight;
    public static BufferedImage myImage,image, image2;
    public static int state;
    public static Play play;
    public static Setting setting;
    public static int ID;
    public static Point p;
    public static Menu menu;

    public GamePlay(Run run){
	Run.driver.addMouseListener(new Key());
	thread = new Thread(this);
	thread.start();

	try{
	    myImage = ImageIO.read(new File("background.jpg"));
	    image = ImageIO.read(new File("girl.png"));
	    image2 = ImageIO.read(new File("mafia.png"));
	}catch(Exception e){}
	isFirst = true;
	state = 0;
	ID = 1;
    }

    public void paintComponent(Graphics g){
	if (isFirst){
	    myWidth = getWidth();
	    myHeight = getHeight();
	    define();
	    
	    isFirst = false;
	}
	g.drawImage(myImage,0,0,getWidth(),getHeight(),this);
	if(ID == 1){
	    g.drawImage(image,919,myHeight/2-60,null);
	}
	if(ID == 2){
	    g.drawImage(image2,919,myHeight/2-60,null);
	}
	if(state == 0){
	    menu.draw(g);
	}
	
	if (state == 1){
	    play.draw(g);
	}
	if (state == 2){
	    setting.draw(g);
	}
	
    }

    public void define(){
	play = new Play();
	setting = new Setting();
	p = new Point(0,0);
	menu = new Menu();
    }
    
    public void run(){
	while(true){
	    if(!isFirst){
		
	    }
	    repaint();
	    /*try{
		thread.sleep(1);//slows down running
		}catch(Exception e){}*/
	}
    }





}

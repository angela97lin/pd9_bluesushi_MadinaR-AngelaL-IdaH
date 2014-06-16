import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class Key implements MouseMotionListener, MouseListener{

   
    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){
    }


    public void mouseReleased(MouseEvent e){
	
    }

    public void mouseDragged(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e){	
	GamePlay.p = new Point(e.getPoint());
	//if the state == the settings one
	//then set profPic to the image that is currently in the boundaries
	if(GamePlay.state == 1){//game mode
	    //if on a specific card
	    if(e.getX()>=0&&e.getX()<=80&&e.getY()>=GamePlay.myHeight/2-40&&
	       e.getY()<=GamePlay.myHeight/2+40){
		GamePlay.state = 0;
		GamePlay.stuff = 1;
	    }
	    else if(e.getX()>=200&&e.getX()<=280&&e.getY()>=355&&e.getY()<=395
		    &&Play.turn){
		GamePlay.play.go();
		GamePlay.stuff = 1;
	    }
	    else if(e.getX()>=200&&e.getX()<=280&&e.getY()>=405&&e.getY()<=445
		    &&Play.lie){
		GamePlay.play.count =1;
		GamePlay.stuff = 1;
	    }
	    else if(e.getX()>=200&&e.getX()<=290&&e.getY()>=305&&e.getY()<=345){
		GamePlay.play.deselect();
		GamePlay.stuff = 1;
	    }
	    else{
		
		GamePlay.play.checkAll(e.getX(),e.getY());
	    }
	}
	if(GamePlay.state == 2){//settings page
	    if (e.getX()>=0&&e.getX()<=80&&e.getY()>=0&&e.getY()<=80){
		GamePlay.state =0;
		GamePlay.stuff = 1;
	    }
	    if(e.getX()>=GamePlay.myWidth/2-81&&e.getX()<=GamePlay.myWidth/2&&
	       e.getY()>=230&&e.getY()<=350){
		GamePlay.ID = 1;
		GamePlay.stuff = 1;
	    }
	    if(e.getX()>GamePlay.myWidth/2&&e.getX()<=GamePlay.myWidth/2+81&&
	       e.getY()>=230&&e.getY()<=350){
		GamePlay.ID=2;
		GamePlay.stuff = 1;
	    }
	    //levels:
	    if(e.getX()>420&&e.getX()<=620&&
	       e.getY()>=425&&e.getY()<=490){
		GamePlay.lvl = 1;
		//System.out.println(GamePlay.lvl);
	    }
	    if(e.getX()>420&&e.getX()<=620&&
	       e.getY()>=510&&e.getY()<=575){
		GamePlay.lvl = 2;
		//System.out.println(GamePlay.lvl);
	    }
	    if(e.getX()>420&&e.getX()<=620&&
	       e.getY()>=583&&e.getY()<=653){
		GamePlay.lvl = 3;
		//System.out.println(GamePlay.lvl);
	    }
	    
	}
	if(GamePlay.state == 0){//menu
	    if (e.getX()<=750&&e.getX()>=350&&e.getY()<=350&&e.getY()>=252){
		GamePlay.play = new Play();
		GamePlay.state = 1;
		GamePlay.stuff = 1;
	    } 
	    if (e.getX()<=750&&e.getX()>=350&&e.getY()<550&&e.getY()>=450){
		GamePlay.state = 2;
		GamePlay.stuff = 1;
	    }
	}
	//System.out.println(e.getX());
	//System.out.println(e.getY());
	
	
    }

    public void mouseMoved(MouseEvent e){
    }

    public void mousePressed(MouseEvent e){
    }



}

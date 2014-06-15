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
	//I think this goes here..
	//if the state == the settings one
	//then set profPic to the image that is currently in the boundaries
	if(GamePlay.state == 1){//game mode
	    //if on a specific card
	    GamePlay.play.checkAll(e.getX(),e.getY());
	    
	}
	if(GamePlay.state == 2){//settings page

	}
	if(GamePlay.state == 0){
	    if (e.getX()<=750&&e.getX()>=350&&e.getY()<=325&&e.getY()>=225){
		GamePlay.state = 1;
	    } 
	    if (e.getX()<=750&&e.getX()>=350&&e.getY()<525&&e.getY()>=425){
		GamePlay.state = 2;
	    }
	}
	
    }

    public void mouseMoved(MouseEvent e){
    }

    public void mousePressed(MouseEvent e){
    }



}

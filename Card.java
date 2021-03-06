import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;

/*****************************************************
 * class Card 
 * represents a single card in the deck/hand
 * loading of the image of card with value and suit from an external file
 *****************************************************/

public class Card extends Component implements Comparable<Card> {
    
    //INSTANCE VARIABLES
    private int intValue; //contains numerical value of card (J = 11, Q = 12, A = 1, 2 = 2, etc.)
    private String suit; //contains the suit of the card (ex: Hearts, Clover, Diamond, Spade)
    // private String faceValue; // 2-10, J, Q, K, A
    BufferedImage img,bck;
    private boolean faceup;
    private int mx,my,px,py;
    private boolean select;
    private boolean go;

    //CONSTRUCTOR - sets the intValue and suit
    public Card(int x, String s) {
        //if valid arguments
        if(x >= 1 && x <= 13)
            intValue = x;
        if(s.equalsIgnoreCase("Clover") || s.equalsIgnoreCase("Hearts") ||
           s.equalsIgnoreCase("Spade") || s.equalsIgnoreCase("Diamond"))
            suit = s;
	faceup = false; // initially they are all face down

	/*****************************************************
	Note: the code below displays the image of the card but only when it= the gif file is in the same file
        Still need to work on:
        display face down card or face up card
        if (faceup == false) {display face down card }
	should display face down card when...
        1. Part of deck (if we are showing the deck)
        2. Computer's cards
        3. After we have selected our card and moved it to middle (computer can't see it)
	*****************************************************/

	//	else {
	String filename = intValue + s.substring(0,1).toLowerCase() + ".gif";
	try {
	    img = ImageIO.read(new File("images/" + filename));
	    bck = ImageIO.read(new File("images/back.png"));
	}
	catch (IOException e){
	}
	//	}
	px = 0;
	py = 0;
	mx = px;
	my = py;
	select = false;
	go= false;
    }

    //public accessor to intValue
    public int getIntVal() {
        return intValue;
    }
    //public accessor to suit
    public String getSuit() {
        return suit;
    }
    //checks if two cards have equal numerical values
    public boolean equals(Card other) {
        return (other.getIntVal() == getIntVal());
    }
    
    //returns true only if suit + numerical values are equal
    public boolean isSame(Card other) {
        return (other.getIntVal() == getIntVal()) && (other.getSuit().equals(getSuit()));
    }

    public boolean selected(){
	return select;
    }
    
    public void select(){
	select =true;
    }
    
    public void unselect(){
	select = false;
    }

    public String toString(){
        String retS = "";
        retS = intValue + ", " + suit;
        return retS;
    }

    // public void draw(Graphics g){
    // }
    
    public void draw(Graphics g) {
	if(faceup){
	    g.drawImage(img, px, py, null);
	}else{
	    g.drawImage(bck,px,py,null);
	}
    }

    public void changeFace(){
	faceup = !faceup;
    }
    
    public void falseFace(){
	faceup = false;
    }

    public void trueFace(){
	faceup = true;
    }
    
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(50,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }

    public void setXCor(int val){
	px = val;
    }

    public boolean getGo(){
	return go;
    }

    public void resetGo(){
	go = false;
    }

    public void setYCor(int val){
	py = val;
    }

    public void reveal(Graphics g,int num,int check){
	trueFace();
	setXCor((GamePlay.myWidth/2+37)+num*75);
	draw(g);
	if(check == getIntVal()){
	    go = true;
	}
    }

    public int getXCor(){
	return px;
    }

    public int getYCor(){
	return py;
    }
  

    public boolean isBetween(float objeX, float objeY) {
	if ((px<= objeX && px+70>=objeX)) {
	    if ((py+25<= objeY && py+125 >=objeY)){
		return true;
	    }
	}return false;
    }

    public int compareTo(Card other){
	if (this.getIntVal() > other.getIntVal())
	    return 1;
	else if (this.getIntVal() == other.getIntVal())
	    return 0;
	else
	    return -1;
    }

  
} //end Card class

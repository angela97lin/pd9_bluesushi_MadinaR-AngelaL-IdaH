import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
/*=======================================
 Player Class
 -details what a player/user in this game 
 is capable of.
 ========================================*/
public class Player {

    //INSTANCE VARIABLE
    private Hand myHand;
    public static BufferedImage profPic;
    
    //CONSTRUCTOR: instantiate player with a hand
    public Player(){
	//myHand = new Hand(cards); // gets it from the Driver class
	myHand = new Hand();
    }

    //tentatively String
    public String makeMove(){
	String retStr = "";
	//UPDATING NEXT EXPECTED VALUE FOR CARD STACK AFTER PLAYER FINISHES MOVES
	if (Play.cs.expectedVal != 13)
	    Play.cs.expectedVal++; //after move, next expected val increases or loops around
	else 
	    Play.cs.expectedVal = 1;

	return retStr;
    }

    public void showHand(){
	for(int i = 0; i < myHand.size();i++){
	    myHand.getCard(i).trueFace();
	}
    }

    //ACCESSOR METHOD to the player's hand
    public Hand getHand(){
	return myHand;
    }

}

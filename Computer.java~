
//Similar to the Player class; However, everything is randomized.

import java.util.*;
import java.io.*;

public class Computer {

    private Hand hand;
    private ArrayList<String> goodEmotions;
    private ArrayList<String> badEmotions;
    private int trickery; //how good the computer will be at BS-ing
    private int gullibility; //how easily the computer can fall to someone else's BS
    public static int lvl; //Level of difficulty, 1-3 (1 = easy, 2 = medium, 3 = hard)
    
    /*
     * Constructor will set up the Computer's cards as well as level of
     * intelligence
     * The higher the level, the harder it will be to play against it.
     * You can pass values 1-3 into level, else the level will be set to 2
     * automatically.
     *
     * Trickery from 1-21    Easy 1-7, Medium 8-14, Hard 15-21
     * Gullibility from 1-21 Easy 1-7, Medium 8-14, Hard 15-21
     */
    public Computer(){
	lvl = 1;
	hand = new Hand();

	goodEmotions = new ArrayList<String>();
	badEmotions = new ArrayList<String>();
	goodEmotions.add("The Computer smiled.");
	goodEmotions.add("The Computer grinned.");
	goodEmotions.add("The Computer has a blank face.");
	goodEmotions.add("The Computer yawned.");
	goodEmotions.add("The Computer smirked.");
	goodEmotions.add("The Computer cackled.");
	goodEmotions.add("The Computer whistled.");

	badEmotions.add("The Computer's hands are shaking!");
	badEmotions.add("The Computer is looking down.");
	badEmotions.add("The Computer moaned.");
	badEmotions.add("The Computer is spacing out.");
	badEmotions.add("The Computer placed the cards down nervously.");
	badEmotions.add("The Computer giggled nervously.");
	badEmotions.add("The Computer cursed.");
    }
    
    public Computer(ArrayList<Card> cards, int lvl){
	hand = new Hand(cards);
        this.lvl = lvl;
	//is this necessary
	//sets stats based on lvl of the computer
        if(lvl == 1) {
            trickery = (int)(Math.random() * 6) + 1;
            gullibility = (int)(Math.random() * 6) + 1;
        } else if(lvl == 3) {
            trickery = (int)(Math.random() * 6) + 8;
            gullibility = (int)(Math.random() * 6) + 8;
        } else {
            trickery = (int)(Math.random() * 6) + 15;
            gullibility = (int)(Math.random() * 6) + 15;
        }
    }

    /*
     * The String returned by the makeMove() method will be the computer's
     * reactions to the move it just made.
     * This is where the emotions will be showcased. (Ex. "giggled nervously, etc.)
     *
     * makeMove() takes in one parameter, the numerical value of the card it
     * expects next. This is to allow computer to check to see if it has that
     * value.

     */
   
    //might change to void and instead simply have a popup box or label...
    public String makeMove() {
	Random r = new Random();
       	int nextVal = Play.cs.peek()+1; //represents the value that
        String retStr = "";//return string for emotions based on level and 
	int temp = r.nextInt(goodEmotions.size());
	int temp2 = r.nextInt(badEmotions.size());
	int temp3 = r.nextInt(4); //0,1,2,3 --> 25 percent chance of bluff
        if (hand.hasCard(Play.cs.expectedVal)) { //if the computer does have a card with
	    while (hand.hasCard(Play.cs.expectedVal)) {
		hand.remove(Play.cs.expectedVal);
	    }
	    if (lvl == 1){
		retStr = goodEmotions.get(temp);
	    }
	    if (lvl == 2){
		if (temp3 == 0){ //bluff
		    retStr = badEmotions.get(temp2);
		}
		else {
		    retStr = goodEmotions.get(temp);
		}
	    }
	    if (lvl == 3){ //amazing bluff --> 50% chance
		if (temp3 < 2){
		    retStr = badEmotions.get(temp2);
		}
		else {
		    retStr = goodEmotions.get(temp);
		}
	    }
	}
	else { //Computer does not have appropriate card
	   
	}

	//UPDATING NEXT EXPECTED VALUE FOR CARD STACK AFTER COMPUTER FINISHES MOVES
	if (Play.cs.expectedVal != 13)
	    Play.cs.expectedVal++; //after move, next expected val increases or loops around
	else 
	    Play.cs.expectedVal = 1;

        return retStr;
    }
	
    
           
    //public accessor to hand
    public Hand getHand() {
        return hand;
    }
}


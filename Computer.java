
//Similar to the Player class; However, everything is randomized.

import java.util.*;
import java.io.*;

public class Computer {

    private Hand hand;
    private int trickery; //how good the computer will be at BS-ing
    private int gullibility; //how easily the computer can fall to someone else's BS
    private int lvl; //Level of difficulty, 1-3 (1 = easy, 2 = medium, 3 = hard)
    
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
    public Computer(ArrayList<Cards> cards, int lvl){
        hand = new Hand(cards);
        this.lvl = lvl;
        if(lvl == 1) {
            trickery = (Math.random() * 6) + 1;
            gullibility = (Math.random() * 6) + 1;
        } else if(lvl == 3) {
            trickery = (Math.random() * 6) + 8;
            gullibility = (Math.random() * 6) + 8;
        } else {
            trickery = (Math.random() * 6) + 15;
            gullibility = (Math.random() * 6) + 15;
        }
    }

    /*
     * The String returned by the makeMove() method will be the computer's
     * reactions to the move it just made.
     * This is where the emotions will be showcased. (Ex. "giggled nervously, etc.)
     */
    public String makeMove() {
        String retStr = "";
        
        return retStr;
    }
                  
    //public accessor to hand
    public Hand getHand() {
            return hand;
    }
}


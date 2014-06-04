import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;


public class Card extends Rectangle{
    
    private int intValue; //contains numerical value of card (J = 11, Q = 12, A = 1, 2 = 2, etc.)
    private String suit; //contains the suit of the card (ex: Hearts, Clover, Diamond, Spade)
    //private String faceValue;


    //CONSTRUCTOR
    public Card(int x, String s) {
        //if valid arguments
        if(x >= 1 && x <= 13)
            intValue = x;
        if(s.equalsIgnoreCase("Clover") || s.equalsIgnoreCase("Hearts") ||
           s.equalsIgnoreCase("Spade") || s.equalsIgnoreCase("Diamond"))
            suit = s;
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

    public String toString(){
        String retS = "";
        retS = intValue + ", " + suit;
        return retS;
    }

    public void draw(Graphics g){
    }


}

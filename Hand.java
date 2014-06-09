/*
  This class will hold each individual's hand. 
  Will use ArrayList as back-end structure.
 */

import java.util.*;
import java.io.*;

public class Hand {

    private ArrayList<Card> hand = new ArrayList<Card>();
    
    public Hand(ArrayList<Card> h) {
        hand = h;
    }
    
    public ArrayList<Card> showHand() {
        return hand;
    }
    public int size(){
        return hand.size();
    }
   
    //Will check for a card with the same suit and int value in hand
    public boolean hasCard(Card x) {
        for(Card current : hand) {
            if (current.isSame(x))
                return true;
        }
        return false;
    }
    
    //Will check if a card with any suit is present in the hand that has
    //an int value of x
    public boolean hasCard(int x) {
        for(Card current : hand) {
            if (current.getIntVal() == x)
                return true;
        }
        return false;
    }
    
    //Will remove the card at the index of occurence of Card object c
    //and will return that card. (The return is for testing purposes)
    public Card remove(Card c) {
        hand.remove(hand.indexOf(c));
        return c;
    }
    
    public Card remove(int x) {
        int pos = 0;
        Card retCard = null;
        for(Card c: hand) {
            if (hand.get(pos).getIntVal() == x) {
                retCard = hand.get(pos);
                hand.remove(pos);
                break;
            } else
                pos++;
        }
        return retCard;
    }
    
    public void add(Card c){
	hand.add(c);
	sort();
    }
    //will implement a sort of our choosing to sort the cards :)
    public void sort() {
    }

   public String toString(){
	String retS = "(";
	for (int i = 0; i<hand.size(); i++){
	    retS = retS + " " + hand.get(i).toString()+"\n";
	}
	return retS;
    }
}

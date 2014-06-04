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
   
    //will implement a sort of our choosing to sort the cards :)
    public void sort() {
    }
}

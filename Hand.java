/*
  This class will hold each individual's hand. 
  Will use ArrayList as back-end structure.
 */

import java.util.*;
import java.io.*;

public class Hand{

    private ArrayList<Card> hand;// = new ArrayList<Card>();
    private ALHeap heap = new ALHeap();
    
    public Hand(){
	hand = new ArrayList<Card>();
	heap = new ALHeap();
    }

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
	//Play.cs.add(c);
        return c;
    }
    //removes first value
    public Card remove(){
	return hand.remove(0);
    }

    public Card remove(int x) {
        Card retCard = null;
        for (int i = 0; i<hand.size(); i++) {
            if (hand.get(i).getIntVal() == x) {
                retCard = hand.get(i);
                hand.remove(i);
                break;
            }
        }
	/*if (retCard != null){
	    Play.cs.add(retCard);
	    }*/
        return retCard;
    }
    
    public Card get(int x){
	Card retCard = null;
        for (int i = 0; i<hand.size(); i++) {
            if (hand.get(i).getIntVal() == x) {
                retCard = hand.get(i);
            }
	}
        return retCard;
    }

    public void add(Card c){
	hand.add(c);
    }

    public void sort() {
	//return ArrayList<Card> of sorted heap
	int len = hand.size();
	ArrayList<Card> sorted = new ArrayList<Card>();
	for (int i = 0; i < len; i++){
	    heap.add(getCard(i));
	}
	for (int i = 0; i < len; i++){
	    if (heap.isEmpty() != true){
		sorted.add(heap.getMin());
		heap.removeMin();
	    }
	}
	
	hand = sorted;
    }

    public Card getCard(int pos){
	return hand.get(pos);
    }

    

   public String toString(){
	String retS = "(";
	for (int i = 0; i<hand.size(); i++){
	    retS = retS + " " + hand.get(i).toString()+"\n";
	}
	return retS;
    }
}

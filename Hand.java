/*****************************************************
 * class Hand  --- hold each individual's hand in game
 * Implements ArrayList as back-end structure
 * Implements heapsort for sorting
 *****************************************************/
import java.util.*;
import java.io.*;

public class Hand {
    
    //--------------  INSTANCE VARIABLES  --------------
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ALHeap heap = new ALHeap();
    
    //--------------  CONSTRUCTOR  --------------
    public Hand(ArrayList<Card> h) {
        hand = h;
    }
    
    //--------------v  METHODS  v--------------
    
    /*****************************************************
     * ArrayList<Card> showHand()
     * displays card in this hand
     *****************************************************/
    public ArrayList<Card> showHand() {
        return hand;
    }

    /*****************************************************
     * int size()
     * returns size of this hand
     *****************************************************/
    public int size(){
        return hand.size();
    }
   
    /*****************************************************
     * boolean hadCard (Card)
     * @param x --  checks for a card with the same suit and int value in hand
     *****************************************************/
    public boolean hasCard(Card x) {
        for(Card current : hand) {
            if (current.isSame(x))
                return true;
        }
        return false;
    }

    /*****************************************************
     * int hasCard (int)
     * @param x -- checks if a card with any suit is present in the hand that 
     *             has an int value of x
     * returns a number from 0 - 4
     * 0 if no such card is present, and 4 if the player has 
     * all cards with int value of x
     *****************************************************/
    public int hasCard(int x) {
        int count = 0;
        for(Card current : hand) {
            if (current.getIntVal() == x)
                count++;
        }
        return count;
    }

    
    /*****************************************************
     * Card remove(Card)
     * @param c -- removes the card at the index of occurence of Card object c
     *              and returns that card. (The return is for testing purposes)
     *****************************************************/
    public Card remove(Card c) {
        hand.remove(hand.indexOf(c));
        return c;
    }


    /*****************************************************
     * Card remove(int)
     * @param x -- removes the card at the index x and returns that card. 
     *             (The return is for testing purposes)
     *****************************************************/
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

    /*****************************************************
     * void add(Card)
     * @param c -- add Card c to hand and sorts the hand
     *****************************************************/    
    public void add(Card c){
	hand.add(c);
	sort();
    }

    /*****************************************************
     * void add(Card)
     * @param c -- add Card c to hand and sorts the hand
     *****************************************************/
    public ArrayList<Card> sort() {
	//create the heap 
	for (Card i: hand){
	    heap.add(i);
	}
	
	//return ArrayList<Card> of sorted heap
	int len = hand.size();
	ArrayList<Card> sorted = new ArrayList<Card>();
	for (int i = 0; i < len; i++){
	    sorted.add(heap.getMin());
	}
	
	return sorted;
    }

    public String toString(){
	String retS = "(";
	for (int i = 0; i<hand.size(); i++){
	    retS = retS + " " + hand.get(i).toString()+"\n";
	}
	return retS;
    }

    public static void main (String[] args){

	ArrayList<Card> pile = new ArrayList<Card>();
	Hand h = new Hand(pile);
	h.add(new Card(2, "Clover"));
	h.add(new Card(10, "Hearts"));
	h.add(new Card(13, "Diamond"));
	h.add(new Card(9, "Clover"));
	h.add(new Card(1, "Hearts"));
	h.add(new Card(5, "Spade"));
	h.add(new Card(2, "Spade"));
        h.add(new Card(10, "Spade"));
	h.add(new Card(7, "Diamonds"));
	h.add(new Card(11, "Spade"));

	System.out.println(h);
    }
}

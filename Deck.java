import java.util.*;
import java.io.*;

public class Deck {

    private ArrayList<Card> deck;
    public static ArrayList<Card> half;
    public ArrayList<String> suits = new ArrayList<String>();

    public ArrayList<Integer> vals = new ArrayList<Integer>();

    public Deck(){
	suits.add("Spade");
	suits.add("Clover");
	suits.add("Hearts");
	suits.add("Diamond");
	for (int i = 0; i<=13; i++)
	    vals.add(i);
	
	deck = new ArrayList<Card>();
      	for (int i = 0; i < suits.size(); i++){
	    for (int j = 1; j < vals.size(); j++){
		Card temp = new Card(vals.get(j), suits.get(i));
		deck.add(temp);
	    }
	}
	
	Random r = new Random();
	for (int i = 0; i < deck.size()*2; i++){
	    int rand1 = r.nextInt(deck.size());
	    int rand2 = r.nextInt(deck.size());

	    swap(rand1,rand2);
	}
	
	half();
    }
    //Used in the shuffling of our deck; it swaps two cards in their positions
    public void swap(int index1, int index2){
	Card card1 = deck.get(index1);
	deck.set(index1,deck.get(index2));
	deck.set(index2, card1);
    }
    //draws one card from deck
    public Card drawFromDeck(){
	return deck.remove(0);
    }
    //builds our half ArrayList<Card> which contains half a deck of cards (since that is all we need for each game)
    public void half(){
	half = new ArrayList<Card>();
	for (int i = 0; i<26; i++){
	    half.add(deck.get(i));
	}
    }
    //returns size of the deck
    public int getSize(){
	return deck.size();
    }
    //for testing purposes
    //returns all elements of the deck
    public String toString(){
	String retS = "";
	for (int i = 0; i<deck.size(); i++){
	    retS = retS + " " + deck.get(i).toString()+"\n";
	}
	return retS;
    }
    //DEAL: 
    //takes an ArrayList (in our case, half), a Computer, and a Player as its parameters. Then, using the ArrayList specified in the parameters, it distributes 13 cards to each player.
    //Only used at the beginning of each game and takes advantage of how our Deck is already shuffled. Woohoo!
    public void deal(Computer comp, Player p){
	for (int i = 0; i<13; i++){
	    p.getHand().add(half.remove(half.size()-1));
	    comp.getHand().add(half.remove(half.size()-1));
	}
    }


    public static void main(String[] args){
        Deck d = new Deck();
	//System.out.println(d);
	ArrayList<Card> e = new ArrayList<Card>();
	Player p = new Player();
	//Computer c = new Computer(e,5);
	Computer c = new Computer();
	d.deal(c, p);
	System.out.println(p.getHand());
    }





}

import java.util.*;
import java.io.*;

public class Deck {

    private ArrayList<Card> deck;

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
	
    }

    public void swap(int index1, int index2){
	Card card1 = deck.get(index1);
	deck.set(index1,deck.get(index2));
	deck.set(index2, card1);
    }

    public Card drawFromDeck(){
	return deck.remove(deck.size()-1);
    }

    public int getSize(){
	return deck.size();
    }

    public String toString(){
	String retS = "";
	for (int i = 0; i<deck.size(); i++){
	    retS = retS + " " + deck.get(i).toString()+"\n";
	}
	return retS;
    }


    public static void main(String[] args){
        Deck d = new Deck();
	System.out.println(d);
    }





}

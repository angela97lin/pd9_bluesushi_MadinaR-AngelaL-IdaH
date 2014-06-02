<<<<<<< HEAD
public class Card {
    
    private int intValue;
    private String suit; 
    //private String faceValue;

    public Card(int x, String s) {
=======


public class Card {
    
    private int intValue; //contains numerical value of card (J = 11, Q = 12, A = 1, 2 = 2, etc.)
    private String suit; //contains the suit of the card (ex: Hearts, Clover, Diamond, Spade)
    //private String faceValue;


    //CONSTRUCTOR
    public Card(int x, String s) {
	//if valid arguments
>>>>>>> FETCH_HEAD
	if(x >= 1 && x <= 13)
	    intValue = x;
	if(s.equalsIgnoreCase("Clover") || s.equalsIgnoreCase("Hearts") ||
	   s.equalsIgnoreCase("Spade") || s.equalsIgnoreCase("Diamond"))
	    suit = s;
    }
<<<<<<< HEAD
    
    public int getIntVal() {
	return intValue;
    }

    public String getSuit() {
	return suit;
    }

    public boolean equals(Card other) {
	return other.getIntVal() == getIntVal();
    }

}
=======

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

}
>>>>>>> FETCH_HEAD
